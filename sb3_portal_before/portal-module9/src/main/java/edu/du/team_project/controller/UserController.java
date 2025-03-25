package edu.du.team_project.controller;
import org.springframework.ui.Model;
import edu.du.team_project.model.User;
import edu.du.team_project.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(produces = "text/html;charset=UTF-8")
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public String adminUserList(HttpSession session, Model model) {
        User currentUser = (User) session.getAttribute("loggedInUser");

        if (currentUser == null || !"ADMIN".equals(currentUser.getRole())) {
            return "redirect:/login"; // 또는 에러 페이지
        }

        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user-list"; // templates/admin/user-list.html
    }
    @GetMapping("/users/edit/{id}")
    public String editUserForm(@PathVariable Long id, HttpSession session, Model model) {
        User currentUser = (User) session.getAttribute("loggedInUser");
        if (currentUser == null || !"ADMIN".equals(currentUser.getRole())) {
            return "redirect:/login";
        }
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-edit";
    }

    @PostMapping("/users/update")
    public String updateUser(@ModelAttribute User user, HttpSession session) {
        User currentUser = (User) session.getAttribute("loggedInUser");
        if (currentUser == null || !"ADMIN".equals(currentUser.getRole())) {
            return "redirect:/login";
        }
        userService.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping("/users/delete")
    public String deleteUser(@RequestParam Long id, HttpSession session) {
        User currentUser = (User) session.getAttribute("loggedInUser");
        if (currentUser == null || !"ADMIN".equals(currentUser.getRole())) {
            return "redirect:/login";
        }
        userService.deleteUserAndAnonymizePosts(id);
        return "redirect:/users"; // 사용자 목록 페이지로 이동
    }

   //마이페이지 컨트롤러
    @GetMapping("/mypage")
    public String myPage(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/login";

        model.addAttribute("user", user);
        return "mypage";
    }

    @PostMapping("/mypage/update")
    public String updateMyInfo(@ModelAttribute User user, HttpSession session) {
        User currentUser = (User) session.getAttribute("loggedInUser");

        // 세션에 있는 사용자 ID 강제 설정 (보안)
        user.setId(currentUser.getId());
        userService.updateUser(user);
        user.setRole(currentUser.getRole()); // 👈 요게 핵심!
        // 세션 정보 갱신
        session.setAttribute("loggedInUser", userService.getUserById(user.getId()));

        return "redirect:/";
    }
    //비밀번호 변경
    @GetMapping("/mypage/password")
    public String showPasswordChangeForm(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/login";

        model.addAttribute("userId", user.getId());
        return "mypage-password";
    }

    @PostMapping("/mypage/password/update")
    public String updatePassword(@RequestParam Long userId,
                                 @RequestParam String currentPassword,
                                 @RequestParam String newPassword,
                                 HttpSession session,
                                 Model model) {
        User user = userService.getUserById(userId);
        User currentUser = (User) session.getAttribute("loggedInUser");
        // 기존 비밀번호 검증 (평문)
        if (!user.getPassword().equals(currentPassword)) {
            model.addAttribute("error", "현재 비밀번호가 일치하지 않습니다.");
            model.addAttribute("userId", userId);
            return "mypage-password";
        }

        // 변경
        user.setPassword(newPassword);
        currentUser.setPhoneNumber(currentUser.getPhoneNumber());
        currentUser.setEmail(currentUser.getRole());
        userService.updateUser(user);

        // 성공 후 리다이렉트
        return "redirect:mypage";
    }

}

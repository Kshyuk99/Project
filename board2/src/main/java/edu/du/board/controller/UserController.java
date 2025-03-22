package edu.du.board.controller;

import edu.du.board.model.User;
import edu.du.board.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String users(Model model) {
        model.addAttribute("users", this.userRepository.findAll());
        return "users/list";
    }

    @GetMapping("/new")
    public String newUserForm(Model model) {
        model.addAttribute("users", this.userRepository.findAll());
        return "users/form";
    }

    @PostMapping
    public String newUser(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/users";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        model.addAttribute("users", this.userRepository.findById(id ));
        return "users/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "redirect:/users";
    }

}

package edu.du.sb20250319.controller;

import edu.du.sb20250319.dto.UserDto;
import edu.du.sb20250319.entity.UserTb;
import edu.du.sb20250319.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/list")
public class ListController {

    @Autowired
    private ListService listService;

    @GetMapping
    public String list(Model model) {
        List<UserTb> user = listService.findAll();
        System.out.println(user);
        model.addAttribute("users", user);
        return "user/userlist";
    }

    @GetMapping("/edit/{no}")
    public String edit(@PathVariable int no, Model model) {
        UserDto user = listService.findAllByNo(no);
        model.addAttribute("userDto",user);
        return  "user/edit";
    }

    @GetMapping("/delete/{no}")
    public String delete(@PathVariable int no) {
        listService.deleteByNo(no);
        return  "redirect:/list";
    }
}

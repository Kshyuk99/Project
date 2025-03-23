package com.example.module4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/module4")
public class Module4Controller {

    @GetMapping({"", "/"})
    public String home(Model model) {
        model.addAttribute("message", "타임리프와 부트스트랩으로 만든 홈페이지에 오신 것을 환영합니다!");
        return "module4/index";
    }


    @GetMapping("/variables")
    public String variables(Model model) {
        model.addAttribute("name", "홍길동123");
        model.addAttribute("age", 27);
        model.addAttribute("isStudent", false);
        return "module4/variables";
    }

    @GetMapping("/iteration")
    public String iteration(Model model) {
        List<String> fruits = Arrays.asList("사과", "바나나", "오렌지", "포도", "키위");
        model.addAttribute("fruits", fruits);
        return "module4/iteration";
    }

    @GetMapping("/condition")
    public String condition(Model model) {
        model.addAttribute("score", 85);
        model.addAttribute("isPass", true);
        return "module4/condition";
    }

    @GetMapping("/layout")
    public String layout(Model model) {
        model.addAttribute("title", "레이아웃 예제");
        model.addAttribute("content", "이것은 레이아웃을 사용한 페이지입니다.");
        return "module4/layout";
    }
}
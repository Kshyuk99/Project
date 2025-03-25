package edu.du.team_project.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
    @GetMapping("/")
    public String home() {

        return "index"; // "WEB-INF/views/index.jsp"를 반환
    }

}
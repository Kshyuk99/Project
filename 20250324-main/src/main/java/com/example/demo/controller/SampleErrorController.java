package com.example.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleErrorController implements ErrorController {
//Spring Boot의 ErrorController 인터페이스를 구현하여,error URL을 통해 발생한 오류를 직접 처리할 수 있도록 함

    @RequestMapping("/error")  //error 경로로 들어오는 요청 처리
    public String handleError(HttpServletRequest request, Model model) {
        //HttpServletRequest 객체를 통해 요청 속성에서 에러 상태 코드를 가져옴.

        Object status = request.getAttribute("jakarta.servlet.error.status_code");
        //해당 속성을 가져와서 어떤 종류의 오류인지를 확인하는 코드

        if (status != null) {  //status 값이 null이 아니라면, int로 변환하여 오류 상태 코드를 확인
            int statusCode = Integer.parseInt(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "404";  // 404.jsp로 이동
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "500";  // 500.jsp로 이동
            }
        }

        return "error";  // 기본 오류 페이지 error.jsp로 이동
    }
}

package com.example.demo;  // 1️⃣ 패키지 선언

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 2️⃣ Spring Boot 애플리케이션임을 선언하는 애너테이션
@SpringBootApplication
public class DemoApplication {  // 3️⃣ Spring Boot의 메인 클래스
    public static void main(String[] args) {  // 4️⃣ 애플리케이션 실행 메서드
        SpringApplication.run(DemoApplication.class, args);  // 5️⃣ Spring Boot 실행
    }
}

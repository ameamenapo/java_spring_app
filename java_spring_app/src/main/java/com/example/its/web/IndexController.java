package com.example.its.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/test")
    public String test(Model model) {
        // test2.htmlにリダイレクトされるので、ここでは何もする必要はありません
    	String htmlContent = "<h1>test</h1>";
        model.addAttribute("htmlContent", htmlContent);
        return "test";
    }
    
    @GetMapping
    public String index() {
        return "index";
    }
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
}

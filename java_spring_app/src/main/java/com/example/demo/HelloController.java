package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	@GetMapping("/login")
	private String login() {
		return "login";
	}
	
	@GetMapping("/index")
	private String index() {
		return "index";
	}
	
	@GetMapping("/test")
	private String test(Model model) {
		model.addAttribute("message", "messageをmodelに設定");
		model.addAttribute("modelValue", "modelvalue");
		return "test";
	}

}

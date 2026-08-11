package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.GreetingService;

public class HelloWebController {
	
	private final GreetingService greetingService;
	
	public HelloWebController(GreetingService greetingService) {
		this.greetingService=greetingService;
	}
	
	@GetMapping("/hello")
	public String hello(@RequestParam(defaultValue ="World" )String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("message", greetingService.greet(name));
        return "home/hello";
    }
    
    @GetMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("message", greetingService.getWelcomeMessage());
        return "home/welcome";
    }
}

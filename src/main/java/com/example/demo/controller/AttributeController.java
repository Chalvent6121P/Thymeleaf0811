package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Book;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/attribute")
public class AttributeController {
    
	@GetMapping("/img")
	public String imageAttr(Model model) {
		String[] imgs= {"banana.png","grape.png","guava.png","orange.png"};
		int index=(int)(Math.random()*imgs.length);
		model.addAttribute("fruitImage", imgs[index]);
		return "showimage";
	}
	@GetMapping("/status")
	public String statusAttr(Model model) {
		model.addAttribute("isLogin", false);
		return "status";
	}
	@GetMapping("/role")
	public String roleAttr(Model model) {
		int v=(int)(Math.random()*3)+1;
		model.addAttribute("role", v==1 ? "admin" : (v==2 ? "user" : "NA"));
		return "role";
	}
	@GetMapping("/iterate")
	public String loopAttr(Model model) {
		List<Book> data=List.of(new Book(10,"UI",650),new Book(11,"UFO Mys.",750),
					new Book(12,"wUw",400));
		model.addAttribute("books", data);
		return "book";
	}
	
	@GetMapping("/session")
	public String sessionAttr(Model model,HttpServletRequest request) {
		request.setAttribute("user", "Jacky Chen");
		model.addAttribute("session", "Jacky Chen");
		return "session";
	}
	/*
	@GetMapping("/session")
	public String sessionAttr(HttpSession session) {
		session.setAttribute("user", "Jon Chu");				
		return "session";
	}
	*/
	//以上的方法對應的EL語法會是
	/*
	@GetMapping("/session")
	public String sessionAttr(Model model,HttpSession session) {
		session.setAttribute("user", "Tom Chu");
		//model.addAttribute("session", session);
		model.addAttribute("price", 19.9565);
		model.addAttribute("today", new java.util.Date());
		return "session";
	}
	@GetMapping("/href")
	public String sessionAttr(Model model) {
		model.addAttribute("userId", 100);
		return "hyperlink";
	}*/
}

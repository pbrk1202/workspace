package com.pbrk.pbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/index")
	public String index() {

		return "home.index";
	}
	
	@RequestMapping("/help")
	public String help() {
		
		return "home.help";
	}

}


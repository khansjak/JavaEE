package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
	@RequestMapping("/")
	public String showHome() {
		System.out.println("home");
		return "home";
	}
	
	@RequestMapping(value="sayName",method=RequestMethod.POST)
	public String readName(@RequestParam("fname") String firstname , ModelMap map) {
		map.addAttribute("firstname",firstname);
		
		return "profile";
		
	}
}

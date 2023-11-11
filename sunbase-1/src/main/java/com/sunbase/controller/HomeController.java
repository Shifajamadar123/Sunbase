package com.sunbase.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
	
	@GetMapping("/Assignment")
	public ModelAndView Assignment()
	{
		ModelAndView mv = new ModelAndView("Assignment");
		return mv;
		
	} 
	
}

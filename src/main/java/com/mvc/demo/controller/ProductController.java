package com.mvc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

	
	@RequestMapping("/")
	public String indexPage() {
		return "index";
	}
}

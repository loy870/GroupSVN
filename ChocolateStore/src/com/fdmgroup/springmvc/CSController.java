package com.fdmgroup.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CSController {

	@RequestMapping("/")
	public String goToHome() {
		return "csfrontPage";
	}
	
}
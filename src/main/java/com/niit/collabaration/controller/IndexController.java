package com.niit.collabaration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
@RequestMapping("/")
public String landingpage(){
	return "index";
}
	
}

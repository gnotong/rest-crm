package com.notgabs.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppRestController {

	@RequestMapping("/hello")
	public String hello() {
		return "hello Gabs";
	}
}

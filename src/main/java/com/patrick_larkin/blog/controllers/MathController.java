package com.patrick_larkin.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
	@GetMapping("/quickmath/increment/{num}")
	@ResponseBody
	public Long increment(@PathVariable Long num) {
		return num + 1;
	}

	@GetMapping("/quickmath/decrement/{num}")
	@ResponseBody
	public Long decrement(@PathVariable Long num) {
		return num - 1;
	}

	@GetMapping("/quickmath/addition/{num1}+{num2}")
	@ResponseBody
	public Long addition(@PathVariable Long num1, @PathVariable Long num2) {
		return num1 + num2;
	}
}

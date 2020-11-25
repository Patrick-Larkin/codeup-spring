package com.patrick_larkin.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
	@GetMapping("/")
	@ResponseBody
	public String home() {
		return "This is the landing page!!";
	}

	@GetMapping("/home")
	@ResponseBody
	public String welcome() {
		return "Welcome to the home page";
	}

	@GetMapping("/home/{name}")
	public String welcome(@PathVariable String name, Model model) {
		model.addAttribute("name", name);
		return "/home";
	}

	@GetMapping("/join")
	public String showJoinForm(Model model) {
		List<String> cohortNames = new ArrayList<>();
		cohortNames.add("Cobol");
		cohortNames.add("Draco");

		model.addAttribute("cohortNames", cohortNames);
		return "join";
	}

	@PostMapping("/join")
	public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
		model.addAttribute("cohort", "Welcome to " + cohort + "!");
		return "join";
	}
}



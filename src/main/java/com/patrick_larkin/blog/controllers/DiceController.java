package com.patrick_larkin.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DiceController {
	@GetMapping("/roll-dice")
		return "/dicegame";
	}

	@GetMapping("/roll-dice/n")
	public String showJoinForm(Model model) {

		return "join";
	}
}

package com.patrick_larkin.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class DiceController {

	@GetMapping("/roll-dice/{guess}")
	public String rollDice(@PathVariable int guess, Model model) {
		int dice = ThreadLocalRandom.current().nextInt(1, 6 + 1);
		model.addAttribute("guess", guess);
		model.addAttribute("dice", dice);
		model.addAttribute("isCorrectGuess", guess == dice);
		return "roll-dice";
	}

	@GetMapping("/roll-dice")
	public String showDiceGame() {
		return "/dicegame";
	}

	@PostMapping("/roll-dice")
	public String playDiceGame(@RequestParam(name = "roll") String roll, Model model) {
		model.addAttribute("roll", roll + "!");
		return "/dicegame";
	}
}

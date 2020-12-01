package com.patrick_larkin.blog.controllers;

import com.patrick_larkin.blog.Dao.AdRepository;
import com.patrick_larkin.blog.model.Ad;
import com.patrick_larkin.blog.model.Post;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class AdController {
	private final AdRepository adDao;

	public AdController(AdRepository adDao) {
		this.adDao = adDao;
	}

	@GetMapping ("/ads")
	public String index(Model viewModel) {
		viewModel.addAttribute("ads", adDao.findAll())
		return "/ads/index";
	}

	@GetMapping ("/ads")
	public String show(Model model) {
		List<Post> posts = new ArrayList<>();
		model.addAttribute("ads", adDao.findAll());
		return "/ads/show";
	}

	@GetMapping ("/ads/{id}")
	public String show(@PathVariable long id, Model model) {
		List<Post> posts = new ArrayList<>();
		Post post = new Post("Post " + id, "Some cool post");
		model.addAttribute("ads", adDao.findAll());
		return "/ads/show";
	}

	@GetMapping("/ads/create")
	public String showCreateAd() {
		return "/ads/create";
	}

	@PostMapping("/ads/create")
	@ResponseBody
	public String createAD(@RequestParam(name = "title") String title, @RequestParam(name = "description") String description) {
		Ad ad = new Ad(title, description);
		Ad dbad = adDao.save(ad);
		return "Created a new Ad with an id of: " + dbad.getId();
	}
}

/*	posts.add(new Post("Post 1", "cool stuff 1", "Selling some really cool stuff"));
		posts.add(new Post("Post 2", "cool stuff 2", "Selling some really cool stuff"));
		posts.add(new Post("Post 3", "cool stuff 3", "Selling some really cool stuff"));*/

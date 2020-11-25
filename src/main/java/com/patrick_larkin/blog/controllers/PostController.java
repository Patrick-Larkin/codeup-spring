package com.patrick_larkin.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

	@GetMapping("/posts")
	@ResponseBody
	public String index() {
		return "post index page";
	}

	@GetMapping("/posts/{id}")
	@ResponseBody
	public String show(@PathVariable String id) {
		return "View and individual post: " + id;
	}

	@GetMapping("/posts/create")
	@ResponseBody
	public String showCreatePost() {
		return "View the form for creating a post";
	}

	@PostMapping("/posts/create/{title}")
	@ResponseBody
	public String submitCreatePost(@PathVariable String title) {
		return "Post created: " + title;
	}
}

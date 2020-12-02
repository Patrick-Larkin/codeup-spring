package com.patrick_larkin.blog.controllers;

import com.patrick_larkin.blog.model.Ad;
import com.patrick_larkin.blog.repos.AdRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdController {

	private final AdRepository adDao;

	public AdController(AdRepository adDao){
		this.adDao = adDao;
	}

	@GetMapping("/ads")
	public String index(Model viewModel) {
		viewModel.addAttribute("ads", adDao.findAll());
		return "/ads/index";
	}

	@PostMapping("/ads")
	public String search(@RequestParam(name = "search") String term, Model viewModel){
		term = "%"+term+"%";
		List<Ad> dbAds = adDao.findAllByTitleIsLike(term);
		viewModel.addAttribute("ads", dbAds);
		return "/ads/index";
	}

	@GetMapping("/ads/{id}")
	public String show(@PathVariable long id, Model model){
		Ad ad = new Ad("Post " + id, "Some cool stuff " + id + ".");
		model.addAttribute("ad", ad);
		return "/ads/show";
	}

	@GetMapping("/ads/create")
	public String showCreateForm(){
		return "/ads/create";
	}

	@PostMapping("/ads/create")
	@ResponseBody
	public String createAd(
					@RequestParam(name = "title") String title,
					@RequestParam(name = "description") String description,
					@RequestParam(name = "price") String price,
					/*Todo: figure out how to implement array categories*/
					/*@RequestParam(name = "categories") List<Categories> categories*/

	){
		Ad ad = new Ad(title, description, price);
		Ad dbAd = adDao.save(ad);
		return "create a new Ad with the id: " + dbAd.getId();
	}
}
package com.patrick_larkin.blog.controllers;

import com.patrick_larkin.blog.models.Ad;
import com.patrick_larkin.blog.models.User;
import com.patrick_larkin.blog.repos.AdRepository;
import com.patrick_larkin.blog.repos.UserRepository;
import com.patrick_larkin.blog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdController {

	private final AdRepository adDao;
	private final UserRepository userDao;
	private final EmailService emailService;

	public AdController(AdRepository adDao, UserRepository userDao, EmailService emailService) {
		this.adDao = adDao;
		this.userDao = userDao;
		this.emailService = emailService;
	}

	/*Show all Ads*/
	@GetMapping("/ads")
	public String index(Model viewModel) {
		viewModel.addAttribute("ads", adDao.findAll());
		return "/ads/index";
	}

	/*Show Ads by Search "Title"*/
	@PostMapping("/ads")
	public String search(@RequestParam(name = "search") String term, Model viewModel){
		term = "%"+term+"%";
		List<Ad> dbAds = adDao.findAllByTitleIsLike(term);
		viewModel.addAttribute("ads", dbAds);
		return "/ads/index";
	}

	@GetMapping("/ads/{id}")
	public String show(@PathVariable long id, Model viewModel){
		viewModel.addAttribute("ad", adDao.getOne(id));
		return "/ads/show";
	}


	/*Show page for creating new ad*/
	/*Todo:
	   - Require user to sign in to access this page
		 - Put in necessary inputs for creation
	*/

	@GetMapping("/ads/create")
	public String showCreateForm(Model model) {
		model.addAttribute("ad", new Ad());
		return "ads/create";
	}

	/*Post */
	@PostMapping("/ads/create")
	public String createAd(@ModelAttribute Ad adToBeSaved){
		User userDb = userDao.getOne(1L);
		adToBeSaved.setUser(userDb);
		Ad dbAd = adDao.save(adToBeSaved);
		emailService.prepareAndSend(dbAd, "Ad has been created", "You can find it with the id of " + dbAd.getId());
		return "redirect:/ads/" + dbAd.getId();
	}

	@GetMapping("/ads/{id}/edit")
	public String showEditForm(@PathVariable long id, Model viewModel) {
		viewModel.addAttribute("ad", adDao.getOne(id));
		return "/ads/edit";
	}

	@PostMapping("/ads/{id}/edit")
	public String editAd(@ModelAttribute Ad editedAdToBeSaved){
		User userDb = userDao.getOne(1L);
		editedAdToBeSaved.setUser(userDb);
		Ad editedDbAd = adDao.save(editedAdToBeSaved);
		return "redirect:/ads/" + editedDbAd.getId();
	}

	@PostMapping("/ads/{id}/delete")
	public String deleteAd(@PathVariable long id){
		adDao.deleteById(id);
		return "redirect:/ads";
	}
}
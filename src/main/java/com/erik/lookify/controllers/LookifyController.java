package com.erik.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.erik.lookify.models.Song;
import com.erik.lookify.services.LookifyService;

@Controller
public class LookifyController {
	private final LookifyService lookService;
	public LookifyController(LookifyService lookService) {
		this.lookService = lookService;
	}
	@RequestMapping("/")
	public String intro() {
		return "/songs/home.jsp";
	}
	@GetMapping("/dashboard")
	public String allsongs(Model model) {
		List<Song> songs = lookService.allSongs();
		model.addAttribute("songs", songs);
		System.out.println(model);
		return "/songs/dashboard.jsp";
	}
	@PostMapping("/dashboard") //comes from songs/new
	public String songValidate(@Valid @ModelAttribute("songs") Song song, BindingResult result) {
		if(result.hasErrors()) {
			
			return "/songs/new.jsp";
		}
		else {
			lookService.createSong(song);
			return "redirect:/dashboard";
		}
	}
	@RequestMapping("/songs/{song_id}")
	public String showSong(Model model, @PathVariable("song_id") Long song_id) {
		Song song = lookService.findSong(song_id);
		if(song == null) {
			return "redirect:/dashboard";
		}
		else {
			model.addAttribute("song", song);
			return "/songs/song.jsp";
		}
	}
	@RequestMapping("/songs/new")
	public String newSong(Model model, @ModelAttribute("song") Song song) {	
		return "/songs/new.jsp";
	}
	@RequestMapping("/search/topTen")
	public String topTen(Model model) {
		List<Song> topSongs = lookService.topTen();
		model.addAttribute("top10", topSongs);
		return "/songs/topTen.jsp";
	}
	@GetMapping("/search/{query}")
	public String searchRender(Model model,  @PathVariable("query") String query) {
		List<Song> querySongs = lookService.artistSearch(query);
		model.addAttribute("this_query", querySongs);
		model.addAttribute("query_text", query);
		return "/songs/search.jsp";
	}
	@PostMapping("/search")
	public String searchPost(@RequestParam(value = "artist", required = false) String query) { //comes from dashboard
		return "redirect:/search/"+query;
	}
	@PostMapping("/delete/{song_id}")
	public String delete(@PathVariable("song_id") Long song_id) {
		lookService.deleteById(song_id);
		return "redirect:/dashboard";
	}
}

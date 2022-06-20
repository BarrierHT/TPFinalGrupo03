package ar.edu.unju.edm.tpfinalgrupo03.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.edm.tpfinalgrupo03.models.Movie;
import ar.edu.unju.edm.tpfinalgrupo03.relations.UserMovie;
import ar.edu.unju.edm.tpfinalgrupo03.services.IUserMovieService;

@Controller
public class MainController {

	private static final Log LOGGER = LogFactory.getLog(MainController.class);

	@Autowired
	IUserMovieService userMovieService;

	@GetMapping({ "/", "/index", "/home" })
	public String getIndex(Model model) {
		List<UserMovie> listUserMovies = userMovieService.getUserMovies();
		Integer userId = 1;
		// ToDo declare userId from auth

		List<UserMovie> listUserMovieMapped = new ArrayList<>();

		for (int i = 0; i < listUserMovies.size(); i++) {
			// Movie movie = listUserMovies.get(i).getMovie();
			Integer userIdStored = listUserMovies.get(i).getUser().getId();

			if (userIdStored == userId) {
				UserMovie userMovie = listUserMovies.get(i);
				listUserMovieMapped.add(userMovie);
			}

		}
		model.addAttribute("UserMovieList", listUserMovieMapped);
		model.addAttribute("userId", "1");
		return "/index";
	}
}

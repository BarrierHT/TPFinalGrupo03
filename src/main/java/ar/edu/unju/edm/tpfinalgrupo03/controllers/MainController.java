package ar.edu.unju.edm.tpfinalgrupo03.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
// import org.hibernate.annotations.common.util.impl.Log_.logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.edm.tpfinalgrupo03.models.Movie;
import ar.edu.unju.edm.tpfinalgrupo03.models.User;
import ar.edu.unju.edm.tpfinalgrupo03.relations.UserMovie;
import ar.edu.unju.edm.tpfinalgrupo03.services.IUserMovieService;
import ar.edu.unju.edm.tpfinalgrupo03.services.IUserService;

@Controller
public class MainController {

	private static final Log LOGGER = LogFactory.getLog(MainController.class);

	@Autowired
	IUserMovieService userMovieService;

	@Autowired
	IUserService userService;

	@GetMapping({ "/", "/index", "/home" })
	public String getIndex(Model model, Principal principal) {
		List<UserMovie> listUserMovies = userMovieService.getUserMovies();

		User currentUser = new User();

		try {
			currentUser = userService.getUserByIdCard(Integer.parseInt(principal.getName()));
			LOGGER.info(currentUser.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Integer userId = currentUser.getId();

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
		if (currentUser.getId() != null) {
			model.addAttribute("userId", userId);
			model.addAttribute("userRole", currentUser.getRole());
		}

		return "/index";
	}
}

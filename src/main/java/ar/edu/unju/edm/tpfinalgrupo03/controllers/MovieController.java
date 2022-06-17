package ar.edu.unju.edm.tpfinalgrupo03.controllers;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.tpfinalgrupo03.models.Movie;
import ar.edu.unju.edm.tpfinalgrupo03.services.IMovieService;

@Controller
public class MovieController {
    
    private static final Log LOGGER = LogFactory.getLog(MovieController.class);

    @Autowired
    IMovieService movieService;

    @GetMapping("/registerMovie")
    public ModelAndView addMovie() {
        ModelAndView view = new ModelAndView("/admin/edit-movie");
        Movie newMovie = new Movie();
        view.addObject("movie", newMovie);
        view.addObject("editing", false);
        view.addObject("errors", false);
        return view;
    }

    @PostMapping("/saveMovie")
    public String saveMovie(@Valid @ModelAttribute("movie") Movie incomingMovie, BindingResult result,
            Model model) {
        LOGGER.info("Saving Course");
        
        if (result.hasErrors()) {
            LOGGER.fatal("Validation error");
            model.addAttribute("movie", incomingMovie);
            model.addAttribute("editing", false);
            model.addAttribute("errors", true);
            return "/admin/edit-movie";
        }

        try {
            movieService.saveMovie(incomingMovie);
        } catch (Exception e) {
            LOGGER.error("The movie can't be saved");
            model.addAttribute("movie", incomingMovie);
            model.addAttribute("editing", false);
            model.addAttribute("errors", true);

            return "/admin/edit-movie";
        }

        model.addAttribute("editing", false);

        return "redirect:/index";
    }
}

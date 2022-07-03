package ar.edu.unju.edm.tpfinalgrupo03.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.unju.edm.tpfinalgrupo03.models.Movie;
import ar.edu.unju.edm.tpfinalgrupo03.models.User;
import ar.edu.unju.edm.tpfinalgrupo03.relations.UserMovie;
import ar.edu.unju.edm.tpfinalgrupo03.relations.UserMovieComment;
import ar.edu.unju.edm.tpfinalgrupo03.services.IMovieService;
import ar.edu.unju.edm.tpfinalgrupo03.services.IUserMovieCommentService;
import ar.edu.unju.edm.tpfinalgrupo03.services.IUserMovieService;
import ar.edu.unju.edm.tpfinalgrupo03.services.IUserService;

@Controller
public class UserMovieController {

    private static final Log LOGGER = LogFactory.getLog(UserMovieController.class);

    @Autowired
    IUserMovieService userMovieService;

    @Autowired
    IMovieService movieService;

    @Autowired
    IUserService userService;

    @Autowired
    IUserMovieCommentService userMovieCommentService;

    @PostMapping("/buy-tickets")
    public String buyTickets(@RequestParam Map<String, String> body) {
        Integer movieId = Integer.parseInt(body.get("movieId")); // get the id from the body
        Integer userId = Integer.parseInt(body.get("userId")); // get the id from the body

        LOGGER.info("id: " + movieId);
        LOGGER.info("id: " + userId);

        // ToDo
        try {
            List<UserMovie> listUserMovies = userMovieService.getUserMovies();
            // LOGGER.info(listUserMovies.size());
            for (int i = 0; i < listUserMovies.size(); i++) {
                Integer movieIdStored = listUserMovies.get(i).getMovie().getId();
                Integer userIdStored = listUserMovies.get(i).getUser().getId();
                LOGGER.info("movieId from db: " + movieIdStored);
                LOGGER.info("userId from db: " + userIdStored);
                if (movieIdStored == movieId && userId == userIdStored) {
                    LOGGER.info("Relation already exists");

                    Movie movie = movieService.getMovie(movieId);

                    LOGGER.info(movie.getTicketStock());

                    if (movie.getTicketStock() > 0) {
                        movie.setTicketStock(movie.getTicketStock() - 1);
                        movieService.saveMovie(movie);

                        UserMovie userMovie = listUserMovies.get(i);

                        // userMovie.setCreatedAt(LocalDate.now());
                        userMovie.setTickets(userMovie.getTickets() + 1);

                        userMovieService.saveUserMovie(userMovie);
                    }

                    return "redirect:/getMovies";
                }
            }
            UserMovie userMovie = new UserMovie();

            Movie movie = movieService.getMovie(movieId);
            userMovie.setMovie(movie);

            LOGGER.info(movie.getTitle() + " " + movie.getTicketStock());
            if (movie.getTicketStock() > 0) {
                movie.setTicketStock(movie.getTicketStock() - 1); // * Reduce ticket stock in 1
                LOGGER.info(movie.getTitle() + " " + movie.getTicketStock());

                movieService.saveMovie(movie);

                User user = userService.getUser(userId);
                userMovie.setUser(user);

                LOGGER.info(user.getName());

                userMovie.setCreatedAt(LocalDate.now());
                userMovie.setTickets(1);
                userMovie.setValoration(null);

                userMovieService.saveUserMovie(userMovie);

                LOGGER.info(user.getName());

            } else
                LOGGER.fatal("The user can't buy tickets");

        } catch (Exception e) {
            LOGGER.error("The user can't buy tickets");

        }
        return "redirect:/getMovies";
    }

    @PostMapping("/valoration-movie")
    public String valorateMovie(@RequestParam Map<String, String> body,
            @Valid UserMovie incomingValoration, BindingResult resulr, Model model) throws Exception {
        Integer movieId = Integer.parseInt(body.get("movieId"));
        Integer userId = Integer.parseInt(body.get("userId"));
        Integer valoration = Integer.parseInt(body.get("valoration"));

        LOGGER.info("movieId: " + movieId);
        LOGGER.info("userId: " + userId);

        if (resulr.hasErrors()) {
            LOGGER.fatal("Validation error");
            System.out.println(incomingValoration.getValoration());
            return "redirect:/getMovies";
        }

        try {
            List<UserMovie> listUserMovies = userMovieService.getUserMovies();
            for (int i = 0; i < listUserMovies.size(); i++) {
                Integer movieIdStored = listUserMovies.get(i).getMovie().getId();
                Integer userIdStored = listUserMovies.get(i).getUser().getId();
                LOGGER.info("movieId from db: " + movieIdStored);
                LOGGER.info("userId from db: " + userIdStored);
                if (movieIdStored == movieId && userId == userIdStored) {
                    LOGGER.info("Relation already exists");

                    UserMovie userMovie = listUserMovies.get(i);

                    userMovie.setValoration(valoration);
                    userMovieService.saveUserMovie(userMovie);

                    return "redirect:/getMovies";
                }
            }

            UserMovie userMovie = new UserMovie();

            Movie movie = movieService.getMovie(movieId);
            userMovie.setMovie(movie);

            User user = userService.getUser(userId);
            userMovie.setUser(user);

            userMovie.setCreatedAt(LocalDate.now());
            userMovie.setValoration(valoration);
            userMovieService.saveUserMovie(userMovie);

        } catch (Exception e) {
            LOGGER.error("The user can't valorate the movie");
        }
        return "redirect:/getMovies";
    }

    @PostMapping("/comment-movie")
    public String commentMovie(@RequestParam Map<String, String> body,
            @Valid UserMovieComment incomingComment, BindingResult resulr, Model model) {
        Integer movieId = Integer.parseInt(body.get("movieId"));
        Integer userId = Integer.parseInt(body.get("userId"));
        String comment = body.get("comment");

        LOGGER.info("id: " + movieId);
        LOGGER.info("id: " + userId);

        if (resulr.hasErrors()) {
            LOGGER.fatal("Validation error");
            System.out.println(incomingComment.getComment());
            return "redirect:/getMovies";
        }

        try {
            UserMovieComment userMovieComment = new UserMovieComment();

            Movie movie = movieService.getMovie(movieId);
            userMovieComment.setMovie(movie);

            User user = userService.getUser(userId);
            userMovieComment.setUser(user);

            userMovieComment.setComment(comment);

            userMovieComment.setCreatedAt(LocalDate.now());
            userMovieCommentService.saveUserMovieComment(userMovieComment);

        } catch (Exception e) {
            LOGGER.error("The user can't comment the movie");
            return "redirect:/getMovies";
        }
        return "redirect:/getMovies";
    }

    @PostMapping("/delete-comment")
    public String deleteComment(@RequestParam Map<String, String> body) {
        Integer commentId = Integer.parseInt(body.get("commentId"));
        // Integer userId = Integer.parseInt(body.get("userId"));
        // String comment = body.get("comment");
        LOGGER.info("id: " + commentId);
        try {
            userMovieCommentService.deleteUserMovieComment(commentId);
        } catch (Exception e) {
            LOGGER.error("The comment cant be deleted");
        }

        return "redirect:/getMovies";
    }
}

package ar.edu.unju.edm.tpfinalgrupo03.controllers;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unju.edm.tpfinalgrupo03.relations.UserMovie;
import ar.edu.unju.edm.tpfinalgrupo03.services.IUserMovieService;

@Controller
public class UserMovieController {

    private static final Log LOGGER = LogFactory.getLog(UserMovieController.class);

    @Autowired
    IUserMovieService userMovieService;

    @PostMapping("/buy-tickets")
    public String joinCourse(@RequestParam Map<String, String> body) {
        Integer movieId = Integer.parseInt(body.get("movieId")); // get the id from the body
        Integer userId = Integer.parseInt(body.get("userId")); // get the id from the body

        LOGGER.info("id: " + movieId);
        // ToDo
        try {
            // List<UserMovie> listUserCourse = userMovieService.getUserMovies();
            // for (int i = 0; i < listUserCourse.size(); i++) {
            // Integer courseIdStored = listUserCourse.get(i).getCourse().getId();
            // Integer userIdStored = listUserCourse.get(i).getUser().getId();
            // LOGGER.info("courseId from db: " + courseIdStored);
            // LOGGER.info("userId from db: " + userIdStored);
            // if (courseIdStored == courseId && userId == userIdStored) {
            // LOGGER.fatal("Relation already exists");
            // // ?Send a variable to the view and lock inscription button
            // // throw new Error("Relation already exists");
            // return "redirect:/index";
            // }
            // }
            // UserCourse userCourse = new UserCourse();

            // Course course = courseService.getCourse(courseId);
            // userCourse.setCourse(course);

            // User user = userService.getUser(userId);
            // userCourse.setUser(user);
            // // LOGGER.info(LocalDate.now());
            // userCourse.setInscriptionDate(LocalDate.now());
            // userCourseService.saveUserCourse(userCourse);
        } catch (Exception e) {
            LOGGER.error("The user can't buy tickets");

        }
        return "redirect:/index";
    }

}

package ar.edu.unju.edm.tpfinalgrupo03.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.tpfinalgrupo03.models.User;

@Controller
public class AuthController {

    private static final Log LOGGER = LogFactory.getLog(AuthController.class);

    @GetMapping("/login")
    public String getLogin() {
        return "/auth/login";
    }

    @GetMapping("/signup")
    public ModelAndView addUser() {
        ModelAndView view = new ModelAndView("/auth/signup");
        User newUser = new User();
        view.addObject("user", newUser);
        view.addObject("editing", false);
        view.addObject("errors", false);
        LOGGER.info("view: " + view);
        return view;
    }

}

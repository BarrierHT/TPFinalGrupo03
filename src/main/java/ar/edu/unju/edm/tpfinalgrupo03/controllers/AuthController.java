package ar.edu.unju.edm.tpfinalgrupo03.controllers;

import java.security.Principal;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.tpfinalgrupo03.models.User;

@Controller
public class AuthController {

    private static final Log LOGGER = LogFactory.getLog(AuthController.class);

    @Autowired
    MVCController mvcController;

    @GetMapping("/login")
    public String getLogin() {
        return "/auth/login";
    }

    @PostMapping("/login")
    public String postLogin(@RequestParam Map<String, String> body) {
        String password = body.get("password");
        Integer idCard = Integer.parseInt(body.get("idCard"));

        LOGGER.info(password);
        LOGGER.info(idCard);

        return "redirect:index";
    }

    @GetMapping("/signup")
    public ModelAndView addUser(Principal principal) {
        ModelAndView view = new ModelAndView("/auth/signup");

        User currentUser = new User();

        try {
            currentUser = mvcController.getCurrentUser(principal);
        } catch (Exception e) {
            // TODO: handle exception
        }
        User newUser = new User();
        view.addObject("user", newUser);
        view.addObject("editing", false);
        view.addObject("errors", false);
        if (currentUser.getId() != null) {
            view.addObject("userRole", currentUser.getRole());
        }

        LOGGER.info("view: " + view);
        return view;
    }

}

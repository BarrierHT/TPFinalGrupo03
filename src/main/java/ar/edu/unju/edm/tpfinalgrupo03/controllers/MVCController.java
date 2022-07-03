package ar.edu.unju.edm.tpfinalgrupo03.controllers;

import java.security.Principal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.edm.tpfinalgrupo03.models.User;
import ar.edu.unju.edm.tpfinalgrupo03.services.IUserService;

@Controller
public class MVCController {

    private static final Log LOGGER = LogFactory.getLog(MVCController.class);

    @Autowired
    IUserService userService;

    public User getCurrentUser(Principal principal) {
        // LOGGER.info(principal.getName());

        User user = new User();

        try {
            LOGGER.info(principal.getName());
            user = userService.getUserByIdCard(Integer.parseInt(principal.getName()));
            LOGGER.info(user.getName());
        } catch (Exception e) {
        }
        return user;
    }
}

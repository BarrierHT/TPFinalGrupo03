package ar.edu.unju.edm.tpfinalgrupo03.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String getLogin() {
        return "/auth/login";
    }

    // @GetMapping("/signup")
    // public String getSignup() {
    // return "/auth/signup";
    // }

}

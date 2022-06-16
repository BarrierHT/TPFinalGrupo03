package ar.edu.unju.edm.tpfinalgrupo03.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class MainController {

    @GetMapping({ "/", "/index", "/home" })
	public String getIndex() {
		return "index";
	}
}

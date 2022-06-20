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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.tpfinalgrupo03.models.User;
import ar.edu.unju.edm.tpfinalgrupo03.services.IUserService;

@Controller
public class UserController {

	private static final Log LOGGER = LogFactory.getLog(UserController.class);

	@Autowired
	IUserService userService;

	@PostMapping("/saveUser")
	public String saveUser(@Valid @ModelAttribute("user") User incomingUser, BindingResult result, Model model) {
		LOGGER.info("Saving User");
		if (result.hasErrors()) {
			LOGGER.fatal("Validation error");
			System.out.println(incomingUser.getPassword());
			model.addAttribute("user", incomingUser);
			model.addAttribute("editing", false);
			model.addAttribute("errors", true);
			return "/auth/signup";
		}
		try {
			userService.saveUser(incomingUser);
		} catch (Exception e) {
			LOGGER.error("The user can't be saved");
			model.addAttribute("errorForm", "Comprueba si tu DNI o correo electronico no fueron ingresados antes");
			model.addAttribute("user", incomingUser);
			model.addAttribute("editing", false);
			model.addAttribute("errors", true);
			return "/auth/signup";
		}
		model.addAttribute("editing", false);
		return "redirect:/index";
	}

	@GetMapping("/getUsers")
	public String getUsers(Model model) {
		model.addAttribute("UserList", userService.getUsers());
		return "/admin/getUsers";
	}

	@GetMapping("/editUser/{id}")
	public ModelAndView editUser(Model model, @PathVariable Integer id) {
		LOGGER.info("ID: " + id);
		User userFound = new User();
		try {
			userFound = userService.getUser(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView sendFoundUser = new ModelAndView("/auth/signup");
		sendFoundUser.addObject("user", userFound);
		sendFoundUser.addObject("editing", true);
		return sendFoundUser;
	}

	@PostMapping("/editUser")
	public String editUser(@Valid @ModelAttribute("user") User incomingUser, BindingResult result, Model model) {
		LOGGER.info("Editing User");
		LOGGER.info(incomingUser.getId());

		if (result.hasErrors()) {
			for (int i = 0; i < result.getFieldErrors().size(); i++) {
				String field = result.getFieldErrors().get(i).getField().trim();
				LOGGER.info("field: " + field);
				if (!field.equals("password") && !field.equals("idCard")) {
					LOGGER.info("field filtered: " + field);
					LOGGER.fatal("Validation error");
					LOGGER.fatal(result.getErrorCount());
					model.addAttribute("user", incomingUser);
					model.addAttribute("editing", true);
					model.addAttribute("errors", true);
					return "/auth/signup";
				}
			}
		}
		try {
			LOGGER.info(incomingUser.getId());
			userService.editUser(incomingUser);
		} catch (Exception e) {
			LOGGER.error("The user can't be edited");
			model.addAttribute("errors", true);
		}
		LOGGER.error("Size of list: " + userService.getUsers().size());
		return "redirect:/index";
	}

	@GetMapping("/deleteUser/{id}")
	public String deleteUser(Model model, @PathVariable Integer id) {
		try {
			userService.deleteUser(id);
		} catch (Exception e) {
			LOGGER.error("The user can't be deleted");
		}
		return "redirect:/index";
	}
}

package sfirat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome() {
		return "index";
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String mainPage() {
		return "index";
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contactPage(ModelMap model) {
		model.addAttribute("message", "Contact");
		return "contact";
	}
}
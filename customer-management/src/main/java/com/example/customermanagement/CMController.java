package com.example.customermanagement;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;

import lombok.*;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class CMController {


	@GetMapping
	public String getAction(@ModelAttribute("command") CMCommand command, 
							Model model, HttpServletRequest request) {

		return "hello";
	}

	@PostMapping
	public String postAction (@ModelAttribute("command") CMCommand command, 
							@RequestParam(value="action", required=true) String action,
							Model model, HttpServletRequest request) {

		log.info("Action: " + action);
		log.info("Command" + command);

		if (action.equals("Ping to DB")){
			model.addAttribute("message", "ping to db success!");
		}

		if (action.equals("Ping to Catalog-Cart")){
			model.addAttribute("message", "ping to Catalog-Cart success!");
		}
		
		return "hello";
	}

}

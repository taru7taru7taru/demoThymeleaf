package com.example.demo;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageableController {

	@Autowired
	private MessageSource messageSource;

	@RequestMapping("/paging")
	public String showPageableTable(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model, Locale locale, Pageable pageable) {
		
		return "fragment/ptable";
	}

}

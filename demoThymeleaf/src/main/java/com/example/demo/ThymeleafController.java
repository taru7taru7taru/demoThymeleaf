/**
 * タイムリームのお試し用コントローラ
 */
package com.example.demo;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * SpringBootのコントローラ.
 * Thymeleaf のお試し用
 * 
 * @author wata2wata
 *
 */
@Controller
public class ThymeleafController {

	@Autowired
	private MessageSource messageSource;

	@RequestMapping("/transport")
	public String transport(@RequestParam(name = "name", required = false, defaultValue = "noLogin") String name,
			Model model, Locale locale) {
		model.addAttribute("name", name);
		model.addAttribute("mainframeName", "defaultMainPage");
		
		return "main/aggregation";
	}
	
}

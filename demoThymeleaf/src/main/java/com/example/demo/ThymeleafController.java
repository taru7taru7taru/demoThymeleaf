/**
 * タイムリームのお試し用コントローラ
 * 参考サイト：https://www.thymeleaf.org/doc/tutorials/2.1/usingthymeleaf_ja.html#thymeleaf%E3%81%AE%E7%B4%B9%E4%BB%8B
 * 
 */
package com.example.demo;

import java.util.List;
import java.util.Locale;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
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
		
		Document node = getDocument();
		model.addAttribute("node", node);
			
		return "main/aggregation";
	}

	private Document getDocument() {
		
		Document newDoc = DocumentHelper.createDocument();
		Element newRoot = newDoc.addElement("root");
		newRoot.setText("rootText");
		newRoot.addAttribute("href", "");
		newRoot.addAttribute("target", "");
		
		//メソッドチェーンで追加する
		newRoot.addElement("link1").setText("link1text"); 
		//newRoot.element("link1").addAttribute("href", "http://www.google.co.jp/");
		newRoot.element("link1").addAttribute("href", "/Dummy1.html");
		newRoot.element("link1").addAttribute("target", "MainPage");
		
		//メソッドチェーンで追加する
		newRoot.addElement("link2").setText("link2text");
		newRoot.element("link2").addAttribute("href", "/Dummy2.html");
		newRoot.element("link2").addAttribute("target", "MainPage");

		System.out.println(newRoot.asXML() );

		return newDoc;
	}
	
}


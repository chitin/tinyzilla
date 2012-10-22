package com.stc.tinyzilla.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.stc.tinyzilla.service.BugServices;
import com.stc.tinyzilla.tinyzilla.model.factories.TinyzillaDataPoolFactory;
import com.stc.tinyzilla.tinyzilla.service.data.DataLayerTinyzilla;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	BugServices service;
	
	
	@RequestMapping(value = "/newBug")
	public ModelAndView newBug(@RequestParam String title) {
		service.createBug(title);
		ModelAndView mv = new ModelAndView("ok");
		mv.addObject("title", title);
		return mv;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! the client locale is "+ locale.toString());
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}

	@RequestMapping(value = "/foo", method = RequestMethod.GET)
	public String foo() {
		return "foo";
	}
	

}

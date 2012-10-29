package com.stc.tinyzilla.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.sql.DataSource;


import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.stc.tinyzilla.service.BugServices;
import com.stc.tinyzilla.tinyzilla.model.Bug;
import com.stc.tinyzilla.tinyzilla.service.data.DataLayerTinyzilla;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	BugServices service;
	
	@Autowired
	@Qualifier(value="mainDataSource")
	DataSource datasource;
	
	
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
	

	@RequestMapping(value = "/report", method = RequestMethod.GET)
	@Transactional
	public ModelAndView report() {
		ModelAndView mv = new ModelAndView("sampleReport");
//		List<Bug> ds = dataLayer.createQuery("from Bug").list();
//		mv.addObject("reportDataKey", new  JRBeanCollectionDataSource (ds));
		mv.addObject("reportDataKey", datasource);
		return mv;
	}

}

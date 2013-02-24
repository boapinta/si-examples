package org.krams.tutorial.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.krams.tutorial.service.CommerceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles request relating to records
 */
@Controller
@RequestMapping("/main")
public class MainController {

	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="commerceService")
	private CommerceService commerceService;
	
    @RequestMapping(value = "/records", method = RequestMethod.GET)
    public String getRecordsPage(Model model) {
    	logger.debug("Received request to show records page");
    
    	// Attach records to Model
    	model.addAttribute("records",  commerceService.getAll());
    	
    	// This will resolve to /WEB-INF/jsp/records.jsp
    	return "records";
	}
    
}

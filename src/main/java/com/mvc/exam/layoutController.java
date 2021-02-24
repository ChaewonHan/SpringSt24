package com.mvc.exam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class layoutController {
	
	@RequestMapping(value = "/layout.do", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView modelAndView) {
		 modelAndView.setViewName("layout");
		return modelAndView;
	}
		
}

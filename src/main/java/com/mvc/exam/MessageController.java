package com.mvc.exam;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MessageController {

	@RequestMapping(value = "/message.do", method = RequestMethod.GET)
	public ModelAndView message(ModelAndView modelAndView) {
		
		Date date = new Date();
		
		modelAndView.addObject("data1","ȫ�浿");
		modelAndView.addObject("data2",10);
		modelAndView.addObject("date",date);
		
		modelAndView.setViewName("message");
		
		return modelAndView;
	}
}

package com.mvc.exam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller // ������� ����� �Է� �޾� ���εǴ� �޼ҵ带 �����ϴ� Ŭ����, mappging value�� ��ġ�� �ȵȴ�.(method��)
public class IndexController {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class); // logger log ���
	
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView modelAndView) {
		// ModelAndView ������, view ��ġ�� �����ϴ� ��ü
		// Model �����͸� �����ϴ� ��ü
		logger.debug("index ����");
		
		modelAndView.addObject("myMessage","spring �׽�Ʈ"); // setAttribute�� ���
		modelAndView.setViewName("index");
		
		return modelAndView;
	}
	
	
}

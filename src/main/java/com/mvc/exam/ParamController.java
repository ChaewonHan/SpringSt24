package com.mvc.exam;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ParamController {
	@RequestMapping(value = "/param1.do", method = RequestMethod.GET)
	public ModelAndView param1(@RequestParam(value = "name", required = false, defaultValue = "empty") 
	String name, @RequestParam(value="age", defaultValue="0") int age, ModelAndView modelAndView) throws Exception{
		
		System.out.println("name: "+name);
		System.out.println("age: "+age);
		
		modelAndView.setViewName("param1link");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/param2.do", method = RequestMethod.GET)
	public ModelAndView param2(Goods goods, ModelAndView modelAndView) throws Exception{
		
		System.out.println("code: "+goods.getCode());
		System.out.println("name: "+goods.getName());
		System.out.println("price: "+goods.getPrice());
		System.out.println("color: "+goods.getColor());
		
		modelAndView.setViewName("form01");
		return modelAndView;
	}
	
	/*
	 * 오늘의 실습과제 장바구니번호 / 회원이름 / 상품코드 /가격 / 수량 / 입력날짜(오늘날짜) 에 대해 vo(getter/setter) 를
	 * 만들어서 실습2) 와같은 내용을 완성하시오
	 */
	@RequestMapping(value = "/param3.do", method = RequestMethod.GET)
	public ModelAndView param3 (Goods2 goods2, ModelAndView modelAndView) throws Exception{
		Date date = new Date();
		goods2.setDate(date);
		modelAndView.addObject("date",goods2.getDate()+"");
		
		System.out.println(goods2.getNum());
		System.out.println(goods2.getMemberName());
		System.out.println(goods2.getCode());
		System.out.println(goods2.getPrice());
		System.out.println(goods2.getNumber());
		System.out.println(goods2.getDate());
		
		modelAndView.setViewName("form2");
		return modelAndView;
	}
}

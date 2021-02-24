package com.mvcproject.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mvcproject.member.controller.model.dao.MemberDAO;
import com.mvcproject.member.controller.model.vo.Member;

@Controller
public class MemberController {
	
	@Autowired
	MemberDAO memberDao;
	
	@RequestMapping(value="memberList.do", method=RequestMethod.GET)
	public ModelAndView memberListService(ModelAndView modelAndView) throws Exception{
		
		List<Member> memberList = memberDao.selectMemberAll();
		
		for(int i=0; i < memberList.size(); i++) {
			System.out.println(i);
		}
		
	
		modelAndView.setViewName("member/memberList");
		
		return modelAndView;
	}
}

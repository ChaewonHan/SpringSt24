package com.mvcproject.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
		
		/*
		 * for(int i=0; i < memberList.size(); i++) { Member member = memberList.get(i);
		 * System.out.println(i + "name: "+ member.getName());
		 * System.out.println("email: "+member.getEmail()); }
		 */
		
		modelAndView.addObject("memberList",memberList);
		
		modelAndView.setViewName("member/memberList");
		
		return modelAndView;
	}
	@RequestMapping(value="memberView.do", method=RequestMethod.GET)
	// 데이터 하나만 가져올 때 주로 사용
	public String memberViewService(@RequestParam("id") String id,Model model) throws Exception{
		Member member = memberDao.selectMember(id);
		// modelAndView를 안 쓰고 그냥 model을 쓰면 값 저장만 한다.
		model.addAttribute("member", member);
		
		return "member/memberView"; // 어디로 갈지 리턴할면 문자열로 리턴한다.
	}
	
//	@GetMapping()으로 쓸 수 있음
	@RequestMapping(value="memberDel.do", method=RequestMethod.GET)
	public ModelAndView deleteMember(Member member, ModelAndView modelAndView) throws Exception {
		
		int cnt = memberDao.deleteMember(member);
		
		modelAndView.addObject("cnt", cnt);
		modelAndView.setViewName("member/memberDelComplete");
		
		return modelAndView;
	}
	
	@RequestMapping("memberInsertForm.do")
	public ModelAndView insertMemberForm(ModelAndView modelAndView) {
		modelAndView.setViewName("member/memberInsert");
		
		return modelAndView;
	}
	
	@RequestMapping(value="memberInsert.do", method=RequestMethod.POST)
	public ModelAndView insertMember(Member member, ModelAndView modelAndView) throws Exception{
		
		memberDao.insertMember(member);
		
		modelAndView.setViewName("member/memberJoinComplete");
		
		return modelAndView;
	}
	
	@RequestMapping("memberUpdateForm.do")
	public ModelAndView updateMemberForm(@RequestParam("member") Member member, ModelAndView modelAndView) {
		
		modelAndView.addObject("member",member);
		modelAndView.setViewName("member/memberUpdateForm");
		
		return modelAndView;
	}
	
	@RequestMapping(value="memberUpdate.do", method=RequestMethod.POST)
	public ModelAndView updateMember(Member member, ModelAndView modelAndView) throws Exception{
		
		int cnt = memberDao.updateMember(member);
		modelAndView.addObject("cnt", cnt);
		modelAndView.setViewName("member/memberUpdateComplete");
		
		return modelAndView;
	}
	
	/*
	 * @RequestMapping(value="memberIdCheck.do", method=RequestMethod.GET)
	 * 
	 * @ResponseBody public int idCheck(@RequestParam("id") String id) throws
	 * Exception{ System.out.println(id); int result = memberDao.idCheck(id);
	 * 
	 * return result; }
	 */
}

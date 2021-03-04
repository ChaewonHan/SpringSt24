package com.mvc.josnexam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JsonController {
	
	private static final Logger logger = LoggerFactory.getLogger(JsonController.class);   

	   @RequestMapping(value = "test1.do", method = RequestMethod.POST)
	   public void test1Method(Sample vo, HttpServletResponse response, HttpSession session) throws IOException {
	      response.setContentType("text/html; charset=utf-8");
	      // PrintWriter 객체를 생성하여 통신에 대한 응답 결과를 전달한다.
	      PrintWriter out = response.getWriter();

	      System.out.println("vo : " + vo);
	      if (vo.getName().equals("신사임당")) {
	         session.setAttribute("sample", vo);
	         out.append("ok");
	         out.flush();
	      } else {
	         out.append("fail");
	         out.flush();
	      }
	      out.close();
	   }
}

package com.mvc.josnexam;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	   
	   @RequestMapping(value = "test2.do", method=RequestMethod.POST)
	   @ResponseBody // 결과를 response 객체에 담아서 보내는 어노테이션
	   public String test2Method(HttpServletResponse response) throws IOException{
		   response.setContentType("application/json; charset=utf-8");
		   
		   JSONObject job = new JSONObject();
		   // Map 형식의 JSON 객체를 생성하여 출력할 값을 Key와 Value 형태로 담는다
		   job.put("no",123);
		   job.put("title", "test return json object");
		   
		   // 한글 전송 시 깨질 우려가 있으므로 URIEncoder로 UTF-8 방식의 인코딩을 처리한다
		   job.put("writer",URLEncoder.encode("홍길동","utf-8"));
		   job.put("content",URLEncoder.encode("json 객체를 뷰로 리턴하는 테스트","utf-8"));
		   
		   //JSONObject를 String 형태로 리턴한다.
		   return job.toJSONString();
		   
	   }
	   
	   @RequestMapping(value="test3.do", method=RequestMethod.POST)
	   public void test3Method(HttpServletResponse response) throws IOException{
	   logger.info("test3Method() run...");
	   //List를 json 배열로 만들어서, 뷰로 리턴 처리한다.
	   ArrayList<User> list = new ArrayList<User>();
	   list.add(new User("u1234", "p1234", "홍길동", 25, "h1234@kh.org"));
	   list.add(new User("u2345", "p2345", "박문수", 33, "p2345@kh.org"));
	   list.add(new User("u3456", "p3456", "장영실", 45, "j3456@kh.org"));

	   // 전송용 최종 json 객체
	   JSONObject sendJson = new JSONObject();
	   // JSONArray 객체를 생성하여 JSONObject 객체를 하나씩 담는다
	   JSONArray jarr = new JSONArray();

	   //list 를 jarr 에 저장 처리
	   for(User user : list){
	   //user 정보 저장할 json 객체 선언
	   JSONObject juser = new JSONObject();
	   juser.put("userId", user.getUserId());
	   juser.put("userPwd", user.getUserPwd());
	   juser.put("userName", URLEncoder.encode(user.getUserName(), "utf-8"));
	   juser.put("age", user.getAge());
	   juser.put("email", user.getEmail());
	   jarr.add(juser);
	   }
	   // 전송할 객체 배열을 JSONObject에 담아 한 번에 전달한다
	   sendJson.put("list", jarr);
	   response.setContentType("application/json; charset=utf-8");
	   PrintWriter out = response.getWriter();
	   out.println(sendJson.toJSONString());
	   out.flush();
	   out.close();
	  }
}

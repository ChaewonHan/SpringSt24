package com.mvcproject.member.controller.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvcproject.member.controller.model.vo.Member;

@Repository // Controller처럼 클래스를 자동으로 생성해서 동작하게 해준다
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public MemberDAO() {
	}
	
	public List<Member> selectMemberAll() throws Exception{
		List<Member> memberList = sqlSession.selectList("Member.selectMemberAll");
		return memberList;
	}
}

package com.store.member.Service;

import java.util.List;

import com.store.member.DAO.MemberDAO;
import com.store.member.Model.MemberVO;

public class MemberService {
	private MemberDAO dao;

	public MemberService() {
		dao = new MemberDAO();
	}

	public MemberVO getByMemberId(String memId) {
		return dao.findById(memId);
	}

	public MemberVO getByMemberName(String memName) {
		return dao.findByName(memName);
	}

	public List<MemberVO> getAll() {
		return dao.getAll();
	}
}


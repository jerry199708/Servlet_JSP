package com.store.member.DAO;

import java.util.List;

import com.store.member.Model.MemberVO;

public interface MemberDAO_interface {
	 public void insert(MemberVO memberVO);
     public void update(MemberVO memberVO);
     public void delete(Integer memberId);
     public MemberVO findById(String memId);
     public MemberVO findByName(String memName);
     public List<MemberVO> getAll();
}

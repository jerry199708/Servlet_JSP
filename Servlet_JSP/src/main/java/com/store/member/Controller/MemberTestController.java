package com.store.member.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.store.member.Service.MemberService;
import com.store.member.Model.MemberVO;

@WebServlet("/member/test")
public class MemberTestController extends HttpServlet {


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("big5");
		res.setContentType("text/html; charset=big5");
		PrintWriter out = res.getWriter();
		MemberService svc = new MemberService();
		MemberVO vo = svc.getByMemberId("1");
		MemberVO vo2 = svc.getByMemberName("¤Ú¶ë¶©¯Ç");
		Gson gson = new Gson();
		out.print(gson.toJson(vo));
		out.print(gson.toJson(vo2));
		
	}
}

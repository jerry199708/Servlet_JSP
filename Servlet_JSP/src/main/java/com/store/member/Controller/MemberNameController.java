package com.store.member.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.store.member.Service.MemberService;
import com.store.member.Model.MemberVO;

@WebServlet("/member/name")
public class MemberNameController extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("big5");
		res.setContentType("text/html; charset=big5");
		List<String> ErrorMsg = new ArrayList<String>();
		PrintWriter out = res.getWriter();
		String name = req.getParameter("memName");
		if (name == null || name.isEmpty()) {
			ErrorMsg.add("請輸入正確的會員名稱!!!!!");
		}
		MemberService svc = new MemberService();
		MemberVO vo = svc.getByMemberName(name);
		Gson gson = new Gson();
		out.print(gson.toJson(vo));
	}
}

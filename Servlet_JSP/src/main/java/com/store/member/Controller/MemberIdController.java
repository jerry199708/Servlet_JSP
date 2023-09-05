package com.store.member.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.member.Model.MemberVO;
import com.store.member.Service.MemberService;

@WebServlet("/member/id")
public class MemberIdController extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("big5");
		res.setContentType("text/html; charset=big5");
		
		Map<String, String> ErrorMsg = new HashMap<String, String>();
		req.setAttribute("ErrorMsg", ErrorMsg);

		String id = req.getParameter("memId");
		System.out.println("�z��J���s�� :" + id);
//		===============���u�s�����~�B�z===============
		if (id == null || id.isEmpty()) {
			System.out.println("��J�|���s��");
			ErrorMsg.put("memberId", "�|���s������ť�!");
			System.out.println("���L���~�T��: " + ErrorMsg.get("memberId"));
		}
		if(!ErrorMsg.isEmpty()) {
			RequestDispatcher failView = req.getRequestDispatcher("/member/select_page.jsp");
			failView.forward(req, res);
			return; //�{�����_
		}
//		===============�d�߷|�����===============
		MemberService svc = new MemberService();
		MemberVO vo = svc.getByMemberId(id);
		if(vo == null) {
			ErrorMsg.put("memberId", "�d�L����T");
			String url = "/member/select_page.jsp";
			RequestDispatcher failView = req.getRequestDispatcher(url);
			failView.forward(req, res);
			System.out.println("���L���~�T��: " + ErrorMsg.get("memberId"));
			return;
		}
		System.out.println("���L���~�T��: " + ErrorMsg.get("memberId"));
		
//		===============�N�d�ߨ쪺��Ʃ�Jrequest����̭�===============
		req.setAttribute("memVO", vo);
//		===============������Dispatcher���|�@�w�n�[�׽u ===============
		String url = "/member/listOneByIdMem.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url);
		successView.forward(req, res);
	}
}

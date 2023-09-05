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
		System.out.println("您輸入的編號 :" + id);
//		===============員工編號錯誤處理===============
		if (id == null || id.isEmpty()) {
			System.out.println("輸入會員編號");
			ErrorMsg.put("memberId", "會員編號不能空白!");
			System.out.println("有無錯誤訊息: " + ErrorMsg.get("memberId"));
		}
		if(!ErrorMsg.isEmpty()) {
			RequestDispatcher failView = req.getRequestDispatcher("/member/select_page.jsp");
			failView.forward(req, res);
			return; //程式中斷
		}
//		===============查詢會員資料===============
		MemberService svc = new MemberService();
		MemberVO vo = svc.getByMemberId(id);
		if(vo == null) {
			ErrorMsg.put("memberId", "查無此資訊");
			String url = "/member/select_page.jsp";
			RequestDispatcher failView = req.getRequestDispatcher(url);
			failView.forward(req, res);
			System.out.println("有無錯誤訊息: " + ErrorMsg.get("memberId"));
			return;
		}
		System.out.println("有無錯誤訊息: " + ErrorMsg.get("memberId"));
		
//		===============將查詢到的資料放入request物件裡面===============
		req.setAttribute("memVO", vo);
//		===============為什麼Dispatcher路徑一定要加斜線 ===============
		String url = "/member/listOneByIdMem.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url);
		successView.forward(req, res);
	}
}

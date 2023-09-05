package com.store.product.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.store.product.Model.ProductVO;

@WebServlet("/store/cart")
public class ProductCartController extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		HttpSession session = req.getSession();
		List<ProductVO> list = new ArrayList();
//		���o��J�ʪ����ӫ~
		ProductVO productVO = getProduct(req);
//		�C����J�@���ʪ����A�ƶq���|�W�[�@�� ???????
		productVO.setProQuantity(productVO.getProQuantity() + 1); 
		list.add(productVO);
		session.setAttribute("shopCart", list);
		System.out.println(session);
		for(ProductVO vo:(List<ProductVO>)session.getAttribute("shopCart")) {
			System.out.println("�Ϥ����}: " + vo.getProPic() + "\n"
								+"�W��: " + vo.getProName() + "\n"
								+"�ԭz: " + vo.getProDescript() + "\n"
								+"����: " + vo.getProPrice()
								);
			
		}
		RequestDispatcher successView = req.getRequestDispatcher("/store/index.jsp");
		successView.forward(req, res);
	}

	public ProductVO getProduct(HttpServletRequest req) {
		ProductVO vo = new ProductVO();
		vo.setProPic(req.getParameter("proPic"));
		vo.setProName(req.getParameter("proName"));
		vo.setProDescript(req.getParameter("proDescript"));
		vo.setProPrice(req.getParameter("proPrice"));
		vo.setProQuantity(0);
//		�ƶq���]�w
//		1.�e�ݴ��Ѽƶq�����
//		2.�z�L�I���ʪ�������
		return vo;
	}
}

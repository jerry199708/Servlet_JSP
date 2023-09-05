package shopcart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/shop/addProduct")
public class AddServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		ShopCart shopCart = (ShopCart) session.getAttribute("shopCart");
		//�P�@�x�ʪ���
		if (shopCart == null) {
			shopCart = new ShopCart();
		}
		System.out.println("�ʪ���: " + shopCart);
		Product product = getProduct(req);
		System.out.println("�s�W���ӫ~: " + product);
		shopCart.add(product);
		System.out.println("�`�ƶq: " + shopCart.getTotalQuantity());
		System.out.println("�`���B: " + shopCart.getTotalPrice());
		session.setAttribute("shopCart", shopCart);
		RequestDispatcher successView = req.getRequestDispatcher("/shop/shopCart.jsp");
		successView.forward(req, resp);
	}

	public Product getProduct(HttpServletRequest req) {
		String name = req.getParameter("name");
		String pic = req.getParameter("pic");
		System.out.println(pic);
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		int price = Integer.parseInt(req.getParameter("price"));
		Product p = new Product(name, pic, quantity, price);
		return p;
	}

}

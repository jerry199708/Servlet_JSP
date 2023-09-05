package shopcart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/shop/delOneProduct")
public class DeleteOneServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		HttpSession session = req.getSession();
		ShopCart shopCart = (ShopCart) session.getAttribute("shopCart");
		if (shopCart != null) {
			String name = req.getParameter("name");
			int totalQuantity = shopCart.getTotalQuantity();
			int totalPrice = shopCart.getTotalPrice();
			totalQuantity -= shopCart.getProMap().get(name).getQuantity();
			totalPrice -= shopCart.getProMap().get(name).getPrice() * shopCart.getProMap().get(name).getQuantity();
			System.out.println("總數:" + totalQuantity);
			System.out.println("總金額:" + totalPrice);
			
			//刪除後記得更改數量
			shopCart.setTotalQuantity(totalQuantity);
			shopCart.setTotalPrice(totalPrice);
			
			shopCart.getProMap().remove(name);
			System.out.println("Product in shopcart del success");
			RequestDispatcher successView = req.getRequestDispatcher("shopTable.jsp");
			successView.forward(req, resp);
		} else {
			System.out.println("Product in shopcart del fail");
		}
	}

}

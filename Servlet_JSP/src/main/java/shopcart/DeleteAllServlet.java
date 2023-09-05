package shopcart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/shop/delAllProduct")
public class DeleteAllServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		HttpSession session = req.getSession();
		ShopCart shopCart = (ShopCart) session.getAttribute("shopCart");
		if (shopCart != null) {
			shopCart.getProMap().clear();
			System.out.println("All shopcart del success");
			
			//刪除後記得更改數量
			shopCart.setTotalQuantity(0);
			shopCart.setTotalPrice(0);
			
			RequestDispatcher successView = req.getRequestDispatcher("shopTable.jsp");
			successView.forward(req, resp);
		}else {
			System.out.println("All shopcart del fail");
		}
	}

}

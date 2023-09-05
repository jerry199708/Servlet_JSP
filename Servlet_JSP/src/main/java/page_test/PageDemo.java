package page_test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.member.DAO.MemberDAO;
import com.store.member.Model.MemberVO;

@WebServlet("/member/page")
public class PageDemo extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		List<MemberVO> memLists = new ArrayList<MemberVO>();
		MemberDAO dao = new MemberDAO();
		System.out.println("test: " + dao.getAll());
		memLists = dao.getAll();

//		 每頁顯示幾筆數
		int itemCount = 3;
//		 選擇第幾頁
		int page = 1;
		System.out.println("總筆數: " + memLists.size());
//		 共有幾頁
		int pageCount = memLists.size() / itemCount;
//		 假設有餘數 , 將頁數 + 1
		if (memLists.size() % itemCount != 0) {
			pageCount++;
		}
		System.out.println("每頁幾筆: " + itemCount);
		System.out.println("總頁數: " + pageCount);
		System.out.println("現在在第幾頁: " + page);
//		 判斷是否有超出最大索引值
		int maxIndex = itemCount * page;
		if (maxIndex > memLists.size()) {
			maxIndex = memLists.size();
		}
		List pageResult = memLists.subList(itemCount * (page - 1), maxIndex);
		req.setAttribute("pageResult", pageResult);
		req.setAttribute("pageCount", pageCount);
		RequestDispatcher successView = req.getRequestDispatcher("memberPage.jsp");
		successView.forward(req, resp);
		
//		Gson gson = new Gson();
//		Object obj = gson.toJson(memLists.subList(itemCount * (page - 1), maxIndex));
//		out.print(obj);
	}

//	public static void main(String[] args) throws Exception {

//		List<PageMember> memLists = new ArrayList<PageMember>();
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/store?serverTimezone=Asia/Taipei",
//				"root", "password");
//		String sql = "SELECT * FROM member";
//		PreparedStatement psmt = con.prepareStatement(sql);
//		ResultSet rs = psmt.executeQuery();
//		while (rs.next()) {
//			PageMember member = new PageMember();
//			member.setEmail(rs.getString(1));
//			member.setPwd(rs.getString(2));
//			member.setName(rs.getString(3));
//			member.setPhone(rs.getString(4));
//			member.setId(rs.getInt(6));
//			memLists.add(member);
//		}
	// 每頁顯示幾筆數
//		int itemCount = 3;
	// 選擇第幾頁
//		int page = 1;
//		System.out.println("總筆數: " + memLists.size());
	// 共有幾頁
//		int pageCount = memLists.size() / itemCount;
	// 假設有餘數 , 將頁數 + 1
//		if (memLists.size() % itemCount != 0) {
//			pageCount++;
//		}
//		System.out.println("每頁幾筆: " + itemCount);
//		System.out.println("總頁數: " + pageCount);
//		System.out.println("現在在第幾頁: " + page);
	// 判斷是否有超出最大索引值
//		int maxIndex = itemCount * page;
//		if (maxIndex > memLists.size()) {
//			maxIndex = memLists.size();
//		}
//		System.out.println(memLists.subList(itemCount * (page - 1), maxIndex));
//	}
}

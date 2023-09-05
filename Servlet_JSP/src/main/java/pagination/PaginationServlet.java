package pagination;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.store.member.Model.MemberVO;
import com.store.member.Service.MemberService;

@WebServlet("/pagination/page")
public class PaginationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String valueCurrentPage =request.getParameter("currentPage");
		String valuePageSize = request.getParameter("pageSize");
		System.out.println("valueCurrentPage" + valueCurrentPage);
		Integer currentPage;
		Integer pageSize;
		// 假設使用者沒給條件為空
		if (valueCurrentPage == null || valueCurrentPage.isEmpty()) {
			currentPage = 1;
		} else
			currentPage = Integer.valueOf(valueCurrentPage);
		if (valuePageSize == null || valuePageSize.trim().isEmpty()) {
			pageSize = 1;
		} else
			pageSize = Integer.valueOf(valuePageSize);
		System.out.println("現在頁數:" + currentPage);
		System.out.println("每頁幾筆:" + pageSize);
		
		
		// DB拿資料
		MemberService service = new MemberService();
		List<MemberVO> lists = service.getAll();

		int totalList = lists.size();
		int totalPage = totalList / pageSize;
		if (totalList % pageSize != 0) {
			totalPage++;
		}
		System.out.println("總元素個數" + totalList);
		System.out.println("總頁數" + totalPage);
		System.out.println(getData(currentPage, pageSize, lists));
		request.setAttribute("pageLists", getData(currentPage, pageSize, lists));
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("currentPage", currentPage);
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		out.print(gson.toJson(getData(currentPage, pageSize, lists)));    
		RequestDispatcher successView = request.getRequestDispatcher("pagination.jsp");
		successView.forward(request, response);
	}

	public static List<MemberVO> getData(Integer currentPage, Integer pageSize, List<MemberVO> lists) {

		int startIndex = (currentPage - 1) * pageSize;
		int endIndex = currentPage * pageSize;
		try {
			return lists.subList(startIndex, endIndex);
		} catch (IndexOutOfBoundsException e) {
			return lists.subList(startIndex, lists.size());
		}
	}

//	測試專用
	public static void main(String[] args) {
		Integer currentPage = 1;
		Integer pageSize = 4;
		// 假設使用者沒給條件
		if (currentPage == null) {
			currentPage = 1;
		}
		if (pageSize == null) {
			pageSize = 3;
		}
		// DB
		List<MemberVO> lists = new ArrayList<MemberVO>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/store?serverTimezone=Asia/Taipei",
					"root", "password");
			PreparedStatement psmt = con.prepareStatement("SELECT * FROM MEMBER");
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				MemberVO m = new MemberVO();
				m.setEmail(rs.getString("email"));
				m.setPwd(rs.getString("pwd"));
				m.setName(rs.getString("name"));
				lists.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Test
//		List<Integer> lists = new ArrayList<Integer>();
//		for (int i = 1; i <= 100; i++) {
//			lists.add(i);
//		}
		int totalList = lists.size();
		int totalPage = totalList / pageSize;
		if (totalList % pageSize != 0) {
			totalPage++;
		}
		System.out.println("總頁數為: " + totalPage);
//		System.out.println(lists.subList(0, 3)); // 第一頁
//		System.out.println(lists.subList(3, 6)); // 第二頁
//		int startIndex = (currentPage - 1) * pageSize;
//		int endIndex = currentPage * pageSize;
		System.out.println("每頁顯示" + pageSize + "筆");
		System.out.println("目前第" + currentPage + "頁");
		System.out.println(getData(currentPage, pageSize, lists));
	}
}

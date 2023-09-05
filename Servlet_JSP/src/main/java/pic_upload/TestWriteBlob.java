package pic_upload;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//import util.Util;

public class TestWriteBlob {
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/store?serverTimezone=Asia/Taipei";
	public static final String USER = "root";
	public static final String PASSWORD = "password";
	
	
	private static final String SQL = "INSERT INTO MEMBER(EMAIL, PWD, NAME, PHONE, PIC, ID) VALUES (?, ?, ?, ?, ?, ?)";

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement psmt = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			psmt = con.prepareStatement(SQL);

			// 1. setBlob (JDBC 4.0 / JDK 6)
//			psmt.setString(1, "aaa@gmail.com");
//			psmt.setString(2, "aaa");
//			psmt.setString(3, "拜仁慕尼黑");
//			psmt.setString(4, "0911111111");
//			InputStream is = getPictureStream("items/FC_Bayern.png");
//			psmt.setBlob(5, is);
//			psmt.setInt(6, 1);
//			psmt.executeUpdate();
//			is.close();

			// 2. setBytes
			psmt.setString(1, "bbb@gmail.com");
			psmt.setString(2, "bbb");
			psmt.setString(3, "巴塞隆納");
			psmt.setString(4, "0922222222");
			byte[] pic = getPictureByteArray("items/FC_Barcelona.png");
			psmt.setBytes(5, pic);
			psmt.setInt(6, 2);
			psmt.executeUpdate();

//
			// 3. setBinaryStream
//			psmt.setInt(1, 3);
//			psmt.setString(2, "皇家馬德里");
//			InputStream is2 = getPictureStream("items/FC_Real_Madrid.png");
//			psmt.setBinaryStream(3, is2);
//			psmt.executeUpdate();
//			is2.close();

			System.out.println("新增成功");

		} catch (ClassNotFoundException ce) {
			System.out.println(ce);
		} catch (SQLException se) {
			System.out.println(se);
		} catch (IOException ie) {
			System.out.println(ie);
		} finally {
			// 依建立順序關閉資源 (越晚建立越早關閉)
			if (psmt != null) {
				try {
					psmt.close();
				} catch (SQLException se) {
					System.out.println(se);
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException se) {
					System.out.println(se);
				}
			}
		}
	}

	// 使用InputStream資料流方式
	public static InputStream getPictureStream(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		return fis;
	}

	// 使用byte[]方式
	public static byte[] getPictureByteArray(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		return buffer;
	}
}

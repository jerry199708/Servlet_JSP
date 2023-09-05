package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Db {
	public static void main(String[] args)  {
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/store?serverTimezone=Asia/Taipei", "root", "password");
				PreparedStatement psmt = con.prepareStatement("SELECT * FROM MEMBER");
				ResultSet rs = psmt.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getString("name"));
				}
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


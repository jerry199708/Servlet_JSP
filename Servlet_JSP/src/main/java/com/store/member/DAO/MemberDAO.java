package com.store.member.DAO;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.store.member.Model.MemberVO;

public class MemberDAO implements MemberDAO_interface {
	private static final String GET_ALL_STMT = "SELECT email, pwd, name, phone, pic, id FROM MEMBER order by id";
	private static final String GET_ONE_ID_STMT = "SELECT email, pwd, name, phone, pic, id FROM MEMBER WHERE id = ? order by id";
	private static final String GET_ONE_NAME_STMT = "SELECT email, pwd, name, phone, pic, id FROM MEMBER WHERE name = ? order by id";
	private static final String ADD_MEMBER_STMT = "INSERT INTO MEMBER(email, pwd, name, phone, pic) VALUES = (?, ?, ?, ?, ?)";
	private static DataSource ds = null;
	static {
		try {
//			JNDI的初始上下文
			Context ctx = new InitialContext();
//			取得設定資訊
//			根據設定資訊配置初始化環境
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/jerry");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(MemberVO memberVO) {
		try {
			Connection conn = ds.getConnection();
			PreparedStatement psmt = conn.prepareStatement(ADD_MEMBER_STMT);
			psmt.setString(1, memberVO.getEmail());
			psmt.setString(2, memberVO.getPwd());
			psmt.setString(3, memberVO.getName());
			psmt.setString(4, memberVO.getPhone());
			InputStream is = new ByteArrayInputStream(memberVO.getPic());
			psmt.setBlob(5, is);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(MemberVO memberVO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer memberId) {
		// TODO Auto-generated method stub

	}

	@Override
	public MemberVO findById(String memId) {
		MemberVO vo = null;
		try {
			Connection conn = ds.getConnection();
			PreparedStatement psmt = conn.prepareStatement(GET_ONE_ID_STMT);
			psmt.setString(1, memId);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new MemberVO();
				vo.setEmail(rs.getString(1));
				vo.setPwd(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setPhone(rs.getString(4));
				vo.setPic(rs.getBytes(5));
				vo.setId(rs.getInt(6));
			}
			return vo;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public MemberVO findByName(String memName) {
		Connection conn = null;
		PreparedStatement psmt = null;
		MemberVO vo = null;
		try {
			conn = ds.getConnection();
			psmt = conn.prepareStatement(GET_ONE_NAME_STMT);
			psmt.setString(1, memName);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new MemberVO();
				vo.setEmail(rs.getString(1));
				vo.setPwd(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setPhone(rs.getString(4));
				vo.setPic(rs.getBytes(5));
				vo.setId(rs.getInt(6));
			}
			return vo;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<MemberVO> getAll() {
		List<MemberVO> lists = new ArrayList();
		PreparedStatement psmt = null;
		MemberVO vo = null;
		try {
			Connection conn = ds.getConnection();
			psmt = conn.prepareStatement(GET_ALL_STMT);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new MemberVO();
				vo.setEmail(rs.getString(1));
				vo.setPwd(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setPhone(rs.getString(4));
//				vo.setPic(rs.getBytes(5));
				vo.setId(rs.getInt(6));
				lists.add(vo);
			}
			return lists;
		} catch (SQLException e) {
			e.printStackTrace();
			return lists;
		}
	}
}

  package com.capgemini.storemanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.storemanagement.dto.Users;
import com.capgemini.storemanagement.exception.SchemaManagementException;

public class AdminDAOImpl implements AdminDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Statement stmt = null;

	public List<String> loginAdmin(String userId, String password) {
		List<String> users = new ArrayList<String>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/storemanagement?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			String qry = "select * from users_info where userId ='" + userId + "' and password='" + password + "'";
			pstmt = con.prepareStatement(qry);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				users.add(rs.getString("userId"));
				users.add(rs.getString("password"));

			}
		} catch (Exception e) {
			e.getMessage();
		}

		return users;
	}

	public boolean addManufactur(Users user) {
		boolean isAdded = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/storemanagement?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			String qry = " insert into  users_info  values (?,?,?,?,?,?)";
			pstmt = con.prepareStatement(qry);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2,user.getEmail());
			pstmt.setString(3,user.getLocation());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getRole());
			pstmt.setString(6, user.getUserName());
			int r = pstmt.executeUpdate();
			System.out.println(r);

			if (r != 0) {
				isAdded = true;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return isAdded;
	}

	public boolean updateManufactur(String userId) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/storemanagement?user=root&password=root";
			Connection con = DriverManager.getConnection(dburl);

			String qry = "update users_info set role='manufacture' where userId='" + userId + "' ";
			pstmt = con.prepareStatement(qry);
			int i = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public boolean deleteManufactur(String userId) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/storemanagement?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			String qry = "delete from users_info where userId=?";
			pstmt = con.prepareStatement(qry);
			pstmt.setString(1, userId);
			pstmt.executeUpdate();
		} catch (Exception e) {

			e.getMessage();
		}
		return true;
	}

	public List<String> viewAllManufacturs(String role) {

		List<String> manufactures = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/storemanagement?user=root&password=root";
			Connection con = DriverManager.getConnection(dburl);
			String qry = "select * from users_info where role='" + role + "' ";
			pstmt=con.prepareStatement(qry);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				manufactures.add(rs.getString("userName"));
				manufactures.add(rs.getString("userId"));
				manufactures.add(rs.getString("email"));
				manufactures.add(rs.getString("location"));
				
			}
		} catch (Exception e) {

			e.getMessage();
		}

		return manufactures;

	}
}

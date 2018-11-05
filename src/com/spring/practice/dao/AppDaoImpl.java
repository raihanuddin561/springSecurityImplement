package com.spring.practice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.spring.practice.model.User;
import com.spring.practice.service.PasswordEncoder;

public class AppDaoImpl implements AppDao {
	private DataSource dataSource;
	
	
	public AppDaoImpl(DataSource dataSource) {
		
		this.dataSource = dataSource;
	}

	@Override
	public void addUser(User user) {
		String query1 = "insert into users(username,email,password,enabled) values(?,?,?,?)";
		String query2 = "insert into authorities(username,authority) values(?,?)";
		Connection conn;
		try {
			conn = dataSource.getConnection();
			PreparedStatement pst = conn.prepareStatement(query1);
			pst.setString(1,user.getUsername());
			pst.setString(2, user.getEmail());
			pst.setString(3, new PasswordEncoder().encoder(user.getPassword()));
			pst.setInt(4, 1);
			pst.execute();
			PreparedStatement pst2 = conn.prepareStatement(query2);
			pst2.setString(1, user.getUsername());
			pst2.setString(2, "ROLE_USER");
			pst2.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}

	}

	@Override
	public List<User> userList() {
		List<User> userList = new ArrayList<User>();
		String query = "select * from users where enabled = 1";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				User user = new User(rs.getInt("userid"),rs.getString("username"),rs.getString("email"),rs.getString("password"));
				userList.add(user);
			}
			return userList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}

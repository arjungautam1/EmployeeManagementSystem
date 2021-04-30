package com.login;

import java.sql.*;
public class LoginDao {
	
	String sql="select * from login where uname=? and pass=?";
	String url="jdbc:mysql://localhost:3306/emp_management_sys?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String username="root";
	String password="";
public boolean check(String uname,String pass) throws SQLException {
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1, uname);
		st.setString(2, pass);
		
		ResultSet rs=st.executeQuery();
		if(rs.next()) {
			return true;
		}
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	}
	
	
	return false;
}
}

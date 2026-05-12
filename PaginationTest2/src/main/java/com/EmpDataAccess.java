package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.Emp;
import com.EmpDataAccess;

public class EmpDataAccess {
	public static Connection getConnection() {
		Connection con = null;
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crudtestdb","root","root");
            
            
		} catch (Exception e) {
          System.out.println(e);
		}
		return con;
	}
	
	public static int save(Emp e) 
	{
		int status = 0;
		try {
			Connection con = EmpDataAccess.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into usertable(id,name,password,email,country) values(?,?,?,?,?)");
		    ps.setInt(1, e.getId() );
		    ps.setString(2, e.getName());
		    ps.setString(3, e.getPassword());
		    ps.setString(4, e.getEmail());
		    ps.setString(5, e.getCountry());
		    
		    status=ps.executeUpdate();
		    
		    con.close();
		} catch (Exception e1) {
			System.out.println(e1);
		}
		return status;
	}
		public static List<Emp> getRecords(int start, int pagelimit)
		{
			List<Emp> list = new ArrayList<Emp>();
			try {
				Connection con = EmpDataAccess.getConnection();
				PreparedStatement ps = con.prepareStatement("select * from usertable limit "+(start -1)+","+pagelimit);
				
				ResultSet rs = ps.executeQuery();
				
			    while(rs.next()) 
			    {
			    	Emp e = new Emp();
			    	e.setId(rs.getInt(1) );
				    e.setName(rs.getString(2));
				    e.setPassword(rs.getString(3));
				    e.setEmail(rs.getString(4));
				    e.setCountry(rs.getString(5));
				    
				    list.add(e);
			    }
			} catch (Exception e2) {
				System.out.println(e2);
			}
			return list;
		}
		
}

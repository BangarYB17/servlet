package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductAccess {
     private static final int product_id = 0;
	public static Connection getConnection() {
    	 Connection con =null;
    	 try {
    		 Class.forName("com.mysql.cj.jdbc.Driver");
    		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crudtestdb","root","root");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
     }
     
     public static int save(Product p) {
    	 int status =0;
    	 try {
			Connection con = ProductAccess.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into products(product_id,product_name,price,quality) values(?,?,?,?)");
			
			ps.setInt(1, p.getProduct_id());
			ps.setString(2, p.getProduct_name());
			ps.setFloat(3, p.getPrice());
			ps.setString(4, p.getQuality());
			
			status=ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
     }
		return status;
   }
     public static List<Product> getProducts(){
    	 
    	 List<Product> list = new ArrayList<Product>();
    	 
    	 try {
			Connection con = ProductAccess.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from products");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Product p = new Product();
				p.setProduct_id(rs.getInt(1));
				p.setProduct_name(rs.getString(2));
				p.setPrice(rs.getFloat(3));
				p.setQuality(rs.getString(4));
				
				list.add(p);
			}
		} catch (Exception e2) {
			System.out.println(e2);
		}
		return list;
     }
     public static int update(Product p) {
    	 int status=0;
    	 try {
			Connection con = ProductAccess.getConnection();
			PreparedStatement ps = con.prepareStatement("update products set product_name =?,price=?,quality=? where product_id = ?");
			
			ps.setString(1, p.getProduct_name());
			ps.setFloat(2, p.getPrice());
			ps.setString(3, p.getQuality());
			ps.setInt(4, p.getProduct_id());
			
			status = ps.executeUpdate();
			con.close();
		} catch (Exception e3) {
			System.out.println(e3);
		}
		return status;
     }
     public static Product getProductsById(int product_id) {
    	 Product p = new Product();
    	 try {
			Connection con = ProductAccess.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from products where product_id=?");
			ps.setInt(1, product_id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				p.setProduct_id(rs.getInt(1));
				p.setProduct_name(rs.getString(2));
				p.setPrice(rs.getFloat(3));
				p.setQuality(rs.getString(4));
			}
			
		} catch (Exception e4) {
			System.out.println(e4);
		}
		return p;
     }
     public static int delete(int id) {
    	 int status =0;
    	 try {
			Connection con = ProductAccess.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from products where product_id =?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
			con.close();
		} catch (Exception e5) {
			System.out.println(e5);
		}
		return status;
     }
}

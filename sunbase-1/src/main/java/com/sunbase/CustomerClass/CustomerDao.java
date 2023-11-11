package com.sunbase.CustomerClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
	private Connection con = null;

	public CustomerDao(Connection con) {
		this.con = con;
	}
	
	public boolean addCustomer(Customer u) {
		boolean flag = false;

		PreparedStatement ps = null;

		try {
			String s = "insert into customer(first_name, last_name, address, street, city, state, email, phone) values(?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(s);
			ps.setString(1, u.getFirst_name());
			ps.setString(2, u.getLast_name());
			ps.setString(3, u.getAddress());
			ps.setString(4, u.getStreet());
			ps.setString(5, u.getCity());
			ps.setString(6, u.getState());
			ps.setString(7, u.getEmail());
			ps.setString(8, u.getPhone());
			int n = ps.executeUpdate();
			if (n > 0) {
				flag = true;
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (this.con != null) {
					this.con.close();
				}
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return flag;
	}

	public boolean updateCustomer(Customer u) {
		boolean flag = false;

		PreparedStatement ps = null;

		try {
			String s = "update customer set first_name=? , last_name=? , address=? , street=? , city=?, state=?, email=?, phone=? where id=?";
			ps = con.prepareStatement(s);
			ps.setString(1, u.getFirst_name());
			ps.setString(2, u.getLast_name());
			ps.setString(3, u.getAddress());
			ps.setString(4, u.getStreet());
			ps.setString(5, u.getCity());
			ps.setString(6, u.getState());
			ps.setString(7, u.getEmail());
			ps.setString(8, u.getPhone());
			ps.setInt(9, u.getId());
			int n = ps.executeUpdate();
			if (n > 0) {
				flag = true;
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (this.con != null) {
					this.con.close();
				}
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return flag;
	}
	
	public boolean deleteCustomer(int id)
	{
		boolean flag = false;

		PreparedStatement ps = null;

		try {
			String s = "delete from customer where id=?";
			ps = con.prepareStatement(s);
			
			ps.setInt(1, id);
			int n = ps.executeUpdate();
			if (n > 0) {
				flag = true;
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (this.con != null) {
					this.con.close();
				}
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return flag;
	}
	
	public List<Customer> getCustomers()
	{
		List<Customer> l = new ArrayList<Customer>();

		PreparedStatement ps = null;

		try {
			String s = "select * from customer";
			ps = con.prepareStatement(s);
			ResultSet set=ps.executeQuery();
			while(set.next())
			{
				Customer c=new Customer();
				c.setId(set.getInt("id"));
				c.setFirst_name(set.getString("first_name"));
				c.setLast_name(set.getString("last_name"));
				c.setAddress(set.getString("address"));
				c.setEmail(set.getString("email"));
				c.setCity(set.getString("city"));
				c.setStreet(set.getString("street"));
				c.setState(set.getString("state"));
				c.setPhone(set.getString("phone"));
				l.add(c);
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (this.con != null) {
					this.con.close();
				}
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return l;
		
		
	}
	
	
	
}

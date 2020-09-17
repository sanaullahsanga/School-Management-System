package Model;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import Singleton.jdbc;

public class M_Teacher extends jdbc{
	public String name,cnic,Subject,education,contact,email,dob,address,Class_name,Section,gender;
	public M_Teacher()
	{
		name="";
		cnic="";
		Subject="";
		education="";
		contact="";
		email="";
		dob="";
		address="";
		Class_name="";
		Section="";
		gender="";
	}
	public void showprofile(String user)
	{
		String sql="select * from teacher_info where name=\""+user+"\"";
		try {
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				
				name=rs.getString("name");
					cnic=rs.getString("cnic");
					Subject=rs.getString("Subject");
					education=rs.getString("education");
					contact=rs.getString("contact");
					email=rs.getString("email");
					dob=rs.getString("dob");
					address=rs.getString("address");
					Class_name=rs.getString("Class_name");
					Section=rs.getString("Section");
					gender=rs.getString("gender");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String name()
	{
		return name;
	}
	public String cnic()
	{
		return cnic;
	}
	public String Subject()
	{
		return Subject;
	}
	public String education()
	{
		return education;
	}
	public String contact()
	{
		return contact;
	}
	public String email()
	{
		return email;
	}
	public String dob()
	{
		return dob;
	}
	public String address()
	{
		return address;
	}
	public String Class_name()
	{
		return Class_name;
	}
	public String Section()
	{
		return Section;
	}
	public String gender()
	{
		return gender;
	}
	
}

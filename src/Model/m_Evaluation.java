package Model;

import java.awt.List;
import java.beans.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Singleton.jdbc;

public class m_Evaluation extends jdbc {
	int ids;
	String name,date,subject,marks;
	String c_id;
	String user,class_name,section;
	public m_Evaluation()
	{
		ids=0;
		name="";
		date="";
		subject="";
		marks="";
		c_id="";
		user="";
		class_name="";
		section="";
	}
	public void teacherinfo()
	{
		String sql="select Class_name,Section from teacher_info where name=\""+user+"\"";
		java.sql.Statement s;
		try {
			s = conn.createStatement();
			ResultSet r=s.executeQuery(sql);
			 while(r.next())
		  	  {
		  		  class_name=r.getString("Class_name");
		  		  section=r.getString("Section");
		  	  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	  
  	 
	}
	public void set_mid(String user,String Date,int id,String name,String subject,String marks)
	{
		this.user=user;
		this.date=Date;
		this.ids=id;
		this.name=name;
		this.subject=subject;
		this.marks=marks;
		
	}
	public void get_mid()
	{
		teacherinfo();
		if(subject.equals("Urdu"))
		{
			c_id = "1";
		}
		else if(subject.equals("English"))
		{
			c_id = "2";
		}
		else if(subject.equals("Maths"))
		{
			c_id = "3";
		}
		else if(subject.equals("Quran"))
		{
			c_id = "4";
		}
		else if(subject.equals("Islamiat"))
		{
			c_id = "5";
		}
		else if(subject.equals("Pak-Study"))
		{
			c_id = "6";
		}
		else if(subject.equals("Science"))
		{
			c_id = "7";
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Invalid Subject You Choose");
		}
		String sql="SELECT c_a_s_id,c_id FROM course_along_std WHERE s_id=\""+ids+  "\" AND c_id=\""+c_id+"\" AND section=\""+section+"\" AND class_name= \""+class_name+"\"";
		System.out.println(sql);
		try {
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				String casid=rs.getString("c_a_s_id");
				String subject_id=rs.getString("c_id");
				String exam="Mid";
				//if(subject_id.equals("c_id")){
				String sql1="insert into exam_std_sem1 values(\""+casid+"\",\""+exam+"\",\""+subject+"\",\""+date+"\",\""+marks+"\",\""+100+"\")";
				System.out.println(sql1);
				stmt.executeUpdate(sql1);
				JOptionPane.showMessageDialog(null, "Updated");}
			//}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void set_final(String user,String Date,int id,String name,String subject,String marks)
	{
		this.user=user;
		this.date=Date;
		this.ids=id;
		this.name=name;
		this.subject=subject;
		this.marks=marks;
		
	}
	public void get_final()
	{
		teacherinfo();
		if(subject.equals("Urdu"))
		{
			c_id = "1";
		}
		else if(subject.equals("English"))
		{
			c_id = "2";
		}
		else if(subject.equals("Maths"))
		{
			c_id = "3";
		}
		else if(subject.equals("Quran"))
		{
			c_id = "4";
		}
		else if(subject.equals("Islamiat"))
		{
			c_id = "5";
		}
		else if(subject.equals("Pak-Study"))
		{
			c_id = "6";
		}
		else if(subject.equals("Science"))
		{
			c_id = "7";
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Invalid Subject You Choose");
		}
		String sql="SELECT c_a_s_id,c_id FROM course_along_std WHERE s_id=\""+ids+  "\" AND c_id=\""+c_id+"\" AND section=\""+section+"\" AND class_name= \""+class_name+"\"";
		System.out.println(sql);
		try {
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				String casid=rs.getString("c_a_s_id");
				String subject_id=rs.getString("c_id");
				String exam="Final";
				//if(subject_id.equals("c_id")){
				String sql1="insert into exam_std_sem1 values(\""+casid+"\",\""+exam+"\",\""+subject+"\",\""+date+"\",\""+marks+"\",\""+100+"\")";
				System.out.println(sql1);
				stmt.executeUpdate(sql1);
				JOptionPane.showMessageDialog(null, "Updated");}
			//}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

package Model;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Singleton.jdbc;

public class M_Record extends jdbc {
	int ids;
	boolean check = false;
	String name,dob,address,nationality,religion,gender,f_name,f_contact,f_cnic;
	String cnic,education,subject,contact,email,class_name,section;
	ResultSet r1=null;
	public M_Record()
	{
		ids=0;
		name="";
		dob="";
		address="";
		nationality="";
		religion="";
		gender="";
		f_name="";
		f_contact="";
		f_cnic="";
		cnic="";
		education="";
		subject="";
		contact="";
		email="";
		class_name="";
		section="";
	}
	public void set_update_stu(int data1,String data2,String data3,String data4,String data5,String data6,String data7,String data8,String data9,String data10)
	{
		this.ids=data1;
		this.name=data2;
		this.dob=data3;
		this.address=data4;
		this.nationality=data5;
		this.religion=data6;
		this.gender=data7;
		this.f_name=data8;
		this.f_cnic=data9;
		this.f_contact=data10;
	}
	public void get_update_stu()
	{
		try {
			
		    String sql1 = "select * from  student_info s join guardian_info g where s.s_id=g.s_id ;";//where user_name=\""+Name+  "\" and \""+Pass+"\"";
			
			
				System.out.println(sql1);
				
						try {
							rs = stmt.executeQuery(sql1);
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}			
						try {
							while(rs.next()){
								 int id =rs.getInt("s_id");
							     //String uname  = rs.getString("User_name");
							     //String passw = rs.getString("Password");
						    	 
							     if(id ==ids )
							     {
							    	 
							    	 String sql0="UPDATE student_info SET s_name = \""+name+  "\" ,s_dob= \""+dob+"\",s_address = \""+address+  "\" ,nationality = \""+nationality+  "\" ,religion = \""+religion+  "\" ,s_gender = \""+gender+  "\"  where s_id= \""+id+"\"";
							    	 String sql2="UPDATE guardian_info SET father_name = \""+f_name+  "\" ,father_cnic= \""+f_cnic+"\",father_contact = \""+f_contact+  "\"   where s_id= \""+id+"\"";
							    	 System.out.println(sql0);
							    	 stmt.executeUpdate(sql0);
							    	 System.out.println(sql2);
							    	 stmt.executeUpdate(sql2);
							    	 JOptionPane.showMessageDialog(null, "Successfully Updated");
							    	 check = true;
							    	break;
							     }
							       
					}
							conn.close();
							rs.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void set_update_tea(int data1,String data2,String data3,String data4,String data5,String data6,String data7,String data8,String data9,String data10,String data11,String data12)
	{
		this.ids=data1;
		this.name=data2;
		this.cnic=data3;
		this.education=data4;
		this.subject=data5;
		this.contact=data6;
		this.email=data7;
		this.dob=data8;
		this.gender=data9;
		this.address=data10;
		this.class_name=data11;
		this.section=data12;
	}
	public void get_update_tea()
	{
		try {
			
		    String sql1 = "select * from  teacher_info  ;";//where user_name=\""+Name+  "\" and \""+Pass+"\"";
			
			
				System.out.println(sql1);
				
						try {
							rs = stmt.executeQuery(sql1);
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}			
						try {
							while(rs.next()){
								 int id =rs.getInt("t_id");
							     //String uname  = rs.getString("User_name");
							     //String passw = rs.getString("Password");
						    	 
							     if(id ==ids )
							     {
							    	 
							    	 String sql0="UPDATE teacher_info SET name = \""+name+  "\" ,cnic= \""+cnic+"\",Subject = \""+subject+  "\" ,education = \""+education+  "\" ,contact = \""+contact+  "\" ,email = \""+email+  "\",dob = \""+dob+  "\" ,address = \""+address+  "\" ,Class_name = \""+class_name+  "\" ,Section = \""+section+  "\",gender = \""+gender+  "\"  where t_id= \""+id+"\"";
							    	 System.out.println(sql0);
							    	 stmt.executeUpdate(sql0);
							    	 JOptionPane.showMessageDialog(null, "Successfully Updated");
							    	 check = true;
							    	break;
							     }
							       
					}
							conn.close();
							rs.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

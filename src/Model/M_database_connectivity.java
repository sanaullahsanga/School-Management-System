package Model;

import java.awt.HeadlessException;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import Singleton.jdbc;
import View.Admin;
import View.Registration;

public class M_database_connectivity extends jdbc {
	   public String un;
	   public String pass;
		String Ltype="";
		boolean check = false;
		int ids;
		String Name ;
		String Pass ;
		String F_Name;
		String F_Cnic;
		String F_Contact;
		String Cnic;
		String C_no;
		String D_o_b;
		String Adress;
		String Nationality;
		String Gender;
		String Email;
		String Class_Name;
		String Section;
		String year;
		String Subject;
		String Education;
	    String type;
	    String Religion;
	    String Date;
	    static int loginid;
	    String uname;
	public M_database_connectivity(){
		
		un = "";
		pass =  "";
		ids=0;
		 Name = "";
		 Pass = "";
		 F_Name = "";
		 F_Cnic = "";
		 F_Contact = "";
		 Cnic = "";
		 C_no = "";
		 D_o_b = "";
		 Adress = "";
		 Nationality = "";
		 Gender = "";
		 Email = "";
		 Class_Name = "";
		 Section = "";
		 year="";
		 Subject="";
		 Education="";
		 type="";
		 Religion="";
		 Date="";
		 loginid=0;
		 uname="";
			}
	
	
	public void set_login(String na,String pa)
    {
    	this.un = na;
    	this.pass = pa;
    }
	public String get_login_query()
	{
		try {
		String sql = "select * from  login_user;";
	    System.out.println(sql);
				try {
					rs = stmt.executeQuery(sql);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
				try {
					while(rs.next()){
						 loginid=rs.getInt("id"); 
					     uname  = rs.getString("User_name");
					     String passw = rs.getString("Password");
					     String type = rs.getString("Type");
					     
					     if(uname.equals(un) && passw.equals(pass)&& type.equals("Admin"))
					     {
					    	Ltype = "Admin";
					    	check = true;
					    	break;
					     }
					     else if(uname.equals(un) && passw.equals(pass)&& type.equals("Teacher"))
					     {
					    	 Ltype = "Teacher";
						     check = true;
						     break;
					     }
					     else
					     {
					    	 check = false;
					     }     
}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (HeadlessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		try {
			if (check == true && Ltype.equals("Admin")) {
			 JOptionPane.showMessageDialog(null,"Successfully Login"); 
			 //Login_Home lh = new Login_Home();
			 
			 return uname;
	    	 }
	    	 else if (check == true && Ltype.equals("Teacher")) {
	    		 JOptionPane.showMessageDialog(null,"Successfully Login"); 
	    		 
				 return uname;
	    	 }
	    	 else if (check == false) {
		    	 JOptionPane.showMessageDialog(null,"User Name or Password is Incorrect");
	    	 }
			conn.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return null;
		 
	     
	}
	public void getid()
	{
		this.ids=loginid;
		System.out.println("Id : "+ids);
	}
	public void set_insert(String Year,String Name,String F_Name,String F_Cnic,String F_Contact,String D_o_b,String Adress,String Nationality,String Gender,String Religion,String Date,String Class_Name,String Section)
	{
		this.Name = Name;
		this.F_Name = F_Name;
		this.F_Cnic = F_Cnic;
		this.F_Contact = F_Contact;
		this.D_o_b = D_o_b;
		this.Adress = Adress;
		this.Nationality = Nationality;
		this.Gender = Gender;
		this.Religion = Religion;
		this.Date=Date;
		this.Class_Name = Class_Name;
		this.Section = Section;
		this.year = Year;

	}
	public void get_insert_query()
	{
		try {
			String sql = "insert into student_info(s_name, s_dob, s_address, nationality,religion, s_gender) values(\""+Name+  "\",\""+D_o_b+"\",\""+Adress+"\",\""+Nationality+"\",\""+Religion+"\",\""+Gender+"\")";
			String sql1 = "select s_id,s_name from  student_info;";//where user_name=\""+Name+  "\" and \""+Pass+"\"";
	    	 		
			try {
						stmt.executeUpdate(sql);
					rs=	stmt.executeQuery(sql1);
					
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}			
					try {
						while(rs.next()){
							 int id =rs.getInt("s_id");
							 String name=rs.getString("s_name");
							 String status="studying";
							 if(name.equals(Name) )
						     {
						    	 String sql3 = "insert into guardian_info(s_id, father_name, father_cnic, father_contact) values(\""+id+  "\",\""+F_Name+  "\",\""+F_Cnic+"\",\""+F_Contact+"\" )";
						    	 String sql4 = "insert into degree0_info(s_id,Dates, Class_name,Year, section) values(\""+id+  "\",\""+Date+  "\",\""+Class_Name+  "\",\""+year+"\",\""+Section+"\")";
						 	     String sql5 = "insert into course_along_std (s_id,c_id,section,class_name,p_f_s)values(\""+id+  "\",\""+1+  "\",\""+Section+"\",\""+Class_Name+"\",\""+status+"\"),(\""+id+  "\",\""+2+  "\",\""+Section+"\",\""+Class_Name+"\",\""+status+"\"),(\""+id+  "\",\""+3+  "\",\""+Section+"\",\""+Class_Name+"\",\""+status+"\"),(\""+id+  "\",\""+5+  "\",\""+Section+"\",\""+Class_Name+"\",\""+status+"\"),(\""+id+  "\",\""+6+  "\",\""+Section+"\",\""+Class_Name+"\",\""+status+"\"),(\""+id+  "\",\""+7+  "\",\""+Section+"\",\""+Class_Name+"\",\""+status+"\")";
						    	 
						 	     System.out.println(sql3);
						    	 System.out.println(sql5);
						    	   stmt.executeUpdate(sql3);
						    	   stmt.executeUpdate(sql4);
						    	   stmt.executeUpdate(sql5);
						    	   JOptionPane.showMessageDialog(null, "Registered Successfully");
						    	  // Registration rg=new Registration();
						    	   //rg.setVisible(false);
						    	   //Admin ad = new Admin();
						    	   //ad.setVisible(true);
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
	public void set_teacher_insert(String Name,String Pass,String Cnic,String Subject,String Education,String C_no,String D_o_b,String Adress,String Class,String Section,String Gender,String Email)
	{
		this.Name = Name;
		this.Pass = Pass;
		this.Subject = Subject;
		this.Education = Education;
		this.Cnic = Cnic;
		this.C_no = C_no;
		this.D_o_b = D_o_b;
		this.Adress = Adress;
		this.Class_Name = Class;
		this.Section=Section;
		this.Gender = Gender;
		this.Email = Email;
		
	}
	public void get_insert_teacher_query()
	{
		try {
			String type="Teacher";
	    String sql = "insert into login_user(user_name, Password,Type) values (\""+Name+  "\",\""+Pass+"\",\""+type+"\")";
	    String sql1 = "select id, User_name, Password from  login_user;";//where user_name=\""+Name+  "\" and \""+Pass+"\"";
		
	   
		
			System.out.println(sql1);
			
					try {
						stmt.executeUpdate(sql);
						rs = stmt.executeQuery(sql1);
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}			
					try {
						while(rs.next()){
							 int id =rs.getInt("id");
						     String uname  = rs.getString("User_name");
						     String passw = rs.getString("Password");
						    // JOptionPane.showMessageDialog(null, id);
						     if(uname.equals(Name) && passw.equals(Pass))
						     {
						    	 //JOptionPane.showMessageDialog(null, id);
						    	 String sql2 = "insert into teacher_info(t_id, name , cnic, Subject, education, contact, email, dob, address, Class_name,Section, gender) values(\""+id+  "\",\""+Name+  "\",\""+Cnic+"\",\""+Subject+"\",\""+Education+"\",\""+C_no+"\",\""+Email+"\",\""+D_o_b+"\",\""+Adress+"\",\""+Class_Name+"\",\""+Section+"\",\""+Gender+"\")";
						    	 System.out.println(sql2);
						    	 stmt.executeUpdate(sql2);
						    	 JOptionPane.showMessageDialog(null, "Registered Successfully");
						    	// Registration rg=new Registration();
						    	  // rg.setVisible(false);
						    	   //Admin ad = new Admin();
						    	   //ad.setVisible(true);
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
	public void setupdateuser(int id,String Name,String Pass)
	{
		this.ids=id;
		this.un=Name;
		this.pass=Pass;
		
	}
	public void getupdateuser()
	{
		try {
			
	    String sql1 = "select id, User_name, Password from  login_user;";//where user_name=\""+Name+  "\" and \""+Pass+"\"";
		
		
			System.out.println(sql1);
			
					try {
						rs = stmt.executeQuery(sql1);
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}			
					try {
						while(rs.next()){
							 int id =rs.getInt("id");
						     String uname  = rs.getString("User_name");
						     String passw = rs.getString("Password");
					    	 
						     if(id ==ids )
						     {
						    	 
						    	 String sql0="UPDATE login_user SET User_name = \""+un+  "\" ,Password= \""+pass+"\" where id= \""+id+"\"";
						    	 JOptionPane.showMessageDialog(null, "Successfully Updated");
						    	 System.out.println(sql0);
						    	 stmt.executeUpdate(sql0);
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
	public void setdeleteuser(int id,String Name,String Pass,String Type)
	{
		this.ids=id;
		this.un=Name;
		this.pass=Pass;
		this.type=Type;
	}
	public void getdeleteuser()
	{
		try {
			
		    String sql1 = "select id,Type from  login_user;";//where user_name=\""+Name+  "\" and \""+Pass+"\"";
			
				System.out.println(sql1);
						try {
							rs = stmt.executeQuery(sql1);
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}			
						try {
							while(rs.next()){
								 int id =rs.getInt("id");
								 String type=rs.getString("Type");
								 if(id ==ids && type==type)
							     {
									 String sql0="delete from login_user where id = \""+ids+  "\" ";
							    	 String sql2="delete from teacher_info where t_id = \""+ids+  "\" ";
							    	 
							    	 System.out.println(sql0);
							    	 stmt.executeUpdate(sql0);
							    	 stmt.executeUpdate(sql2);
							    	 JOptionPane.showMessageDialog(null, "Successfully Removed");
							    	 check = true;
							    	break;
							     }
							     else if(id ==ids && type=="Student" )
							     {

									 JOptionPane.showMessageDialog(null, id);
									 JOptionPane.showMessageDialog(null, type);
							    	 String sql0="delete from login_user where id = \""+ids+  "\" ";
							    	 String sql2="delete from student_info where s_id = \""+ids+  "\" ";
							    	 
							    	 System.out.println(sql0);
							    	 stmt.executeUpdate(sql0);
							    	 JOptionPane.showMessageDialog(null, "Successfully Removed");
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
	

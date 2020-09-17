package Model;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import Singleton.jdbc;

public class m_Attendance extends jdbc {
	String Date,status;
	int id;
	public m_Attendance()
	{
		Date = "";
		id = 0;
		status = "";
	}
	public void set_att(String Date,int id,String status)
	{
		this.Date=Date;
		this.id=id;
		this.status=status;
	}
	public void get_att()
	{
		String sql="select s_id,Class_name,section from degree0_info where s_id=\""+id+"\"";
		System.out.println(sql);
		try {
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				int ids=rs.getInt("s_id");
				String cn=rs.getString("Class_name");
				String sec=rs.getString("section");
				if(ids==id)
				{
				String sql1="insert into attandace values(\""+id+"\",\""+Date+"\",\""+status+"\",\""+cn+"\",\""+sec+"\")";
				System.out.println(sql1);
				stmt.executeUpdate(sql1);
				JOptionPane.showMessageDialog(null, "Updated");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

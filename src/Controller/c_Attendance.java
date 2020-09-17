package Controller;

import Model.m_Attendance;

public class c_Attendance {
	m_Attendance att=new m_Attendance();
	public void set_att(String Date,int id,String status)
	{
		att.set_att(Date,id,status);
	}
	public void get_att()
	{
		att.get_att();
	}
}

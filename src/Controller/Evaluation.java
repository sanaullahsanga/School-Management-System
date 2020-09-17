package Controller;

import Model.m_Evaluation;

public class Evaluation {
	m_Evaluation e = new m_Evaluation();
	public void set_mid(String user,String Date,int id,String name,String subject,String marks)
	{
		e.set_mid(user,Date,id,name,subject,marks);
	}
	public void get_mid()
	{
		e.get_mid();
	}
	public void set_final(String user,String Date,int id,String name,String subject,String marks)
	{
		e.set_final(user,Date,id,name,subject,marks);
	}
	public void get_final()
	{
		e.get_final();
	}
	
}

package Controller;

import javax.swing.JOptionPane;

import Model.M_database_connectivity;

public class C_update {

	M_database_connectivity model = new M_database_connectivity();
	public void setupdateuser(int id,String Name,String Pass)
	{
		model.setupdateuser(id,Name,Pass);
	}
	public void getupdateuser()
	{
		model.getupdateuser();
	}
	public void setdeleteuser(int id,String Name,String Pass,String Type)
	{
		model.setdeleteuser(id,Name,Pass,Type);
	}
	public void getdeleteuser()
	{
		model.getdeleteuser();
	}
	
}

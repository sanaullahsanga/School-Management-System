package Controller;

import Model.M_database_connectivity;

public class C_insert_student {
	public M_database_connectivity model = new M_database_connectivity();
	
	public void set_insert(String Year,String Name,String F_Name,String F_Cnic,String F_Contact,String D_o_b,String Adress,String Nationality,String Gender,String Religion,String Date,String Class_Name,String Section)
	{
		model.set_insert(Year,Name,F_Name,F_Cnic,F_Contact,D_o_b,Adress,Nationality,Gender,Religion,Date,Class_Name,Section);
	}
	public void get_insert()
	{
		model.get_insert_query();
	}
}

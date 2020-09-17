package Controller;
import Model.M_database_connectivity;

public class C_insert_teacher {

	public M_database_connectivity model = new M_database_connectivity();
	
	public void set_insert(String Name,String Pass,String Cnic,String Subject,String Education,String C_no,String D_o_b,String Adress,String Class,String Section,String Gender,String Email)
	{
		model.set_teacher_insert(Name,Pass,Cnic,Subject,Education,C_no,D_o_b,Adress,Class,Section,Gender,Email);
	}
	public void get_insert()
	{
		model.get_insert_teacher_query();
	}
}
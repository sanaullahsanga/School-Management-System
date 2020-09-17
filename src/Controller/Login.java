package Controller;
import Model.*;

public class Login {
	public M_database_connectivity model = new M_database_connectivity();
    
	   public void setlogin(String name,String pass)
	   {
		   model.set_login(name, pass);
	   }
	   public String get_login(){
		    return model.get_login_query();
		   }
	   
}

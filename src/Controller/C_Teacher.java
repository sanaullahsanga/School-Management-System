package Controller;

import Model.M_Teacher;

public class C_Teacher {
	static M_Teacher t = new M_Teacher();
	public void showprofile (String user)
	{
		t.showprofile(user);
	}
	public static String name()
	{
		return t.name();
	}
	public static String cnic()
	{
		return t.cnic();
	}
	public static String Subject()
	{
		return t.Subject();
	}
	public static String education()
	{
		return t.education();
	}
	public static String contact()
	{
		return t.contact();
	}
	public static String email()
	{
		return t.email();
	}
	public static String dob()
	{
		return t.dob();
	}
	public static String address()
	{
		return t.address();
	}
	public static String Class_name()
	{
		return t.Class_name();
	}
	public static String Section()
	{
		return t.Section();
	}
	public static String gender()
	{
		return t.gender();
	}
	
}

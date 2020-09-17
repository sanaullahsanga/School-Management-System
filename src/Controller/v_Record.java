package Controller;

import Model.M_Record;

public class v_Record {
	M_Record r = new M_Record();
	public void set_update_stu(int data1,String data2,String data3,String data4,String data5,String data6,String data7,String data8,String data9,String data10)
	{
		r.set_update_stu(data1,data2,data3,data4,data5,data6,data7,data8,data9,data10);
	}
	public void get_update_stu()
	{
		r.get_update_stu();
	}
	public void set_update_tea(int data1,String data2,String data3,String data4,String data5,String data6,String data7,String data8,String data9,String data10,String data11,String data12)
	{
		r.set_update_tea(data1,data2,data3,data4,data5,data6,data7,data8,data9,data10,data11,data12);
	}
	public void get_update_tea()
	{
		r.get_update_tea();
	}
}

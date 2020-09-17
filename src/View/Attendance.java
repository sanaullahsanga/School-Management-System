package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Attendance extends JFrame {
	DefaultTableModel model;
	Connection conn=null;
	Statement stmt;
	ResultSet rs;
	String User;
	String data1,data2,data3,data4,data5;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(String user) {
				try {
					Attendance frame = new Attendance(user);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Attendance(String user) {
		User=user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 82, 275, 266);
		contentPane.add(scrollPane);
		
		showtableddata();
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Date", "Status"
			}
		));
	}
	public void showtableddata() {
		conn = null;
		stmt = null;
		String USER = "root";
		String PASS =  "";
		   final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		   final String DB_URL = "jdbc:mysql://localhost/sms_ooad";
		      try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      System.out.println("Connecting to a selected database...");
		      try {
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		      System.out.println("Connected database successfully...");
		      try {
		    	  String sql = "select Class_name,Section from teacher_info where name=\""+User+"\"";
		            stmt = conn.createStatement();
		            System.out.println(sql);
			        rs = stmt.executeQuery(sql);
			        java.sql.ResultSetMetaData rsmd = rs.getMetaData();
		        while(rs.next()) { 
		        data1 = rs.getString("Class_name");
		        data2 = rs.getString("Section");
		        }
		        String sql2="select a.s_name,b.date,b.status from student_info a join  attandace b where a.s_id=b.s_id AND b.class_name=\""+data1+"\" AND b.section=\""+data2+"\" order by b.date ASC";
		        System.out.println(sql2);
		        Statement s=conn.createStatement();
		        ResultSet r=s.executeQuery(sql2);
		        while(r.next())
		        {
		        	data3 = r.getString("s_name");
			        data4 = r.getString("date");
			        data5 = r.getString("status");
			        JOptionPane.showMessageDialog(null, data3);
		        Object[] row = { data3, data4, data5};
		        model = (DefaultTableModel) table.getModel();
		        model.addRow(row);
		        
		      }
		    } catch (SQLException e) {
		    	e.printStackTrace();
		        }
	}

		}

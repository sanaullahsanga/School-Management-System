package View;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

import Controller.C_Teacher;
import Controller.Evaluation;
import Controller.c_Attendance;

import com.toedter.calendar.JDateChooser;

import javax.swing.JComboBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class v_Teacher extends JFrame {
	Connection conn=null;
	Statement stmt=null;
	String us,pass;
	ResultSet rs;
	String user;
	String section,class_name;
	DefaultTableModel model,model_1,model_2,model_3=null;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTable table_1;
	private JTable table_2;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTabbedPane tabbedPane_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(String type) {
				try {
					v_Teacher frame = new v_Teacher(type);
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
	 * @param type 
	 */
	public v_Teacher(String type) {
		user=type;
		//JOptionPane.showMessageDialog(null, type);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 505);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(169, 169, 169));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 63, 587, 387);
		contentPane.add(tabbedPane_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("Menu.selectionBackground"));
		tabbedPane_1.addTab("Profile", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblName_1 = new JLabel("Personal Information");
		lblName_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblName_1.setBounds(47, 27, 154, 28);
		panel_1.add(lblName_1);
		
		JLabel label = new JLabel("Name");
		label.setBounds(47, 66, 46, 14);
		panel_1.add(label);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(47, 106, 46, 14);
		panel_1.add(lblGender);
		
		JLabel lblSubject_1 = new JLabel("Subject");
		lblSubject_1.setBounds(315, 287, 46, 14);
		panel_1.add(lblSubject_1);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setBounds(47, 196, 46, 14);
		panel_1.add(lblContact);
		
		JLabel lblD = new JLabel("DOB");
		lblD.setBounds(315, 66, 46, 14);
		panel_1.add(lblD);
		
		JLabel lblCnic = new JLabel("CNIC");
		lblCnic.setBounds(315, 106, 46, 14);
		panel_1.add(lblCnic);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(47, 148, 46, 14);
		panel_1.add(lblEmail);
		
		JLabel lblContactInformation = new JLabel("Educational Information");
		lblContactInformation.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblContactInformation.setBounds(47, 235, 175, 28);
		panel_1.add(lblContactInformation);
		
		JLabel lblAddress = new JLabel("Education");
		lblAddress.setBounds(47, 287, 65, 14);
		panel_1.add(lblAddress);
		
		JLabel lblAddress_1 = new JLabel("Address");
		lblAddress_1.setBounds(315, 196, 46, 14);
		panel_1.add(lblAddress_1);
		
		JLabel lblClass = new JLabel("Section");
		lblClass.setBounds(315, 322, 46, 14);
		panel_1.add(lblClass);
		
		JLabel lblClass_1 = new JLabel("Class");
		lblClass_1.setBounds(47, 322, 46, 14);
		panel_1.add(lblClass_1);
		
		C_Teacher t = new C_Teacher();
		t.showprofile(type);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBackground(Color.BLUE);
		lblNewLabel_1.setText(C_Teacher.name());
		lblNewLabel_1.setBounds(155, 66, 97, 20);
		panel_1.add(lblNewLabel_1);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setBackground(Color.BLUE);
		label_1.setText(C_Teacher.gender());
		label_1.setBounds(155, 106, 97, 20);
		panel_1.add(label_1);
		
		JLabel label_3 = new JLabel("New label");
		label_3.setBackground(Color.BLUE);
		label_3.setText(C_Teacher.Subject());
		label_3.setBounds(423, 287, 97, 20);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("New label");
		label_4.setBackground(Color.BLUE);
		label_4.setText(C_Teacher.contact());
		label_4.setBounds(155, 196, 97, 20);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("New label");
		label_5.setBackground(Color.BLUE);
		label_5.setText(C_Teacher.dob());
		label_5.setBounds(423, 66, 97, 20);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("New label");
		label_6.setBackground(Color.BLUE);
		label_6.setText(C_Teacher.cnic());
		label_6.setBounds(423, 106, 97, 20);
		panel_1.add(label_6);
		
		JLabel label_7 = new JLabel("New label");
		label_7.setBackground(Color.BLUE);
		label_7.setText(C_Teacher.email());
		label_7.setBounds(155, 148, 161, 20);
		panel_1.add(label_7);
		
		JLabel label_8 = new JLabel("New label");
		label_8.setBackground(Color.BLUE);
		label_8.setText(C_Teacher.address());
		label_8.setBounds(423, 196, 97, 20);
		panel_1.add(label_8);
		
		JLabel label_9 = new JLabel("New label");
		label_9.setBackground(Color.BLUE);
		label_9.setText(C_Teacher.education());
		label_9.setBounds(155, 287, 97, 20);
		panel_1.add(label_9);
		
		JLabel label_10 = new JLabel("New label");
		label_10.setBackground(Color.BLUE);
		label_10.setText(C_Teacher.Class_name());
		label_10.setBounds(155, 322, 97, 20);
		panel_1.add(label_10);
		
		JLabel label_11 = new JLabel("New label");
		label_11.setBackground(Color.BLUE);
		label_11.setText(C_Teacher.Section());
		label_11.setBounds(423, 322, 97, 20);
		panel_1.add(label_11);
		
		JPanel panel_3 = new JPanel();
		tabbedPane_1.addTab("Attendance", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(24, 29, 182, 319);
		panel_3.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i=table.getSelectedRow();
				TableModel model = table.getModel();
				textField.setText(model.getValueAt(i, 0).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name"
			}
		));
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(294, 66, 46, 14);
		panel_3.add(lblDate);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(294, 130, 46, 14);
		panel_3.add(lblId);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(294, 185, 46, 14);
		panel_3.add(lblStatus);
		
		textField = new JTextField();
		textField.setBounds(380, 124, 86, 20);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(380, 66, 102, 20);
		panel_3.add(dateChooser);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Present");
		comboBox.addItem("Absent");
		comboBox.setBounds(380, 182, 86, 20);
		panel_3.add(comboBox);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.addTab("Exam", null, tabbedPane, null);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Mid", null, panel, null);
		panel.setLayout(null);
		
		table_1 = new JTable();
		table_1.setBounds(288, 5, 0, 0);
		panel.add(table_1);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 24, 182, 277);
		panel.add(scrollPane_3);
		
		
		table_2 = new JTable();
		scrollPane_3.setViewportView(table_2);
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i=table_2.getSelectedRow();
				TableModel model = table_2.getModel();
				textField_1.setText(model.getValueAt(i, 0).toString());
				textField_2.setText(model.getValueAt(i, 1).toString());
			}
		});
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Name"
			}
		));
		
		JLabel lblDate_1 = new JLabel("Date");
		lblDate_1.setBounds(218, 55, 46, 14);
		panel.add(lblDate_1);
		
		JLabel lblId_1 = new JLabel("ID");
		lblId_1.setBounds(218, 97, 46, 14);
		panel.add(lblId_1);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(399, 97, 46, 14);
		panel.add(lblName);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setBounds(218, 149, 46, 14);
		panel.add(lblSubject);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(293, 49, 91, 20);
		panel.add(dateChooser_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(293, 94, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(469, 91, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addItem("Urdu");
		comboBox_1.addItem("English");
		comboBox_1.addItem("Maths");
		comboBox_1.addItem("Islamiat");
		comboBox_1.addItem("Pak-Study");
		comboBox_1.addItem("Science");
		comboBox_1.setBounds(293, 146, 86, 20);
		panel.add(comboBox_1);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Final", null, panel_4, null);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 22, 170, 284);
		panel_4.add(scrollPane_4);
		
		table_3 = new JTable();
		scrollPane_4.setViewportView(table_3);
		table_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i=table_3.getSelectedRow();
				TableModel model = table_3.getModel();
				textField_4.setText(model.getValueAt(i, 0).toString());
				textField_5.setText(model.getValueAt(i, 1).toString());
			}
		});
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name"
			}
		));
		
		JLabel lblDate_2 = new JLabel("Date");
		lblDate_2.setBounds(251, 69, 46, 14);
		panel_4.add(lblDate_2);
		
		JLabel lblId_2 = new JLabel("ID");
		lblId_2.setBounds(251, 124, 46, 14);
		panel_4.add(lblId_2);
		
		JLabel lblName_2 = new JLabel("Name");
		lblName_2.setBounds(408, 124, 46, 14);
		panel_4.add(lblName_2);
		
		JLabel lblSubject_2 = new JLabel("Subject");
		lblSubject_2.setBounds(251, 189, 46, 14);
		panel_4.add(lblSubject_2);
		
		JLabel lblMarks_1 = new JLabel("Marks");
		lblMarks_1.setBounds(408, 189, 46, 14);
		panel_4.add(lblMarks_1);
		
		JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.setBounds(311, 63, 114, 20);
		panel_4.add(dateChooser_2);
		
		textField_4 = new JTextField();
		textField_4.setBounds(310, 121, 73, 20);
		panel_4.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(464, 121, 86, 20);
		panel_4.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(464, 186, 86, 20);
		panel_4.add(textField_6);
		textField_6.setColumns(10);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.addItem("Urdu");
		comboBox_2.addItem("English");
		comboBox_2.addItem("Maths");
		comboBox_2.addItem("Islamiat");
		comboBox_2.addItem("Pak-Study");
		comboBox_2.addItem("Science");
		comboBox_2.setBounds(311, 186, 72, 20);
		panel_4.add(comboBox_2);
		
		JButton btnUpdate_2 = new JButton("Update");
		btnUpdate_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date selectedDate = (Date) dateChooser_2.getDate();
			    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			    String reportDate = df.format(selectedDate);
				String id=textField_4.getText();
				int result = Integer.parseInt(id);
				String name= textField_5.getText();
				String status=(String) comboBox_2.getSelectedItem();
				String marks=textField_6.getText();
				//JOptionPane.showMessageDialog(null, reportDate);
				Evaluation e=new Evaluation();
				e.set_final(type,reportDate,result,name,status,marks);	
				e.get_final();
			}
		});
		btnUpdate_2.setBounds(357, 255, 89, 23);
		panel_4.add(btnUpdate_2);
		
		
		showtableddata();
		
		JButton btnUpdate_1 = new JButton("Update");
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date selectedDate = (Date) dateChooser_1.getDate();
			    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			    String reportDate = df.format(selectedDate);
				String id=textField_1.getText();
				int result = Integer.parseInt(id);
				String name= textField_2.getText();
				String status=(String) comboBox_1.getSelectedItem();
				String marks=textField_3.getText();
				//JOptionPane.showMessageDialog(null, reportDate);
				Evaluation e=new Evaluation();
				e.set_mid(type,reportDate,result,name,status,marks);	
				e.get_mid();
			}
		});
		btnUpdate_1.setBounds(345, 231, 89, 23);
		panel.add(btnUpdate_1);
		
		JLabel lblMarks = new JLabel("Marks");
		lblMarks.setBounds(399, 149, 46, 14);
		panel.add(lblMarks);
		
		textField_3 = new JTextField();
		textField_3.setBounds(469, 146, 86, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(173, 24, 17, 27);
		panel.add(scrollBar);
		
		
		
		JButton btnUpdate = new JButton("update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date selectedDate = (Date) dateChooser.getDate();
			    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			    String reportDate = df.format(selectedDate);
			    String id=textField.getText();
				int result = Integer.parseInt(id);
				String status=(String) comboBox.getSelectedItem();
				//JOptionPane.showMessageDialog(null, date);
				c_Attendance att=new c_Attendance();
				att.set_att(reportDate,result,status);
				att.get_att();
			}
		});
		btnUpdate.setBounds(354, 259, 89, 23);
		panel_3.add(btnUpdate);
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		String user="Welcome  "+type;
		lblNewLabel.setText(user);
		lblNewLabel.setBounds(221, 28, 178, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblLogout = new JLabel("Logout");
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				Login_Home l =new Login_Home();
				l.setVisible(true);
			}
		});
		lblLogout.setForeground(Color.RED);
		lblLogout.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLogout.setBounds(523, 11, 56, 24);
		contentPane.add(lblLogout);
		
		
	}
	public void showtableddata() {
		
		conn = null;
		stmt = null;
		us = "root";
		pass =  "";
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
				conn = DriverManager.getConnection(DB_URL, us, pass);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		      System.out.println("Connected database successfully...");
		      try {
		    	  String sql1="select Class_name,Section from teacher_info where name=\""+user+"\"";
		    	  Statement s=conn.createStatement();
		    	  ResultSet r=s.executeQuery(sql1);
		    	  while(r.next())
		    	  {
		    		  class_name=r.getString("Class_name");
		    		  section=r.getString("Section");
		    	  }
		    	  String sql = "SELECT DISTINCT a.s_id, a.s_name FROM student_info a JOIN course_along_std b WHERE a.s_id = b.s_id AND b.section=\""+section+"\" AND b.class_name=\""+class_name+"\"";
		            stmt = conn.createStatement();
			        rs = stmt.executeQuery(sql);
			        java.sql.ResultSetMetaData rsmd = rs.getMetaData();
		        while(rs.next()) { 
		        String data1 = rs.getString("s_id");
		        String data2 = rs.getString("s_name");
		        Object[] row = { data1, data2};
		        model = (DefaultTableModel) table.getModel();
		        model_1 = (DefaultTableModel) table_2.getModel();
		        model_2 = (DefaultTableModel) table_3.getModel();
		        model.addRow(row);
		        model_1.addRow(row);
		        model_2.addRow(row);
		        
		                           }
		    } catch (SQLException e) {
		    	e.printStackTrace();
		        }
	}
	}

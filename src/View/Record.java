package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JScrollPane;

import Controller.v_Record;

public class Record extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Connection conn;
	Statement stmt;
	ResultSet rs;
	DefaultTableModel model;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTable table_1;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Record frame = new Record();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Record() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 607);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblBack = new JLabel("Back");
		lblBack.setBounds(10, 11, 46, 14);
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				Admin a = new Admin(getTitle());
				a.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		lblBack.setForeground(Color.RED);
		lblBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblBack);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 46, 791, 499);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Student", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 11, 294, 346);
		panel.add(scrollPane_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				

			}
		});
		scrollPane_2.setViewportView(scrollPane_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i=table.getSelectedRow();
				TableModel model = table.getModel();
				textField.setText(model.getValueAt(i, 0).toString());
				textField_1.setText(model.getValueAt(i, 1).toString());
				textField_2.setText(model.getValueAt(i, 2).toString());
				textField_3.setText(model.getValueAt(i, 3).toString());
				textField_4.setText(model.getValueAt(i, 4).toString());
				textField_5.setText(model.getValueAt(i, 5).toString());
				textField_6.setText(model.getValueAt(i, 6).toString());
				textField_7.setText(model.getValueAt(i, 7).toString());
				textField_8.setText(model.getValueAt(i, 8).toString());
				textField_9.setText(model.getValueAt(i, 9).toString());
			}
		});
		scrollPane_1.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Dob", "Address", "Nationality", "Religion", "Gender", "Father's Name", "Father's Contact", "Father's CNIC"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(116);
		table.getColumnModel().getColumn(2).setPreferredWidth(112);
		table.getColumnModel().getColumn(3).setPreferredWidth(120);
		table.getColumnModel().getColumn(4).setPreferredWidth(105);
		table.getColumnModel().getColumn(5).setPreferredWidth(95);
		table.getColumnModel().getColumn(6).setPreferredWidth(89);
		table.getColumnModel().getColumn(7).setPreferredWidth(103);
		table.getColumnModel().getColumn(8).setPreferredWidth(107);
		table.getColumnModel().getColumn(9).setPreferredWidth(135);
		
		showstudents();
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String data1 = textField.getText();
				int id = Integer.parseInt(data1);	
				String data2 = textField_1.getText();
				String data3 = textField_2.getText();
				String data4 = textField_3.getText();
				String data5 = textField_4.getText();
				String data6 = textField_5.getText();
				String data7 = textField_6.getText();
				String data8 = textField_7.getText();
				String data9 = textField_8.getText();
				String data10 = textField_9.getText();
				v_Record r=new v_Record();
				r.set_update_stu(id,data2,data3,data4,data5,data6,data7,data8,data9,data10);
				r.get_update_stu();
				model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				showstudents();
			}
		});
		btnSave.setBounds(428, 425, 89, 23);
		panel.add(btnSave);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(344, 49, 46, 14);
		panel.add(lblId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(344, 87, 46, 14);
		panel.add(lblName);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setBounds(344, 125, 46, 14);
		panel.add(lblDob);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(344, 162, 46, 14);
		panel.add(lblAddress);
		
		JLabel lblNationality = new JLabel("Nationality");
		lblNationality.setBounds(344, 202, 77, 14);
		panel.add(lblNationality);
		
		JLabel lblReligion = new JLabel("Religion");
		lblReligion.setBounds(344, 237, 46, 14);
		panel.add(lblReligion);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(344, 275, 46, 14);
		panel.add(lblGender);
		
		JLabel lblFathersName = new JLabel("Father's Name");
		lblFathersName.setBounds(344, 312, 89, 14);
		panel.add(lblFathersName);
		
		JLabel lblFathersContact = new JLabel("Father's Contact");
		lblFathersContact.setBounds(344, 351, 89, 14);
		panel.add(lblFathersContact);
		
		JLabel lblFathersCnic = new JLabel("Father's CNIC");
		lblFathersCnic.setBounds(344, 385, 89, 14);
		panel.add(lblFathersCnic);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(516, 46, 56, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(493, 84, 111, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(493, 122, 111, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(493, 159, 111, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(493, 199, 111, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(493, 234, 111, 20);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(493, 272, 111, 20);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(493, 309, 111, 20);
		panel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(493, 348, 111, 20);
		panel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(493, 382, 111, 20);
		panel.add(textField_9);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Teacher", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(22, 45, 300, 353);
		panel_1.add(scrollPane_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
			}
		});
		scrollPane_3.setViewportView(scrollPane);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i=table_1.getSelectedRow();
				TableModel model1 = table_1.getModel();
				textField_10.setText(model1.getValueAt(i, 0).toString());
				textField_11.setText(model1.getValueAt(i, 1).toString());
				textField_12.setText(model1.getValueAt(i, 2).toString());
				textField_13.setText(model1.getValueAt(i, 3).toString());
				textField_14.setText(model1.getValueAt(i, 4).toString());
				textField_15.setText(model1.getValueAt(i, 5).toString());
				textField_16.setText(model1.getValueAt(i, 6).toString());
				textField_17.setText(model1.getValueAt(i, 7).toString());
				textField_18.setText(model1.getValueAt(i, 8).toString());
				textField_19.setText(model1.getValueAt(i, 9).toString());
				textField_20.setText(model1.getValueAt(i, 10).toString());
				textField_21.setText(model1.getValueAt(i, 11).toString());
			}
		});
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "CNIC", "Education", "Subject", "Contact", "Email", "Dob", "Gender", "Address", "Class Name", "Section"
			}
		));
		table_1.getColumnModel().getColumn(1).setPreferredWidth(100);
		table_1.getColumnModel().getColumn(1).setMinWidth(30);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(105);
		table_1.getColumnModel().getColumn(2).setMinWidth(40);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(88);
		table_1.getColumnModel().getColumn(3).setMinWidth(30);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(81);
		table_1.getColumnModel().getColumn(4).setMinWidth(30);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(100);
		table_1.getColumnModel().getColumn(5).setMinWidth(40);
		table_1.getColumnModel().getColumn(6).setPreferredWidth(112);
		table_1.getColumnModel().getColumn(6).setMinWidth(30);
		table_1.getColumnModel().getColumn(7).setPreferredWidth(97);
		table_1.getColumnModel().getColumn(7).setMinWidth(30);
		table_1.getColumnModel().getColumn(8).setPreferredWidth(84);
		table_1.getColumnModel().getColumn(8).setMinWidth(30);
		table_1.getColumnModel().getColumn(9).setPreferredWidth(110);
		table_1.getColumnModel().getColumn(9).setMinWidth(40);
		table_1.getColumnModel().getColumn(10).setPreferredWidth(100);
		table_1.getColumnModel().getColumn(10).setMinWidth(30);
		table_1.getColumnModel().getColumn(11).setPreferredWidth(90);
		table_1.getColumnModel().getColumn(11).setMinWidth(20);
		
		JLabel lblId_1 = new JLabel("ID");
		lblId_1.setBounds(371, 55, 46, 14);
		panel_1.add(lblId_1);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setBounds(371, 90, 46, 14);
		panel_1.add(lblName_1);
		
		JLabel lblCnic = new JLabel("CNIC");
		lblCnic.setBounds(371, 125, 46, 14);
		panel_1.add(lblCnic);
		
		JLabel lblEducation = new JLabel("Education");
		lblEducation.setBounds(371, 160, 46, 14);
		panel_1.add(lblEducation);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setBounds(371, 195, 46, 14);
		panel_1.add(lblSubject);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setBounds(371, 230, 46, 14);
		panel_1.add(lblContact);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(371, 265, 46, 14);
		panel_1.add(lblEmail);
		
		JLabel lblDob_1 = new JLabel("DOB");
		lblDob_1.setBounds(371, 300, 46, 14);
		panel_1.add(lblDob_1);
		
		JLabel lblAddress_1 = new JLabel("Gender");
		lblAddress_1.setBounds(371, 335, 46, 14);
		panel_1.add(lblAddress_1);
		
		JLabel lblClassName = new JLabel("Adress");
		lblClassName.setBounds(371, 370, 46, 14);
		panel_1.add(lblClassName);
		
		JLabel lblClassName_1 = new JLabel("Class Name");
		lblClassName_1.setBounds(371, 405, 46, 14);
		panel_1.add(lblClassName_1);
		
		JLabel lblSection = new JLabel("Section");
		lblSection.setBounds(371, 435, 46, 14);
		panel_1.add(lblSection);
		
		textField_10 = new JTextField();
		textField_10.setEnabled(false);
		textField_10.setBounds(480, 52, 57, 20);
		panel_1.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(466, 87, 125, 20);
		panel_1.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(466, 122, 125, 20);
		panel_1.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(466, 154, 125, 20);
		panel_1.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(466, 192, 125, 20);
		panel_1.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(466, 227, 125, 20);
		panel_1.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(466, 262, 125, 20);
		panel_1.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(466, 294, 125, 20);
		panel_1.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(466, 332, 125, 20);
		panel_1.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(466, 367, 125, 20);
		panel_1.add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBounds(466, 402, 125, 20);
		panel_1.add(textField_20);
		
		textField_21 = new JTextField();
		textField_21.setColumns(10);
		textField_21.setBounds(466, 432, 125, 20);
		panel_1.add(textField_21);
		
		showteacher();
		
		JButton btnSave_1 = new JButton("Save");
		btnSave_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String data1 = textField_10.getText();
				int id = Integer.parseInt(data1);	
				String data2 = textField_11.getText();
				String data3 = textField_12.getText();
				String data4 = textField_13.getText();
				String data5 = textField_14.getText();
				String data6 = textField_15.getText();
				String data7 = textField_16.getText();
				String data8 = textField_17.getText();
				String data9 = textField_18.getText();
				String data10 = textField_19.getText();
				String data11 = textField_20.getText();
				String data12 = textField_21.getText();
				v_Record r=new v_Record();
				r.set_update_tea(id,data2,data3,data4,data5,data6,data7,data8,data9,data10,data11,data12);
				r.get_update_tea();
				model = (DefaultTableModel) table_1.getModel();
				model.setRowCount(0);
				showteacher();
			}
		});
		btnSave_1.setBounds(120, 431, 89, 23);
		panel_1.add(btnSave_1);
	}
	public void showstudents()
	{
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
		    	  String sql = "select a.s_id,a.s_name,a.s_dob,a.s_address,a.nationality,a.religion,a.s_gender,b.father_name,b.father_cnic,b.father_contact FROM student_info a JOIN guardian_info b WHERE a.s_id=b.s_id ORDER BY s_id ASC";
		            stmt = conn.createStatement();
			        rs = stmt.executeQuery(sql);
			        java.sql.ResultSetMetaData rsmd = rs.getMetaData();
		        while(rs.next()) { 
		        String data1 = rs.getString("s_id");
		        String data2 = rs.getString("s_name");
		        String data3 = rs.getString("s_dob");
		        String data4 = rs.getString("s_address");
		        String data5 = rs.getString("nationality");
		        String data6 = rs.getString("religion");
		        String data7 = rs.getString("s_gender");
		        String data8 = rs.getString("father_name");
		        String data9 = rs.getString("father_cnic");
		        String data10 = rs.getString("father_contact");

		        Object[] row = { data1, data2, data3, data4, data5, data6, data7, data8,data9,data10};
		        model = (DefaultTableModel) table.getModel();
		        model.addRow(row);
		        
		                           }
		    } catch (SQLException e) {
		    	e.printStackTrace();
		        }
	}
	public void showteacher()
	{
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
		    	  String sql = "select * from teacher_info ORDER BY t_id ASC";
		            stmt = conn.createStatement();
			        rs = stmt.executeQuery(sql);
			        java.sql.ResultSetMetaData rsmd = rs.getMetaData();
		        while(rs.next()) { 
		        String data1 = rs.getString("t_id");
		        String data2 = rs.getString("name");
		        String data3 = rs.getString("cnic");
		        String data4 = rs.getString("education");
		        String data5 = rs.getString("Subject");
		        String data6 = rs.getString("contact");
		        String data7 = rs.getString("email");
		        String data8 = rs.getString("dob");
		        String data9 = rs.getString("gender");
		        String data10 = rs.getString("address");
		        String data11 = rs.getString("Class_name");
		        String data12 = rs.getString("Section");
		        

		        Object[] row = { data1, data2, data3, data4, data5, data6, data7, data8,data9,data10,data11,data12};
		        DefaultTableModel mode2 = (DefaultTableModel) table_1.getModel();
		        mode2.addRow(row);
		        
		                           }
		    } catch (SQLException e) {
		    	e.printStackTrace();
		        }
	}
}

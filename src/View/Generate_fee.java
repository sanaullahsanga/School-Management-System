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

public class Generate_fee extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Connection conn;
	Statement stmt;
	ResultSet rs;
	DefaultTableModel model;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Generate_fee frame = new Generate_fee();
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
	public Generate_fee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 587);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
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
		lblBack.setForeground(new Color(240, 128, 128));
		lblBack.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		contentPane.add(lblBack);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 58, 791, 499);
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
		
		JLabel Id = new JLabel("Id");
		Id.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		Id.setBounds(471, 52, 73, 20);
		panel.add(Id);
		
		JLabel Name = new JLabel("Name");
		Name.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		Name.setBounds(471, 101, 160, 20);
		panel.add(Name);
		
		JLabel Father = new JLabel("Father's Name");
		Father.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		Father.setBounds(471, 149, 160, 20);
		panel.add(Father);
		
		JLabel Contact = new JLabel("Father's Contact");
		Contact.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		Contact.setBounds(471, 201, 160, 20);
		panel.add(Contact);
		
		JLabel FEE = new JLabel("Fee");
		FEE.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		FEE.setText("500");
		FEE.setBounds(471, 251, 160, 20);
		panel.add(FEE);
		
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i=table.getSelectedRow();
				TableModel model = table.getModel();
				Id.setText(model.getValueAt(i, 0).toString());
				Name.setText(model.getValueAt(i, 1).toString());
				Father.setText(model.getValueAt(i, 2).toString());
				Contact.setText(model.getValueAt(i, 3).toString());
			}
		});
		scrollPane_1.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Father's Name", "Father's Contact"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(116);
		table.getColumnModel().getColumn(2).setPreferredWidth(112);
		table.getColumnModel().getColumn(3).setPreferredWidth(120);

		
		showstudents();
		
		JButton btnSave = new JButton("Print");
		btnSave.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btnSave.setBounds(419, 305, 98, 37);
		panel.add(btnSave);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblId.setBounds(330, 52, 119, 14);
		panel.add(lblId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblName.setBounds(330, 101, 119, 14);
		panel.add(lblName);
		
		JLabel lblFathersName = new JLabel("Father's Name");
		lblFathersName.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblFathersName.setBounds(330, 149, 119, 14);
		panel.add(lblFathersName);
		
		JLabel lblFathersContact = new JLabel("Father's Contact");
		lblFathersContact.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblFathersContact.setBounds(330, 201, 119, 14);
		panel.add(lblFathersContact);
		
		JLabel lblFathersCnic = new JLabel("Fee");
		lblFathersCnic.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblFathersCnic.setBounds(330, 251, 119, 14);
		panel.add(lblFathersCnic);
		
		
		JLabel lblUpdateshowRecord = new JLabel("Generate Fee");
		lblUpdateshowRecord.setForeground(new Color(255, 250, 250));
		lblUpdateshowRecord.setFont(new Font("Trebuchet MS", Font.PLAIN, 21));
		lblUpdateshowRecord.setBounds(245, 19, 231, 28);
		contentPane.add(lblUpdateshowRecord);
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
		    	  String sql = "select a.s_id,a.s_name,b.father_name,b.father_contact FROM student_info a JOIN guardian_info b WHERE a.s_id=b.s_id ORDER BY s_id ASC";
		            stmt = conn.createStatement();
			        rs = stmt.executeQuery(sql);
			        java.sql.ResultSetMetaData rsmd = rs.getMetaData();
		        while(rs.next()) { 
		        String data1 = rs.getString("s_id");
		        String data2 = rs.getString("s_name");
		        String data8 = rs.getString("father_name");
		        String data10 = rs.getString("father_contact");

		        Object[] row = { data1, data2, data8,data10};
		        model = (DefaultTableModel) table.getModel();
		        model.addRow(row);
		        
		                           }
		    } catch (SQLException e) {
		    	e.printStackTrace();
		        }
	}
	
}

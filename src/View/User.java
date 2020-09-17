package View;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.RowFilter;

import Controller.C_update;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class User extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public String USER = "root";
	public String PASS = "";
	Connection conn;
	DefaultTableModel model;
	   Statement stmt;
	   public String un;
	   public String pass;
	   ResultSet rs=null;
		String Ltype="";
		boolean check = false;
		private JTextField textField;
		private JTextField textField_1;
		private JLabel lblId;
		private JTextField textField_2;
		private JButton btnNewButton;
		private JTextField textField_3;
		private JLabel lblSearch;
		private JTextField textField_4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User frame = new User();
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
	public User() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 350);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		table.setBackground(Color.MAGENTA);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i=table.getSelectedRow();
				TableModel model = table.getModel();
				textField_2.setText(model.getValueAt(i, 0).toString());
				textField.setText(model.getValueAt(i, 1).toString());
				textField_1.setText(model.getValueAt(i, 2).toString());
				textField_3.setText(model.getValueAt(i, 3).toString());
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"id", "User_name", "Password", "Type"},
			},
			new String[] {
				"id", "User_name", "Password", "Type"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(55);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.setBounds(28, 95, 316, 182);
		contentPane.add(table);
		
		JLabel lblUsername = new JLabel("User_Name");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(390, 147, 75, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(390, 186, 75, 14);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(468, 144, 92, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(468, 183, 92, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		
		showtableddata();
		      JButton btnSave = new JButton("Save");
				btnSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String Id = textField_2.getText();
						int id = Integer.parseInt(Id);	
						String Name= textField.getText();
						String Pass= textField_1.getText();
						C_update up =new C_update();
						up.setupdateuser(id,Name,Pass);
						up.getupdateuser();
						model = (DefaultTableModel) table.getModel();
						model.setRowCount(1);
						showtableddata();	
					}
				});
				btnSave.setBounds(390, 254, 89, 23);
				contentPane.add(btnSave);
				
				lblId = new JLabel("Id");
				lblId.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblId.setForeground(Color.WHITE);
				lblId.setBounds(390, 111, 46, 14);
				contentPane.add(lblId);
				
				textField_2 = new JTextField();
				textField_2.setEditable(false);
				textField_2.setBounds(468, 108, 92, 20);
				contentPane.add(textField_2);
				textField_2.setColumns(10);
				
				btnNewButton = new JButton("Remove");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String Id = textField_2.getText();
						int id = Integer.parseInt(Id);	
						String Name= textField.getText();
						String Pass= textField_1.getText();
						String Type= textField_3.getText();
						C_update up =new C_update();
						up.setdeleteuser(id,Name,Pass,Type);
						up.getdeleteuser();
						model = (DefaultTableModel) table.getModel();
						model.setRowCount(1);
						showtableddata();
					}
				});
				btnNewButton.setBounds(493, 254, 89, 23);
				contentPane.add(btnNewButton);
				
				JLabel lblType = new JLabel("Type");
				lblType.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblType.setForeground(Color.WHITE);
				lblType.setBounds(390, 226, 46, 14);
				contentPane.add(lblType);
				
				textField_3 = new JTextField();
				textField_3.setEnabled(false);
				textField_3.setBounds(468, 223, 92, 20);
				contentPane.add(textField_3);
				textField_3.setColumns(10);
				
				lblSearch = new JLabel("Search");
				lblSearch.setForeground(Color.RED);
				lblSearch.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblSearch.setBounds(39, 54, 46, 14);
				contentPane.add(lblSearch);
				
				textField_4 = new JTextField();
				textField_4.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent arg0) {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						String search=textField_4.getText();
						TableRowSorter<DefaultTableModel> tr = new  TableRowSorter<DefaultTableModel>(model);
						table.setRowSorter(tr);
						tr.setRowFilter(RowFilter.regexFilter(search));
					}

				});
				textField_4.setBounds(128, 51, 86, 20);
				contentPane.add(textField_4);
				textField_4.setColumns(10);
				
				JLabel lblBack = new JLabel("Back");
				lblBack.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						setVisible(false);
						Admin a = new Admin(Ltype);
						a.setVisible(true);
					}
				});
				lblBack.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblBack.setForeground(Color.RED);
				lblBack.setBounds(10, 11, 46, 14);
				contentPane.add(lblBack);
		
	}
	public void showtableddata() {
		conn = null;
		stmt = null;
		un = "";
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
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		      System.out.println("Connected database successfully...");
		      try {
		    	  String sql = "select * from login_user ORDER BY id ASC";
		            stmt = conn.createStatement();
			        rs = stmt.executeQuery(sql);
			        java.sql.ResultSetMetaData rsmd = rs.getMetaData();
		        while(rs.next()) { 
		        String data1 = rs.getString("id");
		        String data2 = rs.getString("User_name");
		        String data3 = rs.getString("Password");
		        String data4 = rs.getString("Type");

		        Object[] row = { data1, data2, data3, data4};
		        model = (DefaultTableModel) table.getModel();
		        model.addRow(row);
		        
		                           }
		    } catch (SQLException e) {
		    	e.printStackTrace();
		        }
	}
}

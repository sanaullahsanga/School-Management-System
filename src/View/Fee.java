package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

import javax.swing.JScrollPane;

public class Fee extends JFrame {

	protected static final JLabel Id = null;
	private JPanel contentPane;
	private JTable table;
	Connection conn;
	Statement stmt;
	ResultSet rs;
	DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fee frame = new Fee();
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
	public Fee() {
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
		
		JLabel Id = new JLabel("Id");
		Id.setBounds(493, 46, 56, 20);
		panel.add(Id);
		
		JLabel Name = new JLabel("Name");
		Name.setBounds(493, 84, 111, 20);
		panel.add(Name);
		
		JLabel Father = new JLabel("Father's Name");
		Father.setBounds(493, 122, 111, 20);
		panel.add(Father);
		
		JLabel Contact = new JLabel("Father's Contact");
		Contact.setBounds(493, 159, 111, 20);
		panel.add(Contact);
		
		JLabel FEE = new JLabel("Fee");
		FEE.setText("500");
		FEE.setBounds(493, 199, 111, 20);
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
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnSave.setBounds(428, 280, 89, 23);
		panel.add(btnSave);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(344, 49, 46, 14);
		panel.add(lblId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(344, 87, 46, 14);
		panel.add(lblName);
		
		JLabel lblFathersName = new JLabel("Father's Name");
		lblFathersName.setBounds(344, 125, 89, 14);
		panel.add(lblFathersName);
		
		JLabel lblFathersContact = new JLabel("Father's Contact");
		lblFathersContact.setBounds(344, 163, 89, 14);
		panel.add(lblFathersContact);
		
		JLabel lblFathersCnic = new JLabel("Fee");
		lblFathersCnic.setBounds(344, 201, 89, 14);
		panel.add(lblFathersCnic);
		
		
		
	}
	public void showstudents()
	{
		conn = null;
		stmt = null;
		String USER = "root";
		String PASS =  "";
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
			        rs.getMetaData();
		        while(rs.next()) { 
		        String data1 = rs.getString("s_id");
		        String data2 = rs.getString("s_name");
		        String data3 = rs.getString("father_name");
		        String data4 = rs.getString("father_contact");

		        Object[] row = { data1, data2, data3, data4};
		        model = (DefaultTableModel) table.getModel();
		        model.addRow(row);
		        
		                           }
		    } catch (SQLException e) {
		    	e.printStackTrace();
		        }
	}
	
}

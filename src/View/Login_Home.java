package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import Controller.Login;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.UIManager;

public class Login_Home extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Home frame = new Login_Home();
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
	public Login_Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 375);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.light"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblUserName.setBounds(182, 118, 86, 18);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblPassword.setBounds(182, 166, 74, 14);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(278, 119, 141, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login login=new Login();
				String name=textField.getText();
				String pasword=passwordField.getText();		
				login.setlogin(name,pasword);
				String type=login.get_login();
				//JOptionPane.showMessageDialog(null, type);
				if(type.equals("Admin"))
				{
					setVisible(false);
					Admin a=new Admin(type);
					a.setVisible(true);
				}
				else
				{
					setVisible(false);
					v_Teacher t = new v_Teacher(type);
					t.setVisible(true);
				}
			}
		});
		btnLogIn.setBounds(302, 213, 96, 34);
		contentPane.add(btnLogIn);
		
		JLabel lblSchoolManagementSystem = new JLabel("School Management System");
		lblSchoolManagementSystem.setFont(new Font("Trebuchet MS", Font.BOLD, 21));
		lblSchoolManagementSystem.setBounds(195, 34, 268, 41);
		contentPane.add(lblSchoolManagementSystem);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(278, 165, 141, 20);
		contentPane.add(passwordField);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 102));
		panel.setBounds(0, 0, 151, 336);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 19));
		lblNewLabel.setBounds(36, 139, 76, 44);
		panel.add(lblNewLabel);
	}
}

package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Admin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(String Name) {
				try {
					Admin frame = new Admin(Name);
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
	public Admin(String Name) {
		//JOptionPane.showMessageDialog(null, Name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeAdmin = new JLabel("Welcome Admin");
		lblWelcomeAdmin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWelcomeAdmin.setBounds(244, 60, 255, 14);
		contentPane.add(lblWelcomeAdmin);
		
		JButton btnUser = new JButton("User");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			    dispose();
				//System.exit(0);
				User user =new User();
				user.setVisible(true);
				
			}
		});
		btnUser.setBounds(63, 150, 89, 23);
		contentPane.add(btnUser);
		
		JButton btnRegistration = new JButton("Registration");
		btnRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Registration reg=new Registration();
				reg.setVisible(true);
			}
		});
		btnRegistration.setBounds(183, 150, 102, 23);
		contentPane.add(btnRegistration);
		
		
		
		JLabel lblLogout = new JLabel("Logout");
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				Login_Home l = new Login_Home();
				l.setVisible(true);
			}
		});
		lblLogout.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLogout.setForeground(Color.RED);
		lblLogout.setBounds(542, 11, 46, 14);
		contentPane.add(lblLogout);
		
		JButton btnGenerateFee = new JButton("Generate Fee");
		btnGenerateFee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Fee f = new Fee();
				f.setVisible(true);
			}
		});
		btnGenerateFee.setBounds(444, 150, 115, 23);
		contentPane.add(btnGenerateFee);
		
		JButton btnRecord = new JButton("Record");
		btnRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Record r = new Record();
				r.setVisible(true);
			}
		});
		btnRecord.setBounds(314, 150, 89, 23);
		contentPane.add(btnRecord);
	}
}


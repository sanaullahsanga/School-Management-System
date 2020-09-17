package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import Controller.C_insert_student;
import Controller.C_insert_teacher;

import java.awt.Font;

import javax.swing.JPasswordField;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.toedter.calendar.JDateChooser;

public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_2;
	private JTextField textField_5;
	private JTextField textField_13;
	private JTextField textField_15;
	private JTextField textField_10;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
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
	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 45, 585, 430);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Student Registration", null, panel, null);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		textField.setBounds(175, 58, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(175, 89, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(437, 89, 86, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(175, 122, 86, 20);
		panel.add(textField_4);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(132, 153, 158, 82);
		panel.add(textField_6);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(437, 156, 86, 20);
		panel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(437, 201, 86, 20);
		panel.add(textField_9);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(132, 256, 53, 23);
		panel.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(187, 256, 109, 23);
		panel.add(rdbtnFemale);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(410, 294, 86, 20);
		panel.add(comboBox);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(45, 61, 85, 14);
		panel.add(lblName);
		
		JLabel lblFathersName = new JLabel("Father's Name");
		lblFathersName.setBounds(45, 92, 109, 14);
		panel.add(lblFathersName);
		
		JLabel lblFathersContact = new JLabel("Father's Contact");
		lblFathersContact.setBounds(45, 125, 109, 14);
		panel.add(lblFathersContact);
		
		JLabel lblAdress = new JLabel("Address");
		lblAdress.setBounds(45, 187, 71, 14);
		panel.add(lblAdress);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(45, 260, 71, 14);
		panel.add(lblGender);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(438, 58, 85, 20);
		panel.add(comboBox_1);
		
		JLabel lblClassName = new JLabel("Class Name");
		lblClassName.setBounds(45, 297, 85, 14);
		panel.add(lblClassName);
		
		JLabel lblSection = new JLabel("Section");
		lblSection.setBounds(316, 297, 46, 14);
		panel.add(lblSection);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(316, 61, 86, 14);
		panel.add(lblYear);
		
		JLabel lblFathersCnic = new JLabel("Father's CNIC");
		lblFathersCnic.setBounds(316, 92, 111, 14);
		panel.add(lblFathersCnic);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(316, 121, 111, 14);
		panel.add(lblDateOfBirth);
		
		JLabel lblNationality = new JLabel("Nationality");
		lblNationality.setBounds(316, 159, 99, 14);
		panel.add(lblNationality);
		
		JLabel lblReligion = new JLabel("Religion");
		lblReligion.setBounds(316, 204, 86, 14);
		panel.add(lblReligion);
		

		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBounds(175, 294, 86, 20);
		panel.add(comboBox_6);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(437, 120, 109, 20);
		panel.add(dateChooser);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String gender="";
				if (rdbtnMale.isSelected()) {
					gender = "Male";
				}
				else {
					gender = "Male";
				}
				String Year = (String) comboBox_1.getSelectedItem();
				String Name = textField.getText();
				String F_Name = textField_1.getText();
				String F_Cnic = textField_3.getText();
				String F_Contact = textField_4.getText();
				Date selectedDate = (Date) dateChooser.getDate();
			    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			    String D_o_b = df.format(selectedDate);
				String Adress = textField_6.getText();
				String Nationality = textField_8.getText();
				String Gender = gender;
				String Religion = textField_9.getText();
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				LocalDate localDate = LocalDate.now();
				String Date = dtf.format(localDate);
				//JOptionPane.showMessageDialog(null, Date);
				String Class_Name = (String) comboBox_6.getSelectedItem();
				String Section = (String) comboBox.getSelectedItem();
				C_insert_student is= new C_insert_student();
				//JOptionPane.showMessageDialog(null, Section);
				is.set_insert(Year,Name,F_Name,F_Cnic,F_Contact,D_o_b,Adress,Nationality,Gender,Religion,Date,Class_Name,Section);
				is.get_insert();
			}
		});
		btnSubmit.setBounds(241, 356, 89, 23);
		panel.add(btnSubmit);
		
		
		
		
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Teacher Registration", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(69, 73, 46, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblCnoc = new JLabel("CNIC");
		lblCnoc.setBounds(69, 118, 46, 14);
		panel_1.add(lblCnoc);
		
		JLabel lblDateOfBirth_1 = new JLabel("Date of Birth");
		lblDateOfBirth_1.setBounds(69, 158, 77, 14);
		panel_1.add(lblDateOfBirth_1);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setBounds(69, 204, 46, 14);
		panel_1.add(lblSubject);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(69, 254, 77, 14);
		panel_1.add(lblAddress);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(327, 73, 77, 14);
		panel_1.add(lblPassword);
		
		JLabel lblContactNo = new JLabel("Contact No.");
		lblContactNo.setBounds(327, 118, 91, 14);
		panel_1.add(lblContactNo);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(327, 158, 46, 14);
		panel_1.add(lblEmail);
		
		JLabel lblEducation = new JLabel("Education");
		lblEducation.setBounds(327, 204, 91, 14);
		panel_1.add(lblEducation);
		
		textField_2 = new JTextField();
		textField_2.setBounds(170, 70, 86, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(170, 115, 86, 20);
		textField_5.setColumns(10);
		panel_1.add(textField_5);
		
		textField_13 = new JTextField();
		textField_13.setBounds(170, 251, 86, 20);
		textField_13.setColumns(10);
		panel_1.add(textField_13);
		
		textField_15 = new JTextField();
		textField_15.setBounds(428, 115, 86, 20);
		textField_15.setColumns(10);
		panel_1.add(textField_15);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(170, 204, 86, 20);
		panel_1.add(comboBox_2);
		File file3 = new File("D:\\FAST NU/Smester 06/Object Oriented Analysis & Design/Lab/Eclipse Luna/New folder/school_management_system_01/subject.txt"); 
        try {
            BufferedReader br = new BufferedReader(new FileReader(file3));
            Object[] lines1 = br.lines().toArray();
            
            for(int i = 0; i < lines1.length; i++){
                String line1 = lines1[i].toString();
                comboBox_2.addItem(line1);
            }
            
        } catch (FileNotFoundException ex) {

        }
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(428, 198, 86, 20);
		panel_1.add(comboBox_3);
		File file = new File("D:\\FAST NU/Smester 06/Object Oriented Analysis & Design/Lab/Eclipse Luna/New folder/school_management_system_01/education.txt"); 
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            Object[] lines = br.lines().toArray();
            
            for(int i = 0; i < lines.length; i++){
                String line = lines[i].toString();
                comboBox_3.addItem(line);
            }
            
        } catch (FileNotFoundException ex) {
            
        }
		
		JLabel lblGender_1 = new JLabel("Gender");
		lblGender_1.setBounds(69, 307, 46, 14);
		panel_1.add(lblGender_1);
		
		textField_10 = new JTextField();
		textField_10.setBounds(428, 155, 86, 20);
		textField_10.setColumns(10);
		panel_1.add(textField_10);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(428, 251, 86, 20);
		panel_1.add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(428, 304, 86, 20);
		panel_1.add(comboBox_5);

		
		JRadioButton rdbtnMale_1 = new JRadioButton("Male");
		rdbtnMale_1.setBounds(170, 303, 53, 23);
		panel_1.add(rdbtnMale_1);
		
		JRadioButton rdbtnFemale_1 = new JRadioButton("Female");
		rdbtnFemale_1.setBounds(226, 303, 53, 23);
		panel_1.add(rdbtnFemale_1);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(170, 158, 109, 20);
		panel_1.add(dateChooser_1);
		
		JButton btnSubmit_1 = new JButton("Submit");
		btnSubmit_1.setBounds(246, 353, 89, 23);
		btnSubmit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String gender="";
				if (rdbtnMale.isSelected()) {
					gender = "Male";
				}
				else {
					gender = "Male";
				}
				String Name = textField_2.getText();
				String Pass = passwordField.getText();
				String Cnic = textField_5.getText();
				String Subject = (String) comboBox_2.getSelectedItem();
				String Education = (String) comboBox_3.getSelectedItem();
				String C_no = textField_15.getText();
				Date selectedDate = (Date) dateChooser_1.getDate();
			    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			    String D_o_b = df.format(selectedDate);
				String Adress = textField_13.getText();
				String Class = (String) comboBox_4.getSelectedItem();
				String Section = (String) comboBox_5.getSelectedItem();
				String Gender = gender;
				String Email = textField_10.getText();
				C_insert_teacher it= new C_insert_teacher();
				//JOptionPane.showMessageDialog(null, Section);
				it.set_insert(Name,Pass,Cnic,Subject,Education,C_no,D_o_b,Adress,Class,Section,Gender,Email);
				it.get_insert();
		
			}
		});
		panel_1.add(btnSubmit_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(428, 70, 86, 23);
		panel_1.add(passwordField);
		
		JLabel lblClassName_1 = new JLabel("Class Name");
		lblClassName_1.setBounds(327, 254, 77, 14);
		panel_1.add(lblClassName_1);
		
		
		
		JLabel lblSection_1 = new JLabel("Section");
		lblSection_1.setBounds(327, 307, 46, 14);
		panel_1.add(lblSection_1);
		
		
		
		
		File file1 = new File("D:\\FAST NU/Smester 06/Object Oriented Analysis & Design/Lab/Eclipse Luna/New folder/school_management_system_01/section.txt"); 
        try {
            BufferedReader br = new BufferedReader(new FileReader(file1));
            Object[] lines1 = br.lines().toArray();
            
            for(int i = 0; i < lines1.length; i++){
                String line1 = lines1[i].toString();
                comboBox.addItem(line1);
            }
            
        } catch (FileNotFoundException ex) {
            
        }
		File file4 = new File("D:\\FAST NU/Smester 06/Object Oriented Analysis & Design/Lab/Eclipse Luna/New folder/school_management_system_01/Year.txt"); 
        try {
            BufferedReader br = new BufferedReader(new FileReader(file4));
            Object[] lines1 = br.lines().toArray();
            
            for(int i = 0; i < lines1.length; i++){
                String line1 = lines1[i].toString();
                comboBox_1.addItem(line1);
            }
            
        } catch (FileNotFoundException ex) {
        }
        File file5 = new File("D:\\FAST NU/Smester 06/Object Oriented Analysis & Design/Lab/Eclipse Luna/New folder/school_management_system_01/class.txt"); 
        try {
            BufferedReader br = new BufferedReader(new FileReader(file5));
            Object[] lines1 = br.lines().toArray();
            
            for(int i = 0; i < lines1.length; i++){
                String line1 = lines1[i].toString();
                comboBox_4.addItem(line1);
            }
            
        } catch (FileNotFoundException ex) {
        }
        File file7 = new File("D:\\FAST NU/Smester 06/Object Oriented Analysis & Design/Lab/Eclipse Luna/New folder/school_management_system_01/class.txt"); 
        try {
            BufferedReader br = new BufferedReader(new FileReader(file7));
            Object[] lines1 = br.lines().toArray();
            
            for(int i = 0; i < lines1.length; i++){
                String line1 = lines1[i].toString();
                comboBox_6.addItem(line1);
            }
            
        } catch (FileNotFoundException ex) {
        }
        File file6 = new File("D:\\FAST NU/Smester 06/Object Oriented Analysis & Design/Lab/Eclipse Luna/New folder/school_management_system_01/section.txt"); 
        try {
            BufferedReader br = new BufferedReader(new FileReader(file6));
            Object[] lines1 = br.lines().toArray();
            
            for(int i = 0; i < lines1.length; i++){
                String line1 = lines1[i].toString();
                comboBox_5.addItem(line1);
            }
            
        } catch (FileNotFoundException ex) {
        }
		
		JLabel lblRegistrationForm = new JLabel("Registration Form");
		lblRegistrationForm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegistrationForm.setBounds(231, 11, 167, 23);
		contentPane.add(lblRegistrationForm);
		
		JLabel lblBack = new JLabel("Back");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				Admin a = new Admin(getTitle());
				a.setVisible(true);
			}
		});
		lblBack.setForeground(Color.RED);
		lblBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBack.setBounds(10, 17, 46, 14);
		contentPane.add(lblBack);
			}
}

package Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Backend.DBMSConnection;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.border.MatteBorder;

public class RegisterFrame extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	int xx,xy;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField address;
	private JTextField age;
	private JTextField contact;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrame frame = new RegisterFrame();
					frame.setUndecorated(true);
					frame.setLocationRelativeTo(null);
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
	public RegisterFrame() {
		setTitle("Register");
		setResizable(false);
		
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width/2 - getWidth()/2,size.height/2 - getHeight()/2);
		
		setUndecorated(true);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 712);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
				xy = e.getY();
			}
		});
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				RegisterFrame.this.setLocation(x-xx,y-xy);
			}
		});
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 140, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("  +91");
		lblNewLabel_3.setFont(new Font("Segoe UI Symbol", Font.ITALIC, 13));
		lblNewLabel_3.setBounds(10, 547, 38, 33);
		contentPane.add(lblNewLabel_3);
		
		JLabel termsValidLabel = new JLabel("");
		termsValidLabel.setForeground(Color.RED);
		termsValidLabel.setBounds(269, 595, 91, 25);
		contentPane.add(termsValidLabel);
		
		JPanel panel = new JPanel();
	
		
		panel.setBackground(new Color(102, 51, 102));
		panel.setBounds(419, -21, 355, 752);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("X");
		lblNewLabel_1_1.setBounds(322, 22, 23, 38);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
				
			}
		});
		lblNewLabel_1_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1_1.setForeground(SystemColor.controlHighlight);
		lblNewLabel_1_1.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(RegisterFrame.class.getResource("/Frontend/Images/WISE_TRIPS-modified_125x125.png")));
		lblNewLabel_2.setBounds(111, 320, 159, 125);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Wise Trips");
		lblNewLabel_1.setFont(new Font("Countryside", Font.BOLD | Font.ITALIC, 38));
		lblNewLabel_1.setForeground(SystemColor.control);
		lblNewLabel_1.setBounds(75, 144, 270, 68);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(RegisterFrame.class.getResource("/Frontend/Images/alistair-rWR9LvWFoBE-unsplash_540x765.jpg")));
		lblNewLabel.setBounds(-83, 22, 438, 730);
		panel.add(lblNewLabel);
		
		JLabel lbUsername = new JLabel("NAME");
		lbUsername.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbUsername.setBounds(51, 100, 72, 27);
		contentPane.add(lbUsername);
		
		name = new JTextField();
		name.setBounds(51, 129, 309, 33);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lbEmail = new JLabel("USERNAME");
		lbEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbEmail.setBounds(51, 170, 119, 27);
		contentPane.add(lbEmail);
		
		username = new JTextField();
		username.setBounds(51, 196, 309, 33);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(51, 240, 119, 27);
		contentPane.add(lblPassword);
		
		JLabel lbConfirmPassword = new JLabel("CONFIRM PASSWORD");
		lbConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbConfirmPassword.setBounds(51, 310, 172, 27);
		contentPane.add(lbConfirmPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(51, 266, 309, 33);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(51, 337, 309, 33);
		contentPane.add(passwordField_1);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(51, 407, 309, 47);
		contentPane.add(address);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAddress.setBounds(51, 381, 119, 27);
		contentPane.add(lblAddress);
		
		JLabel lblAge = new JLabel("AGE:");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAge.setBounds(51, 471, 45, 33);
		contentPane.add(lblAge);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(89, 475, 45, 27);
		contentPane.add(age);
		
		JLabel lblGender = new JLabel("GENDER:");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGender.setBounds(163, 471, 58, 33);
		contentPane.add(lblGender);
		
		JRadioButton malebutton = new JRadioButton("Male");
		malebutton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		malebutton.setBackground(Color.WHITE);
		malebutton.setBounds(221, 476, 58, 23);
		contentPane.add(malebutton);
		
		JRadioButton femalebutton = new JRadioButton("Female");
		femalebutton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		femalebutton.setBackground(Color.WHITE);
		femalebutton.setBounds(281, 476, 72, 23);
		contentPane.add(femalebutton);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(malebutton);
		bg.add(femalebutton);
		
		
		contact = new JTextField();
		contact.setColumns(10);
		contact.setBounds(51, 547, 309, 33);
		contentPane.add(contact);
		
		JLabel lblContact = new JLabel("CONTACT");
		lblContact.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblContact.setBounds(51, 521, 119, 27);
		contentPane.add(lblContact);
		
		JCheckBox chckbxTerms = new JCheckBox("I accept the terms and conditions");
		chckbxTerms.setBackground(Color.WHITE);
		chckbxTerms.setBounds(51, 597, 218, 23);
		contentPane.add(chckbxTerms);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 102, 102));
		separator.setBounds(22, 85, 371, 4);
		contentPane.add(separator);
		
		Button button = new Button("Register");
		button.setBounds(51, 637, 309, 40);
		contentPane.add(button);
		
		JLabel lblcontact = new JLabel("");
		lblcontact.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblcontact.setForeground(Color.RED);
		lblcontact.setBounds(118, 528, 38, 14);
		contentPane.add(lblcontact);
		
		JLabel lblage = new JLabel("");
		lblage.setForeground(Color.RED);
		lblage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblage.setBounds(41, 481, 38, 14);
		contentPane.add(lblage);
		
		JLabel lblgender = new JLabel("");
		lblgender.setForeground(Color.RED);
		lblgender.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblgender.setBounds(152, 481, 18, 14);
		contentPane.add(lblgender);
		
		JLabel lbladdress = new JLabel("");
		lbladdress.setForeground(Color.RED);
		lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbladdress.setBounds(118, 388, 38, 14);
		contentPane.add(lbladdress);
		
		JLabel lblpass = new JLabel("");
		lblpass.setForeground(Color.RED);
		lblpass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblpass.setBounds(133, 247, 38, 14);
		contentPane.add(lblpass);
		
		JLabel lblusername = new JLabel("");
		lblusername.setForeground(Color.RED);
		lblusername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblusername.setBounds(132, 177, 38, 14);
		contentPane.add(lblusername);
		
		JLabel lblname = new JLabel("");
		lblname.setForeground(Color.RED);
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblname.setBounds(96, 107, 38, 14);
		contentPane.add(lblname);
		
		JLabel lblconfirmpass = new JLabel("");
		lblconfirmpass.setForeground(Color.RED);
		lblconfirmpass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblconfirmpass.setBounds(194, 317, 38, 14);
		contentPane.add(lblconfirmpass);
		
		JLabel useravail = new JLabel("");
		useravail.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		useravail.setBounds(237, 177, 123, 14);
		contentPane.add(useravail);
		
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String gender;
				if(malebutton.isSelected())
					   gender="Male";
				  else
					   gender="Female";
				String password = new String(passwordField.getPassword());
				String confirmpassword = new String(passwordField_1.getPassword());
				
					DBMSConnection db = null;int temp = 0,Reg=0;
					try {
						db = new DBMSConnection();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						temp = db.CheckUser(username.getText());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					if(name.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null,"Please Enter your Name!!");
						lblname.setText("*");
					}
					else if(username.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null,"Please Enter your username!!");
						lblusername.setText("*");
					}
					
					else if(passwordField.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null,"Please Enter your password!!");
						lblpass.setText("*");
					}
					else if(passwordField_1.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null,"Please Enter your conifrm password!!");
						lblconfirmpass.setText("*");
					}
					
					else if(address.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null,"Please Enter your address!!");
						lbladdress.setText("*");
					}
					else if(age.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null,"Please Enter your age!!");
						lblage.setText("*");
					}
					else if(bg.getSelection()==null)
					{
						JOptionPane.showMessageDialog(null,"Please select your Gender!!");
						lblgender.setText("*");
					}
					else if(contact.getText().equals(""))
					{
						
						JOptionPane.showMessageDialog(null,"Please Enter your Mobile Number!!");
						lblcontact.setText("*");
						
					}
					else
					{}
					
					if(temp==1 && !(username.getText().equals("")))
					{
						
						useravail.setText("Username available");
						useravail.setForeground(new Color(60, 179, 113));
					}
					else 
					{	if(!(username.getText().equals(""))){
						JOptionPane.showMessageDialog(null,"Username Not Available!!");
						useravail.setText("Not available");
						useravail.setForeground(Color.RED);}
					}
					if(!(chckbxTerms.isSelected()) )
				 	{
						JOptionPane.showMessageDialog(null,"Please Accept Our terms and conditions!!");
					 	termsValidLabel.setText("*required");
					}
					else if(password.equals(confirmpassword))
					{
						if(temp==1)
						{
							String m;
							if(gender=="Male") 
								m = "Mr.";
							else
								m ="Ms.";
							int x=JOptionPane.showConfirmDialog(null, "Do You Want To Continue "+m+name.getText());
							if (x==0)
							{
									try {
										Reg=db.createUser(username.getText(), name.getText(), password, address.getText(), Integer.parseInt(age.getText()), gender, contact.getText());
									} catch (NumberFormatException | SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									if(Reg==1)
										JOptionPane.showMessageDialog(null,"Registration Successfull!!");
									else
										JOptionPane.showMessageDialog(null,"Registration failed due to some Technical Error!!");
							}
						}
						else
							JOptionPane.showMessageDialog(null,"Registration Failed!!");
						
					}
				  else
				  {
					  JOptionPane.showMessageDialog(null,"Entered Password aren't matching!!! ");
				  }
					
					try {
						db.closecon();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				  	
				
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 19));
		button.setBackground(new Color(255, 127, 80));
		
		
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new Home().setVisible(true);
			}
		});
		lblNewLabel_2_1.setIcon(new ImageIcon(RegisterFrame.class.getResource("/Frontend/Images/icons8-go-back-34.png")));
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(10, 11, 34, 33);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("WISE TRIPS Registration Portal");
		lblNewLabel_1_2.setForeground(new Color(51, 153, 204));
		lblNewLabel_1_2.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(22, 40, 398, 53);
		contentPane.add(lblNewLabel_1_2);
		
		
		
	
		
		
		
		
		
		
	}
}

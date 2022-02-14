package Frontend;
import Backend.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.Cursor;
import java.awt.Point;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	int xx,xy;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setTitle("Login");
		setResizable(false);
		
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width/2 - getWidth()/2,size.height/2 - getHeight()/2);
		
		setUndecorated(true);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 375);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
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
				LoginFrame.this.setLocation(x-xx,y-xy);
			}
		});
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 139, 139)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
	
		
		panel.setBackground(new Color(102, 51, 102));
		panel.setBounds(0, 0, 329, 382);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new Home().setVisible(true);
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon(LoginFrame.class.getResource("/Frontend/Images/icons8-back-30.png")));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(10, 11, 30, 30);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(-17, 0, 359, 382);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/Frontend/Images/WISE_TRIPS_1_360x385.png")));
		
		JCheckBox chckbx_ShowPassword = new JCheckBox("Show Password");
		chckbx_ShowPassword.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(chckbx_ShowPassword.isSelected())
					passwordField.setEchoChar((char)0);
				else
					passwordField.setEchoChar('*');
			}
		});
		chckbx_ShowPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbx_ShowPassword.setBackground(new Color(255, 255, 255));
		chckbx_ShowPassword.setBounds(376, 250, 119, 23);
		contentPane.add(chckbx_ShowPassword);
		
		JLabel starlbl1 = new JLabel("");
		starlbl1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		starlbl1.setForeground(Color.RED);
		starlbl1.setBounds(456, 100, 117, 27);
		contentPane.add(starlbl1);

		JLabel starlbl2 = new JLabel("");
		starlbl2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		starlbl2.setForeground(Color.RED);
		starlbl2.setBounds(456, 183, 103, 27);
		contentPane.add(starlbl2);
		
		
		Button button = new Button("Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBMSConnection db = null;int temp = 0;
				try {
					db = new DBMSConnection();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					 temp =db.userLogin(usernameField.getText(),new String(passwordField.getPassword()));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(usernameField.getText().equals("")) 
				{
					starlbl1.setText("*required");
					
				}
				if(new String(passwordField.getPassword()).equals(""))
				{
					starlbl2.setText("*required");
				}
				else if(temp==1)
				{
					JOptionPane.showMessageDialog(contentPane, "Welcome "+usernameField.getText());
					setVisible(false);
					new TrainFrame(usernameField.getText()).setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(contentPane, "Invalid Crediantials!!");
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
		button.setBackground(new Color(0, 153, 153));
		button.setBounds(376, 301, 291, 39);
		contentPane.add(button);
		
		usernameField = new JTextField();
		usernameField.setBounds(376, 128, 291, 33);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lbUsername = new JLabel("USERNAME");
		lbUsername.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbUsername.setBounds(376, 100, 119, 27);
		contentPane.add(lbUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(376, 183, 153, 27);
		contentPane.add(lblPassword);
		
		JLabel lblNewLabel_1_1 = new JLabel("X");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
				
			}
		});
		lblNewLabel_1_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1_1.setForeground(new Color(255, 0, 102));
		lblNewLabel_1_1.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(699, 0, 20, 22);
		contentPane.add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(376, 210, 291, 33);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("WISE TRIPS Login Portal");
		lblNewLabel_1.setForeground(new Color(51, 153, 204));
		lblNewLabel_1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(360, 11, 329, 62);
		contentPane.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 102, 102));
		separator.setBounds(360, 66, 329, 2);
		contentPane.add(separator);
		
		
	}
}

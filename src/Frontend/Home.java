package Frontend;

import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Toolkit;

import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Home extends JFrame {
	int xx,xy;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setTitle("WISE-TRIPS");
		setResizable(false);
		
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width/2 - getWidth()/2,size.height/2 - getHeight()/2);
		
		setUndecorated(true);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
				xy = e.getY();
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				Home.this.setLocation(x-xx,y-xy);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 736);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("India's Next E-Gen Ticket Booking");
		lblNewLabel_4.setFont(new Font("Rockwell Nova", Font.ITALIC, 17));
		lblNewLabel_4.setForeground(new Color(211, 211, 211));
		lblNewLabel_4.setBounds(135, 359, 294, 32);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_1.setFont(new Font("Segoe UI Emoji", Font.BOLD, 18));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setForeground(UIManager.getColor("CheckBox.background"));
		lblNewLabel_1.setBounds(520, 0, 39, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Home.class.getResource("/Frontend/Images/WISE_TRIPS-modified_2_180x180.png")));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(188, 85, 182, 183);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Welcome to Wise Trips");
		lblNewLabel_3.setBackground(new Color(220, 220, 220));
		lblNewLabel_3.setFont(new Font("Countryside", Font.BOLD, 30));
		lblNewLabel_3.setForeground(new Color(211, 211, 211));
		lblNewLabel_3.setBounds(109, 298, 417, 63);
		contentPane.add(lblNewLabel_3);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(128, 128, 128));
		separator.setBounds(109, 352, 338, 25);
		contentPane.add(separator);
		
		Button buttonLogin = new Button("Login");
		buttonLogin.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 19));
		buttonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new LoginFrame().setVisible(true);
				
			}
		});
		buttonLogin.setForeground(Color.WHITE);
		buttonLogin.setBackground(new Color(255, 102, 0));
		buttonLogin.setBounds(156, 450, 242, 55);
		contentPane.add(buttonLogin);
		
		Button buttonRegister = new Button("Register");
		buttonRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new RegisterFrame().setVisible(true);
			}
		});
		buttonRegister.setForeground(Color.WHITE);
		buttonRegister.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 19));
		buttonRegister.setBackground(new Color(51, 153, 102));
		buttonRegister.setBounds(156, 538, 242, 55);
		contentPane.add(buttonRegister);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/Frontend/Images/derek-story-Kd7Fdg337Qk-unsplash_545x767.jpg")));
		lblNewLabel.setBounds(0, -41, 543, 802);
		contentPane.add(lblNewLabel);
	}
}

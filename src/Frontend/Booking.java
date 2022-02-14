package Frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Button;
import javax.swing.border.MatteBorder;

import Backend.DBMSConnection;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Booking extends JFrame {

	@SuppressWarnings("unused")
	private JPanel contentPane;
	int xx,xy;
	private JPanel contentPane_1;
	private JLabel lblNewLabel_2_1;
	private JLabel lblTicketConfirmation;
	private JLabel lblNewLabel;
	private JSeparator separator;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField textField;
	private JTextField txtMstyagandhaExpress;
	private JTextField txtMangaluru;
	private JTextField txtMumbai;
	private JTextField no_of_pass;
	private Button button;
	private JLabel lblFare;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String[] searcheds = null;
					String zz = null;
					Booking frame = new Booking(zz, searcheds);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param username_login 
	 */
	public Booking(String username_login, String[] searcheds) {
		setTitle("Booking");
		setUndecorated(true);
		
		String train_no = searcheds[0];
		String train_name = searcheds[1];
		String source = searcheds[2];
		String destination = searcheds[3];
		String arrival = searcheds[4];
		String depart = searcheds[5];
		String price = searcheds[7];

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 475);
		contentPane = new JPanel();
		contentPane_1 = new JPanel();
		contentPane_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
				xy = e.getY();
			}
		});
		contentPane_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				Booking.this.setLocation(x-xx,y-xy);
			}
		});
		contentPane_1.setBackground(new Color(255, 255, 255));
		contentPane_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(204, 51, 51)));
		setContentPane(contentPane_1);
		contentPane_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("X");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		lblFare = new JLabel();
		lblFare.setForeground(new Color(255, 102, 0));
		lblFare.setFont(new Font("Arial Nova Cond", Font.BOLD, 39));
		lblFare.setBounds(140, 367, 128, 50);
		contentPane_1.add(lblFare);
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(454, 0, 23, 38);
		contentPane_1.add(lblNewLabel_1_1);
		
		lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new Searched_train(username_login, searcheds).setVisible(true);
			}
		});
		lblNewLabel_2_1.setIcon(new ImageIcon(Booking.class.getResource("/Frontend/Images/icons8-go-back-34.png")));
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(10, 11, 34, 33);
		contentPane_1.add(lblNewLabel_2_1);
		
		lblTicketConfirmation = new JLabel("TICKET CONFIRMATION");
		lblTicketConfirmation.setForeground(new Color(0, 51, 102));
		lblTicketConfirmation.setFont(new Font("Arial Black", Font.BOLD, 26));
		lblTicketConfirmation.setBounds(52, 28, 373, 50);
		contentPane_1.add(lblTicketConfirmation);
		
		lblNewLabel = new JLabel("USER : "+username_login);
		lblNewLabel.setForeground(new Color(46, 139, 87));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(10, 86, 199, 20);
		contentPane_1.add(lblNewLabel);
		
		separator = new JSeparator();
		separator.setBounds(-12, 74, 500, 2);
		contentPane_1.add(separator);
		
		lblNewLabel_1 = new JLabel("Train No :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(24, 137, 109, 25);
		contentPane_1.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Train Name :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setBounds(24, 179, 109, 25);
		contentPane_1.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("From :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_3.setBounds(24, 215, 109, 25);
		contentPane_1.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("To :");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_4.setBounds(24, 259, 109, 25);
		contentPane_1.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Enter the No of Passengers :");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_5.setBounds(24, 308, 211, 25);
		contentPane_1.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setForeground(new Color(204, 0, 51));
		textField.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		textField.setText("  "+searcheds[0]);
		textField.setEditable(false);
		textField.setBounds(200, 138, 211, 25);
		contentPane_1.add(textField);
		textField.setColumns(10);
		
		txtMstyagandhaExpress = new JTextField();
		txtMstyagandhaExpress.setForeground(new Color(204, 0, 51));
		txtMstyagandhaExpress.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		txtMstyagandhaExpress.setText("  "+searcheds[1]);
		txtMstyagandhaExpress.setEditable(false);
		txtMstyagandhaExpress.setColumns(10);
		txtMstyagandhaExpress.setBounds(200, 182, 211, 25);
		contentPane_1.add(txtMstyagandhaExpress);
		
		txtMangaluru = new JTextField();
		txtMangaluru.setForeground(new Color(204, 0, 51));
		txtMangaluru.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		txtMangaluru.setText("  "+searcheds[2]);
		txtMangaluru.setEditable(false);
		txtMangaluru.setColumns(10);
		txtMangaluru.setBounds(200, 218, 211, 25);
		contentPane_1.add(txtMangaluru);
		
		txtMumbai = new JTextField();
		txtMumbai.setForeground(new Color(204, 0, 51));
		txtMumbai.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		txtMumbai.setText("  "+searcheds[3]);
		txtMumbai.setEditable(false);
		txtMumbai.setColumns(10);
		txtMumbai.setBounds(200, 262, 211, 25);
		contentPane_1.add(txtMumbai);
		
		no_of_pass = new JTextField();
		no_of_pass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblFare.setText("\u20B9"+(Integer.parseInt(no_of_pass.getText()) * Integer.parseInt(searcheds[7])));
			}
		});
		no_of_pass.setColumns(10);
		no_of_pass.setBounds(247, 310, 164, 25);
		contentPane_1.add(no_of_pass);
		
		button = new Button("Pay Now");
		button.addActionListener(new ActionListener() {
			private int r,x;

			public void actionPerformed(ActionEvent e) {
				if(no_of_pass.getText().isBlank())
				{
					JOptionPane.showMessageDialog(contentPane, "Please Enter the No of Passengers!!");
				}
				else
				{
					DBMSConnection db =null;
					try {
						db = new DBMSConnection();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					int b_price=(Integer.parseInt(no_of_pass.getText()) * Integer.parseInt(searcheds[7]));
					try {
						 x = db.ticket(username_login, b_price);
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						r = db.booking(username_login, b_price, Integer.parseInt(searcheds[0]),Integer.parseInt(no_of_pass.getText()));
					} catch (NumberFormatException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(r==1 && x==1)
					{
//					try {
//						Desktop.getDesktop().browse(new URL("http://www.google.com").toURI());
//					} catch (IOException | URISyntaxException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
						int var = JOptionPane.showConfirmDialog(contentPane, "Do You want to Confirm Your Booking?");
						if(var==0)
						{
							JOptionPane.showMessageDialog(contentPane, "Thank You for Your Payment!!");
						}
						else
						{
							JOptionPane.showMessageDialog(contentPane, "Payment Cancelled");
						}
							
				}
			
				else
				{
					JOptionPane.showMessageDialog(contentPane, "Payment is cancelled due to some Techinal Error!!");
				}
			}
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Arial", Font.PLAIN, 26));
		button.setBackground(new Color(0, 204, 153));
		button.setBounds(274, 367, 137, 80);
		contentPane_1.add(button);
		
		lblNewLabel_7 = new JLabel("Total Fare :");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_7.setBounds(31, 384, 102, 25);
		contentPane_1.add(lblNewLabel_7);
		
		lblNewLabel_6 = new JLabel("Press Enter To see Ticket Fare");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_6.setBounds(249, 342, 162, 14);
		contentPane_1.add(lblNewLabel_6);
	}

}

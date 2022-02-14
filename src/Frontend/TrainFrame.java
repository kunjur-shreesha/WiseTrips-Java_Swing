package Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JSeparator;
import com.toedter.calendar.JDateChooser;

import Backend.DBMSConnection;

import java.awt.Button;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TrainFrame extends JFrame {

	private JPanel contentPane;
	int xx,xy;
	private JPanel contentPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String String = null;
					TrainFrame frame = new TrainFrame(String);
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
	public TrainFrame(String username_login) {
		setTitle("Time-Table");
//		if (username_login==null)
//			setVisible(false);
//		else {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 633);
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
				TrainFrame.this.setLocation(x-xx,y-xy);
			}
		});
		contentPane_1.setBackground(Color.WHITE);
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
		lblNewLabel_1_1.setForeground(SystemColor.controlHighlight);
		lblNewLabel_1_1.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(547, 0, 23, 38);
		contentPane_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TrainFrame.class.getResource("/Frontend/Images/WISE_TRIPS_330_x_760_px_575_x_131_px_575x131.png")));
		lblNewLabel.setBounds(0, 0, 588, 131);
		contentPane_1.add(lblNewLabel);
		
		JComboBox<String> from_train = new JComboBox<String>();
		from_train.setFont(new Font("Century", Font.PLAIN, 17));
		from_train.setModel(new DefaultComboBoxModel(new String[] {"Select", "Mangaluru", "Howrah", "Chennai", "Bengaluru", "Pune", "Madgaon", "Ernakulam", "Kolkata", "Bhuvaneshwar"}));
		from_train.setBackground(new Color(255, 255, 255));
		from_train.setBounds(127, 268, 315, 39);
		contentPane_1.add(from_train);
		
		JComboBox<String> to_train = new JComboBox<String>();
		to_train.setModel(new DefaultComboBoxModel(new String[] {"Select", "Mumbai LTT", "New Delhi", "Coimbatore", "Nagpur", "Mumbai CST", "Nizamuddin", "Dadar", "Patna"}));
		to_train.setFont(new Font("Century", Font.PLAIN, 17));
		to_train.setBackground(Color.WHITE);
		to_train.setBounds(127, 355, 315, 39);
		contentPane_1.add(to_train);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("BOOK TICKET");
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.BOLD, 40));
		lblNewLabel_1.setForeground(new Color(0, 102, 204));
		lblNewLabel_1.setBounds(183, 166, 238, 39);
		contentPane_1.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 51, 102));
		separator.setBounds(183, 204, 238, 2);
		contentPane_1.add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("From:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(127, 237, 46, 20);
		contentPane_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("To:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(127, 324, 46, 20);
		contentPane_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Day:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_1.setBounds(127, 416, 46, 20);
		contentPane_1.add(lblNewLabel_2_1_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(127, 447, 315, 39);
		contentPane_1.add(dateChooser);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			private String[] searcheds;

			public void actionPerformed(ActionEvent e) {
				String from = (String) from_train.getSelectedItem();
				String to = (String) to_train.getSelectedItem();
				String date = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText()+"" ;
				DBMSConnection db = null;
				try {
					db = new DBMSConnection();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					searcheds = db.trainSearch(from, to);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(from.equals("Select")||to.equals("Select")||date.isBlank())
				{
					JOptionPane.showMessageDialog(contentPane, "ALL FIELDS ARE REQUIRED");
				}
				else {
					if(searcheds==null)
				{
					JOptionPane.showMessageDialog(contentPane, "0 Trains Found");
				}
				else
				{
					setVisible(false);
					new Searched_train(username_login,searcheds).setVisible(true);
				}
			}
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(51, 51, 204));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnNewButton.setBounds(183, 528, 191, 39);
		contentPane_1.add(btnNewButton);

		JLabel lblNewLabel_3_1 = new JLabel("Logout");
		lblNewLabel_3_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DBMSConnection Db = null;
				
				try {
					Db = new DBMSConnection();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			try {
				Db.closecon();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			setVisible(false);
			new Home().setVisible(true);
			}
		});
		
		
		JLabel lblNewLabel_3 = new JLabel("USER : "+username_login);
		lblNewLabel_3.setForeground(new Color(46, 139, 87));
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_3.setBounds(10, 135, 199, 20);
		contentPane_1.add(lblNewLabel_3);
		
		
		lblNewLabel_3_1.setForeground(new Color(178, 34, 34));
		lblNewLabel_3_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(510, 136, 60, 20);
		contentPane_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4 = new JLabel("Click Here : TIME TABLE");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TIME_TABLE().setVisible(true);
			}
		});
		lblNewLabel_4.setForeground(new Color(255, 0, 102));
		lblNewLabel_4.setFont(new Font("Arial Nova Cond", Font.BOLD, 15));
		lblNewLabel_4.setBounds(10, 608, 179, 14);
		contentPane_1.add(lblNewLabel_4);
	}
}
//}

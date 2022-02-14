package Frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Button;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Searched_train extends JFrame {

	@SuppressWarnings("unused")
	private JPanel contentPane;
	int xx,xy;
	private JPanel contentPane_1;
	private JTextField txtField_train_no;
	private JLabel lbl_Header;
	private JLabel lblTrainName;
	private JLabel lblDepature;
	private JLabel lblArrival;
	private JLabel lblTrainNo;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JLabel lblTrain_Name;
	private JLabel lblDept;
	private JLabel lblArrival_1;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblDuration;
	private JLabel lblFrom;
	private JLabel lblTo;
	private JLabel lblNewLabel_8;
	private JTextField txtRunningDays;
	private Button button;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String[] searcheds = null;
					String zz = null;
					Searched_train frame = new Searched_train(zz, searcheds);
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
	public Searched_train(String username_login, String[] searcheds) {
		setTitle("Search Results");
		
		String train_no = searcheds[0];
		String train_name = searcheds[1];
		String source = searcheds[2];
		String destination = searcheds[3];
		String arrival = searcheds[4];
		String depart = searcheds[5];
		String running = searcheds[6];
		String price = searcheds[7];
		LocalTime time1 = LocalTime.of(Integer.parseInt(arrival.substring(0, 2)), 00);
        LocalTime time2 = LocalTime.of(Integer.parseInt(depart.substring(0, 2)), 22);
  
        // Calculating the difference in Hours
        long hours = ChronoUnit.HOURS.between(time1, time2);
  
        // Calculating the difference in Minutes
        long minutes
            = ChronoUnit.MINUTES.between(time1, time2) % 60;
  
		
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 946, 327);
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
				Searched_train.this.setLocation(x-xx,y-xy);
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
		
		lblNewLabel_9 = new JLabel(Math.abs(minutes)+" MINS");
		lblNewLabel_9.setForeground(new Color(204, 102, 0));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_9.setBounds(617, 183, 68, 14);
		contentPane_1.add(lblNewLabel_9);
		
		lblNewLabel_5 = new JLabel(Math.abs(hours)+" HOURS");
		lblNewLabel_5.setForeground(new Color(204, 102, 0));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(611, 158, 74, 14);
		contentPane_1.add(lblNewLabel_5);
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(914, 0, 23, 38);
		contentPane_1.add(lblNewLabel_1_1);
		
		txtField_train_no = new JTextField();
		txtField_train_no.setBackground(new Color(220, 220, 220));
		txtField_train_no.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 24));
		txtField_train_no.setEditable(false);
		txtField_train_no.setText(train_no);
		txtField_train_no.setBounds(28, 163, 68, 31);
		contentPane_1.add(txtField_train_no);
		txtField_train_no.setColumns(10);
		
		lbl_Header = new JLabel(source+" To "+destination+" Available Trains");
		lbl_Header.setForeground(new Color(0, 128, 128));
		lbl_Header.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 34));
		lbl_Header.setBounds(182, 23, 570, 31);
		contentPane_1.add(lbl_Header);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(182, 65, 570, 1);
		contentPane_1.add(separator);
		
		lblTrainName = new JLabel("Train Name");
		lblTrainName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTrainName.setBounds(204, 102, 98, 24);
		contentPane_1.add(lblTrainName);
		
		lblDepature = new JLabel("Depature");
		lblDepature.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblDepature.setBounds(440, 102, 98, 24);
		contentPane_1.add(lblDepature);
		
		lblArrival = new JLabel("Arrival");
		lblArrival.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblArrival.setBounds(773, 102, 98, 24);
		contentPane_1.add(lblArrival);
		
		lblTrainNo = new JLabel("Train No");
		lblTrainNo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTrainNo.setBounds(28, 102, 98, 24);
		contentPane_1.add(lblTrainNo);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(25, 128, 893, 9);
		contentPane_1.add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(25, 130, 893, 9);
		contentPane_1.add(separator_2);
		
		lblTrain_Name = new JLabel(train_name);
		lblTrain_Name.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTrain_Name.setBounds(157, 163, 226, 31);
		contentPane_1.add(lblTrain_Name);
		
		lblDept = new JLabel(arrival);
		lblDept.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		lblDept.setBounds(451, 163, 62, 31);
		contentPane_1.add(lblDept);
		
		lblArrival_1 = new JLabel(depart);
		lblArrival_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		lblArrival_1.setBounds(773, 164, 62, 31);
		contentPane_1.add(lblArrival_1);
		
		lblNewLabel_4 = new JLabel("------------------------------");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(553, 163, 180, 31);
		contentPane_1.add(lblNewLabel_4);
		
		lblDuration = new JLabel("Duration");
		lblDuration.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblDuration.setBounds(607, 102, 90, 24);
		contentPane_1.add(lblDuration);
		
		lblFrom = new JLabel(source.toUpperCase());
		lblFrom.setForeground(new Color(178, 34, 34));
		lblFrom.setFont(new Font("Dubai", Font.BOLD, 17));
		lblFrom.setBounds(428, 193, 133, 24);
		contentPane_1.add(lblFrom);
		
		lblTo = new JLabel(destination.toUpperCase());
		lblTo.setForeground(new Color(0, 0, 139));
		lblTo.setFont(new Font("Dubai", Font.BOLD, 17));
		lblTo.setBounds(768, 193, 103, 24);
		contentPane_1.add(lblTo);
		
		lblNewLabel_8 = new JLabel("Running Days : ");
		lblNewLabel_8.setFont(new Font("Simplified Arabic", Font.BOLD, 18));
		lblNewLabel_8.setBounds(25, 238, 133, 27);
		contentPane_1.add(lblNewLabel_8);
		
		txtRunningDays = new JTextField();
		txtRunningDays.setForeground(new Color(255, 255, 255));
		txtRunningDays.setBackground(new Color(102, 102, 204));
		txtRunningDays.setEditable(false);
		txtRunningDays.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		txtRunningDays.setText("  "+running);
		txtRunningDays.setBounds(157, 238, 249, 27);
		contentPane_1.add(txtRunningDays);
		txtRunningDays.setColumns(10);
		
		button = new Button("BOOK NOW");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Booking(username_login, searcheds).setVisible(true);
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 19));
		button.setBackground(new Color(51, 153, 102));
		button.setBounds(747, 258, 147, 45);
		contentPane_1.add(button);
		
		lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new TrainFrame(username_login).setVisible(true);
			}
		});
		lblNewLabel_2_1.setIcon(new ImageIcon(Searched_train.class.getResource("/Frontend/Images/icons8-go-back-34.png")));
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(10, 11, 34, 33);
		contentPane_1.add(lblNewLabel_2_1);
		
		lblNewLabel = new JLabel("\u20B9"+price);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Arial Nova Cond", Font.BOLD, 27));
		lblNewLabel.setBounds(167, 276, 74, 30);
		contentPane_1.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Ticket Fare :");
		lblNewLabel_1.setFont(new Font("Simplified Arabic", Font.BOLD, 18));
		lblNewLabel_1.setBounds(50, 279, 133, 27);
		contentPane_1.add(lblNewLabel_1);
	}

}

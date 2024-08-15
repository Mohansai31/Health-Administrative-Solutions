
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class home1 {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home1 window = new home1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public home1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().setBackground(new Color(0, 255, 255));
		frame.setBounds(100, 100, 756, 677);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JButton btnNewButton = new JButton("Add New Patient Record\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AddPatientinformation adp = new AddPatientinformation();
				adp.frame.setVisible(true);
		
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 0));
		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		btnNewButton.setBounds(700, 250, 300, 40);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("See Patient Information");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				showrecord shw=new showrecord();
				shw.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setForeground(new Color(255, 255, 0));
		btnNewButton_1.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		btnNewButton_1.setBounds(700, 350, 300, 40);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Remove Patient Information");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				removepatientinformation rem=new removepatientinformation();
				rem.frame.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		btnNewButton_2.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		btnNewButton_2.setForeground(new Color(255, 255, 0));
		btnNewButton_2.setBounds(700, 450, 300, 40);
		frame.getContentPane().add(btnNewButton_2);
		

		// add doctor
		JButton btnNewButton_cd = new JButton("Add Doctor  \r\n");
		btnNewButton_cd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AddDoctors a = new AddDoctors();
				a.frame.setVisible(true);
		
			}
		});
		btnNewButton_cd.setBackground(new Color(0, 0, 0));
		btnNewButton_cd.setForeground(new Color(255, 255, 0));
		btnNewButton_cd.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		btnNewButton_cd.setBounds(700, 550, 300, 40);
		frame.getContentPane().add(btnNewButton_cd);
      // Display doctor
		JButton btnNewButton_sd = new JButton("Search Doctors  \r\n");
		btnNewButton_sd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				showDoctors a = new showDoctors();
				a.frame.setVisible(true);
				
		
			}
		});
		btnNewButton_sd.setBackground(new Color(0, 0, 0));
		btnNewButton_sd.setForeground(new Color(255, 255, 0));
		btnNewButton_sd.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		btnNewButton_sd.setBounds(700, 650, 300, 40);
		frame.getContentPane().add(btnNewButton_sd);

		//Remove Doctor
		JButton btnNewButton_rd = new JButton("Remove Doctor  \r\n");
		btnNewButton_rd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				removDoct a = new removDoct();
				a.frame.setVisible(true);
		
			}
		});
		btnNewButton_rd.setBackground(new Color(0, 0, 0));
		btnNewButton_rd.setForeground(new Color(255, 255, 0));
		btnNewButton_rd.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		btnNewButton_rd.setBounds(700, 750, 300, 40);
		frame.getContentPane().add(btnNewButton_rd);


			JButton btnNewButton_dd = new JButton("Display Doctors  \r\n");
		btnNewButton_dd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				DisplayDoctors a = new DisplayDoctors();
				a.frame.setVisible(true);
			}
		});
		btnNewButton_dd.setBackground(new Color(0, 0, 0));
		btnNewButton_dd.setForeground(new Color(255, 255, 0));
		btnNewButton_dd.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		btnNewButton_dd.setBounds(700, 850, 300, 40);
		frame.getContentPane().add(btnNewButton_dd);

		
		JButton btnNewButton_6 = new JButton("LOGOUT");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null,"Do you really want to close application","Select",JOptionPane.YES_NO_OPTION);
				if(a==0) {
					
					frame.dispose();
					Login lg=new Login();
					lg.frame.setVisible(true);
				}
			}
		});
		btnNewButton_6.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		btnNewButton_6.setBackground(new Color(255, 255, 0));
		btnNewButton_6.setForeground(new Color(255, 0, 0));
		btnNewButton_6.setBounds(700, 958, 300, 40);
		frame.getContentPane().add(btnNewButton_6);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("m.png"));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		lblNewLabel.setBounds(0, 0, screenSize.width, 1000);
	
		frame.getContentPane().add(lblNewLabel);
	}
}

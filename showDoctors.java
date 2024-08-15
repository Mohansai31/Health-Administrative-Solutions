import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class showDoctors {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel_4;
	private JTextField textField_4;
	private JLabel lblNewLabel_5;
	private JTextField textField_5;
	private JLabel lblNewLabel_6;
	private JTextField textField_6;
	private JLabel lblNewLabel_7;
	private JTextField textField_7;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showDoctors window = new showDoctors();
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
	public showDoctors() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 1289, 1001);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" Enter Doctor ID :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setBounds(432, 60, 232, 26);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField.setForeground(new Color(0, 255, 255));
		textField.setBackground(Color.BLACK);
		textField.setBounds(704, 60, 149, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton(" Click to View Record");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String doctorId = textField.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Mohan@473");
					
					if (textField.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please Fill The Doctor ID");
						textField.setText("");
					} else {
						PreparedStatement st = con.prepareStatement("SELECT doctorId FROM doctors WHERE doctor_id=?");
						st.setString(1, doctorId);
						ResultSet rs = st.executeQuery("SELECT * FROM doctors WHERE doctor_id='" + doctorId + "'");
						if (rs.next()) {
							String name = rs.getString("name");
							textField_1.setText(name);
							String specialization = rs.getString("specialization");
							textField_2.setText(specialization);
							String age = rs.getString("age");
							textField_3.setText(age);
							String gender = rs.getString("gender");
							textField_4.setText(gender);
							String contact = rs.getString("contact_no");
							textField_5.setText(contact);
							String address = rs.getString("address");
							textField_6.setText(address);
							String consultationTime = rs.getString("consultation_time");
							textField_7.setText(consultationTime);
						} else {
							JOptionPane.showMessageDialog(null, "Doctor ID does not exist");
							textField.setText("");
							textField_1.setText("");
							textField_2.setText("");
							textField_3.setText("");
							textField_4.setText("");
							textField_5.setText("");
							textField_6.setText("");
							textField_7.setText("");
						}
					}
					con.close();
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton.setBounds(518, 120, 276, 33);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Doctor Details");
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(622, 200, 165, 33);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Doctor Name :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_2.setForeground(Color.YELLOW);
		lblNewLabel_2.setBounds(432, 270, 182, 26);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(0, 255, 255));
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_1.setBackground(Color.BLACK);
		textField_1.setBounds(704, 270, 244, 28);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Specialization :");
		lblNewLabel_3.setForeground(Color.YELLOW);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_3.setBounds(432, 320, 182, 26);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setForeground(new Color(0, 255, 255));
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_2.setBackground(Color.BLACK);
		textField_2.setBounds(704, 320, 244, 28);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Age :");
		lblNewLabel_4.setForeground(Color.YELLOW);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4.setBounds(432, 370, 77, 26);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setForeground(new Color(0, 255, 255));
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_3.setBackground(Color.BLACK);
		textField_3.setBounds(704, 370, 149, 28);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Gender :");
		lblNewLabel_5.setForeground(Color.YELLOW);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_5.setBounds(432, 420, 101, 26);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setForeground(new Color(0, 255, 255));
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_4.setBackground(Color.BLACK);
		textField_4.setBounds(704, 420, 149, 28);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Contact :");
		lblNewLabel_6.setForeground(Color.YELLOW);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_6.setBounds(432, 470, 101, 26);
		frame.getContentPane().add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setForeground(new Color(0, 255, 255));
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_5.setBackground(Color.BLACK);
		textField_5.setBounds(704, 470, 244, 28);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		lblNewLabel_7 = new JLabel("Address :");
		lblNewLabel_7.setForeground(Color.YELLOW);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_7.setBounds(432, 520, 101, 26);
		frame.getContentPane().add(lblNewLabel_7);
		
		textField_6 = new JTextField();
		textField_6.setForeground(new Color(0, 255, 255));
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_6.setBackground(Color.BLACK);
		textField_6.setBounds(704, 520, 361, 28);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Consultation Time:");
		lblNewLabel_8.setForeground(Color.YELLOW);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_8.setBounds(432, 570, 212, 26);
		frame.getContentPane().add(lblNewLabel_8);
		
		textField_7 = new JTextField();
		textField_7.setForeground(new Color(0, 255, 255));
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_7.setBackground(Color.BLACK);
		textField_7.setBounds(704, 570, 361, 28);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				// Open the main menu or any other desired frame
				new home1();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton_1.setBounds(12, 13, 97, 33);
		frame.getContentPane().add(btnNewButton_1);
	}
}

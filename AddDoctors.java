import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddDoctors {
    public JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;

    public AddDoctors() {
        initialize();
    }

    public void showFrame() {
        frame.setVisible(true);
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 853, 880);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Doctor ID :");
        lblNewLabel.setForeground(new Color(0, 0, 0));
        lblNewLabel.setFont(new Font("Gadugi", Font.BOLD, 20));
        lblNewLabel.setBounds(93, 168, 115, 32);
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setForeground(new Color(128, 0, 0));
        textField.setFont(new Font("Calibri", Font.PLAIN, 18));
        textField.setBounds(433, 173, 294, 32);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Name :");
        lblNewLabel_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1.setFont(new Font("Gadugi", Font.BOLD, 20));
        lblNewLabel_1.setBounds(93, 230, 76, 32);
        frame.getContentPane().add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setForeground(new Color(128, 0, 0));
        textField_1.setFont(new Font("Calibri", Font.PLAIN, 18));
        textField_1.setBounds(433, 235, 294, 32);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Age :");
        lblNewLabel_2.setForeground(new Color(0, 0, 0));
        lblNewLabel_2.setFont(new Font("Gadugi", Font.BOLD, 20));
        lblNewLabel_2.setBounds(93, 292, 76, 32);
        frame.getContentPane().add(lblNewLabel_2);

        textField_2 = new JTextField();
        textField_2.setForeground(new Color(128, 0, 0));
        textField_2.setFont(new Font("Calibri", Font.PLAIN, 18));
        textField_2.setBounds(433, 297, 294, 32);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Gender :");
        lblNewLabel_3.setForeground(new Color(0, 0, 0));
        lblNewLabel_3.setFont(new Font("Gadugi", Font.BOLD, 20));
        lblNewLabel_3.setBounds(93, 354, 90, 32);
        frame.getContentPane().add(lblNewLabel_3);

        JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.setForeground(new Color(128, 0, 0));
        comboBox.setFont(new Font("Calibri", Font.PLAIN, 18));
        comboBox.setBounds(433, 357, 294, 32);
        comboBox.addItem("Male");
        comboBox.addItem("Female");
        frame.getContentPane().add(comboBox);

        JLabel lblNewLabel_4 = new JLabel("Specialization :");
        lblNewLabel_4.setForeground(new Color(0, 0, 0));
        lblNewLabel_4.setFont(new Font("Gadugi", Font.BOLD, 20));
        lblNewLabel_4.setBounds(93, 416, 141, 32);
        frame.getContentPane().add(lblNewLabel_4);

        textField_4 = new JTextField();
        textField_4.setForeground(new Color(128, 0, 0));
        textField_4.setFont(new Font("Calibri", Font.PLAIN, 18));
        textField_4.setBounds(433, 421, 294, 32);
        frame.getContentPane().add(textField_4);
        textField_4.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("Consultation Time :");
        lblNewLabel_5.setForeground(new Color(0, 0, 0));
        lblNewLabel_5.setFont(new Font("Gadugi", Font.BOLD, 20));
        lblNewLabel_5.setBounds(93, 478, 186, 32);
        frame.getContentPane().add(lblNewLabel_5);

        textField_5 = new JTextField();
        textField_5.setForeground(new Color(128, 0, 0));
        textField_5.setFont(new Font("Calibri", Font.PLAIN, 18));
        textField_5.setBounds(433, 483, 294, 32);
        frame.getContentPane().add(textField_5);
        textField_5.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("Contact No :");
        lblNewLabel_6.setForeground(new Color(0, 0, 0));
        lblNewLabel_6.setFont(new Font("Gadugi", Font.BOLD, 20));
        lblNewLabel_6.setBounds(93, 540, 127, 32);
        frame.getContentPane().add(lblNewLabel_6);

        textField_6 = new JTextField();
        textField_6.setForeground(new Color(128, 0, 0));
        textField_6.setFont(new Font("Calibri", Font.PLAIN, 18));
        textField_6.setBounds(433, 545, 294, 32);
        frame.getContentPane().add(textField_6);
        textField_6.setColumns(10);

        JLabel lblNewLabel_7 = new JLabel("Address :");
        lblNewLabel_7.setForeground(new Color(0, 0, 0));
        lblNewLabel_7.setFont(new Font("Gadugi", Font.BOLD, 20));
        lblNewLabel_7.setBounds(93, 602, 98, 32);
        frame.getContentPane().add(lblNewLabel_7);

        textField_7 = new JTextField();
        textField_7.setForeground(new Color(128, 0, 0));
        textField_7.setFont(new Font("Calibri", Font.PLAIN, 18));
        textField_7.setBounds(433, 607, 294, 32);
        frame.getContentPane().add(textField_7);
        textField_7.setColumns(10);

        JButton btnNewButton = new JButton("Add");
        btnNewButton.setFont(new Font("Gadugi", Font.BOLD, 20));
        btnNewButton.setBounds(303, 789, 97, 38);
        frame.getContentPane().add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String pid = textField.getText();
                String name = textField_1.getText();
                String gender = comboBox.getSelectedItem().toString();
                String age = textField_2.getText();
                String specialization = textField_4.getText();
                String consultationTime = textField_5.getText();
                String contact = textField_6.getText();
                String address = textField_7.getText();

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Mohan@473");
                    PreparedStatement ps = con.prepareStatement("INSERT INTO doctors (doctor_id, name, gender, age, specialization, consultation_time, contact_no, address) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                    ps.setString(1, pid);
                    ps.setString(2, name);
                    ps.setString(3, gender);
                    ps.setString(4, age);
                    ps.setString(5, specialization);
                    ps.setString(6, consultationTime);
                    ps.setString(7, contact);
                    ps.setString(8, address);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(frame, "Doctor Added Successfully!");
                    con.close();
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Gadugi", Font.BOLD, 20));
        backButton.setBounds(93, 789, 97, 38);
        frame.getContentPane().add(backButton);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.dispose();
                new home1();
            }
        });
        JLabel lblNewLabel_10 = new JLabel("");
        lblNewLabel_10.setIcon(new ImageIcon(AddDoctors.class.getResource("add diagnosis info.jpg")));
        lblNewLabel_10.setBounds(0, 0, 839, 843);
        frame.getContentPane().add(lblNewLabel_10);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new AddDoctors();
    }
}

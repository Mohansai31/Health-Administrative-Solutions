
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

public class Login {

    public JFrame frame;
    private JTextField txtShreeraj;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login window = new Login();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Login() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Username:");
        lblNewLabel.setForeground(Color.RED);
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel.setBounds(500, 250, 114, 28);
        frame.getContentPane().add(lblNewLabel);

        txtShreeraj = new JTextField();
        txtShreeraj.setForeground(new Color(0, 0, 128));
        txtShreeraj.setBackground(SystemColor.menu);
        txtShreeraj.setFont(new Font("Calibri", Font.ITALIC, 17));
        txtShreeraj.setBounds(700, 250, 192, 28);
        frame.getContentPane().add(txtShreeraj);
        txtShreeraj.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Password:");
        lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel_1.setForeground(Color.RED);
        lblNewLabel_1.setBounds(500, 300, 114, 28);
        frame.getContentPane().add(lblNewLabel_1);

        textField = new JTextField();
        textField.setFont(new Font("Calibri", Font.ITALIC, 17));
        textField.setForeground(new Color(0, 0, 128));
        textField.setBackground(SystemColor.menu);
        textField.setBounds(700, 300, 192, 28);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("LOGIN");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user_name = txtShreeraj.getText();
                String password = textField.getText();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root",
                            "Mohan@473");
                    PreparedStatement st = con
                            .prepareStatement("Select user_name,password from users where user_name=? and password=?");
                    st.setString(1, user_name);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(btnNewButton, "Login Successfully");
                        dispose();
                        new home1();
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton, "Invalid Username or Password");
                    }
                } catch (Exception e1) {
                    System.out.println(e1);
                }
            }

            private void dispose() {
                frame.dispose();
            }
        });
        btnNewButton.setBackground(new Color(176, 224, 230));
        btnNewButton.setFont(new Font("Cambria", Font.BOLD, 20));
        btnNewButton.setForeground(new Color(50, 205, 50));
        btnNewButton.setBounds(500, 372, 97, 33);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("CLOSE");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(null, "Do you really want to close the application?", "Select",
                        JOptionPane.YES_NO_OPTION);
                if (a == 0)
                    System.exit(0);
            }
        });
        btnNewButton_1.setFont(new Font("Cambria", Font.BOLD, 20));
        btnNewButton_1.setForeground(new Color(255, 0, 0));
        btnNewButton_1.setBackground(SystemColor.activeCaption);
        btnNewButton_1.setBounds(800, 372, 97, 33);
        frame.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Create New Account");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                createnewaccount cr = new createnewaccount();
                cr.frame.setVisible(true);
            }
        });
        btnNewButton_2.setBackground(Color.BLACK);
        btnNewButton_2.setForeground(Color.YELLOW);
        btnNewButton_2.setFont(new Font("Cambria", Font.BOLD, 20));
        btnNewButton_2.setBounds(565, 432, 224, 34);
        frame.getContentPane().add(btnNewButton_2);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("sam.png"));
        // Get the screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Set the bounds to cover the entire screen
        lblNewLabel_2.setBounds(0, 0, screenSize.width, 960);
        frame.getContentPane().add(lblNewLabel_2);

        frame.setVisible(true);
    }



    public void setVisible(boolean b) {
        frame.setVisible(b);
    }
}

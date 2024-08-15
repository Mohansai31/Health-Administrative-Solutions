import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DisplayDoctors {

    public JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;

    // Database connection details
    private final String url = "jdbc:mysql://localhost:3306/hospital";
    private final String username = "root";
    private final String password = "Mohan@473";

    /**
     * Launch the application.
     */
    public static void main(String[] args) {

















































































































































































































        
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DisplayDoctors window = new DisplayDoctors();
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
    public DisplayDoctors() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().setBackground(new Color(0, 0, 0));
       frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        frame.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, frame.getWidth(), frame.getHeight() - 50);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Doctor ID", "Name", "Gender", "Age", "Specialization", "Consultation Time", "Contact No",
                        "Address" });
        table.setModel(tableModel);
        scrollPane.setViewportView(table);

        JButton backButton = new JButton("Back");
        backButton.setBounds(10, frame.getHeight() - 40, 80, 30);
        frame.getContentPane().add(backButton);
        
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create and show the home screen frame
                home1 homeScreen = new home1();
                homeScreen.frame.setVisible(true);
                frame.dispose(); // Close the current frame
            }
        });

        frame.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                scrollPane.setBounds(0, 0, frame.getWidth(), frame.getHeight() - 50);
                backButton.setBounds(10, frame.getHeight() - 40, 80, 30);
            }
        });

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);

            PreparedStatement st = con.prepareStatement("SELECT * FROM doctors");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                String doctorId = rs.getString("doctor_id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String age = rs.getString("age");
                String specialization = rs.getString("specialization");
                String consultationTime = rs.getString("consultation_time");
                String contactNo = rs.getString("contact_no");
                String address = rs.getString("address");

                // Add a new row to the table
                Object[] row = { doctorId, name, gender, age, specialization, consultationTime, contactNo, address };
                tableModel.addRow(row);
            }

            // Close the resources
            rs.close();
            st.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        frame.setVisible(true);
    }
}

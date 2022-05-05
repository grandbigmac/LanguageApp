import jdbacApi.connectDB;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class TeacherStudentView {

    JFrame frame;
    JLabel label1;
    JPanel svPanel;
    JButton backButton;
    GridBagConstraints gbc = new GridBagConstraints();

    public TeacherStudentView() {

        frame = new JFrame();

        svPanel = new JPanel();
        svPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        svPanel.setLayout(new GridBagLayout());

        gbc.insets = new Insets(5, 5, 5,5);


        //Back button at top of the page
        backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                backButton();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 0;
        svPanel.add(backButton, gbc);

        //Image/logo at top of the page
        try {
            BufferedImage loginLogo = ImageIO.read(new File("loginpageicon.jpg"));
            label1 = new JLabel(new ImageIcon(loginLogo));
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.NONE;
            svPanel.add(label1, gbc);
        }
        catch (IOException e) {
            System.out.println("Could not find file " + "loginpageicon.jpg");
        }

        label1 = new JLabel("Student View");
        gbc.gridy = 2;
        svPanel.add(label1, gbc);







        {
            try
            {
                String url = "jdbc:mysql://localhost:3306/test?autoReconnect=true&useSSL=false";
                String user = "root";
                String password = "";

                Connection con = connectDB.getConnection();

                String query = "SELECT * FROM students";

                Statement stm = con.createStatement();
                ResultSet res = stm.executeQuery(query);

                String columns[] = { "studentID", "studentEmail", "studentName", "userBirthday", "progress", "languagesStudying"};
                String data[][] = new String[10][5];

                int i = 0;
                while (res.next()) {
                    int id = res.getInt("studentID");
                    String email = res.getString("studentEmail");
                    String name = res.getString("studentName");
                    String prog = res.getString("progress");
                    String languages = res.getString("languagesStudying");
                    data[i][0] = id + "";
                    data[i][1] = email;
                    data[i][2] = name;
                    data[i][3] = prog;
                    data[i][4] = languages;

                    i++;
                }

                DefaultTableModel model = new DefaultTableModel(data, columns);
                JTable table = new JTable(model);
                table.setShowGrid(true);
                table.setShowVerticalLines(true);
                JScrollPane pane = new JScrollPane(table);
                gbc.gridy = 3;
                svPanel.add(pane, gbc);


            } catch(SQLException e) {
                e.printStackTrace();
            }
        }







        frame.add(svPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Student View");
        frame.pack();
        frame.setVisible(true);

    }

    public void backButton() {
        TeacherLandingPage r = new TeacherLandingPage();
        frame.dispose();
    }


}



import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FirstPage {

    JFrame frame;
    JPanel loginPanel;
    JLabel label1, label2;
    JButton studentLoginButton;
    JButton teacherLoginButton;

    GridBagConstraints gbc = new GridBagConstraints();

    public FirstPage() throws FileNotFoundException {

        frame = new JFrame();

        loginPanel = new JPanel();
        loginPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        loginPanel.setLayout(new GridBagLayout());

        gbc.insets = new Insets(5, 5, 5, 5);

        //Image/logo at top of the page
        try {
            BufferedImage loginLogo = ImageIO.read(new File("loginpageicon.jpg"));
            label1 = new JLabel(new ImageIcon(loginLogo));
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.CENTER;
            loginPanel.add(label1, gbc);
        } catch (IOException e) {
            System.out.println("Could not find file " + "loginpageicon.jpg");
        }

        //Title for FirstPage
        label2 = new JLabel("LANGUAGE APP");
        gbc.gridx = 0;
        gbc.gridy = 1;
        loginPanel.add(label2, gbc);

        //Button for navigating to student login page
        studentLoginButton = new JButton("Student Login");
        studentLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                StudentLoginPage r = new StudentLoginPage();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        loginPanel.add(studentLoginButton, gbc);

        //Button for navigation to teacher login page
        teacherLoginButton = new JButton("Teacher Login");
        teacherLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                TeacherLoginPage r = new TeacherLoginPage();
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        loginPanel.add(teacherLoginButton, gbc);

        frame.add(loginPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Login Page");
        frame.pack();
        frame.setVisible(true);
    }
}

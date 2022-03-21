import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoginPage implements ActionListener {

    JFrame frame;
    JPanel loginPanel;
    JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9;
    JTextField emailText;
    JPasswordField passwordText;
    JButton loginButton;

    GridBagConstraints gbc = new GridBagConstraints();

    public LoginPage() {

        frame = new JFrame();

        loginPanel = new JPanel();
        loginPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        loginPanel.setLayout(new GridBagLayout());

        gbc.insets = new Insets(5, 5, 5,5);

        //Image/logo at top of the page
        try {
            BufferedImage loginLogo = ImageIO.read(new File("loginpageicon.jpg"));
            label1 = new JLabel(new ImageIcon(loginLogo));
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            loginPanel.add(label1, gbc);
        }
        catch (IOException e) {
            System.out.println("Could not find file " + "loginpageicon.jpg");
        }

        //Title for Login Page
        label2 = new JLabel("LOGIN");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.CENTER;
        loginPanel.add(label2, gbc);

        //Field to enter user's email address
        label3 = new JLabel("Email:");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        loginPanel.add(label3, gbc);
        emailText = new JTextField();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        loginPanel.add(emailText, gbc);

        //Field to enter user's password
        label4 = new JLabel("Password:");
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        loginPanel.add(label4, gbc);
        passwordText = new JPasswordField();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        loginPanel.add(passwordText, gbc);

        //Submission Button, needs to listen for enter button to submit
        loginButton = new JButton("Submit");
        loginButton.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        loginPanel.add(loginButton, gbc);

        //Hypertext to change to teacher login page
        label5 = new JLabel("Teacher login link");
        //Fix when teacher login page is completed
        label5.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //TeacherLoginPage i = new TeacherLoginPage();
                //frame.dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label6.setCursor(Cursor.getDefaultCursor());
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 7;
        loginPanel.add(label5, gbc);

        //Hypertext to register for an account
        label6 = new JLabel("Register for a new account");
        label6.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                RegistrationPage r = new RegistrationPage();
                frame.dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label6.setCursor(Cursor.getDefaultCursor());
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 8;
        loginPanel.add(label6, gbc);

        frame.add(loginPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Login Page");
        frame.pack();
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

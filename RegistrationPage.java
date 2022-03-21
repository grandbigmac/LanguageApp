import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationPage implements ActionListener {

    JFrame frame;
    JPanel regPanel;
    JLabel label1, label2, label3, label4, label5, label6;
    JTextField nameText, emailText;
    JPasswordField passwordText, confirmPassText;
    JButton backButton, submitButton;

    GridBagConstraints gbc = new GridBagConstraints();

    public RegistrationPage() {

        frame = new JFrame();

        regPanel = new JPanel();
        regPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        regPanel.setLayout(new GridBagLayout());

        gbc.insets = new Insets(5, 5, 5, 100);

        label6 = new JLabel();
        gbc.gridx = 3;
        gbc.gridy = 0;
        regPanel.add(label6, gbc);

        //Back button at top of the page, needs to direct back to the login page when pressed
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 0;
        regPanel.add(backButton, gbc);


        //Title text for the page
        label1 = new JLabel("REGISTER");
        gbc.gridx = 1;
        gbc.gridy = 0;
        regPanel.add(label1, gbc);

        //Field to enter user's name for registration
        label2 = new JLabel("NAME:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        regPanel.add(label2, gbc);
        nameText = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 1;
        regPanel.add(nameText, gbc);

        //Field to enter user's email address
        label3 = new JLabel("EMAIL:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        regPanel.add(label3, gbc);
        emailText = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 2;
        regPanel.add(emailText, gbc);

        //Field to create a password for the user's account
        label4 = new JLabel("PASSWORD:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        regPanel.add(label4, gbc);
        passwordText = new JPasswordField();
        gbc.gridx = 1;
        gbc.gridy = 3;
        regPanel.add(passwordText, gbc);

        //Field to confirm the user's password, must match the contents of the previous field
        label5 = new JLabel("CONFIRM PASSWORD:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        regPanel.add(label5, gbc);
        confirmPassText = new JPasswordField();
        gbc.gridx = 1;
        gbc.gridy = 4;
        regPanel.add(confirmPassText, gbc);

        //Submit button, needs to be triggered when user presses enter button
        submitButton = new JButton("SUBMIT");
        submitButton.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 5;
        regPanel.add(submitButton, gbc);



        frame.add(regPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Registration Page");
        frame.pack();
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
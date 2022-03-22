import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RegistrationPage implements ActionListener {

    JFrame frame;
    JPanel regPanel;
    JLabel label1, label2, label3, label4, label5, label6;
    JTextField nameText, emailText;
    JPasswordField passwordText;
    JPasswordField confirmPassText;
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

        //Back button at top of the page
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
        frame.getRootPane().setDefaultButton(submitButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Registration Page");
        frame.pack();
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //When clicked, the back button reopens the first login page and closes the registration frame
        if (e.getSource() == backButton) {
            LoginPage r = new LoginPage();
            frame.dispose();
        }

        //When pressed, loginButton captures the information entered in the registration fields and creates a new user object out of that information
        if (e.getSource() == submitButton) {
            //Create new student object for new user
            Student r = new Student();

            //Set the student's password
            final String password = passwordText.getText().toString();
            final String confirmPW = confirmPassText.getText().toString();

            if (password.equals(confirmPW)) {

                r.setStudentPassword(password.toCharArray());

                //Set student name
                r.setStudentName(nameText.getText());
                //Set student email
                r.setStudentEmail(emailText.getText());

                //Generate a new User ID using 6 random integers concatenated to a string then parsed back into an integer
                //Need to add functionality where the number generated is unique to the user, and no other user can have the same userID
                String userID = "";
                Random rand = new Random();

                for (int i = 0; i < 6; i++) {
                    int number = rand.nextInt(10);
                    userID = userID + number;
                }

                r.setStudentID(Integer.parseInt(userID));

            }
            else {
                JOptionPane.showMessageDialog(frame, "Error, passwords do not match.");
            }




            //generate user ID
            //get student's birthdate
            //set user's start date to date of object generation
        }
    }

}
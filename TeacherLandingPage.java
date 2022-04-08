import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TeacherLandingPage {

    JFrame frame;
    JPanel regPanel;
    JLabel label1, label2, label3, label4, label5, label6;
    JTextField nameText, emailText;
    JPasswordField passwordText;
    JPasswordField confirmPassText;
    JButton backButton, submitButton;
    GridBagConstraints gbc = new GridBagConstraints();

    public TeacherLandingPage() {

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
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                backButton();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 0;
        regPanel.add(backButton, gbc);


        //Title text for the page
        label1 = new JLabel("TEACHER LANDING PAGE");
        gbc.gridx = 1;
        gbc.gridy = 0;
        regPanel.add(label1, gbc);

        frame.add(regPanel);
        frame.getRootPane().setDefaultButton(submitButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Teacher Landing Page");
        frame.pack();
        frame.setVisible(true);

    }

    public void backButton() {
        FirstPage r = new FirstPage();
        frame.dispose();
    }



}


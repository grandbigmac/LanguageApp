import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class RegistrationPage implements ActionListener {

    JFrame frame;
    JPanel regPanel;

    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;

    JTextField nameText;
    JTextField emailText;
    JTextField passwordText;
    JTextField confirmPassText;

    JButton backButton;
    JButton doneButton;

    public RegistrationPage() {

        frame = new JFrame();

        backButton = new JButton("Back");
        backButton.addActionListener(this);
        backButton.setBounds(10, 10, 75 , 40);

        label1 = new JLabel("REGISTER", SwingConstants.CENTER);
        label1.setBounds(0, 50, 400, 60);

        label2 = new JLabel("NAME:");
        label2.setBounds(20, 100, 200, 60);
        nameText = new JTextField();
        nameText.setBounds(20, 140, 350, 20);

        label3 = new JLabel("EMAIL:");
        label3.setBounds(20, 160, 200, 60);
        emailText = new JTextField();
        emailText.setBounds(20, 200, 350, 20);

        label4 = new JLabel("PASSWORD:");
        label4.setBounds(20, 220, 200, 60);
        passwordText = new JTextField();
        passwordText.setBounds(20, 260, 350, 20);

        label5 = new JLabel("CONFIRM PASSWORD:");
        label5.setBounds(20, 280, 200, 60);
        confirmPassText = new JTextField();
        confirmPassText.setBounds(20, 320, 350, 20);

        doneButton = new JButton("SUBMIT");
        doneButton.addActionListener(this);
        doneButton.setBounds(120, 380, 100, 40);


        regPanel = new JPanel();
        regPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        regPanel.setLayout(null);

        regPanel.add(label1);
        regPanel.add(label2);
        regPanel.add(label3);
        regPanel.add(label4);
        regPanel.add(label5);
        regPanel.add(nameText);
        regPanel.add(emailText);
        regPanel.add(passwordText);
        regPanel.add(confirmPassText);
        regPanel.add(backButton);
        regPanel.add(doneButton);

        frame.add(regPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Our GUI");
        frame.setSize(400, 700);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
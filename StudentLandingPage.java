import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StudentLandingPage {

    JFrame frame;
    JPanel landingPanel;
    JLabel label1, label2, label3;
    JButton language1Button;
    JButton language2Button;

    GridBagConstraints gbc = new GridBagConstraints();

    public StudentLandingPage() {

        frame = new JFrame();

        landingPanel = new JPanel();
        landingPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        landingPanel.setLayout(new GridBagLayout());

        gbc.insets = new Insets(5, 5, 5, 5);

        //Image/logo at top of the page
        try {
            BufferedImage loginLogo = ImageIO.read(new File("loginpageicon.jpg"));
            label1 = new JLabel(new ImageIcon(loginLogo));
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.CENTER;
            landingPanel.add(label1, gbc);
        } catch (IOException e) {
            System.out.println("Could not find file " + "loginpageicon.jpg");
        }

        //Title for TeacherLandingPage
        label2 = new JLabel("Select a language \nto learn today!");
        gbc.gridx = 0;
        gbc.gridy = 1;
        landingPanel.add(label2, gbc);

        //Button for navigating to first language
        language1Button = new JButton("Language 1");
        language1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        landingPanel.add(language1Button, gbc);

        //Button for navigation to second language
        language2Button = new JButton("Language 2");
        language2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        landingPanel.add(language2Button, gbc);

        //Hypertext to log out of account
        label3 = new JLabel("Logout");
        label3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                try {
                    FirstPage r = new FirstPage();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                frame.dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label3.setCursor(Cursor.getDefaultCursor());
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.CENTER;
        landingPanel.add(label3, gbc);

        frame.add(landingPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Login Page");
        frame.pack();
        frame.setVisible(true);
    }
}

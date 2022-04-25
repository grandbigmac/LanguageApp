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

public class SpanishFirstPage {
    JFrame frame;
    JLabel label1, label2, label3;
    JPanel SpanishPanel;
    JButton A1, A2, B1, B2;
    GridBagConstraints gbc = new GridBagConstraints();

    public SpanishFirstPage() {

        frame = new JFrame();

        SpanishPanel = new JPanel();
        SpanishPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        SpanishPanel.setLayout(new GridBagLayout());

        gbc.insets = new Insets(5, 5, 5,5);


        //Image/logo at top of the page
        try {
            BufferedImage loginLogo = ImageIO.read(new File("Flag-Spain.jpeg"));
            label1 = new JLabel(new ImageIcon(loginLogo));
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.NONE;
            SpanishPanel.add(label1, gbc);
        }
        catch (IOException e) {
            System.out.println("Could not find file " + "loginpageicon.jpg");
        }

        //Text below flag to ask which language the student wants to study
        label2 = new JLabel("Select a language difficulty");
        gbc.gridy = 1;
        SpanishPanel.add(label2, gbc);

        //Buttons to select which difficulty to learn
        A1 = new JButton("A1");
        A1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SpanishA1 r = new SpanishA1();
                frame.dispose();
            }
        });
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        SpanishPanel.add(A1, gbc);

        A2 = new JButton("A2");
        A2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SpanishA2 r = new SpanishA2();
                frame.dispose();
            }
        });
        gbc.gridx = 1;
        SpanishPanel.add(A2, gbc);

        B1 = new JButton("B1");
        B1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SpanishB1 r = new SpanishB1();
                frame.dispose();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 3;
        SpanishPanel.add(B1, gbc);

        B2 = new JButton("B2");
        B2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SpanishB2 r = new SpanishB2();
                frame.dispose();
            }
        });
        gbc.gridx = 1;
        SpanishPanel.add(B2, gbc);

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
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        SpanishPanel.add(label3, gbc);

        frame.add(SpanishPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Spanish");
        frame.pack();
        frame.setVisible(true);
    }
}

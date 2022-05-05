import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class SpanishB2 {
    JFrame frame;
    JLabel label1, label2, label3;
    JPanel B2Panel;
    JButton backButton, submitButton;
    JComboBox<String> options, suboptions;
    Hashtable<String, String[]> subcombo = new Hashtable<String, String[]>();
    String[] contexts = {"Going shopping and asking for prices", "Work life", "Making travel arrangements", "Socialising in the country"};
    String[] shoppingOptions = {"Phone purchase"};
    String[] workOptions = {"Meet for drinks"};
    String[] travelOptions = {"Disneyland"};
    String[] socialisingOptions = {"No show date"};
    GridBagConstraints gbc = new GridBagConstraints();

    public SpanishB2() {

        frame = new JFrame();

        B2Panel = new JPanel();
        B2Panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        B2Panel.setLayout(new GridBagLayout());

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
        B2Panel.add(backButton, gbc);


        //Image/logo at top of the page
        try {
            BufferedImage loginLogo = ImageIO.read(new File("Flag-Spain.jpeg"));
            label1 = new JLabel(new ImageIcon(loginLogo));
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.NONE;
            B2Panel.add(label1, gbc);
        }
        catch (IOException e) {
            System.out.println("Could not find file " + "Flag-Spain.jpeg");
        }

        //Text below flag to ask which language the student wants to study
        label2 = new JLabel("Select a context to study");
        gbc.gridy = 2;
        B2Panel.add(label2, gbc);

        //Combo box to select a context
        options = new JComboBox<>(contexts);
        options.addActionListener(e -> {
            String item = (String)options.getSelectedItem();
            Object o = subcombo.get(item);

            if (o == null) {
                suboptions.setModel(new DefaultComboBoxModel());
            }
            else {
                suboptions.setModel(new DefaultComboBoxModel((String[])o));
            }
        });
        options.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
        gbc.gridy = 3;
        B2Panel.add(options,gbc);

        label3 = new JLabel("Select a subcontext to study");
        gbc.gridy = 4;
        B2Panel.add(label3,gbc);

        //Subcombo box that changes values dependant on previous combo box
        suboptions = new JComboBox<String>();
        suboptions.setPrototypeDisplayValue("----------------------------------------------------");
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        B2Panel.add(suboptions, gbc);

        //Filling hashtable with suboptions arrays
        subcombo.put(contexts[0], shoppingOptions);
        subcombo.put(contexts[1], workOptions);
        subcombo.put(contexts[2], travelOptions);
        subcombo.put(contexts[3], socialisingOptions);

        //Button to submit your option
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opt1 = (String) options.getSelectedItem();
                String opt2 = (String) suboptions.getSelectedItem();
                new B2Submission(opt1, opt2);
                frame.dispose();
            }
        });
        gbc.gridy = 6;
        B2Panel.add(submitButton, gbc);

        frame.add(B2Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Spanish B2");
        frame.pack();
        frame.setVisible(true);
    }

    public void backButton() {
        SpanishFirstPage r = new SpanishFirstPage();
        frame.dispose();
    }
}

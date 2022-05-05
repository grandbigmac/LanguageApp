import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class SpanishB1 {
    JFrame frame;
    JLabel label1, label2, label3;
    JPanel B1Panel;
    JButton backButton, submitButton;
    JComboBox<String> options, suboptions;
    Hashtable<String, String[]> subcombo = new Hashtable<String, String[]>();
    String[] contexts = {"Going shopping and asking for prices", "University life", "Making travel arrangements", "Socialising", "Weather", "Ordering food and drink",
    "Making invitations", "Work life", "Housing conditions"};
    String[] shoppingpricesOptions = {"Payment", "Cancel hair appointment", "Purchase of computer"};
    String[] uniOptions = {"Study plans"};
    String[] travelOptions = {"E.ticket"};
    String[] socialisingOptions = {"Hair cut"};
    String[] weatherOptions = {"Rain in station"};
    String[] orderfoodOptions = {"Ordering cocktails by barcode"};
    String[] invitationsOptions = {"Offering help for Pink Unicorn Party"};
    String[] workOptions = {"Job offer"};
    String[] houseOptions = {"Delivery of packages"};
    GridBagConstraints gbc = new GridBagConstraints();

    public SpanishB1() {

        frame = new JFrame();

        B1Panel = new JPanel();
        B1Panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        B1Panel.setLayout(new GridBagLayout());

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
        B1Panel.add(backButton, gbc);

        //Image/logo at top of the page
        try {
            BufferedImage loginLogo = ImageIO.read(new File("Flag-Spain.jpeg"));
            label1 = new JLabel(new ImageIcon(loginLogo));
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.NONE;
            B1Panel.add(label1, gbc);
        }
        catch (IOException e) {
            System.out.println("Could not find file " + "Flag-Spain.jpeg");
        }

        //Text below flag to ask which language the student wants to study
        label2 = new JLabel("Select a context to study");
        gbc.gridy = 2;
        B1Panel.add(label2, gbc);

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
        B1Panel.add(options,gbc);

        label3 = new JLabel("Select a subcontext to study");
        gbc.gridy = 4;
        B1Panel.add(label3,gbc);

        //Subcombo box that changes values dependant on previous combo box
        suboptions = new JComboBox<String>();
        suboptions.setPrototypeDisplayValue("----------------------------------------------------");
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        B1Panel.add(suboptions, gbc);

        //Filling hashtable with suboptions arrays
        subcombo.put(contexts[0], shoppingpricesOptions);
        subcombo.put(contexts[1], uniOptions);
        subcombo.put(contexts[2], travelOptions);
        subcombo.put(contexts[3], socialisingOptions);
        subcombo.put(contexts[4], weatherOptions);
        subcombo.put(contexts[5], orderfoodOptions);
        subcombo.put(contexts[6], invitationsOptions);
        subcombo.put(contexts[7], workOptions);
        subcombo.put(contexts[8], houseOptions);

        //Button to submit your option
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opt1 = (String) options.getSelectedItem();
                String opt2 = (String) suboptions.getSelectedItem();
                new B1Submission(opt1, opt2);
                frame.dispose();
            }
        });
        gbc.gridy = 6;
        B1Panel.add(submitButton, gbc);

        frame.add(B1Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Spanish B1");
        frame.pack();
        frame.setVisible(true);
    }

    public void backButton() {
        SpanishFirstPage r = new SpanishFirstPage();
        frame.dispose();
    }
}

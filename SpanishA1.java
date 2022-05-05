import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class SpanishA1 {
    JFrame frame;
    JLabel label1, label2, label3;
    JPanel A1Panel;
    JButton backButton, submitButton;
    JComboBox<String> options, suboptions;
    Hashtable<String, String[]> subcombo = new Hashtable<String, String[]>();
    String[] contexts = {"Ordering food and drink", "Exchanging personal information", "Going shopping and asking for prices",
    "Making Appointments", "Introductions", "Basic employment issues", "Socialising in the country", "Asking and giving directions", "Making invitations", "University life", "Cross-cultural experiences"};
    String[] foodanddrinkOptions = {"Takeaway", "Coffee Order", "Water for table", "Reservation", "Cocktails by card payment"};
    String[] personalinformationOptions = {"Social Media", "Instagram"};
    String[] shoppingpricesOptions = {"Payment", "Refund"};
    String[] appointmentsOptions = {"Booking", "Spelling your name"};
    String[] introductionsOptions = {"Repeat name"};
    String[] employmentOptions = {"Cover", "Interview"};
    String[] socialisingOptions = {"Interview arrangements"};
    String[] directionsOptions = {"Delivery driver"};
    String[] invitationsOptions = {"Disneyland", "Help with child's birthday party"};
    String[] unilifeOptions = {"Study in cafe"};
    String[] crosscultureOptions = {"International food"};
    GridBagConstraints gbc = new GridBagConstraints();

    public SpanishA1() {

        frame = new JFrame();
        A1Panel = new JPanel();
        A1Panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        A1Panel.setLayout(new GridBagLayout());

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
        A1Panel.add(backButton, gbc);

        //Image/logo at top of the page
        try {
            BufferedImage loginLogo = ImageIO.read(new File("Flag-Spain.jpeg"));
            label1 = new JLabel(new ImageIcon(loginLogo));
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.NONE;
            A1Panel.add(label1, gbc);
        }
        catch (IOException e) {
            System.out.println("Could not find file " + "Flag-Spain.jpeg");
        }

        //Text below flag to ask which language the student wants to study
        label2 = new JLabel("Select a context to study");
        gbc.gridy = 2;
        A1Panel.add(label2, gbc);

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
        A1Panel.add(options,gbc);

        label3 = new JLabel("Select a subcontext to study");
        gbc.gridy = 4;
        A1Panel.add(label3,gbc);

        //Subcombo box that changes values dependant on previous combo box
        suboptions = new JComboBox<String>();
        suboptions.setPrototypeDisplayValue("----------------------------------------------------");
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        A1Panel.add(suboptions, gbc);

        //Filling hashtable with suboptions arrays
        subcombo.put(contexts[0], foodanddrinkOptions);
        subcombo.put(contexts[1], personalinformationOptions);
        subcombo.put(contexts[2], shoppingpricesOptions);
        subcombo.put(contexts[3], appointmentsOptions);
        subcombo.put(contexts[4], introductionsOptions);
        subcombo.put(contexts[5], employmentOptions);
        subcombo.put(contexts[6], socialisingOptions);
        subcombo.put(contexts[7], directionsOptions);
        subcombo.put(contexts[8], invitationsOptions);
        subcombo.put(contexts[9], unilifeOptions);
        subcombo.put(contexts[10], crosscultureOptions);

        //Button to submit your option
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opt1 = (String) options.getSelectedItem();
                String opt2 = (String) suboptions.getSelectedItem();
                A1Submission r = new A1Submission(opt1, opt2);
                frame.dispose();
            }
        });
        gbc.gridy = 6;
        A1Panel.add(submitButton, gbc);

        frame.add(A1Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Spanish A1");
        frame.pack();
        frame.setVisible(true);
    }

    public void backButton() {
        SpanishFirstPage r = new SpanishFirstPage();
        frame.dispose();
    }
}

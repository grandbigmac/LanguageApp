import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class SpanishA2 {
    JFrame frame;
    JLabel label1, label2, label3;
    JPanel A2Panel;
    JButton backButton, submitButton;
    JComboBox<String> options, suboptions;
    Hashtable<String, String[]> subcombo = new Hashtable<String, String[]>();
    String[] contexts = {"Asking and giving directions", "Ordering food and drink", "Making Appointments", "Going shopping and asking for prices", "Health matters",
    "Making invitations", "Socialising in the country", "Making travel arrangements", "Introductions", "Cross-cultural experiences",  "Weather and weather conditions"};
    String[] givedirectionsOptions = {"Delivery Driver", "Hospital Visit"};
    String[] orderfoodOptions = {"Cocktails", "Vegan pizza", "Reservation", "Delayed drink order", "QR code"};
    String[] appointmentsOptions = {"Dentist", "Doctor"};
    String[] shoppingpricesOptions = {"Payment"};
    String[] hmOptions = {"Sick relative", "Visiting patient"};
    String[] invitationsOptions = {"Charity", "Lunch", "Children at wedding", "Wedding RSVP"};
    String[] socialisingOptions = {"Family size", "Succulent"};
    String[] travelOptions = {"Expired ticket"};
    String[] introOptions = {"1st day in job", "Job offer"};
    String[] cultureOptions = {"Omelette"};
    String[] weatherOptions = {"Clothing for weather"};

    GridBagConstraints gbc = new GridBagConstraints();

    public SpanishA2() {

        frame = new JFrame();

        A2Panel = new JPanel();
        A2Panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        A2Panel.setLayout(new GridBagLayout());

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
        A2Panel.add(backButton, gbc);

        //Image/logo at top of the page
        try {
            BufferedImage loginLogo = ImageIO.read(new File("Flag-Spain.jpeg"));
            label1 = new JLabel(new ImageIcon(loginLogo));
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.NONE;
            A2Panel.add(label1, gbc);
        }
        catch (IOException e) {
            System.out.println("Could not find file " + "Flag-Spain.jpeg");
        }

        //Text below flag to ask which language the student wants to study
        label2 = new JLabel("Select a context to study");
        gbc.gridy = 2;
        A2Panel.add(label2, gbc);

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
        A2Panel.add(options,gbc);

        label3 = new JLabel("Select a subcontext to study");
        gbc.gridy = 4;
        A2Panel.add(label3,gbc);

        //Subcombo box that changes values dependant on previous combo box
        suboptions = new JComboBox<String>();
        suboptions.setPrototypeDisplayValue("----------------------------------------------------");
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        A2Panel.add(suboptions, gbc);

        //Filling hashtable with suboptions arrays
        subcombo.put(contexts[0], givedirectionsOptions);
        subcombo.put(contexts[1], orderfoodOptions);
        subcombo.put(contexts[2], appointmentsOptions);
        subcombo.put(contexts[3], shoppingpricesOptions);
        subcombo.put(contexts[4], hmOptions);
        subcombo.put(contexts[5], invitationsOptions);
        subcombo.put(contexts[6], socialisingOptions);
        subcombo.put(contexts[7], travelOptions);
        subcombo.put(contexts[8], introOptions);
        subcombo.put(contexts[9], cultureOptions);
        subcombo.put(contexts[10], weatherOptions);

        //Button to submit your option
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opt1 = (String) options.getSelectedItem();
                String opt2 = (String) suboptions.getSelectedItem();
                new A2Submission(opt1, opt2);
                frame.dispose();
            }
        });
        gbc.gridy = 6;
        A2Panel.add(submitButton, gbc);

        frame.add(A2Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Spanish A2");
        frame.pack();
        frame.setVisible(true);
    }

    public void backButton() {
        SpanishFirstPage r = new SpanishFirstPage();
        frame.dispose();
    }
}

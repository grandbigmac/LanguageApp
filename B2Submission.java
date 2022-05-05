import jdbacApi.jdbcCrud;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class B2Submission {

    JFrame frame;
    JPanel panel1;
    JButton backButton;
    JLabel label1, label2, label3;
    String conversation;
    JTextArea text, text2;
    GridBagConstraints gbc = new GridBagConstraints();


    public B2Submission(String opt1, String opt2) {
        conversation = jdbcCrud.getConversation(opt1, opt2);

        frame = new JFrame();
        panel1 = new JPanel();
        panel1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel1.setLayout(new GridBagLayout());

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
        panel1.add(backButton, gbc);

        //Image/logo at top of the page
        try {
            BufferedImage loginLogo = ImageIO.read(new File("Flag-Spain.jpeg"));
            label1 = new JLabel(new ImageIcon(loginLogo));
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.NONE;
            panel1.add(label1, gbc);
        }
        catch (IOException e) {
            System.out.println("Could not find file " + "Flag-Spain.jpeg");
        }

        //Text showing context for conversation
        label2 = new JLabel(opt1 + ":");
        gbc.gridy = 2;
        panel1.add(label2, gbc);

        //Text showing sub context for conversation
        label3 = new JLabel(opt2);
        gbc.gridy = 3;
        panel1.add(label3, gbc);

        //Getting conversation topics
        if (opt1 == "Going shopping and asking for prices" && opt2 == "Phone purchase") {

            text = new JTextArea("A\tHi, can I buy this phone?\n" +
                    "B\tDid you make a reservation?\n" +
                    "A\tNo, I didn't.\n" +
                    "B\tYou need a reservation, I can make one for you but it will be in about 30 minutes. Is that okay?\n" +
                    "A\tNo, that's way too long to wait to buy a phone.\n" +
                    "B\tWell, unfortunately, we are extremely busy because of the launch of our newest phone, and two models have sold out already today. So if you can wait a little while we can get you a slot. Is that okay?\n" +
                    "A\tFine, I will make the reservation. But is there anything you can offer me in return for my having to wait?\n" +
                    "B\tI'm afraid not, we have to do reservations today because we are so busy. Next time you should book online to avoid the wait.\n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "launch, models, slot\n\n" +
                    "Spanish Translation:\n" +
                    "lanzar, modelo, ranura\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Work life" && opt2 == "Meet for drinks") {

            text = new JTextArea("A\tHi I haven't seen you around, are you new?\n" +
                    "B\tHi, yeah I am! Yesterday was my first day.\n" +
                    "A\tNo kidding! How are you finding it so far?\n" +
                    "B\tPretty good. Everyone is really nice and the workload is managable. \n" +
                    "A\tYeah, it's decent for the money. I'm Clare by the way, nice to meet you. \n" +
                    "B\tNice to meet you too. I'm Lucy. \n" +
                    "A\tSo hey, some of us are going for drinks on Friday, would you like to join us? \n" +
                    "B\tSure, what time?\n" +
                    "A\t8pm at the bar down the road. They have 2 for 1 cocktails all night so we're going to have fun! \n" +
                    "B\tOh great! I will see you guys there. \n" +
                    "A\tAwesome, see you there Lucy! \n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "no kidding, workload, manageable, decent\n\n" +
                    "Spanish Translation:\n" +
                    "en serio, carga de trabajo, manejable, decente\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Making travel arrangements" && opt2 == "Disneyland") {

            text = new JTextArea("A\tHi John did you get my letter?\n" +
                    "B\tAbout your son's birthday party next week? \n" +
                    "A\tYeah that one. \n" +
                    "B\tAh, unfortunately we won't be able to come. My wife planned a trip to Disneyland for the whole family, so we're going to be away all week.\n" +
                    "A\tA trip to Disneyland? In the middle of summer? You must have got a good deal. \n" +
                    "B\tWe did!  Kids under the age of 8 get free entry and we're staying in an Airbnb so we're saving a lot on food and accomodation too. \n" +
                    "A\tAh, I've heard the parking can be tricky if you're not staying inside the resort though.\n" +
                    "B\tNo need for parking, the Airbnb is actually only a 15 minute walk from the park!\n" +
                    "A\tWow, you really thought about everything! Well, have a good time and I will see you when you're back.\n" +
                    "B\tThanks, we will. See you later! \n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "airbnb, accomodation, tricky, resort\n\n" +
                    "Spanish Translation:\n" +
                    "airebnb, alojamiento, difícil, complejo\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Socialising in the country" && opt2 == "No show date") {

            text = new JTextArea("A\tHi Peter. How was your weekend?\n" +
                    "B\tCould have been better.\n" +
                    "A\tWhat happened?\n" +
                    "B\tI was supposed to go on a date but she ghosted me.\n" +
                    "A\tThat's awful.\n" +
                    "B\tShe seemed keen but then on the day I just didn't hear from her at all. Such a shame because we really clicked, we like the same music and we had a lot to talk about. \n" +
                    "A\tDo you have a picture of her?\n" +
                    "B\tHere\n" +
                    "A\tOh wow, she looks like a model. Are you sure she wasn't a catfish.\n" +
                    "B\tI didn't think about it, I guessed she was real when she agreed to meet up. You could be right.\n" +
                    "A\tBest to just forget about it, there's plenty more fish in the sea.\n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "a date, ghosted, keen, such a shame, there's plenty more fish in the sea\n\n" +
                    "Spanish Translation:\n" +
                    "una fecha, me desertó, entusiasta, Una pena, hay muchos más peces en el mar \n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        frame.add(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Spanish B2 Conversation");
        frame.pack();
        frame.setVisible(true);
    }

    public void backButton() {
        SpanishB2 r = new SpanishB2();
        frame.dispose();
    }
}

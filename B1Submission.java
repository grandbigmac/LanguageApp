import jdbacApi.jdbcCrud;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class B1Submission {

    JFrame frame;
    JPanel panel1;
    JButton backButton;
    JLabel label1, label2, label3;
    String conversation;
    JTextArea text, text2;
    GridBagConstraints gbc = new GridBagConstraints();


    public B1Submission(String opt1, String opt2) {
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
        if (opt1 == "Going shopping and asking for prices" && opt2 == "Payment") {

            text = new JTextArea("A\tHi there. May I pay for these items please?\n" +
                    "B\tHello, yes of course. Your total is £255. Will you be paying by cash or card?\n" +
                    "A\t£255! Are you sure? \n" +
                    "B\tYes. You have bought 2 pairs of trousers at £65 each, and a jumper - that's £125. That's £255 in total. \n" +
                    "A\tOh. That is too much. I will only buy one of the pairs of trousers. \n" +
                    "B\tWhich one - the blue or the black. \n" +
                    "A\tThe blue. I'm so sorry about this. \n" +
                    "B\tNot a problem. Right, so, that's one pair of trousers at £65 and a jumper at £125. So, £190 please.\n" +
                    "A\tOk. Here's my card. \n" +
                    "B\tRight, please can you insert your card. Oh, I'm sorry, the payment has not been authorised. \n" +
                    "A\tOh dear. I think I'll leave it. Bye. \n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "cash, card\n\n" +
                    "Spanish Translation:\n" +
                    "dinero en efectivo, tarjeta, autorizada\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "University life" && opt2 == "Study plans") {

            text = new JTextArea("A\tHow are you?\n" +
                    "B\tI'm doing okay, you?\n" +
                    "A\tI'm stressed.\n" +
                    "B\tWhy are you stressed?\n" +
                    "A\tI have two assignments and they are both due next Monday. It's just too much!\n" +
                    "B\tWell, I have the same assignments, why don't we meet in the library and study together?\n" +
                    "A\tIt's hard for me to study with other people, because I get distracted.\n" +
                    "B\tWell, I don't get distracted. Look, we can talk about the structure and share some ideas. \n" +
                    "A\tThat would be really helpful. But I know that I can't sit in the library for hours. \n" +
                    "B\tYou're not meant to. We will take a short break every couple of hours - that's the way to maintain focus!\n" +
                    "A\tThat would be really helpful, thank you.\n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "assignments, due, distracted, structure, maintain\n\n" +
                    "Spanish Translation:\n" +
                    "asignaciones, vencer, distraída, estructura, mantener\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Making travel arrangements" && opt2 == "E.ticket") {

            text = new JTextArea("A\tGood morning, tickets please. \n" +
                    "B\tGood morning. Oh no..I think I forgot my ticket. Can you wait a moment?\n" +
                    "A\tWould you like to buy one now? \n" +
                    "B\tNo, I'm sure I have it somewhere just give me a minute. I printed off a copy yesterday evening. \n" +
                    "A\tif you can't find the paper copy, the ticket is also available on your phone sir. \n" +
                    "B\tYou're right, it's right here. What do I do now?  \n" +
                    "A\tJust show me the QR code. Thank you. Now, I see you have a rail card. Please may I see it? \n" +
                    "B\tHere it is. I know that this is stored on my phone. \n" +
                    "A\tThank you that is all done. Have a nice day!\n" +
                    "B\tHave a good day!\n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "QR code, rail card\n\n" +
                    "Spanish Translation:\n" +
                    "código QR, tarjeta de tren\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Going shopping and asking for prices" && opt2 == "Cancel hair appointment") {

            text = new JTextArea("A\tGood morning, how can I help?\n" +
                    "B\tGood morning, I'd like to cancel my appointment please.\n" +
                    "A\tWhen is your appointment?\n" +
                    "B\tToday at 4pm.\n" +
                    "A\tWe require 24 hours notice to cancel appointments, otherwise there's a cancellation charge of £20.\n" +
                    "B\tWhy do I have to pay to cancel my appointment?\n" +
                    "A\tBecause our salon is very popular and we are often booked in advance and we don't do walk-ins. Next time, please book at time that you can make.\n" +
                    "B\tI have to work last minute and can't make it at 4pm anymore, I can't afford to pay for a haircut that I didn't get.\n" +
                    "A\tUnfortunately, that's the agreement you made when making the appointment.\n" +
                    "B\tWell, I will not be coming back here again.\n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "notice, cancellation charge, walk-ins, last minute\n\n" +
                    "Spanish Translation:\n" +
                    "darse cuenta, cargo de cancelación, visitas sin cita previa, último minuto\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Going shopping and asking for prices" && opt2 == "Purchase of computer") {

            text = new JTextArea("A\tHi, can I buy this laptop?\n" +
                    "B\tThat one is quite popular, let me check if it's in stock.\n" +
                    "A\tThank you.\n" +
                    "B\tI've had a look and we don't have the black or grey in stock, however we do have the pink avaliable.\n" +
                    "A\tI was hoping for a more neutral colour.\n" +
                    "B\tUnfortunately this one is very popular, the black is avaliable in another store half an hour away. Would you like me to reserve it for you? \n" +
                    "A\tNo thank you, I have already travelled 40 minutes to come here. Are there any other similar laptops you can recommend to me?\n" +
                    "B\tThere is one here in grey, that has more memory and a better processor but it's more expensive.\n" +
                    "A\tIt's £50 outside of my price range.\n" +
                    "B\tAre you a student? Because we have a student discount and that will make it £40 cheaper.\n" +
                    "A\tThat's perfect, can I buy this one?\n" +
                    "B\tOf course, I'll put it behind the till for you.\n" +
                    "A\tThank you very much.\n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "in stock, similar, recommend, memory, processor, discount\n\n" +
                    "Spanish Translation:\n" +
                    "en stock, similar, recomendar, memoria, procesador, descuento\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Socialising" && opt2 == "Hair cut") {

            text = new JTextArea("A\tHiya, long time no see!\n" +
                    "B\tHi, yeah, it's been ages. How are you getting on?\n" +
                    "A\tI've been good, yourself? You look great by the way, did you change your hair?\n" +
                    "B\tThanks for noticing, I found this excellent new hairdresser.\n" +
                    "A\tWhere is it?\n" +
                    "B\tIt's not far from my house? Maybe 20 minutes by bus. It's called Serenity Salon.\n" +
                    "A\tLet me write that down, I might just check it out. How much was it?\n" +
                    "B\tI had a cut and blowdry and a full head of colour so it was £200.\n" +
                    "A\t£200! That's too expensive.\n" +
                    "B\tWell it is worth to have good colour. Your hair is lovely natural anyway, you don't need an expensive colour.\n" +
                    "A\tThank you for saying that, but I dye my hair at home on my own. It's about £10 at the drugstore.\n" +
                    "B\tI couldn't even tell, it looks amazing. Anyway I've got to run. It was lovely seeing you.\n" +
                    "A\tYou as well, bye.\n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "blowdry\n\n" +
                    "Spanish Translation:\n" +
                    "golpe a secas\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Weather" && opt2 == "Rain in station") {

            text = new JTextArea("A\tHey why weren't you at class this morning?\n" +
                    "B\tHi! Well because of the rain my station was completely flooded. I had to get a replacement bus which was 30 minutes late. \n" +
                    "A\tTell me about it. It was meant to be sunny, so I didn't bring an umbrella and got completely soaked. \n" +
                    "B\tThis is why I always carry an umbrella. You never know. \n" +
                    "A\tAnyway, do you want the notes from the class this morning?\n" +
                    "B\tYes please, that would be great. \n" +
                    "A\tI will take a picture and send it to you later. I have to run now but it was nice talking you!\n" +
                    "B\tSame here. See you later!\n" +
                    "A\tBye. And good luck for your journey home. \n" +
                    "B\tThanks, bye!\n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "flooded, replacement bus, soaked\n\n" +
                    "Spanish Translation:\n" +
                    "Inundado, autobús de reemplazo, mojado\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Ordering food and drink" && opt2 == "Ordering cocktails by barcode") {

            text = new JTextArea("A\tHi there, can we order some cocktails please?\n" +
                    "B\tGood evening, I'm sorry but we're only taking orders through our app at the moment. If you take a seat at your table you can scan the barcode and your drinks will be delivered right to your table. \n" +
                    "A\tWe have already waited half an hour for a table. Can't I just pay you and have my drinks?\n" +
                    "B\tUnfortunately, not. It is a Friday night, we're extremely busy and this system ensures everyone gets their orders on time. \n" +
                    "A\tI understand that but it will be another hour until we get our drinks and I'm not willing to wait that long. \n" +
                    "B\tYou're welcome to go somewhere else, but I can assure you all bars operate under the same policy at the moment. \n" +
                    "A\tWe will see about that. \n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "present continuous, past perfect, adverbs\n\n" +
                    "Spanish Translation:\n" +
                    "escanear el código de barras, el sistema asegura, asegurar, política\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Making invitations" && opt2 == "Offering help for Pink Unicorn Party") {

            text = new JTextArea("A\tHi Mary did you get my letter?\n" +
                    "B\tHi! About your daughter's birthday party next week?\n" +
                    "A\tYes that one. \n" +
                    "B\tOf course! Me and the kids would be delighted to attend. What time does it start?\n" +
                    "A\tThe party starts at 14:00.\n" +
                    "B\tDo you need help setting up?\n" +
                    "A\tI actually do. It's not easy organising a party for 20 kids. \n" +
                    "B\tYeah I know, it's hard work. Do you need me to bring anything? Food, decorations?\n" +
                    "A\tMy daughter wanted a pink, unicorn theme so if you have any pink decorations that would be great. \n" +
                    "B\tI will see what I can do. Shall I meet you at your place at 12?\n" +
                    "A\tYeah, that will give us enough time. Thank you so much for this. \n" +
                    "B\tOh, don't mention it! See you soon. \n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "pink, unicorn, theme\n\n" +
                    "Spanish Translation:\n" +
                    "tema de unicornio rosa\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Work life" && opt2 == "Job offer") {

            text = new JTextArea("A\tGood morning, am I speaking to Lucy?\n" +
                    "B\tHi, yes that's me. \n" +
                    "A\tHi Lucy. I'm calling from H&M head office, following your interview we are delighted to offer you a position. Would you be able to start on Monday?\n" +
                    "B\tThat's brilliant news! I had to give 2 weeks notice at work, so I can start on Monday in 2 weeks.\n" +
                    "A\tThat's perfect. When you come in ask for me at reception, my name is Tim Brown. Can you please bring your passport so we can get the necessary paperwork done.\n" +
                    "B\tYes I will do. Thank you so much again. What time should we meet?\n" +
                    "A\tHow about 10 am?\n" +
                    "B\tThat's perfect. Is there anything else I should bring? And is there a dress code or uniform? \n" +
                    "A\tIf you have an insurance card/ national insurance number bring that along too. There's no uniform but dress smartly. Blazer, black trousers, basic office attire. \n" +
                    "B\tOkay, thank you so much. See you soon!\n" +
                    "A\tMy pleasure Lucy, welcome to the team. Bye! \n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "notice, reception, dress code, uniform, insurance card, attire\n\n" +
                    "Spanish Translation:\n" +
                    "darse cuenta, recepción, código de vestimenta, uniforme, tarjeta de seguro\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Housing conditions" && opt2 == "Delivery of packages") {

            text = new JTextArea("B\tHi, it's your neighbour from number 5.\n" +
                    "A\tOh right, is everything okay?\n" +
                    "B\tYeah, a few weeks ago my package was delivered here, do you have it?\n" +
                    "A\tI don't have any packages for anyone at the moment, no.\n" +
                    "B\tIt says here on the delivery email that it was delivered here, and this picture shows it at your door.\n" +
                    "A\tThose are my feet, but I don't have that package, when was it?\n" +
                    "B\tAbout two weeks ago.\n" +
                    "A\tI do remember that package, but number 8 came and collected it.\n" +
                    "B\tWhy would she collect my package?\n" +
                    "A\tSince I work from home, I collect the packages for the whole apartment block. I get at least two for her a week. I'm not sure why she didn't deliver it to you when she saw it wasn't hers. I'm really sorry about that.\n" +
                    "B\tOkay, thank you for telling me. I'll go to her door and ask.\n" +
                    "A\tI hope you find it, I'll be more careful next time.\n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "at least, care\n\n" +
                    "Spanish Translation:\n" +
                    "por lo menos, cuidado\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        frame.add(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Spanish B1 Conversation");
        frame.pack();
        frame.setVisible(true);
    }

    public void backButton() {
        SpanishB1 r = new SpanishB1();
        frame.dispose();
    }
}

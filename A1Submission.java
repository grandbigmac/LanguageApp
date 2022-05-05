import jdbacApi.jdbcCrud;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class A1Submission {

    JFrame frame;
    JPanel panel1;
    JButton backButton;
    JLabel label1, label2, label3;
    String conversation;
    JTextArea text, text2;
    GridBagConstraints gbc = new GridBagConstraints();


    public A1Submission(String opt1, String opt2) {
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
        if (opt1 == "Ordering food and drink" && opt2 == "Takeaway") {

            text = new JTextArea("A\tHello, is the manager there?\n" +
                    "B\tThey will arrive in an hour, do you want to call back or I can take a message?\n" +
                    "A\tCan you tell them that I am sick and can't come to work today.\n" +
                    "B\tWhat's the matter?\n" +
                    "A\tI've got a cold.\n" +
                    "B\tDid you find cover?\n" +
                    "A\tNot yet.\n" +
                    "B\tSend a message in the group chat, hopefully someone can cover your shift.\n" +
                    "A\tI will do that now, thank you.\n" +
                    "B\tWell, I hope you get well soon.\n" +
                    "A\tThank you, speak to you soon. Goodbye.\n" +
                    "B\tGoodbye.");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "reservation, wait, about, takeaway\n\n" +
                    "Spanish Translation:\n" +
                    "reservación, espera, sobre, llevar"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        else if (opt1 == "Exchanging personal information" && opt2 == "Social Media") {

            text = new JTextArea("A\tHi Peter. How was your weekend?\n" +
                    "B\tHi. It was good thank you. I met a nice girl.\n" +
                    "A\tOh really? What is she like? Did you get her Snapchat?\n" +
                    "B\tShe doesn't use Snapchat. She's very pretty. She has long brown hair and big green eyes. I like her. \n" +
                    "A\tI want to see her. What's her name? I'll look her up on Instagram. \n" +
                    "B\tYou can try. Her name is Natalia Black.\n" +
                    "A\tI found her! Wow, she is beautiful. I'm happy for you!\n" +
                    "B\tI am happy too. And thank you. ");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "use, snapchat\n\n" +
                    "Spanish Translation:\n" +
                    "usa, snapchat"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        else if (opt1 == "Going shopping and asking for prices" && opt2 == "Payment") {

            text = new JTextArea("A\tHi there. May I pay for these items please?\n" +
                    "B\tHello, yes of course. Your total is £35. Will you be paying by cash or card?\n" +
                    "A\tCard, please. \n" +
                    "B\tNo problem. You can insert or touch your card to the machine. \n" +
                    "A\tThank you. \n" +
                    "B\tI'm sorry your card hasn't worked. Can you try again?\n" +
                    "A\tI'm sorry about that. I will use my PIN.\n" +
                    "B\tThat is all done. Thank you for shopping with us. Have a good day!\n" +
                    "A\tHave a good day! Goodbye.");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "cash, card, insert, touch, hasn't worked, PIN\n\n" +
                    "Spanish Translation:\n" +
                    "en efectivo, con tarjeta, insertar, tocar, no ha funcionado, PIN"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        else if (opt1 == "Making Appointments" && opt2 == "Booking") {

            text = new JTextArea("A\tHello, can I make an appointment for tomorrow. \n" +
                    "B\tNo problem, what time would you like to book?\n" +
                    "A\t2pm.\n" +
                    "B\tI'm sorry, that time is not available. We have 10am and 5pm.\n" +
                    "A\tSorry, those times aren't good. Do you have 2pm the day after tomorrow?\n" +
                    "B\tYes, it's available. I will book that for you.\n" +
                    "A\tPerfect, thank you.");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "appointment, to book, available\n\n" +
                    "Spanish Translation:\n" +
                    "cita, reservar, disponible"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);

        }

        else if (opt1 == "Introductions" && opt2 == "Repeat name") {

            text = new JTextArea("A\tHello, my name is Danielle.\n" +
                    "B\tHello Danielle, my name is Michael.\n" +
                    "A\tSorry I didn't hear you, can you repeat that?\n" +
                    "B\tMy name is Michael.\n" +
                    "A\tMichael?\n" +
                    "B\tYes, it's Michael.\n" +
                    "A\tIt's nice to meet you Michael.\n" +
                    "B\tIt's nice to meet you too.");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "repeat\n\n" +
                    "Spanish Translation:\n" +
                    "repetir"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        else if (opt1 == "Basic employment issues" && opt2 == "Cover") {

            text = new JTextArea("A\tHello, is the manager there?\n" +
                    "B\tThey will arrive in an hour, do you want to call back or I can take a message?\n" +
                    "A\tCan you tell them that I am sick and can't come to work today.\n" +
                    "B\tWhat's the matter?\n" +
                    "A\tI've got a cold.\n" +
                    "B\tDid you find cover?\n" +
                    "A\tNot yet.\n" +
                    "B\tSend a message in the group chat, hopefully someone can cover your shift.\n" +
                    "A\tI will do that now, thank you.\n" +
                    "B\tWell, I hope you get well soon.\n" +
                    "A\tThank you, speak to you soon. Goodbye.\n" +
                    "B\tGoodbye.\n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "manager, to call back, to take a message, i've got a cold, find cover, send a message in the group chat, shift\n\n" +
                    "Spanish Translation:\n" +
                    "jefe, llamar de nuevo, darle el mensaje, Tengo un resfriado, encontraste una sustitución, Envía un mensaje al grupo de chat, turno"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        else if (opt1 == "Going shopping and asking for prices" && opt2 == "Refund") {

            text = new JTextArea("A\tHello there. I would like a refund for these items please. \n" +
                    "B\tHi there. Unfortunately, these items look like they have been used. I can offer an exchange or a gift voucher instead.\n" +
                    "A\tThat will not work. I want my money back.\n" +
                    "B\tWe cannot offer a refund for used items. You can exchange it for another item or I can issue you a gift voucher. \n" +
                    "A\tFine. But I will take this up with your manager. \n" +
                    "B\tI am the manager. \n" +
                    "A\tOh. Well, in that case I will just take the gift voucher. Thank you and have a good day. \n" +
                    "B\tYou too. Bye! \n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "refund, items, unfortunately, to use, exchange, gift voucher, manager\n\n" +
                    "Spanish Translation:\n" +
                    "reembolso, artículos, desgraciadamente, usados, intercambio, vale regalo, jefe"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        else if (opt1 == "Ordering food and drink" && opt2 == "Coffee Order") {

            text = new JTextArea("A\tCould I please have a regular decafe latte.\n" +
                    "B\tWe have no decafe, sorry about that.\n" +
                    "A\tThat's okay, I'll just have a regular latte then, and could I get that iced.\n" +
                    "B\tYes.\n" +
                    "A\tAnd, do you have sugar-free syrup?\n" +
                    "B\tWe have sugar-free caramel, vanilla and hazelnut.\n" +
                    "A\tCould I get the sugar-free vanilla please, and could I get that with oat milk please.\n" +
                    "B\tIs that to have in or to go?\n" +
                    "A\tTo go please.");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "decafe latte, iced, sugar-free syrup, caramel, vanilla, hazelnut, oat milk, is that to have here or to go?\n\n" +
                    "Spanish Translation:\n" +
                    "descafeinado con leche, con hielo, almíbar sin azúcar, leche de avena, Es para tomar aquí o para llevar"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        else if (opt1 == "Making Appointments" && opt2 == "Spelling your name") {

            text = new JTextArea("A\tHello, can I make an appointment for tomorrow.\n" +
                    "B\tWe're booked for the next week unfortunately.\n" +
                    "A\tCan I book for next week Tuesday then?\n" +
                    "B\tOf course, what time?\n" +
                    "A\tat 10am please.\n" +
                    "B\tWhat's your name?\n" +
                    "A\tJessica Taylor\n" +
                    "B\tCan you spell that for me?\n" +
                    "A\tYes, J E S S I C A, T A Y L O R.\n" +
                    "B\tThat's all done for you, see you next week.\n" +
                    "A\tThank you, see you then.");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "we are booked\n\n" +
                    "Spanish Translation:\n" +
                    "hemos reservado\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        else if (opt1 == "Basic employment issues" && opt2 == "Interview") {

            text = new JTextArea("A\tGood afternoon, how can I help you?\n" +
                    "B\tGood afternoon, I have an interview here today.\n" +
                    "A\tWhat time is the interview?\n" +
                    "B\tat 13:30.\n" +
                    "A\tWith who?\n" +
                    "B\tit's with Johnathan.\n" +
                    "A\tJohnathan works in the other building, it's not far.\n" +
                    "B\tHow do I get there?\n" +
                    "A\tIf you go right when you leave the building and then turn left. Best of luck with the interview.\n" +
                    "B\tThank you very much.");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "interview, right, turn left\n\n" +
                    "Spanish Translation:\n" +
                    "entrevista, derecha, Gire a la izquierda\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        else if (opt1 == "Ordering food and drink" && opt2 == "Water for table") {

            text = new JTextArea("A\tGood evening, how is it going?\n" +
                    "B\tExcellent thanks.\n" +
                    "A\tCan I get you some drinks while you look at the menu?\n" +
                    "B\tYes, can we get tap water for the table and two lemonades.\n" +
                    "A\tI'll get that for you now. Is this your daughter? She's beautiful.\n" +
                    "B\tActually, she's my wife.\n" +
                    "A\tOf course, excuse me, I'll get your drinks.");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "tap water\n\n" +
                    "Spanish Translation:\n" +
                    "agua del grifo"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        else if (opt1 == "Ordering food and drink" && opt2 == "Reservation") {

            text = new JTextArea("A\tHi there. Do you have a table for 4?\n" +
                    "B\tGood evening. Do you have a reservation with us?\n" +
                    "A\tI'm sorry I don't. \n" +
                    "B\tI'm afraid we're very busy tonight so there are no free tables. Would you like to wait or come back later?\n" +
                    "A\tHow long is the wait for a table? \n" +
                    "B\tIt is about one hour. I'm sorry about that. Are you happy to wait at the bar? \n" +
                    "A\tYes, no problem at all. We know this restaurant is popular. \n" +
                    "B\tI need to book you in. What is your name?\n" +
                    "A\tSmith.\n" +
                    "B\tGreat. You are booked in for 9 o'clock. The bar is over there. I will call you when your table is ready. \n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "reservation, wait, about\n\n" +
                    "Spanish Translation:\n" +
                    "reserva, demora, destinada, en la casa\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        else if (opt1 == "Socialising in the country" && opt2 == "Interview arrangements") {

            text = new JTextArea("A\tHi Derreck. How was your weekend?\n" +
                    "B\tHi Pete. Well, I actually secured a job interview for this admin role. I'm so excited!\n" +
                    "A\tThat is great news! Give me all the details.\n" +
                    "B\tWell, the interview is at 10:00 tomorrow. The dress code is smart-casual so I need to wear a shirt and jeans. \n" +
                    "A\tWill it be face-to-face or online?\n" +
                    "B\tFace-to-face so I need to be prepared. It's not far from here, only 3 stops on the no.32 bus. \n" +
                    "A\tGood luck, my friend I will be thinking of you. You will do great!\n" +
                    "B\tThank you! I will let you know how it goes. \n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "got a job interview, paperwork, dress code, casual, in person, only 3 stops on the no. 32 bus, I'll let you know\n\n" +
                    "Spanish Translation:\n" +
                    "conseguido una entrevista de trabajo, papel administrativo, código de vestir, informal, presencial, en linea, solo 3 paradas en la línea 32  de autobús, haré saber"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        else if (opt1 == "Asking and giving directions" && opt2 == "Delivery driver") {

            text = new JTextArea("A\tHello there. Is this John?\n" +
                    "B\tHi, yes it is. Who's speaking?\n" +
                    "A\tThis is Anna, the delivery driver. I am having trouble finding your house. \n" +
                    "B\tWhere are you right now?\n" +
                    "A\tI'm parked outside the train station. The train station is on my left. \n" +
                    "B\tOh, you're close by. Just cross the street, my house is number 12. It has a red door. \n" +
                    "A\tOh yes, I see it. I will be there soon. Goodbye!\n" +
                    "B\tSee you soon. Goodbye!");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "Delivery driver, having trouble\n\n" +
                    "Spanish Translation:\n" +
                    "Conductor de entrega, teniendo problemas"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        else if (opt1 == "Exchanging personal information" && opt2 == "Instagram") {

            text = new JTextArea("A\tIt's getting late, I think I'm gonna head off.\n" +
                    "B\tThat's a shame, it was nice getting to know you.\n" +
                    "A\tI know. But I have to work. \n" +
                    "B\tI understand. I work too.\n" +
                    "A\tWell, bye.\n" +
                    "B\tOh, can I get your number?\n" +
                    "A\tSorry, I don't give out my number.\n" +
                    "B\tWhat about your instagram?\n" +
                    "A\tSure, I suppose.\n" +
                    "B\tWhat's your username?");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "head off, give out, I suppose, username\n\n" +
                    "Spanish Translation:\n" +
                    "mexclar, repartir, supongo, nombre de usuario"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        else if (opt1 == "Exchanging personal information" && opt2 == "neighbour's parcel") {

            text = new JTextArea("A\tHello there, how can I help?\n" +
                    "B\tHi I have a parcel for your neighbour, but they're not home, can I leave it with you?\n" +
                    "A\tSure, no problem. Which neighbour?\n" +
                    "B\tNumber 17, down the corridor, on the left. Would you mind signing here?\n" +
                    "A\tAll done.\n" +
                    "B\tAnd just to confirm, what is your name?\n" +
                    "A\tSarah Smith. And that's S-A-R-A-H with a H at the end. \n" +
                    "B\tThanks Sarah. Have a good day!\n" +
                    "A\tYou too, bye. ");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "parcel, neighbour, corridor, signing\n\n" +
                    "Spanish Translation:\n" +
                    "terreno, vecina, corredora, firma"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        else if (opt1 == "Ordering food and drink" && opt2 == "Cocktails by card payment") {

            text = new JTextArea("A\tHi there we would like to order 2 cocktails please.\n" +
                    "B\tGood evening. Would you like to start a tab for your table or pay now?\n" +
                    "A\tStart a tab please.\n" +
                    "B\tGreat I will just need your card details and table number please.\n" +
                    "A\tOur table is number 17 and here are my details.\n" +
                    "B\tThank you. Just to let you know we have a 2 for 1 offer on cocktails all night and free refills on soft drinks.\n" +
                    "A\tGreat thanks!\n" +
                    "B\tThank you that is all done. Enjoy your night!");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "free refills, non-alcoholic drinks\n\n" +
                    "Spanish Translation:\n" +
                    "recargas gratis, bebidas sin alcohol"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        else if (opt1 == "Making invitations" && opt2 == "Disneyland") {

            text = new JTextArea("A\tHi John did you get my letter?\n" +
                    "B\tAbout your son's birthday party next week? \n" +
                    "A\tYeah that one. \n" +
                    "B\tAh, unfortunately we won't be able to come. My wife planned a trip to Disneyland for the whole family and so we're going to be away all week.\n" +
                    "A\tA trip to Disneyland? Your kids are lucky. Have fun and take lots of pictures! \n" +
                    "B\tThanks I will. And sorry again for not being able to come. \n" +
                    "A\tThat's okay. Have a good one!\n" +
                    "B\tYou too. \n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "lucky\n\n" +
                    "Spanish Translation:\n" +
                    "suerte"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        else if (opt1 == "Making invitations" && opt2 == "Help with child's birthday party") {

            text = new JTextArea("A\tHi Mary did you get my letter?\n" +
                    "B\tHi! About your son's birthday next week?\n" +
                    "A\tYes that one. \n" +
                    "B\tOf course! Me and the kids would be delighted. What time does it start?\n" +
                    "A\tThe party starts at 14:00.\n" +
                    "B\tDo you need help setting up?\n" +
                    "A\tI actually do. It's not easy organising a party for 30 kids. \n" +
                    "B\tI will come over at 12:00 then. \n" +
                    "A\tThat would be great.  See you then. \n" +
                    "B\tSee you then! ");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "setting up\n\n" +
                    "Spanish Translation:\n" +
                    "configurando"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        else if (opt1 == "University life" && opt2 == "Study in cafe") {

            text = new JTextArea("A\tHey, good to see you.\n" +
                    "B\tHey, how's things?\n" +
                    "A\tNot good, I'm stressed.\n" +
                    "B\tWhat's happening?\n" +
                    "A\tI have two assignments on Monday. I can't do them both.\n" +
                    "B\tWell, I have the same assignments, let's study together in the library?\n" +
                    "A\tI don't know. I don't like the library, it's too quiet.\n" +
                    "B\tLet's study in a cafe then, we can drink coffee and study. \n" +
                    "A\tActually that would be nice, should we go today after class?\n" +
                    "B\tI'm free after class, let's meet at the cafe next door.\n" +
                    "A\tOkay, see you then!\n" +
                    "B\tSee you later!\n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "assignments, next door\n\n" +
                    "Spanish Translation:\n" +
                    "asignaciones, al lado"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        else if (opt1 == "Cross-cultural experiences" && opt2 == "International food") {

            text = new JTextArea("A\tWhat is this?\n" +
                    "B\tIt's tea.\n" +
                    "A\tWhat kind of tea?\n" +
                    "B\tChai tea. It's made with black tea, milk and spices. Do you like it?\n" +
                    "A\tYes, I like it. I want to make it at home. \n" +
                    "B\tYou can buy the spices at the supermarket.\n" +
                    "A\tHow do I make it?\n" +
                    "B\tFirst you boil the milk, then you add the teabag and spices.\n" +
                    "A\tCan you text it to me so I don't forget.\n" +
                    "B\tNo problem, I'll do it now.\n" +
                    "A\tThank you.\n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "spices, boil, text\n\n" +
                    "Spanish Translation:\n" +
                    "especias, hervir, texto"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        frame.add(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Spanish A1 Conversation");
        frame.pack();
        frame.setVisible(true);
    }

    public void backButton() {
        SpanishA1 r = new SpanishA1();
        frame.dispose();
    }
}

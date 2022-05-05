import jdbacApi.jdbcCrud;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class A2Submission {

    JFrame frame;
    JPanel panel1;
    JButton backButton;
    JLabel label1, label2, label3;
    String conversation;
    JTextArea text, text2;
    GridBagConstraints gbc = new GridBagConstraints();


    public A2Submission(String opt1, String opt2) {
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
        if (opt1 == "Ordering food and drink" && opt2 == "Vegan pizza") {

            text = new JTextArea("A\tHi excuse me? I think I have the wrong order. \n" +
                    "B\tHi there, what seems to be the problem?\n" +
                    "A\tI asked for a vegan pizza and this seems to have cheese and meat all over it.\n" +
                    "B\tI'm so sorry about that there must have been a mix up. I will bring you a new one immediately. \n" +
                    "A\tThat is not good enough. My friends and I have been waiting over an hour already. I want a new pizza and my money back.\n" +
                    "B\tI will see if I can get that done for you. And please accept our sincere apologies.\n" +
                    "A\tApology accepted. Now please hurry up, I am starving. \n" +
                    "B\tI will let the kitchen know and your pizza should be with you as soon as possible. \n" +
                    "A\tThank you. \n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "wrong order, vegan, mix up, that is not good enough, waiting over, accept our sincere apologies, hurry up, starving, kitchen\n\n\n" +
                    "Spanish Translation:\n" +
                    "pedido incorrecto, vegana, confusión, Eso no es suficiente, esperando sobre, acepte nuestras más sinceras disculpas, dese prisa / muerto,a de hambre, cocina\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Asking and giving directions" && opt2 == "Delivery Driver") {

            text = new JTextArea("A\tHello there. Is this Mary?\n" +
                    "B\tHi, yes it is. Who's speaking?\n" +
                    "A\tThis is John, the delivery driver. I am having trouble finding your apartment. \n" +
                    "B\tYes it can be a little tricky. Go past the big black gates, turn left at the statue and you should see my building. I live on the 4th floor so I would recommend taking the lift.\n" +
                    "A\tI can't see a statue. Are you sure it's correct?\n" +
                    "B\tIt is a big stone statue, round and grey in colour. \n" +
                    "A\tOh yes, I see it. I will be there soon. Goodbye!\n" +
                    "B\tSee you soon. Goodbye!\n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "delivery driver, having trouble, tricky, gates, statue, recommend, lift, stone, round\n\n" +
                    "Spanish Translation:\n" +
                    "conductor,a de reparto, tengo un problema, complicado, verjas, estatua, recomendaría, ascensor, piedra, redonda\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Making Appointments" && opt2 == "Dentist") {

            text = new JTextArea("A\tHi there. I would like to book an appointment with my dentist, Clara. \n" +
                    "B\tHi there, I'm sorry but Clara is not available at the moment. Could I put you down with someone else?\n" +
                    "A\tClara has done my teeth for the past 10 years. She is very professional and I trust her. Where is she?\n" +
                    "B\tShe is on holiday until the 22nd. I can book you in with Clara on the 30th.\n" +
                    "A\tThat is too long to wait. Do you not have anything sooner?\n" +
                    "B\tLet me check for you. There is a cancellation on the 25th at 13:00. Would you like this appointment?\n" +
                    "A\tYes please. Thank you for that. I will see you then. Bye!\n" +
                    "B\tNo problem, Clara will see you then. Goodbye! \n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "put you down, done my teeth, trust, sooner, cancellation, appointment\n\n" +
                    "Spanish Translation:\n" +
                    "darle cita, cuidado mis dientes, confío, antes, cancelación, cita\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Ordering food and drink" && opt2 == "Reservation") {

            text = new JTextArea("A\tHi there. Do you have a table for 4?\n" +
                    "B\tGood evening. Do you have a reservation with us?\n" +
                    "A\tYes, I do, for 8 pm\n" +
                    "B\tWhat is your name?\n" +
                    "A\tIt's Jones.\n" +
                    "B\tOk, I can see your booking. I am sorry, the table isn't ready yet. It will be about 30 minutes. \n" +
                    "A\tI'm sorry, but I booked the table for 8pm - and it is now 8pm. \n" +
                    "B\tI do understand, but the people who booked the table at 6pm have not finished their meal. \n" +
                    "A\tWell, I suggest that you ask them to hurry up. We are going to sit down. \n" +
                    "B\tMay I ask you to wait in the bar while I get your table ready. \n" +
                    "A\tHa! That's a typical trick! You delay the table and ask me to wait in the bar so that I have to buy some drinks!\n" +
                    "B\tThat is not what I intended. I am sorry that your table is not ready. Please can you wait in the bar. May I get you a drink on the house?\n" +
                    "A\tThat sounds more like it. \n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "reservation, delay, intended, on the house\n\n" +
                    "Spanish Translation:\n" +
                    "reserva, demora, destinada, en la casa\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Going shopping and asking for prices" && opt2 == "Payment") {

            text = new JTextArea("A\tHi there. May I pay for these items please?\n" +
                    "B\tHello, yes of course. Your total is £35. Will you be paying by cash or card?\n" +
                    "A\tCard, please. \n" +
                    "B\tNo problem. You can insert or touch your card to the machine. \n" +
                    "A\tThank you. \n" +
                    "B\tI'm sorry your card hasn't worked. Can you try again?\n" +
                    "A\tLet me try another card. Here it is!\n" +
                    "B\tI'm sorry, but this card hasn't worked either. \n" +
                    "A\tHow embarassing. I will go and get some cash from the bank. \n" +
                    "B\tOk. No problem. I can hold onto your shopping for 30 minutes. \n" +
                    "A\tI will be back as soon as possible. \n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "cash, card, insert, touch, hasn't worked, \n\n" +
                    "Spanish Translation:\n" +
                    "dinero en efectivo, tarjeta, insertar, toque, no ha funcionado\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Health matters" && opt2 == "Sick relative") {

            text = new JTextArea("A\tHey, what are your plans for Saturday night?\n" +
                    "B\tI'm in Italy, didn't you know?\n" +
                    "A\tOh no, I didn't know that. When will you return?\n" +
                    "B\tI meant to stay for 2 weeks but my grandma is unwell, so I am staying another week.\n" +
                    "A\tI hope she gets well soon.\n" +
                    "B\tThank you, it seems as if she will.\n" +
                    "A\tLet me know if you want to talk about it, okay. \n" +
                    "B\tI will, thank you for offering. Take care, speak soon.\n" +
                    "A\tTake care.\n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "indisposed\n\n" +
                    "Spanish Translation:\n" +
                    "indispuesta\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Making invitations" && opt2 == "Charity") {

            text = new JTextArea("A\tGood morning sir, can I speak with you for a moment?\n" +
                    "B\tNo, I am busy.\n" +
                    "A\tIt will just take a second.\n" +
                    "B\tI am going to work.\n" +
                    "A\tI just wanted to speak to you about our charitable organisation.\n" +
                    "B\tI am not interested.\n" +
                    "A\tSo you don't give to charity?\n" +
                    "B\tStop following me.\n" +
                    "A\tBut sir, if you give me your email then you can choose to sign up or not in your own time.\n" +
                    "B\tLeave me alone.\n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "charitable organisation, don't give to charity, choose, sign up, leave me alone\n\n" +
                    "Spanish Translation:\n" +
                    "organización caritativa, no des a la caridad, escorger, inscribirse, Déjame en paz\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Making invitations" && opt2 == "Lunch") {

            text = new JTextArea("A\tDo you want to go for lunch at the weekend?\n" +
                    "B\tI'm afraid not, I work on weekends.\n" +
                    "A\tWhich days do you have off next week?\n" +
                    "B\tI am free on Tuesday and Wednesday\n" +
                    "A\tI go to University on those days unfortunately.\n" +
                    "B\tThat's a shame, what about on Monday morning?\n" +
                    "A\tI am also free on Monday morning. How about we meet at 10 at the cafe near your house.\n" +
                    "B\tPerfect, see you on Monday.\n" +
                    "A\tSee you then!\n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "to go for lunch, I'm afraid not, days do you have off, free, that's a shame\n\n" +
                    "Spanish Translation:\n" +
                    "ir a almorzar, Me temo que no, días tienes libre, gratis, es una pena\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Ordering food and drink" && opt2 == "Delayed drink order") {

            text = new JTextArea("A\tExcuse me, where is my coffee. I've been waiting over 20 minutes.\n" +
                    "B\tWe're really busy, they are making the drinks as fast as they can, can you wait a little longer?\n" +
                    "A\tThis is unacceptable, I am very busy this morning. Some people who ordered after me have already got their drinks.\n" +
                    "B\tI'm sorry, I will check how long it will be. What did you order?\n" +
                    "A\tThank you, I ordered a mocha.\n" +
                    "B\tSorry there was a mix up, I will make it for you right away.\n" +
                    "A\tThank you very much.\n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "mix up\n\n" +
                    "Spanish Translation:\n" +
                    "confusión\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Socialising in the country" && opt2 == "Family size") {

            text = new JTextArea("A\tWho were you chatting to in the cafe?\n" +
                    "B\tOh, that's Suzanna.\n" +
                    "A\tHow do you know each other?\n" +
                    "B\tShe's my sister.\n" +
                    "A\tReally? But you don't look alike.\n" +
                    "B\tYes, she's my half sister actually. Do you have any siblings?\n" +
                    "A\tNo, I'm an only child.\n" +
                    "B\tYou are lucky!  I have five sisters - it is very noisy at home.\n" +
                    "A\tI think you are lucky. How nice to have a big family.\n" +
                    "B\tYes, we are. And we also have 3 dogs and 2 cats. How about you?\n" +
                    "A\tNo, my mum hates animals.\n" +
                    "B\tMust have been very quiet at home then!\n" +
                    "A\tYes, it was very quiet. But I had many good friends. \n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "half-sister, only child, noisy\n\n" +
                    "Spanish Translation:\n" +
                    "media hermana, Hija única, ruidosa\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Ordering food and drink" && opt2 == "QR code") {

            text = new JTextArea("A\tGood morning, can I get a large almond milk latte please?\n" +
                    "B\tSorry about this but, we are all out of almond milk. We do have oat milk or soya milk though. \n" +
                    "A\tIn that case I'll just have a peppermint tea.\n" +
                    "B\tSorry about that, can I get you anything else?\n" +
                    "A\tNo, thank you.\n" +
                    "B\tThat'll be 2.40 please.\n" +
                    "A\tI have a subscription with you.\n" +
                    "B\tCan you scan the QR code for me?\n" +
                    "A\tNo problem. \n" +
                    "B\tThank you. Have a nice day.\n" +
                    "A\tYou too!\n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "almond, oat, soya, peppermint, subscription, scan\n\n" +
                    "Spanish Translation:\n" +
                    "almendra, avena, soja, menta, suscripción, escanear\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Making Appointments" && opt2 == "Doctor") {

            text = new JTextArea("A\tGood Morning, I'd like to make an appointment with Dr Tiberal.\n" +
                    "B\tWhat's your date of birth?\n" +
                    "A\t27th of June 1989\n" +
                    "B\tAnd your name?\n" +
                    "A\tIt's Jane Brown.\n" +
                    "B\tThank you. So, Ms Brown, what's the problem?\n" +
                    "A\tI have had an earache for the last two days and I would like to see the doctor.\n" +
                    "B\tOkay, we have nothing today. However, we have appointments tomorrow at 10:00 or 14:45.\n" +
                    "A\tCan I have 14:45 please.\n" +
                    "B\tOf course, and I can also see from your record that you need a flu jab. Can I book you in for that too?\n" +
                    "A\tActually, I would prefer to do it another time.\n" +
                    "B\tThat's fine, but please book for your flu jab soon.\n" +
                    "A\tI will, goodbye.\n" +
                    "B\tGoodbye.\n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "earache, flujab\n\n" +
                    "Spanish Translation:\n" +
                    "dolor de oidos, vacuna de la gripe\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Making travel arrangements" && opt2 == "Expired ticket") {

            text = new JTextArea("A\tGood morning, tickets please. \n" +
                    "B\tGood morning, here you go. \n" +
                    "A\tYour ticket isn't valid for this part of the journey. You can pay the rest by card now. \n" +
                    "B\tBut the lady at the ticket office told me it will be okay for the whole journey. \n" +
                    "A\tI'm sorry you must have misunderstood. Your ticket expired 3 stops ago so you have to pay up or I'm going to have to ask you to get off at the next station.\n" +
                    "B\tFine. How much is the outstanding amount?\n" +
                    "A\t£3.20 please. \n" +
                    "B\tHere's my card.\n" +
                    "A\tThank you. Have a good day. \n" +
                    "B\tYou too. \n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "valid, misunderstood, outstanding\n\n" +
                    "Spanish Translation:\n" +
                    "válida, incomprendida, pendiente\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Exchanging personal information" && opt2 == "Age restricted") {

            text = new JTextArea("A\tHi there, I have a package for Ms. Anna Smith?\n" +
                    "B\tHi, that's me, thanks. \n" +
                    "A\tMs. Smith can I see some ID please as the item you have ordered is age restricted. \n" +
                    "B\tOh? I don't remember ordering anything dangerous. \n" +
                    "A\tI believe the package contains a set of kitchen knives. \n" +
                    "B\tOh yes of course! Sorry, I will get my ID right away. \n" +
                    "A\tThank you. \n" +
                    "B\tHere you go. \n" +
                    "A\tCan you confirm your birthday for me?\n" +
                    "B\t17th of May 1989. \n" +
                    "A\tThank you, here's your item. Have a good day!\n" +
                    "B\tThank you, have a good day. \n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "age restricted\n\n" +
                    "Spanish Translation:\n" +
                    "edad restringida\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Introductions" && opt2 == "1st day in job") {

            text = new JTextArea("A\tHi, how's it going?\n" +
                    "B\tGood thanks, how are you?\n" +
                    "A\tI'm great. Is it your first day today?\n" +
                    "B\tYes it is. I am quite nervous. \n" +
                    "A\tDon't be nervous we were all new once. I'm Claire by the way, it's nice to meet you. \n" +
                    "B\tNice to meet you too. I'm Lucy. How long have you worked for the company?\n" +
                    "A\tOh a long time. Over 5 years. How are you finding the job so far?\n" +
                    "B\tExhausting but rewarding. \n" +
                    "A\tYou will get used to it don't worry. \n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "exhausting but rewarding\n\n" +
                    "Spanish Translation:\n" +
                    "agotador pero gratificante\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Introductions" && opt2 == "Job offer") {

            text = new JTextArea("A\tGood morning, am I speaking to Lucy?\n" +
                    "B\tHi, yes that's me. \n" +
                    "A\tHi Lucy. I'm calling from H&M, following your interview we are delighted to offer you a position. When can you start?\n" +
                    "B\tThat's brilliant news! I am busy this weekend but I can start as soon as Monday.\n" +
                    "A\tThat's perfect. When you come in to the shop, just ask for me, my name is Tim Brown. Can you please bring your passport so we can get the necessary paperwork done.\n" +
                    "B\tYes I will do. Thank you so much again. What time should we meet?\n" +
                    "A\tHow about 10am?\n" +
                    "B\tThat's perfect. See you then!\n" +
                    "A\tGreat I will see you Monday at 10 am. Bye now!\n" +
                    "B\tBye-bye!\n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "following, position, paperwork\n\n" +
                    "Spanish Translation:\n" +
                    "siguiente, posición, papeleo\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Asking and giving directions" && opt2 == "Hospital Visit") {

            text = new JTextArea("A\tHi there I'm here too see Mr. Smith. \n" +
                    "B\tGood morning, I need the full name of the patient and the time he was taken in.\n" +
                    "A\tDavid Smith, he was admitted yesterday around 9pm.\n" +
                    "B\tWe are only accepting close relatives of Mr. Smith for visits at the moment. What is your relation to the patient? \n" +
                    "A\tI'm his wife.\n" +
                    "B\tGreat Mrs. Smith I just need to see some ID.\n" +
                    "A\tHere you go. \n" +
                    "B\tThank you. His ward is the second door on the left at the end of the corridor. \n" +
                    "A\tThank you very much for your help. Have a good day!\n" +
                    "B\tThanks, you too. \n" +
                    "B\tBye-bye!\n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "patient, admitted, ward\n\n" +
                    "Spanish Translation:\n" +
                    "paciente, aceptado, pabellón\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Ordering food and drink" && opt2 == "Cocktails") {

            text = new JTextArea("A\tHi there we would like to order 2 cocktails please.\n" +
                    "B\tComing right up. Would you like to start a tab for your table or pay now?\n" +
                    "A\tPay now please.\n" +
                    "B\tOkay your total is £22.50 please.\n" +
                    "A\tI thought cocktails were on a 2 for 1 offer?\n" +
                    "B\tThat deal is only valid from Monday to Thursday I’m afraid.\n" +
                    "A\tWell it didn’t say that anywhere. We will leave it for now, thank you.\n" +
                    "B\tI’m sorry to hear that. I hope you have a good night.\n" +
                    "A\tThanks, you too.\n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "a tab, 2 for 1 offer, valid\n\n" +
                    "Spanish Translation:\n" +
                    "una pestaña, 2 por 1 oferta, válido\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Socialising in the country" && opt2 == "Succulent") {

            text = new JTextArea("A\tIs this plant real?\n" +
                    "B\tYes, it's real.\n" +
                    "A\tWhat kind of plant is it?\n" +
                    "B\tIt's a succulent.\n" +
                    "A\tWhat is that?\n" +
                    "B\tIt's a tropical plant that doesn't need much water but needs a lot of sunlight.\n" +
                    "A\tDo you have any other plants?\n" +
                    "B\tYes I have a lot of other plants, it's my hobby. Do you have a hobby?\n" +
                    "A\tI have many hobbies. I like painting the most.\n" +
                    "B\tDo you have any pictures? I want to see them.\n" +
                    "A\tYes, I have them on tiktok. Do you want to see?\n" +
                    "B\tCan I follow you? Send me the link.\n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "succulent, tropical, sunlight, link\n\n" +
                    "Spanish Translation:\n" +
                    "suculenta, tropical, luz del sol, Enlace\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Making invitations" && opt2 == "Children at wedding") {

            text = new JTextArea("A\tIs this plant real?\n" +
                    "B\tYes, it's real.\n" +
                    "A\tWhat kind of plant is it?\n" +
                    "B\tIt's a succulent.\n" +
                    "A\tWhat is that?\n" +
                    "B\tIt's a tropical plant that doesn't need much water but needs a lot of sunlight.\n" +
                    "A\tDo you have any other plants?\n" +
                    "B\tYes I have a lot of other plants, it's my hobby. Do you have a hobby?\n" +
                    "A\tI have many hobbies. I like painting the most.\n" +
                    "B\tDo you have any pictures? I want to see them.\n" +
                    "A\tYes, I have them on tiktok. Do you want to see?\n" +
                    "B\tCan I follow you? Send me the link.\n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "wedding, RSVP\n\n" +
                    "Spanish Translation:\n" +
                    "enlace, boda, confirmación\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Making invitations" && opt2 == "Wedding RSVP") {

            text = new JTextArea("A\tHi Rachel, did you get my wedding invitation?\n" +
                    "B\tI did, yes.\n" +
                    "A\tI didn't recieve your RSVP yet.\n" +
                    "B\tI don't know if I can make it yet, I have to travel a lot for work.\n" +
                    "A\tI'm booking the catering next week, so can you get back to me as soon as possible?\n" +
                    "B\tLet me check my schedule, what was the date again?\n" +
                    "A\tMarch 18th.\n" +
                    "B\tThat fits perfectly actually/ It may well be possible/ I have to check\n" +
                    "A\tWhile I have you, which meal would you like?\n" +
                    "B\tI'll have the vegetarian options please, if you don't mind.\n" +
                    "A\tThanks so much, see you soon!\n" +
                    "B\tLook forward to it!\n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "catering, schedule, vegetarian\n\n" +
                    "Spanish Translation:\n" +
                    "abastecimiento, calendario, vegetariano\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Cross-cultural experiences" && opt2 == "Omelette") {

            text = new JTextArea("A\tWhat is this?\n" +
                    "B\tIt's a Tortilla.\n" +
                    "A\tIt looks like an omelette.\n" +
                    "B\tYes, it's an egg and potato omelette. Do you like it?\n" +
                    "A\tYes I do. How do you make it?\n" +
                    "B\tI didn't make it, my mum made it  for me. Would you like to take some home? I can put a piece in a container.\n" +
                    "A\tOh, that would be lovely. Remind me to return your container next time I come over.\n" +
                    "B\tDon't worry, it's just an old takeaway box. It's clean.\n" +
                    "A\tExcellent, is it recycleable?\n" +
                    "B\tI think so, but you must check. \n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "omelette, takeaway box, recycleable\n\n" +
                    "Spanish Translation:\n" +
                    "tortilla, aja para llevar, reciclable\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Ordering food and drink" && opt2 == "Cocktails") {

            text = new JTextArea("A\tHi there we would like to order 2 cocktails please.\n" +
                    "B\tGood evening. Here's the menu which one would you like?\n" +
                    "A\tI will have an espresso martini and my friend will have the pina colada.\n" +
                    "B\tGreat, coming right up. Are you going to be paying card or cash?\n" +
                    "A\tCard, please. \n" +
                    "B\tThere, these are ready for you. \n" +
                    "A\tWe only ordered two, why are there 4 drinks?\n" +
                    "B\tOh, it is happy hour, which means all are cocktails are on a 2 for 1 offer. \n" +
                    "A\tWow, great thanks! \n" +
                    "B\tYou're welcome. Enjoy your night. \n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "happy hour\n\n" +
                    "Spanish Translation:\n" +
                    "hora feliz\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Health matters" && opt2 == "Visiting patient") {

            text = new JTextArea("A\tHi there I'm here to see Mr. Smith. \n" +
                    "B\tGood morning, I need the full name of the patient and the time he was taken in.\n" +
                    "A\tDavid Smith, he was admitted yesterday around 9pm.\n" +
                    "B\tWe are only accepting close relatives of Mr. Smith for visits at the moment. What is your relationship to the patient? \n" +
                    "A\tI'm his wife.\n" +
                    "B\tGreat Mrs. Smith I just need to see some ID.\n" +
                    "A\tHere you go. \n" +
                    "B\tThank you. His room is the second door on the left at the end of the corridor. \n" +
                    "A\tHow is he doing? Is he eating normally? \n" +
                    "B\tYes, he had his breakfast this morning everything seems good. The doctor is just making his rounds so you will be able to talk to him about this in more detail. \n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "making his rounds\n\n" +
                    "Spanish Translation:\n" +
                    "haciendo sus rondas\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        if (opt1 == "Weather and weather conditions" && opt2 == "Clothing for weather") {

            text = new JTextArea("A\tHello, I'm back.\n" +
                    "B\tWelcome home. Just in time, I'm about to leave now.\n" +
                    "A\tYou should wear a jacket, it's cold today.\n" +
                    "B\tIs it? But it is sunny.\n" +
                    "A\tThe sky is clear but it's very windy.\n" +
                    "B\tI'll bring a scarf too.\n" +
                    "A\tWhere are you going?\n" +
                    "B\tI'm going to the supermarket, do you want anything?\n" +
                    "A\tWe don't have any milk, can you get some.\n" +
                    "B\tSure, see you in a bit.\n" +
                    "A\tBye.\n");
            gbc.gridy = 4;
            panel1.add(text, gbc);

            text2 = new JTextArea("Words to study:\n" +
                    "just in time, scarf\n\n" +
                    "Spanish Translation:\n" +
                    "justo a tiempo, bufanda\n"
            );
            gbc.gridy = 5;
            panel1.add(text2, gbc);
        }

        frame.add(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Spanish A2 Conversation");
        frame.pack();
        frame.setVisible(true);
    }

    public void backButton() {
        SpanishA2 r = new SpanishA2();
        frame.dispose();
    }
}

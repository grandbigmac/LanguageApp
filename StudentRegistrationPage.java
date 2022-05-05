import jdbacApi.jdbcCrud;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Random;


public class StudentRegistrationPage {

    JFrame frame;
    JPanel regPanel;
    JLabel label1, label2, label3, label4, label5, label6;
    JTextField nameText, emailText;
    JPasswordField passwordText;
    JPasswordField confirmPassText;
    JButton backButton, submitButton;
    JSpinner dobDays, dobMonths, dobYears;
    static SpinnerNumberModel daysModel = new SpinnerNumberModel(1, 1, 31, 1);
    static SpinnerNumberModel monthsModel = new SpinnerNumberModel(1, 1, 12, 1);
    static SpinnerNumberModel yearsModel = new SpinnerNumberModel(2000, 1920, 2022, 1);
    GridBagConstraints gbc = new GridBagConstraints();

    public StudentRegistrationPage() {

        frame = new JFrame();
        regPanel = new JPanel();
        regPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        regPanel.setLayout(new GridBagLayout());

        gbc.insets = new Insets(5, 5, 5, 5);

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
        regPanel.add(backButton, gbc);


        //Title text for the page
        label1 = new JLabel("REGISTER AS A STUDENT");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        regPanel.add(label1, gbc);

        //Field to enter user's name for registration
        label2 = new JLabel("NAME:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = GridBagConstraints.NONE;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        regPanel.add(label2, gbc);
        nameText = new JTextField();
        gbc.gridwidth = 3;
        gbc.gridx = 1;
        gbc.gridy = 2;
        regPanel.add(nameText, gbc);

        //Field to enter user's email address
        label3 = new JLabel("EMAIL:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        regPanel.add(label3, gbc);
        emailText = new JTextField();
        gbc.gridwidth = 3;
        gbc.gridx = 1;
        gbc.gridy = 3;
        regPanel.add(emailText, gbc);

        //Field to create a password for the user's account
        label4 = new JLabel("PASSWORD:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        regPanel.add(label4, gbc);
        passwordText = new JPasswordField();
        gbc.gridwidth = 3;
        gbc.gridx = 1;
        gbc.gridy = 4;
        regPanel.add(passwordText, gbc);

        //Field to confirm the user's password, must match the contents of the previous field
        label5 = new JLabel("CONFIRM PASSWORD:");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        regPanel.add(label5, gbc);
        confirmPassText = new JPasswordField();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        regPanel.add(confirmPassText, gbc);

        //Field to enter user's date of birth
        label6 = new JLabel("ENTER DATE OF BIRTH:");
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        regPanel.add(label6, gbc);
        dobDays = new JSpinner();
        gbc.gridx = 1;
        dobDays.setModel(daysModel);
        regPanel.add(dobDays, gbc);
        dobMonths = new JSpinner();
        gbc.gridx = 2;
        dobMonths.setModel(monthsModel);
        regPanel.add(dobMonths, gbc);
        dobYears = new JSpinner();
        gbc.gridx = 3;
        dobYears.setModel(yearsModel);
        regPanel.add(dobYears, gbc);

        //Submit button, needs to be triggered when user presses enter button
        submitButton = new JButton("SUBMIT");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //When pressed, loginButton captures the information entered in the registration fields and creates a new user object out of that information
                try {
                    submitStudentDB();
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                } catch (InvalidKeySpecException | NoSuchAlgorithmException ex) {
                    ex.printStackTrace();
                }
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 7;
        regPanel.add(submitButton, gbc);


        frame.add(regPanel);
        frame.getRootPane().setDefaultButton(submitButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Registration Page");
        frame.pack();
        frame.setVisible(true);

    }

    //Method for submitting student using text file storage
    public void submitStudent() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {

        //Create new student object for new user
        Student r = new Student();

        //Set the student's password
        final String password = passwordText.getText().toString();
        final String confirmPW = confirmPassText.getText().toString();

        if (password.equals(confirmPW)) {

            r.setStudentPassword(securePassword.generateStrongHash(password));
            //System.out.println(r.studentPassword);

            //Set student name
            r.setStudentName(nameText.getText());
            //Set student email
            r.setStudentEmail(emailText.getText());

            //Generate a new User ID using 6 random integers concatenated to a string then parsed back into an integer
            //Need to add functionality where the number generated is unique to the user, and no other user can have the same userID
            String userID = "";
            Random rand = new Random();

            for (int i = 0; i < 6; i++) {
                int number = rand.nextInt(10);
                userID = userID + number;
            }
            r.setStudentID(Integer.parseInt(userID));

            //Set student's start date to the date of object generation
            LocalDate dateObject = LocalDate.now();
            r.setUserStartDate(dateObject);

            //Write new user's email and password to separate files for login validation

            try {
                String emailFile = "studentemail.txt";
                FileWriter fw = new FileWriter(emailFile, true);
                fw.write(r.getStudentEmail() + "\n");
                fw.close();

                String passwordFile = "studentpassword.txt";
                FileWriter fw2 = new FileWriter(passwordFile, true);
                fw2.write(r.getStudentPassword() + "\n");
                fw2.close();
            }
            catch(IOException ioe) {
                //System.out.println("IOException: " + ioe.getMessage());
            }

            JOptionPane.showMessageDialog(frame, "New Student Registered!");
            //System.out.println("user written");
            backButton();

        }
        else {
            JOptionPane.showMessageDialog(frame, "Error, passwords do not match.");
        }
    }

    //Update submission method using databases
    public void submitStudentDB() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {

        //Create new student object for new user
        Student r = new Student();

        //Set the student's password
        final String password = passwordText.getText().toString();
        final String confirmPW = confirmPassText.getText().toString();

        if (password.equals(confirmPW)) {

            r.setStudentPassword(securePassword.generateStrongHash(password));
            //System.out.println(r.studentPassword);

            //Set student name
            r.setStudentName(nameText.getText());
            //Set student email
            r.setStudentEmail(emailText.getText());

            //Generate a new User ID using 6 random integers concatenated to a string then parsed back into an integer
            //Need to add functionality where the number generated is unique to the user, and no other user can have the same userID
            String userID = "";
            Random rand = new Random();

            for (int i = 0; i < 6; i++) {
                int number = rand.nextInt(10);
                userID = userID + number;
            }
            r.setStudentID(Integer.parseInt(userID));

            //Set student's birthday to the numbers set in the date spinners
            String birthday = dobYears.getValue() + "-" + dobMonths.getValue() + "-" + dobDays.getValue();
            r.setUserBirthday(Date.valueOf(birthday));

            //Set student's start date to the date of object generation
            LocalDate dateObject = LocalDate.now();
            r.setUserStartDate(dateObject);

            r.setProgress("");
            r.setLanguagesStudying("English, Spanish");

            jdbcCrud.insertStudent(r.getStudentID(), r.getStudentEmail(), r.getStudentName(), (Date) r.getUserBirthday(), r.getProgress(), r.getLanguagesStudying(), r.getStudentPassword());

            JOptionPane.showMessageDialog(frame, "New Student Registered!");
            //System.out.println("user written");
            backButton();

        } else {
            JOptionPane.showMessageDialog(frame, "Error, passwords do not match.");
        }
    }

    public void backButton() {
            StudentLoginPage r = new StudentLoginPage();
            frame.dispose();
        }



    }


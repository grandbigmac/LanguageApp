import jdbacApi.connectDB;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class TeacherLoginPage implements ActionListener {

    JFrame frame;
    JPanel loginPanel;
    JLabel label1, label2, label3, label4, label5, label6;
    JTextField emailText;
    JPasswordField passwordText;
    JButton loginButton;

    GridBagConstraints gbc = new GridBagConstraints();

    public TeacherLoginPage() {

        frame = new JFrame();

        loginPanel = new JPanel();
        loginPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        loginPanel.setLayout(new GridBagLayout());

        gbc.insets = new Insets(5, 5, 5,5);

        //Image/logo at top of the page
        try {
            BufferedImage loginLogo = ImageIO.read(new File("loginpageicon.jpg"));
            label1 = new JLabel(new ImageIcon(loginLogo));
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            loginPanel.add(label1, gbc);
        }
        catch (IOException e) {
            //System.out.println("Could not find file " + "loginpageicon.jpg");
        }

        //Title for Teacher Login Page
        label2 = new JLabel("TEACHER LOGIN");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.CENTER;
        loginPanel.add(label2, gbc);

        //Field to enter user's email address
        label3 = new JLabel("Email:");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        loginPanel.add(label3, gbc);
        emailText = new JTextField();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        loginPanel.add(emailText, gbc);

        //Field to enter user's password
        label4 = new JLabel("Password:");
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        loginPanel.add(label4, gbc);
        passwordText = new JPasswordField();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        loginPanel.add(passwordText, gbc);

        //Submission Button, needs to listen for enter button to submit
        loginButton = new JButton("Submit");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                checkLogInDB(emailText, passwordText);
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        loginPanel.add(loginButton, gbc);

        //Hypertext to change to student login page
        label5 = new JLabel("Student Login Page");
        //Fix when teacher login page is completed
        label5.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {
                StudentLoginPage i = new StudentLoginPage();
                frame.dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label5.setCursor(Cursor.getDefaultCursor());
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 7;
        loginPanel.add(label5, gbc);

        //Hypertext to register for an account
        label6 = new JLabel("Register for a new account");
        label6.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                TeacherRegistrationPage r = new TeacherRegistrationPage();
                frame.dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label6.setCursor(Cursor.getDefaultCursor());
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 8;
        loginPanel.add(label6, gbc);

        frame.add(loginPanel);
        frame.getRootPane().setDefaultButton(loginButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Login Page");
        frame.pack();
        frame.setVisible(true);
    }

    public boolean logInValidate(String password, String storedAuthentication) throws NoSuchAlgorithmException, InvalidKeySpecException {

        char[] passwordAsCharArray = password.toCharArray();
        String[] params = storedAuthentication.split(":");

        int iterations = Integer.parseInt(params[0]);
        byte[] salt = securePassword.fromHex(params[1]);
        byte[] hash = securePassword.fromHex(params[2]);

        PBEKeySpec spec = new PBEKeySpec(passwordAsCharArray, salt, iterations, 64 * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] testHash = skf.generateSecret(spec).getEncoded();

        ////System.out.println(hash);
        ////System.out.println(testHash);

        return securePassword.slowEquals(hash, testHash);
    }

    //Old method for validating login from text files
    public void checkEmailPassword(JTextField email, JPasswordField password) throws FileNotFoundException, NoSuchAlgorithmException, InvalidKeySpecException {

        String em = email.getText();
        String pw = password.getText();

        ArrayList<String> emailAL = new ArrayList<>();
        ArrayList<String> passwordAL = new ArrayList<>();

        //CODE TO FILL ARRAYLIST WITH DATA FROM EMAIL AND PASSWORD FILES
        Scanner scanner = new Scanner(new File(("teacheremail.txt")));

        while (scanner.hasNext()) {
            emailAL.add(scanner.nextLine());
        }

        scanner = new Scanner(new File("teacherpassword.txt"));
        while (scanner.hasNext()) {
            passwordAL.add(scanner.nextLine());
        }

        for (int i = 0; i < emailAL.size(); i++) {

            if (em.equals(emailAL.get(i))) {

                Boolean login = logInValidate(pw, passwordAL.get(i));
                //System.out.println("Email matches");
                if (login == false) {

                    JOptionPane.showMessageDialog(frame, "Login credentials incorrect");
                    break;
                }
                else {

                    JOptionPane.showMessageDialog(frame, "Login success!");
                    frame.dispose();
                    TeacherLandingPage r = new TeacherLandingPage();
                    break;
                }
            }
            if (i == emailAL.size() - 1 && emailAL.get(i) != em) {
                JOptionPane.showMessageDialog(frame, "Login credentials incorrect");
            }
        }

    }


    public void checkLogInDB(JTextField email, JPasswordField password) {

        String em = email.getText();
        String pw = password.getText();
        Connection con = connectDB.getConnection();
        Statement stmt = null;

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select teacherPassword from teachers WHERE teacherEmail = '" + em + "'");
            int n = 0;
            while (rs.next()) {
                int numColumns = rs.getMetaData().getColumnCount();
                n++;
                for (int i = 1; i <= numColumns; i++) {
                    Boolean login = logInValidate(pw, rs.getObject(i).toString());
                    //System.out.println("Email matches");
                    if (login == false) {

                        JOptionPane.showMessageDialog(frame, "Login credentials incorrect");
                        break;
                    } else {

                        JOptionPane.showMessageDialog(frame, "Login success!");
                        TeacherLandingPage r = new TeacherLandingPage();
                        frame.dispose();
                        break;
                    }
                }
                //System.out.println("");
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
}

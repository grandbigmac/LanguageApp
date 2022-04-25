import jdbacApi.connectDB;
import jdbacApi.jdbcCrud;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.sql.Date;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, FileNotFoundException {

        //RegistrationPage r = new RegistrationPage();
        //LoginPage i = new LoginPage();
        //FirstPage r = new FirstPage();
        SpanishFirstPage r = new SpanishFirstPage();

        //jdbcCrud.insertStudent(295829, "testemail@email.com", "test name", Date.valueOf("1999-02-23"), "progressing", "English", "1000:cc229c53d761ad157dbf93c871f37b27:97132d39e44d5911f64082308cef3d7be43836b13024a05b158241ec86ce4a82ba50d2c28492b4f46e24903816f651980d94c26b5c033f925ec2a0d46dd92e5b" );

        //jdbcCrud.getStudent("Select * from students WHERE studentEmail = ('harryemail@email.com')");
        //jdbcCrud.insertStudent(283958, "nathanemail@email.com", "Nathan Hamm", Date.valueOf("2000-11-10"), "progressing", "English", "1000:cc229c53d761ad157dbf93c871f37b27:97132d39e44d5911f64082308cef3d7be43836b13024a05b158241ec86ce4a82ba50d2c28492b4f46e24903816f651980d94c26b5c033f925ec2a0d46dd92e5b");


    }


}

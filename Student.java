import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Date;

public class Student extends User{

    @Override
    void User(){}

    int userID;
    int userBirthday;
    LocalDate userStartDate;

    int studentID;
    String studentEmail;
    String progress;
    String studentName;

    char[] studentPassword;

    // GETTER METHODS

    // USER ID
    private int getUserID() {
        return userID;
    }

    // USER BIRTHDAY
    private int getUserBirthday() {
        return userBirthday;
    }

    // USER START DATE
    private LocalDate getUserStartDate() {
        return userStartDate;
    }

    // STUDENT ID
    private int getStudentID() {
        return studentID;
    }

    // STUDENT EMAIL
    private String getStudentEmail() {
        return studentEmail;
    }

    // STUDENT PROGRESS
    private String getProgress() {
        return progress;
    }

    // STUDENT NAME
    private String getStudentName() { return studentName;}


    // SETTER METHODS

    // USER ID
    void setUserID(int i) {
        userID = i;
    }

    // USER BIRTHDAY
    void setUserBirthday(int i) {
        userBirthday = i;
    }

    // USER START DATE
    // maybe better way to do this where it's set on object creation
    void setUserStartDate(LocalDate i) {
        userStartDate = i;
    }

    // STUDENT ID
    void setStudentID(int i) {
        studentID = i;
    }

    // STUDENT EMAIL
    void setStudentEmail(String i) {
        studentEmail = i;
    }

    // STUDENT PROGRESS
    void setProgress(String i) {
        progress = i;
    }

    // STUDENT NAME
    void setStudentName(String i) {
        studentName = i;
    }

    // STUDENT PASSWORD
    void setStudentPassword(char[] i) {
        studentPassword = i;
    }

}

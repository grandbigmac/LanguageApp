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
    public int getUserID() {
        return userID;
    }

    // USER BIRTHDAY
    public int getUserBirthday() {
        return userBirthday;
    }

    // USER START DATE
    public LocalDate getUserStartDate() {
        return userStartDate;
    }

    // STUDENT ID
    public int getStudentID() {
        return studentID;
    }

    // STUDENT EMAIL
    public String getStudentEmail() {
        return studentEmail;
    }

    // STUDENT PROGRESS
    public String getProgress() {
        return progress;
    }

    // STUDENT NAME
    public String getStudentName() { return studentName;}

    // STUDENT PASSWORD
    public String getStudentPassword() {
        String pw = "";

        for (int i = 0; i < studentPassword.length; i++){
            pw = pw + studentPassword[i];
        }

        return pw;
    }


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

import java.util.Date;

public class Teacher extends User{

    @Override
    void User(){}

    int userID;
    int userBirthday;
    Date userStartDate;

    int teacherID;
    String teacherName;
    String teacherEmail;
    String languages;
    String feedbackStudent;
    String teacherPassword;
    int teacherQualification;
    float teacherSalary;

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
    private Date getUserStartDate() {
        return userStartDate;
    }

    // TEACHER ID
    private int getTeacherID() {
        return teacherID;
    }

    // LANGUAGES
    private String getLanguages() {
        return languages;
    }

    // FEEDBACK STUDENT
    private String getFeedbackStudent() {
        return feedbackStudent;
    }

    // TEACHER QUALIFICATIONS
    private int getTeacherQualification() {
        return teacherQualification;
    }

    // TEACHER SALARY
    private float getTeacherSalary() {
        return teacherSalary;
    }

    // TEACHER EMAIL
    public String getTeacherEmail() {
        return teacherEmail;
    }

    // TEACHER PASSWORD
    public String getTeacherPassword() {
        return teacherPassword;
    }

    // TEACHER NAME
    public String getTeacherName() {
        return teacherName;
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
    void setUserStartDate(Date i) {
        userStartDate = i;
    }

    // TEACHER ID
    void setTeacherID(int i) {
        teacherID = i;
    }

    // LANGUAGES
    void setLanguages(String i) {
        languages = i;
    }

    // FEEDBACK STUDENT
    void setFeedbackStudent(String i) {
        feedbackStudent = i;
    }

    // TEACHER QUALIFICATIONS
    void setTeacherQualification(int i) {
        teacherQualification = i;
    }

    // TEACHER SALARY
    void setTeacherSalary(float i) {
        teacherSalary = i;
    }

    // TEACHER EMAIL
    void setTeacherEmail(String i) {teacherEmail = i;}

    // TEACHER PASSWORD
    void setTeacherPassword(String i) {teacherPassword = i;}

    // TEACHER NAME
    void setTeacherName(String i) {teacherName = i;}
}
import java.util.Date;

public class Teacher extends User{

    @Override
    void User(){}

    int userID;
    Date userBirthday;
    Date userStartDate;

    int teacherID;
    String teacherName;
    String teacherEmail;
    String languages;
    String students;
    String teacherPassword;
    int teacherQualification;
    float teacherSalary;

    // GETTER METHODS

    // USER ID
    private int getUserID() {
        return userID;
    }

    // USER BIRTHDAY
    Date getUserBirthday() {
        return userBirthday;
    }

    // USER START DATE
    private Date getUserStartDate() {
        return userStartDate;
    }

    // TEACHER ID
    int getTeacherID() {
        return teacherID;
    }

    // LANGUAGES
    String getLanguages() {
        return languages;
    }

    // FEEDBACK STUDENT
    String getStudents() {
        return students;
    }

    // TEACHER QUALIFICATIONS
    int getTeacherQualification() {
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
    void setUserBirthday(Date i) {
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
    void setStudents(String i) {
        students = i;
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
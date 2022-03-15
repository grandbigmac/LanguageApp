import java.util.Date;

public abstract class User {

    void User() {}

    int userID;
    int userBirthday;
    Date userStartDate;

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
}

package beans;

import java.io.Serializable;
import java.util.Date;

public class UserAdministration implements Serializable {

    private int userId;
    private int userIdAll;
    private String userFirstName;
    private String userFirstNameAll;
    private String userLastName;
    private String userLastNameAll;
    private String userName;
    private String userNameAll;
    private String userEmail;
    private String userEmailAll;
    private String userGender;
    private String userGenderAll;
    private int userGameId;
    private int userGamingTime;
    private Date userGameDate;
    private String userGameType;
    private String userGameDifficulty;


    public UserAdministration() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public int getUserGameId() {
        return userGameId;
    }

    public void setUserGameId(int userGameId) {
        this.userGameId = userGameId;
    }

    public int getUserGamingTime() {
        return userGamingTime;
    }

    public void setUserGamingTime(int userGamingTime) {
        this.userGamingTime = userGamingTime;
    }

    public Date getUserGameDate() {
        return userGameDate;
    }

    public void setUserGameDate(Date userGameDate) {
        this.userGameDate = userGameDate;
    }

    public String getUserGameType() {
        return userGameType;
    }

    public void setUserGameType(String userGameType) {
        this.userGameType = userGameType;
    }

    public String getUserGameDifficulty() {
        return userGameDifficulty;
    }

    public void setUserGameDifficulty(String userGameDifficulty) {
        this.userGameDifficulty = userGameDifficulty;
    }

    public int getUserIdAll() {
        return userIdAll;
    }

    public void setUserIdAll(int userIdAll) {
        this.userIdAll = userIdAll;
    }

    public String getUserFirstNameAll() {
        return userFirstNameAll;
    }

    public void setUserFirstNameAll(String userFirstNameAll) {
        this.userFirstNameAll = userFirstNameAll;
    }

    public String getUserLastNameAll() {
        return userLastNameAll;
    }

    public void setUserLastNameAll(String userLastNameAll) {
        this.userLastNameAll = userLastNameAll;
    }

    public String getUserNameAll() {
        return userNameAll;
    }

    public void setUserNameAll(String userNameAll) {
        this.userNameAll = userNameAll;
    }

    public String getUserEmailAll() {
        return userEmailAll;
    }

    public void setUserEmailAll(String userEmailAll) {
        this.userEmailAll = userEmailAll;
    }

    public String getUserGenderAll() {
        return userGenderAll;
    }

    public void setUserGenderAll(String userGenderAll) {
        this.userGenderAll = userGenderAll;
    }

}

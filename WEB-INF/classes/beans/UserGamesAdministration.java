//Erstellt von Thomas Theinert

package beans;

import java.io.Serializable;
import java.util.Date;

public class UserGamesAdministration implements Serializable {

    private int userId;
    private String userFirstName;
    private String userLastName;
    private String userName;
    private String userGroup;
    private String userEmail;
    private String userGender;
    private int userGameId;
    private int userGamingTime;
    private Date userGameDate;
    private String userGameType;
    private String userGameDifficulty;


    public UserGamesAdministration() {
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

    public String getUserGroup() {

        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
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

}

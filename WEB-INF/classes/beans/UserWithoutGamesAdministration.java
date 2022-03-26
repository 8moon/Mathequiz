//Erstellt von Thomas Theinert

package beans;

import java.io.Serializable;

public class UserWithoutGamesAdministration implements Serializable {

    private int userIdAll;
    private String userFirstNameAll;
    private String userLastNameAll;
    private String userNameAll;
    private String userGroupAll;
    private String userEmailAll;
    private String userGenderAll;

    public UserWithoutGamesAdministration() {
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

    public String getUserGroupAll() {
        return userGroupAll;
    }

    public void setUserGroupAll(String userGroupAll) {
        this.userGroupAll = userGroupAll;
    }
}

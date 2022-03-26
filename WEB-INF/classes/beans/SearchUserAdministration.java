//Erstellt von Thomas Theinert

package beans;

import java.io.Serializable;

public class SearchUserAdministration implements Serializable {

    private int searchUser;
    private int userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String userGroup;
    private String eMail;
    private String gender;
    private String profilePictureName;
    private byte[] profilePictureFile;

    public SearchUserAdministration() {
    }

    public int getSearchUser() {
        return searchUser;
    }

    public void setSearchUser(int searchUser) {
        this.searchUser = searchUser;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfilePictureName() {
        return profilePictureName;
    }

    public void setProfilePictureName(String profilePictureName) {
        this.profilePictureName = profilePictureName;
    }

    public byte[] getProfilePictureFile() {
        return profilePictureFile;
    }

    public void setProfilePictureFile(byte[] profilePictureFile) {
        this.profilePictureFile = profilePictureFile;
    }

}

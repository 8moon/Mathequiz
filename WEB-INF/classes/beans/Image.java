//Erstellt von Lu Hoan

package beans;

import java.io.Serializable;
import java.util.Date;

public class Image implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
    private Integer number;
    private byte[] profilePictureFile;
    private String profilePictureName;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public byte[] getProfilePictureFile() {
		return profilePictureFile;
	}
	public void setProfilePictureFile(byte[] profilePictureFile) {
		this.profilePictureFile = profilePictureFile;
	}
	public String getProfilePictureName() {
		return profilePictureName;
	}
	public void setProfilePictureName(String profilePictureName) {
		this.profilePictureName = profilePictureName;
	}

}

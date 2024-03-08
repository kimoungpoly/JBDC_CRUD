
package model;

public class User {
    private int userId;
    private String userUuid;
    private String userName;
    private String userEmail;
    private String userPassword;
    private boolean isDeleted;
    private boolean isVerified;

    public User(int userId, String userUuid, String userName, String userEmail, String userPassword, boolean isDeleted, boolean isVerified) {
        this.userId = userId;
        this.userUuid = userUuid;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.isDeleted = isDeleted;
        this.isVerified = isVerified;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
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

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public boolean isVerified() {
        return isVerified;
    }
    public void setVerified(boolean verified) {
        isVerified = verified;
    }
}

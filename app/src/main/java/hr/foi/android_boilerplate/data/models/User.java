package hr.foi.android_boilerplate.data.models;

/**
 * Created by Antonio Martinović on 02.03.17.
 */

public class User {
    private String username;
    private String passwordDigest;

    public User() {}

    public User(String username, String passwordDigest) {
        this.username = username;
        this.passwordDigest = passwordDigest;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordDigest() {
        return passwordDigest;
    }

    public void setPasswordDigest(String passwordDigest) {
        this.passwordDigest = passwordDigest;
    }
}

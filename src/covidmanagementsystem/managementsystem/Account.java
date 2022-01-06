/*
 *  Student's ID: 19127622
 *  Full name: Ngo Truong Tuyen
 *  Subject: Java Programming
 *  Assignment :
 *  Problem :
 */
package covidmanagementsystem.managementsystem;

/**
 *
 * @author zerotus
 */
public class Account {
    private String username;
    private String password;
    private int role;
    private int state;
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Account(String username, String password, int role, int state) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.state = state;
    }
}

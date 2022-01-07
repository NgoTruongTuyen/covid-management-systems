/*
 *  Student's ID: 19127622
 *  Full name: Ngo Truong Tuyen
 *  Subject: Java Programming
 *  Assignment :
 *  Problem :
 */
package covidmanagementsystem.managementsystem;

import java.util.List;

/**
 *
 * @author zerotus
 */
public class Manager {
    private String username;
    private int role;
    private int state;
    private List<String> activities;

    public Manager() {
        this.username = null;
        this.role = -1;
        this.state = 0;
        this.activities = null;
    }
    
    public Manager(String username, int role, int state) {
        this.username = username;
        this.role = role;
        this.state = state;
        this.activities = null;
    }
    
    public Manager(String username, int role, int state, List<String> activities) {
        this.username = username;
        this.role = role;
        this.state = state;
        this.activities = activities;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getStatus() {
        return state;
    }

    public void setStatus(int state) {
        this.state = state;
    }

    public List<String> getActivities() {
        return activities;
    }

    public void setActivities(List<String> activities) {
        this.activities = activities;
    }
}

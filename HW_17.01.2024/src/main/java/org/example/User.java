package org.example;

import java.util.List;

public class User {
    private String name;
    private List<String> skills;

    public User(String name, List<String> skills) {
        this.name = name;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
   @Override
    public String toString() {
        return "User{" +
               "name='" + name + '\'' +
               ", skills=" + skills +
               '}';
   }
}

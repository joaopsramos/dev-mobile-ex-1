package main.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String username;
    private String password;

    private static List<User> users;

    public User(int id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static User login(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            return null;
        }

        return users.stream()
                .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
                .findAny()
                .orElse(null);

    }

    public static List<User> getUsers() {
        return users;
    }

    public static User getUserById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findAny()
                .orElse(null);
    }

    public static List<User> createUsers() {
        users = new ArrayList<>();
        int[] ids = {1, 2, 3, 4};
        String[] names = {"João", "Pedro", "Gustavo", "Felipe"};

        for (int id : ids) {
            users.add(new User(id, names[id - 1], "username" + id, "123"));
        }

        return users;
    }
}

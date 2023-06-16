package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class SecondTask {
    public static void main(String[] args) {
        String inputFile = "src/main/resources/file2.txt";
        String outputFile = "src/main/resources/user.json";
        List<User> users = readUsers(inputFile);
        writeUsers(users, outputFile);
    }

    private static List<User> readUsers(String inputFile) {
        List<User> users = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))){

            String linesRead;
            bufferedReader.readLine(); //skip first line "name age"
            while ((linesRead = bufferedReader.readLine()) != null){
                String[] userInfo = linesRead.split(" ");
                User user = new User(userInfo[0], Integer.parseInt(userInfo[1]));
                users.add(user);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }
    private static void writeUsers(List<User> users, String outputFile) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(outputFile)){
            gson.toJson(users, writer);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;

    }

}
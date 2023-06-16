package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirstTask {
    public static void main(String[] args) {
        readFile();
    }
    public static void readFile() {
        Pattern pattern = Pattern.compile("\\(\\d{3}\\) \\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4}");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/file1.txt"))){

            String linesRead;
            while ((linesRead = bufferedReader.readLine()) != null){
                Matcher matcher = pattern.matcher(linesRead);
                if (matcher.matches()) {
                    System.out.println(linesRead);
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

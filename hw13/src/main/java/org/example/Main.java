package org.example;

import org.example.models.TodoEntity;

import java.util.List;
import java.util.Optional;

import static org.example.UserCrudApp.*;

public class Main {
    public static void main(String[] args) {
        int userId = 1;
        //First Task
        System.out.println("\nFirst Task\n");

        System.out.println(createUser());
        System.out.println(updateUser(1));
        System.out.println(deleteUser(1));
        System.out.println(getUsers());
        System.out.println(getUserById(1));
        System.out.println(getUserByUsername("Karianne"));

        //Second Task
        System.out.println("\nSecond Task\n");

        if (writeCommentsToFile(userId)){
            System.out.println("Comments were added to file!");
        } else {
            System.out.println("Failed to add comments to file!");
        }

        // Third Task
        System.out.println("\nThird Task\n");

        Optional<List<TodoEntity>> openTasks = getOpenTasksForUser(userId);
        if (openTasks.isPresent()) {
            System.out.println("Open tasks for User ID " + userId + ":");
            for (TodoEntity task : openTasks.get()) {
                System.out.println(task.getId() + ": " + task.getTitle());
            }
        } else {
            System.out.println("Failed to retrieve open tasks for User ID " + userId);
        }
    }
}
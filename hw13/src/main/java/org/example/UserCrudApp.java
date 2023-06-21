package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.models.CommentEntity;
import org.example.models.PostEntity;
import org.example.models.TodoEntity;
import org.example.models.UserEntity;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * A class for performing CRUD operations on user entities using HTTPURLConnection.
 */
public class UserCrudApp {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    private static final Gson gson = new Gson();

    /**
     * Task number 1.
     * Creates a new user entity by sending a POST request to the API.
     *
     * @return The created user entity.
     */
    public static UserEntity createUser() {
        try {
            URL url = new URL(BASE_URL + "/users");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String requestBody = "{\"name\":\"Thor Odinson\",\"username\":\"Loki\",\"email\":\"thor.odinson@marvel.com\",\"address\":{\"street\":\"Kulas Dark\",\"suite\":\"Apt. 1\",\"city\":\"Asgard city\",\"zipcode\":\"888-88\",\"geo\":{\"lat\":\"-20.3566\",\"lng\":\"12.1366\"}},\"phone\":\"1-110-136-1231 x54442\",\"website\":\"thor.org\",\"company\":{\"name\":\"Marvel studios\",\"catchPhrase\":\"Thor Love and Thunder\",\"bs\":\"lol-kek\"}}";

            try (OutputStream outputStream = connection.getOutputStream()) {
                outputStream.write(requestBody.getBytes());
                outputStream.flush();
            }

            int responseCode = connection.getResponseCode();
            if (HttpURLConnection.HTTP_CREATED == responseCode) {
                return getUserEntity(connection);
            }
            connection.disconnect();
        } catch (IOException e) {
            throw new RuntimeException("Something goes wrong");
        }
        return null;
    }

    /**
     * Updates an existing user entity by sending a PUT request to the API.
     *
     * @param id The ID of the user entity to update.
     * @return The updated user entity.
     */
    public static UserEntity updateUser(int id) {
        try {
            URL url = new URL(BASE_URL + "/users/" + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String requestBody = "{\"id\":5,\"name\":\"Bjorn Ironside\",\"username\":\"ironside\",\"email\":\"ragnarsson@example.com\"}";

            try (OutputStream outputStream = connection.getOutputStream()) {
                outputStream.write(requestBody.getBytes());
                outputStream.flush();
            }

            int responseCode = connection.getResponseCode();
            if (HttpURLConnection.HTTP_OK == responseCode) {
                return getUserEntity(connection);
            }

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Deletes a user entity by sending a DELETE request to the API.
     *
     * @param id The ID of the user entity to delete.
     * @return {@code true} if the deletion is successful, otherwise {@code false}.
     */
    public static boolean deleteUser(int id) {
        try {
            URL url = new URL(BASE_URL + "/users/" + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");
            int responseCode = connection.getResponseCode();
            connection.disconnect();
            return responseCode >= HttpURLConnection.HTTP_OK && responseCode < HttpURLConnection.HTTP_MULT_CHOICE;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Retrieves a list of all user entities from the API.
     *
     * @return A list of user entities.
     */
    public static List<UserEntity> getUsers() {
        try {
            URL url = new URL(BASE_URL + "/users");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (HttpURLConnection.HTTP_OK == responseCode) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String line;
                    StringBuilder response = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    Type userListType = new TypeToken<List<UserEntity>>() {
                    }.getType();
                    return gson.fromJson(response.toString(), userListType);
                }
            }
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Retrieves a user entity by its ID from the API.
     *
     * @param id The ID of the user entity to retrieve.
     * @return An optional containing the user entity if found, or empty optional if not found.
     */
    public static Optional<UserEntity> getUserById(int id) {
        try {
            URL url = new URL(BASE_URL + "/users/" + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String line;
                    StringBuilder response = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    UserEntity user = gson.fromJson(response.toString(), UserEntity.class);
                    return Optional.ofNullable(user);
                }
            }

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    /**
     * Retrieves a user entity by its username from the API.
     *
     * @param username The username of the user entity to retrieve.
     * @return An optional containing the user entity if found, or empty optional if not found.
     */
    public static Optional<UserEntity> getUserByUsername(String username) {
        try {
            URL url = new URL(BASE_URL + "/users?username=" + username);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (HttpURLConnection.HTTP_OK == responseCode) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String line;
                    StringBuilder response = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    Type userListType = new TypeToken<List<UserEntity>>() {
                    }.getType();
                    List<UserEntity> users = gson.fromJson(response.toString(), userListType);
                    if (!users.isEmpty()) {
                        return Optional.of(users.get(0));
                    }
                }
            }

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    /**
     * Task number 2.
     * Writes to file the entity of comments from the last user post by user ID from the API.
     *
     * @param userId The ID of the user entity to find its posts.
     * @return <code>true</code> if comments were loaded to file, or <code>false</code> if something went wrong.
     */
    public static Boolean writeCommentsToFile(int userId) {
        Optional<Integer> lastPostIdOpt = getLastPostId(userId);
        if (lastPostIdOpt.isPresent()) {
            Integer lastPostId = lastPostIdOpt.get();
            Optional<List<CommentEntity>> commentsOpt = getAllCommentsForLastPost(lastPostId);
            String outputFileName = "src/main/resources/user-" + userId + "-post-" + lastPostId + "-comments.json";

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            try (FileWriter writer = new FileWriter(outputFileName)) {
                if (commentsOpt.isPresent()) {
                    List<CommentEntity> comments = commentsOpt.get();
                    gson.toJson(comments, writer);
                    return true;
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    /**
     * Retrieves the list of comment entities of the post from the API.
     *
     * @param lastPostId The ID of the last post entity to find its comments.
     * @return An optional containing the list of comment entities if found, or empty optional if not found.
     */
    private static Optional<List<CommentEntity>> getAllCommentsForLastPost(int lastPostId) {

        try {
            URL url = new URL(BASE_URL + "/posts/" + lastPostId + "/comments");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (HttpURLConnection.HTTP_OK == responseCode) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String line;
                    StringBuilder response = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    Type postCommentsType = new TypeToken<List<CommentEntity>>() {
                    }.getType();
                    List<CommentEntity> comments = gson.fromJson(response.toString(), postCommentsType);
                    if (!comments.isEmpty()) {
                        return Optional.of(comments);
                    }
                }
            }
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * Finds last post ID by user ID from the API.
     *
     * @param userId The ID of the user entity to find its posts.
     * @return An optional containing ID of the last user post, or empty optional if not found.
     */

    private static Optional<Integer> getLastPostId(int userId) {
        try {
            URL url = new URL(BASE_URL + "/users/" + userId + "/posts");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (HttpURLConnection.HTTP_OK == responseCode) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String line;
                    StringBuilder response = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    Type userPostsType = new TypeToken<List<PostEntity>>() {
                    }.getType();
                    List<PostEntity> posts = gson.fromJson(response.toString(), userPostsType);
                    if (!posts.isEmpty()) {
                        PostEntity lastPost = Collections.max(posts, Comparator.comparingInt(PostEntity::getId));
                        return Optional.of(lastPost.getId());
                    }
                }
            }
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * Task number 3.
     * Retrieves the entity of To-dos that are not ready (false) by user ID from the API.
     *
     * @param userId The ID of the user entity to find its tasks.
     * @return An optional containing the list of To-do entities if found, or empty optional if not found.
     */
    public static Optional<List<TodoEntity>> getOpenTasksForUser(int userId) {
        try {
            URL url = new URL(BASE_URL + "/users/" + userId + "/todos?completed=false");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (HttpURLConnection.HTTP_OK == responseCode) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String line;
                    StringBuilder response = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    Type userTasksType = new TypeToken<List<TodoEntity>>() {
                    }.getType();
                    List<TodoEntity> tasks = gson.fromJson(response.toString(), userTasksType);
                    if (!tasks.isEmpty()) {
                        return Optional.of(tasks);
                    }
                }
            }
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private static UserEntity getUserEntity(HttpURLConnection connection) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            return gson.fromJson(response.toString(), UserEntity.class);
        }
    }
}
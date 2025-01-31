package org.example;

/**
 * Hello world!
 *
 */
public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        userRepository.addUser(new User(1, "Joe Biden", "joe.Biden@example.com"));
        userRepository.addUser(new User(2, "Donald Trump", "donald.Trump@example.com"));

        int searchId = 1;
        userRepository.findUserById(searchId).ifPresentOrElse(
                user -> System.out.println("User found: " + user),
                () -> System.out.println("User with ID " + searchId + " not found")
        );

        String searchEmail = "doald.Trump@example.com";
        userRepository.findUserByEmail(searchEmail).ifPresentOrElse(
                user -> System.out.println("User found: " + user),
                () -> System.out.println("User with email " + searchEmail + " not found")
        );

        userRepository.findAllUsers().ifPresentOrElse(
                users -> System.out.println("Total users: " + users.size()),
                () -> System.out.println("No users found")
        );

        /*якщо потрібно вивести всіх користувачів:
        Optional<List<User>> allUsers = userRepository.findAllUsers();
        if (allUsers.isPresent()) {
            List<User> users = allUsers.get();
            System.out.println("Total users: " + users.size());
            users.forEach(System.out::println);
        } else {
            System.out.println("No users found");
        }*/
    }
}


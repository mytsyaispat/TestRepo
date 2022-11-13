package tracker.service;

import tracker.entity.Student;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddStudent {
    private final Random random = new Random();

    public static Map<String, Student> studentsList = new HashMap<>();
    public static Set<String> emailsList = new HashSet<>();
    public static Set<String> idsList = new LinkedHashSet<>();


    public void add() {
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        System.out.println("Enter student credentials or 'back' to return");
        while (true) {
            String action = scanner.nextLine().trim();
            String firstName;
            String lastName;
            String email;
            if (action.equals("back")) break;
            if (!action.matches(".+\\s.+\\s.+")) {
                System.out.println("Incorrect credentials.");
                continue;
            }
            Pattern pattern = Pattern.compile("^[a-zA-Z]+(['\\-][a-zA-Z]+)*\\s");
            Matcher matcher = pattern.matcher(action);
            if (matcher.find() && matcher.group().trim().length() > 1) {
                firstName = matcher.group().trim();
            } else {
                System.out.println("Incorrect first name.");
                continue;
            }
            pattern = Pattern.compile("\\s[a-zA-Z]+(['\\-][a-zA-Z]+)*\\s([a-zA-Z]+(['\\-][a-zA-Z]+)*\\s)*");
            matcher = pattern.matcher(action);
            if (matcher.find() && matcher.group().trim().length() > 1) {
                lastName = matcher.group().trim();
            } else {
                System.out.println("Incorrect last name.");
                continue;
            }
            pattern = Pattern.compile("\\s[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z0-9_-]+$");
            matcher = pattern.matcher(action);
            if (matcher.find()) {
                email = matcher.group().trim();
                if (emailsList.contains(email)) {
                    System.out.println("This email is already taken.");
                    continue;
                }
                emailsList.add(email);
            } else {
                System.out.println("Incorrect email.");
                continue;
            }
            String id = String.valueOf(random.nextInt(10000));
            while (studentsList.containsKey(id)) {
                id = String.valueOf(random.nextInt(10000));
            }
            idsList.add(id);
            studentsList.put(id, new Student(id, firstName, lastName, email));
            System.out.println("The student has been added.");
            counter++;
        }
        System.out.printf("Total %d students were added", counter);
    }
}

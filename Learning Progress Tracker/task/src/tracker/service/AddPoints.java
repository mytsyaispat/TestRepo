package tracker.service;

import tracker.service.AddStudent;

import java.util.*;

public class AddPoints {
    public static Map<String, List<Integer>> pointsInfo = new HashMap<>();
    public static Map<String, Integer> countOfExercises = new LinkedHashMap<>();

    public static int countJavaEx = 0;
    public static int countDSAEx = 0;
    public static int countDatabasesEx = 0;
    public static int countSpringEx = 0;

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an id and points or 'back' to return");
        flag : while (true) {
            String action = scanner.nextLine();

            if (action.equals("back")) break;
            String[] params = action.split(" ");
            if (params.length != 5) {
                System.out.println("Incorrect points format.");
                continue;
            }
            if (!AddStudent.idsList.contains(params[0])) {
                System.out.printf("No student is found for id=%s.", params[0]);
                continue;
            }
            for (int i = 1; i < params.length; i++) {
                if (!params[i].matches("\\d+") || Integer.parseInt(params[i]) < 0) {
                    System.out.println("Incorrect points format.");
                    continue flag;
                }
            }
            if (pointsInfo.containsKey(params[0])) {
                List<Integer> list = pointsInfo.get(params[0]);
                pointsInfo.put(params[0], List.of(list.get(0) + Integer.parseInt(params[1]),
                                                  list.get(1) + Integer.parseInt(params[2]),
                                                  list.get(2) + Integer.parseInt(params[3]),
                                                  list.get(3) + Integer.parseInt(params[4])));

            } else {
                pointsInfo.put(params[0], List.of(Integer.parseInt(params[1]),
                                                  Integer.parseInt(params[2]),
                                                  Integer.parseInt(params[3]),
                                                  Integer.parseInt(params[4])));
            }

            if (Integer.parseInt(params[1]) != 0) {
                countJavaEx++;
            }
            if (Integer.parseInt(params[2]) != 0) {
                countDSAEx++;
            }
            if (Integer.parseInt(params[3]) != 0) {
                countDatabasesEx++;
            }
            if (Integer.parseInt(params[4]) != 0) {
                countSpringEx++;
            }

            if (countOfExercises.containsKey("Java")) {
                countOfExercises.put("Java", countOfExercises.get("Java") + 1);
            } else {
                countOfExercises.put("Java", 1);
            }

            if (countOfExercises.containsKey("DSA")) {
                countOfExercises.put("DSA", countOfExercises.get("DSA") + 1);
            } else {
                countOfExercises.put("DSA", 1);
            }

            if (countOfExercises.containsKey("Database")) {
                countOfExercises.put("Database", countOfExercises.get("Database") + 1);
            } else {
                countOfExercises.put("Database", 1);
            }

            if (countOfExercises.containsKey("Spring")) {
                countOfExercises.put("Spring", countOfExercises.get("Spring") + 1);
            } else {
                countOfExercises.put("Spring", 1);
            }


            System.out.println("Points updated.");

        }


    }
}

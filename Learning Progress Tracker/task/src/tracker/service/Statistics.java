package tracker.service;

import tracker.entity.Courses;

import java.util.*;

public class Statistics {
    private int javaPoints = 0;
    private int javaStudents = 0;
    private int DSAPoints = 0;
    private int DSAStudents = 0;
    private int DatabasesPoints = 0;
    private int DatabasesStudents = 0;
    private int SpringPoints = 0;
    private int SpringStudents = 0;

    private int countJavaEx;
    private int countDSAEx;
    private int countDatabasesEx;
    private int countSpringEx;


    public void show() {
        System.out.println("Type the name of a course to see details or 'back' to quit");

        for (String key : AddPoints.pointsInfo.keySet()) {
            List<Integer> list = AddPoints.pointsInfo.get(key);
            int points = list.get(0);
            if (points != 0) {
                javaPoints += points;
                javaStudents++;
            }
            points = list.get(1);
            if (points != 0) {
                DSAPoints += points;
                DSAStudents++;
            }
            points = list.get(2);
            if (points != 0) {
                DatabasesPoints += points;
                DatabasesStudents++;
            }
            points = list.get(3);
            if (points != 0) {
                SpringPoints += points;
                SpringStudents++;
            }
        }

        if (javaStudents == 0 && DSAStudents == 0 && DatabasesStudents == 0 && SpringStudents == 0) {
            if (javaPoints == 0 && DSAPoints == 0 && DatabasesPoints == 0 && SpringPoints == 0) {
                System.out.println("Most popular: n/a");
                System.out.println("Least popular: n/a");
            } else {
                System.out.println("Most popular: n/a");
                System.out.println("Least popular: Java, DSA, Databases, Spring");
            }
        } else {
            List<String> most = new ArrayList<>();
            List<String> least = new ArrayList<>();
            int min = Math.min(Math.min(javaStudents, DSAStudents), Math.min(DatabasesStudents, SpringStudents));
            int max = Math.max(Math.max(javaStudents, DSAStudents), Math.max(DatabasesStudents, SpringStudents));
            if (javaStudents == max) most.add("Java");
            if (DSAStudents == max) most.add("DSA");
            if (DatabasesStudents == max) most.add("Databases");
            if (SpringStudents == max) most.add("Spring");

            if (javaStudents == min) least.add("Java");
            if (DSAStudents == min) least.add("DSA");
            if (DatabasesStudents == min) least.add("Databases");
            if (SpringStudents == min) least.add("Spring");

            if (most.size() == 4) {
                System.out.println("Most popular: Java, DSA, Databases, Spring");
                System.out.println("Least popular: n/a");
            } else {
                System.out.print("Most popular: " + most.get(0));
                for (int i = 1; i < most.size(); i++) {
                    System.out.print(", " + most.get(i));
                }
                System.out.println();

                System.out.print("Least popular: " + least.get(0));
                for (int i = 1; i < least.size(); i++) {
                    System.out.print(", " + least.get(i));
                }
                System.out.println();
            }
        }

        countJavaEx = AddPoints.countJavaEx;
        countDSAEx = AddPoints.countDSAEx;
        countDatabasesEx = AddPoints.countDatabasesEx;
        countSpringEx = AddPoints.countSpringEx;

        if (countJavaEx == 0 && countDSAEx == 0 && countDatabasesEx == 0 && countSpringEx == 0) {
            if (javaStudents == 0 && DSAStudents == 0 && DatabasesStudents == 0 && SpringStudents == 0) {
                System.out.println("Highest activity: n/a");
                System.out.println("Lowest activity: n/a");
            } else {
                System.out.println("Highest activity: n/a");
                System.out.println("Lowest activity: Java, DSA, Databases, Spring");
            }
        } else {
            List<String> high = new ArrayList<>();
            List<String> low = new ArrayList<>();
            int min = Math.min(Math.min(countJavaEx, countDSAEx), Math.min(countDatabasesEx, countSpringEx));
            int max = Math.max(Math.max(countJavaEx, countDSAEx), Math.max(countDatabasesEx, countSpringEx));
            if (countJavaEx == max) high.add("Java");
            if (countDSAEx == max) high.add("DSA");
            if (countDatabasesEx == max) high.add("Databases");
            if (countSpringEx == max) high.add("Spring");

            if (countJavaEx == min) low.add("Java");
            if (countDSAEx == min) low.add("DSA");
            if (countDatabasesEx == min) low.add("Databases");
            if (countSpringEx == min) low.add("Spring");

            if (low.size() == 4) {
                System.out.println("Highest activity: Java, DSA, Databases, Spring");
                System.out.println("Lowest activity: n/a");
            } else {
                System.out.print("Highest activity: " + high.get(0));
                for (int i = 1; i < high.size(); i++) {
                    System.out.print(", " + high.get(i));
                }
                System.out.println();

                System.out.print("Lowest activity: " + low.get(0));
                for (int i = 1; i < low.size(); i++) {
                    System.out.print(", " + low.get(i));
                }
                System.out.println();
            }

        }
        if (AddPoints.countOfExercises.isEmpty()) {
            if (javaStudents == 0 && DSAStudents == 0 && DatabasesStudents == 0 && SpringStudents == 0) {
                System.out.println("Easiest course: n/a");
                System.out.println("Hardest course: n/a");
            } else {
                System.out.println("Highest activity: n/a");
                System.out.println("Lowest activity: Java, DSA, Databases, Spring");
            }
        } else {
            int javaCountOfExercises = AddPoints.countOfExercises.get("Java");
            int dsaCountOfExercises = AddPoints.countOfExercises.get("DSA");
            int databaseCountOfExercises = AddPoints.countOfExercises.get("Database");
            int springCountOfExercises = AddPoints.countOfExercises.get("Spring");

            double percentJava = (double) javaPoints / javaCountOfExercises;
            double percentDSA = (double) DSAPoints / dsaCountOfExercises;
            double percentDatabase = (double) DatabasesPoints / databaseCountOfExercises;
            double percentSpring = (double) SpringPoints / springCountOfExercises;

            if (percentJava == 0 && percentDSA == 0 && percentDatabase == 0 && percentSpring == 0) {
                System.out.println("Easiest course: n/a");
                System.out.println("Hardest course: n/a");
            } else {
                List<String> easy = new ArrayList<>();
                List<String> hard = new ArrayList<>();
                double min = Math.min(Math.min(percentJava, percentDSA), Math.min(percentDatabase, percentSpring));
                double max = Math.max(Math.max(percentJava, percentDSA), Math.max(percentDatabase, percentSpring));
                if (percentJava == max) easy.add("Java");
                if (percentDSA == max) easy.add("DSA");
                if (percentDatabase == max) easy.add("Databases");
                if (percentSpring == max) easy.add("Spring");

                if (percentJava == min) hard.add("Java");
                if (percentDSA == min) hard.add("DSA");
                if (percentDatabase == min) hard.add("Databases");
                if (percentSpring == min) hard.add("Spring");

                if (hard.size() == 4) {
                    System.out.println("Easiest course: Java, DSA, Databases, Spring");
                    System.out.println("Hardest course: n/a");
                } else {
                    System.out.print("Easiest course: " + easy.get(0));
                    for (int i = 1; i < easy.size(); i++) {
                        System.out.print(", " + easy.get(i));
                    }
                    System.out.println();

                    System.out.print("Hardest course: " + hard.get(0));
                    for (int i = 1; i < hard.size(); i++) {
                        System.out.print(", " + hard.get(i));
                    }
                    System.out.println();
                }

            }
        }

        Scanner scanner = new Scanner(System.in);

        Comparator<String[]> comparator = (strings, t1) -> {
            int result = Integer.compare(Integer.parseInt(t1[1]), Integer.parseInt(strings[1]));
            if (result == 0) {
                return Integer.compare(Integer.parseInt(strings[0]), Integer.parseInt(t1[0]));
            }
            return result;
        };

        while (true) {
            String action = scanner.nextLine();
            if (action.equals("back")) break;
            List<String[]> list = new ArrayList<>();

            if (action.matches("(?i)java")) {
                System.out.println("Java");
                System.out.println("id    points    completed");
                String points = null;
                String percent = null;
                for (String id : AddStudent.idsList) {
                    points = String.valueOf(AddPoints.pointsInfo.get(id).get(0));
                    percent = String.format("%.1f", (double) AddPoints.pointsInfo.get(id).get(0) / ((double) Courses.Java.getPoints() / 100));
                    list.add(new String[] {id, points, percent});
                }
                list.sort(comparator);
                for (String[] arr : list) {
                    if (arr[1].equals("0")) {
                        continue;
                    }
                    System.out.println(arr[0] + "  " + (arr[1] == null ? 0 : arr[1]) + "      " + (arr[2] == null ? "0.0" : arr[2]) + "%");
                }
                continue;
            }

            if (action.matches("(?i)dsa")) {
                System.out.println("DSA");
                System.out.println("id    points    completed");
                String points = null;
                String percent = null;
                for (String id : AddStudent.idsList) {
                    points = String.valueOf(AddPoints.pointsInfo.get(id).get(1));
                    percent = String.format("%.1f", (double) AddPoints.pointsInfo.get(id).get(1) / ((double) Courses.DSA.getPoints() / 100));
                    list.add(new String[] {id, points, percent});
                }
                list.sort(comparator);
                for (String[] arr : list) {
                    if (arr[1].equals("0")) {
                        continue;
                    }
                    System.out.println(arr[0] + "  " + (arr[1] == null ? 0 : arr[1]) + "      " + (arr[2] == null ? "0.0" : arr[2]) + "%");
                }
                continue;
            }

            if (action.matches("(?i)databases")) {
                System.out.println("Databases");
                System.out.println("id    points    completed");
                String points = null;
                String percent = null;
                for (String id : AddStudent.idsList) {
                    points = String.valueOf(AddPoints.pointsInfo.get(id).get(2));
                    percent = String.format("%.1f", (double) AddPoints.pointsInfo.get(id).get(2) / ((double) Courses.Databases.getPoints() / 100));
                    list.add(new String[] {id, points, percent});
                }
                list.sort(comparator);
                for (String[] arr : list) {
                    if (arr[1].equals("0")) {
                        continue;
                    }
                    System.out.println(arr[0] + "  " + (arr[1] == null ? 0 : arr[1]) + "      " + (arr[2] == null ? "0.0" : arr[2]) + "%");
                }
                continue;
            }

            if (action.matches("(?i)spring")) {
                System.out.println("Spring");
                System.out.println("id    points    completed");
                String points = null;
                String percent = null;
                for (String id : AddStudent.idsList) {
                    points = String.valueOf(AddPoints.pointsInfo.get(id).get(3));
                    percent = String.format("%.1f", (double) AddPoints.pointsInfo.get(id).get(3) / ((double) Courses.Spring.getPoints() / 100));
                    list.add(new String[] {id, points, percent});
                }
                list.sort(comparator);
                for (String[] arr : list) {
                    if (arr[1].equals("0")) {
                        continue;
                    }
                    System.out.println(arr[0] + "  " + (arr[1] == null ? 0 : arr[1]) + "      " + (arr[2] == null ? "0.0" : arr[2]) + "%");
                }
                continue;
            }

            System.out.println("Unknown course.");

        }
    }

}
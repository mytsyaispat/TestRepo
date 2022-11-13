package tracker.menu;

import tracker.service.*;

import java.util.Scanner;

public class Menu {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        AddStudent addStudent = new AddStudent();
        AddPoints addPoints = new AddPoints();
        FindStudent findStudent = new FindStudent();
        Notify notify = new Notify();
        System.out.println("Learning Progress Tracker");

        while (true) {
            String action = scanner.nextLine();
            if (action.matches("\\s*")) {
                System.out.println("No input");
                continue;
            }
            if (action.equals("exit")) {
                System.out.println("Bye!");
                System.exit(0);
            }
            if (action.equals("statistics")) {
                new Statistics().show();
                continue;
            }
            if (action.equals("add students")) {
                addStudent.add();
                continue;
            }
            if (action.equals("list")) {
                if (AddStudent.studentsList.size() == 0) {
                    System.out.println("No students found");
                } else {
                    System.out.println("Students:");
                    for (String el : AddStudent.idsList) {
                        System.out.println(el);
                    }
                }
                continue;
            }
            if (action.equals("add points")) {
                addPoints.run();
                continue;
            }
            if (action.equals("notify")) {
                notify.run();
                continue;
            }
            if (action.equals("find")) {
                findStudent.run();
                continue;
            }
            if (action.equals("back")) {
                System.out.println("Enter 'exit' to exit the program");
                continue;
            }

            System.out.println("Unknown command!");
        }
    }

}

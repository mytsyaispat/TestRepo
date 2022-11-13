package tracker.service;

import tracker.service.AddPoints;

import java.util.List;
import java.util.Scanner;

public class FindStudent {

    public void run() {
        System.out.println("Enter an id or 'back' to return:");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String action = scanner.nextLine();
            if (action.equals("back")) {
                break;
            }

            if (action.matches("\\d+") && AddPoints.pointsInfo.containsKey(action)) {
                List<Integer> list = AddPoints.pointsInfo.get(action);
                System.out.printf("%s points: Java=%d; DSA=%d; Databases=%d; Spring=%d", action,
                        list.get(0), list.get(1), list.get(2), list.get(3));
            } else {
                System.out.printf("No student is found for id=%s.", action);
            }

        }

    }
}

package tracker.service;

import tracker.entity.Courses;

import java.util.List;

public class Notify {

    public void run() {



        int counter = 0;

        for (String id : AddPoints.pointsInfo.keySet()) {
            boolean flag = false;
            List<Integer> list = AddPoints.pointsInfo.get(id);

            if (list.get(0) >= Courses.Java.getPoints() && !AddStudent.studentsList.get(id).isJavaStatus()) {
                sendEmail(AddStudent.studentsList.get(id).getEmail(), AddStudent.studentsList.get(id).getFirstName(),
                        AddStudent.studentsList.get(id).getLastName(), "Java");
                AddStudent.studentsList.get(id).setJavaStatus();
                flag = true;
            }

            if (list.get(1) >= Courses.DSA.getPoints() && !AddStudent.studentsList.get(id).isDsaStatus()) {
                sendEmail(AddStudent.studentsList.get(id).getEmail(), AddStudent.studentsList.get(id).getFirstName(),
                        AddStudent.studentsList.get(id).getLastName(), "DSA");
                AddStudent.studentsList.get(id).setDsaStatus();
                flag = true;
            }

            if (list.get(2) >= Courses.Databases.getPoints() && !AddStudent.studentsList.get(id).isDatabaseStatus()) {
                sendEmail(AddStudent.studentsList.get(id).getEmail(), AddStudent.studentsList.get(id).getFirstName(),
                        AddStudent.studentsList.get(id).getLastName(), "Databases");
                AddStudent.studentsList.get(id).setDatabaseStatus();
                flag = true;
            }

            if (list.get(3) >= Courses.Spring.getPoints() && !AddStudent.studentsList.get(id).isSpringStatus()) {
                sendEmail(AddStudent.studentsList.get(id).getEmail(), AddStudent.studentsList.get(id).getFirstName(),
                        AddStudent.studentsList.get(id).getLastName(), "Spring");
                AddStudent.studentsList.get(id).setSpringStatus();
                flag = true;
            }
            if (flag) {
                counter++;
            }
        }

        System.out.println("Total " + counter + " students have been notified.");
    }

    private void sendEmail(String email, String firstName, String secondName, String course) {
        System.out.println("To: " + email);
        System.out.println("Re: Your Learning Progress");
        System.out.println("Hello, " + firstName + " " + secondName + "! You have accomplished our " + course + " course!");
    }

}

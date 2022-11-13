package tracker.entity;

import java.util.Objects;

public final class Student {

    private final String id;
    private final String firstName;
    private final String lastName;
    private final String email;

    private boolean javaStatus = false;
    private boolean dsaStatus = false;
    private boolean databaseStatus = false;
    private boolean springStatus = false;

    public boolean isJavaStatus() {
        return javaStatus;
    }

    public void setJavaStatus() {
        javaStatus = true;
    }

    public boolean isDsaStatus() {
        return dsaStatus;
    }

    public void setDsaStatus() {
        dsaStatus = true;
    }

    public boolean isDatabaseStatus() {
        return databaseStatus;
    }

    public void setDatabaseStatus() {
        databaseStatus = true;
    }

    public boolean isSpringStatus() {
        return springStatus;
    }

    public void setSpringStatus() {
        springStatus = true;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Student(String id, String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) &&
               Objects.equals(firstName, student.firstName) &&
               Objects.equals(lastName, student.lastName) &&
               Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email);
    }
}

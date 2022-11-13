package tracker.entity;

public enum Courses {
    Java(600),
    DSA(400),
    Databases(480),
    Spring(550);

    private int points;

    Courses(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }
}

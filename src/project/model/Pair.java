package project.model;

public class Pair {

    private Employee firstEmployee;

    private  Employee secondEmployee;

    private long projectId;

    private int length;

    public Pair(Employee firstEmployee, Employee secondEmployee, long projectId, int length) {
        this.firstEmployee = firstEmployee;
        this.secondEmployee = secondEmployee;
        this.projectId = projectId;
        this.length = length;
    }

    public Employee getFirstEmployee() {
        return firstEmployee;
    }

    public void setFirstEmployee(Employee firstEmployee) {
        this.firstEmployee = firstEmployee;
    }

    public Employee getSecondEmployee() {
        return secondEmployee;
    }

    public void setSecondEmployee(Employee secondEmployee) {
        this.secondEmployee = secondEmployee;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "firstEmployee=" + firstEmployee +
                ", secondEmployee=" + secondEmployee +
                ", projectId=" + projectId +
                ", length=" + length +
                '}';
    }
}

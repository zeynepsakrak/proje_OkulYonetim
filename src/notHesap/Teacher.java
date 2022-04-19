package notHesap;

public class Teacher {

    private String teacherId;
    private String name;
    private String branch;

    public Teacher() {

    }

    public Teacher(String teacherId, String name, String branch) {
        this.teacherId = teacherId;
        this.name = name;
        this.branch = branch;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + teacherId + '\'' +
                ", name='" + name + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }
}
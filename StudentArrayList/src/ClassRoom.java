public class ClassRoom {
    private int id;
    private String className;
    private String schoolName;

    @Override
    public String toString() {
        return "ClassRoom{" +
                "id=" + id +
                ", classname='" + className + '\'' +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }

    public ClassRoom() {
    }

    public ClassRoom(int id, String classname, String schoolName) {
        this.id = id;
        this.className = classname;
        this.schoolName = schoolName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassname() {
        return className;
    }

    public void setClassname(String classname) {
        this.className = classname;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}

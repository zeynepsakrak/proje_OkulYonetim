package notHesap;

public class depoStudent{
   public static String name;
   public static String stuNo;
   public static String classes;
   public static Course mat = new Course();
   public static Course tur = new Course();
   public static Course bio = new Course();

    public depoStudent() {

    }

    public depoStudent(String stuNo,String name, String classes) {
        this.stuNo=stuNo;
        this.name=name;
        this.classes=classes;
    }

    @Override
    public String toString() {
        return "ogrenciler" +
                ", no='" + stuNo + '\'' +
                ", Ismi='" + name + '\'' +
                ", sınıfı='" + classes + '\'' + '\n' ;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        depoStudent.name = name;
    }

    public static String getStuNo() {
        return stuNo;
    }

    public static void setStuNo(String stuNo) {
        depoStudent.stuNo = stuNo;
    }

    public static String getClasses() {
        return classes;
    }

    public static void setClasses(String classes) {
        depoStudent.classes = classes;
    }

    public static Course getMat() {
        return mat;
    }

    public static void setMat(Course mat) {
        depoStudent.mat = mat;
    }

    public static Course getTur() {
        return tur;
    }

    public static void setTur(Course tur) {
        depoStudent.tur = tur;
    }

    public static Course getBio() {
        return bio;
    }

    public static void setBio(Course bio) {
        depoStudent.bio = bio;
    }

}

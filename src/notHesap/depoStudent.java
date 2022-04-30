package notHesap;

public class depoStudent{
   private String studentName;
   private  String stuNo;
   private  String classes;
   private  double mat;
   private  double tur;
   private  double bio;

    public depoStudent() {

    }

    public depoStudent(String stuNo, String studentName, String classes, double mat,double tur,double bio) {
        this.stuNo=stuNo;
        this.studentName=studentName;
        this.classes=classes;
        this.mat=mat;
        this.tur=tur;
        this.bio=bio;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public double getMat() {
        return mat;
    }

    public void setMat(double mat) {
        this.mat = mat;
    }

    public double getTur() {
        return tur;
    }

    public void setTur(double tur) {
        this.tur = tur;
    }

    public double getBio() {
        return bio;
    }

    public void setBio(double bio) {
        this.bio = bio;
    }

    @Override
  public String toString() {
      return "ogrenciler" +
              ", no='" + stuNo + '\'' +
              ", Ismi='" + studentName + '\'' +
              ", sınıfı='" + classes + '\'' +
              ", Matematik notu='" + mat + '\'' +
              ", Türkçe Notu='" + tur + '\'' +
              ", Biyoloji Notu ='" + bio + '\'' +'\n' ;
  }


}

package notHesap;

public class depoStudent{
   private String studentName;
   private  String stuNo;
   private  String classes;
   private  int mat;
   private  int tur;
   private  int bio;

    public depoStudent() {

    }

    public depoStudent(String stuNo, String studentName, String classes, int mat,int tur,int bio) {
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

    public int getMat() {
        return mat;
    }

    public void setMat(int mat) {
        this.mat = mat;
    }

    public int getTur() {
        return tur;
    }

    public void setTur(int tur) {
        this.tur = tur;
    }

    public int getBio() {
        return bio;
    }

    public void setBio(int bio) {
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

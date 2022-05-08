package notHesap;

public class depoStudent{
    private String studentName;
   private  String stuNo;
   private  String classes;
   private  Double mat;
   private  Double tur;
   private  Double bio;
    private static double matSozluYuzde;
    private static double bioSozluYuzde;
    private static double turSozluYuzde;
    public depoStudent() {

    }

    public depoStudent(String stuNo, String studentName, String classes, Double mat,Double tur,Double bio) {
        this.stuNo=stuNo;
        this.studentName=studentName;
        this.classes=classes;
        this.mat=mat;
        this.tur=tur;
        this.bio=bio;
    }

    public depoStudent(double matSozluYuzde, double bioSozluYuzde, double turSozluYuzde) {
        this.matSozluYuzde = matSozluYuzde;
        this.bioSozluYuzde = bioSozluYuzde;
        this.turSozluYuzde = turSozluYuzde;
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

    public Double getMat() {
        return mat;
    }

    public void setMat(Double mat) {
        this.mat = mat;
    }

    public Double getTur() {
        return tur;
    }

    public void setTur(Double tur) {
        this.tur = tur;
    }

    public Double getBio() {
        return bio;
    }

    public void setBio(Double bio) {
        this.bio = bio;
    }

    public static double getMatSozluYuzde() {
        return matSozluYuzde;
    }

    public static void setMatSozluYuzde(double matSozluYuzde) {
        depoStudent.matSozluYuzde = matSozluYuzde;
    }

    public static double getBioSozluYuzde() {
        return bioSozluYuzde;
    }

    public static void setBioSozluYuzde(double bioSozluYuzde) {
        depoStudent.bioSozluYuzde = bioSozluYuzde;
    }

    public static double getTurSozluYuzde() {
        return turSozluYuzde;
    }

    public static void setTurSozluYuzde(double turSozluYuzde) {
        depoStudent.turSozluYuzde = turSozluYuzde;
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

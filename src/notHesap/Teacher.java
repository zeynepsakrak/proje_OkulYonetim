
package notHesap;
import java.util.*;
import java.util.concurrent.SynchronousQueue;
import static notHesap.Main.girisPaneli;
import static notHesap.Student.ogrenciMap;
public class Teacher {
    static  Scanner scan=new Scanner(System.in);
    static int teacherId=1;
    //static String teacherId;
    private String name;
    private String branch;
    public static Map<Integer, Teacher> teacherMap = new HashMap<Integer, Teacher>();
    public Teacher() {
    }
    public Teacher(String name, String branch) {
        //this.teacherId = teacherId;
        this.name = name;
        this.branch = branch;
    }
    public int getTeacherId() {
        return teacherId;
    }
    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
    /*
            public String getTeacherId() {
                return teacherId;
            }
            public void setTeacherId(String teacherId) {
                this.teacherId = teacherId;
            }
        */
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
                " name='" + name + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }
    public static void teacherPaneli() {
        double cAvarage;
//Methods : Student(), addBulkExamNote(), isPass(), calcAvarage(), printNote()
//-->öğrenci(), topluSınavNotuEkle(), gectiMi() ortlamaHesapla(), notYazdır()
        System.out.println("===================================="+
                "\n      OGRETMEN YONETIM PANELI\n" +
                "====================================\n"+ "\n"
                + "1- ÖGRETMEN EKLE \n2- ÖGRETMEN LİSTELE \n3- OGRETMEN SIL\nHERHANGİ BİR TUŞ- ÖĞRETMEN PANELİNDEN ÇIKIŞ ");
        System.out.print("\nisleminiz seciniz : ");
        String secim = scan.next().toUpperCase(Locale.ROOT);
        switch (secim) {
            case "1":
                ogretmenekle();
                teacherPaneli();
                break;
            case "2":
                ogretmenyazdir();
                teacherPaneli();
                break;
            case "3":
                ogretmensil();
                teacherPaneli();
                break;
            case "4":
                girisPaneli();
                break;
            default:
                break;
        }
    }
    private static void ogretmenyazdir() {
        System.out.println("   *** öğretmen arama sayfası   ***");
        Set<Map.Entry<Integer, Teacher>> urunEntrySeti = teacherMap.entrySet();
        System.out.println("------------ÖĞRETMEN LİSTESİ---------------");
        System.out.println("id       ismi         branş"+
                "\n--------------------------------------------");
        for (Map.Entry<Integer, Teacher> e : urunEntrySeti
        ) {
            Integer entryKey = e.getKey();
            System.out.printf("%-8d %-12s %-15s\n", entryKey, teacherMap.get(entryKey).getName(), teacherMap.get(entryKey).getBranch());
        }
    }
    private static void ogretmenekle() {
        System.out.println("   ***  Ogretmen ekleme sayfası   ***");
        System.out.print("Bölüm giriniz : ");
        scan.nextLine();//dummy
        String branch = scan.nextLine();
        System.out.print("Ögretmenin Adini Soyadini giriniz : ");
        String name = scan.nextLine();
        Teacher  teacher = new Teacher(name,branch);//urun objesi oluşturuldu
        teacherMap.put(teacherId,teacher); //map içerisine urunId key, urun objesi eklendi
        //System.out.println(teacherMap);
        teacherId++;
    }
    private static void ogretmensil() {
        System.out.print("Silmek Istediğiniz Ogretmenin Id Numarasini giriniz :");
        Integer teacherId = scan.nextInt();
        if (teacherMap.containsKey(teacherId)) {
            teacherMap.remove(teacherId);
            System.out.println("Ogretmen bilgileri silinmiştir");
        } else {
            System.out.println("Böyle bir Ogretmen bulunamadığından silinemedi");
        }
    }
}
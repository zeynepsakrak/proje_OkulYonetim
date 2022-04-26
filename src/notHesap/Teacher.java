package notHesap;



import java.util.*;
import java.util.concurrent.SynchronousQueue;

import static notHesap.Main.girisPaneli;

public class Teacher {
static  Scanner scan=new Scanner(System.in);
    static int teacherId=1;
    //static String teacherId;
    static String name;
    static String branch;
    public static Map<Integer, Teacher> teacherMap = new HashMap<Integer, Teacher>();

    public Teacher() {

    }

    public Teacher(String name, String branch) {
        //this.teacherId = teacherId;
        this.name = name;
        this.branch = branch;
    }

    public static int getTeacherId() {
        return teacherId;
    }

    public static void setTeacherId(int teacherId) {
        Teacher.teacherId = teacherId;
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
        System.out.println("====================================\nOGRETMEN YONETIM PANELI\n" +
                "====================================\n"
                + "1- OGRETMEN EKLE \n2-OGRETMEN YAZDIR \n3- ÖĞRETMEN PANELİNDEN ÇIKIŞ ");
        System.out.print("isleminiz seciniz : ");
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

        //System.out.print("Sicil No giriniz : ");
       // String teacherId = scan.next();

        System.out.print("bolum giriniz : ");
        scan.nextLine();//dummy
        String branch = scan.nextLine();

        System.out.print("Ogretmenin Adini Soyadini giriniz : ");
        String name = scan.nextLine();
        //scan.next();
       // Teacher OgretmenEkle = new Teacher(teacherId, name, branch);
        Teacher  teacher = new Teacher(name,branch);//urun objesi oluşturuldu
        teacherMap.put(teacherId,teacher); //map içerisine urunId key, urun objesi eklendi
        System.out.println(teacherMap);
        teacherId++;
    }

}
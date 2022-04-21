package notHesap;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

import static notHesap.Main.girisPaneli;

public class Teacher {
static  Scanner scan=new Scanner(System.in);
    static List<Teacher> ogrtListesi = new ArrayList<>();
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
        boolean flag = true;

            System.out.println();
            System.out.print("Aradıgınız Ogretmenin Id No giriniz : ");

            String arananKimlikNo = scan.next();

            for (Teacher k : ogrtListesi) {
                if (k.getTeacherId().equals(arananKimlikNo)) {//flag havada
                    System.out.println("Aradıgınız Ogretmen : " + k.getName());
                    flag = false;
                }

            }
            if (flag) {//flag inince
                System.out.println("Aradıgınız Ogretmen mevcut değil ");

            }


    }

    private static void ogretmenekle() {
        System.out.println("   ***  Ogretmen ekleme sayfası   ***");
        System.out.print("Sicil No giriniz : ");
        String teacherId = scan.nextLine();
        scan.next();
        System.out.print("bolum giriniz : ");
        String branch = scan.nextLine();
        scan.next();
        System.out.print("Ogretmenin Adini Soyadini giriniz : ");
        String name = scan.nextLine();
        scan.next();
        Teacher OgretmenEkle = new Teacher(teacherId, name, branch);
        System.out.println(ogrtListesi);
    }

}
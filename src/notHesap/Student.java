package notHesap;

import javax.xml.namespace.QName;
import java.util.*;

import static notHesap.Main.girisPaneli;
import static notHesap.depoStudent.*;

public class Student {

    //static Course mat;
    //static Course tur;
    //static Course bio;
    static Scanner scan = new Scanner(System.in);
    static List<String> ogrenciList = new ArrayList<>();
    public static Map<String,depoStudent> ogrenciMap = new HashMap<String, depoStudent>();



    public static void studentPaneli() {

        double cAvarage;
//Methods : Student(), addBulkExamNote(), isPass(), calcAvarage(), printNote()
//-->öğrenci(), topluSınavNotuEkle(), gectiMi() ortlamaHesapla(), notYazdır()
        System.out.println("====================================\nOGRENCI YONETIM PANELI\n" +
                "====================================\n"
                + "1- OGRENCI EKLEME\n2-SINAV NOTU EKLEYİNİZ \n3- GECTİMİ \n4- ORTALAMA HESAPLAYINIZ \n5- NOTLARI YAZDIRINIZ\n6- ÖĞRENCİ PANELİNDEN ÇIKIŞ ");
        System.out.print("isleminiz seciniz : ");
        String secim = scan.next().toUpperCase(Locale.ROOT);
        switch (secim) {
            case "1":
                student();
                studentPaneli();
                break;
            case "2":
                sinavNotuEkle();
                studentPaneli();
                break;
            case "3":
                gectiMi();
                studentPaneli();
                break;
            case "4":
                ortalama();
                studentPaneli();
                break;
            case "5":
                notlariYazdir();
                studentPaneli();
                break;
            case "6":
                girisPaneli();
                break;
            default:
                break;
        }
    }

    private static void ortalama() {
        double matOrt = (mat.getNoteSozlu() * 0.20) + (mat.getNoteYazili() * 0.80);
        double turOrt = (bio.getNoteSozlu() * 0.20) + (bio.getNoteYazili() * 0.80);
        double bioOrt = (tur.getNoteSozlu() * 0.20) + (tur.getNoteYazili() * 0.80);
        double genelOrt = (matOrt + turOrt + bioOrt) / 3;
        System.out.println("ortalamanız: "+genelOrt);
    }


    private static void notlariYazdir() {
        System.out.println("Mat yazili notu: " + mat.getNoteYazili());
        System.out.println("Mat sözlü notu: " + mat.getNoteSozlu());
        System.out.println("Bio yazili notu: " + bio.getNoteYazili());
        System.out.println("Bio sözlü notu: " + bio.getNoteSozlu());
        System.out.println("Tur yazili notu: " + tur.getNoteYazili());
        System.out.println("Tur sözlü notu: " + tur.getNoteSozlu());
    }

    private static void gectiMi() {
        double matOrt = (mat.getNoteSozlu() * 0.20) + (mat.getNoteYazili() * 0.80);
        double turOrt = (bio.getNoteSozlu() * 0.20) + (bio.getNoteYazili() * 0.80);
        double bioOrt = (tur.getNoteSozlu() * 0.20) + (tur.getNoteYazili() * 0.80);
        double genelOrt = (matOrt + turOrt + bioOrt) / 3;
        String gectiMi = genelOrt >= 50 ? "GEÇTİ" : "GEÇEMEDİ";
        System.out.println("Öğrencinin Ortalamaları:\n" +
                "Mat Ortalaması: " + matOrt + "\nBio Ortalaması: " + bioOrt + "\nTur Ortalaması: "
                + turOrt + "\nGenel Ortalama: " + genelOrt + "\nSınıfı " + gectiMi);


    }

    private static void sinavNotuEkle() {
        System.out.println("Lutfen mat icin yazili notu giriniz");
        int not = scan.nextInt();
        mat.setNoteYazili(not);
        System.out.println("Lutfen mat icin sözlü notu giriniz");
        not = scan.nextInt();
        mat.setNoteSozlu(not);
        System.out.println("Mat yazili notu: " + mat.getNoteYazili() + "\nMat sözlü notu: " + mat.getNoteSozlu());
        System.out.println("Lutfen bio icin yazili notu giriniz");
        not = scan.nextInt();
        bio.setNoteYazili(not);
        System.out.println("Lutfen bio icin sözlü notu giriniz");
        not = scan.nextInt();
        bio.setNoteSozlu(not);
        System.out.println("Bio yazili notu: " + bio.getNoteYazili() + "\nBio sözlü notu: " + bio.getNoteSozlu());
        System.out.println("Lutfen tur icin yazili notu giriniz");
        not = scan.nextInt();
        tur.setNoteYazili(not);
        System.out.println("Lutfen tur icin sözlü notu giriniz");
        not = scan.nextInt();
        tur.setNoteSozlu(not);
        System.out.println("Tur yazili notu: " + tur.getNoteYazili() + "\nTur sözlü notu: " + tur.getNoteSozlu());


    }

    private static <ogrenci> void student() {
        System.out.println("lütfen öğrenci bilgileri giriniz: ");
        System.out.println("isim giriniz");
        scan.nextLine();//bos dummy attık
        name = scan.nextLine();
        System.out.println("öğrenci numarası giriniz giriniz");
        stuNo = scan.nextLine();
        System.out.println("sınıf giriniz");
        //scan.nextLine();//bos dummy attık
        classes = scan.nextLine();

        depoStudent ogrenci  = new depoStudent(stuNo,name,classes);//urun objesi oluşturuldu
        ogrenciMap.put(stuNo,ogrenci);

        System.out.println(ogrenciMap);

    }


}


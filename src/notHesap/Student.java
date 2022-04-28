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
               // gectiMi();
                studentPaneli();
                break;
            case "4":
              //  ortalama();
                studentPaneli();
                break;
            case "5":
                //notlariYazdir();
                studentPaneli();
                break;
            case "6":
                girisPaneli();
                break;
            default:
                break;
        }
    }
/*
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
*/
    private static void sinavNotuEkle() {
        System.out.println("notunu girmek istediğiniz öğrenci id sini yazınız :");
        String arananId= scan.next();

        if (ogrenciMap.keySet().contains(arananId)) {


        System.out.println("Lutfen mat icin yazili notu giriniz");
        int notmy = scan.nextInt();
        System.out.println("Lutfen mat icin sözlü notu giriniz");
        int notms = scan.nextInt();
        System.out.println("Mat yazili notu: " + notmy + "\nMat sözlü notu: " + notms);


        System.out.println("Lutfen bio icin yazili notu giriniz");
        int notby = scan.nextInt();
        System.out.println("Lutfen bio icin sözlü notu giriniz");
        int notbs = scan.nextInt();
        System.out.println("Bio yazili notu: " + notby + "\nBio sözlü notu: " + notbs);


        System.out.println("Lutfen tur icin yazili notu giriniz");
       int  notTy = scan.nextInt();
        System.out.println("Lutfen tur icin sözlü notu giriniz");
        int notTs = scan.nextInt();
        System.out.println("Tur yazili notu: " +notTy + "\nTur sözlü notu: " + notTs);


            int matOrt = (int) ((notms * 0.20) + (notmy * 0.80));
            int turOrt = (int) ((notTs * 0.20) + (notTy * 0.80));
            int bioOrt = (int) ((notbs * 0.20) + (notby * 0.80));

            ogrenciMap.get(arananId).setMat(matOrt);//eski raf değerini ezip güncel raf değerini girecek
            ogrenciMap.get(arananId).setMat(turOrt);//eski raf değerini ezip güncel raf değerini girecek
            ogrenciMap.get(arananId).setMat(bioOrt);//eski raf değerini ezip güncel raf değerini girecek

        } else {
            System.out.println("bu öğrenci numarasında öğrenci yoktur");
            sinavNotuEkle();
        }

        System.out.println(ogrenciMap);
    }

    private static void student() {
        System.out.println("lütfen öğrenci bilgileri giriniz: ");
        System.out.println("isim giriniz");
        scan.nextLine();//bos dummy attık
       String studentName = scan.nextLine();
        System.out.println("öğrenci numarası giriniz giriniz");
        String stuNo = scan.nextLine();
        System.out.println("sınıf giriniz");
        //scan.nextLine();//bos dummy attık
        String classes = scan.nextLine();
        int mat=0;
        int tur=0;
        int bio=0;

        depoStudent ogrenci  = new depoStudent(stuNo,studentName,classes,mat,tur,bio);//urun objesi oluşturuldu
        ogrenciMap.put(stuNo,ogrenci);

        System.out.println(ogrenciMap);

    }


}


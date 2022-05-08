package notHesap;

import javax.xml.namespace.QName;
import java.util.*;

import static notHesap.Main.girisPaneli;
import static notHesap.depoStudent.*;
import static notHesap.depoStudent.setMatSozluYuzde;

public class Student {

    //static Course mat;
    //static Course tur;
    //static Course bio;
    static Scanner scan = new Scanner(System.in);
    static List<String> ogrenciList = new ArrayList<>();
    public static Map<String, depoStudent> ogrenciMap = new HashMap<String, depoStudent>();


    public static void studentPaneli() {

        double cAvarage;
//Methods : Student(), addBulkExamNote(), isPass(), calcAvarage(), printNote()
//-->öğrenci(), topluSınavNotuEkle(), gectiMi() ortlamaHesapla(), notYazdır()
        System.out.println("====================================\nOGRENCI YONETIM PANELI\n" +
                "====================================\n"
                + "1- ÖGRENCI EKLEME\n2- ORTALAMA YÜZDE BELİRLEME\n3- SINAV NOTU EKLEYİNİZ \n4- GECTİMİ \n5- ORTALAMA HESAPLAYINIZ \n6- NOTLARI YAZDIRINIZ\n7- ÖĞRENCİ LİSTESİ\n8- ÖĞRENCİ PANELİNDEN ÇIKIŞ ");
        System.out.print("isleminiz seciniz : ");
        String secim = scan.next().toUpperCase(Locale.ROOT);
        switch (secim) {
            case "1":
                student();
                studentPaneli();
                break;
            case "2":
                yuzdeBelirle();
                studentPaneli();
                break;
            case "3":
                sinavNotuEkle();
                studentPaneli();
                break;
            case "4":
                gectiMi();
                studentPaneli();
                break;
            case "5":
                ortalama();
                studentPaneli();
                break;
            case "6":
                notlariYazdir();
                studentPaneli();
                break;
            case "7":
                listeleme();
                studentPaneli();
                break;
            case "8":
                break;
            default:
                break;
        }
    }

    private static void listeleme() {
        System.out.println("   *** öğrenci paneli   ***");
        Set<Map.Entry<String, depoStudent> > EntrySeti = ogrenciMap.entrySet();
        System.out.println("------------------------ÖĞRENCİ LİSTESİ---------------------------------");
        System.out.println("ÖĞRENCİNO   İSİMSOYİSİM     SINIFI      MATEMATİK   TÜRKÇE  BİYOLOJİ"+
                "\n-----------------------------------------------------------------------");
        for (Map.Entry<String, depoStudent> e : EntrySeti
        ) {
            String entryKey = e.getKey();
            System.out.printf("%-8s %-12s %-15s  %-10f %-10f %-10f\n",ogrenciMap.get(entryKey).getStuNo(), ogrenciMap.get(entryKey).getStudentName(), ogrenciMap.get(entryKey).getClasses(),ogrenciMap.get(entryKey).getMat(),ogrenciMap.get(entryKey).getTur(),ogrenciMap.get(entryKey).getBio());
        }
    }

    private static void yuzdeBelirle() {
        System.out.println("Sözlü notlarının ortalamaya etkileme yüzdesini, her ders için ayrı  belirtin. (0.20, 0.30 veya 0.50 giriniz) ");
        System.out.println("matematik sözlü notu yüzdesi: ");
        double x=scan.nextDouble();
        if ((x==0.20)||(x==0.30) ||(x==0.50)){
            setMatSozluYuzde(x);
        }else {
            System.out.println("lütfen geçerli yüzdelik giriniz");
        }

        System.out.println("biyoloji sözlü notu yüzdesi: ");
        double y=scan.nextDouble();
        if ((y==0.20)||(y==0.30) ||(y==0.50)){
            setBioSozluYuzde(y);
        }else {
            System.out.println("lütfen geçerli yüzdelik giriniz");
        }

        System.out.println("türkçe sözlü notu yüzdesi: ");
        double z=scan.nextDouble();
        if ((z==0.20)||(z==0.30) ||(z==0.50)){
            setTurSozluYuzde(z);
        }else {
            System.out.println("lütfen geçerli yüzdelik giriniz");
        }

    }

    private static void ortalama() {
        System.out.println("not ortalamasını öğrenmek istediğiniz öğrenci id sini yazınız :");
        String arananId = scan.next();

        if (ogrenciMap.keySet().contains(arananId)) {
            double genelOrt = (ogrenciMap.get(arananId).getMat() + ogrenciMap.get(arananId).getBio() + ogrenciMap.get(arananId).getTur()) / 3;
            String gectiMi = genelOrt >= 50 ? "GEÇTİ" : "GEÇEMEDİ";
            System.out.println("Öğrencinin not Ortalaması:\n" + genelOrt);
        } else {
            System.out.println("bu öğrenci numarasında öğrenci yoktur");
            ortalama();
        }
    }


    private static void notlariYazdir() {
        System.out.println("notlarını yazdırmak istediğiniz öğrenci id sini yazınız :");
        String arananId = scan.next();

        if (ogrenciMap.keySet().contains(arananId)) {
            System.out.println("Mat not ortalaması: " + ogrenciMap.get(arananId).getMat());
            System.out.println("Bio not ortalaması: " + ogrenciMap.get(arananId).getBio());
            System.out.println("Tur not ortalaması: " + ogrenciMap.get(arananId).getTur());
        } else {
            System.out.println("bu öğrenci numarasında öğrenci yoktur");
            notlariYazdir();
        }
    }

    private static void gectiMi() {
        System.out.println("sınıfı geçip geçmediğini öğrenmek istediğiniz öğrenci id sini yazınız :");
        String arananId = scan.next();

        if (ogrenciMap.keySet().contains(arananId)) {
            double genelOrt = (ogrenciMap.get(arananId).getMat() + ogrenciMap.get(arananId).getBio() + ogrenciMap.get(arananId).getTur()) / 3;
            String gectiMi = genelOrt >= 50 ? "GEÇTİ" : "GEÇEMEDİ";
            System.out.println("Öğrencinin Ortalaması:\n" + genelOrt + "\nSınıfı " + gectiMi);
        } else {
            System.out.println("bu öğrenci numarasında öğrenci yoktur");
            gectiMi();
        }

        System.out.println(ogrenciMap);


    }

    private static void sinavNotuEkle() {
        if (getBioSozluYuzde() == 0 && getTurSozluYuzde() == 0 && getMatSozluYuzde() == 0) {
            System.out.println("notların yüzdelik dilimini girmediniz! lütfen öncelikle yüzdelik miktarını giriniz..");
            yuzdeBelirle();
        } else {
            System.out.println("notunu girmek istediğiniz öğrenci id sini yazınız :");
            String arananId = scan.next();

            if (ogrenciMap.keySet().contains(arananId)) {


                System.out.println("Lutfen mat icin yazili notu giriniz");
                Double notmy = scan.nextDouble();
                System.out.println("Lutfen mat icin sözlü notu giriniz");
                Double notms = scan.nextDouble();
                System.out.println("Mat yazili notu: " + notmy + "\nMat sözlü notu: " + notms);


                System.out.println("Lutfen bio icin yazili notu giriniz");
                Double notby = scan.nextDouble();
                System.out.println("Lutfen bio icin sözlü notu giriniz");
                Double notbs = scan.nextDouble();
                System.out.println("Bio yazili notu: " + notby + "\nBio sözlü notu: " + notbs);


                System.out.println("Lutfen tur icin yazili notu giriniz");
                Double notTy = scan.nextDouble();
                System.out.println("Lutfen tur icin sözlü notu giriniz");
                Double notTs = scan.nextDouble();
                System.out.println("Tur yazili notu: " + notTy + "\nTur sözlü notu: " + notTs);


                Double matOrt = (Double) ((notms * getMatSozluYuzde()) + (notmy * (1 - getMatSozluYuzde())));
                Double turOrt = (Double) ((notTs * getTurSozluYuzde()) + (notTy * (1 - getTurSozluYuzde())));
                Double bioOrt = (Double) ((notbs * getBioSozluYuzde()) + (notby * (1 - getBioSozluYuzde())));

                ogrenciMap.get(arananId).setMat(matOrt);
                ogrenciMap.get(arananId).setTur(turOrt);
                ogrenciMap.get(arananId).setBio(bioOrt);

            } else {
                System.out.println("bu öğrenci numarasında öğrenci yoktur");
                sinavNotuEkle();
            }
        }

        System.out.println(ogrenciMap);
    }

    private static void student() {
        System.out.println("lütfen öğrenci bilgileri giriniz: ");
        System.out.println("isim giriniz");
        scan.nextLine();//bos dummy attık
        String studentName = scan.nextLine();
        System.out.println("öğrenci numarası giriniz");
        String stuNo = scan.nextLine();
        System.out.println("sınıf giriniz");
        //scan.nextLine();//bos dummy attık
        String classes = scan.nextLine();
        Double mat = 0.0;
        Double tur = 0.0;
        Double bio = 0.0;

        depoStudent ogrenci = new depoStudent(stuNo, studentName, classes, mat, tur, bio);//urun objesi oluşturuldu
        ogrenciMap.put(stuNo, ogrenci);

        System.out.println(ogrenciMap);

    }


}


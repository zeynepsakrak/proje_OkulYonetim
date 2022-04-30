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
         System.out.println("not ortalamasını öğrenmek istediğiniz öğrenci id sini yazınız :");
        String arananId= scan.next();

        if (ogrenciMap.keySet().contains(arananId)) {
            double genelOrt= (ogrenciMap.get(arananId).getMat()+ogrenciMap.get(arananId).getBio()+ogrenciMap.get(arananId).getTur())/3;
        String gectiMi = genelOrt >= 50 ? "GEÇTİ" : "GEÇEMEDİ";
        System.out.println("Öğrencinin not Ortalaması:\n" + genelOrt );
        } else {
            System.out.println("bu öğrenci numarasında öğrenci yoktur");
            ortalama();
        }
    }


    private static void notlariYazdir() {
        System.out.println("notlarını yazdırmak istediğiniz öğrenci id sini yazınız :");
        String arananId= scan.next();

        if (ogrenciMap.keySet().contains(arananId)) {
        System.out.println("Mat not ortalaması: " +ogrenciMap.get(arananId).getMat());
        System.out.println("Bio not ortalaması: "+ogrenciMap.get(arananId).getBio() );
        System.out.println("Tur not ortalaması: " + ogrenciMap.get(arananId).getTur());
        } else {
            System.out.println("bu öğrenci numarasında öğrenci yoktur");
           notlariYazdir();
        }
    }

    private static void gectiMi() {
        System.out.println("sınıfı geçip geçmediğini öğrenmek istediğiniz öğrenci id sini yazınız :");
        String arananId= scan.next();

        if (ogrenciMap.keySet().contains(arananId)) {
            double genelOrt= (ogrenciMap.get(arananId).getMat()+ogrenciMap.get(arananId).getBio()+ogrenciMap.get(arananId).getTur())/3;
        String gectiMi = genelOrt >= 50 ? "GEÇTİ" : "GEÇEMEDİ";
        System.out.println("Öğrencinin Ortalaması:\n" + genelOrt + "\nSınıfı " + gectiMi);
        } else {
            System.out.println("bu öğrenci numarasında öğrenci yoktur");
            gectiMi();
        }

        System.out.println(ogrenciMap);


    }

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

            ogrenciMap.get(arananId).setMat(matOrt);
            ogrenciMap.get(arananId).setTur(turOrt);
            ogrenciMap.get(arananId).setBio(bioOrt);

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


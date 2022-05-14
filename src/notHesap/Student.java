package notHesap;

import javax.xml.namespace.QName;
import java.util.*;
import static notHesap.Main.girisPaneli;
import static notHesap.depoStudent.*;
import static notHesap.depoStudent.setMatSozluYuzde;

public class Student {

    static Scanner scan = new Scanner(System.in);
    static List<String> ogrenciList = new ArrayList<>();
    public static Map<String, depoStudent> ogrenciMap = new HashMap<String, depoStudent>();
    public static void studentPaneli() {

        double cAvarage;
        System.out.println("====================================\nOGRENCI YONETIM PANELI\n" +
                "====================================\n"
                + "1- ÖGRENCI EKLEME\n2- ÖĞRENCİ SİLME \n3- SINAV NOTU EKLEYİNİZ \n4- GECTİMİ \n5- ORTALAMA HESAPLAYINIZ \n6- NOTLARI YAZDIRINIZ\n7- ÖĞRENCİ LİSTESİ\nHERHANGİ BİR TUŞ- ÖĞRENCİ PANELİNDEN ÇIKIŞ ");
        System.out.print("isleminiz seciniz : ");
        String secim = scan.next().toUpperCase(Locale.ROOT);
        switch (secim) {
            case "1":
                student();
                studentPaneli();
                break;
            case "2":
               studentDelete();
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
                girisPaneli();
                break;
            default:
                break;
        }
    }

    private static void studentDelete() {
        System.out.println("bilgisini silmek istediğiniz öğrenci numarasını yazınız :");
        String arananId = scan.next();

        if (ogrenciMap.keySet().contains(arananId)) {
               ogrenciMap.remove(arananId);
            System.out.println("öğrenci bilgileri silinmiştir");
        } else {
            System.out.println("böyle bir öğrenci bulunamadığından silinemedi");
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
            System.out.printf("%-10s %-12s %-12s  %-10f %-10f %-10f\n",ogrenciMap.get(entryKey).getStuNo(), ogrenciMap.get(entryKey).getStudentName(), ogrenciMap.get(entryKey).getClasses(),ogrenciMap.get(entryKey).getMat(),ogrenciMap.get(entryKey).getTur(),ogrenciMap.get(entryKey).getBio());
        }
    }

    private static void yuzdeBelirle() {

        System.out.println("Sözlü notlarının ortalamaya etkileme yüzdesini, her ders için ayrı  belirtin. \nLÜTFEN!! 0.20, 0.30 veya 0.50 giriniz ");

        double x;
        double y;
        double z;

        boolean xFlag = false;
        boolean yFlag = false;
        boolean zFlag = false;

        do{
            System.out.println("matematik sözlü notu yüzdesi: ");

            if(xFlag==true){
                scan.nextLine();
                xFlag=false;
            }

            try {
                x=scan.nextDouble();
                setMatSozluYuzde(x);

                if (((x==0.20) || (x==0.30) || (x==0.50))){
                    xFlag=false;
                } else {
                    xFlag=true;
                }
            } catch (Exception e) {
                xFlag=true;
            }
        }while(xFlag);

        do{
            System.out.println("biyoloji sözlü notu yüzdesi: ");

            if(yFlag==true){
                scan.nextLine();
                yFlag=false;
            }

            try {
                y=scan.nextDouble();
                setBioSozluYuzde(y);
                if (((y==0.20)||(y==0.30) ||(y==0.50))){
                    yFlag=false;
                }else {
                    yFlag=true;
                }
            } catch (Exception e) {
                yFlag=true;
            }
        }while(yFlag);

        do{
            System.out.println("türkçe sözlü notu yüzdesi: ");

            if(zFlag==true){
                scan.nextLine();
                zFlag=false;
            }

            try {
                z=scan.nextDouble();
                setTurSozluYuzde(z);
                if (((z==0.20)||(z==0.30) ||(z==0.50))){
                    zFlag=false;
                } else {
                    zFlag=true;
                }
            } catch (Exception e) {
                zFlag=true;
            }
        }while(zFlag);
            sinavNotuEkle();

    }

    private static void ortalama() {
        System.out.println("not ortalamasını öğrenmek istediğiniz öğrenci numarasını yazınız :");
        String arananId = scan.next();
        if (ogrenciMap.keySet().contains(arananId)) {
            double genelOrt = (ogrenciMap.get(arananId).getMat() + ogrenciMap.get(arananId).getBio() + ogrenciMap.get(arananId).getTur()) / 3;
            String gectiMi = genelOrt >= 50 ? "GEÇTİ" : "GEÇEMEDİ";
            System.out.println(ogrenciMap.get(arananId).getStudentName()+" isimli Öğrencinin not Ortalaması:\n" + genelOrt);
        } else {
            System.out.println("bu öğrenci numarasında öğrenci yoktur");
            ortalama();
        }
    }


    private static void notlariYazdir() {
        System.out.println("notlarını yazdırmak istediğiniz öğrenci numarasını yazınız :");
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
        System.out.println("sınıfı geçip geçmediğini öğrenmek istediğiniz öğrenci numarasını yazınız :");
        String arananId = scan.next();

        try {
            if (ogrenciMap.keySet().contains(arananId)) {

                double genelOrt = (ogrenciMap.get(arananId).getMat() + ogrenciMap.get(arananId).getBio() + ogrenciMap.get(arananId).getTur()) / 3;
                String gectiMi = genelOrt >= 50 ? "GEÇTİ" : "GEÇEMEDİ";
                System.out.println(ogrenciMap.get(arananId).getStudentName()+ " isimli öğrenci sınıfı :"+ gectiMi);
            } else {
                System.out.println("bu öğrenci numarasında öğrenci yoktur");
                gectiMi();
            }
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }



    }

    private static void sinavNotuEkle() {

        if (getBioSozluYuzde() == 0 && getTurSozluYuzde() == 0 && getMatSozluYuzde() == 0) {
            System.out.println("notların yüzdelik dilimini girmediniz! lütfen öncelikle yüzdelik miktarını giriniz..");
            yuzdeBelirle();
        } else {
            System.out.println("notunu girmek istediğiniz öğrenci numarasını yazınız :");
            String arananId = scan.next();

            if (ogrenciMap.keySet().contains(arananId)) {



                Double notmy = null;
                boolean myFlag = false;

                do {
                    System.out.println("Lutfen mat icin yazili notu giriniz");
                    if (myFlag==true){
                        scan.nextLine();
                        myFlag=false;
                    }
                    try {
                        notmy = scan.nextDouble();
                    } catch (Exception e) {
                        myFlag=true;
                    }
                } while (myFlag);

                Double notms = null;
                boolean msFlag = false;
                do {
                    System.out.println("Lutfen mat icin sözlü notu giriniz");
                    if (msFlag==true){
                        scan.nextLine();
                        msFlag=false;
                    }
                    try {
                        notms = scan.nextDouble();
                    } catch (Exception e) {
                        msFlag=true;
                    }
                } while (msFlag);

                System.out.println("Mat yazili notu: " + notmy + "\nMat sözlü notu: " + notms);


                Double notby = null;
                boolean byFlag= false;

                do {
                    System.out.println("Lutfen bio icin yazili notu giriniz");
                    if (byFlag==true){
                        scan.nextLine();
                        byFlag=false;
                    }
                    try {
                        notby = scan.nextDouble();
                    } catch (Exception e) {
                        byFlag=true;
                    }
                } while (byFlag);

                Double notbs = null;
                boolean bsFlag= false;

                do {
                    System.out.println("Lutfen bio icin sözlü notu giriniz");
                    if (bsFlag==true){
                        scan.nextLine();
                        bsFlag=false;
                    }
                    try {
                        notbs = scan.nextDouble();
                    } catch (Exception e) {
                        bsFlag=true;
                    }
                } while (bsFlag);

                System.out.println("Bio yazili notu: " + notby + "\nBio sözlü notu: " + notbs);


                Double notTy= null;
                boolean tyFlag= false;

                do {
                    System.out.println("Lutfen tur icin yazili notu giriniz");
                    if (tyFlag==true){
                        scan.nextLine();
                        tyFlag=false;
                    }
                    try {
                        notTy = scan.nextDouble();
                    } catch (Exception e) {
                        tyFlag=true;
                    }
                } while (tyFlag);

                Double notTs= null;
                boolean tsFlag= false;

                do {
                    System.out.println("Lutfen tur icin sözlü notu giriniz");
                    if (tsFlag==true){
                        scan.nextLine();
                        tsFlag=false;
                    }
                    try {
                        notTs = scan.nextDouble();
                    } catch (Exception e) {
                        tsFlag=true;
                    }
                } while (tsFlag);

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
            }}

    }

    private static void student() {
        System.out.println("lütfen öğrenci bilgileri giriniz: ");
        System.out.println("isim soyisim giriniz");
        scan.nextLine();//bos dummy attık
        String studentName = scan.nextLine();
        System.out.println("öğrenci numarası giriniz");
        String stuNo = scan.nextLine();
        System.out.println("sınıf giriniz");
        String classes = scan.nextLine();
        double mat = 0.0;
        double tur = 0.0;
        double bio = 0.0;

        depoStudent ogrenci = new depoStudent(stuNo, studentName, classes, mat, tur, bio);//urun objesi oluşturuldu
        ogrenciMap.put(stuNo, ogrenci);

        System.out.println("başka öğrenci eklemek istiyorsanız 1'i,\nöğrenciyi silmek istiyorsanız 2'yi, \nöğrenci paneline dönmek için istediğiniz tuşa basınız.");
        String secim = scan.next().toUpperCase(Locale.ROOT);
        switch (secim) {
            case "1":
              student();
                break;
            case "2":
                studentDelete();
                break;
            default:
                studentPaneli();
                break;
        }
    }


}


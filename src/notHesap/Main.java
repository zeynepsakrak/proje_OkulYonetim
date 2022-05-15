package notHesap;

import static notHesap.Student.scan;
import static notHesap.Student.studentPaneli;
import static notHesap.Teacher.teacherPaneli;

public class Main{
    public static void main(String[] args) {
        girisPaneli();
    }

    public static void girisPaneli() {
        String girilenDeger = "1";
        do {
            System.out.println("" +
                    "    ======================================\n" +
                    "\tÖĞRENCİ VE ÖĞRETMEN YÖNETİM PANELİ\n" +
                    "\t======================================\n" +"\n"+
                    "\t 1- ÖĞRENCİ İŞLEMLERİ\n" +
                    "\t 2- ÖĞRETMEN İŞLEMLERİ\n" +
                    "\t 3- ÇIKIŞ"
            );
            System.out.print("\nLütfen islemi giriniz: ");
            girilenDeger = scan.next();

            switch (girilenDeger) {
                case "1":
                    studentPaneli();
                    break;
                case "2":
                    teacherPaneli();
                    break;
                case "3":
                    break;
            }


        } while (!girilenDeger.equalsIgnoreCase("3"));
        System.out.println("Sistemden başarıyla çıktınız");
        System.exit(0);
    }
}



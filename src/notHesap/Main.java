package notHesap;

import static notHesap.Student.scan;
import static notHesap.Student.studentPaneli;
import static notHesap.Teacher.teacherPaneli;

public class Main {
    public static void main(String[] args) {
        girisPaneli();
    }

    public static void girisPaneli() {
            String girilenDeger = "1";
            do {
                System.out.println("" +
                        "====================================\n" +
                        "\t ÖĞRENCİ VE ÖĞRETMEN YÖNETİM PANELİ\n" +
                        "\t====================================\n" +
                        "\t 1- ÖĞRENCİ İŞLEMLERİ\n" +
                        "\t 2- ÖĞRETMEN İŞLEMLERİ\n" +
                        "\t 3- COURSE İŞLEMLERİ\n" +
                        "\t Q- ÇIKIŞ"
                );
                System.out.print("Lütfen islemi giriniz: ");
                girilenDeger = scan.next();

                switch (girilenDeger) {
                    case "1":
                        studentPaneli();
                        break;
                    case "2":
                        teacherPaneli();
                        break;

                    case "3":
                        System.out.println("COURSE paneli");
                        break;
                }


            } while (!girilenDeger.equalsIgnoreCase("Q"));
            System.out.println("Sistemden başarıyla çıktınız");
        }
        }


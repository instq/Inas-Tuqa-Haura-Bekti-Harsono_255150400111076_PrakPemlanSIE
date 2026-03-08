package Modul1;

import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //instansiasi objek bernama m1
        Mobil m1 = new Mobil();
        
        System.out.print("Masukkan merk mobil1: ");
        String merk1 = input.nextLine();

        System.out.print("Masukkan Nomor Polisi mobil1: ");
        String nopol1 = input.nextLine();

        System.out.println("---------------");
        
        m1.setMerk(merk1);
        m1.setNopol(nopol1);
        m1.setWarna("Merah");
        m1.setKecepatan(50);

        int jarak = m1.hitungJarakTempuh(2);
        m1.setJarakTempuh(jarak);

        m1.display();
        System.out.println("---------------");
        
        //instansiasi objek bernama m2
        Mobil m2 = new Mobil();
        
        System.out.print("Masukkan merk mobil2: ");
        String merk2 = input.nextLine();

        System.out.print("Masukkan Nomor Polisi mobil2: ");
        String nopol2 = input.next();

        System.out.println("---------------");

        m2.setKecepatan(100);
        m2.setMerk(merk2);
        m2.setNopol(nopol2);
        m2.setWarna("Biru");
        m2.display();
        System.out.println("---------------");

        System.out.println("Atribut pada objek m1 diubah.");
        //mengubah warna dari objek m1
        m1.setWarna("Hijau");
        //menampilkan hasil perubahan
        m1.display();
    }
}
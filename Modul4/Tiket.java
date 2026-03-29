public class Tiket {
    private String namaPenumpang = "Anonim";
    private String tujuan = "Jakarta";
    private int jarakTempuh = 750;
    private double hargaTiket = 250000;

    public void pesan() {}

    public void pesan(String n, String t) {
        this.namaPenumpang = n;
        this.tujuan = t;
        this.jarakTempuh = 90; this.hargaTiket = 55000;
    }

    public void pesan(String n, String t, int j, double h) {
        this.namaPenumpang = n;
        this.tujuan = t;
        this.jarakTempuh = j; this.hargaTiket = h;
    }

    public void setTujuan(String t) {
        this.tujuan = t;
    }

    public String getTujuan() {
        return this.tujuan;
    }

    public void setNamaPenumpang(String n) {
        this.namaPenumpang = n;
    }

    public String getNamaPenumpang() {
        return this.namaPenumpang;
    }

    public double getHargaTiket() {
        return this.hargaTiket;
    }

    // public void pesan(String n, int j) {
    //     this.namaPenumpang = n;
    //     this.jarakTempuh = j;
    // }

    // public void pesan(String t, String n) {
    //     this.tujuan = t;
    //     this.namaPenumpang = n;
    // }

    public void tampil() {
        System.out.println("Nama Penumpang: " + this.namaPenumpang);
        System.out.println("Tujuan: " + this.tujuan);
        System.out.println("Jarak Tempuh: " + this.jarakTempuh);
        System.out.println("Harga Tiket: " + this.hargaTiket);
        System.out.println("--------------------");
    }
}


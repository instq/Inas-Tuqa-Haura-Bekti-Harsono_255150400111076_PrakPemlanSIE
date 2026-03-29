public class TiketBus extends Tiket {
    @Override
    public void pesan() {
        this.setTujuan("Bandung");
    }

    @Override
    public void pesan(String n, String t) {
        if (t.equals("Makassar")) {
            this.setTujuan("Makassar");
            System.out.println("Maaf " + n + ", tiket tidak dapat dipesan.");
        }
    }

    @Override
    public void tampil() {
        if (!this.getTujuan().equals("Makassar")) {
            super.tampil();
        } else {
            System.out.println("Tiket tujuan Makassar tidak tersedia.");
            System.out.println("--------------------");
        }
    }

    public void pesan(String n) {
        this.setNamaPenumpang(n);
    }
}

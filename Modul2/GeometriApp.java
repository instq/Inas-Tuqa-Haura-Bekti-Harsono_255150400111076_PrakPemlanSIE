public class GeometriApp {
    public static void main(String[] args) {
        Lingkaran lingKecil = new Lingkaran(2.0f);
        Lingkaran lingBesar = new Lingkaran(11.0f);

        float lK = lingKecil.luas();
        float lB = lingBesar.luas();
        
        System.out.println("Luas Lingkaran Kecil: " + lK);
        System.out.println("Luas Lingkaran Besar: " + lB);

        System.out.println("Luas Lingkaran Besar: " + lingBesar.luas());
        System.out.println("Keliling Lingkaran Besar: " + lingBesar.keliling());
    }
}

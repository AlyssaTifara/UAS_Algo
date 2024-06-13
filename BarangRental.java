public class BarangRental{
    String noTNKB;
    String namaKendaraan;
    String jenisKendaraan;
    int tahun;
    int biayaSewa;

    public BarangRental(){
    }

    BarangRental(String noTNKB, String namaKendaraan, String jenisKendaraan, int tahun, int biayaSewa){
        this.tahun = tahun;
        this.namaKendaraan = namaKendaraan;
        this.jenisKendaraan = jenisKendaraan;
        this.noTNKB = noTNKB;
        this.biayaSewa = biayaSewa;
    }

    public String toString() {
        return noTNKB + " " + namaKendaraan + " " + jenisKendaraan + " " + tahun + " " + biayaSewa;
    }
}
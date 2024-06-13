public class Transaksirental {
    int kodeTransaksi;
    String namaPeminjam;
    int lamaPinjam;
    double totalBiaya;
    BarangRental br;

    Transaksirental(int kodeTransaksi, String namaPeminjam, int lamaPinjam, double totalBiaya, BarangRental br){
        this.br = br;
        this.namaPeminjam = namaPeminjam;
        this.kodeTransaksi = kodeTransaksi;
        this.totalBiaya = totalBiaya;
        this.lamaPinjam = lamaPinjam;
    }

    public String toString() {
        return "Kode Transaksi: " + kodeTransaksi + ", Nama Peminjam: " + namaPeminjam + ", Lama Pinjam: " + lamaPinjam + " hari, Total Biaya: " + totalBiaya + ", Barang: [" + br + "]";
    }
}
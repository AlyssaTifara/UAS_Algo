import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static List<BarangRental> kendaraan = new ArrayList<>();
    static List<Transaksirental> transaksi = new ArrayList<>();
    static String[] namaPeminjam = new String[10];
    static int jumlahPeminjam = 0;
    static String[] noTNKB = new String[10];
    static int[] lamaPinjam = new int[10];

    public static void menu() {
        System.out.println("==============================");
        System.out.println("          Pilih Menu          ");
        System.out.println("==============================");
        System.out.println("1. Daftar Kendaraan");
        System.out.println("2. Peminjam");
        System.out.println("3. Tampilkan Seluruh Transaksi");
        System.out.println("4. Urutkan Transaksi");
        System.out.println("5. Keluar");
        System.out.println("===============================");
        System.out.print("Pilih(1-5): ");
    }

    public static void kelolaKendaraan() {
        kendaraan.add(new BarangRental("15 4567 YV", "Honda Beat", "Motor", 2017, 10000));
        kendaraan.add(new BarangRental("IN 4511 VS", "Honda Vario", "Motor", 2018, 10000));
        kendaraan.add(new BarangRental("IN 1453 AA", "Toyota Yaris", "Mobil", 2022, 30000));
        kendaraan.add(new BarangRental("AB 4321 A", "Toyota Innova", "Mobil", 2019, 60000));
        kendaraan.add(new BarangRental("B1234 AG", "Toyota Avanza", "Mobil", 2021, 25000));

        System.out.println("==========================================================================");
        System.out.println("                               Daftar Kendaraan                          ");
        System.out.println("==========================================================================");
        System.out.printf("%-10s %-20s %-20s %-10s %-15s\n", "Nomor TNKB", "Nama Kendaraan", "Jenis Kendaraan", "Tahun", "Biaya Sewa");
        System.out.println("--------------------------------------------------------------------------");

        for (BarangRental k : kendaraan) {
            System.out.printf("%-10s %-20s %-20s %-10d %-15d\n",
                k.noTNKB, k.namaKendaraan, k.jenisKendaraan, k.tahun, k.biayaSewa);
        }
    }

    public static void kelolaPeminjam() {
        System.out.println("Masukkan data pelanggan:");
        System.out.print("Nama Peminjam: ");
        String nama = sc.nextLine();
        System.out.print("Nomor TNKB: ");
        String tnkb = sc.nextLine();
        System.out.print("Lama Pinjam (hari): ");
        int lama = Integer.parseInt(sc.nextLine());
    
        namaPeminjam[jumlahPeminjam] = nama;
        noTNKB[jumlahPeminjam] = tnkb;
        lamaPinjam[jumlahPeminjam] = lama;
        jumlahPeminjam++;
    
        System.out.println("==========================================================================");
        System.out.println("                              Daftar Peminjam                             ");
        System.out.println("==========================================================================");
        System.out.printf("%-5s %-30s %-15s %-10s\n", "No.", "Nama Peminjam", "No. TNKB", "Lama Pinjam (hari)");
        System.out.println("--------------------------------------------------------------------------");
        for (int i = 0; i < jumlahPeminjam; i++) {
            System.out.printf("%-5d %-30s %-15s %-10d\n", i + 1, namaPeminjam[i], noTNKB[i], lamaPinjam[i]);
        }
    }
    

    public static void kelolaTransaksi() {
        if (transaksi.isEmpty()) {
            System.out.println("Belum ada transaksi yang tercatat.");
            return;
        }
        System.out.println("===================================================================================================");
        System.out.println("                                    Data Transaksi");
        System.out.println("===================================================================================================");
        System.out.printf("%-10s %-20s %-20s %-15s %-10s %-15s\n", "Kode", "Nomor TNKUN", "Nama Barang", "Nama Peminjam", "Lama Pinjam", "Total Biaya");
        System.out.println("---------------------------------------------------------------------------------------------------");
        for (Transaksirental tr : transaksi) {
            System.out.printf("%-10s %-20s %-20s %-15s %-10d %-15d\n",
                    tr.kodeTransaksi, tr.br.noTNKB, tr.br.namaKendaraan, tr.namaPeminjam, tr.lamaPinjam, tr.totalBiaya);
        }
    }
    
    public static void tambahPeminjam() {
        System.out.println("Masukkan Data Peminjam:");
        System.out.print("Nama: ");
        String nama = sc.nextLine();
        if (jumlahPeminjam == namaPeminjam.length) {
            System.out.println("Daftar peminjam sudah penuh!");
            return;
        }
        namaPeminjam[jumlahPeminjam++] = nama;
        System.out.println("Peminjam baru dengan nama " + nama + " telah ditambahkan.");
    }
    

    public static void urutkanTransaksi() {
        for (int i = 0; i < transaksi.size() - 1; i++) {
            for (int j = 0; j < transaksi.size() - i - 1; j++) {
                if (transaksi.get(j).kodeTransaksi > transaksi.get(j + 1).kodeTransaksi) {
                    Transaksirental temp = transaksi.get(j);
                    transaksi.set(j, transaksi.get(j + 1));
                    transaksi.set(j + 1, temp);
                }
            }
        }
        System.out.println("Transaksi diurutkan berdasarkan kode transaksi:");
        kelolaTransaksi();
    }

    public static void main(String[] args) {
        int pilihan;
        do {
            menu();
            pilihan = sc.nextInt();
            sc.nextLine(); 

            switch (pilihan) {
                case 1:
                    kelolaKendaraan();
                    break;
                case 2:
                    kelolaPeminjam();
                    break;
                case 3:
                    kelolaTransaksi();
                    break;
                case 4:
                    urutkanTransaksi();
                    break;
                case 5:
                    System.out.println("Terimakasih!!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 5);
    }
}
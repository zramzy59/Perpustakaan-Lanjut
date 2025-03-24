import java.util.Scanner;

// Kelas untuk merepresentasikan kategori buku
class Kategori {
    String nama; // Nama kategori buku

    public Kategori(String nama) {
        this.nama = nama;
    }
}

// Kelas untuk merepresentasikan buku
class Buku {
    String judul, penulis, sinopsis;
    int tahunTerbit;
    Kategori kategori;

    // Konstruktor untuk menginisialisasi buku
    public Buku(String judul, int tahunTerbit, Kategori kategori, String penulis, String sinopsis) {
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
        this.kategori = kategori;
        this.penulis = penulis;
        this.sinopsis = sinopsis;
    }

    // Menghitung jumlah kata dalam sinopsis
    public int hitungJumlahKata() {
        return sinopsis.split("\\s+").length;
    }

    // Membandingkan kesamaan antara dua buku berdasarkan atribut tertentu
    public double cekKesamaan(Buku bukuLain) {
        int kesamaan = 0;
        if (judul.equalsIgnoreCase(bukuLain.judul)) kesamaan++;
        if (tahunTerbit == bukuLain.tahunTerbit) kesamaan++;
        if (kategori.nama.equalsIgnoreCase(bukuLain.kategori.nama)) kesamaan++;
        if (penulis.equalsIgnoreCase(bukuLain.penulis)) kesamaan++;
        if (sinopsis.equalsIgnoreCase(bukuLain.sinopsis)) kesamaan++;

        return (kesamaan / 5.0) * 100;
    }

    // Membuat salinan buku
    public Buku copy() {
        return new Buku(judul, tahunTerbit, kategori, penulis, sinopsis);
    }

    // Menghitung royalti 10% dari total penjualan bulan ini
    public double hitungRoyalti(double hargaBuku) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jumlah buku yang terjual bulan ini: ");
        int jumlahTerjual = scanner.nextInt();

        return (hargaBuku * jumlahTerjual) * 0.1;
    }

    // Menghitung royalti berdasarkan persentase yang diinginkan
    public double hitungRoyalti(double hargaBuku, double persenRoyalti) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jumlah buku yang terjual bulan ini: ");
        int jumlahTerjual = scanner.nextInt();

        return (hargaBuku * jumlahTerjual) * (persenRoyalti / 100);
    }
}

// Kelas utama untuk menjalankan program
public class royalty {
    public static void main(String[] args) {
        // Inisialisasi kategori buku
        Kategori teknologi = new Kategori("Teknologi");
        Kategori filsafat = new Kategori("Filsafat");
        Kategori sejarah = new Kategori("Sejarah");
        Kategori psikologi = new Kategori("Psikologi");
        Kategori fiksi = new Kategori("Fiksi");

        // Inisialisasi buku dengan kategori masing-masing
        Buku buku1 = new Buku("Buku Pemrograman", 2022, teknologi, "Zulfikar Ramzy", "Buku ini membahas konsep pemrograman modern dan penerapannya dalam dunia kerja.");
        Buku buku2 = new Buku("Buku Filsafat", 2023, filsafat, "Zulfikar Ramzy", "Buku ini membahas pemikiran filsafat dari berbagai era.");
        Buku buku3 = new Buku("Buku Sejarah", 2024, sejarah, "Zulfikar Ramzy", "Buku ini menjelaskan sejarah peradaban dunia dengan rinci.");
        Buku buku4 = new Buku("Buku Psikologi", 2025, psikologi, "Zulfikar Ramzy", "Buku ini mengupas berbagai teori psikologi dan penerapannya.");
        Buku buku5 = new Buku("Buku Fiksi", 2026, fiksi, "Zulfikar Ramzy", "Buku ini adalah novel fiksi yang penuh dengan petualangan dan misteri.");

        // Menyimpan buku dalam array
        Buku[] daftarBuku = {buku1, buku2, buku3, buku4, buku5};

        // Menampilkan informasi setiap buku
        for (Buku buku : daftarBuku) {
            System.out.println("Judul: " + buku.judul);
            System.out.println("Kategori: " + buku.kategori.nama);
            System.out.println("Penulis: " + buku.penulis);
            System.out.println("Sinopsis: " + buku.sinopsis);
            System.out.println("Jumlah Kata dalam Sinopsis: " + buku.hitungJumlahKata());
            System.out.println("--------------------");
        }

        // Input harga buku dan jumlah penjualan
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan harga satu buku: ");
        double hargaBuku = scanner.nextDouble();

        // Menghitung royalti 10%
        double royalti1 = buku1.hitungRoyalti(hargaBuku);
        System.out.println("Royalti (10% dari penjualan bulan ini): Rp " + royalti1);

        // Input persentase royalti dari pengguna
        System.out.print("Masukkan persentase royalti yang diinginkan: ");
        double persenRoyalti = scanner.nextDouble();

        // Menghitung royalti berdasarkan persentase pilihan pengguna
        double royalti2 = buku1.hitungRoyalti(hargaBuku, persenRoyalti);
        System.out.println("Royalti dengan persentase " + persenRoyalti + "%: Rp " + royalti2);

        scanner.close();
    }
}

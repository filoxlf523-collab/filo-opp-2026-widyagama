import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class soal20dpk {
    public static void main(String[] args) {
        SiswaManager manager = new SiswaManager();

        try {
            manager.tambah(new Siswa(1, "Andi", 80));
            manager.tambah(new Siswa(2, "Budi", 65));
            manager.tambah(new Siswa(3, "Cici", 90));

            System.out.println("=== DATA SISWA ===");
            manager.tampilSemua();

            System.out.println("\nTambah siswa baru: id=4, nama=Dodi, nilai=75");
            manager.tambah(new Siswa(4, "Dodi", 75));
            System.out.println("Data Dodi berhasil ditambahkan.");

            System.out.println("\nCari id=2: " + manager.cari(2));

            System.out.println("\nHapus id=3...");
            Siswa yangDihapus = manager.cari(3);
            manager.hapus(3);
            System.out.println("Data " + yangDihapus.getNama() + " berhasil dihapus.");

            System.out.println("\n=== DATA SISWA (setelah update) ===");
            manager.tampilSemua();

            manager.simpanKeFile();
            System.out.println("\nData disimpan ke data_siswa.txt");

            SiswaManager managerBaru = new SiswaManager();
            managerBaru.muatDariFile();
            System.out.println("\n=== DATA DIMUAT ULANG DARI FILE ===");
            managerBaru.tampilSemua();

        } catch (SiswaException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error file: " + e.getMessage());
        }
    }
}
class SiswaException extends Exception {
    public SiswaException(String pesan) {
        super(pesan);
    }
}

class Siswa {
    private int id;
    private String nama;
    private int nilai;

    public Siswa(int id, String nama, int nilai) {
        this.id = id;
        this.nama = nama;
        this.nilai = nilai;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public int getNilai() { return nilai; }
    public void setNilai(int nilai) { this.nilai = nilai; }

    @Override
    public String toString() {
        return id + " - " + nama + " - " + nilai;
    }
}

class SiswaManager {
    private ArrayList<Siswa> daftar = new ArrayList<>();
    private static final String NAMA_FILE = "data_siswa.txt";

    public void tambah(Siswa s) throws SiswaException {
        for (Siswa x : daftar) {
            if (x.getId() == s.getId()) {
                throw new SiswaException("ID " + s.getId() + " sudah digunakan.");
            }
        }
        daftar.add(s);
    }

    public void tampilSemua() {
        if (daftar.isEmpty()) {
            System.out.println("(data kosong)");
            return;
        }
        for (Siswa s : daftar) {
            System.out.println(s);
        }
    }

    public Siswa cari(int id) throws SiswaException {
        for (Siswa s : daftar) {
            if (s.getId() == id) {
                return s;
            }
        }
        throw new SiswaException("Siswa dengan ID " + id + " tidak ditemukan.");
    }

    public void hapus(int id) throws SiswaException {
        Siswa s = cari(id);
        daftar.remove(s);
    }

    public void simpanKeFile() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NAMA_FILE))) {
            for (Siswa s : daftar) {
                writer.write(s.getId() + "," + s.getNama() + "," + s.getNilai());
                writer.newLine();
            }
        }
    }

    public void muatDariFile() throws IOException {
        File file = new File(NAMA_FILE);
        if (!file.exists()) {
            return;
        }
        daftar.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String baris;
            while ((baris = reader.readLine()) != null) {
                String[] bagian = baris.split(",");
                if (bagian.length == 3) {
                    int id = Integer.parseInt(bagian[0]);
                    String nama = bagian[1];
                    int nilai = Integer.parseInt(bagian[2]);
                    daftar.add(new Siswa(id, nama, nilai));
                }
            }
        }
    }
}
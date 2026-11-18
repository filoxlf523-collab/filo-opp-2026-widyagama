import java.util.HashMap;
import java.util.Map;

public class BukuTelepon {
    public static void main(String[] args) {
        HashMap<String, String> kontak = new HashMap<>();

        // 1. Tambah 3 kontak
        kontak.put("Budi", "081234567890");
        kontak.put("Siti", "082345678901");
        kontak.put("Andi", "083456789012");

        // 2. Tampilkan semua kontak
        System.out.println("=== Semua Kontak ===");
        for (Map.Entry<String, String> entry : kontak.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // 3. Cari 1 kontak berdasarkan nama
        String cari = "Siti";
        System.out.println("\n=== Cari Kontak: " + cari + " ===");
        if (kontak.containsKey(cari)) {
            System.out.println("Ditemukan! Nomor HP " + cari + ": " + kontak.get(cari));
        } else {
            System.out.println("Kontak tidak ditemukan.");
        }

        // 4. Hapus 1 kontak, lalu tampilkan sisa
        String hapus = "Budi";
        kontak.remove(hapus);
        System.out.println("\n=== Hapus Kontak: " + hapus + " ===");
        System.out.println("Sisa kontak:");
        for (Map.Entry<String, String> entry : kontak.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("Jumlah kontak: " + kontak.size());
    }
}
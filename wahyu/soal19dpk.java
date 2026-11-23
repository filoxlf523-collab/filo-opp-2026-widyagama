import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class soal19dpk {
    public static void main(String[] args) {
        String namaFile = "catatan.txt";

        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(namaFile))) {
            writer.write("Hari ini saya belajar Java.");
            writer.newLine();
            writer.write("Saya sedang mencoba menulis file.");
            writer.newLine();
            writer.write("Semoga programnya berjalan lancar.");
            writer.newLine();
            System.out.println("Berhasil menulis ke " + namaFile);
        } catch (IOException e) {
            System.out.println("Error saat menulis file: " + e.getMessage());
            return;
        }

        
        System.out.println("\n=== Isi " + namaFile + " ===");
        try (BufferedReader reader = new BufferedReader(new FileReader(namaFile))) {
            String baris;
            int nomor = 1;
            while ((baris = reader.readLine()) != null) {
                System.out.println(nomor + ". " + baris);
                nomor++;
            }
        } catch (IOException e) {
            System.out.println("Error saat membaca file: " + e.getMessage());
        }
    }
}
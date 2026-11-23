import java.util.InputMismatchException;
import java.util.Scanner;

public class soal16dpk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Masukkan angka pertama (yang dibagi): ");
            double a = scanner.nextDouble();

            System.out.print("Masukkan angka kedua (pembagi): ");
            double b = scanner.nextDouble();

            if (b == 0) {
                throw new ArithmeticException("Pembagi tidak boleh 0.");
            }

            double hasil = a / b;
            System.out.println("Hasil: " + a + " / " + b + " = " + hasil);

        } catch (InputMismatchException e) {
            System.out.println("Error: Input harus berupa angka.");
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
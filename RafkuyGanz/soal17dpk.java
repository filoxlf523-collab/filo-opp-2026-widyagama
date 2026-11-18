public class soal17dpk {
    public static void main(String[] args) {
        Tabungan tabungan = new Tabungan(100000);

        try {
            tabungan.tarik(30000);
            System.out.println("Penarikan berhasil. Sisa saldo: " + tabungan.getSaldo());

            tabungan.tarik(100000);
            System.out.println("Penarikan berhasil. Sisa saldo: " + tabungan.getSaldo());
        } catch (SaldoTidakCukupException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
class SaldoTidakCukupException extends Exception {
    public SaldoTidakCukupException(String pesan) {
        super(pesan);
    }
}

class Tabungan {
    private int saldo;

    public Tabungan(int saldoAwal) {
        this.saldo = saldoAwal;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public void tarik(int jumlah) throws SaldoTidakCukupException {
        if (jumlah > saldo) {
            throw new SaldoTidakCukupException(
                "Saldo tidak cukup. Saldo: " + saldo + ", penarikan: " + jumlah);
        }
        saldo -= jumlah;
    }
}

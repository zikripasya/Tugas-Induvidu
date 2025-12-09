import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bus bus = new Bus();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("BUS TRANS KOETARADJA");
            System.out.println("1. Naikkan Penumpang");
            System.out.println("2. Turunkan Penumpang");
            System.out.println("3. Lihat Penumpang");
            System.out.println("4. Keluar");
            System.out.print("Pilih: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            if (pilihan == 1) {
                try {
                    System.out.print("Masukkan ID penumpang: ");
                    int id = scanner.nextInt();
                    System.out.print("Masukkan umur penumpang: ");
                    int umur = scanner.nextInt();
                    System.out.print("Apakah penumpang hamil? (true/false): ");
                    boolean hamil = scanner.nextBoolean();

                    Penumpang p;
                    if (umur > 60 || umur < 10 || hamil) {
                        p = new PenumpangPrioritas(id, umur, hamil);
                    } else {
                        p = new PenumpangBiasa(id, umur, hamil);
                    }

                    boolean naik = bus.naikkanPenumpang(p);
                    if (naik) {
                        System.out.println("Penumpang berhasil ditambahkan!");
                    } else {
                        System.out.println("Penumpang gagal ditambahkan (bus penuh).");
                    }
                } catch (SaldoTidakCukupException e) {
                    System.out.println("Gagal tambah penumpang: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Input tidak valid. Silakan coba lagi.");
                    scanner.nextLine();
                }
            } else if (pilihan == 2) {
                System.out.print("Masukkan ID penumpang yang ingin diturunkan: ");
                int idTurun = scanner.nextInt();
                boolean turun = bus.turunkanPenumpang(idTurun);
                if (turun) {
                    System.out.println("Penumpang berhasil diturunkan!");
                } else {
                    System.out.println("Penumpang tidak ditemukan!");
                }
            } else if (pilihan == 3) {
                System.out.println(bus.toString());
            } else if (pilihan == 4) {
                System.out.println("Terima kasih!");
                break;
            } else {
                System.out.println("Pilihan tidak valid.");
            }
            System.out.println();
        }
        scanner.close();
    }
}


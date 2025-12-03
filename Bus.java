import java.util.ArrayList;

// Bus.java
public class Bus {
    public static final int ONGKOSBUS = 2000;
    private int totalPendapatan = 0;

    // batas kapasitas
    public static final int MAX_BIASA = 16;
    public static final int MAX_PRIORITAS = 4;
    public static final int MAX_BERDIRI = 20;

    // menyimpan penumpang saat runtime
    private ArrayList<Penumpang> penumpangBiasa = new ArrayList<>();
    private ArrayList<Penumpang> penumpangPrioritas = new ArrayList<>();
    private ArrayList<Penumpang> penumpangBerdiri = new ArrayList<>();
    public ArrayList<Penumpang> getPenumpangBiasa() { return penumpangBiasa; }

    public ArrayList<Penumpang> getPenumpangPrioritas() { return penumpangPrioritas; }

    public ArrayList<Penumpang> getPenumpangBerdiri() { return penumpangBerdiri; }

    public int getJumlahPenumpangBiasa() { return penumpangBiasa.size(); }

    public int getJumlahPenumpangPrioritas() { return penumpangPrioritas.size(); }

    public int getJumlahPenumpangBerdiri() { return penumpangBerdiri.size(); }

    public int getTotalPendapatan() { return totalPendapatan; }

    private int getTotalPenumpang() {
        return getJumlahPenumpangBiasa() + getJumlahPenumpangPrioritas() + getJumlahPenumpangBerdiri();
    }
    public boolean naikkanPenumpang(Penumpang p) throws SaldoTidakCukupException {
        if (getTotalPenumpang() >= (MAX_BIASA + MAX_PRIORITAS + MAX_BERDIRI)) {
            return false;
        }

        p.kurangiSaldo(ONGKOSBUS);
        totalPendapatan += ONGKOSBUS;

        if (p.isPrioritas()) {
            if (getJumlahPenumpangPrioritas() < MAX_PRIORITAS) {
                penumpangPrioritas.add(p);
                return true;
            } else if (getJumlahPenumpangBiasa() < MAX_BIASA) {
                penumpangBiasa.add(p);
                return true;
            } else if (getJumlahPenumpangBerdiri() < MAX_BERDIRI) {
                penumpangBerdiri.add(p);
                return true;
            }
        } else {
            if (getJumlahPenumpangBiasa() < MAX_BIASA) {
                penumpangBiasa.add(p);
                return true;
            } else if (getJumlahPenumpangBerdiri() < MAX_BERDIRI) {
                penumpangBerdiri.add(p);
                return true;
            }
        }
        return false;
    }
    public boolean turunkanPenumpang(int id) {
        if (cariDanHapusPenumpang(penumpangBiasa, id)) return true;
        if (cariDanHapusPenumpang(penumpangPrioritas, id)) return true;
        if (cariDanHapusPenumpang(penumpangBerdiri, id)) return true;
        return false;
    }

    private boolean cariDanHapusPenumpang(ArrayList<Penumpang> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Batas Kapasitas: Biasa=").append(MAX_BIASA)
          .append(", Prioritas=").append(MAX_PRIORITAS)
          .append(", Berdiri=").append(MAX_BERDIRI).append("\n\n");

        sb.append("Penumpang Biasa (Terisi ").append(getJumlahPenumpangBiasa()).append("/").append(MAX_BIASA).append("):\n");
        for (Penumpang p : penumpangBiasa) {
            sb.append(p.toString()).append("\n");
        }
        sb.append("\nPenumpang Prioritas (Terisi ").append(getJumlahPenumpangPrioritas()).append("/").append(MAX_PRIORITAS).append("):\n");
        for (Penumpang p : penumpangPrioritas) {
            sb.append(p.toString()).append("\n");
        }
        sb.append("\nPenumpang Berdiri (Terisi ").append(getJumlahPenumpangBerdiri()).append("/").append(MAX_BERDIRI).append("):\n");
        for (Penumpang p : penumpangBerdiri) {
            sb.append(p.toString()).append("\n");
        }
        sb.append("\nJumlah Penumpang: ").append(getTotalPenumpang()).append("\n");
        sb.append("Total Pendapatan: ").append(totalPendapatan).append("\n");
        return sb.toString();
    }
}

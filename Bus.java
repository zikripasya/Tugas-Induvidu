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

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


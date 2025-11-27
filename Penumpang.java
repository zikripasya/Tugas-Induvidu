public abstract class Penumpang {
    private int id;
    private int umur;
    private boolean hamil;
    private int saldo;

    public Penumpang(int id, int umur, boolean hamil) {
        this.id = id;
        this.umur = umur;
        this.hamil = hamil;
        this.saldo = 10000;  // saldo awal
    }

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
`   public int getId() {
        return id;
    }

    public int getUmur() {
        return umur;
    }

    public boolean isHamil() {
        return hamil;
    }

    public int getSaldo() {
        return saldo;
    }

    public void tambahSaldo(int saldoBaru) {
        saldo += saldoBaru;
    }
     public void kurangiSaldo(int ongkos) throws SaldoTidakCukupException {
        if (saldo >= ongkos) {
            saldo -= ongkos;
        } else {
            throw new SaldoTidakCukupException("Saldo tidak cukup untuk membayar ongkos bus");
        }
    }
    public abstract boolean isPrioritas();

    @Override
    public String toString() {
        return "ID: " + id + ", Umur: " + umur + ", Hamil: " + hamil + ", Saldo: " + saldo;
    }
}

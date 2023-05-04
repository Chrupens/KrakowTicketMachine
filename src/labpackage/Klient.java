package labpackage;

import java.util.ArrayList;

public class Klient {

    private ArrayList<Pieniadz> portfel;
    private ArrayList<Bilet> bilety;

    //constrctor
    public Klient(Pieniadz saldo, ArrayList<Bilet> bilety) {
        this.bilety = bilety;
        this.portfel = new ArrayList<Pieniadz>();
        this.portfel.add(saldo);
    }

    //getters and setters
    public ArrayList<Pieniadz> getPortfel() {
        return portfel;
    }

    public void setPortfel(Pieniadz nowyPieniadz) {
        this.portfel.add(nowyPieniadz);
    }

    public void removePortfel(int index){
        this.portfel.remove(index);
    }

    public ArrayList<Bilet> getBilety() {
        return bilety;
    }

    public void setBiletyKupujacego(ArrayList<Bilet> bilety) {
        this.bilety = bilety;
    }
}

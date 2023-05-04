package labpackage;

import java.time.LocalDate;

public class Transkacje {
    private LocalDate date;
    private int[] liczbaBiletow;
    private double[] dochod;

    //construcors
    Transkacje() {
        this.date = LocalDate.now();
        this.liczbaBiletow = new int[14];
        this.dochod = new double[14];
    }

    //setters and getters

    public void setLiczbaBiletow(int index) {
        this.liczbaBiletow[index] += 1;
    }

    public void setDochod(int index) {
        this.dochod[index] = liczbaBiletow[index] * Biletomat.cenaBiletow[index];
    }

    public LocalDate getDate() {
        return date;
    }

    public int getLiczbaBiletow(int index) {
        return liczbaBiletow[index];
    }

    public double getDochod(int index) {
        return dochod[index];
    }
}

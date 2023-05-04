package labpackage;

import java.util.ArrayList;

public class Pieniadz {
    protected String nominal;
    protected double wartosc;

    Pieniadz(){
        this.nominal = "";
        this.wartosc = 0;
    }

    public void to_String(){
        System.out.println("Nominal: " + this.nominal);
    }
}

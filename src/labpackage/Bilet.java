package labpackage;

public class Bilet{

    protected String rodzajBiletu;

    protected double cenaBiletu;

    //constructor
    Bilet(){
        rodzajBiletu = "";
        cenaBiletu = 0;
    }

    Bilet(String rodzaj, double cena){
        rodzajBiletu = rodzaj;
        cenaBiletu = cena;
    }

    public void to_String(){

        System.out.println("Rodzaj: " + this.rodzajBiletu + "; Cena: "+ cenaBiletu + " zl");
    }


}

package labpackage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biletomat{
    private String lokalizacja;

    private ArrayList<Integer> wybraneBilety;

    private ArrayList<Transkacje> wszystkieTransakcje;

    private static String[] rodzajeBiletow = new String[]{"ulgowy-20min", "ulgowy-60min","ulgowy-90min", "ulgowy-24h", "ulgowy-48h","ulgowy-72h","ulgowy-7d", "normalny-20min", "normalny-60min","normalny-90min", "normalny-24h", "normalny-48h","normalny-72h","normalny-7d"};

    static double[] cenaBiletow = {2,3,4,8.5,17.5,25,34,4,6,8,17,35,50,56};

    //constructors
    public Biletomat() {
        this.lokalizacja = "";
        this.wybraneBilety = new ArrayList();
        this.wszystkieTransakcje = new ArrayList<Transkacje>();
    }
    public Biletomat(String nowaLokalizacja) {
        this.lokalizacja = nowaLokalizacja;
        this.wybraneBilety = new ArrayList();
        this.wszystkieTransakcje = new ArrayList<Transkacje>();
    }

    //getter and setters
    public String getLokalizacja(){
        return this.lokalizacja;
    }

    public void menuBiletomat(Klient nowyKlient){
        Scanner scanner = new Scanner(System.in);
        boolean stop = false;

        while(!stop){
            System.out.println("Biletomat - " + this.getLokalizacja());
            System.out.println("1. Kup bilety");
            System.out.println("2. Wydruk: wszystkie bilety");
            System.out.println("3. Wydruk: bilety z okreslonej daty");
            System.out.println("4. POKAŻ MOJE BILETY");
            System.out.println("5. POKAŻ MOJ PORTFEL");
            System.out.println("6. Koniec");
            int wybor = scanner.nextInt();

            switch(wybor){
                case 1:
                    this.transakcja(nowyKlient);
                    break;
                case 2:
                    this.to_String();
                    break;
                case 3:
                    System.out.println("Podaj date: ");
                    System.out.println("Rok: ");
                    int rok = scanner.nextInt();
                    System.out.println("Miesiac: ");
                    int miesiac = scanner.nextInt();
                    System.out.println("Dzien: ");
                    int dzien = scanner.nextInt();
                    LocalDate konkretna_data = LocalDate.of(rok,miesiac,dzien);
                    this.wydrukujTransakcje(konkretna_data);
                    break;
                case 4:
                    System.out.println("Moje bilety: ");
                    if(nowyKlient.getBilety() != null)
                    {
                        for(int i=0; i<nowyKlient.getBilety().size(); i++){
                            nowyKlient.getBilety().get(i).to_String();
                        }
                    }
                    else
                        System.out.println("Brak biletow\n");
                    break;
                case 5:
                    System.out.println("Moj portfel: ");
                    for(int i=0; i<nowyKlient.getPortfel().size(); i++){
                        nowyKlient.getPortfel().get(i).to_String();
                    }
                case 6:
                    stop = true;
                    break;
                default:
                    System.out.println("Błąd, podaj poprawny wybor");
            }
        }
    }

    public void transakcja(Klient nowyKlient){
        String wybraneBilety_String;
        Scanner scanner = new Scanner(System.in);
        int doZaplaty = 0;
        double kontoKlienta = 0;
        double reszta = 0;

        System.out.println("Wybierz bilety: ");
        for(int i=0; i<rodzajeBiletow.length; i++) {
            System.out.println(i + ". " + rodzajeBiletow[i] + " (" + cenaBiletow[i] + " zl)");
        }
        wybraneBilety_String = scanner.nextLine();
        String [] wybraneBilety_Array = wybraneBilety_String.split(" ");
        for(int i=0; i<wybraneBilety_Array.length; i++)
        {
            wybraneBilety.add(Integer.parseInt(wybraneBilety_Array[i]));
        }

        for(int i=0; i<wybraneBilety.size(); i++)
        {
            doZaplaty += cenaBiletow[wybraneBilety.get(i)];
        }

        for(int i=0; i<nowyKlient.getPortfel().size(); i++)
        {
            kontoKlienta += nowyKlient.getPortfel().get(i).wartosc;
        }

        if(doZaplaty > kontoKlienta)
            System.out.println("Za mało funduszy!");
        else if(doZaplaty == kontoKlienta)
            nowyKlient.setPortfel(null);
        else
        {
            for(int i=0; i<nowyKlient.getPortfel().size(); i++)
                nowyKlient.getPortfel().remove(i);
            nowyKlient.setBiletyKupujacego(this.wydrukBiletow());
            reszta = kontoKlienta - doZaplaty;
            while( reszta != 0)
            {
                if(reszta >= 500)
                {
                    nowyKlient.setPortfel(new _500_zl());
                    reszta -= 500;
                }
                else if(reszta < 500 && reszta >= 200)
                {
                    nowyKlient.setPortfel(new _200_zl());
                    reszta -= 200;
                }
                else if(reszta < 200 && reszta >= 100)
                {
                    nowyKlient.setPortfel(new _100_zl());
                    reszta -= 100;
                }
                else if(reszta < 100 && reszta >= 50)
                {
                    nowyKlient.setPortfel(new _50_zl());
                    reszta -= 50;
                }
                else if(reszta < 50 && reszta >= 20)
                {
                    nowyKlient.setPortfel(new _20_zl());
                    reszta -= 20;
                }
                else if(reszta < 20 && reszta >= 10)
                {
                    nowyKlient.setPortfel(new _10_zl());
                    reszta -= 10;
                }
                else if(reszta < 10 && reszta >= 5)
                {
                    nowyKlient.setPortfel(new _5_zl());
                    reszta -= 5;
                }
                else if(reszta < 5 && reszta >= 2)
                {
                    nowyKlient.setPortfel(new _2_zl());
                    reszta -= 2;
                }
                else if(reszta < 2 && reszta >= 1)
                {
                    nowyKlient.setPortfel(new _1_zl());
                    reszta -= 1;
                }
                else if(reszta < 1 && reszta >= 0.5)
                {
                    nowyKlient.setPortfel(new _50_gr());
                    reszta -= 0.5;
                }
                else if(reszta < 0.5 && reszta >= 0.2)
                {
                    nowyKlient.setPortfel(new _20_gr());
                    reszta -= 0.2;
                }
                else if(reszta < 0.2 && reszta >= 0.1)
                {
                    nowyKlient.setPortfel(new _10_gr());
                    reszta -= 0.1;
                }
            }
        }
    }

    public ArrayList<Bilet> wydrukBiletow(){
        ArrayList<Bilet> bilety = new ArrayList<Bilet>();
        int sizeTransakcje = 0;
        for(int i=0; i<wybraneBilety.size(); i++)
        {
            bilety.add(new Bilet(rodzajeBiletow[wybraneBilety.get(i)], cenaBiletow[wybraneBilety.get(i)]));
            zapisTransakcji();
            sizeTransakcje = wszystkieTransakcje.size();
            wszystkieTransakcje.get(sizeTransakcje-1).setLiczbaBiletow(wybraneBilety.get(i));
            wszystkieTransakcje.get(sizeTransakcje-1).setDochod(wybraneBilety.get(i));
        }
        return bilety;
    }

    public void zapisTransakcji(){
        LocalDate obecnaData = LocalDate.now();
        int sizeTransakcje = wszystkieTransakcje.size();
        if(sizeTransakcje == 0)
        {
            wszystkieTransakcje.add(new Transkacje());
        }
        else if(wszystkieTransakcje.get(sizeTransakcje-1).getDate().compareTo(obecnaData) != 0)
        {
            wszystkieTransakcje.add(new Transkacje());
        }
    }

    public void to_String(){
        System.out.println("\nWszystkie sprzedane bilety: ");
        for(int i=0; i<wszystkieTransakcje.size(); i++)
        {
            for(int j=0; j<cenaBiletow.length; j++)
            {
                System.out.println(wszystkieTransakcje.get(i).getDate() + " : " + rodzajeBiletow[j] + " : " + wszystkieTransakcje.get(i).getLiczbaBiletow(j) + " : " + wszystkieTransakcje.get(i).getDochod(j));
            }
        }
    }

    public void wydrukujTransakcje(LocalDate date)
    {
        System.out.println("Transakcje z dnia: " + date);
        for(int i=0; i<wszystkieTransakcje.size(); i++)
        {
            if(wszystkieTransakcje.get(i).getDate().compareTo(date) == 0)
            {
                for(int j=0; j<cenaBiletow.length; j++)
                {
                    System.out.println(wszystkieTransakcje.get(i).getDate() + " : " + rodzajeBiletow[j] + " : " + wszystkieTransakcje.get(i).getLiczbaBiletow(j) + " : " + wszystkieTransakcje.get(i).getDochod(j));
                }
            }
        }
    }
}

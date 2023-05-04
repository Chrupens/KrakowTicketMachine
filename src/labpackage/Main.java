package labpackage;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Biletomat b1= new Biletomat("ul. Lipinskiego");
        Klient k1 = new Klient(new _50_zl(), null);

        b1.menuBiletomat(k1);
    }
}
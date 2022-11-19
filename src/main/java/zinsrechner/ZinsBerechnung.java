package zinsrechner;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ZinsBerechnung {
    private List<JahrKapital> kapitalProJahr = new ArrayList<>();
    private Zinsdaten zinsdaten;
    public ZinsBerechnung(Zinsdaten zinsdaten) {
        this.zinsdaten = zinsdaten;
    }

    public List<JahrKapital> berechnen(){
        Integer jahr = zinsdaten.zeit();
        Double anfangsKapital = zinsdaten.kapital();
        Double zinssatz = zinsdaten.zinssatz() / 100;
        Double zinsen;
        Double endKapital;
        for(int i = 1; i <= jahr;i++){
            zinsen = anfangsKapital * zinssatz;
            endKapital = anfangsKapital + zinsen;
            double roundEndKapital = Math.round(endKapital*100.0)/100.0;
            double roundAnfangsKapital = Math.round(anfangsKapital*100.0)/100.0;
            double roundZinsen = Math.round(zinsen*100.0)/100.0;
            JahrKapital jahrKapital = new JahrKapital(i,roundAnfangsKapital,roundZinsen,roundEndKapital);
            kapitalProJahr.add(jahrKapital);
            anfangsKapital = endKapital;
        }
        return kapitalProJahr;
    }

}

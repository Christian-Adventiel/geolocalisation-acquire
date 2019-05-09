package fr.adventiel.innov.geolocalisationacquire.tools;

/**
 * Generate random location somewhere in france
 * Created by Anto on 09/05/19.
 */
public class RandomLocationGenerator {

    /**
     * In order to hide explicit public constructor
     */
    private RandomLocationGenerator(){}

    public static Double randomLatitude() {
        return Math.floor(Math.random()*(48.93693495409401-44.276671273775186+1)+44.276671273775186);
    }

    public static Double randomLongitude() {
        return Math.floor(Math.random()*(5.64697265625-(-0.54931640625)+1)+(-0.54931640625));
    }
}

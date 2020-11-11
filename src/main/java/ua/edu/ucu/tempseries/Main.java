package ua.edu.ucu.tempseries;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        double[] oneElemArr = {-1.0};
        double[] shortArr = {3.0, -5.0, 1.0, 5.0, -0.2, 0.2};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(shortArr);
        double[] res = seriesAnalysis.findTempsGreaterThen(1.0);
        System.out.println(Arrays.toString(res));
    }
}

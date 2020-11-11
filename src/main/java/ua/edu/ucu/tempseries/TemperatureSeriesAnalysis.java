package ua.edu.ucu.tempseries;

import java.util.Arrays;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    static final double MIN_TEMP = -273.0;
    private double[] tempSeries;
    private int tempNumber;
    private int seriesCap;

    public TemperatureSeriesAnalysis() {
        setTemperatureSeries(new double[1]);
        tempNumber = 0;
    }

    public void isValid(double[] temperatureSeries) {
        for (double val : temperatureSeries) {
            if (val < MIN_TEMP) {
                throw new InputMismatchException(
                        "Temperature is less then " + MIN_TEMP + "!");
            }
        }
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        isValid(temperatureSeries);
        setTemperatureSeries(temperatureSeries);
    }

    public void setTemperatureSeries(double[] temperatureSeries) {
        this.tempSeries = Arrays.copyOf(temperatureSeries,
                temperatureSeries.length);
        seriesCap = tempSeries.length;
        tempNumber = seriesCap;
    }

    public void isEmpty() {
        if (tempNumber == 0) {
            throw new IllegalArgumentException("Temperature series is empty!");
        }
    }

    public double average() {
        isEmpty();
        double seriesSum = 0;
        for (double val : tempSeries) {
            seriesSum = seriesSum + val;
        }
        return seriesSum / tempNumber;
    }

    public double deviation() {
        isEmpty();
        if (tempNumber == 1) {
            throw new IllegalArgumentException("You "
                    + "can't find the deviation of the "
                    + "series including just one element!");
        } else {
            double seriesAver = average();
            double seriesDev = 0;
            for (double val : tempSeries) {
                seriesDev = seriesDev + (val - seriesAver) * (val - seriesAver);
            }
            return Math.sqrt(seriesDev / tempNumber);
        }
    }

    public double min() {
        isEmpty();
        if (tempNumber == 1) {
            return tempSeries[0];
        } else {
            double minSeries = Double.MAX_VALUE;
            for (double val : tempSeries) {
                if (val < minSeries) {
                    minSeries = val;
                }
            }
            return minSeries;
        }
    }

    public double max() {
        isEmpty();
        if (tempNumber == 1) {
            return tempSeries[0];
        } else {
            double maxSeries = Double.MIN_VALUE;
            for (double val : tempSeries) {
                if (val > maxSeries) {
                    maxSeries = val;
                }
            }
            return maxSeries;
        }
    }

    public double findTempClosestToZero() {
        return findTempClosestToValue(0.0);
    }

    public double findTempClosestToValue(double tempValue) {
        isEmpty();
        double currDiff = Double.MAX_VALUE;
        double closestTemp = 0.0;
        for (double val : tempSeries) {
            if (Math.abs(val - tempValue) < currDiff) {
                currDiff = Math.abs(val - tempValue);
                closestTemp = val;
            } else if (Math.abs(val - tempValue) == currDiff) {
                closestTemp = Math.max(val, closestTemp);
            }
        }
        return closestTemp;
    }

    public double[] findTempsLessOrGreaterThen(double tempValue, boolean less) {
        isEmpty();
        int amount = 0;
        for (double val : tempSeries) {
            if (val < tempValue && less || val > tempValue && !less) {
                amount = amount + 1;
            }
        }

        double[] tempsLessOrGreaterThanSeries = new double[amount];
        int temporalIndex = 0;
        for (double val : tempSeries) {
            if (val < tempValue && less || val > tempValue && !less) {
                tempsLessOrGreaterThanSeries[temporalIndex] = val;
                temporalIndex = temporalIndex + 1;
            }
        }

        TemperatureSeriesAnalysis result =
                new TemperatureSeriesAnalysis(tempsLessOrGreaterThanSeries);
        return result.tempSeries;
    }

    public double[] findTempsLessThen(double tempValue) {
        return findTempsLessOrGreaterThen(tempValue, true);
    }

    public double[] findTempsGreaterThen(double tempValue) {
        return findTempsLessOrGreaterThen(tempValue, false);
    }

    public TempSummaryStatistics summaryStatistics() {
        return new TempSummaryStatistics(average(), deviation(), min(), max());
    }

    public void addOneTemp(double temp) {
        if (seriesCap == tempNumber) {
            double[] newSeries = new double[2 * (seriesCap + 1)];
            System.arraycopy(tempSeries, 0, newSeries, 0, tempNumber);
            tempSeries = newSeries;
            seriesCap = seriesCap * 2;
        }
        tempSeries[tempNumber] = temp;
        tempNumber = tempNumber + 1;
    }

    public int addTemps(double... temps) {
        isValid(temps);
        for (double val : temps) {
            addOneTemp(val);
        }
        return tempNumber;
    }
}



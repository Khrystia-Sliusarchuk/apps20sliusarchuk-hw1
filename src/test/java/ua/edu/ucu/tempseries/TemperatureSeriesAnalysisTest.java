package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {

    private double[] oneElemArr ;
    private double[] emptyArr;
    private double[] badArr;
    private double[] simpleArr;
    private double[] longArr ;

    @Before
    public void setUp() {
        oneElemArr = new double[] {-1.0};
        emptyArr = new double[]  {};
        badArr = new double[] {-1.0, 34.8, -345.9, 56.8};
        simpleArr = new double[]  {3.0, -5.0, 1.0, 5.0, -0.2, 0.2};
        longArr = new double[] {23.0, 65.8, -162.0, 0.0, 75.0, -23.1, 267.0, -272.9};
    }

    @Test
    public void testIsValidOneElementArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(oneElemArr);

        seriesAnalysis.isValid(oneElemArr);

    }

    @Test
    public void testIsValidEmptyArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(emptyArr);

        seriesAnalysis.isValid(emptyArr);
    }

    @Test
    public void testIsValidSimpleSeries() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(simpleArr);

        seriesAnalysis.isValid(simpleArr);
    }

    @Test(expected = InputMismatchException.class)
    public void testIsValidBadArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(badArr);

        seriesAnalysis.isValid(badArr);
    }

    @Test
    public void testIsEmptyOneElementArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(oneElemArr);

        seriesAnalysis.isEmpty();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsEmptyEmptyArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(emptyArr);

        seriesAnalysis.isEmpty();
    }


    @Test
    public void testAverageWithOneElementArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(oneElemArr);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(emptyArr);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testAverageSimpleSeries() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(simpleArr);
        double expResult = 0.66666666666667;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testAverageLongSeries() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(longArr);
        double expResult = -3.4;

        double actualResult = seriesAnalysis.average();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithOneElementArray(){
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(oneElemArr);

        seriesAnalysis.deviation();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(emptyArr);

        seriesAnalysis.deviation();
    }

    @Test
    public void testDeviationSimpleSeries() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(simpleArr);
        double expResult = 3.093362068832;

        double actualResult = seriesAnalysis.deviation();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testDeviationLongSeries() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(longArr);
        double expResult = 151.21680627496;

        double actualResult = seriesAnalysis.deviation();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMinWithOneElementArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(oneElemArr);
        double expResult = -1.0;

        double actualResult = seriesAnalysis.min();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(emptyArr);

        seriesAnalysis.min();
    }

    @Test
    public void testMinSimpleSeries() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(simpleArr);
        double expResult = -5.0;

        double actualResult = seriesAnalysis.min();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMinLongSeries() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(longArr);
        double expResult = -272.9;

        double actualResult = seriesAnalysis.min();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMaxWithOneElementArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(oneElemArr);
        double expResult = -1.0;

        double actualResult = seriesAnalysis.max();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(emptyArr);

        seriesAnalysis.max();
    }

    @Test
    public void testMaxSimpleSeries() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(simpleArr);
        double expResult = 5.0;

        double actualResult = seriesAnalysis.max();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMaxLongSeries() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(longArr);
        double expResult = 267.0;

        double actualResult = seriesAnalysis.max();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToZeroWithOneElementArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(oneElemArr);
        double expResult = -1.0;

        double actualResult = seriesAnalysis.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToZeroWithEmptyArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(emptyArr);

        seriesAnalysis.findTempClosestToZero();
    }

    @Test
    public void testFindTempClosestToZeroSimpleSeries() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(simpleArr);
        double expResult = 0.2;

        double actualResult = seriesAnalysis.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToZeroLongSeries() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(longArr);
        double expResult = 0.0;

        double actualResult = seriesAnalysis.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToValueWithOneElementArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(oneElemArr);
        double expResult = -1.0;

        double actualResult = seriesAnalysis.findTempClosestToValue(345.0);

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToValueWithEmptyArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(emptyArr);

        seriesAnalysis.findTempClosestToValue(0.0);
    }

    @Test
    public void testFindTempClosestToValueSimpleSeries() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(simpleArr);
        double expResult = 3.0;

        double actualResult = seriesAnalysis.findTempClosestToValue(2.0);

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToValueLongSeries() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(longArr);
        double expResult = 267.0;

        double actualResult = seriesAnalysis.findTempClosestToValue(267.0);

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsLessThenWithOneElementArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(oneElemArr);
        double[] expResult = new double[] {};

        double[] actualResult = seriesAnalysis.findTempsLessThen(-4.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsLessThenWithOneElementArray2() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(oneElemArr);
        double[] expResult = new double[] {};

        double[] actualResult = seriesAnalysis.findTempsLessThen(-1.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsLessThenWithOneElementArray3() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(oneElemArr);
        double[] expResult = {-1.0};

        double[] actualResult = seriesAnalysis.findTempsLessThen(1.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsLessThenWithEmptyArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(emptyArr);

        seriesAnalysis.findTempsLessThen(0.0);
    }

    @Test
    public void testFindTempsLessThenSimpleSeries() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(simpleArr);
        double[] expResult = {-5.0, 1.0, -0.2, 0.2};

        double[] actualResult = seriesAnalysis.findTempsLessThen(2.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsLessThenLongSeries() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(longArr);
        double[] expResult = {23.0, 65.8, -162.0, 0.0, 75.0, -23.1, -272.9};

        double[] actualResult = seriesAnalysis.findTempsLessThen(267.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsGreaterThenWithOneElementArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(oneElemArr);
        double[] expResult = new double[] {};

        double[] actualResult = seriesAnalysis.findTempsGreaterThen(4.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsGreaterThenWithOneElementArray2() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(oneElemArr);
        double[] expResult = new double[] {};

        double[] actualResult = seriesAnalysis.findTempsGreaterThen(-1.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsGreaterThenWithOneElementArray3() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(oneElemArr);
        double[] expResult = {-1.0};

        double[] actualResult = seriesAnalysis.findTempsGreaterThen(-2.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsGreaterThenWithEmptyArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(emptyArr);

        seriesAnalysis.findTempsGreaterThen(0.0);
    }

    @Test
//    що тут має повертати? 1 чи 3?
    public void testFindTempsGreaterThenSimpleSeries() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(simpleArr);
        double[] expResult = {3.0, 5.0};

        double[] actualResult = seriesAnalysis.findTempsGreaterThen(1.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsGreaterThenLongSeries() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(longArr);
        double[] expResult = {23.0, 65.8, 0.0, 75.0, -23.1, 267.0};

        double[] actualResult = seriesAnalysis.findTempsGreaterThen(-162.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testTempSummaryStatistics() {
        TemperatureSeriesAnalysis tempArr2 = new TemperatureSeriesAnalysis(simpleArr);

        TempSummaryStatistics expValue = new TempSummaryStatistics(tempArr2.average(), tempArr2.deviation(),
                tempArr2.min(), tempArr2.max());

        TempSummaryStatistics realValue = tempArr2.summaryStatistics();
        assertEquals(expValue.getClass(), realValue.getClass());
    }

    @Test
    public void testTempSummaryStatistics2() {
        TemperatureSeriesAnalysis tempArr = new TemperatureSeriesAnalysis(simpleArr);
        TempSummaryStatistics tempArr2 = tempArr.summaryStatistics();
                
        double average = tempArr2.getAvgTemp();
        double deviation = tempArr2.getDevTemp();
        double min = tempArr2.getMinTemp();
        double max = tempArr2.getMaxTemp();
        assertEquals(tempArr.average(), average, 0.0001);
        assertEquals(tempArr.deviation(), deviation, 0.00001);
        assertEquals(tempArr.min(), min, 0.001);
        assertEquals(tempArr.max(), max, 0.00001);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSummaryStatistics_EmptySeries() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.summaryStatistics();
    }

    @Test
    public void testTempSummaryStatisticsEqualsEqualHashCodes() {
        TempSummaryStatistics tempOne = new TempSummaryStatistics(34.5, -11.0, 45, 0);
        TempSummaryStatistics tempTwo = new TempSummaryStatistics(34.5, -11.0, 45, 0);
        assertNotEquals(tempOne, tempTwo);
    }

    @Test
    public void testAddTempsToOneElementArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(oneElemArr);
        int expResult = 2;

        int actualResult = seriesAnalysis.addTemps(-1.0);

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testAddTempsToEmptyArray() {
//        проблемка коли роблю через emptyArr
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
        int expResult = 2;

        int actualResult = seriesAnalysis.addTemps(-2.0, 3.0);

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testAddTempsToSimpleSeries() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(simpleArr);
        int expResult = 8;

        int actualResult = seriesAnalysis.addTemps(23.0, 56.8);

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testAddTempsToLongSeries() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(longArr);
        int expResult = 8;

        int actualResult = seriesAnalysis.addTemps();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test (expected = InputMismatchException.class)
    public void testAddTempsWithForbiddenTempInArgument() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(simpleArr);

        seriesAnalysis.addTemps(-345.7);
    }

}
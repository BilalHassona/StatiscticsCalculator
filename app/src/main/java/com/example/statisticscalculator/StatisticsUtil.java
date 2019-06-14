package com.example.statisticscalculator;

import java.util.ArrayList;
import java.util.List;

public class StatisticsUtil {

    private Double average;
    private Double stdDev;

    public static List<Double> TabStringToDoubleList(String[] tabString){

        List<Double> doubleList = new ArrayList<>();

        for(int i = 0; i<=tabString.length-1; i++) {
            try {
                doubleList.add(Double.parseDouble(tabString[i]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return doubleList;
    }

    public static Double round(Double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public static Double calculateAverage(List<Double> list){

        Double sum = 0.00;
        Double avg;

        for (Double number : list) {
            sum += number;
        }
        avg = (sum / list.size());
        return round(avg,3);
    }

    public static Double calculateStdDev(List<Double> list){

        Double mean = calculateAverage(list);
        double xiMinusXThenSquare = 0.00;
        Double variance;

        for(Double a : list){
            xiMinusXThenSquare += (a-mean)*(a-mean);
        }

        variance = xiMinusXThenSquare/(list.size()-1);
        variance = Math.sqrt(variance/list.size());
        variance = round(variance, 3);
        return variance;
    }

    public static Double calculateAverage2(List<Double> xjList, List<Double> njList){

        double sum = 0.00;
        Double avg;
        int index = 0;
        Double n = 0.00;

        for (Double number : njList) {
            sum += (number*xjList.get(index));
            n += number;
            index++;
        }

        avg = (sum / n);
        return round(avg,3);
    }

    public static Double calculateStdDev2(List<Double> xjList, List<Double> njList){

        Double mean = calculateAverage2(xjList, njList);
        double xjMinusXThenSquareTimesNj = 0.00;
        Double variance;
        int index = 0;
        Double sum = 0.00;

        for(Double number : xjList){
            xjMinusXThenSquareTimesNj += ((number-mean)*(number-mean)*njList.get(index));
            index++;
        }

        for(Double number : njList){
            sum += number;
        }

        variance = xjMinusXThenSquareTimesNj/(sum-1);
        variance = Math.sqrt(variance/sum);
        variance = round(variance, 3);
        return variance;
    }

    public static Double calculateMinusMModel1(Double avg, Double uAlpha, Double sigma, int n){
        Double mFinal;
        mFinal = (uAlpha*(sigma/Math.sqrt(n)));
        mFinal = avg - mFinal;
        return round(mFinal, 3);
    }

    public static Double calculatePlusMModel1(Double avg, Double uAlpha, Double sigma, int n){
        Double mFinal;
        mFinal = (uAlpha*(sigma/Math.sqrt(n)));
        mFinal = avg + mFinal;
        return round(mFinal, 3);
    }

    public static Double calculateMinusMModel2(Double avg, Double stdDev, Double tOrUAlpha){
        Double mFinal;
        mFinal = (avg - (tOrUAlpha*stdDev));
        return round(mFinal, 3);
    }

    public static Double calculatePlusMModel2(Double avg, Double stdDev, Double tOrUAlpha){
        Double mFinal;
        mFinal = (avg + (tOrUAlpha*stdDev));
        return round(mFinal, 3);
    }

    public void setAverage(Double avg){
        this.average = avg;
    }

    public Double getAverage(){
        return average;
    }

    public void setStdDev(Double stdDevi){
        this.stdDev = stdDevi;
    }

    public Double getStdDev(){
        return stdDev;
    }

    //    public static DescriptiveStatistics getStatistics(ArrayList<Double> doubleList){
//        DescriptiveStatistics stats = new DescriptiveStatistics();
//
//        for (int i=0; i<=doubleList.size()-1; i++) {
//            stats.addValue(doubleList.get(i));
//        }
//        return stats;
//    }

//        public static String getMean(DescriptiveStatistics stats){
//        return (String.valueOf(round(stats.getMean(), 2)));
//    }

//    public static String getStandardDeviation(DescriptiveStatistics stats){
//        return (String.valueOf(round(stats.getStandardDeviation(), 2)));
//    }

}

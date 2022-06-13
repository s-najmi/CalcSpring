package ir.mapsa.controller;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import java.util.List;

public class CalcMath {
    private List<Integer> list = null;

    public List<Integer> getList() {
        return list;
    }

    public float mean(List<Integer> list){
        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();
        list.forEach(descriptiveStatistics::addValue);
        return (float) descriptiveStatistics.getMean();
    }

    public float variance(List<Integer> list){
        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();
        list.forEach(descriptiveStatistics::addValue);
        return (float) descriptiveStatistics.getVariance();
    }

    public float median(List<Integer> list){
        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();
        list.forEach(descriptiveStatistics::addValue);
        return (float) descriptiveStatistics.getPercentile(50);
    }
}

package ir.mapsa.controller;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CalcService implements ICalc{
    Map<String,Float> resultMap = null;
    public float add(float num1, float num2){
        return num1+num2;
    }

    public float minus(float num1,float num2){
        return num1-num2;
    }

    public float multiply(float num1,float num2){
        return num1*num2;
    }

    public float devide(float num1,float num2) throws Exception{
        if (num2==0)
            throw new Exception("Devide zero is forbidden!");
        return num1/num2;
    }

    public float sqrt(float num1){
        return (float) Math.sqrt(num1);
    }

    public float log10(float num1){
        return (float) Math.log10(num1);
    }

    public Map<String,Float> operation(String operator, float num1, float num2){
        float resultFeild = switch (operator){
            case "+":
                yield add(num1,num2);
            case "-":
                yield minus(num1,num2);
            case "*":
                yield multiply(num1,num2);
            case "/":
                try {
                    yield devide(num1,num2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            case "sqrt":
                yield sqrt(num1);
            case "log":
                yield log10(num1);
            default:
                yield -1;
        };

        resultMap = new HashMap<>();
        resultMap.put(operator, resultFeild);
        return resultMap;
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

    public Map<String, Float> operationApacheMath(List<Integer> numbers){
        resultMap = new HashMap<>();
        resultMap.put("Mean", mean(numbers));
        resultMap.put("median", median(numbers));
        resultMap.put("variance", variance(numbers));
        return resultMap;
    }
}
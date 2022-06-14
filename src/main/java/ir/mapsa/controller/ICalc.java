package ir.mapsa.controller;

import java.util.List;
import java.util.Map;

public interface ICalc {
    public float add(float num1, float num2);
    public float minus(float num1,float num2);
    public float multiply(float num1,float num2);
    public float devide(float num1,float num2) throws Exception;
    public float sqrt(float num1);
    public float log10(float num1);
    public Map<String,Float> operation(String operator, float num1, float num2);
    public float mean(List<Integer> list);
    public float variance(List<Integer> list);
    public float median(List<Integer> list);
    public Map<String,Float> operationApacheMath(List<Integer> list);
}

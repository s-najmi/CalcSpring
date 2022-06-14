package ir.mapsa.controller;

import java.util.List;

public class Calc {
    private String operator;
    private float num1;
    private float num2;
    private List<Integer> list = null;

    public List<Integer> getList() {
        return list;
    }

    public String getOperator() {
        return operator;
    }

    public float getNum1() {
        return num1;
    }

    public float getNum2() {
        return num2;
    }
}

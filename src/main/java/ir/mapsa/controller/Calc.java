package ir.mapsa;

public class Calc {
    private String operator;
    private float num1;
    private float num2;

    public Calc(String operator, float num1, float num2) {
        this.operator = operator;
        this.num1 = num1;
        this.num2 = num2;
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
}

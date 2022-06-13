package ir.mapsa.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CalcController {
    List<Integer> list = null;
    Map<String,Float> resultMap = null;

    @PostMapping("/calcNumber")
    public Map<String,Float> CalcNumber(@RequestBody Calc cal){
        String operator = cal.getOperator();
        float num1 = cal.getNum1();
        float num2 = cal.getNum2();
        float resultFeild = switch (operator){
            case "+":
                yield cal.add(num1,num2);
            case "-":
                yield cal.minus(num1,num2);
            case "*":
                yield cal.multiply(num1,num2);
            case "/":
                try {
                    yield cal.devide(num1,num2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            case "sqrt":
                yield cal.sqrt(num1);
            case "log":
                yield cal.log10(num1);
            default:
                yield -1;
        };
        resultMap = new HashMap<>();
        resultMap.put(operator, resultFeild);
        return resultMap;
    }

    @PostMapping("/calcList")
    public Map<String,Float> Mathapache(@RequestBody CalcMath cal){
        list = cal.getList();
        resultMap = new HashMap<>();
        resultMap.put("Mean", cal.mean(list));
        resultMap.put("median", cal.median(list));
        resultMap.put("variance", cal.variance(list));
        return resultMap;
    }
}

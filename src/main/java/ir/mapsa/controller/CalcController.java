package ir.mapsa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CalcController {
    @Autowired
    ICalc icalc;

    List<Integer> list = null;


    @PostMapping("/calcNumber")
    public Map<String,Float> CalcNumber(@RequestParam(required = true, name = "operator") String operator,
                                        @RequestParam(required = true, name = "num1") float num1,
                                        @RequestParam(required = false, name = "num2",defaultValue = "0F") float num2){
        return icalc.operation(operator, num1, num2);
    }

    @PostMapping("/calcList")
    public Map<String,Float> Mathapache(@RequestParam(required = true, name = "list") List<Integer> numbers){
        return icalc.operationApacheMath(numbers);
    }
}

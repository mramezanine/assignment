package com.mahdi.assignment.paymentplan.conroller;


import com.mahdi.assignment.paymentplan.model.Annuity;
import com.mahdi.assignment.paymentplan.model.LoanCondition;
import com.mahdi.assignment.paymentplan.service.PaymentPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/generate-plan")
public class PaymentPlanController {


    @Autowired
    PaymentPlanService paymentPlanService;

    @PostMapping
    public List<Annuity> calculatePlan(@RequestBody LoanCondition loanCondition){

        return paymentPlanService.calculatePlan(loanCondition);
    }


}

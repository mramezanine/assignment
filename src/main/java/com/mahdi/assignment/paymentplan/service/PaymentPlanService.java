package com.mahdi.assignment.paymentplan.service;

import com.mahdi.assignment.paymentplan.model.Annuity;
import com.mahdi.assignment.paymentplan.model.LoanCondition;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class PaymentPlanService {
    public List<Annuity> calculatePlan(LoanCondition loanCondition){
        List<Annuity> result = Arrays.asList(
                new Annuity("5000.0",
                        new Date(),
                        "5.0",
                        "10.0",
                        "200.0",
                        "10.0") ,
                new Annuity("1000.0",
                        new Date(),
                        "10.0",
                        "2.0",
                        "20.0",
                        "20.0")
        );
        return result;
    }

}
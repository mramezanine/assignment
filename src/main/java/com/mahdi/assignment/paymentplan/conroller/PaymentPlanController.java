package com.mahdi.assignment.paymentplan.conroller;


import com.mahdi.assignment.paymentplan.model.Annuity;
import com.mahdi.assignment.paymentplan.model.LoanCondition;
import com.mahdi.assignment.paymentplan.service.PaymentPlanService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/generate-plan")
public class PaymentPlanController {


    @Autowired
    PaymentPlanService paymentPlanService;

    @ApiOperation(value = "Calculate a plan for loan repayment, based on 'Amount(float type)'," +
            " 'nominal rate(float type)', 'duration(integer type)' and 'start date(string type, like 2019-09-01T00:00:01Z)'. " +
            "For more information please check: https://financeformulas.net/Annuity_Payment_Formula.html ",
            response = Annuity.class,
            responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 422, message = "Input data is not valid. Please check Duration/NominalRate"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    @PostMapping
    public List<Annuity> calculatePlan(@RequestBody LoanCondition loanCondition) throws Exception {
        return paymentPlanService.calculatePlan(loanCondition);
    }


}

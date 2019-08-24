package com.mahdi.assignment.paymentplan.service;

import com.mahdi.assignment.paymentplan.exeptions.DurationNotValidException;
import com.mahdi.assignment.paymentplan.model.Annuity;
import com.mahdi.assignment.paymentplan.model.LoanCondition;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PaymentPlanService {
    final int daysinMonth = 30;
    final int daysInyear=360;


    public List<Annuity> calculatePlan(LoanCondition loanCondition) throws Exception {
        return createPlan(loanCondition);
    }

    private boolean isLoanConditionValid(LoanCondition loanCondition){
        if (loanCondition.getDuration() == 0)
            return false;
        if (loanCondition.getNominalRate() < 0.0009 && loanCondition.getNominalRate() != 0)
            return false;
        return true;
    }
    private float calulateRatePerPeriod(float nominalRate){
        return nominalRate/1200;
    }

    private float calulateAnnuity(float loanAmount,float ratePerPeriod, int duration){
        float result = 0f;
        if (ratePerPeriod == 0){
            result = loanAmount / duration ;
        }
        else{
            result =  (float) ((loanAmount*ratePerPeriod)/(1-Math.pow((1+ratePerPeriod),-duration)));
            result = getRounded2DecFloat(result);
        }

        return result;
    }
    private float calculateInterest (float nominalRate ,float OutstandinPrincipal) {
        return getRounded2DecFloat((nominalRate * daysinMonth * OutstandinPrincipal) /(daysInyear*100));

    }
    private List<Annuity> createPlan(LoanCondition loanCondition) throws Exception {
        List<Annuity> result = new ArrayList<>();
        float brrowerPaymentAmount = 0.0f;
        if (isLoanConditionValid(loanCondition))
        {
                brrowerPaymentAmount =calulateAnnuity(loanCondition.getLoanAmount(),
                                                calulateRatePerPeriod(loanCondition.getNominalRate()),
                                                loanCondition.getDuration()
                                                );

            float remainingOutstandingPrincipal =loanCondition.getLoanAmount();

            for (int i = 0; i < loanCondition.getDuration()  ; i++){

                float interest = calculateInterest(loanCondition.getNominalRate(),remainingOutstandingPrincipal);
                float principal = (brrowerPaymentAmount - interest);
                remainingOutstandingPrincipal = remainingOutstandingPrincipal - principal;

                if (i == loanCondition.getDuration()-1){
                    brrowerPaymentAmount = getRounded2DecFloat(brrowerPaymentAmount + remainingOutstandingPrincipal);
                    remainingOutstandingPrincipal = 0;
                }
                result.add(new Annuity(brrowerPaymentAmount+"",
                        addSpecificMonth(loanCondition.getStartDate(),i),
                        getRounded2DecFloat(remainingOutstandingPrincipal+principal)+"",
                        getRounded2DecFloat(interest)+"",
                        getRounded2DecFloat(principal)+"",
                        getRounded2DecFloat(remainingOutstandingPrincipal)+""
                ));
            }

        }
        else{
            throw new DurationNotValidException("Input data is not valid. Please check Duration/NominalRate");
        }
        return result;
    }

    private float getRounded2DecFloat(float f){
        return Math.round(f*100.0f)/100.0f;
    }

    private String addSpecificMonth(Date refranceDate,int monthToAdd){

        Calendar cal = Calendar.getInstance();
        cal.setTime(refranceDate);
        cal.add(Calendar.MONTH,monthToAdd);

        Date newDate = cal.getTime();
        return convertToDateFormat(newDate);

    }


    private String convertToDateFormat(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T00:00:01Z'");
        return dateFormat.format(date);
    }



}
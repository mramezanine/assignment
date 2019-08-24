package com.mahdi.assignment.paymentplan.model;

import java.util.Date;

public class LoanCondition {

    private String loanAmount;
    private String nominalRate;
    private int duration;
    private Date startDate;

    public LoanCondition() {
    }

    public LoanCondition(String loanAmount, String nominalRate, int duration, Date startDate) {
        this.loanAmount = loanAmount;
        this.nominalRate = nominalRate;
        this.duration = duration;
        this.startDate = startDate;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getNominalRate() {
        return nominalRate;
    }

    public void setNominalRate(String nominalRate) {
        this.nominalRate = nominalRate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString()
    {
        return "LoanCondition [duration = "+duration+"," +
                " nominalRate = "+nominalRate+
                ", loanAmount = "+loanAmount+
                ", startDate = "+startDate+"]";
    }
}

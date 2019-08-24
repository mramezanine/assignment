package com.mahdi.assignment.paymentplan.model;

import java.util.Date;

public class LoanCondition {

    private float loanAmount;
    private float nominalRate;
    private int duration;
    private Date startDate;

    public LoanCondition() {
    }

    public LoanCondition(float loanAmount, float nominalRate, int duration, Date startDate) {
        this.loanAmount = loanAmount;
        this.nominalRate = nominalRate;
        this.duration = duration;
        this.startDate = startDate;
    }

    public float getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(float loanAmount) {
        this.loanAmount = loanAmount;
    }

    public float getNominalRate() {
        return nominalRate;
    }

    public void setNominalRate(float nominalRate) {
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

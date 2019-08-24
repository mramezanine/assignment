package com.mahdi.assignment.paymentplan.model;

import java.util.Date;

public class Annuity {

    private String borrowerPaymentAmount;
    private Date   date;
    private String initialOutstandingPrincipal;
    private String interest;
    private String principal;
    private String remainingOutstandingPrincipal;

    public Annuity() {
    }

    public Annuity(String borrowerPaymentAmount, Date date,
                   String initialOutstandingPrincipal,
                   String interest,
                   String principal,
                   String remainingOutstandingPrincipal) {
        this.borrowerPaymentAmount = borrowerPaymentAmount;
        this.date = date;
        this.initialOutstandingPrincipal = initialOutstandingPrincipal;
        this.interest = interest;
        this.principal = principal;
        this.remainingOutstandingPrincipal = remainingOutstandingPrincipal;
    }

    public String getBorrowerPaymentAmount() {
        return borrowerPaymentAmount;
    }

    public void setBorrowerPaymentAmount(String borrowerPaymentAmount) {
        this.borrowerPaymentAmount = borrowerPaymentAmount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getInitialOutstandingPrincipal() {
        return initialOutstandingPrincipal;
    }

    public void setInitialOutstandingPrincipal(String initialOutstandingPrincipal) {
        this.initialOutstandingPrincipal = initialOutstandingPrincipal;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getRemainingOutstandingPrincipal() {
        return remainingOutstandingPrincipal;
    }

    public void setRemainingOutstandingPrincipal(String remainingOutstandingPrincipal) {
        this.remainingOutstandingPrincipal = remainingOutstandingPrincipal;
    }
    @Override
    public String toString()
    {
        return "Annuity [borrowerPaymentAmount = "+borrowerPaymentAmount+"," +
                " date = "+date+
                ", initialOutstandingPrincipal = "+initialOutstandingPrincipal+
                ", interest = "+interest+
                ", principal = "+principal+
                ", remainingOutstandingPrincipal = "+remainingOutstandingPrincipal+"]";
    }
}
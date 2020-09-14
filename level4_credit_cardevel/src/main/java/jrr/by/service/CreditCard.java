package jrr.by.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreditCard {
    private String cardNumber;
    private int pinCode;
    private double balance;
    private double creditLimit;
    private double theDebtOnTheLoan;
    private static final String INFO_LOG_INVALID_PIN_CODE = "Repeat pin code";
    private static final String INFO_LOG_CANCEL_THE_OPERATION = "The amount owed exceeds the credit limit";

    private Logger logger = LoggerFactory.getLogger(CreditCard.class);

    public CreditCard(String cardNumber, int pinCode) {
        this.cardNumber = cardNumber;
        this.pinCode = pinCode;
        this.balance = 0;
        this.creditLimit = 0;
        this.theDebtOnTheLoan = 0;
    }

    public double withdraw(double amountToWithdraw, double enteredByTheUserPinCode) {

            if (this.pinCode == enteredByTheUserPinCode){
                if(amountToWithdraw <= this.balance) {
                    return this.balance - amountToWithdraw;
                } else {
                    if (this.theDebtOnTheLoan <= this.creditLimit) {
                        logger.info("the amount owed on the loan");
                        return this.balance - amountToWithdraw;
                    } else {
                        logger.info(INFO_LOG_CANCEL_THE_OPERATION);
                    }
                }
            } else {
                logger.info(INFO_LOG_INVALID_PIN_CODE);
            }
            return 0;
        }




   public double deposit(double theAmountCredited, double enteredByTheUserPinCode) {
       if (this.pinCode == enteredByTheUserPinCode) {
           if (this.theDebtOnTheLoan <= theAmountCredited) {
               return theAmountCredited - this.theDebtOnTheLoan;
           } else{
               return  0;
               }
       } else {
           logger.info(INFO_LOG_INVALID_PIN_CODE);
       }
       return theAmountCredited;
   }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getTheDebtOnTheLoan() {
        return theDebtOnTheLoan;
    }

    public void setTheDebtOnTheLoan(double theDebtOnTheLoan) {
        this.theDebtOnTheLoan = theDebtOnTheLoan;
    }
}


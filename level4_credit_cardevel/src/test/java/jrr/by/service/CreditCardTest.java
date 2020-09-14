package jrr.by.service;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreditCardTest {
    CreditCard creditCard;

    @Before
    public void setUp() {
        creditCard = new CreditCard("9999_9999_9999_9999x", 1111);
    }

    @Test
    public void depositReturnFalsePincode() {
        creditCard.deposit(6000, 9999);

        boolean expected = false;
        boolean actual = creditCard.getPinCode() == 8888;

        assertEquals(expected, actual);
    }

    @Test
    public void depositReturnTruePincode() {
        creditCard.deposit(600, 1111);

        boolean expected = true;
        boolean actual = creditCard.getPinCode() == 1111;

        assertEquals(expected, actual);
    }

    @Test
    public void depositIfTheDebtOnTheLoanMoreThenAmountCredited() {
        creditCard.deposit(2000.0, 1111);
        creditCard.setTheDebtOnTheLoan(3000);

        double expected = 0;
        double actual = creditCard.deposit(2000.0, 1111);

        assertEquals(expected, actual, 0.009999999);
    }

    @Test
    public void depositThenAmountCreditedMoreThenTheDebtOnTheLoan() {
        creditCard.setTheDebtOnTheLoan(1000.0);
        creditCard.deposit(3000.0, 1111);

        double expected = 2000.0;
        double actual = creditCard.deposit(3000.0, 1111);

        assertEquals(expected, actual, 0.009999999);
    }

    @Test
    public void depositIfTheDebtOnTheLoanIsZero() {
        creditCard.deposit(4000.00, 1111);
        creditCard.setTheDebtOnTheLoan(0);


        double expected = 4000;
        double actual = creditCard.deposit(4000.00, 1111);

        assertEquals(expected, actual, 0.009999999);
    }


    @Test
    public void withdrawReturnPincode() {
        creditCard.withdraw(3000, 1111);

        int expected = 1111;
        int actual = creditCard.getPinCode();

        assertEquals(expected, actual);
    }

    @Test
    public void withdrawReturnFalse() {
        creditCard.withdraw(3000, 1454);

        boolean expected = false;
        boolean actual = creditCard.getPinCode() == 1454;

        assertEquals(expected, actual);
    }

    @Test
    public void withdrawIfBalanceMoreThanAmountToWithdraw() {
        creditCard.setBalance(4000);
        creditCard.withdraw(3000, 1111);

        double expected = 1000;
        double actual = creditCard.withdraw(3000, 1111);

        assertEquals(expected, actual, 0.009999999);

    }

    @Test
    public void withdrawIfBalanceMoreIsEqualToAmountToWithdraw() {
        creditCard.setBalance(4000);
        creditCard.withdraw(4000, 1111);

        double expected = 0;
        double actual = creditCard.withdraw(4000, 1111);

        assertEquals(expected, actual, 0.009999999);

    }

    //amountToWithdraw > this.balance
    @Test
    public void withdrawIfAmountToWithdrawMoreThenBalance() {
        creditCard.setBalance(1000);
        creditCard.withdraw(2000, 1111);


        double expected = -1000;
        double actual = creditCard.withdraw(2000, 1111);

        assertEquals(expected, actual, 0.009999999);
    }


    @Test
    public void withdrawLimitIsExceeded() {
        creditCard.setCreditLimit(1000);
        creditCard.setTheDebtOnTheLoan(1500);
        creditCard.setBalance(1000);
        creditCard.withdraw(5000, 1111);

        double expected = 0;
        double actual = creditCard.withdraw(5000, 1111);

        assertEquals(expected, actual, 0.009999999);
    }
}




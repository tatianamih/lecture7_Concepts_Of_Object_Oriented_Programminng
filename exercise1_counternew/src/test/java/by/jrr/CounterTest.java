package by.jrr;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CounterTest {

    @Test
    public void setStepReturnNumber() {
        Counter counter = new Counter();
        counter.setStep(3);

        int expected = 3;
        int actual = counter.getStep();
        assertEquals(expected, actual);
    }

    @Test
    public void setStepReturnMinNumber() {
        Counter counter = new Counter();
        counter.setStep(1);

        int expected = 1;
        int actual = counter.getStep();
        assertEquals(expected, actual);
    }
    @Test
    public void setStepReturnMaxNumber() {
        Counter counter = new Counter();
        counter.setStep(10);

        int expected = 10;
        int actual = counter.getStep();
        assertEquals(expected, actual);
    }

    @Test
    public void setStepReturnNothing() {
        Counter counter = new Counter();
        counter.setStep(11);

        int expected = 0;
        int actual = counter.getStep();
        assertEquals(expected, actual);
    }
    @Test
    public void setStepReturnLoggerMessage() {
        Counter counter = new Counter();
        counter.setStep(20);

        int expected = 0;
        int actual = counter.getStep();

        assertEquals(expected, actual);
    }

    @Test
    public void setValueReturnNumber() {
        Counter counter = new Counter();
        counter.setValue(88);

        int expected = 88;
        int actual = counter.getValue();
        assertEquals(expected, actual);
    }

    @Test
    public void setValueReturnNothing() {
        Counter counter = new Counter();
        counter.setValue(200);

        int expected = 0;
        int actual = counter.getValue();

        assertEquals(expected, actual);
    }
    @Test
      public void setValueReturnLoggerMessage() {
        Counter counter = new Counter();
        counter.setValue(-200);

        int expected = 0;
        int actual = counter.getValue();

        assertEquals(expected, actual);
        }
    @Test
    public void incrementReturnTrue() {
        Counter counter = new Counter();
        counter.setValue(80);
        counter.setStep(10);
        counter.increment();

        int expected = 90;
        int actual = counter.getValue();

        assertEquals(expected, actual);
    }

    @Test
    public void incrementMaxCounter() {
        Counter counter = new Counter();
        counter.setValue(85);
        counter.setStep(10);
        counter.increment();

        int expected = 95;
        int actual = counter.getValue();

        assertEquals(expected, actual);
    }

    @Test
    public void decrementReturnTrue(){
        Counter counter = new Counter();
        counter.setValue(20);
        counter.setStep(4);
        counter.decrement();
        counter.decrement();
        counter.decrement();
        counter.decrement();
        counter.decrement();

        int expected = 0;
        int actual = counter.getValue();

        assertEquals(expected, actual);
    }

    @Test
    public void decrementMin() {
        Counter counter = new Counter();
        counter.setValue(9);
        counter.setStep(10);
        counter.decrement();

        int expected = 9;
        int actual = counter.getValue();

        assertEquals(expected, actual);
    }

    @Test
    public void reset() {
        Counter counter = new Counter();
        counter.setStep(1);
        counter.setValue(10);
        counter.reset();

        boolean expected = true;
        boolean actual = (counter.getStep() == 1 && counter.getValue() == 0);

        assertEquals(expected,actual);
    }
}
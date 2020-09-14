package by.jrr;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Counter {
    private Logger logger = LoggerFactory.getLogger(Counter.class);
    private int value;
    private int step;

    private static final int MAX_VALUE = 100;
    private static final int MIN_VALUE = 0;
    private static final int MAX_STEP = 10;
    private static final int MIN_STEP = 1;

    public Counter() {
        this.value = 0;
        this.value = 1;
    }

    public int getValue() {
        return value;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        if (step >= MIN_STEP && step <= MAX_STEP) {
            this.step = step;
        } else {
            logger.info(("The step must be in the range from 1 to 10"));
        }
    }

    public void setValue(int value) {
        if (value >= MIN_VALUE && value <= MAX_VALUE) {
            this.value = value;
        } else {
            logger.info("The value must be in the range from 0 to 100");
            this.value = 0;
        }
    }

    public void increment() {
        if ((getValue() + getStep()) > MAX_VALUE) {
            logger.info("The maximum limit of the counter");
        } else {
            this.value = getValue() + getStep();
        }
    }

    public void decrement() {
        if ((getValue() - getStep()) < MIN_VALUE) {
            logger.info("the minimum limit of the counter");
        } else {
            this.value = getValue() - getStep();
        }
    }

    public void reset(){
        this.value = 0;
        this.step = 1;
    }
}











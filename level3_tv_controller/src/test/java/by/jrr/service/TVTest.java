package by.jrr.service;


import by.jrr.bean.TV;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TVTest {
    TV tv;
    TVController tvController;

    @Before
    public void setUp(){
        tv = new TV(4,35,"Gomel news");
        tvController = new TVController();
    }

    @Test
    public void getTvReturnTv() {
        tvController.setTv(tv);

        TV expected = tv;
        TV actual = tvController.getTv();

        assertEquals(expected,actual);
    }

    @Test
    public void getTvReturnTrue() {
        tvController.setTv(tv);

        boolean expected = true;
        boolean actual = tvController.getTv().equals(tv);

        assertEquals(expected,actual);
    }


    @Test
    public void turnOnTv() {
        tvController.setTv(tv);
        tvController.turnOnTv();

        boolean expected = true;
        boolean actual = tv.isSwitchTV();

        assertEquals(expected,actual);
    }

    @Test
    public void turnOffTv() {
        tvController.setTv(tv);
        tvController.turnOnTv();
        tvController.turnOffTv();

        boolean expected = false;
        boolean actual = tv.isSwitchTV();

        assertEquals(expected,actual);
    }

    @Test
    public void turnUpVolume() {
        tvController.setTv(tv);
        tvController.turnOnTv();
        tvController.turnUpVolume();
        tvController.turnUpVolume();
        tvController.turnUpVolume();


        int expected = 38;
        int actual = tv.getCurrentVolume();

        assertEquals(expected,actual);
    }

    @Test
    public void turnDownVolume() {
        tvController.setTv(tv);
        tvController.turnOnTv();
        tvController.turnDownVolume();
        tvController.turnDownVolume();
        tvController.turnOffTv();


        int expected = 33;
        int actual = tv.getCurrentVolume();

        assertEquals(expected,actual);
    }

    @Test
    public void switchChannelIncrease() {
        tvController.setTv(tv);
        tvController.turnOnTv();
        tvController.switchChannelIncrease();
        tvController.switchChannelIncrease();
        tvController.switchChannelIncrease();

        int expected = 7;
        int actual = tv.getCurrentChannel();

        assertEquals(expected,actual);
    }

    @Test
    public void switchChannelDecrease() {
        tvController.setTv(tv);
        tvController.turnOnTv();
        tv.setCurrentChannel(20);
        tvController.switchChannelDecrease();
        tvController.switchChannelDecrease();
        tvController.switchChannelDecrease();
        tvController.switchChannelDecrease();
        tvController.switchChannelDecrease();
        tvController.switchChannelDecrease();
        tvController.switchChannelDecrease();
        tvController.switchChannelDecrease();
        tvController.switchChannelDecrease();
        tvController.switchChannelDecrease();


        int expected = 10;
        int actual = tv.getCurrentChannel();

        assertEquals(expected,actual);
    }
}
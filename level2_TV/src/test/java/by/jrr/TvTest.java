package by.jrr;

import org.junit.Before;
import org.junit.Test;


import static org.junit.jupiter.api.Assertions.*;

public class TvTest {
        TV tv;

        @Before
        public void setUp(){
            tv = new TV(1,10,"Радыё Свабода");
        }

        @Test
        public void testEqualsReturnFalse() {
            TV tv2 = new TV(1,30, "БЕЛСАТ");

            boolean expected = false;
            boolean actual = tv2.equals(tv);

            assertEquals(expected,actual);
        }

        @Test
        public void testEqualsReturnTrue() {
            TV tv2 = new TV(1,10,"Радыё Свабода");

            boolean expected = true;
            boolean actual = tv2.equals(tv);

            assertEquals(expected,actual);
        }

        @Test
        public void testHashCode() {
            int expected = 848800781;
            int actual = tv.hashCode();

            assertEquals(expected,actual);
        }

        @Test
        public void testToString() {
            String expected = "Tv{currentChannel=1, currentVolume=10, company='Радыё Свабода', switchTV=false}";
            String actual = tv.toString();

            assertEquals(expected,actual);
        }

        @Test
        public void switchChannelIncreaseReturnNumber() {
            tv.setSwitchTV(true);
            tv.switchChannelIncrease();

            int expected = 2;
            int actual = tv.getCurrentChannel();

            assertEquals(expected,actual);
        }

        @Test
        public void switchChannelIncreaseReturnLog() {
            tv.setSwitchTV(false);

            int expected = 1;
            int actual = tv.getCurrentChannel();

            assertEquals(expected,actual);
        }

        @Test
        public void switchChannelDecreaseReturnNumberChannel() {
            tv.setSwitchTV(true);
            tv.setCurrentChannel(5);
            tv.switchChannelDecrease();
            tv.switchChannelDecrease();
            tv.switchChannelDecrease();

            int expected = 2;
            int actual = tv.getCurrentChannel();

            assertEquals(expected,actual);
        }

        @Test
        public void switchChannelDecreaseReturnLog() {//add
            tv.setSwitchTV(false);
            tv.setCurrentChannel(1);

            int expected = 1;
            int actual = tv.getCurrentChannel();

            assertEquals(expected,actual);
        }

        @Test
        public void turnUpVolumeReturnNumber() {
            tv.setSwitchTV(true);
            tv.turnUpVolume();
            tv.turnUpVolume();
            tv.turnUpVolume();
            tv.turnUpVolume();

            int expected = 14;
            int actual = tv.getCurrentVolume();

            assertEquals(expected,actual);
        }



        @Test
        public void turnUpVolumeReturnLog() {
            tv.setSwitchTV(false);

            int expected = 10;
            int actual = tv.getCurrentVolume();

            assertEquals(expected,actual);
        }


        @Test
        public void turnDownVolumeReturnNumber() {
            tv.setSwitchTV(true);
            tv.setCurrentVolume(55);
            tv.turnDownVolume();
            tv.turnDownVolume();
            tv.turnDownVolume();
            tv.turnDownVolume();
            tv.turnDownVolume();

            int expected = 50;
            int actual = tv.getCurrentVolume();

            assertEquals(expected,actual);
        }
    @Test
    public void turnDownVolumeReturnLog() {
        tv.setSwitchTV(false);
        tv.setCurrentVolume(55);

        int expected = 55;
        int actual = tv.getCurrentVolume();

        assertEquals(expected,actual);
    }


        @Test
        public void setCompanyReturnTrue() {
            tv.setCompany("1+1");

            String expected = "1+1";
            String actual = tv.getCompany();

            assertEquals(expected,actual);
        }
    }




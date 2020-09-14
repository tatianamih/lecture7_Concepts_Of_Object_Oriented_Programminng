package by.jrr.service;


import by.jrr.bean.TV;

public class TVController {

   private TV tv;

    public TV getTv() {
        return tv;
    }

    public void setTv(TV tv) {

        this.tv = tv;
    }

    public void turnOnTv()
    {
        tv.setSwitchTV(true);
    }

    public void turnOffTv(){
        tv.setSwitchTV(false);
    }

    public void turnUpVolume(){

        tv.turnUpVolume();
    }
    public void turnDownVolume(){
        tv.turnDownVolume();
    }
    public void switchChannelIncrease(){

        tv.switchChannelIncrease();
    }
    public void switchChannelDecrease(){
        tv.switchChannelDecrease();
    }
}


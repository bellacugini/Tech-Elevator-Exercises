package com.techelevator;

public class Television {

    private boolean isOn = false;
    private int currentChannel = 3;
    private int currentVolume = 2;

    public boolean isOn() {
        return isOn;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void turnOff(){
        this.isOn = false;
    }

    public void turnOn(){
        this.isOn = true;
    }

    public void changeChannel(int newChannel){
        if(isOn == true){
            if(newChannel >= 3 && newChannel <= 18){
                this.currentChannel = newChannel;
            }
        }
    }

    public void channelUp(){
        if(isOn == true){
            if(currentChannel < 18){
                this.currentChannel += 1;
            }
            else{
                this.currentChannel = 3;
            }
        }
    }

    public void channelDown(){
        if(isOn == true){
            if(currentChannel > 3){
                this.currentChannel -= 1;
            }
            else {
                this.currentChannel = 18;
            }
        }
    }

    public void raiseVolume(){
        if(isOn == true){
            if(currentVolume < 10){
                this.currentVolume += 1;
            }
            else {
                this.currentVolume = currentVolume;
            }
        }
    }

    public void lowerVolume(){
        if(isOn == true){
            if(currentVolume > 0){
                this.currentVolume -= 1;
            }
            else {
                this.currentVolume = currentVolume;
            }
        }
    }
}

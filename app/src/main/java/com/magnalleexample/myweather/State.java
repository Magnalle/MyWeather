package com.magnalleexample.myweather;

public class State {
    private int number;

    public int getNumber() {
        return number;
    }

    static private State data;
    private State(){}
    public static State getInstance(){
        if(data == null) {
            data = new State();
            data.number = (int)(Math.random() * 100);
        }
        return data;
    }
}

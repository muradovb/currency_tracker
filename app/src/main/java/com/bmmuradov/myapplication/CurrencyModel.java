package com.bmmuradov.myapplication;

public class CurrencyModel {


    //properties
    private String name;
    private double rate;

    //constructors
    public CurrencyModel(){
        name="";
        rate=0;
    }

    public CurrencyModel(String name, double rate) {
        this.name = name;
        this.rate=rate;
    }

    //methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}

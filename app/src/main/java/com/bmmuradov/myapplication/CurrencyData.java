package com.bmmuradov.myapplication;

import java.util.ArrayList;
import java.util.List;

public class CurrencyData {

    /**
     * success : true
     * timestamp : 1519296206
     * base : USD
     * date : 2019-07-01
     * rates : {"GBP":0.72007,"JPY":107.346001,"EUR":0.813399}
     */

    private boolean success;
    private int timestamp;
    private String base;
    private String date;
    private RatesBean rates;

    public ArrayList<CurrencyModel> getCurrList(){
        ArrayList<CurrencyModel> currList=new ArrayList<>();
        currList.add(new CurrencyModel("GBP", rates.getGBP()));
        currList.add(new CurrencyModel("JPY", rates.getJPY()));
        currList.add(new CurrencyModel("EUR", rates.getEUR()));
        return currList;
    }
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public RatesBean getRates() {
        return rates;
    }

    public void setRates(RatesBean rates) {
        this.rates = rates;
    }

    public static class RatesBean {
        /**
         * GBP : 0.72007
         * JPY : 107.346001
         * EUR : 0.813399
         */

        private double GBP;
        private double JPY;
        private double EUR;

        public double getGBP() {
            return GBP;
        }

        public void setGBP(double GBP) {
            this.GBP = GBP;
        }

        public double getJPY() {
            return JPY;
        }

        public void setJPY(double JPY) {
            this.JPY = JPY;
        }

        public double getEUR() {
            return EUR;
        }

        public void setEUR(double EUR) {
            this.EUR = EUR;
        }
    }
}

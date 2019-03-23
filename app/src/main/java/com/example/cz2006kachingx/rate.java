package com.example.cz2006kachingx;

public class rate {
    // Currency_1 = Singapore Dollar
    // Currency_2 = US Dollar
    // Currency_3 = Malaysian Ringgit
    // Currency_4 = Australian Dollar
    // Currency_5 = Euro
    // Currency_6 = British Pound
    public String[] rates;

    public rate(String rateStr) {
        rates = rateStr.split(",");
    }

    public String[] getRates(){
        return rates;
    }

    public double calculateRate(double base_currency, double target_currency, double value) {
        double result;
        result = (target_currency/base_currency)* value;
        return Math.round(result*100)/100;
    }
}

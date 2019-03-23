package com.example.cz2006kachingx;

public class rate {
    // Currency_1 = Singapore Dollar
    // Currency_2 = US Dollar
    // Currency_3 = Malaysian Ringgit
    // Currency_4 = Australian Dollar
    // Currency_5 = Euro
    // Currency_6 = British Pound
    double Currency_1 = -1;
    double Currency_2 = -1;
    double Currency_3 = -1;
    double Currency_4 = -1;
    double Currency_5 = -1;
    double Currency_6 = -1;

    public rate(String rateStr) {
        String[] rates = rateStr.split(",");
        Currency_1 = Double.parseDouble(rates[0]);
        Currency_2 = Double.parseDouble(rates[1]);
        Currency_3 = Double.parseDouble(rates[2]);
        Currency_4 = Double.parseDouble(rates[3]);
        Currency_5 = Double.parseDouble(rates[4]);
        Currency_6 = Double.parseDouble(rates[5]);
    }

    public double calculateRate(double base_currency, double target_currency, double value) {
        double result;
        result = (target_currency/base_currency)* value;
        return Math.round(result*100)/100;
    }
}

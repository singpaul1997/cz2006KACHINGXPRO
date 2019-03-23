package com.example.cz2006kachingx;

public class CurrencyExchange {
    int exchange_code = -1;
    String exchange_name = "";
    String exchange_address = "";
    String exchange_rate = "";
    String exchange_contact = "";

    public CurrencyExchange(){}

    public void setcode(int code){
        exchange_code = code;
    }
    public void setname(String name){
        exchange_name = name;
    }
    public void setaddr(String address){
        exchange_address = address;
    }
    public void setrate(String rate){
        exchange_rate = rate;
    }
    public void setcontact(String contact){
        exchange_contact = contact;
    }
}

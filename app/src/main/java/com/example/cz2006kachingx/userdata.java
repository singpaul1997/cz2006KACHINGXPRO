package com.example.cz2006kachingx;

public class userdata {
    String favorite_1;
    String favorite_2;
    String favorite_3;

    public userdata(){
        favorite_1 = null;
        favorite_2 = null;
        favorite_3 = null;

    }
    public userdata(String fav1, String fav2, String fav3){
        favorite_1 = fav1;
        favorite_2 = fav2;
        favorite_3 = fav3;
    }
    public void setfav1(String fav1){
        favorite_1 = fav1;
    }
    public void setfav2(String fav2){
        favorite_2 = fav2;
    }
    public void setfav3(String fav3){
        favorite_3 = fav3;
    }
    public String getfav1(){
        return favorite_1;
    }
    public String getfav2(){
        return favorite_2;
    }
    public String getfav3(){
        return favorite_3;
    }

}

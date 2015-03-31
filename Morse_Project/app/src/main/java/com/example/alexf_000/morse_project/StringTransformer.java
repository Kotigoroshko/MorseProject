package com.example.alexf_000.morse_project;

/**
 * Created by alexf_000 on 31.03.2015.
 */
public class StringTransformer {

    private String str;


    private String morse_string;

    public StringTransformer(String str){
        this.str = str;
        morse_string = strToMorse(str);
    }


    public String getMorse_string() {
        return morse_string;
    }

    private String strToMorse(String str){

        String result = "";

        char[] string = str.toLowerCase().toCharArray();

        for(int i = 0; i<str.length(); i++){
            result += charToMorse(string[i]);
        }

        return result;
    }

    private String charToMorse(char c) {

        String res = "";

        if(c == 'a')
            res = ".-";
        if(c == 'b')
            res = "-...";
        if(c == 'c')
            res = "-.-.";
        if(c == 'd')
            res = "-..";
        if(c == 'e')
            res = ".";
        if(c == 'f')
            res = "..-.";
        if(c == 'g')
            res = "--.";
        if(c == 'h')
            res = "....";
        if(c == 'i')
            res = "..";
        if(c == 'j')
            res = ".---";
        if(c == 'k')
            res = "-.-";
        if(c == 'l')
            res = ".-..";
        if(c == 'm')
            res = "--";
        if(c == 'n')
            res = "-.";
        if(c == 'o')
            res = "---";
        if(c == 'p')
            res = ".--.";
        if(c == 'q')
            res = "--.-";
        if(c == 'r')
            res = ".-.";
        if(c == 's')
            res = "...";
        if(c == 't')
            res = "-";
        if(c == 'u')
            res = "..-";
        if(c == 'v')
            res = "...-";
        if(c == 'w')
            res = ".--";
        if(c == 'x')
            res = "-..-";
        if(c == 'y')
            res = "-.--";
        if(c == 'z')
            res = "--..";

        res += "|";


        return res;
    }

}

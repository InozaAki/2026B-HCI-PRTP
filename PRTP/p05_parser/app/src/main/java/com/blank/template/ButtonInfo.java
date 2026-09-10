package com.blank.template;

import java.util.HashMap;

public final class ButtonInfo {

    ButtonInfo() {}

    public static final HashMap<Integer, String> buttonData = new HashMap<>(){
        {
            put(R.id.ac_button, "AC");
            put(R.id.delete_button, "DEL");
            put(R.id.parenthesis_button, "()");
            put(R.id.percent_button, "%");
            put(R.id.divided_by, "/");
            put(R.id.seven_button, "7");
            put(R.id.eight_button, "8");
            put(R.id.nine_button, "9");
            put(R.id.times_button, "*");
            put(R.id.four_button, "4");
            put(R.id.five_button, "5");
            put(R.id.six_button, "6");
            put(R.id.minus_button, "-");
            put(R.id.one_button, "1");
            put(R.id.two_button, "2");
            put(R.id.three_button, "3");
            put(R.id.plus_button, "+");
            put(R.id.zero_button, "0");
            put(R.id.decimal_button, ".");
            put(R.id.equals_button, "=");
        }
    };
}
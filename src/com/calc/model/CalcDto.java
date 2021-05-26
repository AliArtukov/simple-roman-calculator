package com.calc.model;

/*
Created by Ali Artukov
*/

public class CalcDto {

    public String left;
    public String right;
    public String operator;

    @Override
    public String toString() {
        return "Para{" +
                "left='" + left + '\'' +
                ", right='" + right + '\'' +
                ", operator='" + operator + '\'' +
                '}';
    }

}

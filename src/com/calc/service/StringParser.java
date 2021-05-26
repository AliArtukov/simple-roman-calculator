package com.calc.service;

import com.calc.model.CalcDto;

/*
Created by Ali Artukov
*/
public class StringParser {

    public boolean isNumeric(CalcDto calcDto){
        try {
            Integer.parseInt(calcDto.left);
            Integer.parseInt(calcDto.right);
            return true;
        }catch (NumberFormatException n){
            return false;
        }
    }

    public CalcDto getCalcDto(String row){
        String operator = "";
        if (row.contains("*"))
            operator = "*";
        if (row.contains("/"))
            operator = "/";
        if (row.contains("+"))
            operator = "+";
        if (row.contains("-"))
            operator = "-";

        if (operator.isEmpty()){
            return new CalcDto();
        }else {
            CalcDto calcDto = new CalcDto();
            calcDto.left = row.substring(0, row.indexOf(operator));
            calcDto.right = row.substring(row.indexOf(operator) + 1);
            calcDto.operator = operator;
            return calcDto;
        }
    }

}

package com.calc;

import com.calc.model.CalcDto;
import com.calc.service.RomanNumeralsConverter;
import com.calc.service.StringParser;

import java.util.Scanner;

/*
Created by Ali Artukov
*/
public class Main {

    public static void main(String[] args) {

        RomanNumeralsConverter converter = new RomanNumeralsConverter();
        StringParser stringParser = new StringParser();
        CalcDto calcDto;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter operation (example: VI+XII or 10-9), 0=stop:");
            String operation = scanner.nextLine();
            if (operation.equals("0"))
                return;

            calcDto = stringParser.getCalcDto(operation);
            if (calcDto.left == null) {
                System.err.println("We do not accept such an operator!!!");
                return;
            }
            boolean numeric = stringParser.isNumeric(calcDto);

            Integer left;
            Integer right;
            int result = 0;

            if (numeric) {
                left = Integer.parseInt(calcDto.left);
                right = Integer.parseInt(calcDto.right);
                if (!(left > 0 && left <= 10 && right > 0 && right <= 10)) {
                    System.err.println("We do not accept such an operand!!!");
                    return;
                }
            } else {
                left = converter.convertRomanNumeralsToInteger(calcDto.left);
                right = converter.convertRomanNumeralsToInteger(calcDto.right);
                if (!(left > 0 && left <= 10 && right > 0 && right <= 10)) {
                    System.err.println("We do not accept such an operand!!!");
                    return;
                }
            }

            switch (calcDto.operator) {
                case "*":
                    result = left * right;
                    break;
                case "/":
                    result = left / right;
                    break;
                case "+":
                    result = left + right;
                    break;
                case "-":
                    result = left - right;
                    break;
                default:
                    System.err.println("We do not accept such an operator!!!");
            }
            System.out.println(numeric ? result : converter.convertIntegerToRomanNumerals(result));
        }
    }

}

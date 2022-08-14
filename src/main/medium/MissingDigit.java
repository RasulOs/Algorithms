package main.medium;/*
Missing Digit

Have the function main.medium.MissingDigit(str) take the str parameter, which will be a simple mathematical formula with
three numbers, a single operator (+, -, *, or /) and an equal sign (=) and return the digit that completes
the equation. In one of the numbers in the equation, there will be an x character, and your program should
determine what digit is missing. For example, if str is "3x + 12 = 46" then your program should output 4.
The x character can appear in any of the three numbers and all three numbers will be greater than or equal
to 0 and less than or equal to 1000000.

Examples:

Input: "4 - 2 = x"

Output: 2

Input: "1x0 * 12 = 1200"

Output: 0

*/

import java.util.*;

public class MissingDigit {

    public static String missingDigit(String str) {

        str = str.replaceAll(" ", "");

        int length = 0;
        String operator = "";
        String result = "";
        boolean makeOpposite = false;
        String returningValue = "";

        String[] array = str.split("=");

        String[] lhs = array[0].split("[-+*/]");

        if (lhs[0].contains("x")) {
            length = lhs[0].length();
            makeOpposite = true;
            operator = findOperator(str, length, makeOpposite);
            result = evaluateExpression(array[1], lhs[1], operator);
            returningValue = findMiss(result, lhs[0]);

        } else if(lhs[1].contains("x")) {
            length = lhs[0].length();
            makeOpposite = false;

            if (str.charAt(length) == '*' || str.charAt(length) == '+') {
                makeOpposite = true;
                operator = findOperator(str, length, makeOpposite);
                result = evaluateExpression(array[1], lhs[0], operator);
                returningValue = findMiss(result, lhs[1]);
            } else {
                operator = findOperator(str, length, makeOpposite);
                result = evaluateExpression(lhs[0], array[1], operator);
                returningValue = findMiss(result, lhs[1]);
            }



        } else if(array[1].contains("x")) {
            length = lhs[0].length(); // do not need
            operator = findOperator(str, length, makeOpposite);
            result = evaluateExpression(lhs[0], lhs[1], operator);
            returningValue = findMiss(result, array[1]);
        }

        // code goes here
        return returningValue;
    }

    public static String findMiss(String result, String stringWithX) {

        for (int i = 0; i < stringWithX.length(); i++) {
            if (stringWithX.charAt(i) == 'x')
                return result.charAt(i) + "";
        }

        return "";
    }

    public static String findOperator(String str, int index, boolean makeOpposite) {
        String operator = str.charAt(index) + "";

        if (makeOpposite) {

            switch (operator) {
                case "+":
                    operator = "-";
                    break;
                case "-":
                    operator = "+";
                    break;
                case "/":
                    operator = "*";
                    break;
                case "*":
                    operator = "/";
                    break;
            }
        }

        return operator;
    }

    public static String evaluateExpression(String lhs, String rhs, String operator) {

        int a = Integer.parseInt(lhs);
        int b = Integer.parseInt(rhs);
        int result = 0;

        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "/":
                result = a / b;
                break;
            case "*":
                result = a * b;
                break;
        }

        return String.valueOf(result);
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        //System.out.print(missingDigit(s.nextLine()));
        System.out.print(missingDigit("39 - x3 = 6"));
    }
}


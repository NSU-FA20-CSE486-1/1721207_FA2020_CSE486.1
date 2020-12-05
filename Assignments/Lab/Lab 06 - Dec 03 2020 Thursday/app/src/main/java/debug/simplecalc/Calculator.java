package com.mohammadrayed.nsu.fall2020.cse486.sec01.lab06.debug;

public class Calculator {
    // Available operations
    public enum Operator {ADD, SUB, DIV, MUL}


    public double addition(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }


    public double subtraction(double firstOperand, double secondOperand) {
        return firstOperand - secondOperand;
    }

    public double division(double firstOperand, double secondOperand) {
        return firstOperand / secondOperand;
    }

    public double multiplication(double firstOperand, double secondOperand) {
        return firstOperand * secondOperand;
    }
}

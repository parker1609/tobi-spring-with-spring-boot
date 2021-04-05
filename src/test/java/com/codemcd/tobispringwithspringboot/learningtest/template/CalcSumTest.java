package com.codemcd.tobispringwithspringboot.learningtest.template;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class CalcSumTest {
    Calculator calculator;
    String numFilepath;

    @BeforeEach
    void setUp() {
        this.calculator = new Calculator();
        this.numFilepath = "src/main/resources/numbers.txt";
    }

    @Test
    void sumOfNumbers() throws IOException {
        assertThat(calculator.calcSum(numFilepath)).isEqualTo(10);
    }

    @Test
    void multiplyOfNumbers() throws IOException {
        assertThat(calculator.calcMultiply(numFilepath)).isEqualTo(24);
    }
}

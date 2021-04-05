package com.codemcd.tobispringwithspringboot.learningtest.template;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CalcSumTest {

    @Test
    void sumOfNumbers() throws IOException {
        Calculator calculator = new Calculator();
        int sum = calculator.calcSum("src/main/resources/numbers.txt");

        Assertions.assertThat(sum).isEqualTo(10);
    }
}

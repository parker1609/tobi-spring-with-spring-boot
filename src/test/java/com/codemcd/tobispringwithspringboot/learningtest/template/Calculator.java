package com.codemcd.tobispringwithspringboot.learningtest.template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {

    public int calcSum(String filepath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            Integer sum = 0;
            String line = null;
            while ((line = br.readLine()) != null) {
                sum += Integer.parseInt(line);
            }

            return sum;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}

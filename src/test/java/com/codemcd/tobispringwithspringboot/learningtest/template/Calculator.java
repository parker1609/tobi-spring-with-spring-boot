package com.codemcd.tobispringwithspringboot.learningtest.template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {

    public int calcSum(String filepath) throws IOException {
        LineCallback sumCallback = (line, value) -> value + Integer.parseInt(line);

        return lineReadTemplate(filepath, sumCallback, 0);
    }

    public Integer calcMultiply(String filepath) throws IOException {
        LineCallback sumCallback = (line, value) -> value * Integer.parseInt(line);

        return lineReadTemplate(filepath, sumCallback, 1);
    }

    public Integer lineReadTemplate(String filepath, LineCallback callback, int initVal) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            Integer res = initVal;
            String line = null;
            while ((line = br.readLine()) != null) {
                res = callback.doSomethingWithLine(line, res);
            }

            return res;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}

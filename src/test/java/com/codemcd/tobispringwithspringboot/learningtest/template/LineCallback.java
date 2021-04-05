package com.codemcd.tobispringwithspringboot.learningtest.template;

@FunctionalInterface
public interface LineCallback {
    Integer doSomethingWithLine(String line, Integer value);
}

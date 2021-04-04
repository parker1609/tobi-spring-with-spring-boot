package com.codemcd.tobispringwithspringboot.learningtest.junit;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JUintTest {
    static JUintTest testObject;

    @Test
    void test1() {
        Assertions.assertThat(this).isNotSameAs(testObject);
        testObject = this;
    }

    @Test
    void test2() {
        Assertions.assertThat(this).isNotSameAs(testObject);
        testObject = this;
    }

    @Test
    void test3() {
        Assertions.assertThat(this).isNotSameAs(testObject);
        testObject = this;
    }
}

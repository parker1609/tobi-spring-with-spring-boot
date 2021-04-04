package com.codemcd.tobispringwithspringboot.learningtest.junit;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class JUintTest {
    static Set<JUintTest> testObjects = new HashSet<>();

    @Test
    void test1() {
        Assertions.assertThat(testObjects).doesNotContain(this);
        testObjects.add(this);
    }

    @Test
    void test2() {
        Assertions.assertThat(testObjects).doesNotContain(this);
        testObjects.add(this);
    }

    @Test
    void test3() {
        Assertions.assertThat(testObjects).doesNotContain(this);
        testObjects.add(this);
    }
}

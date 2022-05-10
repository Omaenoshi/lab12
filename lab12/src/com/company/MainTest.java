package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    public void testMaxInput() {
        Assertions.assertEquals(Integer.MAX_VALUE, Integer.decode(Integer.MAX_VALUE + ""));
    }

    @Test
    public void testMinInput() {
        Assertions.assertEquals(Integer.MIN_VALUE, Integer.decode(Integer.MIN_VALUE + ""));
    }

    @Test
    public void testZeroInput() {
        Assertions.assertEquals(0, Integer.decode("+0"));
        Assertions.assertEquals(0, Integer.decode("0"));
        Assertions.assertEquals(0, Integer.decode("-0"));
    }

    @Test
    public void positiveAndNegativeInput() {
        Assertions.assertEquals(5, Integer.decode("+5"));
        Assertions.assertEquals(5, Integer.decode("5"));
        Assertions.assertEquals(-5, Integer.decode("-5"));
    }

    @Test
    public void testHexNumberInput() {
        Assertions.assertEquals(10, Integer.decode("0xA"));
        Assertions.assertEquals(10, Integer.decode("0XA"));
        Assertions.assertEquals(10, Integer.decode("0x00A"));
        Assertions.assertEquals(-10, Integer.decode("-0xA"));
        Assertions.assertEquals(10, Integer.decode("#A"));
        Assertions.assertEquals(-11, Integer.decode("-#B"));
    }
    @Test
    public void testEmptyStringInput() {
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.decode(""), "Zero length string");
    }

    @Test
    public void testWrongStringFormatInput() {
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.decode("1+"), "Sign character in wrong position");
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.decode("1-"), "Sign character in wrong position");
    }

    @Test
    public void testOctalInput() {
        Assertions.assertEquals(8, Integer.decode("010"));
        Assertions.assertEquals(-8, Integer.decode("-010"));
        Assertions.assertEquals(9, Integer.decode("011"));
        Assertions.assertEquals(-9, Integer.decode("-011"));
    }
    @Test
    public void testRandomStringInput() {
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.decode("Test test"), "For input string: \"Test test\"");
    }

}

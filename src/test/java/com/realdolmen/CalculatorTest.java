package com.realdolmen;

import com.mysql.jdbc.AssertionFailedException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sun.jvm.hotspot.utilities.AssertionFailure;

import static org.junit.Assert.fail;

public class CalculatorTest {
    Calculator calculator;

    @Before
    public void intitializeCalculator() {
        calculator = new Calculator();
    }
    @Test
    public void testIfAddMethodWithEmptyParametersReturnsZero() {
        Assert.assertEquals(0, calculator.add(""));
    }
    @Test
    public void testIfAddMethodWithOneParameterReturnsThisParameter() {
        Assert.assertEquals(4, calculator.add("4"));
    }
    @Test
    public void testIfAddMethodWithTwoParametersReturnsAddedParameters() {
        Assert.assertEquals(37, calculator.add("14, 23"));
    }
    @Test
    public void testIfAddMethodWorksWithMultipleParameters() {
        Assert.assertEquals(17, calculator.add("5, 4, 4, 3, 1"));
    }
    @Test
    public void testIfAddMethodWithTwoDelimitersStillAddsParameters(){
        Assert.assertEquals(35, calculator.add("3, 2\n5\n6, 4, 7\n8"));
    }
    @Test (expected =NumberFormatException.class)
    public void testIfAddMethodWithOneParameterAndBackslashNGivesException(){
      calculator.add("1,\n");
    }
}

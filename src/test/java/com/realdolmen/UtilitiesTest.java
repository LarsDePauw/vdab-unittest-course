package com.realdolmen;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UtilitiesTest {
    @Test
    public void greatestCommonFactorReturnsGreatestCommonFactorForNormalValues() {
        assertEquals(8, Utilities.greatestCommonFactor(24, 16));
        assertEquals(4, Utilities.greatestCommonFactor(48, 100));
    }

    @Test
    public void greatestCommonFactorReturnsOneIfAnyParameterIsZero() {
        assertEquals(1, Utilities.greatestCommonFactor(0, 2));
        assertEquals(1, Utilities.greatestCommonFactor(10, 0));
    }

    @Test
    public void greatestCommonFactorAlwaysReturnsPositiveValues() throws Exception {
        assertEquals(2, Utilities.greatestCommonFactor(2, 4));
        assertEquals(2, Utilities.greatestCommonFactor(-2, 4));
        assertEquals(2, Utilities.greatestCommonFactor(2, -4));
        assertEquals(2, Utilities.greatestCommonFactor(-2, -4));
    }

    @Test
    public void greatestCommonFactorOfTwoEqualNumbersEqualsTheNumberItself() throws Exception {
        assertEquals(28, Utilities.greatestCommonFactor(28, 28));
    }


    @Test
    public void smallerValueGetsSwitchedWithBiggerValue() throws Exception {
        assertEquals(16, Utilities.greatestCommonFactor(64, 144));
    }

    @Test
    public void testToSeeIfasDoubleReturnsDouble() {
        Fraction a = new Fraction(17, 23);
        assertEquals(0.73913043478261, a.asDouble(), 0.0000001);
    }

    @Test()
    public void checkingifEqualsFunctionComparesFractionsAndGivesTRUEBoolean() {
        Fraction a = new Fraction(12, 8);
        Fraction b = new Fraction(12, 8);
        assertEquals(false, a.equals(b));
    }


    @Test()
    public void checkingifEqualsFunctionComparesFractionsAndGivesFALSEBoolean() {
        Fraction a = new Fraction(12, 8);
        Fraction b = new Fraction(7, 8);
        assertEquals(false, a.equals(b));
    }
    @Test(expected = ArithmeticException.class)
    public void testToSeeIfExceptionGetsThrownWithDenominatorZero() {
        Fraction a = new Fraction(5, 0);
    }

    @Test
    public void testingGetterForDenominator() {
    Fraction a = new Fraction(5, 8);
    assertEquals(5, a.getTeller());
}

    @Test
    public void testingGetterForNominator() {
        Fraction a = new Fraction(7, 9);
        assertEquals(9, a.getNoemer());
    }

    @Test
    public void testingFractiontoString() {
        Fraction a = new Fraction(3, 7);
        assertEquals("3/7", a.toString());
    }

//    @Test
//    public void testToSeeIfSimpliFyReturnsSimplifiedFraction(){
//        Fraction b = new Fraction(12,8);
//        assertEquals("3/2", b.simplify());
//    }
}

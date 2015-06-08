import com.realdolmen.Fraction;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;


public class FractionTests {
    @Test
    public void testToSeeIfasDoubleReturnsDouble() {
        Fraction a = new Fraction(17, 23);
        assertEquals(0.73913043478261, a.asDouble(), 0.0000001);
    }

    @Test()
    public void checkingifEqualsValueFunctionComparesFractionsAndGivesTRUEBoolean() {
        Fraction a = new Fraction(12, 8);
        Fraction b = new Fraction(12, 8);
        assertEquals(true, a.equals(b));
    }


    @Test()
    public void checkingifEqualsValueFunctionComparesFractionsAndGivesFALSEBoolean() {
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
    public void testIfNewFractionGetsSimplified(){
        Fraction a = new Fraction(20, 40);
        assertTrue(a.getNoemer() == 2 && a.getTeller() == 1);
    }

    @Test
    public void testingFractiontoString() {
        Fraction a = new Fraction(9, 21);
        assertEquals("3/7", a.toString());
    }

    @Test
    public void testToSeeIfSimpliFyReturnsSimplifiedFraction() {
        Fraction b = new Fraction(12, 8);
        assertEquals("3/2", b.toString());
    }

    @Test
    public void testReciprocalIfReturnsNewInvertedFraction() {
        Fraction a = new Fraction(5, 8);
        assertEquals(new Fraction(8, 5), a.reciprocal());
    }

    @Test
    public void testIfMultiplyReturnsNewFractionWithMultipliedValues() {
        Fraction a = new Fraction(3, 7);
        Fraction b = new Fraction(4, 2);
        assertEquals(new Fraction(12, 14), a.multiply(b));
    }

    @Test
    public void testIfAddFunctionReturnsNewFractionWithAddedValues(){
        Fraction a = new Fraction(2, 3);
        Fraction b = new Fraction(3, 4);
        assertEquals(new Fraction(17, 12), a.add(b));
    }

    @Test
    public void testIfNegativeFractionMultipliedWithPositiveFractionReturnsNegativeFraction(){
        Fraction a = new Fraction(-1, 2);
        Fraction b = new Fraction(3, 4);
        assertEquals(new Fraction(-3, 8), a.multiply(b));
    }

    @Test
    public void testIfNegativeFractionMultipliedWithNegativeFractionReturnspositiveFraction(){
        Fraction a = new Fraction(-1, 2);
        Fraction b = new Fraction(3, -4);
        assertEquals(new Fraction(3, 8), a.multiply(b));
    }
}

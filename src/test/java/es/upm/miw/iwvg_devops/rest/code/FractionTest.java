package es.upm.miw.iwvg_devops.rest.code;


import es.upm.miw.iwvg_devops.code.Fraction;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;


public class FractionTest {

    @Test
    public void testConstructorValidFraction() {
        Fraction fraction = new Fraction(1, 2);
        assertEquals(1, fraction.getNumerator());
        assertEquals(2, fraction.getDenominator());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorDenominatorZero() {
        new Fraction(1, 0);
    }

    @Test
    public void testDefaultConstructor() {
        Fraction fraction = new Fraction();
        assertEquals(1, fraction.getNumerator());
        assertEquals(1, fraction.getDenominator());
    }

    @Test
    public void testDecimal() {
        Fraction fraction = new Fraction(1, 4);
        assertEquals(0.25, fraction.decimal(), 0.001);
    }

    @Test
    public void testIsProper() {
        Fraction proper = new Fraction(1, 2);
        Fraction improper = new Fraction(3, 2);
        assertTrue(proper.isProper());
        assertFalse(improper.isProper());
    }

    @Test
    public void testIsImproper() {
        Fraction proper = new Fraction(1, 2);
        Fraction improper = new Fraction(3, 2);
        assertFalse(proper.isImproper());
        assertTrue(improper.isImproper());
    }

    @Test
    public void testIsEquivalent() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(2, 4);
        Fraction f3 = new Fraction(3, 4);
        assertTrue(f1.isEquivalent(f2));
        assertFalse(f1.isEquivalent(f3));
    }

    @Test
    public void testAdd() {
        Fraction f1 = new Fraction(1, 4);
        Fraction f2 = new Fraction(1, 4);
        Fraction result = f1.add(f2);
        assertEquals(new Fraction(2, 4).toString(), result.toString());
    }

    @Test
    public void testMultiply() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);
        Fraction result = f1.multiply(f2);
        assertEquals(new Fraction(1, 6).toString(), result.toString());
    }

    @Test
    public void testDivide() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 4);
        Fraction result = f1.divide(f2);
        assertEquals(new Fraction(2, 1).toString(), result.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZeroNumerator() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(0, 1);
        f1.divide(f2);
    }

    @Test
    public void testReduce() {
        Fraction fraction = new Fraction(4, 8);
        Fraction reduced = fraction.reduce();
        assertEquals(new Fraction(1, 2).toString(), reduced.toString());
    }

    @Test
    public void testToString() {
        Fraction fraction = new Fraction(1, 2);
        assertEquals("Fraction{numerator=1, denominator=2}", fraction.toString());
    }
}

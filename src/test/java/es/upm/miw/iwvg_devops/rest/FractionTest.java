package es.upm.miw.iwvg_devops.rest;

import es.upm.miw.iwvg_devops.code.Fraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {
    private Fraction fraction;

    @BeforeEach
    void before() {
        this.fraction = new Fraction(2, 4);
    }

    @Test
    void testGetNumerator() {
        assertEquals(2, this.fraction.getNumerator());
    }

    @Test
    void testSetNumerator() {
        fraction.setNumerator(3);
        assertEquals(3, this.fraction.getNumerator());
    }

    @Test
    void testGetDenominator() {
        assertEquals(4, this.fraction.getDenominator());
    }

    @Test
    void testSetDenominator() {
        this.fraction.setDenominator(5);
        assertEquals(5, this.fraction.getDenominator());
    }

    @Test
    void testDecimal() {
        assertEquals(0.5, this.fraction.decimal());
    }

    @Test
    void testToString() {
        assertEquals("Fraction{numerator=2, denominator=4}", this.fraction.toString());
    }

    @Test
    void testIsProper() {
        assertTrue(this.fraction.isProper());
        this.fraction = new Fraction(4,2);
        assertFalse(this.fraction.isProper());
    }

    @Test
    void testIsImproper() {
        assertFalse(this.fraction.isImproper());
        this.fraction = new Fraction(4,2);
        assertTrue(this.fraction.isImproper());
    }

    @Test
    void testIsEquivalent() {
        assertTrue(this.fraction.isEquivalent(new Fraction(4, 8)));
        assertFalse(this.fraction.isEquivalent(new Fraction(5, 6)));
    }

    @Test
    void testAddFraction() {
        this.fraction.add(new Fraction(4, 16));
        assertEquals(new Fraction(3,4) , this.fraction);
    }

    @Test
    void testMultiplyFraction() {
        this.fraction.multiply(new Fraction(4, 16));
        assertEquals(new Fraction(1,8) , this.fraction);
    }

    @Test
    void testDivideFraction() {
        this.fraction.divide(new Fraction(4, 16));
        assertEquals(new Fraction(2,1) , this.fraction);
    }
}

package es.upm.miw.iwvg_devops.code;

import java.util.Objects;

public class Fraction {

    private int numerator;

    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction() {
        this(1, 1);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double decimal() {
        return (double) numerator / denominator;
    }

    public boolean isProper() {
        return this.numerator < this.denominator;
    }

    public boolean isImproper() {
        return this.numerator > this.denominator;
    }

    public boolean isEquivalent(Fraction fraction) {
        return this.numerator * fraction.denominator == this.denominator * fraction.numerator;
    }

    public void add(Fraction fractionAdded) {
        int lcm = leastCommonMultiple(this.denominator, fractionAdded.denominator);

        this.numerator *= (lcm / this.denominator);
        fractionAdded.numerator *= (lcm / fractionAdded.denominator);

        this.denominator = lcm;
        this.numerator = this.numerator + fractionAdded.numerator;

        simplify();
    }

    public void multiply(Fraction fractionAdded) {
        this.denominator *= fractionAdded.denominator;
        this.numerator *= fractionAdded.numerator;

        simplify();
    }

    public void divide(Fraction fractionAdded) {
        this.denominator *= fractionAdded.numerator;
        this.numerator *= fractionAdded.denominator;

        simplify();
    }

    private int greatestCommonDivisor(int denominator1, int denominator2) {
        if (denominator1 == 0)
            return denominator2;

        return greatestCommonDivisor(denominator2 % denominator1, denominator1);
    }

    private int leastCommonMultiple(int number1, int number2) {
        return (number1 * number2) / greatestCommonDivisor(number1, number2);
    }

    private void simplify() {
        int gcd = greatestCommonDivisor(this.numerator, this.denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fraction)) return false;
        Fraction fraction = (Fraction) o;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}

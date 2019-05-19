package net.coderodde.math.impl;

/**
 * This class implements a complex number. The complex number consists of a real
 * part and an imaginary part. The imaginary part is a real number equipped with
 * the imaginary unit {@code i}, for which {@code i^2 = -1}. This class is
 * immutable.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (May 18, 2019)
 */
public final class ComplexNumber {

    /**
     * The real number.
     */
    private final double realPart;

    /**
     * The imaginary number.
     */
    private final double imaginaryPart;

    /**
     * Constructs a new complex number.
     * 
     * @param realPart      the real part of the newly constructed complex 
     *                      number.
     * @param imaginaryPart the imaginary part of the newly constructed complex
     *                      number.
     */
    public ComplexNumber(final double realPart, final double imaginaryPart) {
        checkNotNan(realPart);
        checkNotNan(imaginaryPart);
        checkNotInfinite(realPart);
        checkNotInfinite(imaginaryPart);
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    /**
     * Returns the real part of this complex number.
     * 
     * @return the real part of this complex number.
     */
    public double getRealPart() {
        return realPart;
    }

    /**
     * Returns the imaginary part of this complex number.
     * 
     * @return the imaginary part of this complex number.
     */
    public double getImaginaryPart() {
        return imaginaryPart;
    }

    /**
     * Returns the complex number that is equal to the sum of this complex 
     * number and the {@code other} complex number.
     * 
     * @param other the complex number to add.
     * @return the sum of this and {@code other} complex number.
     */
    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(realPart + other.realPart, 
                                 imaginaryPart + other.imaginaryPart);
    }

    /**
     * Returns the negative of this complex number.
     * 
     * @return the negative of this complex number. 
     */
    public ComplexNumber negate() {
        return new ComplexNumber(-realPart, -imaginaryPart);
    }

    /**
     * Returns the complex number representing the product of the two input 
     * complex numbers.
     * 
     * @param a the first complex number.
     * @param b the second complex number.
     * @return the product of {@code a} and {@code b}.
     */
    public ComplexNumber multiply(ComplexNumber complexNumber) {
        double a = realPart;
        double b = imaginaryPart;
        double c = complexNumber.realPart;
        double d = complexNumber.imaginaryPart;
        double resultRealPart = a * c - b * d;
        double resultImaginaryPart = a * d + b * c;
        return new ComplexNumber(resultRealPart, resultImaginaryPart);
    }

    /**
     * Returns a simple textual representation of this complex number.
     * 
     * @return the textual representation of this complex number.
     */
    @Override
    public String toString() {
        if (realPart == 0.0 && imaginaryPart == 0.0) {
            return "0.0";
        }

        if (realPart == 0.0) {
            return imaginaryPart + "i";
        }

        if (imaginaryPart == 0.0) {
            return Double.toString(realPart);
        }

        if (imaginaryPart < 0.0) {
            return realPart + " - " + Math.abs(imaginaryPart) + "i";
        }

        return realPart + " + " + imaginaryPart + "i";
    }

    /**
     * Checks that the input {@code double} value is not {@code NaN}.
     * 
     * @param d the value to check.
     * @throws IllegalArgumentException in case {@code d} is {@code NaN}.
     */
    private void checkNotNan(double d) {
        if (Double.isNaN(d)) {
            throw new IllegalArgumentException("NaN");
        }
    }

    /**
     * Checks that the input {@code double} value is finite.
     * 
     * @param d the value to check.
     * @throws IllegalArgumentException in case {@code d} is not finite.
     */
    private void checkNotInfinite(double d) {
        if (Double.isInfinite(d)) {
            throw new IllegalArgumentException("Infinite");
        }
    }
}

package net.coderodde.math.impl;

/**
 *
 * @author rodde
 */
public final class ComplexNumber {
    
    private final double realPart;
    private final double imaginaryPart;
    
    public ComplexNumber(final double realPart, final double imaginaryPart) {
        checkNotNan(realPart);
        checkNotNan(imaginaryPart);
        checkNotInfinite(realPart);
        checkNotInfinite(imaginaryPart);
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }
    
    public double getRealPart() {
        return realPart;
    }
    
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
    
    private void checkNotNan(double d) {
        if (Double.isNaN(d)) {
            throw new IllegalArgumentException("NaN");
        }
    }
    
    private void checkNotInfinite(double d) {
        if (Double.isInfinite(d)) {
            throw new IllegalArgumentException("Infinite");
        }
    }
}

package net.coderodde.math.impl;

import net.coderodde.math.Divisible;

/**
 * This class implements the division operator over complex numbers.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (May 18, 2019)
 */
public final class ComplexVectorDivisible implements Divisible<ComplexNumber,
                                                               ComplexNumber,
                                                               ComplexNumber> {

    /**
     * Divides the complex {@code divident} by the complex {@code divisor} and 
     * returns the fraction. Both the input complex numbers remain intact.
     * 
     * @param divident the complex divident.
     * @param divisor  the complex divisor.
     * @return the fraction after dividing the divident by the divisor.
     */
    @Override
    public ComplexNumber divide(ComplexNumber divident, ComplexNumber divisor) {
        // TODO: could do Karatsuba multiplication here, I guess.
        double a = divident.getRealPart();
        double b = divident.getImaginaryPart();
        double c = divisor.getRealPart();
        double d = divisor.getImaginaryPart();

        double resultRealPart = (a * c + b * d) / (c * c + d * d);
        double resultImaginaryPart = (b * c - a * d) / (c * c + d * d);

        return new ComplexNumber(resultRealPart, resultImaginaryPart);
    }
}

package net.coderodde.math.impl;

import net.coderodde.math.Divisible;

/**
 * This class implements the division of {@code double} values.
 * 
 * @author Rodion  "rodde" Efremov
 * @version 1.6 (May 17, 2019)
 */
public final class RealVectorDivisible 
        implements Divisible<Double, Double, Double> {

    /**
     * Returns the fraction of {@code divident} and {@code divisor}.
     * 
     * @param divident the divident {@code double} value.
     * @param divisor  the divisor {@code double} value.
     * @return the fraction.
     */
    @Override
    public Double divide(Double divident, Double divisor) {
        return divident / divisor;
    }
}

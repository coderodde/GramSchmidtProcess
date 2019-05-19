package net.coderodde.math;

/**
 * This interface defines the API for division operator.
 * 
 * @param <D1> the type of the divident.
 * @param <D2> the type of the divisor.
 * @param <F>  the fraction type.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (May 17, 2019)
 */
public interface Divisible<D1, D2, F> {

    /**
     * Divides {@code a} by {@code b} and returns the result.
     * 
     * @param divident the object being divided.
     * @param divisor  the divisor.
     * @return the result of dividing {@code divident} by {@code divisor}.
     */
    public F divide(D1 divident, D2 divisor);
}

package net.coderodde.math;

/**
 * This interface defines the API for division operator.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (May 17, 2019)
 */
public interface Divisible<I, O> {
    
    /**
     * Divides {@code a} by {@code b} and returns the result.
     * 
     * @param divident the object being divided.
     * @param divisor  the divisor.
     * @return the result of dividing {@code divident} by {@code divisor}.
     */
    public O divide(I divident, I divisor);
}

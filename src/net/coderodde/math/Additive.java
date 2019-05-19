package net.coderodde.math;

/**
 * This interface defines the API for adding the two elements.
 * 
 * @param <I1> the type of the left operand.
 * @param <I2> the type of the right operand.
 * @param <O>  the sum type.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (May 17, 2019)
 */
public interface Additive<I1, I2, O> {

    /**
     * This method adds {@code a} and {@code b} and returns the sum.
     * 
     * @param a the first element.
     * @param b the second element.
     * @return the sum of the two given numbers.
     */
    public O add(I1 a, I2 b);
}

package net.coderodde.math;

/**
 * This interface defines the API for adding the two elements.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (May 17, 2019)
 */
public interface Additive<E> {
    
    /**
     * This method adds {@code a} and {@code b} and returns the sum.
     * 
     * @param a the first element.
     * @param b the second element.
     * @return the sum of the two given numbers.
     */
    public E add(E a, E b);
}

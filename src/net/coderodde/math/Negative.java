package net.coderodde.math;

/**
 * This interface defines the API for computing negative of given values.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (May 17, 2019)
 */
public interface Negative<E> {
    
    /**
     * Returns the negative of {@code element}. The negative of {@code a} is 
     * {@code -a} such that {@code a + (-a) = O}, where {@code O} is the zero
     * element.
     * 
     * @param element the element to negate.
     * @return the negative of {@code element}.
     */
    public E negate(E element);
}

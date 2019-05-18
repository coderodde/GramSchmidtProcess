package net.coderodde.math;

/**
 * This interface defines the API for multiplication (product).
 * 
 * @param <E1> the type of the left element to multiply.
 * @param <E2> the type of the right element to multiply.
 * @param <O>  the product result type.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (May 17, 2019)
 */
public interface Product<E1, E2, O> {
    
    /**
     * Returns the product of {@code a} and {@code b}.
     * 
     * @param a the first element.
     * @param b the second element.
     * @return the product of the two input elements.
     */
    public O multiply(E1 a, E2 b);
}

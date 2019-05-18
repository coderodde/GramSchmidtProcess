package net.coderodde.math;

/**
 * This interface defines the API for inner product over given vector component
 * type.
 * 
 * @param <I> the vector component type.
 * @param <O> the inner product value type.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (May 17, 2019)
 */
public interface InnerProduct<I, O> {
    
    /**
     * Computes the inner product of the two given vectors.
     * @param a the first vector.
     * @param b the second vector.
     * @return the inner product 
     */
    public O innerProductOf(Vector<I> a, Vector<I> b);
}

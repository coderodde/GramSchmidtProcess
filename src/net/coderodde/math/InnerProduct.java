package net.coderodde.math;

/**
 * This interface defines the API for inner product over given vector component
 * type.
 * 
 * @param <VCT1> the left vector type.
 * @param <VCT2> the right vector type.
 * @param <IPT>  the inner product value type.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (May 17, 2019)
 */
public interface InnerProduct<VCT1, VCT2, IPT> {
    
    /**
     * Computes the inner product of the two given vectors.
     * 
     * @param a the first vector.
     * @param b the second vector.
     * @return the inner product 
     */
    public IPT innerProductOf(Vector<VCT1> a, Vector<VCT2> b);
}

package net.coderodde.math.impl;

import net.coderodde.math.Negative;
import net.coderodde.math.Vector;

/**
 * This class implements negation operation over real vectors.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (May 17, 2019)
 */
public final class RealVectorNegative implements Negative<Vector<Double>,
                                                          Vector<Double>> {

    /**
     * Negates the input {@code double} vector. The input vector remains intact.
     * 
     * @param a the {@code double} vector to negate.
     * @return the negative of {@code a}.
     */
    @Override
    public Vector<Double> negate(Vector<Double> a) {
        Vector<Double> result = new Vector<>(a);
        
        for (int i = 0; i < result.getNumberOfDimensions(); i++) {
            result.set(i, -result.get(i));
        }
        
        return result;
    }
    
}

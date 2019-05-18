package net.coderodde.math.impl;

import net.coderodde.math.Product;
import net.coderodde.math.Vector;

/**
 * This class implements the operation of multiplying a vector by a scalar.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (May 18, 2019)
 */
public final class RealVectorProductByScalar 
        implements Product<Double, Vector<Double>, Vector<Double>> {

    /**
     * This method multiplies the input vector {@code vector} component-wise by
     * the {@code double} scalar and returns the result. The input vector 
     * remains intact.
     * 
     * @param scalar the scalar.
     * @param vector the vector to multiply by the scalar.
     * @return the input vector multiplied by the input scalar.
     */
    @Override
    public Vector<Double> multiply(Double scalar, Vector<Double> vector) {
        Vector<Double> x = new Vector<>(vector);
        
        for (int i = 0; i < vector.getNumberOfDimensions(); i++) {
            x.set(i, x.get(i) * scalar);
        }
        
        return x;
    }
}

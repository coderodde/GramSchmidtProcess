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
     * {@inheritDoc }.
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

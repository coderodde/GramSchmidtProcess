package net.coderodde.math.impl;

import net.coderodde.math.Additive;
import net.coderodde.math.Vector;

/**
 * This class implements addition over {@code double}-valued vectors of an
 * Euclidean space.
 * 
 * @author Rodion "rodde" Efremov 
 * @version 1.6 (May 17, 2019)
 */
public final class RealVectorAdditive implements Additive<Vector<Double>,
                                                          Vector<Double>,
                                                          Vector<Double>> {

    /**
     * Adds component-wise the contents in {@code a} and {@code b} and returns 
     * the sum. Both input vectors remain intact.
     * 
     * @param a the first operand.
     * @param b the second operand.
     * @return the sum of the two input operands.
     */
    @Override
    public Vector<Double> add(Vector<Double> a, Vector<Double> b) {
        Vector<Double> result = new Vector<>(a);
        
        for (int i = 0; i < a.getNumberOfDimensions(); i++) {
            result.set(i, result.get(i) + b.get(i));
        }
        
        return result;
    }
}

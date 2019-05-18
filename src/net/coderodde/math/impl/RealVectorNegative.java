package net.coderodde.math.impl;

import net.coderodde.math.Negative;
import net.coderodde.math.Vector;

/**
 * This class implements negation operation over real vectors.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (May 17, 2019)
 */
public final class RealVectorNegative implements Negative<Vector<Double>> {

    /**
     * {@inheritDoc }
     */
    @Override
    public Vector<Double> negate(Vector<Double> element) {
        Vector<Double> result = new Vector<>(element);
        
        for (int i = 0; i < result.getNumberOfDimensions(); i++) {
            result.set(i, -result.get(i));
        }
        
        return result;
    }
    
}

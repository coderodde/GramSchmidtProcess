package net.coderodde.math.impl;

import net.coderodde.math.InnerProduct;
import net.coderodde.math.Vector;

/**
 * This class is responsible for computing inner products over real-valued 
 * vectors.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (May 17, 2019)
 */
public final class RealVectorInnerProduct 
        implements InnerProduct<Double, Double> {

    /**
     * {@inheritDoc }
     */
    @Override
    public Double innerProductOf(Vector<Double> a, Vector<Double> b) {
        double innerProduct = 0.0;
        
        for (int i = 0; i < a.getNumberOfDimensions(); i++) {
            innerProduct += a.get(i) * b.get(i);
        }
        
        return innerProduct;
    }
}

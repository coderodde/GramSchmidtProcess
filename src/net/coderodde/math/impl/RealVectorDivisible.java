package net.coderodde.math.impl;

import net.coderodde.math.Divisible;
import net.coderodde.math.Product;
import net.coderodde.math.Vector;

/**
 * This class implements the multiplication of vectors by a scalar.
 * 
 * @author Rodion  "rodde" Efremov
 * @version 1.6 (May 17, 2019)
 */
public final class RealVectorDivisible implements Divisible<Double, Double> {
    
    @Override
    public Double divide(Double divident, Double divisor) {
        return divident / divisor;
    }
}

package net.coderodde.math.impl;

import net.coderodde.math.Product;
import net.coderodde.math.Vector;

/**
 *
 * @author Rodion "rodde" Efremov
 * @version 1.6 (May 18, 2019)
 */
public final class ComplexVectorProductByScalar 
        implements Product<ComplexNumber, 
                           Vector<ComplexNumber>, 
                           Vector<ComplexNumber>>{

    @Override
    public Vector<ComplexNumber> multiply(ComplexNumber a, 
                                          Vector<ComplexNumber> b) {
        Vector<ComplexNumber> ret = new Vector<>(b);
        
        for (int i = 0; i < b.getNumberOfDimensions(); i++) {
            ret.set(i, ret.get(i).multiply(a));
        }
        
        return ret;
    }
}

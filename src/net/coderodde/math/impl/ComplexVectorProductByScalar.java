package net.coderodde.math.impl;

import net.coderodde.math.Product;
import net.coderodde.math.Vector;

/**
 * This class implements multiplying complex vectors by a complex scalar.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (May 18, 2019)
 */
public final class ComplexVectorProductByScalar 
        implements Product<ComplexNumber, 
                           Vector<ComplexNumber>, 
                           Vector<ComplexNumber>>{

    /**
     * Multiplies the complex vector by the given complex scalar and returns the
     * result. All the input objects remain intact.
     * 
     * @param scalar the scalar to multiply by.
     * @param vector the complex vector to multiply.
     * @return the {@code vector} multiplied by {@code scalar}.
     */
    @Override
    public Vector<ComplexNumber> multiply(ComplexNumber scalar, 
                                          Vector<ComplexNumber> vector) {
        Vector<ComplexNumber> ret = new Vector<>(vector);
        
        for (int i = 0; i < vector.getNumberOfDimensions(); i++) {
            ret.set(i, ret.get(i).multiply(scalar));
        }
        
        return ret;
    }
}

package net.coderodde.math.impl;

import net.coderodde.math.InnerProduct;
import net.coderodde.math.Vector;

/**
 * This class implements computing inner product over complex vectors.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (May 18, 2019)
 */
public final class ComplexVectorInnerProduct 
        implements InnerProduct<ComplexNumber, ComplexNumber, ComplexNumber> {

    /**
     * Computes the inner product of {@code a} and {@code b} and returns it to
     * the caller.
     * 
     * @param a the first operand.
     * @param b the second operand.
     * @return the inner product.
     */
    @Override
    public ComplexNumber innerProductOf(Vector<ComplexNumber> a,//1 -2i
                                        Vector<ComplexNumber> b) {//1 -2i
        ComplexNumber innerProduct = new ComplexNumber(0.0, 0.0);
        
        for (int i = 0; i < a.getNumberOfDimensions(); i++) {
            ComplexNumber complexNumber1 = a.get(i);
            ComplexNumber complexNumber2 = b.get(i);
            ComplexNumber product = complexNumber1.multiply(complexNumber2);
            innerProduct = innerProduct.add(product);
        }
        
        return innerProduct;
    }
}

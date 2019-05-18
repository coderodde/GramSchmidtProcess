package net.coderodde.math.impl;

import net.coderodde.math.Additive;
import net.coderodde.math.Vector;

/**
 * This class implements the addition operation over complex vectors.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6:P (May 18, 2019)
 */
public final class ComplexVectorAdditive 
        implements Additive<Vector<ComplexNumber>,
                            Vector<ComplexNumber>,
                            Vector<ComplexNumber>> {

    /**
     * Adds the complex vectors {@code a} and {@code b} and returns the 
     * component-wise copy of the object. Both input complex vectors remain
     * intact.
     * 
     * @param a the left summation operand.
     * @param b the right summation operand.
     * @return the sum vector.
     */
    @Override
    public Vector<ComplexNumber> add(Vector<ComplexNumber> a, 
                                     Vector<ComplexNumber> b) {
        ComplexNumber[] complexNumbers = 
                new ComplexNumber[a.getNumberOfDimensions()];
        
        for (int i = 0; i < a.getNumberOfDimensions(); i++) {
            complexNumbers[i] = a.get(i).add(b.get(i));
        }
        
        return new Vector<>(complexNumbers);
    }
}

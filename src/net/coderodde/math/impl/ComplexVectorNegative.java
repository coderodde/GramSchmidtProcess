package net.coderodde.math.impl;

import net.coderodde.math.Negative;
import net.coderodde.math.Vector;

/**
 * This class implements the negation operation over complex numbers.
 * 
 * @author Rodino "rodde" Efremov
 * @version 1.6 (May 18, 2019)
 */
public final class ComplexVectorNegative 
        implements Negative<Vector<ComplexNumber>,
                            Vector<ComplexNumber>> {

    /**
     * Negates every component in {@code element} and returns the resulting 
     * vector. The input vector remains intact.
     * 
     * @param element the element to negate.
     * @return the element with all the components negated compared to the 
     *         input vector. 
     */
    @Override
    public Vector<ComplexNumber> negate(Vector<ComplexNumber> element) {
        Vector<ComplexNumber> result = new Vector<>(element);

        for (int i = 0; i < element.getNumberOfDimensions(); i++) {
            result.set(i, result.get(i).negate());
        }

        return result;
    }
}

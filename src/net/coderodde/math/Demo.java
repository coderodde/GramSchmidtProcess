package net.coderodde.math;

import net.coderodde.math.impl.RealVectorAdditive;
import net.coderodde.math.impl.RealVectorDivisible;
import net.coderodde.math.impl.RealVectorInnerProduct;
import net.coderodde.math.impl.RealVectorNegative;
import net.coderodde.math.impl.RealVectorProductByScalar;

/**
 * This class runs a simple demo for the Gram-Schmidt process.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (May 17, 2019)
 */
final class Demo {

    public static void main(String[] args) {
        Vector<Double> x1 = new Vector<>(1., -1., 1., -1.);
        Vector<Double> x2 = new Vector<>(5., 1., 1., 1.);
        Vector<Double> x3 = new Vector<>(-3., -3., 1., -3.);
        
        Vector<Double>[] orthogonalBasis1 = 
                new GramSchmidtProcess(new RealVectorInnerProduct(),
                                       new RealVectorDivisible(),
                                       new RealVectorProductByScalar(),
                                       new RealVectorAdditive(),
                                       new RealVectorNegative())
                .process(x1, x2, x3);
        
        for (Vector<Double> vector : orthogonalBasis1) {
            System.out.println(vector);
        }
    }
}

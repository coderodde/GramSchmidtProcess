package net.coderodde.math;

import net.coderodde.math.impl.ComplexVectorProductByScalar;
import net.coderodde.math.impl.ComplexNumber;
import net.coderodde.math.impl.ComplexVectorAdditive;
import net.coderodde.math.impl.ComplexVectorDivisible;
import net.coderodde.math.impl.ComplexVectorInnerProduct;
import net.coderodde.math.impl.ComplexVectorNegative;
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
                new GramSchmidtProcess<>(new RealVectorInnerProduct(),
                                         new RealVectorDivisible(),
                                         new RealVectorProductByScalar(),
                                         new RealVectorAdditive(),
                                         new RealVectorNegative())
                .process(x1, x2, x3);

        for (Vector<Double> vector : orthogonalBasis1) {
            System.out.println(vector);
        }

        System.out.println("Orthogonal: " + 
                isOrthogonal(orthogonalBasis1[0],
                             orthogonalBasis1[1],
                             0.00001));

        System.out.println("------");

        // [(1, -2), (3, 4)] = [1 - 2i, 3 + 4i]
        Vector<ComplexNumber> c1 = new Vector<>(new ComplexNumber(1, -2),
                                                new ComplexNumber(3, 4));

        // [(0, -3), (1, 1)] = [-3i, 1 + i]
        Vector<ComplexNumber> c2 = new Vector<>(new ComplexNumber(0, -3),
                                                new ComplexNumber(1, 1));

        Vector<ComplexNumber>[] orthogonalBasis2 = 
                new GramSchmidtProcess<>(new ComplexVectorInnerProduct(),
                                         new ComplexVectorDivisible(),
                                         new ComplexVectorProductByScalar(),
                                         new ComplexVectorAdditive(),
                                         new ComplexVectorNegative())
                .process(c1, c2);

        for (Vector<ComplexNumber> c : orthogonalBasis2) {
            System.out.println(c);
        }        

        System.out.println("Orthogonal: " + 
                isOrthogonalComplex(orthogonalBasis2[0],
                                    orthogonalBasis2[1],
                                    0.00001));
    }

    public static <E, IP> boolean basisIsOrthogonal(Vector<Double>[] basis,
                                                   double epsilon) {
        for (int i = 1; i < basis.length; i++) {
            Vector<Double> target = basis[i];

            for (int j = 0; j < i; j++) {
                Vector<Double> current = basis[j];

                if (!isOrthogonal(target, current, epsilon)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean basisIsOrthogonalComplex(
            Vector<ComplexNumber>[] basis, double epsilon) {
        for (int i = 1; i < basis.length; i++) {
            Vector<ComplexNumber> target = basis[i];

            for (int j = 0; j < i; j++) {
                Vector<ComplexNumber> current = basis[j];

                if (!isOrthogonalComplex(target, current, epsilon)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isOrthogonal(Vector<Double> a, Vector<Double> b, double epsilon) {
        double sum = 0.0;

        for (int i = 0; i < a.getNumberOfDimensions(); i++) {
            sum += a.get(i) * b.get(i);
        }

        return sum < epsilon;
    }

    private static boolean isOrthogonalComplex(Vector<ComplexNumber> a,
                                               Vector<ComplexNumber> b,
                                               double epsilon) {
        ComplexNumber sum = new ComplexNumber(0, 0);

        for (int i = 0; i < a.getNumberOfDimensions(); i++) {
            ComplexNumber product = a.get(i).multiply(b.get(i));
            sum = sum.add(product);
        }

        return Math.abs(sum.getRealPart()) < epsilon &&
               Math.abs(sum.getImaginaryPart()) < epsilon;
    }
}

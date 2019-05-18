package net.coderodde.math;

import net.coderodde.math.impl.RealVectorAdditive;
import net.coderodde.math.impl.RealVectorDivisible;
import net.coderodde.math.impl.RealVectorInnerProduct;
import net.coderodde.math.impl.RealVectorNegative;
import net.coderodde.math.impl.RealVectorProductByScalar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GramSchmidtProcessTest {
    
    private final GramSchmidtProcess<Double, Double, Double> process = 
            new GramSchmidtProcess<>(new RealVectorInnerProduct(),
                                     new RealVectorDivisible(),
                                     new RealVectorProductByScalar(),
                                     new RealVectorAdditive(),
                                     new RealVectorNegative());
    
    @Test(expected = NullPointerException.class) 
    public void testThrowsNullPointerExceptionOnNullBasis() {
        process.process(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testThrowsIllegalArgumentExceptionOnNoVectors() {
        process.process();
    }
    
    @Test
    public void testReturnsSingleVectorWhenBasisContainsOnlyOneVector() {
        Vector<Double> vec = new Vector<>(1.0, 2.2, 3.0);
        Vector<Double>[] result = process.process(vec);
        assertEquals(1, result.length);
        assertEquals(vec, result[0]);
    }
    
    @Test(expected = IllegalArgumentException.class) 
    public void
         testThrowsIllegalArgumentExceptionWhenFirstVectorHasDimensionZero() {
        Vector<Double> v1 = new Vector<>();
        Vector<Double> v2 = new Vector<>(1.0);
        process.process(v1, v2);
    }
         
    @Test(expected = IllegalArgumentException.class) 
    public void 
        testThrowsIllegalArgumentExceptionWhenAnotherVectorHasDimensionZero() {
        Vector<Double> v1 = new Vector<>(1.0);
        Vector<Double> v2 = new Vector<>();
        process.process(v1, v2);
    }
        
    @Test(expected = IllegalArgumentException.class) 
    public void testThrowsIllegalArgumentExceptionWhenDimensionalityMismatch() {
        Vector<Double> v1 = new Vector<>(1.0);
        Vector<Double> v2 = new Vector<>(2.0, 3.0);
        process.process(v1, v2);
    }
    
    @Test
    public void testValidInput1() {
        Vector<Double> v1 = new Vector<>(1., 1., 1.);
        Vector<Double> v2 = new Vector<>(1., 0., 1.);
        Vector<Double> v3 = new Vector<>(3., 2., 3.);
        Vector<Double>[] orthogonalBasis = process.process(v1, v2, v3);
        assertTrue(Demo.basisIsOrthogonal(orthogonalBasis, 0.001));
        for (Vector<Double> vec : orthogonalBasis) {
            System.out.println(vec);
        }
    }
}

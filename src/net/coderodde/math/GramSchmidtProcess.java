package net.coderodde.math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * This class implements the method for running 
 * <a href="">https://en.wikipedia.org/wiki/Gram%E2%80%93Schmidt_process</a>
 * over a given independent basis of a linear space.
 * 
 * @param <VCT> the vertex component type.
 * @param <IPT> the inner product type.
 * @param <FT>  the division result type.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (May 17, 2019)
 */
public class GramSchmidtProcess<VCT, IPT, FT> {

    /**
     * This object is responsible for computing the inner product of two 
     * vectors.
     */
    private InnerProduct<VCT, IPT> innerProduct;
    
    /**
     * This object is responsible for computing division.
     */
    private Divisible<IPT, FT> divisible;
    
    /**
     * This object is responsible for computing products (multiplication).
     */
    private Product<FT, Vector<VCT>, Vector<VCT>> product;
    
    /**
     * This object is responsible for computing addition.
     */
    private Additive<Vector<VCT>> additive;
    
    /**
     * This object is responsible for computing negative elements.
     */
    private Negative<Vector<VCT>> negative;
    
    /**
     * Constructs the object with the method for running Gram-Schmidt process 
     * over given basis.
     * 
     * @param innerProduct the object for computing inner products.
     * @param divisible    the object for performing division.
     * @param product      the object for performing multiplication.
     * @param additive     the object for performing addition.
     * @param negative     the object for computing inverses.
     */
    public GramSchmidtProcess(InnerProduct<VCT, IPT> innerProduct,
                              Divisible<IPT, FT> divisible,
                              Product<FT, Vector<VCT>, Vector<VCT>> product,
                              Additive<Vector<VCT>> additive,
                              Negative<Vector<VCT>> negative) {
        this.innerProduct = 
                Objects.requireNonNull(
                        innerProduct,
                        "The input InnerProduct is null.");
        
        this.negative = Objects.requireNonNull(negative,  
                                               "The input Negative is null.");
        
        this.product = Objects.requireNonNull(product, 
                                              "The input Product is null.");
        
        this.divisible = Objects.requireNonNull(divisible, 
                                                "The input Divisible is null.");
        
        this.additive = Objects.requireNonNull(additive,
                                               "The input Additive is null.");
    }
    
    /**
     * Performs the Gram-Schmidt process upon {@code basis}.
     * 
     * @param basis the basis to process.
     * @return the orthogonal basis.
     */
    public Vector<VCT>[] process(Vector<VCT>... basis) {
        // Validate the input basis:
        checkBasis(basis);
        
        // Deal with the very first base element:
        Vector<VCT>[] orthogonalBasis = new Vector[basis.length];
        orthogonalBasis[0] = (Vector<VCT>) new Vector(basis[0]);
        
        // The actual process:
        for (int i = 1; i < basis.length; i++) {
            // Copy-construct 'x' from 'basis[i]':
            Vector<VCT> x = new Vector<>(basis[i]);
            
            // For each basis element before 'x', do:
            for (int j = 0; j < i; j++) {
                // Take the inner product of the divident:
                IPT innerProductDivident = 
                        this.innerProduct.innerProductOf(x, basis[j]);
                
                // Take the inner product of the divisor:
                IPT innerProductDivisor = 
                        this.innerProduct.innerProductOf(orthogonalBasis[j],
                                                         orthogonalBasis[j]);
                
                // Divide the divident by divisor:
                FT fraction = divisible.divide(innerProductDivident,
                                               innerProductDivisor);
                
                // Multiply the above by the current basis:
                Vector<VCT> term = product.multiply(fraction, basis[j]);
                
                // Negate the above:
                term = negative.negate(term);
                
                // Add the above to 'x'. Effectively, it subtracts 'term' from
                // 'x' since we have negated 'term':
                x = additive.add(x, term);
            }
            
            orthogonalBasis[i] = x;
        }
        
        return removeDuplicates(orthogonalBasis);
    }
    
    /**
     * This method validates the input data sent to the Gram-Schmidt process
     * implementation above.
     * 
     * @param <E>            the element component type.
     * @param basisCandidate the basis candidate.
     * @throws IllegalArgumentException if the candidate is not valid.
     */
    private static <E> void checkBasis(Vector<E>[] basisCandidate) {
        // Check not null:
        Objects.requireNonNull(basisCandidate, "The input basis is null.");
        
        // Check is not empty:
        if (basisCandidate.length == 0) {
            throw new IllegalArgumentException("No vectors given.");
        }
        
        int expectedDimensions = basisCandidate[0].getNumberOfDimensions();
        
        // Each element in the basis candidate must have the same 
        // dimensionality:
        if (expectedDimensions == 0) {
            throw new IllegalArgumentException(
                    "The element at index 0 has no components.");
        }
        
        for (int i = 1; i < basisCandidate.length; i++) {
            if (basisCandidate[i].getNumberOfDimensions() == 0) {
                // Oops. An empty element:
                throw new IllegalArgumentException(
                        "The element at index " + i + " has no components.");
            }
            
            if (expectedDimensions
                    != basisCandidate[i].getNumberOfDimensions()) {
                // Oops. Not all basis elements are of the same equal 
                // dimensionality:
                throw new IllegalArgumentException(
                    "Element dimension mismatch: expected " +
                            expectedDimensions + " but was " + 
                            basisCandidate[i].getNumberOfDimensions() +
                            " at index " + i + ".");
            }
        }
    }
    
    private static <E> Vector<E>[] removeDuplicates(Vector<E>[] basis) {
        Set<Vector<E>> set = new HashSet<>(Arrays.asList(basis));
        Vector<E>[] vectors = new Vector[set.size()];
        return set.toArray(vectors);
    }
}

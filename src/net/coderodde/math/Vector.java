package net.coderodde.math;

import java.util.Arrays;
import java.util.Objects;

/**
 * This class implements a vector/element in a {@code n}-dimensional space.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (May 17, 2019)
 */
public final class Vector<E> {

    /**
     * The actual vector contents.
     */
    private final E[] components;

    /**
     * Constructs the vector from the given data.
     * 
     * @param components the vector data.
     */
    public Vector(E... components) {
        Objects.requireNonNull(components, "The input vector is null.");
        this.components = Arrays.copyOf(components, components.length);
    }

    /**
     * Copy-constructs this vector.
     * 
     * @param vector the vector to copy.
     */
    public Vector(Vector<E> vector) {
        this.components = Arrays.copyOf(vector.components, 
                                        vector.components.length);
    }

    /**
     * Returns the {@code index}th component of this vector.
     * 
     * @param index the component index.
     * @return the value of the {@code index}th component.
     */
    public E get(int index) {
        return components[index];
    }

    /**
     * Sets the value of the {@code index}th vector component to the given 
     * value. 
     * 
     * @param index the index of the target vector component.
     * @param value the value to set.
     */
    public void set(int index, E value) {
        components[index] = value;
    }

    /**
     * Returns the number of components in this vector.
     * 
     * @return the number of components in this vector.
     */
    public int getNumberOfDimensions() {
        return components.length;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String separator = "";

        for (E component : components) {
            stringBuilder.append(separator);
            separator = ", ";
            stringBuilder.append(component);
        }
        return stringBuilder.append(">").toString();
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(components);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (o == this) {
            return true;
        }

        if (!o.getClass().equals(this.getClass())) {
            return false;
        }

        Vector<E> other = (Vector<E>) o;
        return Arrays.equals(components, other.components);
    }
}

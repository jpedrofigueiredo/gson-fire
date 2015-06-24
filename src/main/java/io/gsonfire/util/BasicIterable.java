package io.gsonfire.util;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by julio on 6/23/15.
 */
public final class BasicIterable<T> implements Iterable<T>{

    private final Iterable<T> iterable;

    private BasicIterable(Iterable<T> iterable) {
        this.iterable = iterable;
    }

    @Override
    public Iterator<T> iterator() {
        return iterable.iterator();
    }

    public static <T> BasicIterable<T> of(Iterable<T> iterable) {
        if(iterable == null) {
            throw new NullPointerException("The iterable parameter cannot be null");
        } else {
            return new BasicIterable<T>(iterable);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BasicIterable<?> that = (BasicIterable<?>) o;

        return !(iterable != null ? !iterable.equals(that.iterable) : that.iterable != null);

    }

    @Override
    public int hashCode() {
        return iterable != null ? iterable.hashCode() : 0;
    }

    @Override
    public String toString() {
        return iterable.toString();
    }

    public static <T> BasicIterable<T> of(T... array) {
        return of(Arrays.asList(array));
    }

}

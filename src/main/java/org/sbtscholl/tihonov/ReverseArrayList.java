package org.sbtscholl.tihonov;

import javax.swing.text.Position;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ReverseArrayList<E> extends ArrayList<E> {

    @Override
    public Iterator<E> iterator() {
        return new ReverseIterator<E>();
    }

    /**
     * Iterator with reverse iteration
     * first position this last element
     * next element current position-1;
     * @param <E>
     */
    public class ReverseIterator<E> implements Iterator<E> {
        int position;
        int lastRet;

        ReverseIterator() {
            position = size() - 1;
            lastRet = -1;
        }

        @Override
        public boolean hasNext() {
            return (position > 0);
        }

        @Override
        public E next() {
            int i = position;
            if (i < 0) {
                throw new NoSuchElementException();
            }
            lastRet = i;
            position = i - 1;
            return (E) get(i);
        }
    }
}

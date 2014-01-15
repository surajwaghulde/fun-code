package funEasy;

import java.util.Iterator;

class PeekIterator<T> implements Iterator<T> {
    
    Iterator<T> iterator = null;
    T current = null;
    boolean isPeek = true;
    
    public PeekIterator(Iterator<T> iterator) {
        this.iterator = iterator;
    }
    
    public T peek() {
        if (isPeek) {
            current = iterator.next();
            isPeek = false;
        }
        return current;
    }
    
    public T next() {
        if (isPeek) {
            iterator.next();
        }
        isPeek = true;
        return current;
    }
    
    public boolean hasNext() {
        return iterator.hasNext();
    }
    
    public void remove() {
        
        iterator.remove();
    }
}


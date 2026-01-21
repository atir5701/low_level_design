/*
The iterator Design Pattern is a pattern that provides a standarf way to access
elements of a collection sequentially without exposing its internal structure.

At its core, the Iterator pattern is about separating the logic of how you
move through a collection from the collection itself. Instead of letting
clients directly access internal arrays, lists, or other data structures,
the collection provides an iterator object that handles traversal.

We have 2 components -> Collection and Iterator
4 components :-
1. Iterator - Interface that has a hasNext and next method
2. ConcreteIterator - Implements the Iterator interface and contains ref
   of Collection
3. IterableCollection - Interface that has a createIterator method
4. ConcreteCollection - Implements the IterableCollection
*/

import java.util.ArrayList;
import java.util.List;

interface Iterator<T>{
    boolean hasNext();
    T next();
}

interface IterableCollection<T>{
    Iterator<T> createIterator();
}

class ConcreteCollection implements IterableCollection<String>{
    private final List<String> songs = new ArrayList<>();
    public void addSong(String t){
        songs.add(t);
    }

    public int getSize() {return songs.size();}

    @Override
    public Iterator<String> createIterator(){
        return new ConcreteIterator(this);
    }

    public String getSongAtindex(int index){
        return songs.get(index);
    }
}


class ConcreteIterator implements Iterator<String>{
    private final ConcreteCollection c;
    int index = 0;
    public ConcreteIterator(ConcreteCollection c){
        this.c = c;
    }

    @Override
    public boolean hasNext(){
        return index<this.c.getSize();
    }

    @Override
    public String next(){
        index++;
        return c.getSongAtindex(index);
    }
}

public class Iterator_Pattern {
}

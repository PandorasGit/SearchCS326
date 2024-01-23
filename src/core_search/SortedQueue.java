package core_search;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;


public class SortedQueue<S,A> implements PriorityQueue<S,A>{

    private final SortedSet<Node<S,A>> queue;

    public SortedQueue(Comparator<Node<S,A>> c) {
        this.queue = new TreeSet<>(c);
    }

    public void add(Node<S,A> e){
        queue.add(e);
        //System.out.println(e.getState()+" added");
    }

    public Node<S,A> pop(){
        return queue.removeFirst();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

}

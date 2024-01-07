package HW_13_12_2023;

import java.util.LinkedList;

public class QueueEx<T> implements Queue23<T>{
    private LinkedList<T> queue;

    public QueueEx() {
        this.queue = new LinkedList<>();
    }

    @Override
    public void put(T element) {
        queue.add(element);
    }

    @Override
    public boolean isEmpty() {
       return queue.isEmpty();
    }

    @Override
    public T get() {
        if (!isEmpty()) {
            T obj = queue.getLast();
            queue.removeLast();
            return obj;
        }
        return null;
    }

    @Override
    public T peek() {
        if(!isEmpty()){
            T obj = queue.getFirst();
            queue.removeFirst();
            return obj;
        }
        return null;
    }
}

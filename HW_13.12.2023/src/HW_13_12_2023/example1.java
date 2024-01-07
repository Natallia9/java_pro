package HW_13_12_2023;

import java.util.LinkedList;

class StackImpl<T> implements Stack23<T> {
    private LinkedList<T> stack;

    public StackImpl() {
        this.stack = new LinkedList<>();
    }

    @Override
    public void put(T item) {
        stack.add(item);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public T get() {
        if (!isEmpty()) {
            T obj = stack.getLast();
            stack.removeLast();
            return obj;
        }
        return null;
    }
}

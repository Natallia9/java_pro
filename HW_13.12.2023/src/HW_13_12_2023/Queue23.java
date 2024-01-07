package HW_13_12_2023;

public interface Queue23<T> {
    void put(T element);
    boolean isEmpty();
    T get();
    T peek();
}

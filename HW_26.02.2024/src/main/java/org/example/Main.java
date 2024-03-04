package org.example;

import java.util.ArrayList;
import java.util.List;

import static org.example.Sum.getTotalSum;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 10000; i++) {
            list.add(i);
        }

        Sum t1 = new Sum(list.subList(0, 2500));
        Sum t2 = new Sum(list.subList(2500, 5000));
        Sum t3 = new Sum(list.subList(5000, 7500));
        Sum t4 = new Sum(list.subList(7500, 10000));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        int sumThread = getTotalSum(t1, t2, t3, t4);
        System.out.println("Общая сумма потоков: " + sumThread);

    }
}

class Sum extends Thread {
    List<Integer> list;
    int sum = 0;

    public Sum(List<Integer> list) {
        this.list = list;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public void run() {
        for (int i : list) {
            sum += i;
            System.out.println(sum);
        }
    }

    static int getTotalSum(Sum... threads) {
        int totalSum = 0;
        for (Sum thread : threads) {
            totalSum += thread.getSum();
        }
        return totalSum;
    }
}

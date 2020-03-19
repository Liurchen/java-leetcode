package com.java.leetcode;

import java.util.Locale;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        // write your code here
//        LTC_Tag_Stack solution = new LTC_Tag_Stack();
//        String tree = "9,3,4,#,#,1,#,#,2,#,6,#,#";
//        solution.isValidSerialization(tree);

        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = 100;
        }
        Bank bank = new Bank(a);

        for (int i = 0; i < bank.size(); i++) {
            int from = i;
            Runnable r = () -> {
                try {
                    while (true) {
                        int toAccount = (int) (bank.size() * Math.random());
                        while (toAccount == from) {
                            toAccount = (int) (bank.size() * Math.random());
                        }
                        int amount = (int) (100 * Math.random());
                        bank.transfer(from, toAccount, amount);
                        Thread.sleep((int) (1000 * Math.random()));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            Thread t = new Thread(r);
            t.start();
        }


    }
}

class Bank {

    private int[] accounts;

//    private Lock backLock = new ReentrantLock();

//    private Condition sufficientFunds = backLock.newCondition();

    public Bank(int[] accounts) {
        this.accounts = accounts;
    }

    public int size() {
        return this.accounts.length;
    }

    public void transfer(int from, int to, int amount) throws InterruptedException {
//        backLock.lock();
        System.out.println(Thread.currentThread());
        while (accounts[from] < amount) {
            System.out.println("no sufficient funds!!!!!!!!!!!!!!!!!waiting!!!!!!!!!!!!!!!!!!!");
//                sufficientFunds.await();
//            wait();
        }
        accounts[from] -= amount;
        System.out.printf("from %d to %d %d yuan\n", from, to, amount);
        accounts[to] += amount;
//            sufficientFunds.signalAll();
//        notifyAll();
        System.out.printf("total balance %d\n", this.getTotalBalance());
    }

    private int getTotalBalance() {
        int total = 0;
        for (int amount : accounts) {
            total += amount;
        }
        return total;
    }

}



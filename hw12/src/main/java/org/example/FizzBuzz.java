package org.example;

public class FizzBuzz {
    private int n;
    private int count;

    public FizzBuzz(int n) {
        this.n = n;
        count = 1;
    }

    public synchronized void fizz() throws InterruptedException {
        while (count <= n) {
            if (count % 3 == 0 && count % 5 != 0) {
                System.out.print("fizz, ");
                count++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void buzz() throws InterruptedException {
        while (count <= n) {
            if (count % 5 == 0 && count % 3 != 0) {
                System.out.print("buzz, ");
                count++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void fizzbuzz() throws InterruptedException {
        while (count <= n) {
            if (count % 3 == 0 && count % 5 == 0) {
                System.out.print("fizzbuzz, ");
                count++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void number() throws InterruptedException {
        while (count <= n) {
            if (count % 3 != 0 && count % 5 != 0) {
                System.out.print(count + ", ");
                count++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);

        Thread A = new Thread(() -> {
            try {
                fizzBuzz.fizz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread B = new Thread(() -> {
            try {
                fizzBuzz.buzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread C = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread D = new Thread(() -> {
            try {
                fizzBuzz.number();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        A.start();
        B.start();
        C.start();
        D.start();
    }
}
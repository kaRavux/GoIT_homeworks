package org.example;

public class FirstTask {

    public static void main(String[] args) {
        Thread timeThread = new Thread(new EverySecond());
        Thread messageThread = new Thread(new EveryFiveSeconds());

        timeThread.start();
        messageThread.start();
    }
}

class EverySecond implements Runnable {
    public void run() {
        long startTime = System.currentTimeMillis();

        while (true) {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - startTime;
            System.out.println("Time passed: " + (elapsedTime / 1000) + "s");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class EveryFiveSeconds implements Runnable {

    public void run() {
        while (true) {
            System.out.println("5 seconds passed.");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
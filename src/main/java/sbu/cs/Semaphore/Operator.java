package sbu.cs.Semaphore;

import java.util.concurrent.Semaphore;

public class Operator extends Thread {


    public Operator(String name , Semaphore sem) {
        super(name);
        this.sem = sem;
    }
    Semaphore sem;
    @Override
    public void run() {
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++)
        {
            Resource.accessResource();         // critical section - a Maximum of 2 operators can access the resource concurrently
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sem.release();
    }
}

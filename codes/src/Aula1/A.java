package Aula1;

import java.util.concurrent.Semaphore;

public class A extends Thread{
    private Semaphore mut;

    public A(Semaphore mut){
        this.mut = mut;
    }

    public void run(){
        try {
            mut.acquire();
            System.out.println("inicio da tarefa A: " + Mutex.x);
            Mutex.x = Mutex.x * 30;
            System.out.println("X: " + Mutex.x);
            mut.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

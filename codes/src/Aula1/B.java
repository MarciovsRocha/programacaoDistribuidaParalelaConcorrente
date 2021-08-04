package Aula1;

import java.util.concurrent.Semaphore;

public class B extends Thread{
    private Semaphore mut;

    public B(Semaphore mut){
        this.mut = mut;
    }

    public void run(){
        try {
            mut.acquire();
            System.out.println("inicio da tarefa B: " + Mutex.x);
            Mutex.x = Mutex.x/3;
            System.out.println("X: " + Mutex.x);
            mut.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

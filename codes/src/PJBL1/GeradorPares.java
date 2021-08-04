package PJBL1;

import java.util.concurrent.Semaphore;

public class GeradorPares extends Thread{
    private int contador;
    private Semaphore mutex;

    public GeradorPares(Semaphore mut){
        this.contador = 0;
        this.mutex = mut;
    }

    public void run(){
        try{
            mutex.acquire();

            mutex.release();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}

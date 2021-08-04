package PJBL1;

import java.util.concurrent.Semaphore;

public class GeradorImpares extends Thread{
    private int contador;
    private Semaphore mutex;

    public GeradorImpares(Semaphore mut){
        this.contador = 0;
        this.mutex = mut;
    }

    public void run(){
        try{

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

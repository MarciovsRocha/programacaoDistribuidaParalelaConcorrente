package PJBL1;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class GeradorPares extends Thread{
    private int contador;
    private Chave array;
    private Semaphore mutex;

    public GeradorPares(Chave array, Semaphore mut){
        this.contador = 0;
        this.mutex = mut;
        this.array = array;
    }

    private int getValidTime(Random r){
        int i = r.nextInt(3000);
        while (100 > i){
            i = r.nextInt(3000);
        }
        return i;
    }

    public void run(){
        try{
            Random r = new Random();
            Thread.sleep(getValidTime(r));
            mutex.acquire();
                int par = r.nextInt(8);
                while (0!=(par%2)){
                    par = r.nextInt(8);
                }
            mutex.release();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}

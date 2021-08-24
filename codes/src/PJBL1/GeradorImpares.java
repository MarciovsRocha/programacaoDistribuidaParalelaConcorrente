package PJBL1;

import java.util.Random;
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
            Random r = new Random();
            Thread.sleep(r.nextInt(3000));
            int aux = r.nextInt(9);
            while ((1 > aux) || (aux%2==0)){
                aux = r.nextInt(9);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

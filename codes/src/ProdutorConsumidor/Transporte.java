package ProdutorConsumidor;

import java.util.concurrent.Semaphore;
import java.util.Random;

public class Transporte extends Thread {
        
    private Entrega entrega;
    private Random r = new Random();
    private Semaphore espacoDeEntregasSimultaneas;


    public Transporte(Entrega e, Semaphore espacoDeEntregasSimultaneas) {
        this.entrega = e;
        this.espacoDeEntregasSimultaneas = espacoDeEntregasSimultaneas;
    }

    
    public void run() {
        try {
            // dormir por tempo aleatorio
            System.out.println("Transportando: " + entrega.toString());
            Thread.sleep(r.nextInt(2000));

            // inserir nova Entrega na fila de entregas
            System.out.println("Entrega feita: " + entrega.toString());

            espacoDeEntregasSimultaneas.release();

        } catch (Exception e) { e.printStackTrace(); }
    }

}

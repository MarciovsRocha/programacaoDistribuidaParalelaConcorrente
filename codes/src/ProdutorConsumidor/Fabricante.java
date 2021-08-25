package ProdutorConsumidor;// import java.util.Thread;

import java.util.concurrent.Semaphore;

public class Fabricante extends Thread {
    private String nome;
    private Semaphore askIfCanProduce;
    private Semaphore sayItIsProduced;
    private FilaVenda filaVenda;


    public Fabricante(String nome, Semaphore semaphore1, 
    Semaphore semaphore2, FilaVenda filaVenda) {
        this.nome = nome;
        this.askIfCanProduce = semaphore1;
        this.sayItIsProduced = semaphore2;
        this.filaVenda = filaVenda;
    }

    public void run() {
        try {
            while(true) {
                Thread.sleep(2000);
                askIfCanProduce.acquire();
                    // fabricante remove compra da fila
                    filaVenda.retiraVendaDaFila();
                sayItIsProduced.release();
            }

        } catch(Exception e) {e.printStackTrace();}
    }
}

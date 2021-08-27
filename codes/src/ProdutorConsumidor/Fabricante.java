package ProdutorConsumidor;// import java.util.Thread;

import java.util.concurrent.Semaphore;

public class Fabricante extends Thread {
    private String nome;
    private Semaphore askIfTheresSale;
    private Semaphore saleIsBeingProduced;
    private Semaphore askIfCanProduce;
    private Semaphore sayItsProduced;
    private FilaVenda filaVenda;
    private FilaEntrega filaEntrega;


    public Fabricante(String nome, FilaVenda filaVenda, FilaEntrega filaEntrega,
    Semaphore semaphore1, Semaphore semaphore2, 
    Semaphore semaphore3, Semaphore semaphore4) { 
        this.nome = nome;
        this.filaVenda = filaVenda;
        this.filaEntrega = filaEntrega;
        this.askIfTheresSale = semaphore1;
        this.saleIsBeingProduced = semaphore2;
        this.askIfCanProduce = semaphore3;
        this.sayItsProduced = semaphore4;

    }

    // ver uma venda e criar uma entrega
    

    public void run() {
        try {
            while(true) {
                Thread.sleep(2000);
                askIfTheresSale.acquire();
                askIfCanProduce.acquire();
                    // fabricante remove compra da fila
                    Entrega entrega = filaVenda.retiraVendaDaFila();
                    filaEntrega.insereEntregaNaFila(entrega);
                saleIsBeingProduced.release();
                sayItsProduced.release();

            }

        } catch(Exception e) {e.printStackTrace();}
    }
}

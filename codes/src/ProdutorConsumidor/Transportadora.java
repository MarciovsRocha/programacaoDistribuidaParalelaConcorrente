package ProdutorConsumidor;

import java.util.concurrent.Semaphore;

public class Transportadora extends Thread {
    private String nome;

    private FilaEntrega filaEntrega;
    
    private Semaphore perguntaSeTemProdutoNaFilaDeEntrega;
    private Semaphore espacoDeEntregasSimultaneas;


    public Transportadora(String nome, int maxEntSim,
    FilaEntrega filaEntrega,
    Semaphore semaphore1
    //, Semaphore semaphore2
    ) {
        this.nome = nome;
        this.espacoDeEntregasSimultaneas = new Semaphore(maxEntSim);
        this.filaEntrega = filaEntrega;
        this.perguntaSeTemProdutoNaFilaDeEntrega = semaphore1;
        //this.liberouEspacoNaFilaDeEntrega = semaphore2;
    }


    @Override
    public String toString() {
        return "Transportadora [nome=" + nome + "]";
    }


    public void run() {
        try {
            while(true) {
                espacoDeEntregasSimultaneas.acquire();
                perguntaSeTemProdutoNaFilaDeEntrega.acquire();
                    Entrega entrega = filaEntrega.retiraEntregaDaFila();
                    Transporte transporte = new Transporte(entrega, espacoDeEntregasSimultaneas);
                    transporte.start();
                //liberouEspacoNaFilaDeEntrega.release();
            }

        } catch (Exception e) { e.printStackTrace(); }
    }
}

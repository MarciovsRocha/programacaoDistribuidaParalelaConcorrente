package ProdutorConsumidor;

import java.util.Random;
import java.util.concurrent.Semaphore;


public class Fabricacao extends Thread {

    private Venda venda;
    private String fabricante;
    private int tempoDeFabricacao;
    
    private FilaEntrega filaEntrega;
    private Random r = new Random();

    private Semaphore espacoParaProducao;
    private Semaphore espacoNaFilaDeEntrega;

    
    public Fabricacao(FilaEntrega fe, Venda v, 
    Semaphore espacoParaProducao,
    Semaphore espacoNaFilaDeEntrega
    ) {
        this.filaEntrega = fe;
        this.venda = v;
        this.espacoParaProducao = espacoParaProducao;
        this.espacoNaFilaDeEntrega = espacoNaFilaDeEntrega;
    }


    public void run() {
        try {
            // tempo de fabricação
            System.out.println("Fabricando: " + venda.toString());
            Thread.sleep(r.nextInt(2000));

            // inserir nova Entrega na fila de entregas
            Entrega entrega = venda.transformaEmEntrega();
            filaEntrega.insereEntregaNaFila(entrega);
            System.out.println("produção pronta: " + entrega.toString());

            espacoParaProducao.release();

            // acrescenta espaco à fila de entrega
            espacoNaFilaDeEntrega.release();

        } catch (Exception e) { e.printStackTrace(); }
    }
}

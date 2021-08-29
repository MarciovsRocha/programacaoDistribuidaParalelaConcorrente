package codigo;

import java.util.concurrent.Semaphore;

public class Fabricante extends Thread {
    private String nome;

    private Semaphore espacoParaProducao;
    private Semaphore perguntaSeTemVendaNaFila;
    private Semaphore espacoNaFilaDeEntrega;
    
    private FilaVenda filaVenda;
    private FilaEntrega filaEntrega;


    public Fabricante(String nome, int producaoSimultaneaMaxima,
    FilaVenda filaVenda, FilaEntrega filaEntrega,
    Semaphore vendasNaFila, 
    Semaphore entregasNaFila
    ) { 
        this.nome = nome;
        espacoParaProducao = new Semaphore(producaoSimultaneaMaxima);
        this.filaVenda = filaVenda;
        this.filaEntrega = filaEntrega;
        this.perguntaSeTemVendaNaFila = vendasNaFila;
        this.espacoNaFilaDeEntrega = entregasNaFila;
    }


    @Override
    public String toString() {
        return "Fabricante [nome=" + nome + "]";
    }


    public void run() {
        try {
            while(true) {
                // ver se pode fazer mais uma produção simultânea
                espacoParaProducao.acquire();
                perguntaSeTemVendaNaFila.acquire();
                    // fabricante remove compra da fila
                    Venda venda = filaVenda.retiraVendaDaFila();
                    // cria uma fabricação
                    Fabricacao fabricacao = new Fabricacao(filaEntrega, venda, espacoParaProducao, espacoNaFilaDeEntrega);
                    // inicia fabricação
                    fabricacao.start();
            }

        } catch(Exception e) {e.printStackTrace();}
    }

    
}

package ProdutorConsumidor;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Loja extends Thread {
    private String nome;
    private int idSequencial; // contador de vendas
    private String catalogo[];
    private Semaphore novaVendaEstaNaFila;
    private FilaVenda filaVenda;
    private Random r = new Random();

    
    public Loja(String nome, String cat[],
    FilaVenda filaVenda, FilaEntrega filaEntrega, 
    Semaphore vendasNaFila) {
        idSequencial = 0;
        this.nome = nome;
        this.catalogo = cat;
        this.filaVenda = filaVenda;
        this.novaVendaEstaNaFila = vendasNaFila;
    }


    private Venda novaVenda(String produto) {
        this.idSequencial++;
        return new Venda(nome, String.valueOf(idSequencial) , produto);
    }


    private Venda novaVendaAleatoria() {
        String produtoAleatorio = catalogo[new Random().nextInt(catalogo.length)];
        return novaVenda(produtoAleatorio);
    }


    private int tempoEntreVendas() {
        return r.nextInt(1500-1000)+1000;
    }

    
    // loja insere compra na fila
    public void run() {
        try {
            while(true) {
                // tempo entre vendas
                Thread.sleep(tempoEntreVendas());
                //perguntaSeTemEspacoNaFila.acquire(); // se for 0, trava aqui até aumentar o valor
                    //criar compra e inserir na fila
                    Venda venda = novaVendaAleatoria();
                    filaVenda.insereVendaNaFila(venda);
                    System.out.println("inserido na fila: " + venda.toString());
                novaVendaEstaNaFila.release(); // 
            }

        } catch(Exception e) {e.printStackTrace();}
    }

    
    
}

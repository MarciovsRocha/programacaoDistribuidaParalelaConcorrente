package ProdutorConsumidor;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Loja extends Thread {
    private String nome;
    private int idSequencial; // contador de vendas
    private String catalogo[];
    private Semaphore askIfCanAdd;
    private Semaphore sayItWasAdded;
    private FilaVenda filaVenda;

    
    public Loja(String nome, FilaVenda filaVenda, String cat[],
    Semaphore semaphore1, Semaphore semaphore2) {
        idSequencial = 0;
        this.nome = nome;
        this.filaVenda = filaVenda;
        this.catalogo = cat;
        this.askIfCanAdd = semaphore1;
        this.sayItWasAdded = semaphore2;
    }


    // cria um objeto da classe Venda
    public Venda novaVenda(String produto) {
        this.idSequencial++;
        return new Venda(nome, String.valueOf(idSequencial) , produto);
    }

    
    // loja insere compra na fila
    public void run() {
        try {
            while(true) {
                Thread.sleep(2000);
                askIfCanAdd.acquire();
                    //criar compra e inserir na fila
                    String produtoAleatorio = catalogo[new Random().nextInt(catalogo.length)];
                    filaVenda.insereVendaNaFila(novaVenda(produtoAleatorio));
                sayItWasAdded.release();
            }

        } catch(Exception e) {e.printStackTrace();}
    }

    
    
}

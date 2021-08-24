package ProdutorConsumidor;

import java.util.Random;

public class Loja extends Thread {
    private String nome;
    private static int idSequencial;
    private static String catalogo[];
    private int pedidos;
    private FilaVenda filaVenda;

    
    public Loja(String nome, int pedidos, FilaVenda filaVenda, String cat[]) {
        idSequencial = 0;
        this.nome = nome;
        this.pedidos = pedidos;
        this.filaVenda = filaVenda;
        catalogo = cat;
    }

    public Loja(String nome){
        this.nome = nome;
        this.pedidos = 0;
        this.filaVenda = null; // fix this thing
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
                //criar compra e inserir na fila
                String produtoAleatorio = catalogo[new Random().nextInt(catalogo.length)];
                filaVenda.insereVendaNaFila(novaVenda(produtoAleatorio));

                //filaVenda.insere(p);
            }

        } catch(Exception e) {e.printStackTrace();}
    }

    
    
}

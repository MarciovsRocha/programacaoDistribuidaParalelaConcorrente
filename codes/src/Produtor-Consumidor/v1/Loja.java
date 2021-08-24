import java.io.RandomAccessFile;

public class Loja extends Thread {
    private String nome;
    private static int idSequencial;
    private static String catalogo[];

    
    public Loja(String nome, int pedidos, Fila FilaVenda, String cat[]) {
        idSequencial = 0;
        this.nome = nome;
        this.pedidos = pedidos;
        this.FilaVenda = filaVenda;
        catalogo = cat;
    }


    // cria um objeto da classe Venda
    public Venda novaVenda(String produto) {
        return new Venda(nome,idSequencial++,produto);
    }

    
    // loja insere compra na fila
    public void run() {
        try {
            while(true) {
                Thread.sleep(2000);
                //criar compra e inserir na fila
                String produtoAleatorio = catalogo[new Random().nextInt(catalogo.length)];
                FilaVenda.insereVendaNaFila(novaVenda(produtoAleatorio));

                filaVenda.insere(p);
            }

        } catch(Exception e) {e.printStackTrace();}
    }

    
    
}

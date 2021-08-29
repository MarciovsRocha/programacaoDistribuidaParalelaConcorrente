package ProdutorConsumidor;

public class Venda {
    // nome da loja + numero sequencial fornecido pela loja
    private String id; 
    private String produto;

    
    public Venda(String nomeLoja, String id, String produto) {
        this.id = nomeLoja + id;
        this.produto = produto;
    }


    public Entrega transformaEmEntrega() {
        String idEntrega = this.id;
        String produto = this.produto;
        Entrega entrega = new Entrega(idEntrega, produto);
        return entrega;
    }


    public boolean checarProduto(String produto) {
        return produto.equals(this.produto);
    }


    public int calculaTempoDeFabricacao(String fabricante) {
        String combinacao = fabricante + produto;
        int tempo;
        A 600,1000,400,600,1000,1200,800,1000
        B 200,400,800,1000,1200,1400,600,800
        C 1000,1200,1200,1400,400,600,400,600
        D 400,600,800,1000,600,800,1000,1200
        E 800,1000,200,400,400,600,1200,1400
        F 1400,1600,1000,1200,400,600,800,1000
        G 400,600,1000,1200,1000,1200,600,800
        H 800,1000,600,800,400,600,1200,1400
        }
    }
    

    @Override
    public String toString() {
        return "Venda [id=" + id + ", produto=" + produto + "]";
    }
    

}

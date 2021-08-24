package ProdutorConsumidor;

public class Venda {
    // nome da loja + numero sequencial fornecido pela loja
    private String id; 
    private String produto;

    
    public Venda(String nomeLoja, String id, String produto) {
        this.id = nomeLoja + id;
        this.produto = produto;
    }

}
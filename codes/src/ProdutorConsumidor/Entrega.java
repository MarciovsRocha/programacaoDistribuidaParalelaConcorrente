package ProdutorConsumidor;

public class Entrega {
    private String id;
    private String produto;

    public Entrega(String id, String p) {
        this.id = id;
        this.produto = p;
    }

    @Override
    public String toString() {
        return "Entrega [id=" + id + ", produto=" + produto + "]";
    }

    
}

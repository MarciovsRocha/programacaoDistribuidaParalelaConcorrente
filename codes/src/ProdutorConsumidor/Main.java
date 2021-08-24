package ProdutorConsumidor;

public class Main {
    public static void main(String[] args) {
        String catalogo[] = { "A", "B", "C", "D", "E", "F", "G", "H"};

        FilaVenda filaVenda = new FilaVenda();
        
        Loja loja = new Loja("ProdutorConsumidor.Loja A");

        Fabricante fabricante = new Fabricante();
        
        Transportadora transportadora = new Transportadora();

    }

}

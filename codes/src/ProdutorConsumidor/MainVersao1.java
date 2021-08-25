package ProdutorConsumidor;

import java.util.concurrent.Semaphore;

public class MainVersao1 {
    public static void main(String[] args) {
/*
        String catalogo[] = { "A", "B", "C", "D", "E", "F", "G", "H"};

        FilaVenda filaVenda = new FilaVenda();
        
        Loja loja = new Loja("ProdutorConsumidor.Loja A");

        Fabricante fabricante = new Fabricante();
        
        Transportadora transportadora = new Transportadora();
*/
        Semaphore semaphore1 = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(1);
        // FilaVenda filaVenda = new FilaVenda(semaphore1);
        Venda venda = new Venda("minha Loja","1","NovoProduto");
        // Loja

    }

}

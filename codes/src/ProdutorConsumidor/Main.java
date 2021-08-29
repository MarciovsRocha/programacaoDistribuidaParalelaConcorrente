package ProdutorConsumidor;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        String catalogo[] = { "A", "B", "C", "D", "E", "F", "G", "H"};

        FilaVenda filaVenda = new FilaVenda();
        // semaforo para fila de vendas
        Semaphore vendasNaFila = new Semaphore (0);
        
        FilaEntrega filaEntrega = new FilaEntrega();
        // semaforo para fila de entregas
        Semaphore entregasNaFila = new Semaphore (0);

        Loja loja1 = new Loja("Loja-A", catalogo, filaVenda, filaEntrega, vendasNaFila);
        Loja loja2 = new Loja("Loja-B", catalogo, filaVenda, filaEntrega, vendasNaFila);
        Loja loja3 = new Loja("Loja-C", catalogo, filaVenda, filaEntrega, vendasNaFila);
        Loja loja4 = new Loja("Loja-D", catalogo, filaVenda, filaEntrega, vendasNaFila);
        Loja loja5 = new Loja("Loja-E", catalogo, filaVenda, filaEntrega, vendasNaFila);
        Loja loja6 = new Loja("Loja-F", catalogo, filaVenda, filaEntrega, vendasNaFila);
        Loja loja7 = new Loja("Loja-G", catalogo, filaVenda, filaEntrega, vendasNaFila);
        Loja loja8 = new Loja("Loja-H", catalogo, filaVenda, filaEntrega, vendasNaFila);

        Fabricante fabricante1 = new Fabricante("Fab-A", 4, filaVenda, filaEntrega, vendasNaFila, entregasNaFila);
        Fabricante fabricante2 = new Fabricante("Fab-B", 1, filaVenda, filaEntrega, vendasNaFila, entregasNaFila);
        Fabricante fabricante3 = new Fabricante("Fab-C", 4, filaVenda, filaEntrega, vendasNaFila, entregasNaFila);
        Fabricante fabricante4 = new Fabricante("Fab-D", 4, filaVenda, filaEntrega, vendasNaFila, entregasNaFila);

        Transportadora transportadora1 = new Transportadora("Trp-A", 10, filaEntrega, entregasNaFila);
        Transportadora transportadora2 = new Transportadora("Trp-B", 20, filaEntrega, entregasNaFila);

        loja1.start();
        loja2.start();
        loja3.start();
        loja4.start();
        loja5.start();
        loja6.start();
        loja7.start();
        loja8.start();

        fabricante1.start();
        fabricante2.start();
        fabricante3.start();
        fabricante4.start();
        
        transportadora1.start();
        transportadora2.start();

    }

}


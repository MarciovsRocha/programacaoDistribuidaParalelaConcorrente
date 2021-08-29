package ProdutorConsumidor;

import java.util.ArrayList;

class FilaVenda {

    private static ArrayList<Venda> fila = new ArrayList<Venda>();


    public void insereVendaNaFila(Venda venda) {
        fila.add(venda);
    }

    public Venda retiraVendaDaFila() {
        return fila.remove(0);        
    }

}

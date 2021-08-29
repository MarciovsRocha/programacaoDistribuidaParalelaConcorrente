package ProdutorConsumidor;

import java.util.ArrayList;

public class FilaEntrega {
    ArrayList<Entrega> filaEntrega;

    public FilaEntrega() {
        this.filaEntrega = new ArrayList<Entrega>();
    }

    public void insereEntregaNaFila(Entrega entrega) {
        filaEntrega.add(entrega);
    }

    public Entrega retiraEntregaDaFila() {
        Entrega entregaRetirada = filaEntrega.remove(0);
        return entregaRetirada;
    }
    
}

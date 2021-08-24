import java.util.Thread;

public class Fabricante extends Thread {
    

    public Fabricante() {

    }

    public void run() {
        try {
            while(true) {
                Thread.sleep(2000);
                FilaVenda.retiraVendaDaFila();
            }

        } catch(Exception e) {e.printStackTrace();}
    }
    // fabricante remove compra da fila
}

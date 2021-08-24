package PJBL2;

import java.util.concurrent.Semaphore;

public class Padronizador {
    private Semaphore mutex;
    private char[][] pipeline;

    public Padronizador(Semaphore mutex, char[][] pipeline){
        this.mutex = mutex;
        this.pipeline = pipeline;
    }

}

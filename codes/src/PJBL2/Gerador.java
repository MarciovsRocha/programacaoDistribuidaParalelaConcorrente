package PJBL2;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Gerador extends Thread{
    private char[][] pipeline;
    private Semaphore mutex;
    private char[] key = {
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','x','y','z',
            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','X','Y','Z'};

    public Gerador(Semaphore mutex, char[][] pipeline){
        this.pipeline = pipeline;
        this.mutex = mutex;
    }

    public void run(){
        try{
            mutex.acquire();
            char[] vetor = new char[10];
            for(byte b=0;b<10;b++){
                Random r = new Random();
                vetor[b] = this.key[r.nextInt(this.key.length)];
            }
            mutex.release();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

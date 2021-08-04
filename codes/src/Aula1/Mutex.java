package Aula1;

import java.util.concurrent.Semaphore;

public class Mutex {
    public static int x = 20;
    public static void main(String[] args){
        Semaphore s = new Semaphore(2);
        A exemploDeCodigo1 = new A(s);
        exemploDeCodigo1.start();
        B exemploDeCodigo2 = new B(s);
        exemploDeCodigo2.start();
        System.out.println("Variavel x: " + x);
    }

}

package Aula1.ExemplosCodigoJava;

import java.util.concurrent.*;

public class Teste04 {

	public static void main(String[] args) {

		Semaphore s = new Semaphore( 4 );
		
		for ( int i=0; i<10; i++)
		{
			Tarefa c = new Tarefa(i, s);
			c.start();
		}
	}

}

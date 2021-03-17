package view;

import java.util.concurrent.Semaphore;

import controller.ThreadIngresso;

public class Principal {

	public static void main(String[] args) {
		
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int i = 0; i<300; i++) {
			Thread TIngresso = new ThreadIngresso(i, semaforo);
			TIngresso.start();
		}

	}

}

package controller;

import java.util.concurrent.Semaphore;

public class ThreadIngresso extends Thread {

	private int idPessoa;
	private static int ingressoDisponivel = 100;
	private Semaphore semaforo;

	public ThreadIngresso(int idPessoa, Semaphore semaforo) {
		this.idPessoa = idPessoa;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		boolean verificador = loginSistema();

		if (verificador) {
			verificador = processoCompra();
			if (verificador) {
				try {
					semaforo.acquire();
					validacaoCompra();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					semaforo.release();
				}

			}
		}

	}

	public boolean loginSistema() {
		boolean verificador = true;
		int tempo = (int) ((Math.random() * 1951) + 50);
		
		try {
			sleep(tempo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (tempo > 1000) {
			System.out.println("#" + idPessoa + " -> Timeout");
			verificador = false;
			return verificador;
		}
		System.out.println("#" + idPessoa + " -> Indo para o processo de compra");
		return verificador;
	}

	public boolean processoCompra() {
		boolean verificador = true;
		int tempo = (int) ((Math.random() * 1001) + 2000);
		
		try {
			sleep(tempo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (tempo > 2500) {
			System.out.println("#" + idPessoa + " --> Tempo de sessão esgotado");
			verificador = false;
			return verificador;
		}
		System.out.println("#" + idPessoa + " --> Indo para a validação de compra");
		return verificador;
	}

	public void validacaoCompra() {
		int qtdIngressos = (int)((Math.random()*1.1) + 3);
		
		if(ingressoDisponivel > qtdIngressos) {
			System.out.println("#"+idPessoa+" conseguiu comprar "+qtdIngressos+" ingressos");
			ingressoDisponivel = ingressoDisponivel - qtdIngressos;
			System.out.println("Ainda restam "+ingressoDisponivel+" ingressos.");
		}
		else {
			System.out.println("Não há ingressos disponiveis.");
		}
	}

}

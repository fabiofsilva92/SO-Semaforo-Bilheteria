package controller;

public class ThreadIngresso extends Thread{
	private int idPessoa;
	private static int ingressoDisponivel = 100;
	
	
	public ThreadIngresso(int idPessoa) {
		this.idPessoa = idPessoa;
	}
	
	public boolean loginSistema() {
		boolean verificador = false;
		int tempo = (int)((Math.random()*1951)+50);
		try {
			sleep(tempo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(tempo > 1000) {
			System.out.println("#"+idPessoa+" -> Timeout");
			verificador = true;
			return verificador;
		}
		System.out.println("#"+idPessoa+" -> Indo para o processo de compra");
		return verificador;
	}
	
	public boolean processoCompra() {
		boolean verificador = false;
		int tempo = (int) ((Math.random()*1001)+2000);
		try {
			sleep(tempo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(tempo > 2500) {
			System.out.println("#"+idPessoa+" --> Tempo de sessão esgotado");
			verificador = true;
			return verificador;
		}
		System.out.println("#"+idPessoa+" --> Indo para a validação de compra");
		return verificador;
	}
	
	public void validacaoCompra() {
		
	}

}

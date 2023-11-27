package model.exception;

public class TreinamentoInexistenteException extends RuntimeException {
	
	public TreinamentoInexistenteException(String mensagem) {
		super(mensagem);
	}
}
package model.exception;

public class InstituicaoInexistenteException extends RuntimeException {
	
	public InstituicaoInexistenteException(String mensagem) {
		super(mensagem);
	}
}
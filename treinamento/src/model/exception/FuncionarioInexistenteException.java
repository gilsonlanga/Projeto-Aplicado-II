package model.exception;

public class FuncionarioInexistenteException extends RuntimeException {
	
	public FuncionarioInexistenteException(String mensagem) {
		super(mensagem);
	}
}
package model.exception;

public class CursoInexistenteException extends RuntimeException {
	
	public CursoInexistenteException(String mensagem) {
		super(mensagem);
	}
}
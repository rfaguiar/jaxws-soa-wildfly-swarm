package br.com.knight.estoque.servico;

public class UsuarioNaoAutorizadoException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public UsuarioNaoAutorizadoException(){}
	
	public UsuarioNaoAutorizadoException(String message) {
		super(message);
	}
	
	public UsuarioNaoAutorizadoException(Throwable cause) {
		super(cause);
	}
	
	public UsuarioNaoAutorizadoException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public UsuarioNaoAutorizadoException(String message, Throwable cause, 
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

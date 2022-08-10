package model.exceptions;

public class DomainException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	//
	//isso faz com que a exceção personalizada passe uma mensagem para ela (String msg) e essa mensagem vai ficar armazenada dentro da minha exceção
	public DomainException(String msg) {
		super(msg);
	}
	
}

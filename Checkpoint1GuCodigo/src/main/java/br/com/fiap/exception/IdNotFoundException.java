package br.com.fiap.exception;

public class IdNotFoundException extends Exception {
	public IdNotFoundException() {
		super("Id não encontrado");
	}

	public IdNotFoundException(String message) {
		super(message);
	}
}

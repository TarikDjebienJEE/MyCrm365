package com.miage.crm365.model.service.exception;

public class CustomerColumnNotExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Defult
	 */
	public CustomerColumnNotExistException() {
		super();
	}

	/**
	 *
	 * @param message : exception message
	 */
	public CustomerColumnNotExistException(String message) {
		super(message);
	}

}

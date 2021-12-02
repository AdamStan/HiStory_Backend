package com.adam.stan.clients.exceptions;

public class EmptyBodyException extends RuntimeException {
	private static final long serialVersionUID = 1222732879870695058L;

	public EmptyBodyException(String message) {
        super(message);
    }
}

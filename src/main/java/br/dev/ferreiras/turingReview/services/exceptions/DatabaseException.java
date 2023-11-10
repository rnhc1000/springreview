package br.dev.ferreiras.turingReview.services.exceptions;

import java.io.Serializable;

public class DatabaseException extends Throwable implements Serializable {

	private static final long serialVersionUID = 1L;

	public DatabaseException(String msg) {
		super(msg);
	}

}

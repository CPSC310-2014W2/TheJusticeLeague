package com.google.gwt.cs310project.crimemapper.client;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FailedToRetrieveDataException extends RuntimeException implements Serializable {

	public FailedToRetrieveDataException() {
		super();
	}

	public FailedToRetrieveDataException(String message) {
		super(message);
	}

}
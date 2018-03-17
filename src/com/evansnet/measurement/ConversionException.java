package com.evansnet.measurement;

public class ConversionException extends Exception {

	private static final long serialVersionUID = 1L;

	public ConversionException(String s) throws Exception {
		throw new Exception(s);
	}
}

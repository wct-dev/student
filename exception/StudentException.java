package com.briup.exception;

public class StudentException extends RuntimeException {
	/**
	 * 自定义异常
	 */
	private static final long serialVersionUID = 1L;

	public StudentException() {
	}

	public StudentException(String msg) {
		super(msg);
	}
}

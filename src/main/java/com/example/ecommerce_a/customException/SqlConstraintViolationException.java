package com.example.ecommerce_a.customException;

/**
 * SQLの制約違反があった場合に投げられる例外
 * 
 * @author mikami
 *
 */
public class SqlConstraintViolationException extends Exception {

	private static final long serialVersionUID = 1L;

	public SqlConstraintViolationException() {
	}

	public SqlConstraintViolationException(String message) {
		super(message);
	}

}

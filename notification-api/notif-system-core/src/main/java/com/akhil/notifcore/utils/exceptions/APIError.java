/**
 * 
 */
package com.akhil.notifcore.utils.exceptions;

/**
 * @author akhil
 *
 */
public class APIError {

	private String errorCode;
	private String error;

	public APIError() {

	}

	public APIError(String errorCode, String error) {
		this.errorCode = errorCode;
		this.error = error;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}

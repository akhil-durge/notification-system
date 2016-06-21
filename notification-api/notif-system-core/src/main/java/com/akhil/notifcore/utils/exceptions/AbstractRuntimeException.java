/**
 * 
 */
package com.akhil.notifcore.utils.exceptions;

import java.util.Map;

import javax.ws.rs.core.Response;

/**
 * @author akhil
 *
 */
public abstract class AbstractRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Map<String, String> errorMap;

	public Map<String, String> getErrorMap() {
		return errorMap;
	}

	public void setErrorMap(Map<String, String> errorMap) {
		this.errorMap = errorMap;
	}

	abstract public Response.Status getStatus();
}

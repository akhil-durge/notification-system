/**
 * 
 */
package com.akhil.notifcore.utils.exceptions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.core.Response;

/**
 * @author akhil
 *
 */
public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, String> errorMap;

	public ServiceException(Map<String, String> errorMap) {
		super();
		this.setErrorMap(errorMap);
	}

	public Map<String, String> getErrorMap() {
		return errorMap;
	}

	public void setErrorMap(Map<String, String> errorMap) {
		this.errorMap = errorMap;
	}

	public Response.Status getStaus() {
		return Response.Status.INTERNAL_SERVER_ERROR;
	}
	 public List<APIError> getErrorList() {
	        List<APIError> tmpErrorList = new ArrayList<APIError>();
	        if (errorMap != null) {
	            Iterator<Entry<String, String>> it = errorMap.entrySet().iterator();
	            while (it.hasNext()) {
	                Map.Entry<String, String> value = (Map.Entry<String, String>) it.next();
	                APIError error = new APIError();
	                error.setErrorCode(value.getKey());
	                error.setError(value.getValue());
	                tmpErrorList.add(error);
	            }
	        }
	        return tmpErrorList;
	    }
	@Override
	public String getMessage() {
		if (getErrorMap() != null) {
			return getErrorMap().toString();
		}
		return super.getMessage();
	}
}

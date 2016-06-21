/**
 * 
 */
package com.akhil.notifcore.utils.exceptions.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import com.akhil.notifcore.utils.exceptions.ServiceException;

/**
 * @author akhil
 *
 */
public class ServiceExceptionMapper implements
		ExceptionMapper<ServiceException> {

	@Override
	public Response toResponse(ServiceException exception) {
		return Response.status(exception.getStaus())
				.entity(exception.getErrorList()).build();
	}

}

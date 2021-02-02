package com.flipkart.validator;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
 
/**
 * 
 * @author JEDI-03
 * Class for Application Exception Mapper
 *
 */
@Provider
public class ApplicationExceptionMapper implements ExceptionMapper<Exception> {
 
	/**
	 * Method to return Response
	 * @param exception
	 * @return Response Object
	 */
    public Response toResponse(Exception e) {
        return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
                .type(MediaType.TEXT_PLAIN)
                .entity(e.getMessage())
                .build();
    }
}
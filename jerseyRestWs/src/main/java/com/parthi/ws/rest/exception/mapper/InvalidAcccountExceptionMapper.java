package com.parthi.ws.rest.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.Status.Family;
import javax.ws.rs.core.Response.StatusType;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.parthi.ws.rest.exception.InvalidAccountTypeException;
@Provider
public class InvalidAcccountExceptionMapper implements ExceptionMapper<InvalidAccountTypeException>{
	@Override
	public Response toResponse(InvalidAccountTypeException exception) {
		StatusType statusType = new StatusType() {
			
			@Override
			public int getStatusCode() {
				return Status.INTERNAL_SERVER_ERROR.getStatusCode();
			}
			
			@Override
			public String getReasonPhrase() {
				return "Invalid Account or AccountType.";
			}
			
			@Override
			public Family getFamily() {
				return Family.CLIENT_ERROR;
			}
		};
		Response response = Response.status(statusType).build();
		System.out.println("Response: "+response.toString());
		return response;
	}
}

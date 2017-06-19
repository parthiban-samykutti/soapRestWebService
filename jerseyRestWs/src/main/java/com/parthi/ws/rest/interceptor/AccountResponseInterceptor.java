package com.parthi.ws.rest.interceptor;

import java.io.IOException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

import com.parthi.ws.rest.AccountUpdate;
@Provider
@AccountUpdate
public class AccountResponseInterceptor implements WriterInterceptor{

	@Override
	public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {
		System.out.println("AccountResponseInterceptor....getPropertyNames: "+context.getPropertyNames());
		context.proceed();
	}

}
package com.parthi.ws.rest.interceptor;

import java.io.IOException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;

import com.parthi.ws.rest.AccountSave;
@Provider
@AccountSave
public class AccountRequestInterceptor implements ReaderInterceptor{

	@Override
	public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {
		System.out.println("AccountRequestInterceptor.....getPropertyNames: "+context.getPropertyNames());		
		return context.proceed();
	}

}
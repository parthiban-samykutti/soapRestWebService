package com.parthi.ws.rest.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class AccountRequestResponseFilter implements ContainerRequestFilter, ContainerResponseFilter{
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("AccountRequestResponseFilter.....method: "+requestContext.getMethod());
		System.out.println("getPropertyNames: "+requestContext.getPropertyNames());
		System.out.println(requestContext.getEntityStream());
	}

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		System.out.println("AccountRequestResponseFilter.....method: "+requestContext.getMethod());
		System.out.println("getPropertyNames: "+requestContext.getPropertyNames());
		System.out.println("getStatusInfo: "+responseContext.getStatusInfo());
		System.out.println("responseContext.getEntity(): "+responseContext.getEntity().toString());
	}

}

package com.parthi.ws.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.parthi.ws.rest.exception.AccountNotFoundException;
import com.parthi.ws.rest.exception.InvalidAccountTypeException;
import com.parthi.ws.rest.vo.Account;

@Path("/account")
public class AccountResource {
	@Path("/getNumber/{name}")
	@GET
	public String getNumber(@PathParam("name") final String name){
		return "{name:"+name+",number:"+name+"001}";
	}
	@Path("/getNumber")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Account getNumberofQuery(@QueryParam("name") final String name){
		Account account = new Account();
		account.setName(name);
		account.setNumber(12313);
		account.setType("checking");
		return account;
	}
	@Path("/getNumber/{name}/{type}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Account getNumberofQueryParam(@PathParam("name") final String name,@PathParam("type") final String type){
		Account account = new Account();
		account.setName(name);
		account.setNumber(123132);
		account.setType(type);
		return account;
	}
	@Path("/saveAccount")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@AccountSave
	public Account saveAccount(@FormParam(value="name") String name,@FormParam(value="type") String type){
		Account account = new Account();
		account.setName(name);
		account.setNumber(123132);
		account.setType(type);
		return account;
	}
	@Path("/updateAccount")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@AccountUpdate
	public Account updateAccount(@Context UriInfo uriInfo) throws InvalidAccountTypeException{
		System.out.println("updateAccount.....");
		
		Account account = new Account();
		account.setName(uriInfo.getQueryParameters().getFirst("name"));
		if(uriInfo.getQueryParameters().getFirst("number") != null)
			account.setNumber(Integer.parseInt(uriInfo.getQueryParameters().getFirst("number")));
		account.setType(uriInfo.getQueryParameters().getFirst("type"));
		if(uriInfo.getQueryParameters().getFirst("type") == null || uriInfo.getQueryParameters().getFirst("type").isEmpty() || uriInfo.getQueryParameters().getFirst("type").startsWith("in")){
			throw new InvalidAccountTypeException("Invalid AccountType.");
		}
		return account;
	}
	@Path("/deleteAccount")
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteAccount(@QueryParam("number") String number) throws AccountNotFoundException{
		System.out.println("deleteAccount.....");
		Response response = null;
		if(number == null || number.startsWith("4") || number.isEmpty()){
			throw new AccountNotFoundException();
		}else{
			response = Response.ok(number+" is deleted!").build();
		}
		return response;
	}
}

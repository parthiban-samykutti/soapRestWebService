package com.parthi.spring.ws.rest.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

@RunWith(Parameterized.class)
public class RestControllerTest {
	private String url;
	public RestControllerTest(final String url){
		this.url = url;
	}
	@Parameters
	public static List<Object[]> balanceRates() {
		return Arrays.asList(new Object[][] {
				{"http://localhost:8080/springRestWsSecurity/account/restController/getAccountDetail.rs?accountName=sav"},
				{"http://localhost:8080/springRestWsSecurity/account/restController/getAccount.rs?accountName=sav"},
				{"http://localhost:8080/springRestWsSecurity/account/restController/getName.rs?accountName=sav"},
				{"http://localhost:8080/springRestWsSecurity/account/restController/get.rs?accountName=sav"}
		});
	}
	RestTemplate restTemplate;
	@Test
	public void testGetAccountDetail(){
		restTemplate = new RestTemplate();
		String response = restTemplate.execute(url, HttpMethod.GET, new RequestCallback() {
			
			@Override
			public void doWithRequest(final ClientHttpRequest request) throws IOException {
				request.getHeaders().add("userName", "parthiban");
				request.getHeaders().add("password", "parthi");
				request.getHeaders().add(HttpHeaders.ACCEPT, MediaType.APPLICATION_XML_VALUE);
				request.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE);
			}
		}, new ResponseExtractor<String>() {

			@Override
			public String extractData(ClientHttpResponse response) throws IOException {
				
				return response.getStatusText();
			}
			
		});
		System.out.println("response: "+response);
	}
}

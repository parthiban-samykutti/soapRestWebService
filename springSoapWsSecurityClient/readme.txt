Errors:
Case 1: No SecurityHeaders/proper authentication handler passed along with request. 
org.springframework.ws.soap.client.SoapFaultClientException: 
	com.sun.xml.wss.XWSSecurityException: Message does not conform to configured policy [ AuthenticationTokenPolicy(S) ]:  
		No Security Header found; nested exception is com.sun.xml.wss.XWSSecurityException: com.sun.xml.wss.XWSSecurityException: 
			Message does not conform to configured policy [ AuthenticationTokenPolicy(S) ]:  No Security Header found
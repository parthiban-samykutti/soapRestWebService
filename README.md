# soapRestWebService
Webservice codebases created for SOAP and SOAP attachments, JAXWS, JAXWS attachments, Jersey Resy Ws, Jersey client, Rest Client, SOAP Ws Security, SOAP WS Security client.

This repository has working examples for JAXWs, Jersey REST Ws, REST Client, JAXWs with attachments, Spring with JAX WS, Spring based REST service with Spring Security, Sping based SOAP webservice, Spring based SOAP Ws Security client. All the codebases are tested in the Tomcat 8 Appserver.

Few URLs to access the services after deployed it to App server with port 8080.

URL to access the services in jerseyRestWs:
http://localhost:8080/jerseyRestWs/
http://localhost:8080/jerseyRestWs/testAccount.jsp
http://localhost:8080/jerseyRestWs/webresources/account/getNumber/parthiban
http://localhost:8080/jerseyRestWs/webresources/account/getNumber/parthiban/checking

Interceptor & Filters are added
Request(Read) Interceptor is designed for Name binder with value @AccountSave
Response (write) Interceptor is designed for Name binder with value @AccountUpdate

ExceptionMapper is used to map the exceptions to create the response with error code and messages.

JAX-WS + Spring integration example

http://localhost:8080/springJaxWs/account/getAccountDetails?wsdl

http://localhost:8080/springJaxWs/account/getAccountDetails?xsd=1

http://localhost:8080/springJaxWs/account/getAccountDetails




Reason why Spring-WS only supports Contract First approach,
http://docs.spring.io/spring-ws/site/reference/html/why-contract-first.html

This project has the interceptors (PayloadLoggingInterceptor, SoapEnvelopeLoggingInterceptor) configured to log the payload and envelops.

This project has the interceptors (PayloadValidatingInterceptor) configured to validate request/response messages based on XSD.

This project configures SoapFaultMappingExceptionResolver to handle the exceptions. 

It uses the xjc (jaxb schema to java) plugin to generate the java classes into the package com.parthi.ws.soap.spring.vo.

We shall generate the java classes from the xsd file by using the below command (xjc),
C:\Users\ps242\OSJArch7\jdk1.8.0_66\bin>xjc  -p com.parthi.ws.soap.spring.vo -d C:\data\codebase\ws\soapRest\springSoapWs\src\main\java C:\data\codebase\ws\soapRest\springSoapWs\src\main\resources\getAccountDetails.xsd

This project build file has the plugin (jaxb2) to generate the java classes from the xsd file.

After deploying the application, WSDL can be accessible from,
http://localhost:8080/springSoapWs/ws/accountService.wsdl

Keep remember that the "localPart" attribute used in the @PayloadRoot annotation should be equivalent to the XML root element name in the request object 


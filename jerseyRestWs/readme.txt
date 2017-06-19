
URL to access the services:
http://localhost:8080/jerseyRestWs/
http://localhost:8080/jerseyRestWs/testAccount.jsp
http://localhost:8080/jerseyRestWs/webresources/account/getNumber/parthiban
http://localhost:8080/jerseyRestWs/webresources/account/getNumber/parthiban/checking

Interceptor & Filters are added
Request(Read) Interceptor is designed for Name binder with value @AccountSave
Response (write) Interceptor is designed for Name binder with value @AccountUpdate

ExceptionMapper is used to map the exceptions to create the response with error code and messages.

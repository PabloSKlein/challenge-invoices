# challenge-invoices

Notes:
* I wasn't able to implement the mock for the client in the spring application context, I'm used to do this kind of implementation on test enviromentes using Wiremock or Mockito.
* I did some test to show the mock and application working, hope it is fine.
* To test the applications apis runing I used the Swagger to provide a easy interface. http://localhost:8080/swagger-ui.html (But the post will always fail because the integration is not mocked, should work fine if you comment the line 28 of InvoiceService file)
* To store the invoices I used the H2 database, whitch is a in memory database.

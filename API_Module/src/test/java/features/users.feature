Feature: User feature

  Background:

    * url BaseURL
    * def random_string =
	"""
		function(s){
			var text = "";
			var pattern = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
			for(var i=0; i<s; i++)
				text += pattern.charAt(Math.floor(Math.random() * pattern.length()));
				return text;
		}
	"""
    * def random_phone =
	"""
		function(s){
			var phone = "";
			var pattern = "0123456789";
			for(var i=0; i<s; i++)
				phone += pattern.charAt(Math.floor(Math.random() * pattern.length()));
				return phone;
		}
	"""
    * def randomString = random_string(6)
    * print randomString
    * def randomPhone = random_phone(10)
    * def requestPayload =
    """
       {
        "firstName": "ECloud1",
        "lastName": "Testing",
        "mobilePhone": "(767) 676-7676",
        "email": "ecloud@gmail.com",
        "roleID": 3,
        "managerID": null,
        "contractorID": null
        }
    """
      * set requestPayload.email = randomString + "@gmail.com"
      * set requestPayload.firstName = "ECloud" + randomString
      * set requestPayload.mobilePhone = randomPhone
      * print requestPayload


  Scenario: Get User scenario
    * def request_headers = {Connection:'keep-alive',Authorization:'Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IjRXUmJTenR2R21JS2FaRTV6V3F6cyJ9.eyJnaXZlbl9uYW1lIjoiRWNsb3VkIiwiZmFtaWx5X25hbWUiOiJUZXN0aW5nIiwibmlja25hbWUiOiJ0ZXN0aW5nK3BmMiIsIm5hbWUiOiJFY2xvdWQgVGVzdGluZyIsInBpY3R1cmUiOiJodHRwczovL3MuZ3JhdmF0YXIuY29tL2F2YXRhci83MmJhNjJkNWQzZjhlZDYzMTAzYjBiMTM3MjViMzcwMj9zPTQ4MCZyPXBnJmQ9aHR0cHMlM0ElMkYlMkZjZG4uYXV0aDAuY29tJTJGYXZhdGFycyUyRmV0LnBuZyIsInVwZGF0ZWRfYXQiOiIyMDIyLTA4LTA1VDE3OjM2OjQ5LjYwNVoiLCJlbWFpbCI6InRlc3RpbmcrcGYyQGVjbG91ZG1zLmNvbSIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJpc3MiOiJodHRwczovL2F1dGgucWEucHJvZnVuZC5uZXQvIiwic3ViIjoiYXV0aDB8NTZlZGFhMTctOTUxOS00MDAwLTk2OGEtNTU5MTU1MzEzZDY3IiwiYXVkIjoiMmJLMVJBVE1qNDFOaFRHM1JuWXFiVUwyRndXeGl1alciLCJpYXQiOjE2NTk3OTQyNTIsImV4cCI6MTY1OTgzMDI1Miwibm9uY2UiOiJRazFyVTFjNWQzRXlPV2hhYVdwSFNVZG5jRXRtV0V4dE1sWmtmbWQ0TGtNME9YSm1OMk5ZUlhCc0xRPT0ifQ.eg_HAdRK3J8D3HQz9gb6iUlC-m503xYmlwyKzGKoQVbt4HrlbJsywzFhtld_foj1Ued6nEE-fxw6SZaxlcRQLsK4I0A1X-cKY1SqQCElylTDZGa9ayBmYdMhqaR_zIUwpljHnjOZmaJU_QzTEcylK6abiJduTOOmdnS7hFB2tnSRBCVhJi0-0j-taKXPM9PnnMngSt16RQiIbILOydBocFjNsusk6TXrHTh_dJXXupRT7Ez6GZMBt5oVO3Zxde0avI_U3cG4fMjrldCq5FzgJ6vGJBKDsDrU6IOsjzqCViheKuLr-zGdMgMOKLXopEiBP3X_Cbdy5ZXM0zfuIeEzoA'}
    Given headers request_headers
    When url BaseURL+'/users'
    And path '2b002881-0b4c-4b92-9feb-fd6d141e9fa1'
    When method GET
    Then status 200
    * print response

  Scenario: Add User scenario
    * def request_headers = {Content-Type:'application/json',Connection:'keep-alive',Authorization:'Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IjRXUmJTenR2R21JS2FaRTV6V3F6cyJ9.eyJnaXZlbl9uYW1lIjoiRWNsb3VkIiwiZmFtaWx5X25hbWUiOiJUZXN0aW5nIiwibmlja25hbWUiOiJ0ZXN0aW5nK3BmMiIsIm5hbWUiOiJFY2xvdWQgVGVzdGluZyIsInBpY3R1cmUiOiJodHRwczovL3MuZ3JhdmF0YXIuY29tL2F2YXRhci83MmJhNjJkNWQzZjhlZDYzMTAzYjBiMTM3MjViMzcwMj9zPTQ4MCZyPXBnJmQ9aHR0cHMlM0ElMkYlMkZjZG4uYXV0aDAuY29tJTJGYXZhdGFycyUyRmV0LnBuZyIsInVwZGF0ZWRfYXQiOiIyMDIyLTA4LTA1VDE3OjM2OjQ5LjYwNVoiLCJlbWFpbCI6InRlc3RpbmcrcGYyQGVjbG91ZG1zLmNvbSIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJpc3MiOiJodHRwczovL2F1dGgucWEucHJvZnVuZC5uZXQvIiwic3ViIjoiYXV0aDB8NTZlZGFhMTctOTUxOS00MDAwLTk2OGEtNTU5MTU1MzEzZDY3IiwiYXVkIjoiMmJLMVJBVE1qNDFOaFRHM1JuWXFiVUwyRndXeGl1alciLCJpYXQiOjE2NTk3OTQyNTIsImV4cCI6MTY1OTgzMDI1Miwibm9uY2UiOiJRazFyVTFjNWQzRXlPV2hhYVdwSFNVZG5jRXRtV0V4dE1sWmtmbWQ0TGtNME9YSm1OMk5ZUlhCc0xRPT0ifQ.eg_HAdRK3J8D3HQz9gb6iUlC-m503xYmlwyKzGKoQVbt4HrlbJsywzFhtld_foj1Ued6nEE-fxw6SZaxlcRQLsK4I0A1X-cKY1SqQCElylTDZGa9ayBmYdMhqaR_zIUwpljHnjOZmaJU_QzTEcylK6abiJduTOOmdnS7hFB2tnSRBCVhJi0-0j-taKXPM9PnnMngSt16RQiIbILOydBocFjNsusk6TXrHTh_dJXXupRT7Ez6GZMBt5oVO3Zxde0avI_U3cG4fMjrldCq5FzgJ6vGJBKDsDrU6IOsjzqCViheKuLr-zGdMgMOKLXopEiBP3X_Cbdy5ZXM0zfuIeEzoA'}
    Given headers request_headers
    And path '/users'
    And request requestPayload
    When method post
    Then status 200
    * print response








    


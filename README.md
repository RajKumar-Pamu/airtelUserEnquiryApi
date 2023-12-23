# airtelUserEnquiryApi

This repository contains a basic structure for a project using Spring Boot with a RESTful API. The project includes two main components:

ApiController: A Spring MVC REST controller responsible for handling incoming requests. It includes an endpoint /users/{msisdn} to fetch user data based on the provided mobile number.

ApiService: A service class that communicates with an external API to retrieve user data. The service uses a RestTemplate to make HTTP requests, and the fetched data is parsed into a CustomResponse object.

CustomResponse: A simple Java class representing the response structure. It includes properties for the user's full name, registration status, and an error message

#Note
Update the configuration file (application.properties or application.yml) with the obtained bearer token.

#Response 
![TestImage](https://github.com/RajKumar-Pamu/airtelUserEnquiryApi/assets/50695791/ec4954de-dc2f-4905-8ae6-a6bb360fea95)


Test Image 



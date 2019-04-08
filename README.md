# jsonspringrest
This application is consuming Json and validates user data using Hibernate validator API. This application consumes User information and returns application-id. Math.random() is used to generate a random application-id. Also UserResponse is generated in service class based on UserRequest and UserResponse is returned with application-id.

Sample Json for the project is attached.

If there are any validation errors then it prompts the client with error details and sends 400 status.

All the validation errors(MethodArgumentNotValidException) are handled in ApplicationRestExceptionHandler class.

Path for the application is /jsonproject/accountCreation.



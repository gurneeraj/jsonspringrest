# jsonspringrest
This project is consuming Json and validate data using Hibernate validator API. Sample Json for the project:
Example:
{
    "requestId": "347",
    "userId": "678",
    "clientId": "492",
    "name": "Gurneeraj Singh",
    "username": "gurneeraj",
    "email": "gurneeraj@gmail.com",
    "address": {
        "street": "Fryent Street",
        "suite": "Suite 786",
        "city": "Calgary",
        "zipcode": "59590-4157"
    },
    "phone": "647-819-5766",
    "website": "gurneeraj.com",
    "company": {
        "name": "XYZ works",
        "catchPhrase": "Best company ever",
        "bs": "car marketing company"
    }
}

Returns on success:
Example:
{
    "requestId": "347",
    "userId": "678",
    "clientId": "492",
    "applicationId": "13",
    "name": "Gurneeraj Singh",
    "username": "gurneeraj",
    "email": "gurneeraj@gmail.com",
    "phone": "647-819-5766"
}

If there are any validation errors then it prompts the client:
Example:
{
    "status": "400",
    "name": "Name is mandatory",
    "address": "Address is mandatory",
    "timestamp": "1554576529993"
}

All the validation exceptions(MethodArgumentNotValidException) are handled in ApplicationRestExceptionHandler class.

Also attached screen-shot of successful completion of different test cases. 

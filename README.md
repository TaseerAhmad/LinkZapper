# LinkZapper
URL shortening REST service.

**Live Demo:** https://link-zapper.herokuapp.com/ (Read API doc before accessing the service)

### 🧰 Built with:

- Spring Boot
- JPA
- PostgreSQL
- Google Guava
- Apache Commons

_______________________________________________________________________________________________________________________________________________________________

### What?
 You guessed it, its a URL shortening REST service!
 
 ### Why?
 I wanted to create a meaningful mini project to learn about REST APIs, Spring Boot and Heroku.
 
 ### How?
 
 The API as of now, only accepts 1 value and generates some value against it and returns the generated value.
 
 **Endpoint:** /url/shorten
 

* **Method**
`POST`
     
     * **Required**
    `longUrl=[PROTOCOL:DOMAIN:TLD]`
    
    - **Data Params**
    { "longUrl":"PROTOCOL:DOMAIN:TLD" }
    
    - **Success Response**
    Code: 200
    Content: { "shortUrl":"ALPHANUMERIC" }
    
    - **Error Response**
    
    Response when the URL is invalid.
  
    - Code: `200`
    - Content: `{"status":400, message:"Malfored or invalid URL", timeStamp: "[Current System Date & Time]" }`
    
    
    
    
    
    
 **Endpoint:** /

* **Method**
`GET`
     
     * **Required**
    `shortUrl=[ALPHANUMERIC]`
    
    - **Data Params**
    { "shortUrl":"ALPHANUMERIC" }
    
    - **Success Response**
    Code: 200
    Content: { "shortUrl":"ALPHANUMERIC" }
    
    - **Error Response**
    Response when the required resource is not found.
    Code: 404
    Content: { "status":404, message:"URL not found", timeStamp: "[Current System Date & Time]" }
    
    
    
    


### To Do:
- Handle global exceptions
- Streamline business logic
- Add authentication to the API
- Implement Redis

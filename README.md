# API Usage Examples

## Authentication

Get a JWT token by sending your credentials:

```bash
curl -X POST http://localhost:8080/authenticate \
    -H "Content-Type: application/json" \
    -d '{"username":"user","password":"password"}'
```

The response will contain your JWT token which you'll need for subsequent requests.

## Chat API

Send a message to the chatbot:

```bash
curl -X GET "http://localhost:8080/chat/message?userMessage=hello" \
    -H "Authorization: Bearer YOUR_JWT_TOKEN_HERE"
```

Replace `YOUR_JWT_TOKEN_HERE` with the actual token received from the authentication endpoint.
## H2 Database Console

Access the embedded H2 database console through your browser:

```
http://localhost:8080/h2-console/
```

Use the following connection settings:
- JDBC URL: `jdbc:h2:mem:chatdb` (or the URL configured in your application)
- Username: 
- Password: 

The console allows you to:
- View database tables
- Execute SQL queries
- Monitor database state during application runtime
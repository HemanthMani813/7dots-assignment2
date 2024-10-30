# Cricket Players API

This project is a Spring Boot application that manages cricket player data, allowing for CRUD operations and querying based on specific criteria.

## Technologies Used

- Java 17
- Spring Boot 2.7.x
- Spring Data JPA
- H2 Database (in-memory)
- Maven


APIs

Initially Data is null
we have to create data to perform API (delete, all ,top10)

1. Create Player Data
Endpoint: POST  http://localhost:8080/api/players

Request Body:

json
{
"name": "hemanth",
"runs": 1000
}


2. Retrieve Top 10 Players Based on Runs
Endpoint: GET  http://localhost:8080/api/players/top



Example Request: GET /api/players/top

Response:

Response: Returns player details that match the specified name.

4. Delete Player
Endpoint: DELETE /api/players/{id}

Path Variable: id (required)

Example Request: DELETE /api/players/1

Response: Returns a success message upon deletion.

5. Retrieve All Players
Endpoint: GET /api/players/all

Response: Returns a list of all players in the database.

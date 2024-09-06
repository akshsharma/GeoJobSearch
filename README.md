# GeoJobSearch

This is a project I worked on during university. It is a indeed style job board that pulls jobs from indeed. I was responsible for the database system and the CI.

## Local Setup

To setup the project locally, you must have [docker](https://www.docker.com/products/docker-desktop/) installed and running on your machine. Once it is setup, run the following command:

```
docker compose up --build
```

This will setup the app and you can access the following addresses on your browser:
- React frontend = http://localhost:3000
- Spring backend = http://localhost:8080/api (add **/docs.html** to access Swagger UI)



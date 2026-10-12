# NASA Space Explorer

A Java Spring Boot application that explores NASA data with a REST API and a simple UI-friendly JSON response layer.

## Features

- Astronomy Picture of the Day (APOD)
- Mars rover photos
- Near-Earth asteroid tracking
- Health check endpoint
- Configurable NASA API key

## Prerequisites

- Java 17+
- Maven 3.9+

## Run locally

1. Clone the repository
2. Set your NASA API key as an environment variable:

   ```bash
   export NASA_API_KEY="your_api_key_here"
   ```

3. Start the app:

   ```bash
   ./mvnw spring-boot:run
   ```

4. Open the app:

   ```text
   http://localhost:8080/api/health
   ```

## Available endpoints

### Health

```bash
curl http://localhost:8080/api/health
```

### APOD

```bash
curl "http://localhost:8080/api/apod?date=2024-05-01"
```

### Mars rover photos

```bash
curl "http://localhost:8080/api/mars-photos?rover=curiosity&sol=1000&camera=RHAZ"
```

### Asteroid data

```bash
curl "http://localhost:8080/api/asteroids?start_date=2024-01-01&end_date=2024-01-07"
```

## Configuration

The application reads the NASA API key from either:

- environment variable: `NASA_API_KEY`
- configuration property: `nasa.api-key`

Example:

```yaml
nasa:
  api-key: ${NASA_API_KEY:}
  base-url: https://api.nasa.gov
```

## License

MIT

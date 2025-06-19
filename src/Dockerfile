# Base image with Maven and Java 17
FROM maven:3.8.3-openjdk-17

# Set working directory
WORKDIR /app

# Copy project files
COPY . /app

# Install any OS-level dependencies WebDriverManager might need
RUN apt-get update && apt-get install -y \
    curl unzip gnupg \
    && apt-get clean

# Build the Maven project (compile code + download dependencies)
RUN mvn clean install -DskipTests

# Run the tests using TestNG
CMD ["mvn", "test"]

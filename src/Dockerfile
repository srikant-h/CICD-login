FROM maven:3.8.1-openjdk-17

RUN apt-get update && apt-get install -y wget unzip curl gnupg \
    && wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb \
    && apt install -y ./google-chrome*.deb \
    && rm google-chrome*.deb

RUN CHROME_VERSION=$(google-chrome --version | cut -d " " -f 3 | cut -d "." -f 1) \
    && wget -q https://chromedriver.storage.googleapis.com/${CHROME_VERSION}.0/chromedriver_linux64.zip \
    && unzip chromedriver_linux64.zip && mv chromedriver /usr/bin/chromedriver && chmod +x /usr/bin/chromedriver

WORKDIR /app
COPY . /app
RUN mvn clean install

CMD ["mvn", "test"]

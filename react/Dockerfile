# 
FROM node:alpine

# Copy package.json and package-lock.json to the image
# We need them to build the dependencies for our project
RUN npm i npm@latest -g
COPY package.json package.json
COPY package-lock.json package-lock.json

# Run `npm ci` to install project dependencies
RUN npm ci

# Run the Google maps API (requires React v16.6)
RUN npm i -S @react-google-maps/api

# Install axios to wait for endpoints
RUN npm install axios

# Install react-router-dom to switch between pages
RUN npm install react-router-dom

# Set environment variables
ENV CI=true
ENV PORT=3000

# Copy the entire project directory to the image
COPY . .

# Default command to start the app
CMD [ "npm", "start" ]
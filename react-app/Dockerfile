FROM node:13.12.0-alpine

# set working directory
WORKDIR /

# add `/app/node_modules/.bin` to $PATH
ENV PATH node_modules/.bin:$PATH

# install app dependencies
COPY package.json .
COPY package-lock.json .
RUN npm install --silent
RUN npm install react-scripts -g --silent
RUN npm install bootstrap react-bootstrap --save

# add app
COPY . .

# start app
ENTRYPOINT ["npm", "start"]
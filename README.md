# Fibonacci App

### Note: JAR. file prepackaged


### Note: please change the IP address for "proxy" in /SA54_Li-Youcheng_fibonacci/react-app/package.json to 
  "proxy": "http://{your IP Address}:8080",


### Build and Run Docker Container for Rest Web Service
1. Move to your CWD to /SA54_Li-Youcheng_fibonacci(root)  
  run -> docker build . -t fib-app    
  run -> docker run -d -p8080:8080 --name fib-deploy fib-app   
  
### Build and Run Docker Container for React App
2. Move yout CWD to /SA54_Li-Youcheng_fibonacci/react-app  
  run -> docker build . -t react-app      
  run -> docker run -d -p3000:3000 --name react-deploy react-app
  
  

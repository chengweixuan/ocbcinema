# OCBCinema (Seat Booking Service)


## This project is now deployed live at:  https://ocbcinema.herokuapp.com/
Note: Heroku apps go to sleep after 1 hour of inacitvity. If live link is slow, please visit [this link](https://ocbcinema-backend.herokuapp.com/ ) to wake backend.  
&nbsp;

### Architecture

* This project is a seat booking service for users to book seats at the fictional but fantastic OCBCinema.
* This project consists of a frontend component developed in Vue.js and a backend component developed in Java.
* Frontend component is developed in Vue.js using the Quasar framework.
* Backend component is developed as a Spring Boot application in Java.


### Description

This repository contains the Java Spring Boot Web Application that runs the REST backend API for OCBCinema.  
A mySQL database is used to store the current seating state.

This Spring Boot Backend is deployed live at:  https://ocbcinema-backend.herokuapp.com/  
Endpoints for backend can be viewed [here](https://ocbcinema-backend.herokuapp.com/swagger-ui.html#/cinema-controller).

Repository for the frontend component is found at: https://github.com/chengweixuan/ocbcinema-front/


### Local Set Up

#### Backend
* Change the address at line 33 of OcbcinemaBackendApplication.java to http://localhost:8070
* Clone this repository and build the maven package
* Run jar file
#### Frontend
* Follow set up instructions at: https://github.com/chengweixuan/ocbcinema-front/

### Security

Spring boot backend access is protected by CORS filtering.  
Only HTTP requests from the frontend application deployed [here](https://ocbcinema.herokuapp.com/) is allowed to pass the CORS filter.

### About

Made by Cheng Weixuan  
GitHub: https://github.com/chengweixuan/

<a> A WIP Jakarta EE based web application for creating and displaying notes </a>

Currently working: \
-signing in and signing up \
-password encryption \
-creating and showing notes \
-sorting 

TODO \
-improve look of the app (priority: fix non centred selection box for sorting) \
-setup error handling (throwing Runtime errors when any inconvenience occurs is not a particularly good idea) \
-add alerts when user inputs wrong username or password (or when registering already used username) \
-add color changing and cancel button in notes editor \
-create tests

I didn't quite know how to use dependency injection in Jakarta EE so I've implemented service classes as singletons \
My css skills are not that great so I've took some inspiration from: https://www.youtube.com/watch?v=KWIM5FuUJ8U

App is designed to be deployed on Tomcat and I'm currently using MySql for a db. Query for creating db can be found in files above \
Authentication is done with Tomcat's realm based container managed security \
I'm using Prepared statements in DAO classes so there should be some protection against XSS attacks

<br />

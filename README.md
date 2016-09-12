Synopsis:
This project exposes a set of subscription and access management API endpoints which maintain user specific subcriptions data.

Code Example:
If your are hosting any subscription based web applciation and you tied up with some third party who is responsible for taking care of 
your accounts which in return trigger a noticfication callback on every user request to your application. Then this project is the right 
place to get to know how to provide the end-points and how to read complex json object and maintain user data in DB and triggered response
in json back to the third party.

API Reference:
localhost:8080/event/notification?url={url}

Instructions:
Below are the libraries which were needed to setup this project:\n
Spring: 3.2.13.RELEASE \n
Hibernate: 3.6.9.Final \n
java: 1.7 \n
Mysql: 5.1.6 \n
Maven 


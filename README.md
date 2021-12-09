# ShortURL
This web app converts a long url into a short url and vice versa

Prerequisites to run the project:
----------------------------------
1. Java 8
2. Eclipse IDE(Any newer version that supports Java EE Project and has inbuilt Maven)
3. Tomcat 9

Steps to run the project and use its services:
------------------------------------------------
1. Create a new workspace in Eclipse
2. Add Tomcat 9 server to the workspace
3. In Eclipse Import Menu, search for option "Projects from Git(with smart import)". 
4. Click next and select Clone URI
5. In the URI enter the github url of the project - https://github.com/akramshuja/ShortURL.git. Also provide the credentials.
6. After the project is imported in the workspace, clean the project by selecting Clean option from the Project menu.
7. Right click on the project, under Maven - click Update Project.
8. The final step is to run it on server. Right click on the project, Run As -> Run on Server. Select Tomcat 9 and say Finish.
9. There are two services that can be accessed from the below URLs:
 i. http://localhost:8080/urlshortener/webapi/shortenUrl/?url=facebook.com/xyz
 This once stores the shorturl in the memory
 ii. http://localhost:8080/urlshortener/webapi/shortenUrlAlt/?url=google.com/hello
 This service stores the url in a text file. The text file is created in the installation folder of Eclipse by the name urlMap.txt

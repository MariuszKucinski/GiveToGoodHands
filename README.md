# GiveToGoodHands
Used technology:
1.Spring/SpringData
2.MySQL
3.Tomcat
4.Hibernate/Hibernate validator
5.Maeven
App uses also lombook library.


When the repository is downloaded you will have to do a few things.
1)Download all needed software bulleted above.
2)Launch your IDE(Intellij UE, eclipse, etc.)
3)Open project as "new project from existing source", check Maven project and "import project from external mode"
4)Conect your IDE with MySQL and create database.
5)In persistence.xml file change username, password and name of your database.
In AppConfig you have to set email address and application password.
6)Configure Tomcat. Application cotext in deployment tab should looks like '/' and artifact should be set on 'war:exploded'
7)Navigate to resources. Open examination.sql and execute all inserts;
8)Launch the application, register and login.

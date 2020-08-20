# virtusaCovidProjectDashboard
# Covid-19 Interactive Dashboard Application 
> An interactive dashboard application that shows live covid-19 Statistics of India in tabular format and in charts. An admin dashboard to source patient data to database, manage it and user-friendly interface for the end users to see the patient reports, their covid status and also apply for covid movement pass.

**This Project runs on server port 8081**

## Use Cases that have been covered

* A landing page that shows the real time Statistics by consuming free API'S like https://api.covid19india.org/data.json in tabular format and charts.
* A use case for admins to add covid patient data to database ie. source the data.
* Admin can also manage the patient data by updating covid status of patient if he is recovered or not and deleting patient if discharged.
* A normal user of the application can seaarch for patient reports and download/share the report.
* They can also apply for an E-pass/ movement pass to travel from one state to another.
* Track the applied E-pass to see if the pass is confirmed or not and go ahead and download the pass.
* System checks internally if a pass is to be allowed or not by comaparing the covid active cases count in both source and destination states making the task of admin easier to issue passes. If the count is above 1 lakh active cases then the pass is denied for travel.
* The user can also check out the statwise covid statistics.

## Spring MVC Architecture 

## Technologies Used:
* Spring boot Application - Useful for creating stand-alone web applications and rapid application development.
* Thymeleaf template - It is a java based library that helps to serve the view layer in MVC- based web application and provides good support for HTML5.
* Spring Data JPA - Provides complete abstraction over the DAO layer. The interface of the DAO is now the only artifact that we need to explicitly define. Spring Data programming model with JPA uses a DAO interface that extends the JPA specific Repository interface – JpaRepository. This will enable Spring Data to find this interface and automatically create an implementation for it. All the basic JPQL queries and methods can be used directly to retreive or save data to MySQL Database.
* MySQL workbench
* Bootstrap 4 - Helps to easily create responsive websites.
* Chart.js - For making reponsive and attractive charts.

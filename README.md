# virtusaCovidProjectDashboard
# Covid-19 Interactive Dashboard Application 
> An interactive dashboard application that shows live covid-19 Statistics of India in tabular format and in charts. An admin dashboard to source patient data to database, manage it and user-friendly interface for the end users to see the patient reports, their covid status and also apply for covid movement pass.

**This Project runs on server 8081**

## Use Cases I have covered

* A landing page that shows the real time Statistics by consuming free API'S like https://api.covid19india.org/data.json in tabular format and charts.
* A use case for admins to add covid patient data to database ie. source the data.
* Admin can also manage the patient data by updating covid status of patient if he is recovered or not and deleting patient if discharged.
* A normal user of the application can seaarch for patient reports and download/share the report.
* They can also apply for a E-pass/ movement pass to travel from one application to another.
* Track the applied E-pass to see if the pass is confirmed or not and go ahead and download the pass.
* System checks internally if a pass is to be allowed or not by comaparing the covid active cases count in both source and destination states making the task of admin easier to issue passes. If the count is above 1 lakh active cases then the pass is denied for travel.
* The user can also check out the statwise covid statistics.




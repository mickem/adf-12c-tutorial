# ADF Tutorial, Part 1: Creating The Model

## 1.0 Create the Application

Create a new application in JDeveloper using the following values.

Keyword           | Application Value
------------------|------------------------------------
Type:             | ADF Fusion Web Application
Application Name: | ADFTutorial
Package Prefix:   | name.medin.tutorial.adf.intro
Maven group id:   | name.medin.tutorial.adf
Maven artifact id:| ADFTutorial
Maven Version:    | 1.0-SNAPSHOT

Keyword           | Model Project                       | View Project
------------------|-------------------------------------|------------------------------------
Name:             | Model                               | ViewController
Technology:       | ADF Business Components             | ADF Faces
Model Package:    | name.medin.tutorial.adf.intro.model | name.medin.tutorial.adf.intro.view

### Instructions

* 1.1 Create the application i JDeveloper
* 1.2 Connect the application to the master git on a private branch from master.

### Questions

* 1.1.	What other ADF Application types exists?
* 1.2.	What's the impact of setting the wrong name/package prefix?
* 1.3.	Why is the maven support in JDeveloper and ADF bad?
* 1.4.	Why do we use ADF Business Components?
* 1.5.	What's the benefit of having the view in a different project?
* 1.6.	What's the impact of changing the maven artifact and group id?

### Setup git

Post-sertup of git is somewhat involved.
* In essence you need to clone the repo (dont create a project/application)
* Create/checkout your local branch
* Manually create the two projects (Model/View)
* Manually create the maven application POM

### Setup git password caching

```
Git:
git config --global credential.helper cache
```

## 2.0 Creating the Model

Import the EMPLOYEES and DEPARTMENTS tables from the HR database.
The database connection is already defined in JDeveloper but not in this application.
Add them to a new Application Module.

Keyword            | Value                                          
-------------------|----------------------------------------------
Database user:     | HR
Database password: | manager
Tables:            | EMPLOYEES, DEPARTMENTS

### Instructions

* 2.1 Create the modle inside JDeveloper

### Questions

* 2.1.	Why do we have application specific connections?
* 2.2.	What's the difference between Entity-based View objects and Query-based view objects?
* 2.3.	What is an application module?
* 2.4.	What does the application module source file contain?
* 2.5.	What do we have now in terms of functionality?

## 3.0 Cleaning up the Model

ADF does a rather good job of a terrible situation. 
There are several relations between Employee and Department but there is no meta information to describe what those relationships are.
Thus we will need to clean up the default relations.

### Instructions
 
* 3.1.	Rename the root DepartmentsView1 to DepartmentsView.
* 3.2.	Rename the root ExmployeesView1 to ExmployeesView.
* 3.3.	Rename the EmployeesView inside the DepartmentsView to: EmployeesInDepartment
* 3.4.	Rename the EmployeeView inside the EmployeesView to: DirectReports
* 3.5.	The final relationship (DepartmentsView) inside EmployeesView we can delete since we will not be working with department managers.
 
### Questions

* 3.1.	How does this affect our code?
* 3.2.	What's the effect of these names are they important?
* 3.3.	Would it be possible to get better names from the database?

## 4.0 Playing with the model

Next up we want to take our model for a spin. Yes we can execute and work with the model as-is without first creating a UI. 
This is I think a very cool feature of ADF-BC.

### Instructions

* 4.1 Click run the Application Module and don't forget the password for the database is manager.
 
### Questions

* 4.1.	Why is this one of the best features of ADF?
* 4.2.	What is not possible to test using this UI?

## 5.0 Building the model

The next step is to turn the database interface into a working usable model. 
Please use the Tester to validate all steps and make sure everything works as expected. 
The *tasks* are described along the lines of user requirements and/or defects and thus only include the end users view. 
You will need to translate that into a proper requirement first.

### Instructions

* 5.1.	The default email address when creating new entries should be firstname.lastname@connecta.se
* 5.2.	The default value for hire date should be the current date (assuming a user is entered on his first day).
* 5.3.	What is employee id? Please remove the field.
* 5.4.	Please add a photo (gravatar) to all users.
* 5.5.	Add a drop down box for the manager when a new user is added.
* 5.6.	Add a drop down for department in the new employee dialog.
* 5.7.	Add a drop down for the job field in the new employee dialog.
* 5.8.	Add a value which shows number of direct reports (DirectReports) by selecting the number of employees which has this employee as manager. 
* 5.9.	Add the ability to quickly filter all employees which is not managers.
* 5.10.	Add the ability to quickly filter all employees which has no direct reports.
* 5.11.	Create a view link to list all employers for each job.
* 5.12.	Add a field which shows the Commission in $ (not %) based on Salary and Commission for the user.

### Hints

* 5.3	The field is required, but can easily be hidden from the user by using the database sequence EMPLOYEE_SEQ.
* 5.4	http://en.wikipedia.org/wiki/Gravatar don?t forget to change one users email to one which has a valid gravtar.
* 5.4	The algorithm can easily be found online as a one-liner.
* 5.5	Think LOV
* 5.7	To do this we need to add the jobs table (as a read-only view).
* 5.7	Don't forget to add it to the application module.
* 5.8	Use a SQL type attribute with a subselect
* 5.8	A good way to work with this is to use the (SQL) Query tab where you can see the query.
* 5.9	Add a view criteria.

### Questions

* 5.1.	Where (Entity object or View) do we put custom attributes and why?
* 5.2.	Where (Entity object or View) do we put default values and why?
* 5.3.	Where (Entity object or View) do we put LOVs and why?
* 5.4.	What's bad about where we placed the code for the id-sequence value?
* 5.5. Do we have any other options for the logic for generating the sequence?
* 5.6.	When do you use the view link?
* 5.8.	When do you use the view accessor?
* 5.8.	What's the difference between a view link and a view accessor?
* 5.9. How could we have avoided adding the View Object for Jobs by hand?
* 5.10. Whats the problem with using Integer?

## 6.0 Validating the model

The next step is to turn the database interface into a working usable model. Please use the Tester to validate all steps and make sure everything works as expected. The ?tasks? are described along the lines of user requirements and/or defects and thus only include the end users view. You will need to translate that into a proper requirement first.

### Instructions

* 6.1	Display the hire date as a date only (not showing the time).
* 6.2	Make sure the error message for setting the salary to value bigger than maximum is: "Salary cannot be higher than X"
* 6.3	Make sure that sallery has to be more then 5000.
* 6.4	Make sure that the email address is a connecta.se address (i.e. michael.medin@connecta.se).
* 6.5	Make sure that for programmers (IT_PROG) salary has to be more than 50000.
* 6.6	Make sure the error message for salary containes the corresponding minimum value.
* 6.7	Make sure that HireDate can only be changed on new entries

### Hints

* 6.1.	Use a SimpleDataFormat string.

### Questions

* 6.1.	Where (Entity object or View) do we put constraints and why?
* 6.2.	Why should you not use the text ?salary? in the error message for the validation rule?
* 6.3.	What should you use instead?


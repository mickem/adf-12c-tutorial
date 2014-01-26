# ADF Tutorial, Part 1: Creating The Model

## 1. Create the Application

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

### Questions

1.	What other ADF Application types exists?
2.	What's the impact of setting the wrong name/package prefix?
3.	Why is the maven support in JDeveloper and ADF bad?
4.	Why do we use ADF Business Components?
5.	What's the benefit of having the view in a different project?
6.	What's the impact of changing the maven artifact and group id?

### Setup git

```
# create project
# exit JDeveloper
cd <project folder>/..
mv <project folder> <project folder>.old
git clone https://github.com/mickem/adf-12c-tutorial.git <project folder>
cd <project folder>
git branch <myname>
#restart jdeveloper
```

### Setup git password caching

```
Git:
git config --global credential.helper cache
```

## 2. Creating the Model

* Import the EMPLOYEES and DEPARTMENTS tables from the HR database.
  The database connection is already defined in JDeveloper but not in this application.
  Add them to a new Application Module.
  
  Keyword            | Value                                          
  -------------------|----------------------------------------------
  Database user:     | HR
  Database password: | manager
  Tables:            | EMPLOYEES, DEPARTMENTS

  Accept default names for everything else.

### Questions

1.	Why do we have application specific connections?
2.	What's the difference between Entity-based View objects and Query-based view objects?
3.	What is an application module?
4.	What does the application module source file contain?
5.	What do we have now in terms of functionality?

## 3. Cleaning up the Model

ADF does a rather good job of a terrible situation. 
There are several relations between Employee and Department but there is no meta information to describe what those relationships are.
Thus we will need to clean up the default relations.
 
* Rename the root DepartmentsView1 to DepartmentsView.
* Rename the root ExmployeesView1 to ExmployeesView.
* Rename the EmployeesView inside the DepartmentsView to: EmployeesInDepartment
* Rename the EmployeeView inside the EmployeesView to: DirectReports
* The final relationship (DepartmentsView) inside EmployeesView we can delete since we will not be working with department managers.
 
### Questions

1.	How does this affect our code?
2.	What's the effect of these names are they important?
3.	Would it be possible to get better names from the database?

## 4. Playing with the model

Next up we want to take our model for a spin. Yes we can execute and work with the model as-is without first creating a UI. 
This is I think a very cool feature of ADF-BC.
Click run the Application Module and don't forget the password for the database is manager.
 
### Questions

1.	Why is this one of the best features of ADF?
2.	What is not possible to test using this UI?

## 5. Building the model

The next step is to turn the database interface into a working usable model. 
Please use the Tester to validate all steps and make sure everything works as expected. 
The *tasks* are described along the lines of user requirements and/or defects and thus only include the end users view. 
You will need to translate that into a proper requirement first.

- The default email address when creating new entries should be firstname.lastname@connecta.se
- The default value for hire date should be the current date (assuming a user is entered on his first day).
- (A) What is employee id? Please remove the field.
- (B) Please add a photo (gravatar) to all users.
- (C) Add a drop down box for the manager when a new user is added.
- (C) Add a drop down for department in the new employee dialog.
- (C,D) Add a drop down for the job field in the new employee dialog.
- (E) Add a value which shows number of direct reports (DirectReports) by selecting the number of employees which has this employee as manager. 
- (F) Add the ability to quickly filter all employees which has no manager.
- (F) Add the ability to quickly filter all employees which has no direct reports.
- Create a view link to list all employers for each job.
- Add a field which shows the Commission in $ (not %) based on Salary and Commission for the user.

### Hints (dont peak)

* HINT A.1: The field is required, but can easily be hidden from the user by using the database sequence EMPLOYEES_SEQ.
* HINT B.1: http://en.wikipedia.org/wiki/Gravatar don?t forget to change one users email to one which has a valid gravtar.
* HINT B.2: The algorithm can easily be found online as a one-liner.
* HINT C.1: Think LOV
* HINT D.1: To do this we need to add the jobs table (as a read-only view).
* HINT D.2: Don't forget to add it to the application module.
* HINT E.1: Use a SQL type attribute with a subselect
* HINT E.2: A good way to work with this is to use the (SQL) Query tab where you can see the query.
* HINT F.1: Add a view criteria.

### Questions

1.	Where (Entity object or View) do we put custom attributes and why?
2.	Where (Entity object or View) do we put default values and why?
3.	Where (Entity object or View) do we put LOVs and why?
4.	What's bad about where we placed the code for the id-sequence value? 
5.	When do you use the view link?
6.	When do you use the view accessor?
7.	What's the difference between a view link and a view accessor?

## 6. Validating the model

The next step is to turn the database interface into a working usable model. Please use the Tester to validate all steps and make sure everything works as expected. The ?tasks? are described along the lines of user requirements and/or defects and thus only include the end users view. You will need to translate that into a proper requirement first.

- Make sure the error message for setting the salary to value bigger than maximum is: ?Salary cannot be higher than X?
- Display the hire date as a date only (not showing the time).
- Makes sure that the email address is a connecta.se address (i.e. michael.medin@connecta.se).
- Make sure that sallery has to be more then 5000.
- Make sure that for programmers (IT_PROG) salary has to be more than 50000.
- Make sure the error message for salary containes the corresponding minimum value.
- Make sure that HireDate can only be changed on new entries

### Hints (dont peak)

* HINT 1: Use a SimpleDataFormat string.

### Questions

1.	Where (Entity object or View) do we put constraints and why?
2.	Why should you not use the text ?salary? in the error message for the validation rule?
3.	What should you use instead?


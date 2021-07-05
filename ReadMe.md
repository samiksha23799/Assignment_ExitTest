### PROJECT TITLE 
ExitTest Web Automation Testing Project On www.redbus.in

### PROJECT DESCRIPTION
The project is based on web automation using Selenium and TestNg framework that consist of 23 test cases.


### USED TOOLS AND FRAMEWORKS
1.Selenium

2.Maven repository

3.TestNG

4.Docker

5.Jenkins Integration


##### Prerequisites

Different ways to run this project.

```
1.Command Prompt Run
2.Eclipse Console Run
3.Batch File
4.Docker Run
```


### GIT REPO

```
https://github.com/samiksha23799/Assignment_ExitTest.git
```

### GETTING STARTED 

##### To run all the test cases

**Option A: Import your project into Eclipse (recommended) **

In Eclipse, go to the File menu and choose:


   - File -> Import... -> Existing Maven Projects into Workspace
  
   - Select the directory containing this file.
  
   - Click Finish.
 

You can now browse the project in Eclipse.

   - Now, right click on the project and go to the Run As
   
   - Click maven clean and then maven install

**Option B: Import your project into Command Prompt **

In command prompt, go to the path where the project is located

   - enter      `mvn clean install`
   
   


   
**Option C: Open the .bat file **




###JENKINS IMPLEMENTATION

Access the WordFile named Jenkins for its implementaion.

###NOTE

##### HEADLESS MODE IMPLEMENTATION

**A**:-To change test in Headless  mode , follow the following steps:

```
For HeadLess Mode:

Step 1.Go to the src/resources/test source folder
Step 2.Open the Properties/config.properties file
Step 3.Change the Headlessoption to True
				if required the headless mode
				else if required the Non-headless mode.
Step 4.Save it.

```


##### DOCKER IMPLEMENTATION
**B**:- To run the testing using Docker, follow the following steps

This changes is in the Project Only

```
For Docker Mode:

Step 1.Go to the src/resources/test source folder
Step 2.Open the Properties/config.properties file
Step 3.Change the DOCKER_RUN to True
				if required the docker mode on
				else if required the normal mode.
Step 4.Save it.
```

Now to run it

```
For Docker Mode:

Step 1.Go to the the project location on cmd
Step 2. Run the command docker-compose up -d
Step 3.And run the project 
Step 4. After the test execution done , run the command docker-compose down
```
##### EXCEL FILE IMPLEMENTATION
**C**:- To update any userInput access the User_Data.xlsx file in ExcelData Folder

```
For Excel File Access:

Step 1.Go to the src/main/resources/ExcelData
Step 2. Open the User_Data.xlsx
Step 3. Update the data accordingly.


```

##### PARALLEL IMPLEMENTATION
**D**:- To run the test in parallel mode, follow the following Steps

```
For Excel File Access:

Step 1.Open the testng.xml file 
Step 2. add  command in the suite tag
         here:-      <suite name="Suite" >
	      add this command:- 	parallel="classes"


```


### src/main/java DESCRIPTION

It consist of 3 packages

**com.redbus.base**-  It consist of the base set up ie. the browser set up to run any test case in local as well as in docker mode.

**com.redbus.pages**- It consist of page action file required to run any test file.

**com.redbus.utils**- It consist of some common utilities file i.e required while testing.

### src/main/resources DESCRIPTION

**ExcelData** - It consist of User_Data.xlsx file for any user input change.

**log4j.properties** - required to generate the logs.


### src/test/java DESCRIPTION

**com.redbus.tests** - It contains all the tests files.

***com.redbus.testUtils** - Some utility files required while testing.


### src/main/resources DESCRIPTION

**Properties** - contains the config.properties file

### FAILEDSCREENSHOTS

Stores all the screenshot when test case failed.

### DRIVERS

It contain all the drivers required to open the browsers like chromedriver, geckodriver etc.

### REPORTS FOLDER

Generate the extent reports for all the test cases.

### LOG FOLDER

Stores all the logs

### RunProject Batch File

Use this to run the project through .bat file




#### AUTHOR NAME

Samiksha Gupta


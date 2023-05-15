# QA Engineer test

### This is a sample project to test APIs using JUnit and RestAssured. In this project you will find the configuration required to write tests for a number of endpoints by Go Rest (https://gorest.co.in/), as well as a sample test class to start with.

##### Requirements:

- Using the already implemented create user endpoint, write a number of tests to cover the functionality of this endpoint
- Implement whatever is required to write tests for the update user endpoint

###### The information required to perform those tasks can be found here -> https://gorest.co.in/. Feel free to update the project in any way you see fit.

# QA Engineer test - GoREST backend test

This project is a test automation framework for testing the create and update user functionalities of a REST API using RestAssured, JUnit 5, and Maven.

## Framework Overview

The project is structured as follows:

* `src/main/java`: Contains the main code of the project, organized in three packages:
    * `Helpers`: Contains classes that provide helper methods to the test cases.
    * `Models`: Contains classes that encapsulate the test data.
    * `Services`: Contains classes that implement the functionalities and requests.
* `src/main/resources`: Contains the configuration file for running the tests.
* `src/test/java`: Contains the test files.
* `pom.xml`: The Maven project object model (POM) file that contains the project configuration information.

## Prerequisites

* Java JDK 11 or higher installed
* Maven installed

## Installation

1. Clone the repository: `git clone https://github.com/tuliobluz/restassured-gorest.git`
2. Navigate to the project directory: `cd pathproject`
3. Install the project dependencies: `mvn install`

## Running the Tests

To run the tests, execute the following command from the project directory:

```
mvn clean test
```

## Generating the Surefire Report

To generate the Surefire report, execute the following command from the project directory:

```
mvn surefire-report:report
```

The report will be generated in the `target/site` directory.

## Configuration

The project uses an `app.properties` file located in the `src/main/resources` directory to configure the `BASE_URL` and `BEARER_TOKEN` values used by the tests. Modify these values according to your needs.

## Test Data

The project uses hardcoded values for the `USER_ID` and `USER_EMAIL` parameters of the tests. Modify these values according to your needs or replace them with dynamically generated values. Assuming the test data will not change or will be provided by a mock service

## GitHub Actions

The project includes a GitHub Actions workflow that runs the tests and generates the Surefire report on every push or pull request. The workflow is defined in the `.github/workflows/tests.yml` file. The Surefire report is uploaded as an artifact and can be accessed from the summary of the workflow run.

## Slack Integration

After running the backend and frontend tests, the GitHub Actions workflow sends a message to Slack channels. Currently, the message is sent only when the job succeeds. In a real scenario, notifications can be sent for both successful and failed jobs.

If you want to join the Slack channel for integration, please use the following invitation link: [Slack Invitation Link](https://join.slack.com/t/github-integrationhq/shared_invite/zt-1uzcgmgde-j6JNKORGMNZgAI2ayyvUYg)


## Refactoring Opportunities

- The `GoRestService` class has two methods that could be refactored into a single method that can be reused in different places: `createUser` and `createUnauthorizedUser`.

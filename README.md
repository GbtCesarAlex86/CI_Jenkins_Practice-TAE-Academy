# Jenkins Implementation with a API Test Automation proyect
The Star Wars API (SWAPI) provides data about various entities in the Star Wars universe. This project includes tests for several endpoints of the API, using different parameters to validate the responses.

Here are the implemented tests:

> - People Test: Test the endpoint people/2/ and check the success response, the skin color to be gold, and the amount of films the character appears in (should be 6).
> - Film Test: Request the endpoint of the second movie in which people/2/ was present (using the response from people/2/). Check the release date to be in the correct date format, and the response to include characters, planets, starships, vehicles, and species, each element including more than 1 element.
> - Planet Test: Request the endpoint of the first planet present in the last film's response (using the previous response). Check the gravity and the terrains matching the exact same values returned by the request.
> - Planet URL Test: On the same response from the planet, grab the url element on the response, and request it. Validate the response being exactly the same from the previous one.
> - Status Code Check Test: Request the /films/7/ and check the response having a 404 code.

## Continuous Integration with Jenkins
This project also demonstrates a simple Continuous Integration workflow with Jenkins. The Jenkins pipeline is configured to perform the following actions each time a commit is made to the main branch of the GitHub repository:

> - Checkout: Clone the repository and fetch the latest version of the source code.
> - Setting Up Environment: Clean the project with mvn clean.
> - Running Tests: Run the tests with mvn test, passing parameters to the tests through the command line.
> - Generating Allure Report: Generate an Allure report from the test results with mvn allure:report.

## Running the Tests Locally
To run the tests locally, you need to have Java and Maven installed on your machine. You can run the tests with the following command:

mvn test -DsuiteXmlFile=src/test/resources/testng.xml -DpersonId=2 -DfilmId=7 -DstatusCode=404

- NOTE: Replace 2, 7, and 404 with the ID of the person, the ID of the film, and the status code you want to use for testing, respectively.

To generate an Allure report after running the tests, use the following command:

mvn allure:report

- The report will be generated in the target/site/allure-maven-plugin directory.


## SETTING UP THE PROJECT IN YOUR JENKINS SERVER

- Click on create new item
- Select the pipeline option
- Go to the pipeline details option and select Pipeline script with SCM
- Select Git on the SCM option
- Copy the repository link (https://github.com/GbtCesarAlex86/CI_Jenkins_Practice-TAE-Academy.git) and paste it in the "Repository URL" Box
- In the branches to build option, write the name of the branch, in this case */main
- And finally, in the ScriptPath, write 'jenkins/Jenkinsfile', then click on Save.

## HOW TO USE IT

When you have the pipeline completely configured you know can request to Build by clicking the build option

Have in mind that it will request for some parameters in order to work, by default you have some ones to test, but feel free to change them and get some different results
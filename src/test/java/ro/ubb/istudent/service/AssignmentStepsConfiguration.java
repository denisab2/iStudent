package ro.ubb.istudent.service;

/**
 * Created by Lenovo on 21-Jan-18.
 */

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.http.HttpStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AssignmentStepsConfiguration extends SpringIntegrationTest {

    @When(("^the client calls /assignment/1"))
    public void the_client_issues_GET_assignment() throws Throwable {
        executeGet("http://localhost:8080/assignment/1");
    }

    @Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        final HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
        assertThat("status code is incorrect : " + latestResponse.getBody(), currentStatusCode.value(), is(statusCode));
    }

    @And("^the client receives server the assignment with id 1")// (.+)$")
    public void the_client_receives_server_get_assignment_body(String version) throws Throwable {
        assertThat(latestResponse.getBody(), is(version));
    }

    @Given(("^assignment to be added"))
    public void the_client_give_assignment_data_to_be_added() throws Throwable {
        //give the new assignment data
    }

    @When(("^the client calls /assignment/save"))
    public void the_client_issues_POST_assignment() throws Throwable {
        executePost();
    }

    @And("^the client receives server added assignment (.+)$") // | 1 | hey | 10/02/2018|")
    public void the_client_receives_server_added_assignment_body(String version) throws Throwable {
        assertThat(latestResponse.getBody(), is(version));
    }

    @Given(("^assignment to be updated"))
    public void the_client_give_assignment_data_to_be_updated() throws Throwable {
        //give the assignment to be updated data
    }

    @When(("^the client calls /assignment/update/1"))
    public void the_client_issues_PUT_assignment() throws Throwable {
        executePut();
    }

    @And("^the client receives server updated assignment (.+)$") // | 1 | hey cucumber | 11/02/2018 |")
    public void the_client_receives_server_updated_assignment_body(String version) throws Throwable {
        assertThat(latestResponse.getBody(), is(version));
    }

    @When(("^the client calls /assignment/delete/1"))
    public void the_client_issues_DELETE_assignment() throws Throwable {
        executeGet("http://localhost:8080/assignment/1");
    }

    @And("^the client receives server deleted status (.+)$") //1
    public void the_client_receives_server_delete_assignment_status(String version) throws Throwable {
        assertThat(latestResponse.getBody(), is(version));
    }

/*    @When("^the client calls /baeldung$")
    public void the_client_issues_POST_hello() throws Throwable {
        executePost();
    }

    @Given("^the client calls /hello$")
    public void the_client_issues_GET_hello() throws Throwable {
        executeGet("http://localhost:8080/hello");
    }

    @When("^the client calls /version$")
    public void the_client_issues_GET_version() throws Throwable {
        executeGet("http://localhost:8080/version");
    }

    @And("^the client receives server version (.+)$")
    public void the_client_receives_server_version_body(String version) throws Throwable {
        assertThat(latestResponse.getBody(), is(version));
    }*/
}

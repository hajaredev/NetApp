/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpanxion.stepDef;

import com.xpanxion.base.DriverFactory;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 *
 * @author xpanxion
 */
public class StepDef {

    @Given("^I am on the home page$")
    public void i_am_on_the_home_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        DriverFactory.getDriverInstance().get("http://toolsqa.com/");
    }

    @When("^I navigate to the automation practice form$")
    public void i_navigate_to_the_automation_practice_form() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the form should be displayed$")
    public void the_form_should_be_displayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I enter \"([^\"]*)\" in the form$")
    public void i_enter_in_the_form(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I am on the automation practice form$")
    public void i_am_on_the_automation_practice_form() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}

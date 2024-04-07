package com.library.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Set;

public class DataBaseStepDefs {

    @When("the user executes query to get all IDs from users")
    public void the_user_executes_query_to_get_all_i_ds_from_users() {

    }

    @Then("the user verifies that all users have unique IDs")
    public void the_user_verifies_that_all_users_have_unique_ids() {

    }

    @When("the user executes query to get all columns")
    public void the_user_executes_query_to_get_all_columns() {

    }

    @Then("the user verifies the below columns are listed in result")
    public void the_user_verifies_the_below_columns_are_listed_in_result(Set<String> tableColumns) {

    }

    @When("the user executes query to find most popular book genre")
    public void the_user_executes_query_to_find_most_popular_book_genre() {

    }

    @Then("the user verifies {string} is the most popular book genre.")
    public void the_user_verifies_is_the_most_popular_book_genre(String genre) {

    }
}

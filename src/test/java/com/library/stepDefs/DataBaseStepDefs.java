package com.library.stepDefs;

import com.library.utilities.DataBaseUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class DataBaseStepDefs {

    List<String> actualIds;
    List<String> actualColumnNames;
    List<String> expectedIds;

    @When("the user executes query to get all IDs from users")
    public void the_user_executes_query_to_get_all_i_ds_from_users() {
        DataBaseUtils.runQuery("select id from users");
        actualIds = DataBaseUtils.getColumnDataAsList(1);
    }

    @Then("the user verifies that all users have unique IDs")
    public void the_user_verifies_that_all_users_have_unique_ids() {
        DataBaseUtils.runQuery("select distinct id from users");
        expectedIds = DataBaseUtils.getColumnDataAsList(1);
        Assert.assertEquals(expectedIds, actualIds);
    }

    @When("the user executes query to get all columns")
    public void the_user_executes_query_to_get_all_columns() {
        DataBaseUtils.runQuery("select * from users");
        actualColumnNames =  DataBaseUtils.getAllColumnNamesAsList();
    }

    @Then("the user verifies the below columns are listed in result")
    public void the_user_verifies_the_below_columns_are_listed_in_result(List<String> tableColumns) {
        Assert.assertEquals(tableColumns, actualColumnNames);
    }

    @When("the user executes query to find most popular book genre")
    public void the_user_executes_query_to_find_most_popular_book_genre() {

    }

    @Then("the user verifies {string} is the most popular book genre.")
    public void the_user_verifies_is_the_most_popular_book_genre(String genre) {

    }
}

package com.library.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * JUnit runner class for executing Cucumber tests.
 */
@RunWith(Cucumber.class) // Indicates that this class should be run with JUnit
@CucumberOptions(
        // Add any desired plugins for reporting here
        plugin = {
                // Generates HTML reports in the specified directory
                "html:target/cucumber-reports.html",
                // Generates rerun file in the specified directory
                "rerun:target/rerun.txt",
                // Enables Allure reporting
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        // Specifies the location of feature files
        features = "src/test/resources/features",
        // Specifies the package where step definitions are located
        glue = "com/library/stepDefs",
        // Whether to execute a dry run of the feature files
        dryRun = false,
        // Specifies the tags to include/exclude specific scenarios or features
        tags = "",
        // Whether to publish the results
        publish = true
)
public class CukesRunner {
}
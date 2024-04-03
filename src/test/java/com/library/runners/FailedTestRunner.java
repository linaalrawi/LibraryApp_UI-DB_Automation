package com.library.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) // Indicates that this class should be run with JUnit
@CucumberOptions(
        // Specifies the location of the failed test scenarios list
        features = "@target/rerun.txt",
        // Specifies the package where step definitions are located
        glue= "com/library/stepDefs"
)
public class FailedTestRunner {
}
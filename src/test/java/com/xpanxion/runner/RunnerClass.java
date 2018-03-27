package com.xpanxion.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/com/xpanxion/cucumber/sample.feature", 
        tags="@test",
        glue = {"com.xpanxion.stepDef"}
)

public class RunnerClass {

}

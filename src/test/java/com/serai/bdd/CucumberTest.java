package com.serai.bdd;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        glue = {"com/serai/bdd/steps"},
        features = {"src/test/resources/features/"}
)
public class CucumberTest {

}


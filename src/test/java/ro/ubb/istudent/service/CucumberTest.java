package ro.ubb.istudent.service;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by Lenovo on 20-Jan-18.
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources")
@SpringBootTest
public class CucumberTest {
}
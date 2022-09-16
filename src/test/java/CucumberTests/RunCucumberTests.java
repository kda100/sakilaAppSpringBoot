package CucumberTests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@RunWith(Cucumber.class)
@CucumberOptions(plugin={"pretty"},
        features= "src/test/resources/Cucumber/Film.feature",
        glue={"CucumberTests.StepDefs"})
public class RunCucumberTests {
}

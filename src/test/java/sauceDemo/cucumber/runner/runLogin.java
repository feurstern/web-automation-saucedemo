package sauceDemo.cucumber.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/sauceDemo/cucumber/resources/features",
        glue = "sauceDemo/cucumber/stepDef",
        plugin = {"html:target/test_nazi_report.html"}
)

public class runLogin {
}

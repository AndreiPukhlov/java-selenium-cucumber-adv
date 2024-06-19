package support;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/report.html", "json:target/report.json"},
        features = "src/test/resources/features",
        tags = "@ups or @yahoo or @apple or @google and not @being_developed and not @bug",
        glue = {"definitions", "support"})
        // same as VM option test -D"cucumber.filter.tags=@signin and not @bug"

public class TestRunner {
    @BeforeClass
    public static void setup() {
        System.out.println("BeforeAll");
    }

    @AfterClass
    public static void teardown() {
        System.out.println("AfterAll");
    }
}

package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utilities.ServerManager;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"step_definitions"},
        plugin = {"pretty",
                "summary",
                "html:target/cucumber/report.html",
                "me.jvt.cucumber.report.PrettyReports:target/Pixel4/cucumber-html-reports"},
        snippets = CAMELCASE
)
public class RunnerTest {
    static ServerManager serverManager = new ServerManager();

    @BeforeClass
    public static void serverInitialize() {
        serverManager.startAppiumServer();
    }

    @AfterClass
    public static void serverCleanup() {
        serverManager.stopAppiumServer();
    }
}

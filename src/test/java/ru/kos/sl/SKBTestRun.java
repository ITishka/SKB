package ru.kos.sl;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/ru/kos/sl",
        glue = "ru.kos.sl",
        tags = "@all",
        snippets = SnippetType.CAMELCASE
)

        public class SKBTestRun {
}

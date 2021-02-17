package inmetrics.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		   tags = {"@all"},
		   features = "src/test/features",
	       glue = {"stepdefinition"},
	       plugin = {"pretty",
	    		   "html:target/allure-results",
	    		   "html:target/cucumber/cucumber-html-report",
	    		   "json:target/cucumber/cucumber-json-report.json"
	    		   },
			monochrome = true,
			snippets = SnippetType.CAMELCASE,
			dryRun = false,
			strict = true
			)
		public class Runner {

}
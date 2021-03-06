package com.runner;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;


@RunWith(Cucumber.class)
@CucumberOptions(
			features = {"classpath:features/guruLogin.feature"},
			monochrome = true,
			plugin = {"pretty","html:target/cucumberReports/cucureport.html"},
			glue= {"com.addcustomer"},
			publish = true,
//			tags = "@single or @multiple",
//			dryRun = false,
			snippets = SnippetType.CAMELCASE
			
		)

public class MyRunner {

}

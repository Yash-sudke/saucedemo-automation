package com.qa.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportManager {
	
    private static ExtentReports extent;
	
	 public static ExtentReports getInstance() {
		 if (extent == null) {
	            String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
	            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
	            sparkReporter.config().setDocumentTitle("Automation Test Report");
	            sparkReporter.config().setReportName("SauceDemo Test Results");
	            sparkReporter.config().setTheme(Theme.STANDARD);

	            extent = new ExtentReports();
	            extent.attachReporter(sparkReporter);
	            extent.setSystemInfo("Project", "SauceDemo");
	            extent.setSystemInfo("Tester", "Yash");
	            extent.setSystemInfo("Environment", "QA");
	        }
	        return extent;
	    }
}

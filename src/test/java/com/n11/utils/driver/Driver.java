package com.n11.utils.driver;

import com.n11.backend.N11AutomationContext;
import com.n11.backend.ContextKeys;
import com.n11.utils.reporting.ExcelUtil;
import com.thoughtworks.gauge.*;
import org.openqa.selenium.WebDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Driver {

    // Holds the WebDriver instance
    public static WebDriver webDriver;

    // Initialize a webDriver instance of required browser
    // Since this does not have a significance in the application's business domain, the BeforeSuite hook is used to instantiate the webDriver
    @BeforeSuite
    public void initializeDriver(){
        webDriver = DriverFactory.getDriver();
        webDriver.manage().timeouts().pageLoadTimeout((long) 60, TimeUnit.SECONDS);
    }

    @BeforeScenario
    public void beforeScenario(ExecutionContext executionContext){
        N11AutomationContext.initializeContext();
        N11AutomationContext.addContext(ContextKeys.CASENAME, executionContext.getCurrentScenario().getName());
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        N11AutomationContext.addContext(ContextKeys.STARTTIME, sdf.format(Calendar.getInstance().getTime()));
    }

    @BeforeStep
    public void beforeStep(ExecutionContext executionContext){
        N11AutomationContext.addContext(ContextKeys.STEPNAME, executionContext.getCurrentStep().getText());
    }

    // Close the webDriver instance
    @AfterSuite
    public void closeDriver(){
        webDriver.quit();
    }

    @AfterScenario
    public void deleteCookies(ExecutionContext executionContext){
        webDriver.manage().deleteAllCookies();
        Set handles = Driver.webDriver.getWindowHandles();
        while (handles.size() > 1){
            Driver.webDriver.close();
            handles = Driver.webDriver.getWindowHandles();
        }
        Driver.webDriver.switchTo().window(Driver.webDriver.getWindowHandles().iterator().next());
        ExcelUtil excelUtil = ExcelUtil.getInstance();
        String domain = executionContext.getCurrentSpecification().getName();
        String testCase = executionContext.getCurrentScenario().getName();
        boolean isFailed = executionContext.getCurrentScenario().getIsFailing();
        String message = N11AutomationContext.getContextValue(ContextKeys.EXCEPTION);
        String ssLink = N11AutomationContext.getContextValue(ContextKeys.SSLINK);
        String loginData = N11AutomationContext.getContextValue(ContextKeys.EMAIL);
        String startTime = N11AutomationContext.getContextValue(ContextKeys.STARTTIME);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        long startLong = 0L;
        try {
            startLong = sdf.parse(startTime).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long endLong = Calendar.getInstance().getTime().getTime();
        long durationLong = endLong - startLong;
        long durationSeconds = durationLong / 1000 % 60;
        long durationMinutes = durationLong / (60 * 1000) % 60;
        String duration = durationMinutes + ":" + durationSeconds;
        excelUtil.createReportSheet(domain, testCase, isFailed, message, ssLink, loginData, startTime, duration);
    }
}


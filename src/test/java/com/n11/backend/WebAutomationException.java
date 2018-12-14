package com.n11.backend;

import com.n11.utils.driver.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class WebAutomationException extends RuntimeException {
    public WebAutomationException (String message){
        super(message);
        File scrFile = ((TakesScreenshot) Driver.webDriver).getScreenshotAs(OutputType.FILE);
        String filePath = "screenshots\\screenshot " + N11AutomationContext.getContextValue(ContextKeys.CASENAME) + ".png";
        try {
            FileUtils.copyFile(scrFile, new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String description = "n11 WEB AUTOMATION FAILED AT STEP: " + N11AutomationContext.getContextValue(ContextKeys.STEPNAME) + " WITH EXCEPTION MESSAGE: " + message;
        N11AutomationContext.addContext(ContextKeys.EXCEPTION, description);
        N11AutomationContext.addContext(ContextKeys.SSLINK, filePath);
    }
}

package com.n11.pages;

import com.n11.backend.WebAutomationException;
import com.n11.pageElement.N11Button;
import com.n11.pageElement.N11Label;
import com.n11.pageElement.N11TextBox;
import com.n11.pageElement.PageElementModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class N11LoginPage extends N11MasterPage {

    //region Veriable
    private static final Log log = LogFactory.getLog(N11LoginPage.class);
    private static N11LoginPage instance;


    //region Login Page Button
    private static N11Button BTN_Login = new N11Button(PageElementModel.selectorNames.CLASS_NAME, ".btnSignIn");
    private static N11Button BTN_FormLogin = new N11Button(PageElementModel.selectorNames.CLASS_NAME, ".green_flat");
    //endregion
    //region Login Page TextBox
    private static N11TextBox TXT_User = new N11TextBox(PageElementModel.selectorNames.ID, "email");
    private static N11TextBox TXT_Password = new N11TextBox(PageElementModel.selectorNames.NAME, "password");
    //endregion
    //region Login Page Label
    private static N11Label LBL_Password = new N11Label(PageElementModel.selectorNames.NAME, "password");
    //endregion

    //endregion

    public static synchronized N11LoginPage getInstance() {
        if (instance == null)
            instance = new N11LoginPage();
        return instance;
    }

    //region Login Page Scenario
    public  void clickLogin() {
        log.info("ENTERING clickLogin");
        try {
            BTN_Login.waitUntilVisibleAndClick();
            BTN_Login.click();
        } catch (WebAutomationException e) {
            log.warn("COLUD NOT CLICK LOGIN. RETRYING AFTER LOGOUT");
            logout();
            BTN_Login.waitUntilVisibleAndClick();
        }
    }

    public void userLogin() {
        log.info("ENTERING userLogin");
        try {
            BTN_Login.waitUntilVisibleAndClick();
        } catch (WebAutomationException e) {
            log.warn("COLUD NOT CLICK LOGIN. RETRYING AFTER LOGOUT");
            logout();
            BTN_Login.waitUntilVisibleAndClick();
        }
    }

    public void clickSubscribe() {
        log.info("ENTERING clickSubscribe");
        BTN_Login.waitUntilVisibleAndClick();
    }

    public void checkResultText(String expectedMessage) {
        log.info("ENTERING checkResultText");
        LBL_Password.waitUntilVisible();
        String label = LBL_Password.getLabelText();
        if (!label.toLowerCase().contains(expectedMessage.toLowerCase())) {
            String error = "LOGIN RESULT MESSAGE DOES NOT CONTAIN EXPECTED TEXT. EXPECTED IS: " + expectedMessage + " ACTUAL IS: " + label;
            log.error(error);
            throw new WebAutomationException(error);
        } else {
            log.info("LOGIN RESULT MESSAGE CHECKED SUCCESSFULLY");
        }
    }
    //endregion
}

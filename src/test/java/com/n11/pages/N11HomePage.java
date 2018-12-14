package com.n11.pages;

import com.n11.backend.WebAutomationException;
import com.n11.pageElement.N11Button;
import com.n11.pageElement.N11Label;
import com.n11.pageElement.N11TextBox;
import com.n11.pageElement.PageElementModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class N11HomePage extends N11MasterPage {

    //region Veriables

    private static final Log log = LogFactory.getLog(N11HomePage.class);
    private static N11HomePage instance;

    //region Home Page Button
    private static N11Button BTN_Search = new N11Button(PageElementModel.selectorNames.CLASS_NAME, ".icon iconSearch");
    private static N11Button BTN_Page = new N11Button(PageElementModel.selectorNames.CLASS_NAME, ".pagination");
    private static N11Button BTN_Follow = new N11Button(PageElementModel.selectorNames.CLASS_NAME, ".textImg followBtn");
    private static N11Button BTN_OpenMenu = new N11Button(PageElementModel.selectorNames.CLASS_NAME, ".myAccountMenu hOpenMenu");
    private static N11Button BTN_DeleteFavorite = new N11Button(PageElementModel.selectorNames.CLASS_NAME, ".deleteProFromFavorites hOpenMenu");
    private static N11Button BTN_BlackConfirm = new N11Button(PageElementModel.selectorNames.CLASS_NAME, ".btn btnBlack confirm");
    //endregion
    //region Home Page TextBox
    private static N11TextBox TXT_Search = new N11TextBox(PageElementModel.selectorNames.ID, "searchData");
    //endregion
    // region Home Page Label
    private static N11Label LBL_Search = new N11Label(PageElementModel.selectorNames.CLASS_NAME, ".bcSep");
    private static N11Label LBL_Favorite = new N11Label(PageElementModel.selectorNames.CLASS_NAME, ".lazy");
    private static N11Label LBL_DeleteFavorite = new N11Label(PageElementModel.selectorNames.CLASS_NAME, ".icon iconSuccess");

    //endregion

    //endregion


    public static synchronized N11HomePage getInstance() {
        if (instance == null)
            instance = new N11HomePage();
        return instance;
    }

    //region Home Page Scenario
    public void clickSearch(String expectedMessage) {

        log.info("ENTERING clickSearchText");
        TXT_Search.clearText();
        TXT_Search.type("samsung");
        LBL_Search.waitUntilVisible();
        String label = LBL_Search.getLabelText();
        if (!label.toLowerCase().contains(expectedMessage.toLowerCase())) {
            String error = "SEARCH MESSAGE DOES NOT CONTAIN EXPECTED TEXT. EXPECTED IS: " + expectedMessage + " ACTUAL IS: " + label;
            log.error(error);
            throw new WebAutomationException(error);
        } else {
            log.info("SEARCH MESSAGE CHECKED SUCCESSFULLY");
        }

        log.info("ENTERING clickSearchButton");
        BTN_Search.waitUntilVisibleAndClick();
        if (BTN_Search.isDisplayed()) {
            String error = "SEARCH BUTTON SHOULD NOT BE DISPLAYED";
            log.error(error);
            throw new WebAutomationException(error);
        } else {
            log.info("CHECK NON EXISTENCE OF SAMSUNG IS SUCCESSFUL");
        }
    }

    public void clickPage(){
        log.info("ENTERING clickPage");
        BTN_Page.waitUntilVisibleAndClick();
        if (BTN_Page.isDisplayed()) {
            String error = "PAGE BUTTON SHOULD NOT BE DISPLAYED";
            log.error(error);
            throw new WebAutomationException(error);
        } else {
            log.info("CHECK NON EXISTENCE OF PAGE IS SUCCESSFUL");
        }
    }

    public void clickFollow(){
        log.info("ENTERING clickFollow");
        BTN_Follow.waitUntilVisibleAndClick();
        if (BTN_Follow.isDisplayed()) {
            String error = "FOLLOW BUTTON SHOULD NOT BE DISPLAYED";
            log.error(error);
            throw new WebAutomationException(error);
        } else {
            log.info("CHECK NON EXISTENCE OF FOLLOW IS SUCCESSFUL");
        }
    }

    public void clickOpenMenu(String expectedMessage){
        log.info("ENTERING clickOpenMenu");
        BTN_OpenMenu.waitUntilVisibleAndClick();
        if (BTN_OpenMenu.isDisplayed()) {
            String error = "OPEN MENU BUTTON SHOULD NOT BE DISPLAYED";
            log.error(error);
            throw new WebAutomationException(error);
        } else {
            log.info("CHECK NON EXISTENCE OF OPEN MENU IS SUCCESSFUL");
        }
        String label = LBL_Favorite.getLabelText();
        if (!label.toLowerCase().contains(expectedMessage.toLowerCase())) {
            String error = "FAVORITE DOES NOT CONTAIN EXPECTED TEXT. EXPECTED IS: " + expectedMessage + " ACTUAL IS: " + label;
            log.error(error);
            throw new WebAutomationException(error);
        } else {
            log.info("FAVORITE CHECKED SUCCESSFULLY");
        }
    }

    public void clickDeleteFavorite(String expectedMessage){
        log.info("ENTERING clickOpenMenu");
        BTN_DeleteFavorite.waitUntilVisibleAndClick();
        if (BTN_DeleteFavorite.isDisplayed()) {
            String error = "OPEN MENU BUTTON SHOULD NOT BE DISPLAYED";
            log.error(error);
            throw new WebAutomationException(error);
        } else {
            log.info("CHECK NON EXISTENCE OF OPEN MENU IS SUCCESSFUL");
        }
        String label = LBL_DeleteFavorite.getLabelText();
        if (!label.toLowerCase().contains(expectedMessage.toLowerCase())) {
            String error = "FAVORITE DOES NOT CONTAIN EXPECTED TEXT. EXPECTED IS: " + expectedMessage + " ACTUAL IS: " + label;
            log.error(error);
            throw new WebAutomationException(error);
        } else {
            log.info("FAVORITE CHECKED SUCCESSFULLY");
        }
    }
    public void clickBlackConfirm(){
        log.info("ENTERING clickFollow");
        BTN_BlackConfirm.waitUntilVisibleAndClick();
        if (BTN_BlackConfirm.isDisplayed()) {
            String error = "BLACK CONFIRM SHOULD NOT BE DISPLAYED";
            log.error(error);
            throw new WebAutomationException(error);
        } else {
            log.info("CHECK NON EXISTENCE OF BLACK CONFIRM IS SUCCESSFUL");
        }
    }
    //endregion

}

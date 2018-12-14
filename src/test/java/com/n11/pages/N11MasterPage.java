package com.n11.pages;

import com.n11.backend.N11AutomationContext;
import com.n11.backend.ContextKeys;
import com.n11.pageElement.N11Button;
import com.n11.pageElement.PageElementModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class N11MasterPage {
    private static final Log log = LogFactory.getLog(N11MasterPage.class);
    private static N11Button BTN_AccountProfile = new N11Button(PageElementModel.selectorNames.CLASS_NAME,"member-name");
    private static N11Button BTN_Logout = new N11Button(PageElementModel.selectorNames.CLASS_NAME, ".logoutBtn");


    public void logout(){
        log.info("ENTERING logout");
        BTN_AccountProfile.waitUntilVisibleAndClick();
        BTN_Logout.waitUntilVisibleAndClick();
        log.info("USED E-MAIL IS: " + N11AutomationContext.getContextValue(ContextKeys.EMAIL));
    }



}

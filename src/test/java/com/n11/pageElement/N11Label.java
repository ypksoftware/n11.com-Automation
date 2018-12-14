package com.n11.pageElement;

public class N11Label extends PageElementModel {

    public N11Label(selectorNames selectorName, String selectorValue) {
        super(selectorName, selectorValue);
    }

    public String getLabelText(){
        return getWebElement().getText();
    }
}

package com.n11.pagesteps;

import com.n11.pages.*;

import com.thoughtworks.gauge.Step;

public class LoginPageSteps {
    private static N11LoginPage n11LoginPage = N11LoginPage.getInstance();

    @Step("Control click login")
    public void clickLogin(){
        n11LoginPage.clickLogin();
    }

    @Step("Login to <package> and <offer>")
    public void clickUserLogin(String user, String password) {
        n11LoginPage.userLogin();
    }


}
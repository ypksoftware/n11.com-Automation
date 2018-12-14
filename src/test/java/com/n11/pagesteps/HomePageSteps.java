package com.n11.pagesteps;

import com.n11.pages.N11HomePage;
import com.thoughtworks.gauge.Step;

public class HomePageSteps {

    private static N11HomePage n11HomePage = N11HomePage.getInstance();

    @Step("Search n11.com <searchText>")
    public void clickSearch(String searchText){
        n11HomePage.clickSearch("samsung");
    }

    @Step("Search page next <pagination>")
    public void clickPage(String pagination){
        n11HomePage.clickPage();
    }

    @Step("Search page follow <clickFollow>")
    public void clickFollow(String clickFollow){
        n11HomePage.clickFollow();
    }

    @Step("Open Menu Favorite <clickFavorite>")
    public void clickOpenMenu(String clickFavorite){
        n11HomePage.clickOpenMenu("Samsung Galaxy A9 128GB (Petrol Mavisi) SM-A920F");
    }

    @Step("Delete Favorite")
    public void clickDeleteFavorite(){
        n11HomePage.clickDeleteFavorite("Ürününüz listeden silindi.");
    }

    @Step("Black Confirm Success")
    public void clickBlackConfirm(){
        n11HomePage.clickBlackConfirm();
    }






}

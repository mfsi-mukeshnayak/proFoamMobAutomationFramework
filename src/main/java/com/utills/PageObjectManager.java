package com.utills;

import com.pageObjects.CommonActionsPage;
import com.pageObjects.LoginPage;
import com.pageObjects.MyAddressesPage;
import com.pageObjects.OrderPage;
import com.pageObjects.ProductDetailsPage;
import com.pageObjects.ProductPage;
import com.pageObjects.SearchPage;

public class PageObjectManager {
	//wrapper class that holds instances of all these pages as attributes.
	
	private LoginPage loginPage;
    private ProductPage productPage;
    private MyAddressesPage myAddressesPage;
    private ProductDetailsPage prodDetailsPage;
    private CommonActionsPage commonActionsPage;
    private SearchPage searchPage;
    private OrderPage orderPage;
	
	// Constructor to initialize the page objects
    public PageObjectManager() {
        loginPage = new LoginPage();
        productPage = new ProductPage();
        myAddressesPage = new MyAddressesPage();
        prodDetailsPage = new ProductDetailsPage();
        commonActionsPage = new CommonActionsPage();
        searchPage = new SearchPage();
        orderPage = new OrderPage();
    }

    // Getter methods to access the page objects

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public ProductPage getProductPage() {
        return productPage;
    }

    public MyAddressesPage getMyAddressesPage() {
        return myAddressesPage;
    }

    public ProductDetailsPage getProdDetailsPage() {
        return prodDetailsPage;
    }

    public CommonActionsPage getCommonActionsPage() {
        return commonActionsPage;
    }
    public SearchPage getSearchPage() {
        return searchPage;
    }
    public OrderPage getOrderPage() {
        return orderPage;
    }

}

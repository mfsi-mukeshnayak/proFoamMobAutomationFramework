package TestCases;

import org.testng.annotations.Test;

import com.utills.BaseClass;
import com.utills.PageObjectManager;

public class WishListPage_TestCases extends BaseClass{
		
		PageObjectManager pageManager = new PageObjectManager();

		
		@Test (groups = {"smoke" ,"Regression", "ValidationOfLandingOnWishListPageAndAttributesOfWishListPage"}, description = "Landing on WishListPage and validating its attributes")
		public void ValidationOfLandingOnWishListPageAndAttributesOfWishListPage() throws InterruptedException {
			System.out.println("Application is launching");
			
			pageManager.getLoginPage().ValidateWelcomeTextInWelcomePage();
			pageManager.getLoginPage().ClickOnSkipButtonInWelcomePage();
			pageManager.getLoginPage().ValidateLogin_ButtonInLoginPage();
			pageManager.getLoginPage().ClickOnLoginButtonInLoginButton();
			pageManager.getLoginPage().LoginToProFoamApplication();
			pageManager.getProductPage().LandedOnProductPageAndAbleToSeeSideMenu();
			pageManager.getProductPage().ClickOnSideMenubar();
			pageManager.getWishListPage().ClickOnWishlistCategoryInSidemenu();
			pageManager.getWishListPage().ValidatingWishListPageHeader();
			pageManager.getWishListPage().ValidateMyWishlistText();
			pageManager.getWishListPage().ValidateSharedWishlistText();
		}
		
		@Test (groups = {"smoke" ,"Regression", "ValidationOfMyWishListPageAndAttributes"}, description = "Validation Of MyWishListPage And its Attributes")
		public void ValidationOfMyWishListPageAndAttributes() throws InterruptedException {
			System.out.println("Application is launching");
			
			pageManager.getLoginPage().ValidateWelcomeTextInWelcomePage();
			pageManager.getLoginPage().ClickOnSkipButtonInWelcomePage();
			pageManager.getLoginPage().ValidateLogin_ButtonInLoginPage();
			pageManager.getLoginPage().ClickOnLoginButtonInLoginButton();
			pageManager.getLoginPage().LoginToProFoamApplication();
			pageManager.getProductPage().LandedOnProductPageAndAbleToSeeSideMenu();
			pageManager.getProductPage().ClickOnSideMenubar();
			pageManager.getWishListPage().ClickOnWishlistCategoryInSidemenu();
			pageManager.getWishListPage().ValidatingWishListPageHeader();
			pageManager.getWishListPage().ValidateMyWishlistText();
			pageManager.getWishListPage().ValidateSharedWishlistText();
			pageManager.getWishListPage().NavigatingMyWishList();
			pageManager.getWishListPage().ValidatingMyWishListPageButtonsAndLinks();
		}
		
		@Test (groups = {"smoke" ,"Regression", "ValidationOfSharedWishListPageAndAttributes"}, description = "Validation Of SharedWishList And its Attributes")
		public void ValidationOfSharedWishListPageAndAttributes() throws InterruptedException {
			System.out.println("Application is launching");
			
			pageManager.getLoginPage().ValidateWelcomeTextInWelcomePage();
			pageManager.getLoginPage().ClickOnSkipButtonInWelcomePage();
			pageManager.getLoginPage().ValidateLogin_ButtonInLoginPage();
			pageManager.getLoginPage().ClickOnLoginButtonInLoginButton();
			pageManager.getLoginPage().LoginToProFoamApplication();
			pageManager.getProductPage().LandedOnProductPageAndAbleToSeeSideMenu();
			pageManager.getProductPage().ClickOnSideMenubar();
			pageManager.getWishListPage().ClickOnWishlistCategoryInSidemenu();
			pageManager.getWishListPage().ValidatingWishListPageHeader();
			pageManager.getWishListPage().ValidateMyWishlistText();
			pageManager.getWishListPage().ValidateSharedWishlistText();
			pageManager.getWishListPage().NavigatingSharedWishList();
			pageManager.getWishListPage().ValidatingSharedWishListPage();
		}
		
		@Test (groups = {"smoke" ,"Regression", "ValidationOfItemDisplayedInMyWishListPageWhicAddedToWishList"}, description = "Validation Of SharedWishList And its Attributes")
		public void ValidationOfItemDisplayedInMyWishListPageWhicAddedToWishList() throws InterruptedException {
			System.out.println("Application is launching");
			
			pageManager.getLoginPage().ValidateWelcomeTextInWelcomePage();
			pageManager.getLoginPage().ClickOnSkipButtonInWelcomePage();
			pageManager.getLoginPage().ValidateLogin_ButtonInLoginPage();
			pageManager.getLoginPage().ClickOnLoginButtonInLoginButton();
			pageManager.getLoginPage().LoginToProFoamApplication();
			pageManager.getProductPage().LandedOnProductPageAndAbleToSeeSideMenu();
			pageManager.getProductPage().ClickOnSideMenubar();
			pageManager.getWishListPage().ClickOnWishlistCategoryInSidemenu();
			pageManager.getWishListPage().ValidatingWishListPageHeader();
			pageManager.getWishListPage().ValidateMyWishlistText();
//			pageManager.getWishListPage().ValidateSharedWishlistText();
//			pageManager.getWishListPage().NavigatingSharedWishList();
//			pageManager.getWishListPage().ValidatingSharedWishListPage();
			pageManager.getWishListPage().NavigatingMyWishList();
			pageManager.getWishListPage().ClearAllWishlistedItemIfItExistsInMyWishListPage();
			pageManager.getCommonActionsPage().navigatetoBackPage();
			pageManager.getCommonActionsPage().navigatetoBackPage();			
			pageManager.getSearchPage().inputProductNameAndSearchTheItem("spray foam guns");
			pageManager.getSearchPage().ClickedOnSearcheditemandNavigateToSearchedItemPage("spray foam guns");
			pageManager.getSearchPage().ClickedOnSearchButton();
			pageManager.getSearchPage().grabTheNameofSearchedItemName();
			pageManager.getSearchPage().ClickedOnProductInfromthesearchedList();
			pageManager.getProdDetailsPage().ValidateLandingInProductPage();
			pageManager.getProdDetailsPage().ClickedOnAddTowishListItemBtnInProductDetailsPage();
			pageManager.getCommonActionsPage().navigatetoBackPage();
			pageManager.getCommonActionsPage().navigatetoBackPage();
			pageManager.getProductPage().ClickOnSideMenubar();
			pageManager.getWishListPage().ClickOnWishlistCategoryInSidemenu();
			pageManager.getWishListPage().ValidatingWishListPageHeader();
			pageManager.getWishListPage().ValidateMyWishlistText();
			pageManager.getWishListPage().ValidateSharedWishlistText();
			pageManager.getWishListPage().NavigatingMyWishList();
			pageManager.getWishListPage().ValidatingMyWishListPageButtonsAndLinks();
			pageManager.getWishListPage().ValidateItemDisplayedinWishListPage();
		}

		@Test (groups = {"smoke" ,"Regression", "ValidationOfSelectedItemToCartBtnDisplayedInMyWishListPageWhicAddedToWishList"}, description = "Validation Of Item Add to cart button ")
		public void ValidationOfSelectedItemToCartBtnDisplayedInMyWishListPageWhicAddedToWishList() throws InterruptedException {
			System.out.println("Application is launching");
			
			pageManager.getLoginPage().ValidateWelcomeTextInWelcomePage();
			pageManager.getLoginPage().ClickOnSkipButtonInWelcomePage();
			pageManager.getLoginPage().ValidateLogin_ButtonInLoginPage();
			pageManager.getLoginPage().ClickOnLoginButtonInLoginButton();
			pageManager.getLoginPage().LoginToProFoamApplication();
			pageManager.getProductPage().LandedOnProductPageAndAbleToSeeSideMenu();
			pageManager.getProductPage().ClickOnSideMenubar();
			pageManager.getWishListPage().ClickOnWishlistCategoryInSidemenu();
			pageManager.getWishListPage().ValidatingWishListPageHeader();
			pageManager.getWishListPage().ValidateMyWishlistText();
//			pageManager.getWishListPage().ValidateSharedWishlistText();
//			pageManager.getWishListPage().NavigatingSharedWishList();
//			pageManager.getWishListPage().ValidatingSharedWishListPage();
			pageManager.getWishListPage().NavigatingMyWishList();
			pageManager.getWishListPage().ClearAllWishlistedItemIfItExistsInMyWishListPage();
			pageManager.getCommonActionsPage().navigatetoBackPage();
			pageManager.getCommonActionsPage().navigatetoBackPage();			
			pageManager.getSearchPage().inputProductNameAndSearchTheItem("spray foam guns");
			pageManager.getSearchPage().ClickedOnSearcheditemandNavigateToSearchedItemPage("spray foam guns");
			pageManager.getSearchPage().ClickedOnSearchButton();
			pageManager.getSearchPage().grabTheNameofSearchedItemName();
			pageManager.getSearchPage().ClickedOnProductInfromthesearchedList();
			pageManager.getProdDetailsPage().ValidateLandingInProductPage();
			pageManager.getProdDetailsPage().ClickedOnAddTowishListItemBtnInProductDetailsPage();
			pageManager.getCommonActionsPage().navigatetoBackPage();
			pageManager.getCommonActionsPage().navigatetoBackPage();
			pageManager.getProductPage().ClickOnSideMenubar();
			pageManager.getWishListPage().ClickOnWishlistCategoryInSidemenu();
			pageManager.getWishListPage().ValidatingWishListPageHeader();
			pageManager.getWishListPage().ValidateMyWishlistText();
			pageManager.getWishListPage().ValidateSharedWishlistText();
			pageManager.getWishListPage().NavigatingMyWishList();
			pageManager.getWishListPage().ValidatingMyWishListPageButtonsAndLinks();
			pageManager.getWishListPage().ValidateItemDisplayedinWishListPage();
			pageManager.getWishListPage().ClickedOnSelectButtonAndCheckedTheTextBoxofItem();
			pageManager.getWishListPage().validatingSelectedIteToCartBtnAndCancelBtnIsDisplayed();
		}
		
		@Test (groups = {"smoke" ,"Regression", "ValidationOfShringItemToSharedWishListFromMyWishListPageWhicAddedToWishList"}, description = "Validation Of Item shared to shared WishList from My WishList")
		public void ValidationOfShringItemToSharedWishListFromMyWishListPageWhicAddedToWishList() throws InterruptedException {
			System.out.println("Application is launching");
			
			pageManager.getLoginPage().ValidateWelcomeTextInWelcomePage();
			pageManager.getLoginPage().ClickOnSkipButtonInWelcomePage();
			pageManager.getLoginPage().ValidateLogin_ButtonInLoginPage();
			pageManager.getLoginPage().ClickOnLoginButtonInLoginButton();
			pageManager.getLoginPage().LoginToProFoamApplication();
			pageManager.getProductPage().LandedOnProductPageAndAbleToSeeSideMenu();
			pageManager.getProductPage().ClickOnSideMenubar();
			pageManager.getWishListPage().ClickOnWishlistCategoryInSidemenu();
			pageManager.getWishListPage().ValidatingWishListPageHeader();
			pageManager.getWishListPage().ValidateMyWishlistText();
//			pageManager.getWishListPage().ValidateSharedWishlistText();
//			pageManager.getWishListPage().NavigatingSharedWishList();
//			pageManager.getWishListPage().ValidatingSharedWishListPage();
			pageManager.getWishListPage().NavigatingMyWishList();
			pageManager.getWishListPage().ClearAllWishlistedItemIfItExistsInMyWishListPage();
			pageManager.getCommonActionsPage().navigatetoBackPage();
			pageManager.getCommonActionsPage().navigatetoBackPage();			
			pageManager.getSearchPage().inputProductNameAndSearchTheItem("spray foam guns");
			pageManager.getSearchPage().ClickedOnSearcheditemandNavigateToSearchedItemPage("spray foam guns");
			pageManager.getSearchPage().ClickedOnSearchButton();
			pageManager.getSearchPage().grabTheNameofSearchedItemName();
			pageManager.getSearchPage().ClickedOnProductInfromthesearchedList();
			pageManager.getProdDetailsPage().ValidateLandingInProductPage();
			pageManager.getProdDetailsPage().ClickedOnAddTowishListItemBtnInProductDetailsPage();
			pageManager.getCommonActionsPage().navigatetoBackPage();
			pageManager.getCommonActionsPage().navigatetoBackPage();
			pageManager.getProductPage().ClickOnSideMenubar();
			pageManager.getWishListPage().ClickOnWishlistCategoryInSidemenu();
			pageManager.getWishListPage().ValidatingWishListPageHeader();
			pageManager.getWishListPage().ValidateMyWishlistText();
			pageManager.getWishListPage().ValidateSharedWishlistText();
			pageManager.getWishListPage().NavigatingSharedWishList();
			pageManager.getWishListPage().ClearAllSharedWishlistedDetailsIfItExists();
			pageManager.getCommonActionsPage().navigatetoBackPage();
			pageManager.getWishListPage().NavigatingMyWishList();
			pageManager.getWishListPage().ValidatingMyWishListPageButtonsAndLinks();
			pageManager.getWishListPage().ValidateItemDisplayedinWishListPage();
		//	pageManager.getWishListPage().ClickedOnSelectButtonAndCheckedTheTextBoxofItem();
			pageManager.getWishListPage().ClickedOnSharedButtonInMyWishListPage();
			pageManager.getCommonActionsPage().navigatetoBackPage();
			pageManager.getWishListPage().NavigatingSharedWishList();
			pageManager.getWishListPage().ClickedOnViewItemsButtonInSharedWishListPage();
			pageManager.getWishListPage().ValidateItemDisplayedinWishListPage();
		}





}

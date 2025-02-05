//package TestCases;
//
//import org.testng.annotations.Test;
//import com.utills.BaseClass;
//import com.utills.PageObjectManager;
//
//
//
//public class LoginPage_TestCase extends BaseClass {
//
//	PageObjectManager pageManager = new PageObjectManager();
//	
//	
//	@Test (groups = {"smoke" , "ValidateLaunching_App"}, description = "Validating to launch the app and display LoginBtn")
//	public void LandingOnLoginPageValidation() throws InterruptedException {
//		System.out.println("Application is launching");
//		
//		pageManager.getLoginPage().ValidateWelcomeTextInWelcomePage();
//		pageManager.getLoginPage().ClickOnSkipButtonInWelcomePage();
//		pageManager.getLoginPage().ValidateLogin_ButtonInLoginPage();
//		
//	}
//	
//	@Test (groups = {"smoke" , "ValidateLaunching_App"}, description = "Validating to launch the app and display LoginBtn")
//	public void LoginValidation() throws InterruptedException {
//		System.out.println("Application is launching");
//		
//		pageManager.getLoginPage().ValidateWelcomeTextInWelcomePage();
//		pageManager.getLoginPage().ClickOnSkipButtonInWelcomePage();
//		pageManager.getLoginPage().ValidateLogin_ButtonInLoginPage();
//		pageManager.getLoginPage().ClickOnLoginButtonInLoginButton();
//		pageManager.getLoginPage().ValidateLoginTextBoxAndButtonInLoginPage();
//		pageManager.getLoginPage().LoginToProFoamApplication();
//		pageManager.getProductPage().LandedOnProductPageAndAbleToSeeSideMenu();
//		
//	
//	}
//
//
//
//}

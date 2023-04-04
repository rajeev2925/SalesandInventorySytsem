package allPomScript;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.POMobjectrepository.LoginPage;
import com.POMobjectrepository.customerpage;
import com.POMobjectrepository.homePage;

@Listeners(com.GenericUtilities.listnerimplimentation.class)
public class create_customer_test extends BaseClass {

@Test(priority = 1, groups = {"smoke","regression"})
public void create_cust() throws Throwable
	{
	LoginPage lp = new LoginPage(driver);
	lp.login("adminusername","adminpassword", flib, wlib, driver);
	    homePage HP = new	homePage(driver);
	    HP.getcustomerM_tab().click();
	    customerpage cp = new customerpage(driver);
	    cp.getCreate_cust_Btn().click();
	    String phone = cp.addcustomer(driver, elib, jlib);
        cp.verifyaddedcust(phone);		

	}

}

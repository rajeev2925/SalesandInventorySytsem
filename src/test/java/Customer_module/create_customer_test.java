package Customer_module;


import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.POMobjectrepository.LoginPage;
import com.POMobjectrepository.customerpage;
import com.POMobjectrepository.homePage;


public class create_customer_test extends BaseClass {

@Test
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

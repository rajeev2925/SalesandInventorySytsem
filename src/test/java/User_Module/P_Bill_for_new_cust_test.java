package User_Module;


import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.POMobjectrepository.LoginPage;
import com.POMobjectrepository.TranscationPage;
import com.POMobjectrepository.Userhome_page;
import com.POMobjectrepository.homePage;


public class P_Bill_for_new_cust_test extends BaseClass{
@Test
	public  void billingfornewcust() throws Throwable
	{	
		LoginPage lp = new LoginPage(driver);
		lp.login("employeeusername","employeepassword", flib,wlib,driver);
		Userhome_page up = new Userhome_page(driver);
		up.sel_product_cat(driver,"Keyboard");
		String pname="oppo";
		up.Add_product(driver,pname);
	    String name = up.create_new_cust(elib, jlib, wlib,driver);
        up.selectAddedCustomer(wlib,name);
        up.getSubmitPOs();
        up.PaymentOpt();
    	wlib.acceptalert(driver);
    	up.logoutasEmployee();
    
     	lp.login("adminusername","adminpassword", flib,wlib,driver);
     	 homePage hp = new homePage(driver);
     	 hp.getTransactionM_TAB();
     	TranscationPage tp = new TranscationPage(driver);
     	tp.verify_Bill(name, driver, pname,hp );
       	
	}

}

package accounts_module;

import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.POMobjectrepository.LoginPage;
import com.POMobjectrepository.accountsPage;
import com.POMobjectrepository.homePage;

public class getTheAccouuntDetails extends BaseClass
{
@Test
public void accounts() throws Throwable
{
	LoginPage lp = new LoginPage(driver);
	accountsPage Ap = new accountsPage(driver);
	homePage hp=new homePage(driver);
	lp.login("adminusername","adminpassword", flib, wlib, driver);
	hp.getaccountsM_TAB();
	String name = Ap.updateADmindetails(elib, driver, wlib, jlib);
	Ap.verifyUpdateddet(name);
	Ap.getcountofusers(driver);
	
}
}

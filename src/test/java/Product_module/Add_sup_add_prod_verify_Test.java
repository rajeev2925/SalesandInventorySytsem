package Product_module;

import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.POMobjectrepository.LoginPage;
import com.POMobjectrepository.ProductsPage;
import com.POMobjectrepository.SuplierPage;
import com.POMobjectrepository.Userhome_page;
import com.POMobjectrepository.homePage;


public class Add_sup_add_prod_verify_Test  extends BaseClass
{
@Test
public void addSupAddPodAndVerify() throws Throwable
{
	LoginPage lp = new LoginPage(driver);
	lp.login("adminusername","adminpassword", flib, wlib, driver);
	homePage hp = new homePage(driver);
	SuplierPage sp = new SuplierPage(driver);
	ProductsPage Pp = new ProductsPage(driver);
	 hp.getSupplierM_TAB();
	 sp.getadd_suplierBTN();
	 String phone = sp.Add_suplier_det(elib, jlib, wlib);
	 String cname = sp.Verify_suplier(driver, phone, wlib);
	 hp.getProductM_TAB();
	 Pp.getAdd_productBTN();
	 String Pname = Pp.Add_Product(elib, jlib, driver, wlib, cname);
	 Pp.Verify_product(Pname);
	 hp.Admin_logout();
	 lp.login("employeeusername","employeepassword", flib, wlib, driver);
	 Userhome_page UHP = new Userhome_page(driver);
	 UHP.sel_product_cat(driver,"Others");
	 UHP.verify_product(driver, Pname);
	
}	
}

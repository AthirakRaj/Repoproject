package Testpkg;

import java.io.IOException;

import org.testng.annotations.Test;

import Basepkg.basecls;
import Pagepkg.Buynowpage;
import Pagepkg.Nutridemopage;
import Pagepkg.Productpage;
import Pagepkg.Signoutpage;
import Utilities.Excelutils;

public class nutritest extends basecls {

    private static final String EXCEL_FILE_PATH = "C:\\Users\\Rahul K Murali\\OneDrive\\Desktop\\nutristar.xlsx";
    private static final String EXCEL_SHEET_NAME = "sheet1";

    @Test(priority = 0)
    public void test() {
        Nutridemopage ob = new Nutridemopage(driver);
        ob.signin();

        int rowcount = Excelutils.getRowCount(EXCEL_FILE_PATH, EXCEL_SHEET_NAME);

        for (int i = 1; i <= rowcount; i++) {
            String email = Excelutils.getCellValue(EXCEL_FILE_PATH, EXCEL_SHEET_NAME, i, 0);
            System.out.println(email);
            String password = Excelutils.getCellValue(EXCEL_FILE_PATH, EXCEL_SHEET_NAME, i, 1);
            System.out.println(password);

            ob.newuser();
            ob.setValues(email, password);
            ob.login();
            driver.navigate().back();
        }
    }

    @Test(priority = 1)
    public void pdt() throws InterruptedException {
        Productpage ob = new Productpage(driver);
        ob.completeShoppingFlow();
    }

    @Test(priority = 2)
    public void buyNow() throws IOException {
        Buynowpage v = new Buynowpage(driver);
        v.completeBuyNowFlow();
    }
    @Test(priority = 3)
    public void signout() throws IOException {
        Signoutpage p = new Signoutpage(driver);
        p.signout();
    }
}

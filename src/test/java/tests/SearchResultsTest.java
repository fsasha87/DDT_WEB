package tests;

import dataProvider.DataProviderCSV;
import dataProvider.DataProviderXML;
import dataProvider.DataProviderXLSX;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.businessobject.SearchResultsPageBO;
import pages.businessobject.Verifier;
import utils.TestNGListener;


@Epic("smoke tests")
@Feature("Search-results-page tests")
@Listeners(TestNGListener.class)
public class SearchResultsTest extends BaseTest {

    @Test(description = "Verify that price is less than amount. Positive test",
            enabled = true)
    @Description("Some description text in the below of page")
    public void verifyPriceOfSearchedCommodity() {
        new SearchResultsPageBO()
                .typeCategory("Laptop")
                .selectGoodByBrand("Lenovo");
        new Verifier()
                .verifyAmountWithSoftAssert(50000)
                .verifyAmount(50000);
    }

    @Test(description = "Verify that price is less than amount Negative test",
            enabled = false)
    public void verifyPriceOfSearchedIncorrectCommodity() {
        new SearchResultsPageBO()
                .typeCategory("dflsdfsd")
                .selectGoodByBrand("Lenovo");
        new Verifier()
                .verifyAmountWithSoftAssert(50000)
                .verifyAmount(50000);
    }


    @Test(description = "Verify that price is less than amount (data from xml)",
            dataProvider = "DpXML", dataProviderClass = DataProviderXML.class, enabled = true)
    public void verifyPriceOfSearchedCommodityXML(String thing, String brand, int amount) {
        new SearchResultsPageBO()
                .typeCategory(thing)
                .selectGoodByBrand(brand);
        new Verifier()
                .verifyAmountWithSoftAssert(amount)
                .verifyAmount(amount);
    }

    @Test(description = "Verify that price is less than amount (data from csv)",
            dataProvider = "DpCSVReader", dataProviderClass = DataProviderCSV.class, enabled = true)
    public void verifyPriceOfSearchedCommodityCSV(String thing, String brand, String amount) {
        new SearchResultsPageBO()
                .typeCategory(thing)
                .selectGoodByBrand(brand);
        new Verifier()
                .verifyAmountWithSoftAssert(Integer.parseInt(amount))
                .verifyAmount(Integer.parseInt(amount));
    }

    @Test(description = "Verify that price is less than amount (data from XLSX)",
            dataProvider = "DpXLSX", dataProviderClass = DataProviderXLSX.class, enabled = true)
    public void verifyPriceOfSearchedCommodityXLSX(String thing, String brand, String amount) {
        new SearchResultsPageBO()
                .typeCategory(thing)
                .selectGoodByBrand(brand);
        new Verifier()
                .verifyAmountWithSoftAssert(Integer.parseInt(amount))
                .verifyAmount(Integer.parseInt(amount));
    }


}

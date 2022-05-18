package pages.businessobject;

import io.qameta.allure.Step;
import pages.BucketPage;
import pages.MainPage;
import pages.SearchResultsPage;

public class SearchResultsPageBO {
    @Step("Type category {0} for method {method}")
    public SearchResultsPageBO typeCategory(String thing) {
        new MainPage()
                .typeSearchField(thing)
                .clickSearchField();
        return this;
    }

    @Step("Select brand of good: {brand}")
    public SearchResultsPageBO selectGoodByBrand(String brand){
        new SearchResultsPage()
                .enterBrandFieldAndClickCheckbox(brand)
                .selectSortOption()
                .clickFirstElementButton();
        new BucketPage()
                .openBucket();
        return this;
    }
}

package ui.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;

import static utils.PageWaiters.waitForJStoLoad;

@Url("")
public class HomePage extends WebPage {

    @Css(".global-nav__branding-logo")
    private UIElement homePageLogo;

    @XPath("//*[@class='global-nav__me-photo evi-image ghost-person ember-view']")
    private Button myAccountIcon;

    public void verifyHomePageOpened() {
        waitForJStoLoad();
        homePageLogo.shouldBe().displayed();
        myAccountIcon.shouldBe().displayed();
    }

}

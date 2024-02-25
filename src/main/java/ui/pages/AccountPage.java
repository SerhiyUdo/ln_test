package ui.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;

import static utils.AllureAssert.assertTrue;
import static utils.LocalStorage.getValueFromLocalStorage;

@Url("/feed/")
public class AccountPage extends WebPage {

    @Css(".feed-identity-module__member-photo")
    private UIElement profilePhoto;

    @Css(".global-nav .global-nav__me-photo")
    private UIElement profileIcon;

    @XPath("//a[contains(@href,'logout')]")
    private Button logOutButton;

    @XPath("(//*[@role = 'dialog']//*[contains(@class, 'artdeco-button__text')])[3]")
    private Button confirmLogOutButton;

    public void verifyUserLoggedIn() {
        profileIcon.shouldBe().displayed();
        profilePhoto.shouldBe().displayed();
    }

    public void verifyLocalStorage() {
        String storage = getValueFromLocalStorage("voyager-web:badges");
        assert storage != null;
        assertTrue("Data saved to local storage", storage.contains("_id"));
    }

    public void logOut() {
        profileIcon.click();
        logOutButton.click();
        confirmLogOutButton.click();
    }

}




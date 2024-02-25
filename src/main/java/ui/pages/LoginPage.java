package ui.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import entities.Account;

import static utils.PageWaiters.waitForJStoLoad;

public class LoginPage extends WebPage {

    @Css("[data-test-id=nav-logo]")
    private UIElement loginPageLogo;
    @Css("#username")
    private UIElement usernameField;

    @Css("#password")
    private UIElement usernamePassword;

    @Css(".nav__cta-container .btn-secondary-emphasis")
    private Button signInButtonTop;

    @XPath("//*[@data-id='sign-in-form']// *[contains(@class, 'btn-primary')]")
    private Button signInButtonBottom;

    @XPath("//*[@data-litms-control-urn='login-submit']")
    private Button signInButtonSecondStep;

    public void openLoginForm() {
        signInButtonTop.click();
    }

    public void verifyLoginPageOpened() {
        waitForJStoLoad();
        loginPageLogo.shouldBe().displayed();
        signInButtonTop.shouldBe().displayed();
        signInButtonBottom.shouldBe().displayed();
    }
    public void loginAs(String user, String password) {
        usernameField.sendKeys(user);
        usernamePassword.sendKeys(password);
        signInButtonSecondStep.click();
    }

    public void loginAs(Account account) {
        loginAs(account.login, account.password);
    }


}

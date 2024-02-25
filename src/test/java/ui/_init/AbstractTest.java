package ui._init;

import com.epam.jdi.light.elements.pageobjects.annotations.smart.SId;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ui._site.ServerSite;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.InitActions.JDI_ANNOTATIONS;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.jdi.light.elements.init.rules.AnnotationRule.aRule;
import static com.jdiai.tools.StringUtils.toCamelCase;

public class AbstractTest {
    @BeforeSuite
    public static void setUp() {
        JDI_ANNOTATIONS.addOrReplace("SId", aRule(SId.class, (e, a) -> {
            e.base().setLocator("#" + toCamelCase(e.getName()).replaceAll(" ", ""));
            e.base().locator.isRoot();
        }));

        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        System.setProperty("webdriver.chrome.silentOutput", "true");

        initSite(ServerSite.class);
        getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        ServerSite.homePage.open();
    }


    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        getDriver().quit();
        killAllSeleniumDrivers();
    }
}

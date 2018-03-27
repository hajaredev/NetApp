package com.xpanxion.hooks;

import com.xpanxion.base.DriverFactory;
import com.xpanxion.core.BrowserTypes;
import com.xpanxion.core.Configuration;
import static com.xpanxion.core.CoreTestCase.log;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import java.io.ByteArrayOutputStream;
import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class Hooks {

    @Before("@test")
    public void setup(Scenario scenario) {
        Configuration config = new Configuration();
        DriverFactory.registerInstance(BrowserTypes.valueOf(config.getBrowsers()).getDriverInstance());
    }

    @After("@test")
    public void tearDown(Scenario scenario) {
        if (DriverFactory.getDriverInstance() == null) {

        } else {

            if (scenario.isFailed()) {
                try {

                    Configuration config = new Configuration();
                    if (!config.isMobileNativeApp() && config.isGrowlEnabled()) {
                        growlNotify(DriverFactory.getDriverInstance(), scenario.getName());
                    }
                    log().debug("Capturing Screenshot...");
                    Screenshot screenshot = new AShot().takeScreenshot(DriverFactory.getDriverInstance());
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageIO.write(screenshot.getImage(), "PNG", baos);
                    scenario.embed(baos.toByteArray(), "png");
                } catch (Throwable e) {
                    log().error("Error in @AfterMethod, Error message: " + e.getLocalizedMessage());
                    e.printStackTrace(System.err);
                }
                try {
                    log().debug("Closing browser / session... ");
                    DriverFactory.getDriverInstance().quit();
                } catch (Throwable e) {
                    log().error("Failed to close browser, ignoring error. " + e.getLocalizedMessage());
                    e.printStackTrace(System.err);
                }
            }
        }
    }

    private void growlNotify(WebDriver driverInstance, String name) {
    }
}

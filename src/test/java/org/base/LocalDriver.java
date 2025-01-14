package org.base;

import org.constants.Constants;
import org.enums.Browsers;
import org.openqa.selenium.WebDriver;
import org.utilities.BrowserManagers.ChromeManager;
import org.utilities.BrowserManagers.EdgeManager;

import java.util.HashMap;
import java.util.function.Supplier;

public final class LocalDriver {

    private LocalDriver() {
    }


        public static WebDriver getLocalDriver() {//String browser, Object[] data

            try {
                HashMap<Browsers, Supplier<WebDriver>> hmm = new HashMap<>();

                hmm.put(Browsers.CHROME, ChromeManager::chromeManagerLocal);
                hmm.put(Browsers.EDGE, () -> EdgeManager.edgeManagerLocal());
                // hmm.put(BrowserType.FIREFOX, return new FirefoxDriver());

                return hmm.get(Constants.getBrowserEnum()).get();
            } catch (Exception e) {
                throw new RuntimeException("Failed to initialize WebDriver: " + e.getMessage(), e);
            }
        }

}


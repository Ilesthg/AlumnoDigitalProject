package org.base;

import org.constants.Constants;
import org.enums.Browsers;
import org.enums.RunMode;
import org.openqa.selenium.WebDriver;
import org.utilities.BrowsersManagers.ChromeManager;
import org.utilities.BrowsersManagers.EdgeManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class LocalDriver {

    private LocalDriver() {
    }


    public static WebDriver getLocalDriver() {//String browser, Object[] data

        HashMap<Browsers, Supplier<WebDriver>> hmm = new HashMap<>();

        hmm.put(Browsers.CHROME, () -> ChromeManager.chromeManagerLocal());
        hmm.put(Browsers.EDGE, () -> EdgeManager.edgeManagerLocal());
        // hmm.put(BrowserType.FIREFOX, return new FirefoxDriver());

        return hmm.get(Constants.getBrowserEnum()).get();
    }

}


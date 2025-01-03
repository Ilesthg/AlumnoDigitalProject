package org.base;

import org.constants.Constants;
import org.enums.Browsers;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.utilities.BrowsersManagers.ChromeManager;
import org.utilities.BrowsersManagers.EdgeManager;

import java.util.HashMap;
import java.util.function.Supplier;

public class Docker {
    public static RemoteWebDriver getRemoteDriver() {//String browser, Object[] data

        HashMap<Browsers, Supplier<RemoteWebDriver>> hmm = new HashMap<>();

        hmm.put(Browsers.CHROME, () -> ChromeManager.chromeManagerRemote());
        hmm.put(Browsers.EDGE, () -> EdgeManager.edgeManagerRemote());
        // hmm.put(BrowserType.FIREFOX, return new FirefoxDriver());

        return hmm.get(Constants.getBrowserEnum()).get();
    }
}

package org.base;

import org.openqa.selenium.WebDriver;

public final class ParallelDriver {

    private ParallelDriver(){};

  private  static ParallelDriver parallelDriver = new ParallelDriver();
    public static ParallelDriver getInstanceParallelDriver(){
        return parallelDriver;
    }
   private ThreadLocal<WebDriver> threadLocalWebDriver = new ThreadLocal<>();


    public WebDriver getThreadLocalWebDriver() {
        return threadLocalWebDriver.get();
    }

    public void setWebDriver(WebDriver driver) {
      threadLocalWebDriver.set(driver);
    }

    public void closeWebDriver(){
        if (threadLocalWebDriver.get() != null) {
            threadLocalWebDriver.remove();
        }

    }




}

package reportss;

import com.aventstack.extentreports.ExtentTest;

//Singleton approach to initialize a logger for each test and log the steps performed
public final class SingletonExtentTest {
    private SingletonExtentTest() {
    }

    private static final SingletonExtentTest instance = new SingletonExtentTest();
    private static final ThreadLocal<ExtentTest> loggerTest = new ThreadLocal<>();

    public static SingletonExtentTest getInstance() {
        return instance;
    }

    public void setExtentTest(ExtentTest loggerT) {
        loggerTest.set(loggerT);
    }
    /*static void setExtentTest(ExtentTest loggerT) {
        loggerTest.set(loggerT);
    }*/

    public ExtentTest getExtentTest() {
        return loggerTest.get();
    }

    public void removeExtentObject() {
        loggerTest.remove();
    }


}

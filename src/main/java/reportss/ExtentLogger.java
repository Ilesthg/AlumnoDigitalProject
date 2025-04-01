package reportss;

import com.aventstack.extentreports.ExtentTest;


public class ExtentLogger {

    public static void passMessage(String message) {
        SingletonExtentTest.getInstance().getExtentTest().pass(message);
    }

    public static void failMessage(String message) {
        SingletonExtentTest.getInstance().getExtentTest().fail(message);
    }

    public static void skipMessage(String message) {
        SingletonExtentTest.getInstance().getExtentTest().skip(message);
    }
    public static void logMessage(String message) {
        SingletonExtentTest.getInstance().getExtentTest().pass(message);
    }


    public static void addAuthor(String author){
        SingletonExtentTest.getInstance().getExtentTest().assignAuthor(author);
    }

}

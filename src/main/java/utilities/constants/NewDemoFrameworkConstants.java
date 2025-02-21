package utilities.constants;

import utilities.propertiesHelper.NewDemoPropertiesHelper;
import utilities.reportGenerator.NewDemoReportGenerator;

import java.io.File;

public final class NewDemoFrameworkConstants {
    private NewDemoFrameworkConstants() {
    }

    static {
        NewDemoPropertiesHelper.loadAllFiles();
    }

    public static final String PROJECT_PATH = System.getProperty("user.dir") + File.separator;
    public static final String browser = NewDemoPropertiesHelper.getValue("browser");
    public static final String HEADLESS = NewDemoPropertiesHelper.getValue("HEADLESS");
    public static final String PROJECT_NAME = NewDemoPropertiesHelper.getValue("PROJECT_NAME");
    public static final String REPORT_TITLE = NewDemoPropertiesHelper.getValue("REPORT_TITLE");
    public static final String EXTENT_REPORT_NAME = NewDemoPropertiesHelper.getValue("EXTENT_REPORT_NAME");
    public static final String EXTENT_REPORT_FOLDER = NewDemoPropertiesHelper.getValue("EXTENT_REPORT_FOLDER");
    public static final String SEND_EMAIL_TO_USERS = NewDemoPropertiesHelper.getValue("SEND_EMAIL_TO_USERS");
    public static final String SCREENSHOT_PASSED_TCS = NewDemoPropertiesHelper.getValue("SCREENSHOT_PASSED_TCS");
    public static final String SCREENSHOT_FAILED_TCS = NewDemoPropertiesHelper.getValue("SCREENSHOT_FAILED_TCS");
    public static final String SCREENSHOT_SKIPPED_TCS = NewDemoPropertiesHelper.getValue("SCREENSHOT_SKIPPED_TCS");
    public static final String SCREENSHOT_ALL_STEPS = NewDemoPropertiesHelper.getValue("SCREENSHOT_ALL_STEPS");

    public static final String EXTENT_REPORT_FOLDER_PATH = PROJECT_PATH + EXTENT_REPORT_FOLDER;
    public static final String EXTENT_REPORT_FILE_NAME = EXTENT_REPORT_NAME + ".html";
    public static String EXTENT_REPORT_FILE_PATH = EXTENT_REPORT_FOLDER_PATH + File.separator + EXTENT_REPORT_FILE_NAME;

    public static final String YES = "yes";
    public static final String NO = "no";
    public static final String ENABLE = "enable";

       public static String getNewDemoExtentReportFilePath() {
           return NewDemoReportGenerator.reportPath;
       }
}

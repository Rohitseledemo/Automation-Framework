package utilities.propertiesHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Properties;

public class NewDemoPropertiesHelper {

    private static Properties properties;
    private static String linkFile;
    private static FileInputStream file;
    private static FileOutputStream out;
    private static String relPropertiesFilePathDefault = "src/main/resources/ConfigFiles/NewDemoConfig.properties";

    public static Properties loadAllFiles() {
        LinkedList<String> files = new LinkedList<>();
        files.add("src/main/resources/ConfigFiles/NewDemoConfig.properties");

        try {
            properties = new Properties();

            for (String f : files) {
                Properties tempProp = new Properties();
                linkFile = System.getProperty("user.dir") + File.separator + f;
                file = new FileInputStream(linkFile);
                tempProp.load(file);
                properties.putAll(tempProp);
            }
            file.close();
            System.out.println("Loaded all properties files of NewDemo.");
            //LogUtils.info(properties);
            return properties;
        } catch (IOException e) {
            System.err.println("Warning !! Can not Load All Files of NewDemo.");
            return new Properties();
        }
    }

    public static Properties getProperties() {
        return properties;
    }

    public static void setFile(String relPropertiesFilePath) {
        properties = new Properties();
        try {
            linkFile = System.getProperty("user.dir") + File.separator + relPropertiesFilePath;
            file = new FileInputStream(linkFile);
            properties.load(file);
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setDefaultFile() {
        properties = new Properties();
        try {
            linkFile = System.getProperty("user.dir") + File.separator + relPropertiesFilePathDefault;
            file = new FileInputStream(linkFile);
            properties.load(file);
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        String keyValue = null;
        try {
            if (file == null && properties == null) {
                properties = new Properties();
                linkFile = System.getProperty("user.dir") + File.separator + relPropertiesFilePathDefault;
                file = new FileInputStream(linkFile);
                properties.load(file);
                file.close();
            }
            // Get value from file
            keyValue = properties.getProperty(key);
            return keyValue;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void setValue(String key, String keyValue) {
        try {
            if (file == null) {
                properties = new Properties();
                file = new FileInputStream(System.getProperty("user.dir") + File.separator + relPropertiesFilePathDefault);
                properties.load(file);
                file.close();
                out = new FileOutputStream(System.getProperty("user.dir") + File.separator + relPropertiesFilePathDefault);
            }
            //Write to the same Prop file as the extracted file
            out = new FileOutputStream(linkFile);
            System.out.println(linkFile);
            properties.setProperty(key, keyValue);
            properties.store(out, "Set value to NewDemo properties file success.");
            out.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

package com.imrantariq.ibm.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author 
 * 
 */
public class AppLogger {

  private static Properties loggerProperties = AppLogger.read("log4j.properties");

  static Logger logger = Logger.getLogger(AppLogger.class);

  static {
    PropertyConfigurator.configure(loggerProperties);
    logger.setLevel(Level.DEBUG);
  }

  public static void logInfo(String msg) {
    logger.info(msg);
  }

  public static void logDebug(String msg) {
    logger.debug(msg);
  }

  public static void logError(String msg) {
    logger.error(msg);
  }

  public static void logException(Throwable aThrowable) {
    aThrowable.printStackTrace();
    logger.error(aThrowable);
  }

  public static void main(String[] args) {

  }

  private static Properties read(String aPropertyName) {
    String propertiesLocation = System.getProperty(aPropertyName);
    Properties props = new Properties();

    try {
      if (propertiesLocation != null) {
        props.load(new FileInputStream(propertiesLocation));
      }
      else {
        System.out.println("Property " + aPropertyName
            + " returned null. If this message is displayed during a batch run then it can be safely ignored.");
      }
    }
    catch (IOException ioe) {
      String msg = "Unable to load properties file at location " + propertiesLocation;
      System.out.println(msg + ioe);
    }
    return props;
  }
}

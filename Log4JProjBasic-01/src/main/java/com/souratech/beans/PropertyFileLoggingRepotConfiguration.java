package com.souratech.beans;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class PropertyFileLoggingRepotConfiguration {
	//Creating Logger Object
	private static Logger logger=Logger.getLogger(PropertyFileLoggingRepotConfiguration.class);

	public static void main(String[] args) {
		//String log4jPrpertyfile=System.getProperty("user.dir")+File.separator+"log4j.properties";
		//Configure Log4J Object
		PropertyConfigurator.configure("log4j.properties");
		logger.trace("This is TRACE");
		logger.info("This is INFO");
		logger.error("This is ERROR");
		logger.debug("This is DEBUG");
		logger.fatal("This is FATAL");
		
	}


}

/*Here we will  Learn ,How to Use Log4J in Our Project/application. For Documentation you can follow
 * Goodle and apache docs also*/

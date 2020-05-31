package com.souratech.beans;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class BasicLoggingRepotConfiguration {
	//Creating Logger Object
	private static Logger logger=Logger.getLogger(BasicLoggingRepotConfiguration.class);

	public static void main(String[] args) {
		//Configure Log4J Object
		BasicConfigurator.configure();
		logger.trace("This is TRACE");
		logger.info("This is INFO");
		logger.error("This is ERROR");
		logger.debug("This is DEBUG");
		logger.fatal("This is FATAL");
		logger.trace("TRACE");
	}


}

/*Here we will  Learn ,How to Use Log4J in Our Project/application. For Documentation you can follow
 * Goodle and apache docs also*/

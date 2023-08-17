package com.nttdatatraining.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The class contains Logback details. 
  * @author Group-6
 * @since 2021-10-08
 */
public class LogBack {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(LogBack.class);
     /**
      * Main Method of LogBack class
      * @param args
      */
	 public static void main(String args) {
	    LOGGER.trace("This is TRACE level messsage");
	    LOGGER.debug("This is DEBUG level messsage");
	    LOGGER.info("This is INFO level messsage");
	    LOGGER.warn("This is WARN level messsage");
	    LOGGER.error("This is ERROR level messsage");
	  }
}


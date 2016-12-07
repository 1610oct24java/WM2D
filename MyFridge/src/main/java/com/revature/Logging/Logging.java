
package com.revature.Logging;

import org.apache.log4j.Logger;

/**
 * The Class Logging.
 */
public class Logging {
	
	/** The log. */
	// private static Logger log = LogManager.getRootLogger();
	
	private static Logger log = Logger.getRootLogger();
	
	/**
	 * Fatal.
	 *
	 * @param msg
	 *            the msg
	 */
	public void fatal(String msg) {
		
		log.fatal(msg);
	}
	
	/**
	 * Warn.
	 *
	 * @param msg
	 *            the msg
	 */
	public void warn(String msg) {
		
		log.warn(msg);
	}
	
	/**
	 * Info.
	 *
	 * @param msg
	 *            the msg
	 */
	public void info(String msg) {
		
		log.info(msg);
	}
	
	/**
	 * Debug.
	 *
	 * @param msg
	 *            the msg
	 */
	public void debug(String msg) {
		
		log.debug(msg);
	}
	
}

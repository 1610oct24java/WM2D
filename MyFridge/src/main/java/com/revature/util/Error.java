
package com.revature.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.revature.Logging.Logging;

/**
 * The Error class <br>
 * Primarily used for generating error reports for specified exceptions,<br>
 * but also provides a method to create a time stamp.
 */
public class Error {
	
	/**
	 * Gets the date.<br>
	 * Used in {@link #error} to create timestamp
	 *
	 * @param now
	 *            the now
	 * @return the date
	 */
	public static String getDate(Date now) {
		
		String dateFormat = "dd/MM/yyyy", timeFormat = "HH:mm:ss";
		SimpleDateFormat sdfDate = new SimpleDateFormat(dateFormat),
				sdfTime = new SimpleDateFormat(timeFormat);
		String timeStamp = sdfDate.format(now) + " | " + sdfTime.format(now);
		return timeStamp;
	}
	
	/**
	 * Produces an error report, also sends errors to log4j2. Specifically:<br>
	 * <ul>
	 * <li>Borders</li>
	 * <li>Time</li>
	 * <li>User Message</li>
	 * <li>Cause</li>
	 * <li>Error message</li>
	 * </ul>
	 * Uses {@link #getDate(Date)}.
	 *
	 * @param message
	 *            the message from the call <br>
	 *            To make the most of this, set the call to look like this:<br>
	 *            {@code 
	 *            StackTraceElement thing = Thread.currentThread().getStackTrace()[1];
	 *            Error.error("\nat Line:\t" + thing.getLineNumber()
	 *            + "\nin Method:\t" + thing.getMethodName()
	 *            + "\nin Class:\t" + thing.getClassName(), e);}
	 * @param t
	 *            the Throwable object passed in
	 */
	public static void error(String message, Throwable t) {
		
		Date now = new Date();
		Logging log = new Logging();
		
		String border = "\n==================================\n", entire;
		if (t == null) {
			entire = border
					+ "Program ran into the following error:\n"
					+ "at Time:\t"
					+ getDate(now)
					+ message
					+ border;
			System.err.println(entire);
		} else {
			entire = border
					+ "Program ran into the following error:\n"
					+ "at Time:\t"
					+ getDate(now)
					+ message
					+ "\nCause:\t\t"
					+ t.getClass().getSimpleName()
					+ "\nMessage:\t\t"
					+ t.getMessage();
			System.err.println(entire + "\nStackTrace:\n");
			t.printStackTrace();
			System.err.println(border);
		}
		
		log.fatal(entire);
		
	}
}

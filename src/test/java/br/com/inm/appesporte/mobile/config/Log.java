package br.com.inm.appesporte.mobile.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {

	private static final Logger logger = LoggerFactory.getLogger(Log.class);
	
	public static Logger getLog () {
		return logger;
	}

}

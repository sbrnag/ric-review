package com.ric.mongodb.database;

import java.net.UnknownHostException;

import com.mongodb.MongoClient;

public class MongoUtil {

	/*
	 * private final static Logger logger = LoggerFactory
	 * .getLogger(MongoUtil.class);
	 */

	private static final int port = 27017;
	private static final String host = "localhost";
	private static MongoClient mongodb = null;

	public static MongoClient getMongo() {
		if (mongodb == null) {
			try {
				mongodb = new MongoClient(host, port);
				/*
				 * logger.debug("New Mongodb created with [" + host + "] and ["
				 * + port + "]");
				 */
			} catch (UnknownHostException e) {
				// logger.error(e.getMessage());
			}
		}
		return mongodb;
	}

}
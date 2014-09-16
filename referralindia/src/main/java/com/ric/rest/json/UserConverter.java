package com.ric.rest.json;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.ric.mongodb.model.User;

public class UserConverter {
	// convert User Object to MongoDB DBObject
	// take special note of converting id String to ObjectId

	public static DBObject toDBObject(User u) {

		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
				.append("password", u.getPassword())
				.append("email", u.getEmail());
		if (u.get_id() != null)
			builder = builder.append("_id", u.get_id());
		return builder.get();
	}

	// convert DBObject Object to UserObject
	// take special note of converting ObjectId to String
	public static User toUser(DBObject doc) {
		User u = new User();
		u.setPassword((String) doc.get("password"));
		u.setEmail((String) doc.get("email"));
		String id = (String) doc.get("_id");
		u.set_id(id.toString());
		return u;

	}

}

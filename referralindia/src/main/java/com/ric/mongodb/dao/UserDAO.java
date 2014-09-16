package com.ric.mongodb.dao;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.ric.mongodb.database.MongoUtil;
import com.ric.mongodb.model.User;
import com.ric.rest.json.UserConverter;

//DAO class for different MongoDB CRUD operations
//also take note of "_id" key for primary key
public class UserDAO {

	private DBCollection col;

	public UserDAO() {
		this.col = MongoUtil.getMongo().getDB("test").getCollection("Users");
	}

	public User createUser(User u) {
		DBObject doc = UserConverter.toDBObject(u);
		this.col.insert(doc);
		String id = (String) doc.get("_id");
		u.set_id(id.toString());
		return u;
	}

	public void updateUser(User u) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", u.get_id()).get();
		this.col.update(query, UserConverter.toDBObject(u));
	}

	public List<User> readAllUser() {
		List<User> data = new ArrayList<User>();
		DBCursor cursor = col.find();
		while (cursor.hasNext()) {
			DBObject doc = cursor.next();
			User u = UserConverter.toUser(doc);
			data.add(u);
		}
		return data;
	}

	public void deleteUser(User u) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", u.get_id()).get();
		this.col.remove(query);
	}

	public User readPerson(User u) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id",u.get_id()).get();
		DBObject data = this.col.findOne(query);
		return UserConverter.toUser(data);
	}

}

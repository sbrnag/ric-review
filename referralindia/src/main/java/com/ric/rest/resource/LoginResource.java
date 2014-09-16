package com.ric.rest.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.ric.mongodb.dao.UserDAO;
import com.ric.mongodb.model.User;

@Path("/loginapi")
public class LoginResource {

	

	@POST
	@Path("/signup")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(String userjson) {
		Gson gson = new Gson();
		User user = gson.fromJson(userjson, User.class);
		UserDAO userDAO = new UserDAO();
		return Response.status(200).entity(userDAO.createUser(user).toString()).build();
	}

	@POST
	@Path("/login")
	public Response valdateUser(String loginCredentials) {
		return null;
	}

	@GET
	@Path("/logout")
	public Response inValidateUser(String sessionToken) {
		return null;
	}

}

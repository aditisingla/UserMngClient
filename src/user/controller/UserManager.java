package user.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import user.model.User;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class UserManager {

	public List<User> add(User contact) {
		String output = null;
		try {
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/user/UserWebService/addUser/"+ contact.getFirstName()+ "/"+ contact.getLastName());

			ClientResponse response = webResource.type("application/json").get(ClientResponse.class);
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
			}
			output = response.getEntity(String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return convertJsonToListObj(output);
	}

	public List<User> getUserslist() {
		String output = null;
		try {
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/user/UserWebService/getUserList");
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
			}
			output = response.getEntity(String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return convertJsonToListObj(output);
	}

	public List<User> convertJsonToListObj(String output) {
		List<User> usersList = new ArrayList<User>();
		Gson gson = new Gson();
		User[] u = gson.fromJson(output, User[].class);
		usersList = Arrays.asList(u);
		return usersList;
	}
}

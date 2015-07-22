package user.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import user.model.User;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class UserManager {
	static Logger logger = Logger.getLogger(UserManager.class);

	public String add(User contact) {
		String url = "http://localhost:8080/user/UserWebService/addUser/"+ contact.getFirstName()+ "/"+ contact.getLastName();
		Map responseMap = getWSReponse(url);
		if(responseMap.get("errorMessage") != null){
			logger.error("Error occured while adding user: "+ responseMap.get("errorMessage"));
			throw new RuntimeException(responseMap.get("errorMessage").toString());
		}
		return responseMap.get("result").toString();
	}

	public List<User> getUserslist() {
		String url = "http://localhost:8080/user/UserWebService/getUserList";
		Map responseMap = getWSReponse(url);
		if(responseMap.get("errorMessage") != null){
			logger.error("Error occured while getting user list: "+ responseMap.get("errorMessage"));
			throw new RuntimeException(responseMap.get("errorMessage").toString());
		}
		return (List<User>) responseMap.get("data");
	}
	
	public Map getWSReponse(String URL){
		Map responseMap = null;
		Gson gson = new Gson();
		try {
			Client client = Client.create();
			WebResource webResource = client.resource(URL);
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
			String output = response.getEntity(String.class);
			responseMap = gson.fromJson(output, Map.class);
		} catch (Exception e) {
			throw new RuntimeException("Failed : HTTP error code : "+ e.getMessage());
		}
		return responseMap;
	}
}

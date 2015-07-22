package user.view;

import java.util.List;

import user.controller.UserManager;
import user.model.User;

public class UserAction {
	private User user;
	private List<User> userList;

	private UserManager UserManager;

	public UserAction() {
		UserManager = new UserManager();
	}

	public String retrieveUserList() {
		this.userList = UserManager.getUserslist();
		return "SUCCESS";
	}

	public String addUser() {
		System.out.println(getUser());
		try {
			this.userList = UserManager.add(getUser());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "SUCCESS";
	}
	
	public User getUser() {
		return user;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

}

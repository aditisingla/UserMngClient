package user.view;

import java.util.List;

import user.controller.UserManager;
import user.model.User;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private User user;
	private List<User> userList;

	private UserManager UserManager;

	public UserAction() {
		UserManager = new UserManager();
	}

	public String retrieveUserList() {
		try {
			this.userList = UserManager.getUserslist();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return "SUCCESS";
	}

	public String addUser() {
		if (user == null || user.getFirstName().isEmpty() || user.getLastName().isEmpty() ) {
			addActionError("First Name & Last Name  should not be empty");
			return "error";
		} else {
			try {
				UserManager.add(getUser());
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
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

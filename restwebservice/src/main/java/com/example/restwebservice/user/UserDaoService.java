package com.example.restwebservice.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<User>();
	private int userCount = 3;

	static {
		users.add(new User(1, "Adam", LocalDate.now()));
		users.add(new User(2, "Eve", LocalDate.now()));
		users.add(new User(3, "Jack", LocalDate.now()));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++userCount);
		}

		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		return users.stream()
		     .filter(u -> u.getId() == id)
		     .findFirst()
		     .orElseThrow(() -> new UserNotFoundException("No user present for id:" + id));
	}

}

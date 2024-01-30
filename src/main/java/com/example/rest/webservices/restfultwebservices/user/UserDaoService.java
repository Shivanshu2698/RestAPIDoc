package com.example.rest.webservices.restfultwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users=new ArrayList<User>();
	
	private static Integer usersCount=0;
	
	static {
		users.add(new User(++usersCount, "Shiva", LocalDate.now().minusYears(30)));
		users.add(new User(++usersCount, "shivam", LocalDate.now().minusYears(20)));
		users.add(new User(++usersCount, "lavi", LocalDate.now().minusYears(20)));
		users.add(new User(++usersCount, "prateek", LocalDate.now().minusYears(24)));
		users.add(new User(++usersCount, "maya", LocalDate.now().minusYears(25)));
	}


	public List<User> finadAll(){
		return users;
	}
	
	public User findOne(int id) {
		Predicate<? super User> predicate= user-> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public User createUser(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}
	
	public void deleteUserById(int id) {
		Predicate<? super User> predicate= user-> user.getId().equals(id);
		users.removeIf(predicate);
	}
}

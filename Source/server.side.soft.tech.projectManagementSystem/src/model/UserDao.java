package model;

import java.util.List;

public interface UserDao {

  List<User> getUser(String email, String password);
}

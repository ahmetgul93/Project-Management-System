package base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.data.User;
import base.database.UserRepository;

@Service
public class UserController {

  @Autowired
  private UserRepository repository;

  public User getUser(final String email, final String pass) {
    return this.repository.getUserByEmailAndPass(email, pass);
  }

  public void insertUser(final User user) {
    this.repository.insertUser(user);
  }
}

package base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.data.User;
import base.database.UserRepository;

/**
 * This class is responsible for communication with user repository.
 *
 * @author anıl öztürk
 * @author ahmet gül
 * @author asım zorlu
 */
@Service
public class UserController {

  @Autowired
  private UserRepository repository;

  public User getUser(final String email, final String pass) {
    return this.repository.getUserByEmailAndPass(email, pass);
  }

  public void insertUser(final User user) {
    this.repository.save(user);
  }
}

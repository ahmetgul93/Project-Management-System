package base.database;

import base.data.User;

public interface UserRepositoryCustom {

  public User getUserByEmailAndPass(String email, String pass);
}

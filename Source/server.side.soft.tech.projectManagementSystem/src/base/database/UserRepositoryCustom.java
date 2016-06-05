package base.database;

import base.data.User;

/**
 * To enrich a repository with custom functionality.
 *
 * @author anıl öztürk
 * @author ahmet gül
 * @author asım zorlu
 */
public interface UserRepositoryCustom {

  public User getUserByEmailAndPass(String email, String pass);
}

package base.database;

import org.springframework.data.repository.CrudRepository;

import base.data.User;


/**
 * Combines the CRUD and custom functionality and makes it available to clients.
 *
 * @author anıl öztürk
 * @author ahmet gül
 * @author asım zorlu
 */
public interface UserRepository extends CrudRepository<User, String>, UserRepositoryCustom {

}

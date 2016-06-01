package base.database;

import org.springframework.data.repository.CrudRepository;

import base.data.User;

public interface UserRepository extends CrudRepository<User, String>, UserRepositoryCustom {

}

package model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

  @Autowired
  private MongoOperations operations;

  @Override
  public List<User> getUser(String email, String password) {
    final Query query = new Query(Criteria.where("email").is(email).and("password").is(password));
    return this.operations.find(query, User.class);
  }
}

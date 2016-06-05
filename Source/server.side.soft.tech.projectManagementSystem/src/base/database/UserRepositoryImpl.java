package base.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import base.data.User;
import base.util.DbUtil;

/**
 * This implementation uses MongoTemplate to achieve the database operations.
 *
 * @author anıl öztürk
 * @author ahmet gül
 * @author asım zorlu
 */
public class UserRepositoryImpl implements UserRepositoryCustom {

  @Autowired
  private MongoTemplate mongoTemplate;

  @Override
  public User getUserByEmailAndPass(final String email, final String pass) {
    final Query query = new Query();
    final Criteria criteria = Criteria.where("email").is(email).and("password").is(pass);
    query.addCriteria(criteria);

    return this.mongoTemplate.findOne(query, User.class, DbUtil.USER_COLL);
  }
}

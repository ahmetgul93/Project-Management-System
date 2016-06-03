package base.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import base.data.GroupInfo;
import base.util.DbUtil;

public class GroupRepositoryImpl implements GroupRepositoryCustom {

  @Autowired
  private MongoTemplate mongoTemplate;

  @Override
  public GroupInfo getGroupByGroupNo(final int groupNo) {
    final Query query = new Query();
    final Criteria criteria = Criteria.where("groupNo").is(groupNo);
    query.addCriteria(criteria);

    return this.mongoTemplate.findOne(query, GroupInfo.class, DbUtil.PROJ_COLL);
  }

  @Override
  public GroupInfo getGroupByNameSurname(final String name, final String surname) {
    final Query query = new Query();
    final Criteria criteria = Criteria.where("name").is(name).and("surname").is(surname);
    query.addCriteria(criteria);

    return this.mongoTemplate.findOne(query, GroupInfo.class, DbUtil.PROJ_COLL);
  }
}

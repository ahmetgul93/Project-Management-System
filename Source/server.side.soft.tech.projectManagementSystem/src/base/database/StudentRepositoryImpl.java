package base.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import base.data.Student;
import base.util.DbUtil;

/**
 * This implementation uses MongoTemplate to achieve the database operations.
 *
 * @author anıl öztürk
 * @author ahmet gül
 * @author asım zorlu
 */
public class StudentRepositoryImpl implements StudentRepositoryCustom {

  @Autowired
  private MongoTemplate mongoTemplate;

  @Override
  public void addStudents(final List<Student> students) {
    // System.out.println("In database.");
    this.mongoTemplate.insert(students, DbUtil.PROJ_COLL);
  }

  @Override
  public Student getStudentByNameSurname(final String name, final String surname) {
    final Query query = new Query();
    final Criteria criteria = Criteria.where("name").is(name).and("surname").is(surname);
    query.addCriteria(criteria);

    return this.mongoTemplate.findOne(query, Student.class, DbUtil.PROJ_COLL);
  }

  @Override
  public List<Student> getStudentsByGroupNo(final int groupNo) {
    final Query query = new Query();
    final Criteria criteria = Criteria.where("groupNo").is(groupNo);
    query.addCriteria(criteria);

    return this.mongoTemplate.find(query, Student.class, DbUtil.PROJ_COLL);
  }

  @Override
  public void updateStudent(final Student updated) {
    final Query query = new Query();
    final Criteria criteria = Criteria.where("studentNumber").is(updated.getStudentNumber());
    query.addCriteria(criteria);

    final Update update = new Update();
    update.set("name", updated.getName());
    update.set("surname", updated.getSurname());
    update.set("grade", updated.getGrade());
    update.set("groupNo", updated.getGroupNo());

    this.mongoTemplate.updateFirst(query, update, DbUtil.PROJ_COLL);
  }
}

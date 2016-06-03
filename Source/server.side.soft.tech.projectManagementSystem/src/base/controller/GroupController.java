package base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.data.GroupInfo;
import base.data.Student;
import base.database.GroupRepository;

@Service
public class GroupController {

  @Autowired
  private GroupRepository repository;

  public void addGroup(final GroupInfo group) {
    this.repository.save(group);
  }

  public GroupInfo getGroupByNameAndSurname(final Student student) {
    return this.repository.getGroupByNameSurname(student.getName(), student.getSurname());
  }

  public GroupInfo getGroupByNo(final int groupNo) {
    return this.repository.getGroupByGroupNo(groupNo);
  }

  public void updateGroup(final GroupInfo newlyUpdatedGroup) {
    this.repository.delete(newlyUpdatedGroup.getId());
    this.repository.save(newlyUpdatedGroup);
  }
}

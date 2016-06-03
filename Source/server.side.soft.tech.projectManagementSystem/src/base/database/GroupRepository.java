package base.database;

import org.springframework.data.repository.CrudRepository;

import base.data.GroupInfo;

public interface GroupRepository extends CrudRepository<GroupInfo, String>, GroupRepositoryCustom {

}

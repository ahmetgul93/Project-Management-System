package base.database;

import base.data.GroupInfo;

public interface GroupRepositoryCustom {

  public GroupInfo getGroupByGroupNo(int groupNo);

  public GroupInfo getGroupByNameSurname(String name, String surname);
}

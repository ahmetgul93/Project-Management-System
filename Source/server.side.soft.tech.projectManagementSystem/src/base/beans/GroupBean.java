package base.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import base.controller.GroupController;
import base.data.GroupInfo;

@Component
@SessionScoped
public class GroupBean {

  @Autowired
  private GroupController controller;

  private List<GroupInfo> groups;

  public List<GroupInfo> getGroups() {
    return this.groups;
  }

  @PostConstruct
  public void init() {
    this.groups = new ArrayList<GroupInfo>();
  }

  public void setGroups(final List<GroupInfo> groups) {
    this.groups = groups;
  }
}

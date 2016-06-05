package base.beans;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import base.controller.UserController;
import base.data.User;
import base.util.DbUtil;
import base.util.PageUtil;

/**
 * This class is responsible for holding the given input from login.xhtml view and transmit those
 * data to controller.
 *
 * @author anıl öztürk
 * @author ahmet gül
 * @author asım zorlu
 */
@Component
@SessionScoped
public class UserBean {

  @Autowired
  private UserController controller;

  private User user;

  public User getUser() {
    return this.user;
  }

  /**
   * This method will be call just once and initialize the User database with admin.
   *
   */
  @PostConstruct
  public void init() {
    this.user = new User();

    final User admin = new User();
    admin.setEmail(DbUtil.USER);
    admin.setPassword(DbUtil.PASS);
    this.controller.insertUser(admin);
  }

  /**
   * This method is responsible for check the user which return from database related to given
   * information and if succeed redirect to project page.
   *
   */
  public void login() {
    final User returnedUser =
        this.controller.getUser(this.user.getEmail(), this.user.getPassword());
    if (returnedUser == null) {
      FacesContext.getCurrentInstance().addMessage("loginForm:loginButton",
          new FacesMessage(PageUtil.LOGIN_ERROR));
    } else {
      try {
        FacesContext.getCurrentInstance().getExternalContext().redirect(PageUtil.PROJECT_PAGE);
      } catch (final IOException e) {
        e.printStackTrace();
      }
    }
  }

  public void setUser(final User user) {
    this.user = user;
  }
}

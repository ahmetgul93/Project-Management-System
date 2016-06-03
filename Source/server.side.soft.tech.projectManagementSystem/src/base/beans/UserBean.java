package base.beans;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import base.controller.UserController;
import base.data.User;
import base.mail.MailListener;
import base.util.DbUtil;
import base.util.PageUtil;

@Component
@SessionScoped
public class UserBean {

  @Autowired
  private UserController controller;

  private User user;

  public User getUser() {
    return this.user;
  }

  @PostConstruct
  public void init() {
    this.user = new User();

    // System.out.println("It is in");
    final User admin = new User();
    admin.setEmail(DbUtil.USER);
    admin.setPassword(DbUtil.PASS);
    this.controller.insertUser(admin);
  }

  public void login() {
    final User returnedUser =
        this.controller.getUser(this.user.getEmail(), this.user.getPassword());
    if (returnedUser == null) {
      FacesContext.getCurrentInstance().addMessage("loginForm:loginButton",
          new FacesMessage(PageUtil.LOGIN_ERROR));
    } else {

      // we start to listen mail at here, every 20 seconds it will run.
      final ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
      exec.scheduleAtFixedRate(new MailListener(), 0, 20, TimeUnit.SECONDS);

      try {
        FacesContext.getCurrentInstance().getExternalContext().redirect(PageUtil.SECOND_PAGE);
      } catch (final IOException e) {
        e.printStackTrace();
      }
    }
  }

  public void setUser(final User user) {
    this.user = user;
  }
}

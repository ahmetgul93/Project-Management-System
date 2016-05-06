package model;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.bson.Document;

import com.mongodb.client.MongoCursor;

import database.MongoDB;
import util.DbUtil;
import util.PageUtil;

@ManagedBean(name = "user")
public class User {

  private String email;

  private String password;

  private boolean rememberMe;

  public String getEmail() {
    return this.email;
  }

  public String getPassword() {
    return this.password;
  }

  public boolean isRememberMe() {
    return this.rememberMe;
  }

  public void login() {
    final MongoDB db = new MongoDB();
    final Document querydoc = new Document("email", this.email);
    querydoc.append("password", this.password);
    @SuppressWarnings("rawtypes")
    final MongoCursor iterator = db.read(DbUtil.USER_COLL, querydoc);
    // while (iterator.hasNext()) {
    // final Document doc = (Document) iterator.next();
    // System.out.println(doc.toJson());
    // }
    if (iterator.hasNext()) {
      try {
        FacesContext.getCurrentInstance().getExternalContext().redirect(PageUtil.SECOND_PAGE);
      } catch (final IOException e) {
        e.printStackTrace();
      }
    } else {
      FacesContext.getCurrentInstance().addMessage("loginForm:loginButton",
          new FacesMessage("Your email and/or password is incorrect. Please try again"));
    }
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  public void setRememberMe(final boolean rememberMe) {
    this.rememberMe = rememberMe;
  }
}

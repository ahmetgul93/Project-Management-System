package model;

import javax.faces.bean.ManagedBean;

import org.bson.Document;

import com.mongodb.client.FindIterable;

import database.MongoDB;
import util.DbUtil;

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

    final Document querydoc = new Document("email", "sunucuyazilim12@gmail.com");
    querydoc.append("password", "123456A!");
    final FindIterable read = db.read(DbUtil.USER_COLL, querydoc);
    System.out.println("xytrtr");
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

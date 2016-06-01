package base.data;

import javax.faces.bean.ManagedBean;

import org.springframework.data.annotation.Id;

@ManagedBean
public class User {

  @Id
  private String id;

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

package base.data;

/**
 * Defines User data structure.
 *
 * @author anıl öztürk
 * @author ahmet gül
 * @author asım zorlu
 */
public class User {

  private String id;

  private String email;

  private String password;

  private boolean rememberMe;

  public String getEmail() {
    return this.email;
  }

  public String getId() {
    return this.id;
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

  public void setId(final String id) {
    this.id = id;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  public void setRememberMe(final boolean rememberMe) {
    this.rememberMe = rememberMe;
  }
}

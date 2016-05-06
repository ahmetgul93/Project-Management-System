package database;

public interface DBConnections<T, U> {

  public void connect();

  public void disconnect();

  T makeQuery(@SuppressWarnings("unchecked") U... args);
}

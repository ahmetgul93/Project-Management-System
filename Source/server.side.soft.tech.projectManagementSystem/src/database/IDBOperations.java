package database;

public interface IDBOperations {

  public void connect();

  public void create(Object element);

  public void delete(Object filter);

  public void disconnect();

  public void read(Object filter);

  public void update(Object element);
}

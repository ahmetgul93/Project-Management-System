package database;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import util.DbUtil;

public class Database2 {

  private MongoClient mongo;

  private MongoDatabase database;

  @SuppressWarnings("rawtypes")
  protected MongoCollection collection;

  public void closeDb() {
    this.mongo.close();
  }

  public void connectDBCollection(final String name) {
    assert name != null && name != "";
    this.collection = this.database.getCollection(name);
  }

  public void openDb() {
    this.mongo = new MongoClient("localhost", 27017);
    this.database = this.mongo.getDatabase(DbUtil.DB_NAME);
  }
}

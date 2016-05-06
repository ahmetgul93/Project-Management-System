package database;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import util.DbUtil;

public class TestDB implements DBConnections<MongoCursor<Document>, Document> {

  private MongoClient client;

  private MongoDatabase database;

  private MongoCollection<Document> collection;

  @Override
  public void connect() {
    this.client = new MongoClient("localhost");
    this.database = this.client.getDatabase(DbUtil.DB_NAME);

    if (this.database.getCollection(DbUtil.USER_COLL) == null) { // it means also DbUtil.PROJ_COLL
                                                                 // is null
      this.database.createCollection(DbUtil.USER_COLL);
      this.database.createCollection(DbUtil.PROJ_COLL);

      final Document obj = new Document("email", "sunucuyazilim12@gmail.com");
      obj.append("password", "123456A!");

      this.database.getCollection(DbUtil.USER_COLL).insertOne(obj);
    }
  }

  public void connectCollection(final String name) {
    assert name != null && name != "";
    this.collection = this.database.getCollection(name);
  }

  @Override
  public void disconnect() {
    this.client.close();
  }

  @Override
  public MongoCursor<Document> makeQuery(final Document... args) {
    return null;
  }
}

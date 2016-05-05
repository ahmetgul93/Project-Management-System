package database;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import util.DbUtil;

public class MongoDB {

  private static MongoClient mongo;

  private static MongoDatabase database;

  @SuppressWarnings("rawtypes")
  protected MongoCollection collection;

  public MongoDB() {
    this.init();
  }

  public void connectCollection(final String name) {
    assert name != null && name != "";
    this.collection = MongoDB.database.getCollection(name);
  }

  @SuppressWarnings("unchecked")
  public void create(final Object tableName, final Object element) {
    assert element != null;
    this.connectCollection((String) tableName);

    this.collection.insertOne(element);
  }

  public void disconnect() {
    MongoDB.mongo.close();
  }

  private void init() {
    if (MongoDB.mongo == null) {
      MongoDB.mongo = new MongoClient("localhost", 8180);
      MongoDB.database = MongoDB.mongo.getDatabase(DbUtil.DB_NAME);
      MongoDB.database.createCollection(DbUtil.USER_COLL);
      MongoDB.database.createCollection(DbUtil.PROJ_COLL);

      final Document obj = new Document("email", "sunucuyazilim12@gmail.com");
      obj.append("password", "123456A!");

      MongoDB.database.getCollection(DbUtil.USER_COLL).insertOne(obj);

    }
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public FindIterable read(final Object tableName, final Object filter) {
    assert filter != null;
    this.connectCollection((String) tableName);

    return this.collection.find((Class) filter);
  }
}

package database;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;

public class DatabaseCRUD extends Database2 {

  @SuppressWarnings("unchecked")
  public void insertData(final BasicDBObject obj) {
    assert this.collection != null;
    assert obj != null;

    this.collection.insertOne(obj);
  }

  @SuppressWarnings("rawtypes")
  public FindIterable readData(final BasicDBObject obj) {
    assert obj != null;

    return this.collection.find(obj);
  }
}

package me.marlon.legacy.data;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


public class Mongodb{

    public static MongoClient client;
    public static MongoDatabase database;
    public static MongoCollection<Document> account;
    static{
        client = MongoClients.create();
        database = client.getDatabase("legacy");
        account = database.getCollection("account");
    }
}

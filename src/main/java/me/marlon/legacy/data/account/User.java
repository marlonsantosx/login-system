package me.marlon.legacy.data.account;

import com.mongodb.client.model.Filters;
import me.marlon.legacy.data.Mongodb;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.text.SimpleDateFormat;

public class User implements UserData{

    public final String username;
    private Document document;
    private final Bson filter;

    public final boolean has;

    public User(String username) {
        this.username = username;
        filter = Filters.eq("username", username);
        document = Mongodb.account.find(filter).first();
        if(document == null) {
            has = false;
            document = new Document("username", username);
        } else
            has = true;
    }

    @Override
    public void create() {

    }

    @Override
    public void update(final String name, final Object object) {
        if (has)
            Mongodb.account.updateOne(filter, new Document("$set", new Document(name, object)));
        else
            Mongodb.account.insertOne(document);
        document.put(name, object);
    }

    @Override
    public long getFirstLogin() {
        return document.getLong("firstLogin");
    }

    @Override
    public void setFirstLogin(long paramLong) {
        update("firstLogin", paramLong);
    }

    @Override
    public long getLastSeen() {
        return document.getLong("getLastSeen");
    }

    @Override
    public void setLastSeen(long paramLong) {
        update("lastSeen", paramLong);
    }

    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy - HH:mm");

    @Override
    public String getFormattedFirstLogin() {
        return format.format(getFirstLogin());
    }

    @Override
    public String getFormattedLastSeen() {
        return format.format(getLastSeen());
    }

    @Override
    public String getName() {
        return document.getString("username");
    }

    @Override
    public void setName() {
        update("username", username);
    }

    @Override
    public String getSorname() {
        return document.getString("userLastName");
    }

    @Override
    public void setSorname(String paramString) {
        update("userLastName", paramString);
    }

    @Override
    public String getEmail() {
        return document.getString("email");
    }

    @Override
    public void setEmail(String paramString) {
        update("email", paramString);
    }

    @Override
    public String getPassword() {
        return document.getString("password");
    }

    @Override
    public void setPassword(String paramString) {
        update("password", paramString);
    }
}

package me.marlon.legacy.data.account;

import com.mongodb.client.model.Filters;
import me.marlon.legacy.data.Mongodb;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.text.SimpleDateFormat;

public class User implements UserData{

    public final String email;
    private Document document;
    private final Bson filter;

    public boolean has;

    public User(String email) {
        this.email = email;
        filter = Filters.eq("email", email);
        document = Mongodb.account.find(filter).first();
        if(document == null) {
            has = false;
            document = new Document("email", email);
        } else
            has = true;
    }


    @Override
    public void create() {

    }

    @Override
    public void update(final String name, final Object object) {
        document.put(name, object);
        if (!has) {
            Mongodb.account.insertOne(document);
            has = true;
        } else
            Mongodb.account.updateOne(filter, new Document("$set", new Document(name, object)));
    }

    @Override
    public String getEmail() {
        return document.getString("email");
    }

    @Override
    public void setEmail() {
        update("email", this.email);
    }

    @Override
    public String getFirstName() {
        return document.getString("firstName");
    }

    @Override
    public void setFirstName(String paramString) {
        update("firstName", paramString);
    }

    @Override
    public String getLastName() {
        return document.getString("lastName");
    }

    @Override
    public void setLastName(String paramString) {
        update("lastName", paramString);
    }

    @Override
    public String getPassword() {
        return document.getString("password");
    }

    @Override
    public void setPassword(String paramString) {
        update("password", paramString);
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

}

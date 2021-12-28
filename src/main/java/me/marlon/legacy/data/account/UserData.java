package me.marlon.legacy.data.account;

public interface UserData {

    void create();
    void update(String paramString, Object paramObject);

    String getEmail();
    void setEmail();

    String getFirstName();
    void setFirstName(String paramString);

    String getLastName();
    void setLastName(String paramString);

    String getPassword();
    void setPassword(String paramString);

    long getFirstLogin();
    void setFirstLogin(long paramLong);

    long getLastSeen();
    void setLastSeen(long paramLong);

    String getFormattedFirstLogin();
    String getFormattedLastSeen();

}

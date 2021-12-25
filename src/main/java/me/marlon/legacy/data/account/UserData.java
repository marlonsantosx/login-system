package me.marlon.legacy.data.account;

public interface UserData {

    void create();
    void update(String paramString, Object paramObject);

    long getFirstLogin();
    void setFirstLogin(long paramLong);

    long getLastSeen();
    void setLastSeen(long paramLong);
    
    String getFormattedFirstLogin();
    String getFormattedLastSeen();

    String getName();
    void setName();

    String getSorname();
    void setSorname(String paramString);

    String getEmail();
    void setEmail(String paramString);

    String getPassword();
    void setPassword(String paramString);



}

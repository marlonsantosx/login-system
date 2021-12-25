package me.marlon.legacy.data.account;

public interface UserData {

    void create();
    void update();

    long getFirstLogin();
    void setFirstLogin(long paramLong);

    long getLastSenn();
    void setLastSeen(long paramLong);

    String getName();
    void setName(String paramString);

    String getSorname();
    void setSorname(String paramString);

    String getEmail();
    void setEmail(String paramString);

    String getPassword();
    void setPassword(String paramString);

}

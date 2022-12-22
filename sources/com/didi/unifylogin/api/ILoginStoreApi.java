package com.didi.unifylogin.api;

public interface ILoginStoreApi {
    void dataMigration(String str, String str2, long j, int i);

    String getAreaCode();

    String getCountryCode();

    String getGlobalPhone();

    String getHideEmail();

    long getLongUid();

    String getPhone();

    String getPlaintTextEmail();

    int getRole();

    String getTemporaryToken();

    String getToken();

    String getUid();

    boolean isDoubleIdentity();

    boolean isLoginNow();

    boolean isNewUser();

    void setPhone(String str);
}

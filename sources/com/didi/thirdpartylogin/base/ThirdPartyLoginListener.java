package com.didi.thirdpartylogin.base;

public interface ThirdPartyLoginListener {
    void onFailure(Exception exc);

    void onSucess(String str, String str2);
}

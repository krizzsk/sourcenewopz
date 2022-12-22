package com.didichuxing.apollo.sdk;

public interface IUserInfoDelegate {
    String getLang();

    String getLatString();

    String getLngString();

    String getLocationCityId();

    String getOrderCityId();

    @Deprecated
    String getPhone();

    String getToken();

    String getUid();
}

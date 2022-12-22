package com.dmap.navigation.base.ctx;

public interface IUserInfo {
    int getBizType();

    String getCityId();

    String getDidiVersion();

    String getImei();

    String getOs();

    String getPhone();

    String getTicket();

    String getUserId();

    void setBizType(int i);

    void setCityId(String str);

    void setCountryId(String str);

    void setDidiVersion(String str);

    void setImei(String str);

    void setOs(String str);

    void setPhone(String str);

    void setPlateNumber(String str);

    void setTicket(String str);

    void setUserId(String str);
}

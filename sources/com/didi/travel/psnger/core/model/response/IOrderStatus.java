package com.didi.travel.psnger.core.model.response;

public interface IOrderStatus {
    int intervalTime();

    boolean isTimeout();

    String lineMD5();

    String oid();

    void setOid(String str);

    void setStatus(int i);

    void setSubStatus(int i);

    int status();

    int subStatus();
}

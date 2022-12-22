package com.didi.map.sdk.passengerlocation;

import java.util.List;

public interface IPsgLocationDataSource {

    public interface PsgLocationCallback {
        void onSuccess(List<PassengerInfo> list);
    }

    void fetchPassengerLocation(List<PassengerInfo> list, PsgLocationCallback psgLocationCallback);

    void onMapVisible(boolean z);

    void setBizType(int i);

    void setPhoneNum(String str);

    void setToken(String str);

    void setTraverID(String str);
}

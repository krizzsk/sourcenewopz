package com.didi.entrega.manager.base;

public interface ICustomerManager {
    String getManagerName();

    void onCreate();

    void onDestroy();

    void onStart();

    void onStop();
}

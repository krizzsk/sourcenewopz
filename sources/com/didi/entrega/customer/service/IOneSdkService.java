package com.didi.entrega.customer.service;

import android.content.Context;
import com.didi.entrega.customer.foundation.rpc.entity.UserInfoEntity;

public interface IOneSdkService extends IService {
    void closeSideMenu();

    UserInfoEntity getUserInfo();

    void logOut(Context context, String str);

    void openOrderHistory();

    void openSideMenu();

    void popBack(boolean z);

    void popToRootActivity();

    @Deprecated
    void switchToRiderTab();
}

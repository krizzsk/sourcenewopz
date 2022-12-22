package com.didi.soda.customer.service;

import android.content.Context;
import com.didi.app.nova.skeleton.Page;
import com.didi.soda.customer.foundation.rpc.entity.UserInfoEntity;

public interface IOneSdkService extends IService {
    UserInfoEntity getUserInfo();

    boolean isHolderPage(Page page);

    void logOut(Context context, String str);

    void open(String str);

    void openOrderHistory();

    void popBackStack();

    void popToRootActivity();

    void refreshTab();

    void setUnReadRedCount(int i);

    void setUnreadImCount(int i);

    void switchToRiderTab();

    void toast(String str);
}

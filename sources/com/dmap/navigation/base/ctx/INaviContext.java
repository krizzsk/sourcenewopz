package com.dmap.navigation.base.ctx;

import android.content.Context;

public interface INaviContext {
    Context getAndroidContext();

    INaviOption getNaviOption();

    IOrderInfo getOrderInfo();

    IUserInfo getUserInfo();
}

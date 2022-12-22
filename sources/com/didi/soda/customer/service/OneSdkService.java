package com.didi.soda.customer.service;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.sdk.events.SwitchTypeEvent;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.foundation.rpc.entity.UserInfoEntity;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.home.page.CustomerMainPage;
import com.didi.usercenter.api.UserCenterFacade;
import com.didi.usercenter.entity.UserInfo;
import org.greenrobot.eventbus.EventBus;

public class OneSdkService implements IOneSdkService {
    public void refreshTab() {
    }

    public void setUnReadRedCount(int i) {
    }

    public void setUnreadImCount(int i) {
    }

    public UserInfoEntity getUserInfo() {
        UserInfo userInfo = UserCenterFacade.getIns().getUserInfo(GlobalContext.getContext());
        if (userInfo == null) {
            return null;
        }
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.firstName = userInfo.getFirst_name();
        userInfoEntity.lastName = userInfo.getLast_name();
        userInfoEntity.headUrl = userInfo.getHead_url();
        return userInfoEntity;
    }

    public void openOrderHistory() {
        DRouter.build(RoutePath.PASSENGER_ORDER_HISTORY_SODA).start();
    }

    public void popToRootActivity() {
        if (GlobalContext.getContext() != null) {
            Intent intent = new Intent();
            intent.setFlags(View.STATUS_BAR_TRANSIENT);
            ((Request) DRouter.build("gloablpassenger://mainactivity").putAddition("intent", intent)).start(GlobalContext.getContext());
        }
    }

    public void switchToRiderTab() {
        EventBus.getDefault().post(new SwitchTypeEvent("ride"));
    }

    public void popBackStack() {
        GlobalContext.getBusinessContext().getNavigation().popBackStack();
    }

    public void logOut(Context context, String str) {
        LoginUtil.logOut(context, str);
    }

    public void toast(String str) {
        ToastUtil.showCustomerToast((ScopeContext) null, str);
    }

    public void open(String str) {
        DRouter.build(str).start();
    }

    public boolean isHolderPage(Page page) {
        if (page instanceof CustomerMainPage) {
            return ((CustomerMainPage) page).isHolderPage();
        }
        return false;
    }
}

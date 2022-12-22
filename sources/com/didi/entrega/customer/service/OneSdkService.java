package com.didi.entrega.customer.service;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.rpc.entity.UserInfoEntity;
import com.didi.entrega.customer.foundation.util.LoginUtil;
import com.didi.sdk.events.SwitchTypeEvent;
import com.didi.sdk.sidebar.history.HistoryRecordFragment;
import com.didi.usercenter.api.UserCenterFacade;
import com.didi.usercenter.entity.UserInfo;
import org.greenrobot.eventbus.EventBus;

public class OneSdkService implements IOneSdkService {
    public void closeSideMenu() {
    }

    public void openSideMenu() {
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
        Intent intent = new Intent();
        intent.setClass(GlobalContext.getContext(), HistoryRecordFragment.class);
        GlobalContext.getBusinessContext().getNavigation().transition(GlobalContext.getBusinessContext(), intent);
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

    public void popBack(boolean z) {
        if (z) {
            GlobalContext.getBusinessContext().getNavigation().popBackStack();
        } else {
            EventBus.getDefault().post(new SwitchTypeEvent("ride"));
        }
    }

    public void logOut(Context context, String str) {
        LoginUtil.logOut(context, str);
    }
}

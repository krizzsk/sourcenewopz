package com.didi.component.common.router.common;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.didi.app.router.sidebar.BaseSideBarDRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.app.BusinessContextManager;
import com.didi.sdk.app.INavigation;
import com.didi.sdk.sidebar.SidebarEvent;
import com.didi.sdk.sidebar.history.HistoryRecordFragment;
import com.didi.sdk.util.EventKeys;
import com.taxis99.R;
import org.greenrobot.eventbus.EventBus;

public class ToHistoryHandler extends BaseSideBarDRouterHandler {
    public void callRealHandle(Request request, Result result) {
        BaseBusinessContext curBusinessContext;
        Uri uri = request.getUri();
        if (uri != null && (curBusinessContext = BusinessContextManager.getInstance().getCurBusinessContext()) != null) {
            EventBus.getDefault().post(new SidebarEvent(EventKeys.Sidebar.CLOSE_SIDEBAR));
            Intent intent = new Intent();
            INavigation.TransactionAnimation transactionAnimation = new INavigation.TransactionAnimation(R.anim.slide_in, 0, 0, R.anim.slide_out);
            intent.setClass(curBusinessContext.getContext(), HistoryRecordFragment.class);
            Bundle bundle = new Bundle();
            bundle.putString("groupType", uri.getQueryParameter("groupType"));
            intent.putExtras(bundle);
            curBusinessContext.getNavigation().transition(curBusinessContext, intent, transactionAnimation);
        }
    }
}

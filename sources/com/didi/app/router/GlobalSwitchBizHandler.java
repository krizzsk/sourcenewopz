package com.didi.app.router;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.sdk.app.TabEventManager;
import com.didi.sdk.events.SwitchTypeEvent;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.util.SaApolloUtil;
import com.didi.sdk.util.UiThreadHandler;
import org.greenrobot.eventbus.EventBus;

public class GlobalSwitchBizHandler implements IRouterHandler {
    public static final String PARAM_GROUP_TYPE = "groupType";

    /* renamed from: a */
    private static final String f8666a = "taxis99onetravel://ride/backhome";

    /* renamed from: b */
    private static final String f8667b = (NationTypeUtil.getNationComponentData().getProductPreFix() + "OneTravel://%s/entrance");

    public void handle(Request request, Result result) {
        final Uri uri = request.getUri();
        if (uri != null) {
            final TabEventManager.TabHandleModel tabHandleModel = new TabEventManager.TabHandleModel();
            tabHandleModel.setFromTab(TabEventManager.INSTANCE.getFromTab(true));
            if (!SaApolloUtil.INSTANCE.getSaState()) {
                DRouter.build(f8666a).start();
            }
            String str = "";
            final String queryParameter = uri.getQueryParameter("groupType") != null ? uri.getQueryParameter("groupType") : str;
            if (uri.getQueryParameter("url") != null) {
                str = uri.getQueryParameter("url");
            }
            tabHandleModel.setActionType(TabEventManager.TYPE.LINK);
            tabHandleModel.setActionUrl(str);
            if (!SaApolloUtil.INSTANCE.getSaState()) {
                UiThreadHandler.postDelayed(new Runnable() {
                    public void run() {
                        SwitchTypeEvent switchTypeEvent = new SwitchTypeEvent(queryParameter);
                        switchTypeEvent.urlGetParams = uri.toString();
                        switchTypeEvent.tabHandleModel = tabHandleModel;
                        EventBus.getDefault().post(switchTypeEvent);
                    }
                }, 200);
            } else if (TextUtils.isEmpty(str)) {
                String format = String.format(f8667b, new Object[]{queryParameter});
                SwitchTypeEvent switchTypeEvent = new SwitchTypeEvent(queryParameter);
                switchTypeEvent.scheme = format;
                Bundle bundle = new Bundle();
                bundle.putString("action_type", TabEventManager.TYPE.LINK.getValue());
                switchTypeEvent.extraBundle = bundle;
                EventBus.getDefault().post(switchTypeEvent);
            } else {
                ((Request) DRouter.build(str).putExtra("action_type", TabEventManager.TYPE.LINK.getValue())).start();
            }
        }
    }
}

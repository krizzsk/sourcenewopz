package com.didi.app.router;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.didi.component.base.BasePagerSwitcher;
import com.didi.component.business.receiver.ReceiverConstant;
import com.didi.component.core.Animations;
import com.didi.component.core.IPresenter;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.sdk.app.ActivityStack;
import com.didi.sdk.app.BroadcastSender;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.events.SwitchTypeEvent;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import org.greenrobot.eventbus.EventBus;

public class PageRouter {
    public static final String VAMOS_BID = "bid";
    public static final String VAMOS_OID = "oid";
    public static final String VAMOS_PATH = "/order";
    public static final String VAMOS_ROLE = "role";
    public static final String VAMOS_ROLE_DRIVER = "driver";
    public static final String VAMOS_ROLE_PASSENGER = "passenger";
    public static final String VAMOS_SCHEME = "taxis99OneTravel";
    public static final String VAMOS_SOURCE = "source";
    public static final String VAMOS_TRIPID = "tripid";

    /* renamed from: a */
    private BusinessContext f8670a;

    /* renamed from: b */
    private BasePagerSwitcher f8671b;

    private static class PageRouterHolder {
        /* access modifiers changed from: private */
        public static final PageRouter INSTANCE = new PageRouter();

        private PageRouterHolder() {
        }
    }

    public static final PageRouter getInstance() {
        return PageRouterHolder.INSTANCE;
    }

    public void setBusinessContext(BusinessContext businessContext) {
        this.f8670a = businessContext;
        this.f8671b = new BasePagerSwitcher(businessContext, (Fragment) null);
    }

    public boolean forward(int i, Bundle bundle) {
        return forward(i, bundle, (Animations) null);
    }

    public boolean forward(int i, Bundle bundle, Animations animations) {
        ActivityStack.pop2MainActivity();
        Class cls = IPresenter.templateMapping.get(Integer.valueOf(i));
        if (cls != null) {
            return forward((Class<? extends Fragment>) cls, bundle, animations);
        }
        return false;
    }

    public boolean forward(Class<? extends Fragment> cls, Bundle bundle) {
        return forward(cls, bundle, (Animations) null);
    }

    public boolean forward(Class<? extends Fragment> cls, Bundle bundle, Animations animations) {
        BasePagerSwitcher basePagerSwitcher = this.f8671b;
        if (basePagerSwitcher == null) {
            return false;
        }
        basePagerSwitcher.forward(cls, bundle, animations);
        return false;
    }

    public void forwardRide(Context context, String str, int i, int i2) {
        if (str != null) {
            Intent intent = new Intent();
            intent.setAction(ReceiverConstant.ACTION_RECOVERY);
            intent.setData(Uri.parse("OneReceiver://" + "extended" + ReceiverConstant.MATCHER_RECOVER));
            intent.putExtra("oid", str);
            intent.putExtra("product_id", i);
            intent.putExtra("source", i2);
            BroadcastSender.getInstance(context).sendBroadcast(intent);
            EventBus.getDefault().post(new SwitchTypeEvent("ride"));
        }
    }

    public void forwardVamosDriver(Context context, String str, int i, String str2) {
        forwardVamosDriver(context, str, "", i, str2);
    }

    public void forwardVamosDriver(Context context, String str, String str2, int i, String str3) {
        DRouter.build("taxis99OneTravel://vamos/order?" + "role=driver&tripid=" + str + ParamKeys.SIGN_AND + "oid" + "=" + str2 + ParamKeys.SIGN_AND + "bid" + "=" + i + ParamKeys.SIGN_AND + "source" + "=" + str3 + ParamKeys.SIGN_AND + DRouterUrlInterceptor.TAG_NO_SWITCH_TAP + "=1").start(context);
    }

    public void forwardVamosPax(Context context, String str, int i, String str2) {
        DRouter.build("taxis99OneTravel://vamos/order?" + "role=passenger&oid=" + str + ParamKeys.SIGN_AND + "bid" + "=" + i + ParamKeys.SIGN_AND + "source" + "=" + str2 + ParamKeys.SIGN_AND + DRouterUrlInterceptor.TAG_NO_SWITCH_TAP + "=1").start(context);
    }

    public void startMainActivity(Context context, Intent intent) {
        ((Request) DRouter.build("gloablpassenger://mainactivity").putAddition("intent", intent)).start(context);
    }
}

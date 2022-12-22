package com.didi.greatwall.protocol;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.didi.greatwall.util.log.GLogger;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public abstract class BaseActivityComponent extends AbsComponent {

    /* renamed from: a */
    private GLogger f22964a = GLogger.getLogger();

    /* renamed from: b */
    private WeakReference<Context> f22965b;

    /* renamed from: c */
    private Intent f22966c;

    /* access modifiers changed from: protected */
    public abstract String getComponentName();

    /* access modifiers changed from: protected */
    public abstract Class<? extends Activity> getTargetActivity();

    public void onResume() {
        Context context = (Context) this.f22965b.get();
        if (context != null) {
            startTargetActivity(context, this.f22966c);
            return;
        }
        this.f22964a.warn("ProgressComponent startActivity failed,context null ,maybe gc");
        ComponentBridge.getInstance().executeFinish(getComponentName(), 2, (JSONObject) null);
    }

    public void onCreate(Context context, Bundle bundle, ComponentListener componentListener) {
        GLogger gLogger = this.f22964a;
        gLogger.info(getComponentName() + "component onCreate......");
        this.f22965b = new WeakReference<>(context);
        Intent intent = new Intent(context, getTargetActivity());
        this.f22966c = intent;
        intent.putExtras(bundle);
        ComponentBridge.getInstance().addExecuteCallback(getComponentName(), componentListener);
    }

    public void onDestroy() {
        WeakReference<Context> weakReference = this.f22965b;
        if (weakReference != null) {
            weakReference.clear();
        }
        GLogger gLogger = this.f22964a;
        gLogger.info(getComponentName() + " component destroy");
    }

    /* access modifiers changed from: protected */
    public void startTargetActivity(Context context, Intent intent) {
        intent.addFlags(268435456);
        context.startActivity(intent);
    }
}

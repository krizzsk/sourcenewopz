package com.didi.beatles.p099im.plugin;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.protocol.host.IMMessageViewStatusCallback;
import com.didi.beatles.p099im.protocol.model.IMRenderCardEnv;
import com.didi.beatles.p099im.protocol.plugin.IIMPluginCardView;
import com.didi.beatles.p099im.utils.C4234I;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.views.custom.IMCustomCardViewBaseProvider;
import java.lang.reflect.Constructor;

/* renamed from: com.didi.beatles.im.plugin.IMPluginCardViewProvider */
public class IMPluginCardViewProvider extends IMCustomCardViewBaseProvider {

    /* renamed from: a */
    private static final String f9470a = IMPluginCardViewProvider.class.getSimpleName();

    /* renamed from: b */
    private SparseArray<Class<? extends View>> f9471b = new SparseArray<>();
    protected IMMessageViewStatusCallback mStatusCallback;

    public final void bindData(int i, View view, String str) {
    }

    public void setMessageViewStatusCallback(IMMessageViewStatusCallback iMMessageViewStatusCallback) {
        this.mStatusCallback = iMMessageViewStatusCallback;
    }

    public void removeMessageViewStatusCallback(IMMessageViewStatusCallback iMMessageViewStatusCallback) {
        this.mStatusCallback = null;
    }

    public void registerPluginMessageView(int i, Class<? extends View> cls) {
        this.f9471b.put(i, cls);
    }

    public View getView(Context context, View view, int i) {
        Class cls = this.f9471b.get(i);
        String str = f9470a;
        IMLog.m6631d(str, "[getView] viewType=" + i + " |clazz=" + cls);
        if (cls == null) {
            IMLog.m6632e(f9470a, C4234I.m6591t("custom im card not support type ", Integer.valueOf(i)));
            return null;
        }
        try {
            Constructor constructor = cls.getConstructor(new Class[]{Context.class});
            if (constructor != null) {
                return (View) constructor.newInstance(new Object[]{context});
            }
        } catch (Exception e) {
            IMLog.m6632e(f9470a, C4234I.m6591t("create custom card failed, view class = ", cls.getName(), " errMsg = ", e.toString()));
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onBindData(int i, View view, String str, IMMessage iMMessage, IMRenderCardEnv iMRenderCardEnv) {
        if (view == null) {
            IMLog.m6632e(f9470a, C4234I.m6591t("[bindData] with NULL view. position=", Integer.valueOf(i), " |data=", str));
        } else if (view instanceof IIMPluginCardView) {
            ((IIMPluginCardView) view).onBind(i, iMRenderCardEnv, str, this.mStatusCallback);
        } else {
            IMLog.m6632e(f9470a, C4234I.m6591t("view @", view.getClass().getCanonicalName(), "@ not implement interface IIMPluginCardView."));
        }
    }

    public void clear() {
        super.clear();
        this.mStatusCallback = null;
        SparseArray<Class<? extends View>> sparseArray = this.f9471b;
        if (sparseArray != null) {
            sparseArray.clear();
        }
    }
}

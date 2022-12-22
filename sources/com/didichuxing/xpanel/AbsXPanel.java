package com.didichuxing.xpanel;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import com.didichuxing.xpanel.agent.IXPanelAgentClickListener;
import com.didichuxing.xpanel.base.IXPanelLife;
import com.didichuxing.xpanel.base.IXPanelViewPrivate;
import com.didichuxing.xpanel.base.IXPanelViewPublic;
import com.didichuxing.xpanel.channel.global.impl.IXPanelSpaceInterceptor;
import com.didichuxing.xpanel.util.LogcatUtil;
import com.didichuxing.xpanel.util.Utils;
import com.didichuxing.xpanel.util.XPanelApolloUtil;
import com.didichuxing.xpanel.util.XPanelOmegaUtils;

public abstract class AbsXPanel<V extends IXPanelViewPrivate> implements IXPanelLife, IXPanelViewPublic {
    public static boolean mIsDebug = false;
    protected Context mContext;
    protected String mCountryCode;
    protected V mView;

    /* access modifiers changed from: protected */
    public abstract String getCountryCode();

    /* access modifiers changed from: protected */
    public abstract V getViewImpl(Context context);

    public AbsXPanel(Context context) {
        this.mContext = context;
        XPanelOmegaUtils.initXPanelOmega();
        V viewImpl = getViewImpl(context);
        this.mView = viewImpl;
        if (viewImpl != null) {
            boolean status = XPanelApolloUtil.getStatus("global_xpanel_debug_accessory");
            mIsDebug = status;
            if (status || Utils.isDebug(context)) {
                LogcatUtil.sLogEnable = true;
                LogcatUtil.m35796i("", "xpanel log open!");
            } else {
                LogcatUtil.sLogEnable = false;
            }
            setCountryCode(getCountryCode());
            XPanelOmegaUtils.X_PANEL_COUNTRY = getCountryCode();
            return;
        }
        throw new RuntimeException("AbsXPanel: view can't be null");
    }

    public void destroy() {
        this.mView.destroy();
    }

    public void onResume() {
        this.mView.onResume();
    }

    public void onPause() {
        this.mView.onPause();
    }

    public void setCountryCode(String str) {
        float f;
        if ("52".equals(str)) {
            f = TypedValue.applyDimension(1, 40.0f, this.mContext.getResources().getDisplayMetrics());
        } else {
            f = TypedValue.applyDimension(1, 30.0f, this.mContext.getResources().getDisplayMetrics());
        }
        this.mCountryCode = str;
        this.mView.setMinShowHeight((int) f);
    }

    public final View getView() {
        return this.mView.getView();
    }

    public void bindAgentClickListener(IXPanelAgentClickListener iXPanelAgentClickListener) {
        this.mView.bindAgentClickListener(iXPanelAgentClickListener);
    }

    public void setMinShowHeight(int i) {
        this.mView.setMinShowHeight(i);
    }

    public void bindSpaceInterceptor(IXPanelSpaceInterceptor iXPanelSpaceInterceptor) {
        this.mView.bindSpaceInterceptor(iXPanelSpaceInterceptor);
    }
}

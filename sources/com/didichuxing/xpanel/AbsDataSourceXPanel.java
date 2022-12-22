package com.didichuxing.xpanel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.xpanel.agent.AgentRequestCallBack;
import com.didichuxing.xpanel.agent.IAgentCallBack;
import com.didichuxing.xpanel.agent.IXPanelAgentClickListener;
import com.didichuxing.xpanel.agent.IXPanelAgentListener;
import com.didichuxing.xpanel.agent.IXPanelDataSource;
import com.didichuxing.xpanel.agent.XPanelDataSource;
import com.didichuxing.xpanel.agent.net.XPanelRequest;
import com.didichuxing.xpanel.base.IXPanelViewPrivate;
import com.didichuxing.xpanel.base.XPanelCardData;
import com.didichuxing.xpanel.debug.p199ui.DebugActivity;
import com.didichuxing.xpanel.util.LogcatUtil;
import com.didichuxing.xpanel.util.XPanelApolloUtil;
import com.didichuxing.xpanel.xcard.ParseHelper;
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;

public abstract class AbsDataSourceXPanel<T extends IXPanelViewPrivate, N extends XPanelDataSource> extends AbsXPanel<T> implements IXPanelDataSource {

    /* renamed from: a */
    private static final String f49270a = "AbsDataSourceXPanel";
    /* access modifiers changed from: protected */
    public N mData;

    /* access modifiers changed from: protected */
    public abstract N createXPanelDataSource(Context context);

    public AbsDataSourceXPanel(final Context context) {
        super(context);
        N createXPanelDataSource = createXPanelDataSource(context);
        this.mData = createXPanelDataSource;
        createXPanelDataSource.setAgentCallBack(new IAgentCallBack() {
            public void notify(List<XPanelCardData> list, boolean z) {
                Activity activity;
                Context context = context;
                if (!(context instanceof Activity) || ((activity = (Activity) context) != null && !activity.isFinishing() && (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()))) {
                    AbsDataSourceXPanel.this.mView.notifyAll(list, z);
                } else {
                    LogcatUtil.m35794d(AbsDataSourceXPanel.f49270a, "ACTIVITY has destroyed");
                }
            }
        });
        m35531a(context);
    }

    /* renamed from: a */
    private void m35531a(Context context) {
        if (mIsDebug && this.mView != null) {
            m35533b(context);
        }
    }

    /* renamed from: b */
    private void m35533b(final Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setId(R.id.debug_view);
        imageView.setImageResource(R.drawable.oc_x_panel_debug_access);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(context.getResources().getDimensionPixelSize(R.dimen.oc_x_panel_debug_image_width), context.getResources().getDimensionPixelSize(R.dimen.oc_x_panel_debug_image_height));
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(R.dimen._10dip);
        layoutParams.bottomMargin = 300;
        layoutParams.gravity = 83;
        ViewGroup handleView = this.mView.getHandleView();
        if (handleView != null) {
            handleView.addView(imageView, layoutParams);
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    context.startActivity(new Intent(context, DebugActivity.class));
                }
            });
        }
    }

    public void notifyServiceCards(List<XPanelCardData> list) {
        this.mData.notifyServiceCards(list);
    }

    public void notifyServiceCards(List<XPanelCardData> list, boolean z) {
        this.mData.notifyServiceCards(list, z);
    }

    public void reloadAgent(String str, HashMap<String, Object> hashMap, boolean z) {
        reloadAgent(false, str, hashMap, z, (AgentRequestCallBack) null);
    }

    public void reloadAgent(boolean z, String str, HashMap<String, Object> hashMap, boolean z2, AgentRequestCallBack agentRequestCallBack) {
        m35532a(hashMap);
        this.mData.reloadAgent(z, str, hashMap, z2, agentRequestCallBack);
    }

    /* renamed from: a */
    private void m35532a(HashMap<String, Object> hashMap) {
        if (hashMap.get("trip_country") == null && !TextUtils.isEmpty(this.mCountryCode)) {
            hashMap.put("trip_country", this.mCountryCode);
        }
        if (XPanelApolloUtil.isXPanelMixOrderEnabled()) {
            hashMap.put("xp_mixed_order", true);
        }
        if (XPanelApolloUtil.isXPanelXCardV2Enabled()) {
            hashMap.put("xp_xd_v", "2.0.0");
        } else {
            hashMap.put("xp_xd_v", ParseHelper.XCARD_VERSION);
        }
        hashMap.put("xp_wx_v", "1.0.0");
    }

    public String getCurrentDimension() {
        return this.mData.getCurrentDimension();
    }

    public void notifyShowList() {
        this.mData.notifyShowList();
    }

    public void bindAgentClickListener(IXPanelAgentClickListener iXPanelAgentClickListener) {
        super.bindAgentClickListener(iXPanelAgentClickListener);
        this.mData.bindAgentClickListener(iXPanelAgentClickListener);
    }

    public void setXPanelAgentListener(IXPanelAgentListener iXPanelAgentListener) {
        this.mData.setXPanelAgentListener(iXPanelAgentListener);
    }

    public void onResume() {
        LogcatUtil.m35796i(f49270a, "onRessume....");
        super.onResume();
        if (mIsDebug) {
            XPanelRequest instance = XPanelRequest.getInstance(this.mContext);
            if (instance.isNeedReload()) {
                reload();
            }
            instance.setReloadStatus(false);
        }
        this.mData.onResume();
    }

    public void onPause() {
        LogcatUtil.m35796i(f49270a, "onPause....");
        super.onPause();
        this.mData.onPause();
    }

    public void destroy() {
        LogcatUtil.m35796i(f49270a, "destroy....");
        super.destroy();
        this.mData.destroy();
    }

    public void onBackHome() {
        this.mData.onBackHome();
    }

    public void onLeaveHome() {
        this.mData.onLeaveHome();
    }

    public void onCreate() {
        LogcatUtil.m35796i(f49270a, "onCreate....");
        this.mData.onCreate();
    }

    public void reload() {
        this.mData.reload();
    }

    public void testResult(String str, String str2) {
        this.mData.testResult(str, str2);
    }

    public void reloadByCardIds(String[] strArr, HashMap<String, Object> hashMap) {
        m35532a(hashMap);
        this.mData.reloadByCardIds(strArr, hashMap);
    }

    public void removeAgentCard(XPanelCardData xPanelCardData) {
        this.mData.removeAgentCard(xPanelCardData);
    }
}

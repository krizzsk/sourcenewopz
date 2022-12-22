package com.didichuxing.xpanel.channel.global;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.global.globalgenerickit.CommonEventListener;
import com.didi.global.globalgenerickit.GGKData;
import com.didi.global.globalgenerickit.GlobalGenericKit;
import com.didi.global.globalgenerickit.template.yoga.CDNTemplateBinder;
import com.didi.global.globalgenerickit.template.yoga.EventListener;
import com.didi.global.globalgenerickit.template.yoga.XMLCacheEntity;
import com.didichuxing.xpanel.AbsDataSourceXPanel;
import com.didichuxing.xpanel.base.IStateChangeListener;
import com.didichuxing.xpanel.base.XPanelCardData;
import com.didichuxing.xpanel.channel.global.GlobalXPanelView;
import com.didichuxing.xpanel.channel.global.impl.IGlobalXPanelView;
import com.didichuxing.xpanel.channel.global.impl.IXPanelCallBack;
import com.didichuxing.xpanel.channel.global.impl.IXPanelSpaceInterceptor;
import com.didichuxing.xpanel.channel.global.widget.XPanelHeaderBarView;
import com.didichuxing.xpanel.global.models.XPanelModels;
import com.didichuxing.xpanel.message.IXPanelMessageContainer;
import com.didichuxing.xpanel.util.RegisterUtil;
import com.didichuxing.xpanel.util.XPanelApolloUtil;
import java.lang.ref.WeakReference;
import java.util.Map;

public class GlobalXPanel extends AbsDataSourceXPanel<GlobalXPanelView, GlobalDataSource> implements IGlobalXPanelView {

    /* renamed from: a */
    private GlobalXPanelView f49336a;

    /* access modifiers changed from: protected */
    public String getCountryCode() {
        return "global";
    }

    static {
        RegisterUtil.registeChannelCardView(RegisterUtil.Channel.GLOBAL);
    }

    public GlobalXPanel(Context context, GlobalXPanelView.XPanelConfig xPanelConfig, View view) {
        super(context);
        this.f49336a.init(xPanelConfig, view);
        GlobalGenericKit.showDebugView(XPanelApolloUtil.isGenericKitDebugEnable());
    }

    private static class StaticCDNTemplateBinder extends CDNTemplateBinder {
        private WeakReference<GlobalXPanel> mWeakGlobalXpanel;

        public StaticCDNTemplateBinder(GlobalXPanel globalXPanel) {
            this.mWeakGlobalXpanel = new WeakReference<>(globalXPanel);
        }

        public void onCDNCached(XMLCacheEntity xMLCacheEntity) {
            GlobalXPanel globalXPanel;
            WeakReference<GlobalXPanel> weakReference = this.mWeakGlobalXpanel;
            if (weakReference != null && (globalXPanel = (GlobalXPanel) weakReference.get()) != null && globalXPanel.mData != null) {
                ((GlobalDataSource) globalXPanel.mData).prepareToNotifyList();
            }
        }

        public EventListener createEventListener(GGKData gGKData) {
            return new StaticCommonEventListener(gGKData);
        }
    }

    private static class StaticCommonEventListener extends CommonEventListener {
        public StaticCommonEventListener(GGKData gGKData) {
            super(gGKData);
        }

        public boolean handleEvent(String str, String str2, Map<String, Object> map) {
            Object obj = this.data.getExt().get("cardData");
            if (obj instanceof XPanelCardData) {
                ((XPanelCardData) obj).clickCardOmega((Map<String, Object>) null);
            }
            return super.handleEvent(str, str2, map);
        }
    }

    public GlobalXPanel(Context context, GlobalXPanelView.XPanelConfig xPanelConfig) {
        this(context, xPanelConfig, (View) null);
    }

    public GlobalXPanel(Context context) {
        this(context, (GlobalXPanelView.XPanelConfig) null);
    }

    /* access modifiers changed from: protected */
    public GlobalDataSource createXPanelDataSource(Context context) {
        return new GlobalDataSource(context);
    }

    /* access modifiers changed from: protected */
    public GlobalXPanelView getViewImpl(Context context) {
        GlobalXPanelView globalXPanelView = new GlobalXPanelView(context);
        this.f49336a = globalXPanelView;
        return globalXPanelView;
    }

    public void resetPosition() {
        ((GlobalXPanelView) this.mView).resetPosition();
    }

    public void moveToResetPosition() {
        ((GlobalXPanelView) this.mView).moveToResetPosition();
    }

    public void setXPanelShadowBg(Drawable drawable) {
        ((GlobalXPanelView) this.mView).setXPanelShadowBg(drawable);
    }

    public void setXPanelShadowBg(int i) {
        ((GlobalXPanelView) this.mView).setXPanelShadowBg(i);
    }

    public void changeXPanelShowHeight(boolean z) {
        ((GlobalXPanelView) this.mView).changeXPanelShowHeight(z);
    }

    public void disableXPanelDownBtn() {
        ((GlobalXPanelView) this.mView).disableXPanelDownBtn();
    }

    public void enableXPanelDownBtn() {
        ((GlobalXPanelView) this.mView).enableXPanelDownBtn();
    }

    public void setXPanelCallBack(IXPanelCallBack iXPanelCallBack) {
        ((GlobalXPanelView) this.mView).setXPanelCallBack(iXPanelCallBack);
    }

    public boolean isListEmpty() {
        return ((GlobalXPanelView) this.mView).isListEmpty();
    }

    public void addStateChangeListener(IStateChangeListener iStateChangeListener) {
        ((GlobalXPanelView) this.mView).addStateChangeListener(iStateChangeListener);
    }

    public void scrollLength(int i) {
        ((GlobalXPanelView) this.mView).scrollLength(i);
    }

    public View findViewByXPanelCardData(XPanelCardData xPanelCardData) {
        return ((GlobalXPanelView) this.mView).findViewByXPanelCardData(xPanelCardData);
    }

    public void setBottomMaxShowHeight(boolean z) {
        ((GlobalXPanelView) this.mView).setBottomMaxShowHeight(z);
    }

    public void setTopOffset(int i) {
        ((GlobalXPanelView) this.mView).setTopOffset(i);
    }

    public void setNavigationText(CharSequence charSequence) {
        ((GlobalXPanelView) this.mView).setNavigationText(charSequence);
    }

    public void setLoadingView(View view) {
        ((GlobalXPanelView) this.mView).setLoadingView(view);
    }

    public XPanelHeaderBarView getHeaderBarView() {
        return ((GlobalXPanelView) this.mView).getHeaderBarView();
    }

    public IXPanelMessageContainer getMessageContainer() {
        return ((GlobalXPanelView) this.mView).getMessageContainer();
    }

    public void showMessageTip(String str) {
        ((GlobalXPanelView) this.mView).showMessageTip(str);
    }

    public void hideMessageTip() {
        ((GlobalXPanelView) this.mView).hideMessageTip();
    }

    public void bindSpaceInterceptor(IXPanelSpaceInterceptor iXPanelSpaceInterceptor) {
        ((GlobalXPanelView) this.mView).bindSpaceInterceptor(iXPanelSpaceInterceptor);
    }

    public TextView getMessageTip() {
        return ((GlobalXPanelView) this.mView).getMessageTip();
    }

    public ViewGroup getHandleView() {
        return ((GlobalXPanelView) this.mView).getHandleView();
    }

    public void clearDefaultScrollFlag(int i, int i2) {
        ((GlobalXPanelView) this.mView).clearFirstDefault(i, i2);
    }

    public void checkShowCardHeight(int i) {
        ((GlobalXPanelView) this.mView).mo121532a(i);
    }

    public void destroy() {
        super.destroy();
        GlobalGenericKit.unRegister(XPanelModels.X_PANEL_TEMPLATE_GLOBAL_OPERATION);
    }
}

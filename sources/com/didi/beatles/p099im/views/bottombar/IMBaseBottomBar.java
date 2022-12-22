package com.didi.beatles.p099im.views.bottombar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.didi.beatles.p099im.access.action.IMActionItem;
import com.didi.beatles.p099im.access.utils.IMBusinessConfig;
import com.didi.beatles.p099im.api.entity.IMSessionExtendInfo;
import com.didi.beatles.p099im.data.IMInnerData;
import com.didi.beatles.p099im.module.entity.IMBusinessParam;
import com.didi.beatles.p099im.module.entity.IMSession;
import com.didi.beatles.p099im.omega.IMTraceUtil;
import com.didi.beatles.p099im.protocol.host.IMActionInvokeEnv;
import com.didi.beatles.p099im.protocol.host.IMActionInvokeReturn;
import com.didi.beatles.p099im.protocol.model.IMBottomGuideConfig;
import com.didi.beatles.p099im.protocol.model.IMTabActionItem;
import com.didi.beatles.p099im.utils.IMLog;
import java.util.List;

/* renamed from: com.didi.beatles.im.views.bottombar.IMBaseBottomBar */
public abstract class IMBaseBottomBar {

    /* renamed from: a */
    private static final String f9965a = "IMBaseBottomBar";

    /* renamed from: b */
    private ViewGroup f9966b;

    /* renamed from: c */
    private View f9967c;
    public Context context;
    protected int mActivityFrom;
    protected IMBusinessConfig mBusinessConfig;
    protected int mBusinessId;
    protected IMBusinessParam mBusinessParam;
    public BottomBarListener mListener;
    protected IMSession mSession;

    /* renamed from: com.didi.beatles.im.views.bottombar.IMBaseBottomBar$BottomBarListener */
    public interface BottomBarListener {
        List<IMBottomGuideConfig> getBottomGuideConfigList();

        List<IMSessionExtendInfo.BottomTabInfo> getBottomTabList();

        List<IMActionItem> getSystemAction();

        void handleEvent();

        List<IMActionItem> interceptMoreAction(List<IMActionItem> list);

        IMActionInvokeReturn invokeAction(IMActionItem iMActionItem, IMActionInvokeEnv iMActionInvokeEnv);

        IMActionInvokeReturn invokeTabAction(IMTabActionItem iMTabActionItem, IMActionInvokeEnv iMActionInvokeEnv);

        void onEditFocus();

        void onTextMessageSend(String str, int i, int i2);

        void sendEmoji(String str, String str2, String str3);

        void sendTextMessage(String str, int i, Object obj);

        void sendVoiceMessage(String str, long j);

        void showAddCustomWordDialog(String str, int i, int i2);
    }

    public void onActivityCreate() {
    }

    public boolean onBackPressed() {
        return false;
    }

    public abstract View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public void onPause() {
    }

    public void onRecommendChanged(String str) {
    }

    public void onResume() {
    }

    public void onStatusChanged(IMSession iMSession) {
    }

    public void resumeInitStatus() {
    }

    public void shrinkBottomBar() {
    }

    public static IMBaseBottomBar instantiate(Context context2, String str) {
        try {
            IMBaseBottomBar iMBaseBottomBar = (IMBaseBottomBar) context2.getClassLoader().loadClass(str).newInstance();
            iMBaseBottomBar.context = context2;
            return iMBaseBottomBar;
        } catch (Exception unused) {
            IMTraceUtil.CodeErrorParam addErrno = IMTraceUtil.addCodeErrorEvent().addErrno(1);
            addErrno.addErrMsg("instant bottom bar failed,class = " + str).report();
            return null;
        }
    }

    public static IMBaseBottomBar instantiate(Context context2, Class cls) {
        try {
            IMBaseBottomBar iMBaseBottomBar = (IMBaseBottomBar) cls.newInstance();
            iMBaseBottomBar.context = context2;
            return iMBaseBottomBar;
        } catch (Exception e) {
            throw new IMInstantiationException("IMBaseBottomBar instance failed ", e);
        }
    }

    public void setBottomBarData(IMSession iMSession, IMBusinessParam iMBusinessParam, IMBusinessConfig iMBusinessConfig, int i) {
        this.mSession = iMSession;
        this.mBusinessParam = iMBusinessParam;
        this.mBusinessConfig = iMBusinessConfig;
        this.mBusinessId = i;
    }

    public void setActivityFrom(int i) {
        this.mActivityFrom = i;
    }

    public void setRecommendInfo(String str) {
        if (str != null) {
            IMLog.m6631d("IMBottomBar", "setRecommendInfo  增加了缓存 " + str);
            IMInnerData.getInstance().addRecommendInfo(Long.valueOf(this.mSession.getSessionId()), str);
        } else {
            str = IMInnerData.getInstance().getRecommendInfo(Long.valueOf(this.mSession.getSessionId()));
            IMLog.m6631d("IMBottomBar", "setRecommendInfo 获得缓存 " + str);
        }
        onRecommendChanged(str);
    }

    public void attachToParent(ViewGroup viewGroup) {
        this.f9966b = viewGroup;
        View onCreateView = onCreateView(LayoutInflater.from(this.context), viewGroup);
        this.f9967c = onCreateView;
        if (onCreateView == null) {
            IMLog.m6632e(f9965a, "onCreateView return null View!");
            return;
        }
        ViewParent parent = onCreateView.getParent();
        if (parent instanceof ViewGroup) {
            IMLog.m6637w("attachToParent but child view already add", new Object[0]);
            ((ViewGroup) parent).removeView(this.f9967c);
        }
        ViewGroup viewGroup2 = this.f9966b;
        View view = this.f9967c;
        viewGroup2.addView(view, view.getLayoutParams());
    }

    public void dettachFromParent() {
        View view;
        ViewGroup viewGroup = this.f9966b;
        if (viewGroup != null && (view = this.f9967c) != null) {
            viewGroup.removeView(view);
            mo44029a();
        }
    }

    /* renamed from: a */
    private void mo44029a() {
        this.mBusinessConfig = null;
        this.mSession = null;
        this.mBusinessParam = null;
    }

    public void onDestroyView() {
        ViewGroup viewGroup = this.f9966b;
        if (viewGroup != null) {
            viewGroup.removeView(this.f9967c);
        }
        mo44029a();
    }

    /* access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    /* access modifiers changed from: protected */
    public View getViewRoot() {
        return this.f9966b;
    }

    /* access modifiers changed from: protected */
    public void onBottomBarExpand() {
        this.mListener.onEditFocus();
    }

    public void onDestroy() {
        mo44029a();
    }

    public void setBottomBarListener(BottomBarListener bottomBarListener) {
        this.mListener = bottomBarListener;
    }

    public void shrinkBottomBarByRecycle() {
        shrinkBottomBar();
    }

    /* renamed from: com.didi.beatles.im.views.bottombar.IMBaseBottomBar$IMInstantiationException */
    public static class IMInstantiationException extends RuntimeException {
        public IMInstantiationException(String str) {
            super(str);
        }

        public IMInstantiationException(String str, Exception exc) {
            super(str, exc);
        }
    }
}

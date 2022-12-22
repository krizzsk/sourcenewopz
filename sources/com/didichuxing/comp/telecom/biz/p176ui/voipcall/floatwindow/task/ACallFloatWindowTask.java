package com.didichuxing.comp.telecom.biz.p176ui.voipcall.floatwindow.task;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LifecycleOwner;
import com.didichuxing.comp.telecom.biz.p176ui.voipcall.floatwindow.CallFloatWindowLayoutParams;
import com.didichuxing.comp.telecom.biz.p176ui.voipcall.floatwindow.FloatWindowHelper;
import com.didichuxing.comp.telecom.biz.p176ui.voipcall.floatwindow.VoipFloatManager;
import com.didichuxing.comp.telecom.biz.p176ui.voipcall.floatwindow.p178vh.ACallFloatViewHolder;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.CallManagerAssist;
import com.didichuxing.comp.telecom.core.CallState;
import com.didichuxing.comp.telecom.core.voip.VoipAudioCall;
import com.didichuxing.comp.telecom.core.voip.VoipCallListener;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0012\u001a\u0004\u0018\u00010\n2\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0004J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019H\u0004J\b\u0010\u001a\u001a\u00020\u0016H\u0014J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 H\u0014J\u0018\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 H\u0017J\u0006\u0010#\u001a\u00020\u0016J\u000e\u0010$\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010%\u001a\u00020\u0016J \u0010&\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0004J\"\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010,\u001a\u00020\u001dH\u0004R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006-"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/task/ACallFloatWindowTask;", "Lcom/didichuxing/comp/telecom/core/voip/VoipCallListener;", "mVoipCall", "Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;", "(Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "mCurVh", "Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/vh/ACallFloatViewHolder;", "<set-?>", "Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/task/FloatContainerView;", "mFrameLayout", "getMFrameLayout", "()Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/task/FloatContainerView;", "getMVoipCall", "()Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;", "checkCurVhUseful", "clz", "Ljava/lang/Class;", "getCacheFloatLocation", "", "prefix", "lp", "Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/CallFloatWindowLayoutParams;", "innerDestroy", "innerHide", "toHide", "", "innerShow", "state", "Lcom/didichuxing/comp/telecom/core/CallState;", "onStateChange", "call", "performDestroy", "performHide", "performShow", "recordFloatLocation", "x", "", "y", "showNewVh", "vh", "keepLocation", "voip-biz_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.floatwindow.task.ACallFloatWindowTask */
/* compiled from: ACallFloatWindowTask.kt */
public abstract class ACallFloatWindowTask implements VoipCallListener {

    /* renamed from: a */
    private final String f46334a = "ACallFloatWindowTask";

    /* renamed from: b */
    private FloatContainerView f46335b;

    /* renamed from: c */
    private ACallFloatViewHolder f46336c;

    /* renamed from: d */
    private final VoipAudioCall f46337d;

    /* access modifiers changed from: protected */
    public final void getCacheFloatLocation(String str, CallFloatWindowLayoutParams callFloatWindowLayoutParams) {
        Intrinsics.checkParameterIsNotNull(str, "prefix");
        Intrinsics.checkParameterIsNotNull(callFloatWindowLayoutParams, "lp");
    }

    /* access modifiers changed from: protected */
    public void innerShow(CallState callState) {
        Intrinsics.checkParameterIsNotNull(callState, "state");
    }

    /* access modifiers changed from: protected */
    public final void recordFloatLocation(String str, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(str, "prefix");
    }

    public ACallFloatWindowTask(VoipAudioCall voipAudioCall) {
        Intrinsics.checkParameterIsNotNull(voipAudioCall, "mVoipCall");
        this.f46337d = voipAudioCall;
        voipAudioCall.bindCallListener(this, (LifecycleOwner) null, false);
        CallManagerAssist instance = CallManagerAssist.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
        Context appContext = instance.getAppContext();
        if (appContext != null) {
            this.f46335b = new FloatContainerView(appContext, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        }
    }

    /* access modifiers changed from: protected */
    public final VoipAudioCall getMVoipCall() {
        return this.f46337d;
    }

    public void notifyStateDes(String str) {
        VoipCallListener.DefaultImpls.notifyStateDes(this, str);
    }

    public void onAudioDeviceChange(VoipAudioCall voipAudioCall, int i) {
        Intrinsics.checkParameterIsNotNull(voipAudioCall, NotificationCompat.CATEGORY_CALL);
        VoipCallListener.DefaultImpls.onAudioDeviceChange(this, voipAudioCall, i);
    }

    public void onMicStateChange(VoipAudioCall voipAudioCall, boolean z) {
        Intrinsics.checkParameterIsNotNull(voipAudioCall, "voipAudioCall");
        VoipCallListener.DefaultImpls.onMicStateChange(this, voipAudioCall, z);
    }

    /* access modifiers changed from: protected */
    public String getTAG() {
        return this.f46334a;
    }

    /* access modifiers changed from: protected */
    public final FloatContainerView getMFrameLayout() {
        return this.f46335b;
    }

    public void onStateChange(VoipAudioCall voipAudioCall, CallState callState) {
        Intrinsics.checkParameterIsNotNull(voipAudioCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(callState, "state");
        if (callState == CallState.END_CALL) {
            innerDestroy();
        } else if (!VoipFloatManager.Companion.getInstance().isAppVisible()) {
            CallLogUtil.logI(getTAG(), "onStateChange - state change try hide");
            m33264a(true);
        } else if (VoipFloatManager.Companion.getInstance().hasVoipCallPage()) {
            CallLogUtil.logI(getTAG(), "onStateChange - state change try destroy");
            innerDestroy();
        } else {
            CallLogUtil.logI(getTAG(), "onStateChange - state change try update");
            innerShow(callState);
        }
    }

    public final void performShow() {
        innerShow(this.f46337d.getState());
    }

    public final void performHide(boolean z) {
        m33264a(z);
    }

    /* renamed from: a */
    private final void m33264a(boolean z) {
        FloatContainerView floatContainerView = this.f46335b;
        if (floatContainerView != null) {
            FloatWindowHelper instance = FloatWindowHelper.Companion.getInstance();
            Context context = floatContainerView.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "it.context");
            instance.hideFloatView(context, floatContainerView, z);
        }
    }

    public final void performDestroy() {
        innerDestroy();
    }

    /* access modifiers changed from: protected */
    public void innerDestroy() {
        this.f46337d.unbindCallListener(this);
        FloatContainerView floatContainerView = this.f46335b;
        if (floatContainerView != null) {
            FloatWindowHelper instance = FloatWindowHelper.Companion.getInstance();
            Context context = floatContainerView.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "it.context");
            instance.removeFloatView(context, floatContainerView);
        }
        this.f46335b = null;
        ACallFloatViewHolder aCallFloatViewHolder = this.f46336c;
        if (aCallFloatViewHolder != null) {
            aCallFloatViewHolder.performDestroy();
        }
        this.f46336c = null;
    }

    public static /* synthetic */ void showNewVh$default(ACallFloatWindowTask aCallFloatWindowTask, ACallFloatViewHolder aCallFloatViewHolder, CallFloatWindowLayoutParams callFloatWindowLayoutParams, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                z = true;
            }
            aCallFloatWindowTask.showNewVh(aCallFloatViewHolder, callFloatWindowLayoutParams, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showNewVh");
    }

    /* access modifiers changed from: protected */
    public final void showNewVh(ACallFloatViewHolder aCallFloatViewHolder, CallFloatWindowLayoutParams callFloatWindowLayoutParams, boolean z) {
        Intrinsics.checkParameterIsNotNull(aCallFloatViewHolder, "vh");
        Intrinsics.checkParameterIsNotNull(callFloatWindowLayoutParams, "lp");
        FloatContainerView floatContainerView = this.f46335b;
        if (floatContainerView != null) {
            if (z) {
                Object tag = floatContainerView.getTag(R.id.voip_call_float_window_lp);
                if (!(tag instanceof WindowManager.LayoutParams)) {
                    tag = null;
                }
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) tag;
                if (layoutParams != null) {
                    callFloatWindowLayoutParams.setCacheX(Integer.valueOf(layoutParams.x));
                    callFloatWindowLayoutParams.setCacheY(Integer.valueOf(layoutParams.y));
                }
            }
            floatContainerView.addView(aCallFloatViewHolder.getView());
            FloatWindowHelper instance = FloatWindowHelper.Companion.getInstance();
            Context context = floatContainerView.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "container.context");
            instance.showFloatView(context, floatContainerView, callFloatWindowLayoutParams);
            this.f46336c = aCallFloatViewHolder;
        }
    }

    /* access modifiers changed from: protected */
    public final ACallFloatViewHolder checkCurVhUseful(Class<?> cls) {
        Intrinsics.checkParameterIsNotNull(cls, "clz");
        ACallFloatViewHolder aCallFloatViewHolder = this.f46336c;
        if (aCallFloatViewHolder == null) {
            return null;
        }
        if (!cls.isInstance(aCallFloatViewHolder)) {
            this.f46336c = null;
            aCallFloatViewHolder.performDestroy();
            FloatContainerView floatContainerView = this.f46335b;
            if (floatContainerView != null) {
                View view = aCallFloatViewHolder.getView();
                if (floatContainerView.indexOfChild(view) != -1) {
                    floatContainerView.removeView(view);
                }
            }
        }
        return this.f46336c;
    }
}

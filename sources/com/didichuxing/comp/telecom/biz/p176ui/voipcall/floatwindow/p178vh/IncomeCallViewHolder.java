package com.didichuxing.comp.telecom.biz.p176ui.voipcall.floatwindow.p178vh;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LifecycleOwner;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.BaseRequestOptions;
import com.didichuxing.comp.telecom.biz.p176ui.voipcall.VoipBusinessActivity;
import com.didichuxing.comp.telecom.biz.p176ui.voipcall.floatwindow.VoipFloatManager;
import com.didichuxing.comp.telecom.biz.util.VoipPermissionHelper;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.CallManagerAssist;
import com.didichuxing.comp.telecom.core.CallRole;
import com.didichuxing.comp.telecom.core.CallState;
import com.didichuxing.comp.telecom.core.voip.AnalyseTickHelper;
import com.didichuxing.comp.telecom.core.voip.RoomInfo;
import com.didichuxing.comp.telecom.core.voip.VoipAudioCall;
import com.didichuxing.comp.telecom.core.voip.VoipCallListener;
import com.didichuxing.comp.telecom.core.voip.VoipCallModel;
import com.didichuxing.comp.telecom.core.voip.tipstate.TipStateComponent;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\u0012\u0010\u001a\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\b\u0010\u001f\u001a\u00020\u0016H\u0016J\b\u0010 \u001a\u00020\u0016H\u0002R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/vh/IncomeCallViewHolder;", "Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/vh/ACallFloatViewHolder;", "Lcom/didichuxing/comp/telecom/core/voip/VoipCallListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "mAnswerBtn", "Landroid/view/View;", "mAvatar", "Landroid/widget/ImageView;", "mCurCall", "Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;", "mOppositeName", "Landroid/widget/TextView;", "mRejectBtn", "mRootView", "mStateDes", "bindView", "", "voipCall", "checkPermissionBeforeAnswer", "getView", "notifyStateDes", "msg", "onAnswerClick", "v", "onRejectClick", "performDestroy", "rejectIncomeCall", "voip-biz_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.floatwindow.vh.IncomeCallViewHolder */
/* compiled from: IncomeCallViewHolder.kt */
public final class IncomeCallViewHolder extends ACallFloatViewHolder implements VoipCallListener {

    /* renamed from: a */
    private final String f46358a = "IncomeCallViewHolder";

    /* renamed from: b */
    private View f46359b;

    /* renamed from: c */
    private ImageView f46360c;

    /* renamed from: d */
    private TextView f46361d;

    /* renamed from: e */
    private TextView f46362e;

    /* renamed from: f */
    private View f46363f;

    /* renamed from: g */
    private View f46364g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public VoipAudioCall f46365h;

    /* renamed from: i */
    private final Context f46366i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IncomeCallViewHolder(Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.f46366i = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.voip_floatview_incomecall, (ViewGroup) null);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(cont…oatview_incomecall, null)");
        this.f46359b = inflate;
    }

    public void onAudioDeviceChange(VoipAudioCall voipAudioCall, int i) {
        Intrinsics.checkParameterIsNotNull(voipAudioCall, NotificationCompat.CATEGORY_CALL);
        VoipCallListener.DefaultImpls.onAudioDeviceChange(this, voipAudioCall, i);
    }

    public void onMicStateChange(VoipAudioCall voipAudioCall, boolean z) {
        Intrinsics.checkParameterIsNotNull(voipAudioCall, "voipAudioCall");
        VoipCallListener.DefaultImpls.onMicStateChange(this, voipAudioCall, z);
    }

    public void onStateChange(VoipAudioCall voipAudioCall, CallState callState) {
        Intrinsics.checkParameterIsNotNull(voipAudioCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(callState, "state");
        VoipCallListener.DefaultImpls.onStateChange(this, voipAudioCall, callState);
    }

    /* access modifiers changed from: protected */
    public String getTAG() {
        return this.f46358a;
    }

    public View getView() {
        return this.f46359b;
    }

    public void performDestroy() {
        VoipAudioCall voipAudioCall = this.f46365h;
        if (voipAudioCall != null) {
            voipAudioCall.unbindCallListener(this);
        }
        this.f46365h = null;
    }

    public void bindView(VoipAudioCall voipAudioCall) {
        TipStateComponent mStateTextHelper;
        Intrinsics.checkParameterIsNotNull(voipAudioCall, "voipCall");
        this.f46365h = voipAudioCall;
        if (voipAudioCall != null) {
            VoipAudioCall.bindCallListener$default(voipAudioCall, this, (LifecycleOwner) null, false, 6, (Object) null);
        }
        VoipCallModel voipCallModel = voipAudioCall.getVoipCallModel();
        this.f46359b.setOnClickListener(new IncomeCallViewHolder$bindView$1(this, voipAudioCall));
        ImageView imageView = (ImageView) this.f46359b.findViewById(R.id.avatar);
        this.f46360c = imageView;
        String str = null;
        if (imageView != null) {
            RequestManager with = Glide.with(imageView.getContext());
            RoomInfo roomInfo = voipCallModel.getRoomInfo();
            RequestBuilder<Drawable> load = with.load(roomInfo != null ? roomInfo.getOppositeAvatar() : null);
            Intrinsics.checkExpressionValueIsNotNull(load, "Glide.with(it.context).l…roomInfo?.oppositeAvatar)");
            CallManagerAssist instance = CallManagerAssist.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
            Integer num = instance.getResources().get("voip_call_page_default_avatar");
            int intValue = num != null ? num.intValue() : -1;
            if (intValue > 0) {
                BaseRequestOptions fallback = ((RequestBuilder) load.placeholder(intValue)).fallback(intValue);
                Intrinsics.checkExpressionValueIsNotNull(fallback, "requestBuilder.placehold…Res).fallback(defaultRes)");
                load = (RequestBuilder) fallback;
            }
            load.into(imageView);
        }
        TextView textView = (TextView) this.f46359b.findViewById(R.id.oppositeName);
        this.f46361d = textView;
        if (textView != null) {
            RoomInfo roomInfo2 = voipCallModel.getRoomInfo();
            textView.setText(roomInfo2 != null ? roomInfo2.getOppositeNickname() : null);
        }
        TextView textView2 = (TextView) this.f46359b.findViewById(R.id.stateDes);
        this.f46362e = textView2;
        if (textView2 != null) {
            VoipAudioCall voipAudioCall2 = this.f46365h;
            if (!(voipAudioCall2 == null || (mStateTextHelper = voipAudioCall2.getMStateTextHelper()) == null)) {
                str = mStateTextHelper.getCurTipStr();
            }
            textView2.setText(str);
        }
        View findViewById = this.f46359b.findViewById(R.id.answerBtn);
        this.f46363f = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(new IncomeCallViewHolder$bindView$3(this));
        }
        View findViewById2 = this.f46359b.findViewById(R.id.rejectBtn);
        this.f46364g = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new IncomeCallViewHolder$bindView$4(this));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0029, code lost:
        r2 = com.didichuxing.comp.telecom.biz.p176ui.voipcall.VoipCallPageStateKt.toUiState((r2 = r2.getState()));
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m33273a(android.view.View r7) {
        /*
            r6 = this;
            java.lang.String r0 = r6.getTAG()
            java.lang.String r1 = "[User click] - onAnswerClick"
            com.didichuxing.comp.telecom.core.CallLogUtil.logI(r0, r1)
            com.didichuxing.comp.telecom.core.CallManagerAssist r0 = com.didichuxing.comp.telecom.core.CallManagerAssist.getInstance()
            java.lang.String r1 = "CallManagerAssist.getInstance()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            com.didichuxing.comp.telecom.core.CallManagerAssist$CallManagerConfig r0 = r0.getConfig()
            r1 = 0
            if (r0 == 0) goto L_0x0054
            com.didichuxing.comp.telecom.core.CallManagerAssist$CallEventTickHandler r0 = r0.getEventTickHandler()
            if (r0 == 0) goto L_0x0054
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r2 = r6.f46365h
            if (r2 == 0) goto L_0x0034
            com.didichuxing.comp.telecom.core.CallState r2 = r2.getState()
            if (r2 == 0) goto L_0x0034
            com.didichuxing.comp.telecom.biz.ui.voipcall.VoipCallPageState r2 = com.didichuxing.comp.telecom.biz.p176ui.voipcall.VoipCallPageStateKt.toUiState(r2)
            if (r2 == 0) goto L_0x0034
            java.lang.String r2 = com.didichuxing.comp.telecom.biz.p176ui.voipcall.VoipCallPageStateKt.toStr(r2)
            goto L_0x0035
        L_0x0034:
            r2 = r1
        L_0x0035:
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r3 = r6.f46365h
            if (r3 == 0) goto L_0x0044
            com.didichuxing.comp.telecom.core.CallRole r3 = r3.getRole()
            if (r3 == 0) goto L_0x0044
            java.lang.String r3 = com.didichuxing.comp.telecom.core.CallStateKt.toStr(r3)
            goto L_0x0045
        L_0x0044:
            r3 = r1
        L_0x0045:
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r4 = r6.f46365h
            if (r4 == 0) goto L_0x004e
            com.didichuxing.comp.telecom.core.voip.VoipCallModel r4 = r4.getModel()
            goto L_0x004f
        L_0x004e:
            r4 = r1
        L_0x004f:
            java.lang.String r5 = "Answer"
            r0.onCallPageBtnClick(r5, r2, r3, r4)
        L_0x0054:
            com.didichuxing.comp.telecom.core.voip.AnalyseTickHelper r0 = com.didichuxing.comp.telecom.core.voip.AnalyseTickHelper.INSTANCE
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r2 = r6.f46365h
            if (r2 == 0) goto L_0x005f
            com.didichuxing.comp.telecom.core.voip.VoipCallModel r2 = r2.getVoipCallModel()
            goto L_0x0060
        L_0x005f:
            r2 = r1
        L_0x0060:
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r3 = r6.f46365h
            if (r3 == 0) goto L_0x0068
            com.didichuxing.comp.telecom.core.CallRole r1 = r3.getRole()
        L_0x0068:
            java.lang.String r3 = "answer"
            r0.tickVoipSteps(r3, r2, r1)
            android.content.Context r7 = r7.getContext()
            java.lang.String r0 = "v.context"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r0)
            r6.m33272a((android.content.Context) r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.comp.telecom.biz.p176ui.voipcall.floatwindow.p178vh.IncomeCallViewHolder.m33273a(android.view.View):void");
    }

    /* renamed from: a */
    private final void m33272a(Context context) {
        VoipCallModel voipCallModel;
        Activity topActivity = VoipFloatManager.Companion.getInstance().getTopActivity();
        String tag = getTAG();
        StringBuilder sb = new StringBuilder();
        sb.append("checkPermissionBeforeAnswer - topActivity not null ");
        sb.append(topActivity != null);
        CallLogUtil.logI(tag, sb.toString());
        if (topActivity != null) {
            VoipPermissionHelper.INSTANCE.checkAudioPermission(topActivity, new IncomeCallViewHolder$checkPermissionBeforeAnswer$1(this));
            return;
        }
        VoipAudioCall voipAudioCall = this.f46365h;
        if (voipAudioCall != null && (voipCallModel = voipAudioCall.getVoipCallModel()) != null) {
            VoipBusinessActivity.Companion.openPage(context, voipCallModel, 1);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0029, code lost:
        r0 = com.didichuxing.comp.telecom.biz.p176ui.voipcall.VoipCallPageStateKt.toUiState((r0 = r0.getState()));
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m33274b(android.view.View r5) {
        /*
            r4 = this;
            java.lang.String r5 = r4.getTAG()
            java.lang.String r0 = "[User click] - onRejectClick"
            com.didichuxing.comp.telecom.core.CallLogUtil.logI(r5, r0)
            com.didichuxing.comp.telecom.core.CallManagerAssist r5 = com.didichuxing.comp.telecom.core.CallManagerAssist.getInstance()
            java.lang.String r0 = "CallManagerAssist.getInstance()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r0)
            com.didichuxing.comp.telecom.core.CallManagerAssist$CallManagerConfig r5 = r5.getConfig()
            if (r5 == 0) goto L_0x0052
            com.didichuxing.comp.telecom.core.CallManagerAssist$CallEventTickHandler r5 = r5.getEventTickHandler()
            if (r5 == 0) goto L_0x0052
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r0 = r4.f46365h
            r1 = 0
            if (r0 == 0) goto L_0x0034
            com.didichuxing.comp.telecom.core.CallState r0 = r0.getState()
            if (r0 == 0) goto L_0x0034
            com.didichuxing.comp.telecom.biz.ui.voipcall.VoipCallPageState r0 = com.didichuxing.comp.telecom.biz.p176ui.voipcall.VoipCallPageStateKt.toUiState(r0)
            if (r0 == 0) goto L_0x0034
            java.lang.String r0 = com.didichuxing.comp.telecom.biz.p176ui.voipcall.VoipCallPageStateKt.toStr(r0)
            goto L_0x0035
        L_0x0034:
            r0 = r1
        L_0x0035:
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r2 = r4.f46365h
            if (r2 == 0) goto L_0x0044
            com.didichuxing.comp.telecom.core.CallRole r2 = r2.getRole()
            if (r2 == 0) goto L_0x0044
            java.lang.String r2 = com.didichuxing.comp.telecom.core.CallStateKt.toStr(r2)
            goto L_0x0045
        L_0x0044:
            r2 = r1
        L_0x0045:
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r3 = r4.f46365h
            if (r3 == 0) goto L_0x004d
            com.didichuxing.comp.telecom.core.voip.VoipCallModel r1 = r3.getModel()
        L_0x004d:
            java.lang.String r3 = "HangUp"
            r5.onCallPageBtnClick(r3, r0, r2, r1)
        L_0x0052:
            r4.m33271a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.comp.telecom.biz.p176ui.voipcall.floatwindow.p178vh.IncomeCallViewHolder.m33274b(android.view.View):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m33271a() {
        CallLogUtil.logI(getTAG(), "rejectIncomeCall");
        AnalyseTickHelper analyseTickHelper = AnalyseTickHelper.INSTANCE;
        VoipAudioCall voipAudioCall = this.f46365h;
        CallRole callRole = null;
        VoipCallModel voipCallModel = voipAudioCall != null ? voipAudioCall.getVoipCallModel() : null;
        VoipAudioCall voipAudioCall2 = this.f46365h;
        if (voipAudioCall2 != null) {
            callRole = voipAudioCall2.getRole();
        }
        analyseTickHelper.tickUserActions("reject", voipCallModel, callRole);
        VoipAudioCall voipAudioCall3 = this.f46365h;
        if (voipAudioCall3 != null) {
            voipAudioCall3.rejectIncomeCall();
        }
    }

    public void notifyStateDes(String str) {
        VoipCallListener.DefaultImpls.notifyStateDes(this, str);
        TextView textView = this.f46362e;
        if (textView != null) {
            textView.setText(str);
        }
    }
}

package com.didichuxing.comp.telecom.biz.p176ui.voipcall.floatwindow.p178vh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.didichuxing.comp.telecom.biz.p176ui.voipcall.VoipCallPageState;
import com.didichuxing.comp.telecom.biz.p176ui.voipcall.VoipCallPageStateKt;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.CallManagerAssist;
import com.didichuxing.comp.telecom.core.CallRole;
import com.didichuxing.comp.telecom.core.CallState;
import com.didichuxing.comp.telecom.core.CallStateKt;
import com.didichuxing.comp.telecom.core.voip.VoipAudioCall;
import com.didichuxing.comp.telecom.core.voip.VoipCallListener;
import com.didichuxing.comp.telecom.core.voip.VoipCallModel;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\rH\u0016J\u0017\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\u0013H\u0016J\u0012\u0010!\u001a\u00020\u001a2\b\u0010\"\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u001eH\u0016J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u0013H\u0004J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u0013H\u0002J\b\u0010)\u001a\u00020\u001aH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/vh/InCallViewHolder;", "Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/vh/ACallFloatViewHolder;", "Lcom/didichuxing/comp/telecom/core/voip/VoipCallListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "mAvatar", "Landroid/widget/ImageView;", "mCurCall", "Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;", "getMCurCall", "()Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;", "setMCurCall", "(Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;)V", "mHangUpBtn", "Landroid/view/View;", "mOppositeName", "Landroid/widget/TextView;", "mRootView", "mSoundBtn", "mStateDes", "bindView", "", "voipCall", "changeSpeakerOnShowState", "state", "", "(Ljava/lang/Integer;)V", "getView", "notifyStateDes", "msg", "onAudioDeviceChange", "call", "deviceState", "onHangUpClick", "v", "onSoundSwitchClick", "performDestroy", "voip-biz_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.floatwindow.vh.InCallViewHolder */
/* compiled from: InCallViewHolder.kt */
public class InCallViewHolder extends ACallFloatViewHolder implements VoipCallListener {

    /* renamed from: a */
    private final String f46349a = "InCallViewHolder";

    /* renamed from: b */
    private View f46350b;

    /* renamed from: c */
    private ImageView f46351c;

    /* renamed from: d */
    private TextView f46352d;

    /* renamed from: e */
    private TextView f46353e;

    /* renamed from: f */
    private View f46354f;

    /* renamed from: g */
    private ImageView f46355g;

    /* renamed from: h */
    private VoipAudioCall f46356h;

    /* renamed from: i */
    private final Context f46357i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InCallViewHolder(Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.f46357i = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.voip_floatview_incall, (ViewGroup) null);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(cont…p_floatview_incall, null)");
        this.f46350b = inflate;
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
        return this.f46349a;
    }

    public View getView() {
        return this.f46350b;
    }

    /* access modifiers changed from: protected */
    public final VoipAudioCall getMCurCall() {
        return this.f46356h;
    }

    /* access modifiers changed from: protected */
    public final void setMCurCall(VoipAudioCall voipAudioCall) {
        this.f46356h = voipAudioCall;
    }

    public void performDestroy() {
        VoipAudioCall voipAudioCall = this.f46356h;
        if (voipAudioCall != null) {
            voipAudioCall.unbindCallListener(this);
        }
        this.f46356h = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x003e, code lost:
        r3 = r0.getRoomInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindView(com.didichuxing.comp.telecom.core.voip.VoipAudioCall r8) {
        /*
            r7 = this;
            java.lang.String r0 = "voipCall"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r8, r0)
            r7.f46356h = r8
            if (r8 == 0) goto L_0x0014
            r2 = r7
            com.didichuxing.comp.telecom.core.voip.VoipCallListener r2 = (com.didichuxing.comp.telecom.core.voip.VoipCallListener) r2
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            r1 = r8
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall.bindCallListener$default(r1, r2, r3, r4, r5, r6)
        L_0x0014:
            com.didichuxing.comp.telecom.core.voip.VoipCallModel r0 = r8.getVoipCallModel()
            android.view.View r1 = r7.f46350b
            com.didichuxing.comp.telecom.biz.ui.voipcall.floatwindow.vh.InCallViewHolder$bindView$1 r2 = new com.didichuxing.comp.telecom.biz.ui.voipcall.floatwindow.vh.InCallViewHolder$bindView$1
            r2.<init>(r7, r8)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r1.setOnClickListener(r2)
            android.view.View r8 = r7.f46350b
            r1 = 2131427678(0x7f0b015e, float:1.847698E38)
            android.view.View r8 = r8.findViewById(r1)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r7.f46351c = r8
            r1 = 0
            if (r8 == 0) goto L_0x0086
            android.content.Context r2 = r8.getContext()
            com.bumptech.glide.RequestManager r2 = com.bumptech.glide.Glide.with((android.content.Context) r2)
            if (r0 == 0) goto L_0x0049
            com.didichuxing.comp.telecom.core.voip.RoomInfo r3 = r0.getRoomInfo()
            if (r3 == 0) goto L_0x0049
            java.lang.String r3 = r3.getOppositeAvatar()
            goto L_0x004a
        L_0x0049:
            r3 = r1
        L_0x004a:
            com.bumptech.glide.RequestBuilder r2 = r2.load((java.lang.String) r3)
            java.lang.String r3 = "Glide.with(it.context).l…roomInfo?.oppositeAvatar)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            com.didichuxing.comp.telecom.core.CallManagerAssist r3 = com.didichuxing.comp.telecom.core.CallManagerAssist.getInstance()
            java.lang.String r4 = "CallManagerAssist.getInstance()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            java.util.Map r3 = r3.getResources()
            java.lang.String r4 = "voip_call_page_default_avatar"
            java.lang.Object r3 = r3.get(r4)
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 == 0) goto L_0x006f
            int r3 = r3.intValue()
            goto L_0x0070
        L_0x006f:
            r3 = -1
        L_0x0070:
            if (r3 <= 0) goto L_0x0083
            com.bumptech.glide.request.BaseRequestOptions r2 = r2.placeholder((int) r3)
            com.bumptech.glide.RequestBuilder r2 = (com.bumptech.glide.RequestBuilder) r2
            com.bumptech.glide.request.BaseRequestOptions r2 = r2.fallback((int) r3)
            java.lang.String r3 = "requestBuilder.placehold…Res).fallback(defaultRes)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            com.bumptech.glide.RequestBuilder r2 = (com.bumptech.glide.RequestBuilder) r2
        L_0x0083:
            r2.into((android.widget.ImageView) r8)
        L_0x0086:
            android.view.View r8 = r7.f46350b
            r2 = 2131433053(0x7f0b165d, float:1.848788E38)
            android.view.View r8 = r8.findViewById(r2)
            android.widget.TextView r8 = (android.widget.TextView) r8
            r7.f46352d = r8
            if (r8 == 0) goto L_0x00a6
            com.didichuxing.comp.telecom.core.voip.RoomInfo r0 = r0.getRoomInfo()
            if (r0 == 0) goto L_0x00a0
            java.lang.String r0 = r0.getOppositeNickname()
            goto L_0x00a1
        L_0x00a0:
            r0 = r1
        L_0x00a1:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r8.setText(r0)
        L_0x00a6:
            android.view.View r8 = r7.f46350b
            r0 = 2131434275(0x7f0b1b23, float:1.849036E38)
            android.view.View r8 = r8.findViewById(r0)
            android.widget.TextView r8 = (android.widget.TextView) r8
            r7.f46353e = r8
            if (r8 == 0) goto L_0x00ca
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r0 = r7.f46356h
            if (r0 == 0) goto L_0x00c4
            com.didichuxing.comp.telecom.core.voip.tipstate.TipStateComponent r0 = r0.getMStateTextHelper()
            if (r0 == 0) goto L_0x00c4
            java.lang.String r0 = r0.getCurTipStr()
            goto L_0x00c5
        L_0x00c4:
            r0 = r1
        L_0x00c5:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r8.setText(r0)
        L_0x00ca:
            android.view.View r8 = r7.f46350b
            r0 = 2131431233(0x7f0b0f41, float:1.848419E38)
            android.view.View r8 = r8.findViewById(r0)
            r7.f46354f = r8
            if (r8 == 0) goto L_0x00e1
            com.didichuxing.comp.telecom.biz.ui.voipcall.floatwindow.vh.InCallViewHolder$bindView$3 r0 = new com.didichuxing.comp.telecom.biz.ui.voipcall.floatwindow.vh.InCallViewHolder$bindView$3
            r0.<init>(r7)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r8.setOnClickListener(r0)
        L_0x00e1:
            android.view.View r8 = r7.f46350b
            r0 = 2131434221(0x7f0b1aed, float:1.849025E38)
            android.view.View r8 = r8.findViewById(r0)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r7.f46355g = r8
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r8 = r7.f46356h
            if (r8 == 0) goto L_0x00fa
            int r8 = r8.getAudioDeviceState()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)
        L_0x00fa:
            r7.m33270a((java.lang.Integer) r1)
            android.widget.ImageView r8 = r7.f46355g
            if (r8 == 0) goto L_0x010b
            com.didichuxing.comp.telecom.biz.ui.voipcall.floatwindow.vh.InCallViewHolder$bindView$4 r0 = new com.didichuxing.comp.telecom.biz.ui.voipcall.floatwindow.vh.InCallViewHolder$bindView$4
            r0.<init>(r7)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r8.setOnClickListener(r0)
        L_0x010b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.comp.telecom.biz.p176ui.voipcall.floatwindow.p178vh.InCallViewHolder.bindView(com.didichuxing.comp.telecom.core.voip.VoipAudioCall):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m33269a(View view) {
        CallManagerAssist.CallEventTickHandler eventTickHandler;
        CallRole role;
        CallState state;
        VoipCallPageState uiState;
        CallLogUtil.logI(getTAG(), "[User click] - onSoundSwitchClick");
        VoipAudioCall voipAudioCall = this.f46356h;
        if (voipAudioCall != null) {
            boolean z = !voipAudioCall.isSpeakerOn();
            VoipAudioCall voipAudioCall2 = this.f46356h;
            if (voipAudioCall2 != null) {
                voipAudioCall2.setSpeakerState(z);
            }
            CallManagerAssist instance = CallManagerAssist.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
            CallManagerAssist.CallManagerConfig config = instance.getConfig();
            if (config != null && (eventTickHandler = config.getEventTickHandler()) != null) {
                String str = z ? "Speaker" : "OffSpeaker";
                VoipAudioCall voipAudioCall3 = this.f46356h;
                VoipCallModel voipCallModel = null;
                String str2 = (voipAudioCall3 == null || (state = voipAudioCall3.getState()) == null || (uiState = VoipCallPageStateKt.toUiState(state)) == null) ? null : VoipCallPageStateKt.toStr(uiState);
                VoipAudioCall voipAudioCall4 = this.f46356h;
                String str3 = (voipAudioCall4 == null || (role = voipAudioCall4.getRole()) == null) ? null : CallStateKt.toStr(role);
                VoipAudioCall voipAudioCall5 = this.f46356h;
                if (voipAudioCall5 != null) {
                    voipCallModel = voipAudioCall5.getModel();
                }
                eventTickHandler.onCallPageBtnClick(str, str2, str3, voipCallModel);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        r1 = com.didichuxing.comp.telecom.biz.p176ui.voipcall.VoipCallPageStateKt.toUiState((r1 = r1.getState()));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onHangUpClick(android.view.View r6) {
        /*
            r5 = this;
            java.lang.String r0 = "v"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)
            java.lang.String r6 = r5.getTAG()
            java.lang.String r0 = "[User click] - onHangUpClick"
            com.didichuxing.comp.telecom.core.CallLogUtil.logI(r6, r0)
            com.didichuxing.comp.telecom.core.CallManagerAssist r6 = com.didichuxing.comp.telecom.core.CallManagerAssist.getInstance()
            java.lang.String r0 = "CallManagerAssist.getInstance()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r0)
            com.didichuxing.comp.telecom.core.CallManagerAssist$CallManagerConfig r6 = r6.getConfig()
            r0 = 0
            if (r6 == 0) goto L_0x0059
            com.didichuxing.comp.telecom.core.CallManagerAssist$CallEventTickHandler r6 = r6.getEventTickHandler()
            if (r6 == 0) goto L_0x0059
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r1 = r5.f46356h
            if (r1 == 0) goto L_0x0039
            com.didichuxing.comp.telecom.core.CallState r1 = r1.getState()
            if (r1 == 0) goto L_0x0039
            com.didichuxing.comp.telecom.biz.ui.voipcall.VoipCallPageState r1 = com.didichuxing.comp.telecom.biz.p176ui.voipcall.VoipCallPageStateKt.toUiState(r1)
            if (r1 == 0) goto L_0x0039
            java.lang.String r1 = com.didichuxing.comp.telecom.biz.p176ui.voipcall.VoipCallPageStateKt.toStr(r1)
            goto L_0x003a
        L_0x0039:
            r1 = r0
        L_0x003a:
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r2 = r5.f46356h
            if (r2 == 0) goto L_0x0049
            com.didichuxing.comp.telecom.core.CallRole r2 = r2.getRole()
            if (r2 == 0) goto L_0x0049
            java.lang.String r2 = com.didichuxing.comp.telecom.core.CallStateKt.toStr(r2)
            goto L_0x004a
        L_0x0049:
            r2 = r0
        L_0x004a:
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r3 = r5.f46356h
            if (r3 == 0) goto L_0x0053
            com.didichuxing.comp.telecom.core.voip.VoipCallModel r3 = r3.getModel()
            goto L_0x0054
        L_0x0053:
            r3 = r0
        L_0x0054:
            java.lang.String r4 = "HangUp"
            r6.onCallPageBtnClick(r4, r1, r2, r3)
        L_0x0059:
            com.didichuxing.comp.telecom.core.voip.AnalyseTickHelper r6 = com.didichuxing.comp.telecom.core.voip.AnalyseTickHelper.INSTANCE
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r1 = r5.f46356h
            if (r1 == 0) goto L_0x0064
            com.didichuxing.comp.telecom.core.voip.VoipCallModel r1 = r1.getVoipCallModel()
            goto L_0x0065
        L_0x0064:
            r1 = r0
        L_0x0065:
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r2 = r5.f46356h
            if (r2 == 0) goto L_0x006d
            com.didichuxing.comp.telecom.core.CallRole r0 = r2.getRole()
        L_0x006d:
            java.lang.String r2 = "stopcall"
            r6.tickVoipSteps(r2, r1, r0)
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r6 = r5.f46356h
            if (r6 == 0) goto L_0x0079
            r6.hangUp()
        L_0x0079:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.comp.telecom.biz.p176ui.voipcall.floatwindow.p178vh.InCallViewHolder.onHangUpClick(android.view.View):void");
    }

    public void notifyStateDes(String str) {
        VoipCallListener.DefaultImpls.notifyStateDes(this, str);
        TextView textView = this.f46353e;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void onAudioDeviceChange(VoipAudioCall voipAudioCall, int i) {
        Intrinsics.checkParameterIsNotNull(voipAudioCall, NotificationCompat.CATEGORY_CALL);
        VoipCallListener.DefaultImpls.onAudioDeviceChange(this, voipAudioCall, i);
        m33270a(Integer.valueOf(i));
    }

    /* renamed from: a */
    private final void m33270a(Integer num) {
        ImageView imageView = this.f46355g;
        boolean z = false;
        if (imageView != null) {
            imageView.setClickable((num != null && num.intValue() == 3) || (num != null && num.intValue() == 4));
        }
        if (num != null && num.intValue() == 3) {
            z = true;
        }
        ImageView imageView2 = this.f46355g;
        if (imageView2 != null) {
            imageView2.setImageResource(z ? R.drawable.voip_biz_callpage_sound_on : R.drawable.voip_biz_callpage_sound_close);
        }
    }
}

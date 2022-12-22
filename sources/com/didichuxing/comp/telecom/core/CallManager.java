package com.didichuxing.comp.telecom.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.didichuxing.comp.telecom.core.base.ICall;
import com.didichuxing.comp.telecom.core.voip.VoipAudioCall;
import com.didichuxing.comp.telecom.core.voip.VoipCallModel;
import com.didichuxing.comp.telecom.core.voip.VoipCallModelKt;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0012\u0010\u0014\u001a\u00020\u00102\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\tJ\b\u0010\u0016\u001a\u00020\u0017H\u0007J\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0001J\u0014\u0010 \u001a\u00020\u00102\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\tH\u0002J\u000e\u0010\"\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/CallManager;", "", "()V", "TAG", "", "mCallbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/didichuxing/comp/telecom/core/CallManagerStateListener;", "<set-?>", "Lcom/didichuxing/comp/telecom/core/base/ICall;", "mCurrentCall", "getMCurrentCall", "()Lcom/didichuxing/comp/telecom/core/base/ICall;", "mHandler", "Landroid/os/Handler;", "bindCallListener", "", "callback", "owner", "Landroidx/lifecycle/LifecycleOwner;", "destroyCurCall", "call", "getAppContext", "Landroid/content/Context;", "inCalling", "", "makeVoipCall", "Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;", "model", "Lcom/didichuxing/comp/telecom/core/voip/VoipCallModel;", "onCallIncome", "sameToCurrent", "setCurCall", "newCall", "unbindCallListener", "Companion", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: CallManager.kt */
public final class CallManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final Lazy f46386e = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, CallManager$Companion$sInstance$2.INSTANCE);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Handler f46387a = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final String f46388b = "CallManager";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final CopyOnWriteArrayList<CallManagerStateListener> f46389c = new CopyOnWriteArrayList<>();

    /* renamed from: d */
    private ICall f46390d;

    @JvmStatic
    public static final CallManager getInstance() {
        return Companion.getInstance();
    }

    public CallManager() {
        bindCallListener$default(this, new CallManagerStateListener(this) {
            final /* synthetic */ CallManager this$0;

            public void onCallDestroy(ICall iCall) {
            }

            {
                this.this$0 = r1;
            }

            public void onCallCreate(ICall iCall) {
                Intrinsics.checkParameterIsNotNull(iCall, "newCall");
                Object model = iCall.getModel();
                String str = null;
                if (!(model instanceof VoipCallModel)) {
                    model = null;
                }
                VoipCallModel voipCallModel = (VoipCallModel) model;
                if (voipCallModel != null) {
                    str = voipCallModel.getEvent();
                }
                if (Intrinsics.areEqual((Object) str, (Object) VoipCallModelKt.PUSH_EVENT_INCOMECALL)) {
                    Long expireTime = voipCallModel.getExpireTime();
                    long longValue = ((expireTime != null ? expireTime.longValue() : 0) * 1000) - CallManagerAssist.getTimeMillis();
                    if (longValue > 0) {
                        CallLogUtil.logI(this.this$0.f46388b, "onCallCreate - time left:" + longValue);
                        this.this$0.f46387a.postDelayed(new CallManager$1$onCallCreate$1(this, iCall), longValue);
                    }
                }
            }
        }, (LifecycleOwner) null, 2, (Object) null);
    }

    public final Context getAppContext() {
        CallManagerAssist instance = CallManagerAssist.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
        Context appContext = instance.getAppContext();
        if (appContext != null) {
            return appContext;
        }
        throw new Exception("voip sdk hasn't initialed, invoke CallManagerAssist.init()");
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0007R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/CallManager$Companion;", "", "()V", "sInstance", "Lcom/didichuxing/comp/telecom/core/CallManager;", "getSInstance", "()Lcom/didichuxing/comp/telecom/core/CallManager;", "sInstance$delegate", "Lkotlin/Lazy;", "getInstance", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
    /* compiled from: CallManager.kt */
    public static final class Companion {
        static final /* synthetic */ KProperty[] $$delegatedProperties = {C21490Reflection.property1(new PropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(Companion.class), "sInstance", "getSInstance()Lcom/didichuxing/comp/telecom/core/CallManager;"))};

        private final CallManager getSInstance() {
            Lazy access$getSInstance$cp = CallManager.f46386e;
            Companion companion = CallManager.Companion;
            KProperty kProperty = $$delegatedProperties[0];
            return (CallManager) access$getSInstance$cp.getValue();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final CallManager getInstance() {
            return getSInstance();
        }
    }

    public final ICall getMCurrentCall() {
        return this.f46390d;
    }

    public final boolean inCalling() {
        return this.f46390d != null;
    }

    public final boolean sameToCurrent(Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "model");
        ICall iCall = this.f46390d;
        if (iCall == null) {
            return false;
        }
        return Intrinsics.areEqual(obj, iCall != null ? iCall.getModel() : null);
    }

    public final VoipAudioCall makeVoipCall(VoipCallModel voipCallModel) {
        Intrinsics.checkParameterIsNotNull(voipCallModel, "model");
        VoipAudioCall voipAudioCall = new VoipAudioCall(CallRole.CALL_MAKER, voipCallModel);
        m33281a(voipAudioCall);
        return voipAudioCall;
    }

    public final VoipAudioCall onCallIncome(VoipCallModel voipCallModel) {
        Intrinsics.checkParameterIsNotNull(voipCallModel, "model");
        VoipAudioCall voipAudioCall = new VoipAudioCall(CallRole.CALLEE, voipCallModel);
        m33281a(voipAudioCall);
        return voipAudioCall;
    }

    public static /* synthetic */ void destroyCurCall$default(CallManager callManager, ICall iCall, int i, Object obj) {
        if ((i & 1) != 0) {
            iCall = null;
        }
        callManager.destroyCurCall(iCall);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
        r3 = r5.getModel();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void destroyCurCall(com.didichuxing.comp.telecom.core.base.ICall r5) {
        /*
            r4 = this;
            java.lang.String r0 = r4.f46388b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "destroyCurCall - "
            r1.append(r2)
            r2 = 0
            if (r5 == 0) goto L_0x001a
            java.lang.Object r3 = r5.getModel()
            if (r3 == 0) goto L_0x001a
            java.lang.String r3 = r3.toString()
            goto L_0x001b
        L_0x001a:
            r3 = r2
        L_0x001b:
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.didichuxing.comp.telecom.core.CallLogUtil.logI(r0, r1)
            if (r5 == 0) goto L_0x002a
            r5.onDestroy()
        L_0x002a:
            if (r5 == 0) goto L_0x0063
            com.didichuxing.comp.telecom.core.base.ICall r0 = r4.f46390d
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r0)
            r5 = r5 ^ 1
            if (r5 == 0) goto L_0x0063
            java.lang.String r5 = r4.f46388b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "not same to cur call - "
            r0.append(r1)
            com.didichuxing.comp.telecom.core.base.ICall r1 = r4.f46390d
            if (r1 == 0) goto L_0x0051
            java.lang.Object r1 = r1.getModel()
            if (r1 == 0) goto L_0x0051
            java.lang.String r1 = r1.toString()
            goto L_0x0052
        L_0x0051:
            r1 = r2
        L_0x0052:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.didichuxing.comp.telecom.core.CallLogUtil.logI(r5, r0)
            com.didichuxing.comp.telecom.core.base.ICall r5 = r4.f46390d
            if (r5 == 0) goto L_0x0063
            r5.onDestroy()
        L_0x0063:
            r4.m33281a(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.comp.telecom.core.CallManager.destroyCurCall(com.didichuxing.comp.telecom.core.base.ICall):void");
    }

    /* renamed from: a */
    static /* synthetic */ void m33280a(CallManager callManager, ICall iCall, int i, Object obj) {
        if ((i & 1) != 0) {
            iCall = null;
        }
        callManager.m33281a(iCall);
    }

    /* renamed from: a */
    private final void m33281a(ICall iCall) {
        ICall iCall2 = this.f46390d;
        this.f46390d = iCall;
        if (iCall != null) {
            for (CallManagerStateListener onCallCreate : this.f46389c) {
                onCallCreate.onCallCreate(iCall);
            }
            return;
        }
        for (CallManagerStateListener onCallDestroy : this.f46389c) {
            onCallDestroy.onCallDestroy(iCall2);
        }
    }

    public static /* synthetic */ void bindCallListener$default(CallManager callManager, CallManagerStateListener callManagerStateListener, LifecycleOwner lifecycleOwner, int i, Object obj) {
        if ((i & 2) != 0) {
            lifecycleOwner = null;
        }
        callManager.bindCallListener(callManagerStateListener, lifecycleOwner);
    }

    public final void bindCallListener(CallManagerStateListener callManagerStateListener, LifecycleOwner lifecycleOwner) {
        Lifecycle lifecycle;
        if (callManagerStateListener != null && !this.f46389c.contains(callManagerStateListener)) {
            this.f46389c.add(callManagerStateListener);
            if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
                lifecycle.addObserver(new CallManager$bindCallListener$1(this, callManagerStateListener));
            }
        }
    }

    public final void unbindCallListener(CallManagerStateListener callManagerStateListener) {
        Intrinsics.checkParameterIsNotNull(callManagerStateListener, "callback");
        this.f46389c.remove(callManagerStateListener);
    }
}

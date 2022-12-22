package com.didichuxing.comp.telecom.biz.api;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import com.didichuxing.comp.telecom.biz.p176ui.calllist.CallListBottomPop;
import com.didichuxing.comp.telecom.biz.p176ui.calllist.PhoneClickCallback;
import com.didichuxing.comp.telecom.biz.p176ui.calllist.VoipClickCallback;
import com.didichuxing.comp.telecom.biz.p176ui.notitication.VoipNotificationHelper;
import com.didichuxing.comp.telecom.biz.p176ui.voipcall.VoipBusinessActivity;
import com.didichuxing.comp.telecom.biz.p176ui.voipcall.floatwindow.FloatWindowUtils;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.CallManager;
import com.didichuxing.comp.telecom.core.CallManagerAssist;
import com.didichuxing.comp.telecom.core.CallRole;
import com.didichuxing.comp.telecom.core.CallState;
import com.didichuxing.comp.telecom.core.base.ICall;
import com.didichuxing.comp.telecom.core.request.VoipCallRequest;
import com.didichuxing.comp.telecom.core.util.PhoneCallHelper;
import com.didichuxing.comp.telecom.core.voip.AnalyseTickHelper;
import com.didichuxing.comp.telecom.core.voip.VoipAudioCall;
import com.didichuxing.comp.telecom.core.voip.VoipCallModel;
import com.didichuxing.comp.telecom.core.voip.VoipCallModelKt;
import com.didichuxing.comp.telecom.impl.VoipBusinessImpl;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.Gson;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010\u000eJ)\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0002\u0010\u000eJ\u001c\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u0006\u0010\u0013\u001a\u00020\u0014J'\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0002\u0010\u0018JB\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000¨\u0006\""}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/biz/api/VoipBusinessSDK;", "", "()V", "PUSH_FROM_LINK", "", "PUSH_FROM_PLATFORM_NOTIFICATION", "TAG", "", "displayInComingCall", "", "context", "Landroid/content/Context;", "jsonStr", "pushTye", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Integer;)V", "handleIncomeCall", "init", "config", "Lcom/didichuxing/comp/telecom/core/CallManagerAssist$CallManagerConfig;", "isInitialized", "", "notifyCallComing", "model", "Lcom/didichuxing/comp/telecom/core/voip/VoipCallModel;", "(Landroid/content/Context;Lcom/didichuxing/comp/telecom/core/voip/VoipCallModel;Ljava/lang/Integer;)V", "showCallMethodDialog", "activity", "Landroid/app/Activity;", "requestParams", "", "phoneCallback", "Lcom/didichuxing/comp/telecom/biz/ui/calllist/PhoneClickCallback;", "voipCallback", "Lcom/didichuxing/comp/telecom/biz/ui/calllist/VoipClickCallback;", "voip-biz_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: VoipBusinessSDK.kt */
public final class VoipBusinessSDK {
    public static final VoipBusinessSDK INSTANCE = new VoipBusinessSDK();
    public static final int PUSH_FROM_LINK = 1;
    public static final int PUSH_FROM_PLATFORM_NOTIFICATION = 2;

    /* renamed from: a */
    private static final String f46281a = f46281a;

    @JvmStatic
    public static final void displayInComingCall(Context context, String str) {
        displayInComingCall$default(context, str, (Integer) null, 4, (Object) null);
    }

    @JvmStatic
    public static final void showCallMethodDialog(Activity activity) {
        showCallMethodDialog$default(activity, (Map) null, (PhoneClickCallback) null, (VoipClickCallback) null, 14, (Object) null);
    }

    @JvmStatic
    public static final void showCallMethodDialog(Activity activity, Map<String, ? extends Object> map) {
        showCallMethodDialog$default(activity, map, (PhoneClickCallback) null, (VoipClickCallback) null, 12, (Object) null);
    }

    @JvmStatic
    public static final void showCallMethodDialog(Activity activity, Map<String, ? extends Object> map, PhoneClickCallback phoneClickCallback) {
        showCallMethodDialog$default(activity, map, phoneClickCallback, (VoipClickCallback) null, 8, (Object) null);
    }

    private VoipBusinessSDK() {
    }

    @JvmStatic
    public static /* synthetic */ void init$default(Context context, CallManagerAssist.CallManagerConfig callManagerConfig, int i, Object obj) {
        if ((i & 2) != 0) {
            callManagerConfig = null;
        }
        init(context, callManagerConfig);
    }

    @JvmStatic
    public static final void init(Context context, CallManagerAssist.CallManagerConfig callManagerConfig) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        CallManagerAssist.getInstance().init(context, callManagerConfig);
        CallManagerAssist.getInstance().bindResources(VoipBusinessImpl.bindResources());
        VoipNotificationHelper.Companion.getInstance();
    }

    public final boolean isInitialized() {
        return CallManagerAssist.getInstance().initialized();
    }

    @JvmStatic
    public static /* synthetic */ void showCallMethodDialog$default(Activity activity, Map map, PhoneClickCallback phoneClickCallback, VoipClickCallback voipClickCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        if ((i & 4) != 0) {
            phoneClickCallback = null;
        }
        if ((i & 8) != 0) {
            voipClickCallback = null;
        }
        showCallMethodDialog(activity, map, phoneClickCallback, voipClickCallback);
    }

    @JvmStatic
    public static final void showCallMethodDialog(Activity activity, Map<String, ? extends Object> map, PhoneClickCallback phoneClickCallback, VoipClickCallback voipClickCallback) {
        String str = f46281a;
        CallLogUtil.logI(str, "showCallMethodDialog invoked - " + map);
        if (activity != null) {
            new CallListBottomPop(activity, map, phoneClickCallback, voipClickCallback).show();
        }
    }

    @JvmStatic
    public static /* synthetic */ void displayInComingCall$default(Context context, String str, Integer num, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        displayInComingCall(context, str, num);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0013, code lost:
        r2 = r2.getAppServiceProvider();
     */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void displayInComingCall(android.content.Context r7, java.lang.String r8, java.lang.Integer r9) {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            com.didichuxing.comp.telecom.core.CallManagerAssist r2 = com.didichuxing.comp.telecom.core.CallManagerAssist.getInstance()
            java.lang.String r3 = "CallManagerAssist.getInstance()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            com.didichuxing.comp.telecom.core.CallManagerAssist$CallManagerConfig r2 = r2.getConfig()
            if (r2 == 0) goto L_0x001e
            com.didichuxing.comp.telecom.core.CallManagerAssist$AppServiceProvider r2 = r2.getAppServiceProvider()
            if (r2 == 0) goto L_0x001e
            long r2 = r2.serverTime()
            goto L_0x0020
        L_0x001e:
            r2 = -1
        L_0x0020:
            java.lang.String r4 = f46281a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "[Entrance-Push:"
            r5.append(r6)
            r5.append(r9)
            java.lang.String r6 = "] - displayInComingCall - deviceTime:"
            r5.append(r6)
            r5.append(r0)
            java.lang.String r0 = " serverTime:"
            r5.append(r0)
            r5.append(r2)
            r0 = 32
            r5.append(r0)
            r5.append(r8)
            java.lang.String r0 = r5.toString()
            com.didichuxing.comp.telecom.core.CallLogUtil.logI(r4, r0)
            if (r7 == 0) goto L_0x0080
            r0 = r8
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x005a
            goto L_0x0080
        L_0x005a:
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            r0 = r0 ^ 1
            if (r0 == 0) goto L_0x007b
            com.didichuxing.comp.telecom.core.CallThreadDispatcher$Companion r0 = com.didichuxing.comp.telecom.core.CallThreadDispatcher.Companion
            com.didichuxing.comp.telecom.core.CallThreadDispatcher r0 = r0.getInstance()
            com.didichuxing.comp.telecom.biz.api.VoipBusinessSDK$displayInComingCall$1 r1 = new com.didichuxing.comp.telecom.biz.api.VoipBusinessSDK$displayInComingCall$1
            r1.<init>(r7, r8, r9)
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            r0.runOnUiThread(r1)
            goto L_0x0080
        L_0x007b:
            com.didichuxing.comp.telecom.biz.api.VoipBusinessSDK r0 = INSTANCE
            r0.m33235a((android.content.Context) r7, (java.lang.String) r8, (java.lang.Integer) r9)
        L_0x0080:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.comp.telecom.biz.api.VoipBusinessSDK.displayInComingCall(android.content.Context, java.lang.String, java.lang.Integer):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m33235a(Context context, String str, Integer num) {
        ICall mCurrentCall;
        VoipAudioCall voipAudioCall = null;
        VoipCallModel voipCallModel = null;
        try {
            voipCallModel = (VoipCallModel) new Gson().fromJson(str, VoipCallModel.class);
        } catch (Exception unused) {
        }
        if (voipCallModel != null) {
            CallLogUtil.logI(f46281a, "handleIncomeCall - model parsed " + voipCallModel.getEvent());
            AnalyseTickHelper.INSTANCE.tickPushArrived(voipCallModel, num);
            CallManager instance = CallManager.Companion.getInstance();
            String event = voipCallModel.getEvent();
            if (event != null) {
                switch (event.hashCode()) {
                    case -1020452985:
                        if (!event.equals(VoipCallModelKt.PUSH_EVENT_INCOMECALL)) {
                            return;
                        }
                        if (instance.sameToCurrent(voipCallModel)) {
                            CallLogUtil.logI(f46281a, "handleIncomeCall - ignore for the same call");
                            return;
                        } else if (PhoneCallHelper.Companion.getInstance().isPhoneCalling()) {
                            CallLogUtil.logI(f46281a, "handleIncomeCall - ignore for in phone call");
                            VoipCallRequest.requestEventReport$default(VoipCallRequest.INSTANCE, "busy", voipCallModel, (RpcService.Callback) null, 4, (Object) null);
                            AnalyseTickHelper.INSTANCE.tickUserActions("busy", voipCallModel, CallRole.CALLEE);
                            return;
                        } else if (instance.inCalling()) {
                            CallLogUtil.logI(f46281a, "handleIncomeCall - ignore for in voip call");
                            VoipCallRequest.requestEventReport$default(VoipCallRequest.INSTANCE, "busy", voipCallModel, (RpcService.Callback) null, 4, (Object) null);
                            AnalyseTickHelper.INSTANCE.tickUserActions("busy", voipCallModel, CallRole.CALLEE);
                            return;
                        } else {
                            m33234a(context, voipCallModel, num);
                            return;
                        }
                    case -934710369:
                        if (!event.equals("reject")) {
                            return;
                        }
                        break;
                    case 3035641:
                        if (!event.equals("busy")) {
                            return;
                        }
                        break;
                    case 1099376044:
                        if (event.equals("cf_hang_up") && instance.sameToCurrent(voipCallModel)) {
                            ICall mCurrentCall2 = instance.getMCurrentCall();
                            if (mCurrentCall2 instanceof VoipAudioCall) {
                                voipAudioCall = mCurrentCall2;
                            }
                            VoipAudioCall voipAudioCall2 = voipAudioCall;
                            if (voipAudioCall2 != null) {
                                CallState state = voipAudioCall2.getState();
                                if (state == CallState.INITIALED || state == CallState.INCOME_RINGING) {
                                    voipAudioCall2.forceStop();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
                if (instance.sameToCurrent(voipCallModel) && (mCurrentCall = instance.getMCurrentCall()) != null) {
                    mCurrentCall.handleCallEvent(voipCallModel);
                }
            }
        }
    }

    /* renamed from: a */
    private final void m33234a(Context context, VoipCallModel voipCallModel, Integer num) {
        CallManagerAssist.AppServiceProvider appServiceProvider;
        CallManagerAssist.CallManagerConfig config;
        CallManagerAssist.CallEventTickHandler eventTickHandler;
        Long expireTime = voipCallModel.getExpireTime();
        long longValue = (expireTime != null ? expireTime.longValue() : 0) * 1000;
        long timeMillis = CallManagerAssist.getTimeMillis();
        if (longValue <= timeMillis) {
            String str = f46281a;
            CallLogUtil.logI(str, "notifyCallComing - this call is expired, time left: " + (longValue - timeMillis));
            CallManagerAssist instance = CallManagerAssist.getInstance();
            if (instance != null && (config = instance.getConfig()) != null && (eventTickHandler = config.getEventTickHandler()) != null) {
                eventTickHandler.onToastShow((String) null, (String) null, "Expired", voipCallModel);
                return;
            }
            return;
        }
        CallManager.Companion.getInstance().onCallIncome(voipCallModel);
        CallManagerAssist instance2 = CallManagerAssist.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance2, "CallManagerAssist.getInstance()");
        CallManagerAssist.CallManagerConfig config2 = instance2.getConfig();
        boolean z = false;
        boolean isForeGround = (config2 == null || (appServiceProvider = config2.getAppServiceProvider()) == null) ? false : appServiceProvider.isForeGround();
        boolean z2 = Build.VERSION.SDK_INT < 29;
        if (num != null && num.intValue() == 2) {
            z = true;
        }
        boolean hasFloatWindowPermission = FloatWindowUtils.INSTANCE.hasFloatWindowPermission(context);
        String str2 = f46281a;
        CallLogUtil.logI(str2, "notifyCallComing - fg:" + isForeGround + " startBg:" + z2 + " isPushClick:" + z + " float:" + hasFloatWindowPermission);
        if (isForeGround || z2 || z || hasFloatWindowPermission) {
            CallLogUtil.logI(f46281a, "notifyCallComing - try open Activity");
            try {
                VoipBusinessActivity.Companion.openPage(context, voipCallModel, 3);
            } catch (Throwable th) {
                CallLogUtil.logError(f46281a, "notifyCallComing - cannot open call activity", th);
            }
        } else {
            CallLogUtil.logI(f46281a, "notifyCallComing - open notification for income call");
            VoipNotificationHelper.Companion.notifyIncomeCall(context, voipCallModel);
        }
    }
}

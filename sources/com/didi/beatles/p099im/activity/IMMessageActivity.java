package com.didi.beatles.p099im.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.collection.LongSparseArray;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.datadog.android.monitoring.internal.InternalLogsFeature;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.access.action.IMActionFactory;
import com.didi.beatles.p099im.access.action.IMActionItem;
import com.didi.beatles.p099im.access.core.IMPushEngine;
import com.didi.beatles.p099im.access.core.IMStageFeedBack;
import com.didi.beatles.p099im.access.notify.NotificationUtils;
import com.didi.beatles.p099im.access.style.IMStyleManager;
import com.didi.beatles.p099im.access.style.custom.IMCustomContext;
import com.didi.beatles.p099im.access.style.custom.IMCustomResHelper;
import com.didi.beatles.p099im.access.utils.ConfigLoadListener;
import com.didi.beatles.p099im.access.utils.IMBusinessConfig;
import com.didi.beatles.p099im.adapter.MessageAdapter;
import com.didi.beatles.p099im.api.IMApiConst;
import com.didi.beatles.p099im.api.entity.IMBaseResponse;
import com.didi.beatles.p099im.api.entity.IMConfig;
import com.didi.beatles.p099im.api.entity.IMInvokePhoneRequest;
import com.didi.beatles.p099im.api.entity.IMInvokePhoneResponse;
import com.didi.beatles.p099im.api.entity.IMLocationEntity;
import com.didi.beatles.p099im.api.entity.IMOrderStatusChangeBody;
import com.didi.beatles.p099im.api.entity.IMSendMessageResponse;
import com.didi.beatles.p099im.api.entity.IMSessionExtendInfo;
import com.didi.beatles.p099im.api.entity.IMTopOperationBody;
import com.didi.beatles.p099im.common.IMBtsAudioHelper;
import com.didi.beatles.p099im.common.IMBtsAudioPlayer;
import com.didi.beatles.p099im.common.IMChatHelper;
import com.didi.beatles.p099im.common.IMLifecycleHandler;
import com.didi.beatles.p099im.common.IMMessageList;
import com.didi.beatles.p099im.common.IMPollingService;
import com.didi.beatles.p099im.common.audio.IMFileHelper;
import com.didi.beatles.p099im.common.widget.IMOnAntiShakeClickListener;
import com.didi.beatles.p099im.data.IMInnerData;
import com.didi.beatles.p099im.event.IMBackgroundSendMessage;
import com.didi.beatles.p099im.event.IMEventDispatcher;
import com.didi.beatles.p099im.event.IMMessageColloectionUpdateEvent;
import com.didi.beatles.p099im.event.IMMessageDetailFinishEvent;
import com.didi.beatles.p099im.event.IMMessageEmptyEvent;
import com.didi.beatles.p099im.event.IMMessageHandleExpiredPicEvent;
import com.didi.beatles.p099im.event.IMMessageSysCardShowEvent;
import com.didi.beatles.p099im.event.IMMessageUnlockRecyclerViewEvent;
import com.didi.beatles.p099im.event.IMMessageUpdateReadStatusEvent;
import com.didi.beatles.p099im.event.IMSendAddressEvent;
import com.didi.beatles.p099im.event.IMSessionInfoUpdateErrorEvent;
import com.didi.beatles.p099im.event.IMSessionInfoUpdateEvent;
import com.didi.beatles.p099im.event.IMShowCustomWordDialogEvent;
import com.didi.beatles.p099im.event.IMSkipToMainActivityEvent;
import com.didi.beatles.p099im.event.IMViewImageEvent;
import com.didi.beatles.p099im.event.IMViewStreetImageEvent;
import com.didi.beatles.p099im.manager.IMActionTipManager;
import com.didi.beatles.p099im.manager.IMManager;
import com.didi.beatles.p099im.manager.IMMessageReadStatusManager;
import com.didi.beatles.p099im.manager.IMStageFeedBackListerManager;
import com.didi.beatles.p099im.module.IIMGlobalModule;
import com.didi.beatles.p099im.module.IIMMessageModule;
import com.didi.beatles.p099im.module.IIMSessionModule;
import com.didi.beatles.p099im.module.IIMUserModule;
import com.didi.beatles.p099im.module.IMEmojiModule;
import com.didi.beatles.p099im.module.IMExtendBtnModule;
import com.didi.beatles.p099im.module.IMMessageCallBackImp;
import com.didi.beatles.p099im.module.IMMessageCallback;
import com.didi.beatles.p099im.module.IMPreSendCallback;
import com.didi.beatles.p099im.module.IMSendMessageCallback;
import com.didi.beatles.p099im.module.IMSessionCallback;
import com.didi.beatles.p099im.module.IMSessionCallbackAdapter;
import com.didi.beatles.p099im.module.IMUserInfoCallback;
import com.didi.beatles.p099im.module.entity.IMAddress;
import com.didi.beatles.p099im.module.entity.IMBusinessParam;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.module.entity.IMSession;
import com.didi.beatles.p099im.module.entity.IMUser;
import com.didi.beatles.p099im.module.impl.IMGroupUserInfoCallback;
import com.didi.beatles.p099im.net.IMHttpManager;
import com.didi.beatles.p099im.net.IMNetCallback;
import com.didi.beatles.p099im.omega.IMMsgOmega;
import com.didi.beatles.p099im.omega.IMTraceError;
import com.didi.beatles.p099im.omega.IMTraceUtil;
import com.didi.beatles.p099im.omega.OmegaUtil;
import com.didi.beatles.p099im.p100db.entity.IMMessageDaoEntity;
import com.didi.beatles.p099im.picture.IMPictureSelector;
import com.didi.beatles.p099im.picture.entity.IMLocalMedia;
import com.didi.beatles.p099im.plugin.IMHostProxy;
import com.didi.beatles.p099im.plugin.IMPluginSendListener;
import com.didi.beatles.p099im.pref.IMPreference;
import com.didi.beatles.p099im.protocol.host.IMActionInvokeEnv;
import com.didi.beatles.p099im.protocol.host.IMActionInvokeReturn;
import com.didi.beatles.p099im.protocol.model.IMBottomGuideConfig;
import com.didi.beatles.p099im.protocol.model.IMTabActionItem;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.C4234I;
import com.didi.beatles.p099im.utils.IMCommonUtil;
import com.didi.beatles.p099im.utils.IMExpoMtaManager;
import com.didi.beatles.p099im.utils.IMField;
import com.didi.beatles.p099im.utils.IMIdGenerator;
import com.didi.beatles.p099im.utils.IMJsonUtil;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.IMParamUtil;
import com.didi.beatles.p099im.utils.IMPollingUtils;
import com.didi.beatles.p099im.utils.IMRTLUtils;
import com.didi.beatles.p099im.utils.IMStreetUtils;
import com.didi.beatles.p099im.utils.IMTextUtil;
import com.didi.beatles.p099im.utils.IMToastHelper;
import com.didi.beatles.p099im.utils.IMViewUtil;
import com.didi.beatles.p099im.utils.UiThreadHandler;
import com.didi.beatles.p099im.views.IMDialogFactory;
import com.didi.beatles.p099im.views.IMRecommendEmojiView;
import com.didi.beatles.p099im.views.IMTipsToast;
import com.didi.beatles.p099im.views.bottombar.IMBaseBottomBar;
import com.didi.beatles.p099im.views.bottombar.IMConversationBottomBar;
import com.didi.beatles.p099im.views.buttonView.IMTopOperationView;
import com.didi.beatles.p099im.views.dialog.IMAddCommonWordDialog;
import com.didi.beatles.p099im.views.dialog.IMDialog;
import com.didi.beatles.p099im.views.eggs.IMEggsLayout;
import com.didi.beatles.p099im.views.popup.IMExtendBtnPopup;
import com.didi.beatles.p099im.views.popup.IMMessageOperatePopup;
import com.didi.beatles.p099im.views.titlebar.CommonTitleBar;
import com.didi.beatles.p099im.views.widget.IMLoadingView;
import com.didi.beatles.p099im.views.widget.IMSimpleGuideView;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.sdk.apm.SystemUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.taxis99.R;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import rui.config.RConfigConstants;

/* renamed from: com.didi.beatles.im.activity.IMMessageActivity */
public class IMMessageActivity extends IMBaseActivity implements MessageAdapter.MessageAdapterListener, IMUserInfoCallback, IMPluginSendListener, IMBaseBottomBar.BottomBarListener {
    public static long CURRENT_SID = -1;
    public static final String EXTRA_TAG_BUSINESSS_PARAM = "business_param";
    public static final String EXTRA_TAG_SOURCE = "source";

    /* renamed from: b */
    private static final String f8916b = "IMMessageActivity";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final boolean f8917c = IMField.DEBUG;

    /* renamed from: d */
    private static final int f8918d = 0;

    /* renamed from: e */
    private static final int f8919e = 1;

    /* renamed from: h */
    private static final int f8920h = 1;

    /* renamed from: i */
    private static final int f8921i = 120;

    /* renamed from: j */
    private static final int f8922j = 2;

    /* renamed from: k */
    private static final int f8923k = 3;

    /* renamed from: l */
    private static final int f8924l = 4;

    /* renamed from: m */
    private static final int f8925m = 5;

    /* renamed from: n */
    private static final int f8926n = 6;

    /* renamed from: o */
    private static final int f8927o = 7;

    /* renamed from: A */
    private IIMGlobalModule f8928A;

    /* renamed from: B */
    private final String f8929B = "IMDIALOG";
    /* access modifiers changed from: private */

    /* renamed from: C */
    public long f8930C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public IMSession f8931D;

    /* renamed from: E */
    private IMCustomContext f8932E;

    /* renamed from: F */
    private View f8933F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public IMExtendBtnPopup f8934G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public View f8935H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public IMBusinessParam f8936I = null;

    /* renamed from: J */
    private IMMessageCallback f8937J = null;

    /* renamed from: K */
    private IMSessionCallback f8938K = null;

    /* renamed from: L */
    private IMStaticSessionModuleListener f8939L = null;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public int f8940M;
    /* access modifiers changed from: private */

    /* renamed from: N */
    public boolean f8941N = true;

    /* renamed from: O */
    private IMRecommendEmojiView f8942O;

    /* renamed from: P */
    private int f8943P;
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public ImageView f8944Q;
    /* access modifiers changed from: private */

    /* renamed from: R */
    public TextView f8945R;
    /* access modifiers changed from: private */

    /* renamed from: S */
    public Set<IMMessage> f8946S = new TreeSet($$Lambda$IMMessageActivity$KqlCFovtYRgFSON5P6eGoX3Jzz8.INSTANCE);

    /* renamed from: T */
    private int f8947T;

    /* renamed from: U */
    private LongSparseArray<IMMessage> f8948U = new LongSparseArray<>(1);
    /* access modifiers changed from: private */

    /* renamed from: V */
    public PopupWindow f8949V;

    /* renamed from: W */
    private HeadsetPlugReceiver f8950W;

    /* renamed from: X */
    private boolean f8951X;

    /* renamed from: Y */
    private boolean f8952Y = false;

    /* renamed from: Z */
    private boolean f8953Z = false;

    /* renamed from: a */
    View.OnTouchListener f8954a = new View.OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || IMMessageActivity.this.f8960g == null) {
                return false;
            }
            IMMessageActivity.this.f8960g.shrinkBottomBarByRecycle();
            return false;
        }
    };

    /* renamed from: aa */
    private boolean f8955aa = false;
    /* access modifiers changed from: private */

    /* renamed from: ab */
    public final Handler f8956ab = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 7 && IMMessageActivity.this.f8949V != null && IMMessageActivity.this.f8949V.isShowing()) {
                try {
                    IMMessageActivity.this.f8949V.dismiss();
                    PopupWindow unused = IMMessageActivity.this.f8949V = null;
                } catch (Exception e) {
                    IMLog.m6633e(e);
                }
            }
        }
    };

    /* renamed from: ac */
    private View.OnClickListener f8957ac = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            if (IMMessageActivity.this.f8931D.getType() == 2) {
                IMMessageActivity iMMessageActivity = IMMessageActivity.this;
                IMGroupProfileActivity.startActivity(iMMessageActivity, iMMessageActivity.f8930C);
                return;
            }
            IMTraceUtil.addBusinessEvent("ddim_service_item_profile_ck").add("product_id", Integer.valueOf(IMMessageActivity.this.f8931D.getBusinessId())).add("no_appid", Long.valueOf(IMMessageActivity.this.f8931D.getPeerUid())).report();
            IMMessageActivity iMMessageActivity2 = IMMessageActivity.this;
            IMUserProfileActivity.startActivity(iMMessageActivity2, iMMessageActivity2.f8931D.getSessionName(), IMMessageActivity.this.f8931D.getPeerUid());
        }
    };

    /* renamed from: ad */
    private View.OnClickListener f8958ad = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            if (IMMessageActivity.this.f8931D != null && IMMessageActivity.this.f8931D.getExtendSessionInfo() != null) {
                IMMessageActivity iMMessageActivity = IMMessageActivity.this;
                IMCommonUtil.startUriActivity(iMMessageActivity, iMMessageActivity.f8931D.getExtendSessionInfo().slink);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: f */
    public CommonTitleBar f8959f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public IMBaseBottomBar f8960g;
    public IMLifecycleHandler.Controller mController;
    public View.OnLayoutChangeListener mLayoutChangeListener = new View.OnLayoutChangeListener() {
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            int windowHeight = IMViewUtil.getWindowHeight(IMMessageActivity.this) / 3;
            if (i8 != 0 && i4 != 0 && i8 - i4 > windowHeight) {
                IMMessageActivity.this.m6056r();
            }
        }
    };

    /* renamed from: p */
    private FrameLayout f8961p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public RecyclerView f8962q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public IMEggsLayout f8963r;

    /* renamed from: s */
    private IMTopOperationView f8964s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public MessageAdapter f8965t;

    /* renamed from: u */
    private final int f8966u = 20;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public IMBusinessConfig f8967v;

    /* renamed from: w */
    private IMDialog f8968w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public IIMSessionModule f8969x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public IIMMessageModule f8970y;

    /* renamed from: z */
    private IIMUserModule f8971z;

    public Context getHostContext() {
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ int m5988a(IMMessage iMMessage, IMMessage iMMessage2) {
        if (iMMessage == null || iMMessage.getCloudUniqueMsgId() == null || iMMessage2 == null || iMMessage2.getCloudUniqueMsgId() == null) {
            return 0;
        }
        return iMMessage.getCloudUniqueMsgId().compareTo(iMMessage2.getCloudUniqueMsgId());
    }

    public void sendPluginTextMessage(int i, String str, int i2, Object obj) {
        m6010a(str, i2, -1, obj);
    }

    public void sendPluginMessage(int i, String str, String str2, int i2) {
        if (this.f8970y != null && this.f8936I != null) {
            m6052p();
            m6019b(this.f8970y.sendPluginMessage(i, str, str2, i2, this.f8936I, this.f8931D, (IMSendMessageCallback) null));
        }
    }

    public void sendStreetViewMessage(int i) {
        IMBusinessParam iMBusinessParam;
        IMSession iMSession;
        if (!IMStreetUtils.canClickStreetView()) {
            IMToastHelper.showLongError(IMContextInfoHelper.getContext(), getString(R.string.im_plugin_street_image_send_frequently));
            return;
        }
        IIMMessageModule iIMMessageModule = this.f8970y;
        if (iIMMessageModule != null && (iMBusinessParam = this.f8936I) != null && (iMSession = this.f8931D) != null) {
            iIMMessageModule.sendStreetViewMessage(i, iMBusinessParam, iMSession);
        }
    }

    public void sendLocationMessage(IMSendAddressEvent iMSendAddressEvent, boolean z) {
        IMAddress iMAddress = iMSendAddressEvent.address;
        if (iMAddress == null) {
            IMLog.m6630d("[sendLocationMessage] address is null");
            return;
        }
        IIMMessageModule iIMMessageModule = this.f8970y;
        if (iIMMessageModule != null) {
            m6019b(iIMMessageModule.sendLocationMessage(buildFromAddress(iMAddress), IMApiConst.MsgTypeSendLocation, this.f8936I, this.f8931D));
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void receiveBackgroundSendMsg(IMBackgroundSendMessage iMBackgroundSendMessage) {
        if (iMBackgroundSendMessage != null && iMBackgroundSendMessage.imMessage != null && iMBackgroundSendMessage.imMessage.getSid() == this.f8931D.getSessionId()) {
            m6019b(iMBackgroundSendMessage.imMessage);
        }
    }

    /* renamed from: com.didi.beatles.im.activity.IMMessageActivity$HeadsetPlugReceiver */
    private static class HeadsetPlugReceiver extends BroadcastReceiver {
        private HeadsetPlugReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (IMMessageActivity.f8917c) {
                String tag = IMField.getTag(IMMessageActivity.f8916b);
                IMLog.m6631d(tag, "onReceive() called with: context = [" + context + "], intent = [" + intent + Const.jaRight);
            }
            IMBtsAudioHelper.stopPlaying();
        }
    }

    /* renamed from: b */
    private void m6016b() {
        try {
            this.f8950W = new HeadsetPlugReceiver();
            try {
                registerReceiver(this.f8950W, new IntentFilter("android.intent.action.HEADSET_PLUG"));
            } catch (Exception e) {
                Log.d("Context", "registerReceiver", e);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: c */
    private void m6024c() {
        HeadsetPlugReceiver headsetPlugReceiver = this.f8950W;
        if (headsetPlugReceiver != null) {
            try {
                unregisterReceiver(headsetPlugReceiver);
            } catch (Exception e) {
                Log.d("Context", "unregisterReceiver", e);
            }
            this.f8950W = null;
        }
    }

    public static void startActivity(Context context, IMSession iMSession) {
        Intent intent = new Intent(context, IMMessageActivity.class);
        intent.putExtra("mSession", iMSession);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onActivityCreate(Bundle bundle) {
        super.onActivityCreate(bundle);
        m6046m();
        if (parseIntent(getIntent())) {
            setContentView((int) R.layout.im_activity_message);
            EventBus.getDefault().register(this);
            IIMSessionModule sessionModel = IMManager.getInstance().getSessionModel();
            if (sessionModel != null) {
                IMStaticSessionModuleListener iMStaticSessionModuleListener = new IMStaticSessionModuleListener(this);
                this.f8939L = iMStaticSessionModuleListener;
                sessionModel.registerSessionCallback(iMStaticSessionModuleListener);
            }
            m6028d();
        }
    }

    /* renamed from: d */
    private void m6028d() {
        setVolumeControlStream(IMContextInfoHelper.getAudioConfig().getStreamType());
        if (m6050o()) {
            IMHostProxy.getInstance().registerPluginSendListener(this);
            m6034g();
            m5992a(0);
            m6047n();
            m6036h();
            m6032f();
            NotificationUtils.cancelNotification();
            m6030e();
            IIMGlobalModule iIMGlobalModule = this.f8928A;
            if (iIMGlobalModule != null) {
                iIMGlobalModule.loadGlobalConfig(false);
            }
        }
    }

    /* renamed from: e */
    private void m6030e() {
        if (this.f8931D.getExtendSessionInfo() != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(InternalLogsFeature.ENV_NAME, Integer.valueOf(this.f8940M));
            hashMap.put("uid", Long.valueOf(IMSession.getPeerId(this.f8931D.getUserIds()).longValue() & -281474976710657L));
            hashMap.put("app", getPackageName());
            hashMap.put("sou", Integer.valueOf(this.f8943P));
            hashMap.put("order_id", getOrderId());
            hashMap.put(ParamKeys.PARAM_ESTIMATE_ROUTE_LIST, getRouteId());
            hashMap.put("type", Integer.valueOf((this.f8931D.getPeerUid() >> 48) == 1 ? 1 : 2));
            hashMap.put("input", Integer.valueOf(this.f8931D.getExtendSessionInfo().input));
            OmegaUtil.trackIMEvent("ddim_xq_all_detail_ck", hashMap);
            if (this.f8931D.getType() == 4) {
                IMTraceUtil.addBusinessEvent("ddim_service_item_sw").add("product_id", Integer.valueOf(this.f8931D.getBusinessId())).add("no_appid", Long.valueOf(this.f8931D.getPeerUid())).add("send_uid", Long.valueOf(this.f8931D.getPeerUid())).add("from", Integer.valueOf(this.f8947T)).report();
            } else {
                IMTraceUtil.addBusinessEvent("ddim_message_dialog_sw").add("product_id", Integer.valueOf(this.f8931D.getBusinessId())).add("client_type", IMContextInfoHelper.getPackageName()).add("send_uid", Long.valueOf(this.f8931D.getPeerUid())).add("from", Integer.valueOf(this.f8947T)).add("order_id", IMParamUtil.getTraceOrderId(this.f8936I, this.f8931D)).report();
            }
        }
    }

    /* renamed from: f */
    private void m6032f() {
        IMMsgOmega.getInstance().init(IMSession.getSelfId(this.f8931D.getUserIds()).longValue() & -281474976710657L, this.f8940M);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0147, code lost:
        if (r8 != 3) goto L_0x0149;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean parseIntent(android.content.Intent r8) {
        /*
            r7 = this;
            java.lang.String r0 = "IMMessageActivity"
            r1 = 0
            java.lang.Class<com.didi.beatles.im.module.entity.IMBusinessParam> r2 = com.didi.beatles.p099im.module.entity.IMBusinessParam.class
            java.lang.ClassLoader r2 = r2.getClassLoader()     // Catch:{ Exception -> 0x015c }
            r8.setExtrasClassLoader(r2)     // Catch:{ Exception -> 0x015c }
            java.lang.String r2 = "business_param"
            android.os.Parcelable r2 = r8.getParcelableExtra(r2)     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMBusinessParam r2 = (com.didi.beatles.p099im.module.entity.IMBusinessParam) r2     // Catch:{ Exception -> 0x015c }
            r7.f8936I = r2     // Catch:{ Exception -> 0x015c }
            if (r2 == 0) goto L_0x0032
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x015c }
            r2.<init>()     // Catch:{ Exception -> 0x015c }
            java.lang.String r3 = "ParseIntent mIMBusinessParam:"
            r2.append(r3)     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMBusinessParam r3 = r7.f8936I     // Catch:{ Exception -> 0x015c }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x015c }
            r2.append(r3)     // Catch:{ Exception -> 0x015c }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.p099im.utils.IMLog.m6631d(r0, r2)     // Catch:{ Exception -> 0x015c }
        L_0x0032:
            com.didi.beatles.im.module.entity.IMBusinessParam r2 = r7.f8936I     // Catch:{ Exception -> 0x015c }
            if (r2 == 0) goto L_0x0153
            com.didi.beatles.im.module.entity.IMBusinessParam r2 = r7.f8936I     // Catch:{ Exception -> 0x015c }
            long r2 = r2.getSessionId()     // Catch:{ Exception -> 0x015c }
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x0044
            goto L_0x0153
        L_0x0044:
            com.didi.beatles.im.module.entity.IMBusinessParam r2 = r7.f8936I     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMSession r2 = com.didi.beatles.p099im.module.entity.IMSession.structureSession(r2)     // Catch:{ Exception -> 0x015c }
            r7.f8931D = r2     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.IIMSessionModule r2 = r7.f8969x     // Catch:{ Exception -> 0x015c }
            r3 = 1
            if (r2 == 0) goto L_0x00d4
            com.didi.beatles.im.module.IIMSessionModule r2 = r7.f8969x     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMBusinessParam r4 = r7.f8936I     // Catch:{ Exception -> 0x015c }
            long r4 = r4.getSessionId()     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMSession r2 = r2.getSessionFromLocal(r4)     // Catch:{ Exception -> 0x015c }
            if (r2 == 0) goto L_0x00d4
            com.didi.beatles.im.module.entity.IMSession r4 = r7.f8931D     // Catch:{ Exception -> 0x015c }
            boolean r5 = r2.getSessionEnable()     // Catch:{ Exception -> 0x015c }
            r4.setSessionEnable(r5)     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMSession r4 = r7.f8931D     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.api.entity.IMSessionExtendInfo r5 = r2.getExtendSessionInfo()     // Catch:{ Exception -> 0x015c }
            r4.setExtendSessionInfo(r5)     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMSession r4 = r7.f8931D     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.api.entity.IMSessionClientExtendInfo r5 = r2.getClientExtendSessionInfo()     // Catch:{ Exception -> 0x015c }
            r4.setClientExtendInfo(r5)     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMSession r4 = r7.f8931D     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.api.entity.IMSessionServiceExtendInfo r5 = r2.getServiceExtendSessionInfo()     // Catch:{ Exception -> 0x015c }
            r4.setServiceExtendInfo(r5)     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMSession r4 = r7.f8931D     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.api.entity.IMSessionRecentMessages r5 = r2.getRecentMessages()     // Catch:{ Exception -> 0x015c }
            r4.setRecentMessages((com.didi.beatles.p099im.api.entity.IMSessionRecentMessages) r5)     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMSession r4 = r7.f8931D     // Catch:{ Exception -> 0x015c }
            java.lang.String r5 = r2.getSessionName()     // Catch:{ Exception -> 0x015c }
            r4.setSessionName(r5)     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMSession r4 = r7.f8931D     // Catch:{ Exception -> 0x015c }
            int r5 = r2.getType()     // Catch:{ Exception -> 0x015c }
            r4.setType(r5)     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMSession r4 = r7.f8931D     // Catch:{ Exception -> 0x015c }
            java.lang.String r5 = r2.getDraft()     // Catch:{ Exception -> 0x015c }
            r4.setDraft(r5)     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMSession r4 = r7.f8931D     // Catch:{ Exception -> 0x015c }
            int r5 = r2.getBusinessId()     // Catch:{ Exception -> 0x015c }
            r4.setBusinessId(r5)     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.api.entity.IMSessionExtendInfo r4 = r2.getExtendSessionInfo()     // Catch:{ Exception -> 0x015c }
            if (r4 == 0) goto L_0x00d4
            com.didi.beatles.im.module.entity.IMSession r4 = r7.f8931D     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.api.entity.IMSessionExtendInfo r5 = r2.getExtendSessionInfo()     // Catch:{ Exception -> 0x015c }
            int r5 = r5.ack     // Catch:{ Exception -> 0x015c }
            if (r5 != r3) goto L_0x00c2
            r5 = 1
            goto L_0x00c3
        L_0x00c2:
            r5 = 0
        L_0x00c3:
            r4.supportMsgReadStatus = r5     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMSession r4 = r7.f8931D     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.api.entity.IMSessionExtendInfo r2 = r2.getExtendSessionInfo()     // Catch:{ Exception -> 0x015c }
            java.lang.String r2 = r2.lag_ty     // Catch:{ Exception -> 0x015c }
            if (r2 == 0) goto L_0x00d1
            r2 = 1
            goto L_0x00d2
        L_0x00d1:
            r2 = 0
        L_0x00d2:
            r4.supportTranslate = r2     // Catch:{ Exception -> 0x015c }
        L_0x00d4:
            com.didi.beatles.im.module.entity.IMSession r2 = r7.f8931D     // Catch:{ Exception -> 0x015c }
            int r2 = r2.getBusinessId()     // Catch:{ Exception -> 0x015c }
            r7.f8940M = r2     // Catch:{ Exception -> 0x015c }
            android.content.Context r2 = com.didi.beatles.p099im.IMContextInfoHelper.getContext()     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.access.IMEngine r2 = com.didi.beatles.p099im.access.IMEngine.getInstance(r2)     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMSession r4 = r7.f8931D     // Catch:{ Exception -> 0x015c }
            int r4 = r4.getType()     // Catch:{ Exception -> 0x015c }
            int r5 = r7.f8940M     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.access.utils.IMBusinessConfig r2 = r2.getCurrentBusinessConfig(r4, r5)     // Catch:{ Exception -> 0x015c }
            r7.f8967v = r2     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMSession r2 = r7.f8931D     // Catch:{ Exception -> 0x015c }
            long r4 = r2.getSessionId()     // Catch:{ Exception -> 0x015c }
            r7.f8930C = r4     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.access.style.custom.IMCustomContext r2 = new com.didi.beatles.im.access.style.custom.IMCustomContext     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMSession r4 = r7.f8931D     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMBusinessParam r5 = r7.f8936I     // Catch:{ Exception -> 0x015c }
            r2.<init>(r4, r5)     // Catch:{ Exception -> 0x015c }
            r7.f8932E = r2     // Catch:{ Exception -> 0x015c }
            java.lang.String r2 = "source"
            r4 = 8
            int r8 = r8.getIntExtra(r2, r4)     // Catch:{ Exception -> 0x015c }
            r7.f8943P = r8     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMSession r8 = r7.f8931D     // Catch:{ Exception -> 0x015c }
            int r8 = r8.getType()     // Catch:{ Exception -> 0x015c }
            r2 = 4
            if (r8 != r2) goto L_0x0122
            com.didi.beatles.im.module.entity.IMBusinessParam r8 = r7.f8936I     // Catch:{ Exception -> 0x015c }
            int r8 = r8.getBusinessId()     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.p099im.resource.IMResource.setBusinessId(r8)     // Catch:{ Exception -> 0x015c }
            goto L_0x0127
        L_0x0122:
            int r8 = r7.f8940M     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.p099im.resource.IMResource.setBusinessId(r8)     // Catch:{ Exception -> 0x015c }
        L_0x0127:
            int r8 = r7.f8943P     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMSession r4 = r7.f8931D     // Catch:{ Exception -> 0x015c }
            int r4 = r4.getType()     // Catch:{ Exception -> 0x015c }
            r5 = 3
            r6 = 2
            if (r4 != r2) goto L_0x0143
            if (r8 == r3) goto L_0x0150
            if (r8 == r6) goto L_0x014d
            if (r8 == r5) goto L_0x014b
            r2 = 9
            if (r8 == r2) goto L_0x014f
            r2 = 10
            if (r8 == r2) goto L_0x0149
            r2 = 5
            goto L_0x0150
        L_0x0143:
            if (r8 == r3) goto L_0x014f
            if (r8 == r6) goto L_0x014d
            if (r8 == r5) goto L_0x014b
        L_0x0149:
            r2 = 3
            goto L_0x0150
        L_0x014b:
            r2 = 0
            goto L_0x0150
        L_0x014d:
            r2 = 1
            goto L_0x0150
        L_0x014f:
            r2 = 2
        L_0x0150:
            r7.f8947T = r2     // Catch:{ Exception -> 0x015c }
            return r3
        L_0x0153:
            java.lang.String r8 = "inValid ImBusinessParam When Start IMMessageActivity"
            com.didi.beatles.p099im.utils.IMLog.m6631d(r0, r8)     // Catch:{ Exception -> 0x015c }
            r7.finish()     // Catch:{ Exception -> 0x015c }
            return r1
        L_0x015c:
            r7.finish()
            java.lang.String r8 = "IMMessageActivity Can't Parse Intent Exception"
            com.didi.beatles.p099im.utils.IMLog.m6631d(r0, r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.activity.IMMessageActivity.parseIntent(android.content.Intent):boolean");
    }

    /* renamed from: g */
    private void m6034g() {
        IMBusinessConfig iMBusinessConfig = this.f8967v;
        if (iMBusinessConfig != null && iMBusinessConfig.isShowEmoji() && IMInnerData.getInstance().getEmojiPrefix() == null) {
            this.f8967v.getIMEmojiList(this.f8931D.getExtendSessionInfo() != null ? this.f8931D.getExtendSessionInfo().qk_key : "", this.f8940M, new ConfigLoadListener.IMGetEmojiListCallback() {
                public void finishLoad(ArrayList<IMEmojiModule> arrayList) {
                    if (arrayList != null && arrayList.size() > 0) {
                        IMInnerData.getInstance().setEmojiPrefix(arrayList.get(0).host);
                    }
                }
            });
        }
    }

    /* renamed from: h */
    private void m6036h() {
        CommonTitleBar commonTitleBar = (CommonTitleBar) findViewById(R.id.im_title_bar);
        this.f8959f = commonTitleBar;
        if (commonTitleBar == null) {
            finish();
            return;
        }
        if (IMStyleManager.getCurBusinessStyle() == IMStyleManager.Style.GLOBAL_PSG) {
            this.f8959f.resetLayout(R.layout.im_common_title_bar_global_psg);
        } else {
            this.f8959f.initResource();
        }
        this.f8959f.setLeftBackListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMMessageActivity.this.m6058s();
                IMMessageActivity.this.finish();
            }
        });
        this.f8959f.setTitleConfig(this.f8967v);
        m6043l();
        m6038i();
    }

    /* renamed from: i */
    private void m6038i() {
        if (this.f8959f == null) {
            m6036h();
        }
        IMLog.m6631d(f8916b, "refreshTitleBar type = " + this.f8931D.getType() + "  num = " + this.f8931D.getGroupNum());
        String str = null;
        if (TextUtils.isEmpty(this.f8931D.getSessionName())) {
            m6054q();
        } else if (this.f8931D.getType() == 2) {
            CommonTitleBar commonTitleBar = this.f8959f;
            commonTitleBar.setTitle(this.f8931D.getSessionName() + "(" + this.f8931D.getGroupNum() + ")");
        } else {
            OmegaUtil.trackTitleNamePath((String) null, this.f8931D, 3);
            this.f8959f.setTitle(this.f8931D.getSessionName());
        }
        IMSessionExtendInfo extendSessionInfo = this.f8931D.getExtendSessionInfo();
        if (extendSessionInfo != null && !TextUtils.isEmpty(extendSessionInfo.titleExtendInfo)) {
            this.f8959f.setSubTitle(extendSessionInfo.titleExtendInfo);
        }
        if (this.f8931D.getExtendSessionInfo() != null) {
            str = this.f8931D.getExtendSessionInfo().slink;
        }
        if (this.f8931D.getType() == 2 || !TextUtils.isEmpty(str)) {
            this.f8959f.setRightImg(R.drawable.im_home_nav_my);
            if (this.f8959f.getRightTextView() != null) {
                this.f8959f.getRightTextView().setContentDescription(IMResource.getString(R.string.im_accessibility_personal));
            }
            if (this.f8931D.getType() == 4 || this.f8931D.getType() == 2) {
                this.f8959f.setRightClickListener(this.f8957ac);
            } else {
                this.f8959f.setRightClickListener(this.f8958ad);
            }
        } else {
            this.f8959f.hideRightImg();
            IMBusinessParam iMBusinessParam = this.f8936I;
            if (iMBusinessParam == null || (TextUtils.isEmpty(iMBusinessParam.getPhoneNum()) && !this.f8936I.getShowChatTitleRightIcon())) {
                m6042k();
            } else {
                m6040j();
            }
        }
    }

    /* renamed from: j */
    private void m6040j() {
        IMBusinessParam iMBusinessParam = this.f8936I;
        if (iMBusinessParam == null) {
            return;
        }
        if (!TextUtils.isEmpty(iMBusinessParam.getPhoneNum()) || this.f8936I.getShowChatTitleRightIcon()) {
            this.f8959f.setRightImg(IMResource.getDrawableID(R.drawable.im_titlebar_call_phone));
            this.f8959f.setRightClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    IMBusinessConfig d = IMMessageActivity.this.f8967v;
                    IMMessageActivity iMMessageActivity = IMMessageActivity.this;
                    d.onClickPhone(iMMessageActivity, iMMessageActivity.f8936I.getPhoneNum());
                    IMBusinessConfig d2 = IMMessageActivity.this.f8967v;
                    IMMessageActivity iMMessageActivity2 = IMMessageActivity.this;
                    d2.onChatTitleRightIconClick(iMMessageActivity2, iMMessageActivity2.f8959f.getRightImg());
                }
            });
            if (!this.f8953Z && !TextUtils.isEmpty(this.f8936I.getPhoneFuncGuide()) && !IMPreference.getInstance(this).isPhoneGuideShow(IMContextInfoHelper.getUid())) {
                this.f8953Z = true;
                new IMSimpleGuideView.Builder(this).isShowForkView(true).setGuideText(this.f8936I.getPhoneFuncGuide()).setTargetView(this.f8959f.getRightTextView()).setOutsideTouchable(true).setMaxWordNumSingleLine(16).setLayoutGravity(2).setGrivaty(3).setDismissListener(new PopupWindow.OnDismissListener() {
                    public void onDismiss() {
                        IMPreference.getInstance(IMMessageActivity.this).setPhoneGuideShow(IMContextInfoHelper.getUid());
                    }
                }).create().show();
            }
        }
    }

    /* renamed from: k */
    private void m6042k() {
        LinearLayout.LayoutParams layoutParams;
        IMSessionExtendInfo extendSessionInfo = this.f8931D.getExtendSessionInfo();
        if (extendSessionInfo != null && extendSessionInfo.sideMenu != null && !extendSessionInfo.sideMenu.isEmpty() && this.f8959f.getRightLayout() != null) {
            LinearLayout rightLayout = this.f8959f.getRightLayout();
            rightLayout.setVisibility(0);
            HashMap hashMap = new HashMap(2);
            for (int i = 0; i < rightLayout.getChildCount(); i++) {
                View childAt = rightLayout.getChildAt(i);
                if (childAt instanceof TextView) {
                    hashMap.put(String.valueOf(childAt.getTag()), (TextView) childAt);
                }
            }
            rightLayout.removeAllViews();
            for (int i2 = 0; i2 < extendSessionInfo.sideMenu.size(); i2++) {
                final IMSessionExtendInfo.SideMenu sideMenu = extendSessionInfo.sideMenu.get(i2);
                final TextView textView = (TextView) hashMap.get(sideMenu.type);
                if (textView == null) {
                    textView = new TextView(this);
                    textView.setTag(sideMenu.type);
                }
                if (!TextUtils.isEmpty(sideMenu.icon)) {
                    if ("phone".equals(sideMenu.icon)) {
                        textView.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_titlebar_call_phone));
                    }
                    layoutParams = new LinearLayout.LayoutParams(IMViewUtil.dp2px(this, 20.0f), IMViewUtil.dp2px(this, 20.0f));
                } else {
                    textView.setTextSize(14.0f);
                    textView.setTextColor(Color.parseColor("#1C3947"));
                    textView.setText(sideMenu.text);
                    layoutParams = new LinearLayout.LayoutParams(-2, -2);
                }
                if (i2 != 0) {
                    layoutParams.leftMargin = IMViewUtil.dp2px(this, 20.0f);
                }
                rightLayout.addView(textView, layoutParams);
                textView.setOnClickListener(new IMOnAntiShakeClickListener() {
                    public void onAntiShakeClick(View view) {
                        String str;
                        String str2;
                        String str3;
                        if (IMSessionExtendInfo.SideMenu.TYPE_COMPLAINT.equals(sideMenu.type)) {
                            IMTraceUtil.BusinessParam add = IMTraceUtil.addBusinessEvent("beat_p_imrpt_btn_ck").add("uid", Long.valueOf(IMContextInfoHelper.getUid()));
                            if (IMMessageActivity.this.f8931D.getExtendSessionInfo() == null) {
                                str2 = "";
                            } else {
                                str2 = IMMessageActivity.this.f8931D.getExtendSessionInfo().routeId;
                            }
                            IMTraceUtil.BusinessParam add2 = add.add(ParamKeys.PARAM_ESTIMATE_ROUTE_LIST, str2);
                            if (IMMessageActivity.this.f8931D.getExtendSessionInfo() == null) {
                                str3 = "";
                            } else {
                                str3 = IMMessageActivity.this.f8931D.getExtendSessionInfo().orderId;
                            }
                            add2.add("order_id", str3).add("rec_channel", "1").report();
                        }
                        int g = IMMessageActivity.this.f8940M;
                        if (IMMessageActivity.this.f8936I == null) {
                            str = "";
                        } else {
                            str = IMMessageActivity.this.f8936I.getPeerUid() + "";
                        }
                        IMHttpManager.getInstance().performCommonPost(new IMInvokePhoneRequest(g, str, IMMessageActivity.this.f8930C + "", sideMenu.type), new IMNetCallback<IMInvokePhoneResponse>() {
                            public void success(final IMInvokePhoneResponse iMInvokePhoneResponse) {
                                if (iMInvokePhoneResponse != null && iMInvokePhoneResponse.body != null) {
                                    UiThreadHandler.post(new Runnable() {
                                        public void run() {
                                            if (!IMTextUtil.isEmpty(iMInvokePhoneResponse.body.phone)) {
                                                IMMessageActivity.this.f8967v.onClickPhone(IMMessageActivity.this, iMInvokePhoneResponse.body.phone);
                                                if (IMMessageActivity.this.f8959f != null) {
                                                    IMMessageActivity.this.f8967v.onChatTitleRightIconClick(IMMessageActivity.this, IMMessageActivity.this.f8959f.getRightImg());
                                                }
                                            } else if (!IMTextUtil.isEmpty(iMInvokePhoneResponse.body.link)) {
                                                IMCommonUtil.startUriActivity(IMMessageActivity.this, iMInvokePhoneResponse.body.link);
                                            } else if (!IMTextUtil.isEmpty(iMInvokePhoneResponse.body.text)) {
                                                IMMessageActivity.this.m5994a((int) R.drawable.im_toast_warm, iMInvokePhoneResponse.body.text);
                                            } else {
                                                C39261.this.failure((IOException) null);
                                            }
                                        }
                                    });
                                }
                            }

                            public void failure(IOException iOException) {
                                UiThreadHandler.post(new Runnable() {
                                    public void run() {
                                        IMMessageActivity.this.m5994a((int) R.drawable.im_toast_warm, IMResource.getString(R.string.bts_im_no_network));
                                    }
                                });
                            }
                        });
                    }
                });
                if (IMSessionExtendInfo.SideMenu.TYPE_COMPLAINT.equals(sideMenu.type)) {
                    UiThreadHandler.post(new Runnable() {
                        public void run() {
                            IMMessageActivity.this.m5995a(textView);
                        }
                    });
                    if (!this.f8955aa) {
                        this.f8955aa = true;
                        String str = "";
                        IMTraceUtil.BusinessParam add = IMTraceUtil.addBusinessEvent("beat_p_imrpt_btn_sw").add("uid", Long.valueOf(IMContextInfoHelper.getUid())).add(ParamKeys.PARAM_ESTIMATE_ROUTE_LIST, this.f8931D.getExtendSessionInfo() == null ? str : this.f8931D.getExtendSessionInfo().routeId);
                        if (this.f8931D.getExtendSessionInfo() != null) {
                            str = this.f8931D.getExtendSessionInfo().orderId;
                        }
                        add.add("order_id", str).add("rec_channel", "1").report();
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5995a(View view) {
        if (!this.f8953Z && !IMPreference.getInstance(this).isComplaintGuideShow(IMContextInfoHelper.getUid())) {
            this.f8953Z = true;
            new IMSimpleGuideView.Builder(this).isShowForkView(true).setGuideText(IMResource.getString(R.string.im_menu_complaint_guide)).setTargetView(view).setOutsideTouchable(true).setMaxWordNumSingleLine(16).setLayoutGravity(2).setGrivaty(3).setPopClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    String str = "";
                    IMTraceUtil.BusinessParam add = IMTraceUtil.addBusinessEvent("beat_p_imrpt_tips_ck").add("uid", Long.valueOf(IMContextInfoHelper.getUid())).add(ParamKeys.PARAM_ESTIMATE_ROUTE_LIST, IMMessageActivity.this.f8931D.getExtendSessionInfo() == null ? str : IMMessageActivity.this.f8931D.getExtendSessionInfo().routeId);
                    if (IMMessageActivity.this.f8931D.getExtendSessionInfo() != null) {
                        str = IMMessageActivity.this.f8931D.getExtendSessionInfo().orderId;
                    }
                    add.add("order_id", str).report();
                }
            }).setDismissListener(new PopupWindow.OnDismissListener() {
                public void onDismiss() {
                    IMPreference.getInstance(IMMessageActivity.this).setComplaintGuideShow(IMContextInfoHelper.getUid());
                }
            }).create().show();
            String str = "";
            IMTraceUtil.BusinessParam add = IMTraceUtil.addBusinessEvent("beat_p_imrpt_tips_sw").add("uid", Long.valueOf(IMContextInfoHelper.getUid())).add(ParamKeys.PARAM_ESTIMATE_ROUTE_LIST, this.f8931D.getExtendSessionInfo() == null ? str : this.f8931D.getExtendSessionInfo().routeId);
            if (this.f8931D.getExtendSessionInfo() != null) {
                str = this.f8931D.getExtendSessionInfo().orderId;
            }
            add.add("order_id", str).report();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m6043l() {
        if (this.f8931D.getExtendSessionInfo() != null) {
            final List<IMExtendBtnModule> list = this.f8931D.getExtendSessionInfo().more;
            if (list == null || list.size() == 0) {
                this.f8959f.setRightExtendIvVisible(8);
                return;
            }
            this.f8959f.setRightExtendIvVisible(0);
            this.f8959f.setRightExtendIv(R.drawable.im_extend_btn, new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (IMMessageActivity.this.f8934G == null) {
                        IMMessageActivity iMMessageActivity = IMMessageActivity.this;
                        IMExtendBtnPopup unused = iMMessageActivity.f8934G = new IMExtendBtnPopup(iMMessageActivity, list);
                    }
                    if (IMMessageActivity.this.f8934G.isShowing()) {
                        IMMessageActivity.this.f8934G.dismiss();
                        return;
                    }
                    IMMessageActivity.this.f8934G.show(IMMessageActivity.this.f8959f.getRightExtendView());
                    IMMsgOmega.getInstance().trackMoreBtn("");
                }
            });
            return;
        }
        this.f8959f.setRightExtendIvVisible(8);
    }

    /* renamed from: m */
    private void m6046m() {
        this.f8969x = IMManager.getInstance().getSessionModel();
        this.f8970y = IMManager.getInstance().getMessageModel();
        this.f8971z = IMManager.getInstance().getUserModel();
        this.f8928A = IMManager.getInstance().getGlobalModel();
    }

    /* renamed from: n */
    private void m6047n() {
        this.mController = IMLifecycleHandler.attach(this);
        m6011a(this.f8931D.getUserIds());
        IMBtsAudioHelper.initSensorModle(new IMBtsAudioPlayer.onVoiceChannelChangeListener() {
            public void onVoiceChannelChanged(final int i) {
                IMMessageActivity.this.mController.post(new Runnable() {
                    public void run() {
                        int i = i;
                        if (i == 0) {
                            IMMessageActivity.this.m5993a((int) R.string.bts_im_change_voice_spaker, IMResource.getDrawableID(R.drawable.bts_im_voice_spaker));
                        } else if (i == 1) {
                            IMMessageActivity.this.m5993a((int) R.string.bts_im_change_voice_call, IMResource.getDrawableID(R.drawable.bts_im_voice_call));
                        } else {
                            IMMessageActivity.this.f8956ab.sendEmptyMessage(7);
                        }
                    }
                });
            }
        });
    }

    /* renamed from: a */
    private void m6011a(List<Long> list) {
        if (this.f8931D.getType() == 2) {
            IIMUserModule iIMUserModule = this.f8971z;
            if (iIMUserModule != null) {
                iIMUserModule.getUserInfo(this.f8930C, (IMGroupUserInfoCallback) new IMGroupUserInfoCallback() {
                    public void onUserInfoLoaded(List<IMUser> list) {
                        if (list == null || list.isEmpty()) {
                            IMMessageActivity.this.m6054q();
                            return;
                        }
                        HashMap hashMap = new HashMap();
                        for (IMUser next : list) {
                            hashMap.put(Long.valueOf(next.getUid()), next);
                        }
                        IMMessageActivity.this.f8965t.setUsers(hashMap);
                        IMMessageActivity.this.f8965t.notifyDataSetChanged();
                    }
                }, false);
            }
        } else if (list != null && list.size() == 2) {
            long longValue = list.get(0).longValue();
            long longValue2 = list.get(1).longValue();
            IIMUserModule iIMUserModule2 = this.f8971z;
            if (iIMUserModule2 != null) {
                iIMUserModule2.getUserInfo(new long[]{longValue, longValue2}, (IMUserInfoCallback) this, false);
            }
        }
    }

    /* renamed from: o */
    private boolean m6050o() {
        this.f8961p = (FrameLayout) findViewById(R.id.bts_im_layout_root);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.im_conversation_recyclerview);
        this.f8962q = recyclerView;
        if (recyclerView == null) {
            finish();
            return false;
        }
        this.f8963r = (IMEggsLayout) findViewById(R.id.im_eggs_layout);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.bts_im_layout);
        linearLayout.setBackgroundColor(IMResource.getColor(R.color.im_nomix_activity_bg_color));
        this.f8962q.setBackgroundColor(IMResource.getColor(R.color.im_nomix_activity_bg_color));
        linearLayout.addOnLayoutChangeListener(this.mLayoutChangeListener);
        MessageAdapter messageAdapter = new MessageAdapter(this, this, 20, this.f8940M, this.f8931D, this.f8932E);
        this.f8965t = messageAdapter;
        messageAdapter.isShowPeerAvatar(this.f8967v.isShowPeerAvatar());
        this.f8965t.setSessionInfo(this.f8931D.supportMsgReadStatus, this.f8931D.supportTranslate);
        this.f8965t.updateRenderCardEnv(this.f8930C, IMParamUtil.getTraceOrderId(this.f8936I, this.f8931D), IMParamUtil.getTraceExtra(this.f8936I, this.f8943P));
        this.f8962q.setLayoutManager(new LinearLayoutManager(this));
        this.f8962q.setOnTouchListener(this.f8954a);
        this.f8962q.setAdapter(this.f8965t);
        this.f8962q.setItemAnimator((RecyclerView.ItemAnimator) null);
        this.f8962q.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                IMMessageActivity.this.f8965t.hidePopup();
                boolean unused = IMMessageActivity.this.f8941N = true;
                if (i == 0) {
                    IMMessageActivity.this.f8965t.loadAudio(((LinearLayoutManager) IMMessageActivity.this.f8962q.getLayoutManager()).findFirstVisibleItemPosition(), ((LinearLayoutManager) IMMessageActivity.this.f8962q.getLayoutManager()).findLastVisibleItemPosition());
                    if (IMMessageActivity.this.f8965t.canLoadHistory() && ((LinearLayoutManager) IMMessageActivity.this.f8962q.getLayoutManager()).findFirstVisibleItemPosition() == 0) {
                        Long listMinPosition = IMMessageActivity.this.f8965t.getListMinPosition();
                        IMMessageActivity iMMessageActivity = IMMessageActivity.this;
                        iMMessageActivity.m6007a(Long.valueOf(iMMessageActivity.f8930C), listMinPosition, false);
                    }
                }
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                if (IMMessageActivity.this.f8941N && IMMessageActivity.this.f8960g != null) {
                    IMMessageActivity.this.f8960g.shrinkBottomBarByRecycle();
                    boolean unused = IMMessageActivity.this.f8941N = false;
                }
                try {
                    int findLastVisibleItemPosition = ((LinearLayoutManager) IMMessageActivity.this.f8962q.getLayoutManager()).findLastVisibleItemPosition();
                    for (int findFirstVisibleItemPosition = ((LinearLayoutManager) IMMessageActivity.this.f8962q.getLayoutManager()).findFirstVisibleItemPosition(); findFirstVisibleItemPosition <= findLastVisibleItemPosition; findFirstVisibleItemPosition++) {
                        IMLog.m6631d(IMMessageActivity.f8916b, "mRecyclerView onScrolled() i:" + findFirstVisibleItemPosition);
                        if (!(IMMessageActivity.this.f8946S == null || IMMessageActivity.this.f8965t == null)) {
                            IMMessage item = IMMessageActivity.this.f8965t.getItem(findFirstVisibleItemPosition);
                            if (item.getType() != 107) {
                                IMMessageActivity.this.f8946S.add(item);
                            }
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("mRecyclerView onScrolled() omegaUpSet size=");
                        sb.append(IMMessageActivity.this.f8946S == null ? 0 : IMMessageActivity.this.f8946S.size());
                        IMLog.m6631d(IMMessageActivity.f8916b, sb.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    IMLog.m6631d(IMMessageActivity.f8916b, "mRecyclerView onScrolled() fail:" + e.getMessage());
                }
            }
        });
        this.f8942O = (IMRecommendEmojiView) findViewById(R.id.im_conversation_recommond_view);
        this.f8933F = findViewById(R.id.im_content_view);
        this.f8944Q = (ImageView) findViewById(R.id.im_no_msg_iv);
        this.f8945R = (TextView) findViewById(R.id.im_no_msg_tv);
        IMSession iMSession = this.f8931D;
        if (iMSession == null || iMSession.getType() != 4) {
            IMViewUtil.hide((View) this.f8944Q);
            IMViewUtil.hide((View) this.f8945R);
            this.f8962q.setVisibility(0);
            this.f8963r.setVisibility(0);
            IMSession iMSession2 = this.f8931D;
            int type = iMSession2 != null ? iMSession2.getType() : 0;
            IMLog.m6631d("IMview", "bg gone mSession = " + type);
        } else {
            IMViewUtil.show((View) this.f8944Q);
            IMViewUtil.show((View) this.f8945R);
            this.f8962q.setVisibility(8);
            this.f8963r.setVisibility(8);
            this.f8944Q.setImageResource(IMResource.getDrawableID(R.drawable.im_nomix_no_history_msg));
            this.f8945R.setText(IMResource.getString(R.string.im_nomix_no_history_msg_text));
            IMLog.m6631d("IMview", "has set bg");
        }
        IMTopOperationView iMTopOperationView = (IMTopOperationView) findViewById(R.id.im_top_operation_view);
        this.f8964s = iMTopOperationView;
        iMTopOperationView.init(this.f8931D, this.f8932E);
        this.f8935H = findViewById(R.id.im_detailes_loading_view);
        IMSession iMSession3 = this.f8931D;
        if (!(iMSession3 == null || iMSession3.getType() == 4)) {
            try {
                int singleChatBackgroundRes = IMCustomResHelper.get(this.f8967v).getSingleChatBackgroundRes();
                if (singleChatBackgroundRes > 0) {
                    this.f8961p.setBackgroundResource(singleChatBackgroundRes);
                }
            } catch (Exception e) {
                IMLog.m6632e(f8916b, e);
            }
        }
        return true;
    }

    public String getOrderId() {
        String str;
        IMSessionExtendInfo extendSessionInfo = this.f8931D.getExtendSessionInfo();
        if (extendSessionInfo == null) {
            str = null;
        } else {
            str = extendSessionInfo.orderId;
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (this.f8936I == null) {
            return "";
        }
        return this.f8936I.getOrderId() + "";
    }

    public String getRouteId() {
        String str;
        IMSessionExtendInfo extendSessionInfo = this.f8931D.getExtendSessionInfo();
        if (extendSessionInfo == null) {
            str = null;
        } else {
            str = extendSessionInfo.routeId;
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (this.f8936I == null) {
            return "";
        }
        return this.f8936I.getRouteId() + "";
    }

    public int getSourceId() {
        IMBusinessParam iMBusinessParam = this.f8936I;
        if (iMBusinessParam != null) {
            return iMBusinessParam.getSourceId();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        IMDialog iMDialog = this.f8968w;
        if (iMDialog != null) {
            iMDialog.dismiss(this.mController);
        }
        if (parseIntent(intent)) {
            m6028d();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5993a(int i, int i2) {
        PopupWindow popupWindow = this.f8949V;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.f8949V.dismiss();
            this.f8949V = null;
        }
        View findViewById = findViewById(R.id.bts_im_layout);
        if (findViewById != null && findViewById.getWindowToken() != null && !isFinishing()) {
            View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.bts_im_change_voice_mode_toast, (ViewGroup) null);
            this.f8949V = new PopupWindow(inflate, -2, -2);
            ((TextView) inflate.findViewById(R.id.toast_message)).setText(getString(i));
            ((ImageView) inflate.findViewById(R.id.toast_img)).setImageResource(i2);
            this.f8949V.setFocusable(false);
            if (IMRTLUtils.isRTLLayout()) {
                this.f8949V.setAnimationStyle(R.style.btsVoiceChangeStyleRTL);
                this.f8949V.showAtLocation(findViewById, 51, 0, IMViewUtil.dp2px(this, 77.0f));
            } else {
                this.f8949V.setAnimationStyle(R.style.btsVoiceChangeStyle);
                this.f8949V.showAtLocation(findViewById, 53, 0, IMViewUtil.dp2px(this, 77.0f));
            }
            this.f8956ab.sendEmptyMessageDelayed(7, 2000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6004a(IMMessage iMMessage) {
        this.f8965t.updateItemState(iMMessage);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5994a(int i, String str) {
        Toast makeText = IMTipsToast.makeText(IMContextInfoHelper.getContext(), (CharSequence) str, 0);
        SystemUtils.showToast(makeText);
        IMTipsToast.setIcon(makeText, i);
        IMTipsToast.setText(makeText, str);
    }

    /* renamed from: a */
    private void m6010a(String str, int i, int i2, Object obj) {
        if (this.f8970y != null && this.f8936I != null) {
            m6052p();
            IMBusinessParam iMBusinessParam = this.f8936I;
            iMBusinessParam.setIsQuick(i2 == 2 ? 1 : 0);
            m6019b(this.f8970y.sendTextMessage(str, i, iMBusinessParam, this.f8931D, obj, 0, (IMSendMessageCallback) null));
        }
    }

    public void sendVoiceMessage(String str, long j) {
        String audioFilePath = IMFileHelper.getAudioFilePath(str);
        int min = (int) (Math.min(j, (long) IMChatHelper.AUDIO_RECORD_MAX_DURATION) / 1000);
        if (this.f8970y != null) {
            m6052p();
            m6019b(this.f8970y.sendAudioMessage(audioFilePath, min, this.f8936I, this.f8931D, (IMSendMessageCallback) null));
        }
    }

    /* renamed from: p */
    private void m6052p() {
        OmegaUtil.trackSendMsgOmega(this.f8940M, this.f8930C, 2);
    }

    /* access modifiers changed from: protected */
    public void initStatusBar() {
        if (IMStyleManager.getCurBusinessStyle() == IMStyleManager.Style.GLOBAL_PSG) {
            StatusBarLightingCompat.setStatusBarBgLightning(this, true, IMResource.getColor(R.color.im_nomix_activity_bg_color));
        } else {
            super.initStatusBar();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        m6016b();
        IMPushEngine.holdMessageSessionId = this.f8930C;
        if (this.f8937J == null) {
            this.f8937J = new IMMessageCallBackImp() {
                public void onSendStatusChanged(IMMessage iMMessage, int i, IMSendMessageResponse iMSendMessageResponse) {
                    if (!(iMSendMessageResponse == null || !iMSendMessageResponse.isSuccess() || iMSendMessageResponse.body == null || iMSendMessageResponse.body.recom == null || IMMessageActivity.this.f8960g == null)) {
                        IMMessageActivity.this.f8960g.setRecommendInfo(iMSendMessageResponse.body.recom);
                        IMLog.m6631d("IMBottombar", "结构化消息发送成功，recom = " + iMSendMessageResponse.body.recom);
                    }
                    IMMessageActivity.this.m6003a((IMBaseResponse) iMSendMessageResponse);
                    IMMessageActivity.this.m6004a(iMMessage);
                    if (IMMessageActivity.this.f8946S != null) {
                        IMMessageActivity.this.f8946S.add(iMMessage);
                    }
                }

                public void onReceive(List<IMMessage> list) {
                    UiThreadHandler.post(new Runnable() {
                        public void run() {
                            IMMessageActivity.this.m6007a(Long.valueOf(IMMessageActivity.this.f8930C), IMMessageActivity.this.f8965t.getListMaxPosition(), true);
                        }
                    });
                }

                public void onHistoryMessageLoad(List<IMMessage> list, boolean z) {
                    IMMessageActivity.this.f8956ab.sendEmptyMessage(2);
                    if (IMTextUtil.isEmpty((Collection<?>) list) || list.size() == 0) {
                        IMMessageActivity.this.f8965t.loadHistoryList((List<IMMessage>) null, z);
                        return;
                    }
                    if (IMMessageActivity.this.f8944Q.isShown()) {
                        IMLog.m6631d("IMview", "hide nomsg show review");
                        IMMessageActivity.this.f8944Q.setVisibility(8);
                        IMMessageActivity.this.f8945R.setVisibility(8);
                        IMMessageActivity.this.f8962q.setVisibility(0);
                        IMMessageActivity.this.f8963r.setVisibility(0);
                    }
                    int findLastVisibleItemPosition = ((LinearLayoutManager) IMMessageActivity.this.f8962q.getLayoutManager()).findLastVisibleItemPosition();
                    IMMessageList<IMMessage> loadHistoryList = IMMessageActivity.this.f8965t.loadHistoryList(list, z);
                    if (z || findLastVisibleItemPosition == -1) {
                        IMMessageActivity.this.m6056r();
                    } else {
                        IMMessageActivity.this.f8962q.scrollToPosition((loadHistoryList.size() + findLastVisibleItemPosition) - 2);
                    }
                    if (!z && IMMessageActivity.this.f8931D.supportMsgReadStatus) {
                        ArrayList arrayList = new ArrayList();
                        for (IMMessage next : list) {
                            if (!next.isRead() && next.getSenderUid() == IMContextInfoHelper.getUid()) {
                                arrayList.add(Long.valueOf(next.getMid()));
                            }
                        }
                        IMLog.m6635i("IMMessageReadStatusManager", "request msgs read status,size is " + arrayList.size());
                        if (IMMessageActivity.this.f8970y != null) {
                            IMMessageActivity.this.f8970y.getMessageReadStatus(IMMessageActivity.this.f8930C, arrayList);
                        }
                    }
                }

                public void onReadStatusChange(List<IMMessage> list, boolean z) {
                    if (!z) {
                        IMMessageReadStatusManager.getInstance().removeHasReportMsg(list);
                    } else if (IMMessageActivity.this.f8965t != null) {
                        IMLog.m6635i("IMMessageReadStatusManager", "update msgs has send");
                        IMMessageActivity.this.f8965t.changeMsgReadStatus(list);
                    }
                }

                public void onReceive(String str) {
                    if (IMMessageActivity.this.f8960g != null) {
                        IMMessageActivity.this.f8960g.setRecommendInfo(str);
                    }
                }

                public long getSid() {
                    return IMMessageActivity.this.f8930C;
                }
            };
        }
        IIMMessageModule iIMMessageModule = this.f8970y;
        if (iIMMessageModule != null) {
            iIMMessageModule.registerMessageCallback(this.f8937J, this.f8930C);
            this.f8970y.pullSingleMessage(this.f8940M, 0, 2);
        }
        if (this.f8938K == null) {
            this.f8938K = new IMStaticSessionCallBack(this);
        }
        if (!(this.f8969x == null || this.f8936I == null)) {
            String simpleName = IMConversationBottomBar.class.getSimpleName();
            IMLog.m6631d(simpleName, "get mSession status " + this.f8936I.toString());
            this.f8969x.syncSessionStatus(-1, -1, this.f8936I, this.f8931D, this.f8938K);
        }
        boolean z = false;
        if (!this.f8951X) {
            Long valueOf = Long.valueOf(this.f8930C);
            Long listMaxPosition = this.f8965t.getListMaxPosition();
            if (this.f8965t.getListMaxPosition().longValue() != 0) {
                z = true;
            }
            m6007a(valueOf, listMaxPosition, z);
        } else {
            this.f8951X = false;
        }
        CURRENT_SID = this.f8930C;
        IMPollingUtils.startPollingService(this, 60, IMPollingService.class, IMPollingService.ACTION);
        this.f8952Y = true;
    }

    /* renamed from: com.didi.beatles.im.activity.IMMessageActivity$IMStaticSessionCallBack */
    private static class IMStaticSessionCallBack implements IMSessionCallback {
        private WeakReference<IMMessageActivity> mActivity;

        public void onSessionStatusUpdate(List<IMSession> list) {
        }

        public IMStaticSessionCallBack(IMMessageActivity iMMessageActivity) {
            this.mActivity = new WeakReference<>(iMMessageActivity);
        }

        public void onSessionOptionResult(List<IMSession> list, int i) {
            IMMessageActivity iMMessageActivity = (IMMessageActivity) this.mActivity.get();
            if (iMMessageActivity != null) {
                if (i == 111) {
                    if (iMMessageActivity.f8936I != null) {
                        iMMessageActivity.f8936I.clearSecret();
                    }
                    if (iMMessageActivity.f8969x != null) {
                        iMMessageActivity.f8969x.updateSessionEnableStatus(iMMessageActivity.f8930C, false, 0);
                    }
                    if (iMMessageActivity.f8931D != null) {
                        iMMessageActivity.f8931D.setSessionEnable(false);
                        if (iMMessageActivity.f8931D.getExtendSessionInfo() != null) {
                            iMMessageActivity.f8931D.getExtendSessionInfo().openActionIds = null;
                        }
                    }
                    if (iMMessageActivity.f8960g != null) {
                        iMMessageActivity.f8960g.onStatusChanged(iMMessageActivity.f8931D);
                    }
                } else if (!iMMessageActivity.f8935H.isShown() || i != -1) {
                    iMMessageActivity.f8935H.findViewById(R.id.im_detailes_loading_icon).setVisibility(8);
                    iMMessageActivity.f8935H.findViewById(R.id.im_detailes_loading_text).setVisibility(0);
                } else {
                    iMMessageActivity.f8935H.findViewById(R.id.im_detailes_loading_icon).setVisibility(8);
                    iMMessageActivity.f8935H.findViewById(R.id.im_detailes_loading_text).setVisibility(0);
                    IMLog.m6631d("IMBottombar", "隐藏 loading");
                }
            }
        }

        public void onSessionLoad(List<IMSession> list) {
            IMMessageActivity iMMessageActivity = (IMMessageActivity) this.mActivity.get();
            if (iMMessageActivity != null) {
                iMMessageActivity.m6021b(list);
                iMMessageActivity.m6043l();
            }
        }
    }

    /* renamed from: com.didi.beatles.im.activity.IMMessageActivity$IMStaticSessionModuleListener */
    private static class IMStaticSessionModuleListener extends IMSessionCallbackAdapter {
        /* access modifiers changed from: private */
        public WeakReference<IMMessageActivity> mActivity;

        IMStaticSessionModuleListener(IMMessageActivity iMMessageActivity) {
            this.mActivity = new WeakReference<>(iMMessageActivity);
        }

        public void onSessionOptionResult(List<IMSession> list, int i) {
            IMMessageActivity iMMessageActivity;
            if (i == 3 && list != null && (iMMessageActivity = (IMMessageActivity) this.mActivity.get()) != null) {
                long h = iMMessageActivity.f8930C;
                for (IMSession next : list) {
                    if (next != null && next.getSessionId() == h) {
                        IMToastHelper.showLongInfo((Context) iMMessageActivity, iMMessageActivity.getResources().getString(R.string.im_delete_session_tips));
                        UiThreadHandler.postDelayed(new Runnable() {
                            public void run() {
                                IMMessageActivity iMMessageActivity = (IMMessageActivity) IMStaticSessionModuleListener.this.mActivity.get();
                                if (iMMessageActivity != null) {
                                    iMMessageActivity.finish();
                                }
                            }
                        }, 300);
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m6012a(Set<IMMessage> set) {
        if (set != null && set.size() != 0) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            int i = 0;
            for (IMMessage next : set) {
                sb2.append(next.getMessageExtendInfo().activity_id);
                sb.append(next.getCloudUniqueMsgId());
                if (i != set.size() - 1) {
                    sb2.append(RConfigConstants.KEYWORD_COLOR_SIGN);
                    sb.append(RConfigConstants.KEYWORD_COLOR_SIGN);
                }
                i++;
                IMLog.m6631d(f8916b, "[reportHelperChat] uniq_msg_id = " + next.getCloudUniqueMsgId() + ",msg_id = " + next.getMsgUniqueId());
            }
            IMTraceUtil.addBusinessEvent("ddim_service_item_content_sw").add("product_id", Integer.valueOf(this.f8931D.getBusinessId())).add("no_appid", Long.valueOf(this.f8931D.getPeerUid())).add("send_uid", Long.valueOf(this.f8931D.getPeerUid())).add("activity_id", sb2.toString()).add("uniq_msg_id_list", sb.toString()).report();
        }
    }

    /* renamed from: b */
    private void m6022b(Set<IMMessage> set) {
        if (set != null && set.size() != 0) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (IMMessage next : set) {
                sb.append(next.getCloudUniqueMsgId());
                if (i != set.size() - 1) {
                    sb.append(RConfigConstants.KEYWORD_COLOR_SIGN);
                }
                i++;
                IMLog.m6631d(f8916b, "[reportChat] uniq_msg_id = " + next.getCloudUniqueMsgId() + ",msg_id = " + next.getMsgUniqueId());
            }
            IMTraceUtil.addBusinessEvent("pub_ddim_chat_item_content_sw").add("product_id", Integer.valueOf(this.f8931D.getBusinessId())).add("peer_uid", Long.valueOf(this.f8931D.getPeerUid())).add("uniq_msg_id_list", sb.toString()).report();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (this.f8931D.supportMsgReadStatus) {
            IMMessageReadStatusManager.getInstance().reportByHand();
        }
        IMMessageReadStatusManager.getInstance().destory();
        IIMSessionModule iIMSessionModule = this.f8969x;
        if (iIMSessionModule != null) {
            iIMSessionModule.clearUnreadCount(this.f8930C);
            this.f8969x.clearHolders();
        }
        IMManager.getInstance().clearIMRedDot();
        IMStageFeedBackListerManager.INSTANCE.notifyListeners(this, IMStageFeedBack.IMStage.IM_CLEAR_UN_READ_COUNT_AFTER, (IMStageFeedBack.OutFeedBackData) null);
        IMPushEngine.holdMessageSessionId = 0;
        IMBaseBottomBar iMBaseBottomBar = this.f8960g;
        if (iMBaseBottomBar != null) {
            iMBaseBottomBar.onPause();
        }
        try {
            m6059t();
        } catch (Exception e) {
            e.printStackTrace();
        }
        m6024c();
        IIMMessageModule iIMMessageModule = this.f8970y;
        if (iIMMessageModule != null) {
            iIMMessageModule.unregisterMessageCallback(this.f8930C);
            this.f8970y.clearHolders();
        }
        if (this.f8937J != null) {
            this.f8937J = null;
        }
        IIMUserModule iIMUserModule = this.f8971z;
        if (iIMUserModule != null) {
            iIMUserModule.clearHolders();
        }
        if (this.f8938K != null) {
            this.f8938K = null;
        }
        IMBtsAudioHelper.stopPlaying();
        IMBtsAudioHelper.cancelRecording();
        IMTipsToast.cancelAll();
        CURRENT_SID = -1;
        IMPollingUtils.stopPollingService(this, IMPollingService.class, IMPollingService.ACTION);
    }

    /* access modifiers changed from: protected */
    public void onActivityDestroy() {
        IMOrderStatusChangeBody iMOrderStatusChangeBody;
        super.onActivityDestroy();
        for (int i = 0; i < this.f8948U.size(); i++) {
            IMMessage valueAt = this.f8948U.valueAt(i);
            IMTraceUtil.addBusinessEvent("ddim_message_sys_item_sw").add("product_id", Integer.valueOf(this.f8931D.getBusinessId())).add("client_type", IMContextInfoHelper.getPackageName()).add("msg_type", Integer.valueOf(valueAt.getType())).add("msg_link", Integer.valueOf(valueAt.linkType > 0 ? 1 : 0)).add("activity_id", Long.valueOf(valueAt.getActivityId())).report();
            if (valueAt.getType() == 393219 && (iMOrderStatusChangeBody = (IMOrderStatusChangeBody) IMJsonUtil.objectFromJson(valueAt.getContent(), IMOrderStatusChangeBody.class)) != null && iMOrderStatusChangeBody.alignStyle == 2 && iMOrderStatusChangeBody.btnGroup != null) {
                IMTraceUtil.addBusinessEvent("beat_p_imrpt_succard_sw").add("uid", Long.valueOf(IMContextInfoHelper.getUid())).add("anal_txt", iMOrderStatusChangeBody.extend != null ? iMOrderStatusChangeBody.extend.analTxt : "").report();
            }
        }
        IMSession iMSession = this.f8931D;
        if (iMSession == null || iMSession.getType() != 4) {
            m6022b(this.f8946S);
        } else {
            m6012a(this.f8946S);
        }
        Set<IMMessage> set = this.f8946S;
        if (set != null) {
            set.clear();
            this.f8946S = null;
        }
        IMHostProxy.getInstance().unregisterPluginSendListener(this);
        IIMSessionModule sessionModel = IMManager.getInstance().getSessionModel();
        if (sessionModel != null) {
            sessionModel.unregisterSessionCallback(this.f8939L);
        }
        if (this.f8956ab.hasMessages(7)) {
            this.f8956ab.removeMessages(7);
        }
        IMBaseBottomBar iMBaseBottomBar = this.f8960g;
        if (iMBaseBottomBar != null) {
            iMBaseBottomBar.onDestroy();
            this.f8960g = null;
        }
        EventBus.getDefault().unregister(this);
        IMBtsAudioHelper.releaseSensorModle();
        MessageAdapter messageAdapter = this.f8965t;
        if (messageAdapter != null) {
            messageAdapter.clearData();
        }
        RecyclerView recyclerView = this.f8962q;
        if (recyclerView != null) {
            recyclerView.clearOnScrollListeners();
        }
        IMMsgOmega.getInstance().destory();
        IMMessageOperatePopup.onDestory();
        IMExpoMtaManager.getInstance().clearExpoEvents();
    }

    public void onTextMessageSend(String str, int i, int i2) {
        if (i2 == 3) {
            sendStreetViewMessage(339);
        } else {
            m6010a(str, i, i2, (Object) null);
        }
    }

    public void sendTextMessage(String str, int i, Object obj) {
        if (this.f8964s != null && IMPreference.getInstance(getApplicationContext()).shouldShowTopGuide()) {
            IMPreference.getInstance(getApplicationContext()).hasShowTopViewGuide();
            this.f8964s.showGuideView(IMResource.getString(R.string.im_top_view_guide_text));
        }
        m6010a(str, i, -1, obj);
    }

    public void onEditFocus() {
        m6056r();
    }

    public void handleEvent() {
        IMBtsAudioHelper.stopPlaying();
    }

    public void showAddCustomWordDialog(String str, int i) {
        showAddCustomWordDialog(str, i, -1);
    }

    public void showAddCustomWordDialog(String str, int i, int i2) {
        m6066w();
        IMAddCommonWordDialog.show(this, this.f8940M, str, i, this.f8967v.getCommonWordType(), i2);
    }

    public List<IMActionItem> getSystemAction() {
        IMSession iMSession = this.f8931D;
        if (!(iMSession == null || iMSession.getExtendSessionInfo() == null)) {
            List<Integer> list = this.f8931D.getExtendSessionInfo().actionIds;
            List<Integer> list2 = this.f8931D.getExtendSessionInfo().openActionIds;
            IMBusinessConfig iMBusinessConfig = this.f8967v;
            List<IMActionItem> generateItems = IMActionFactory.generateItems(this, list, list2, iMBusinessConfig != null ? iMBusinessConfig.getPluginList() : null);
            IMActionTipManager.getInstance().onSystemActionsUpdated(this.f8940M, this.f8930C, this.f8931D.getPeerUid(), this.f8931D.getExtendSessionInfo().actionIds);
            if (generateItems == null || generateItems.isEmpty()) {
                return null;
            }
            return generateItems;
        }
        return null;
    }

    public List<IMActionItem> interceptMoreAction(List<IMActionItem> list) {
        if (list == null) {
            IMLog.m6630d("[interceptMoreAction] actionItems is null");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (IMActionItem next : list) {
            if (next.moreActionNetControlItem == null) {
                arrayList.add(next);
            } else if (m6014a(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private boolean m6014a(IMActionItem iMActionItem) {
        IMSession iMSession = this.f8931D;
        if (!(iMSession == null || iMSession.getExtendSessionInfo() == null || this.f8931D.getExtendSessionInfo().actionIds == null)) {
            if (iMActionItem != null && iMActionItem.moreActionNetControlItem != null && iMActionItem.moreActionNetControlItem.isNetControl()) {
                return this.f8931D.getExtendSessionInfo().actionIds.contains(Integer.valueOf(iMActionItem.moreActionNetControlItem.getPluginId()));
            }
            IMLog.m6630d("enableMoreActionShow actionItem moreActionNetControlItem is null or isNetControl is false");
        }
        return false;
    }

    public IMActionInvokeReturn invokeAction(IMActionItem iMActionItem, IMActionInvokeEnv iMActionInvokeEnv) {
        if (iMActionItem == null) {
            return null;
        }
        if (this.f8952Y) {
            this.f8951X = true;
        }
        if (iMActionItem.item == null) {
            iMActionItem.invokeAction(this, this.f8931D, this.f8936I);
            this.f8960g.shrinkBottomBar();
            return null;
        }
        IMActionInvokeReturn invokeAction = iMActionItem.item.invokeAction(this, iMActionInvokeEnv);
        if (invokeAction == null || invokeAction.containView == null) {
            this.f8960g.shrinkBottomBar();
        }
        return invokeAction;
    }

    public List<IMBottomGuideConfig> getBottomGuideConfigList() {
        IIMGlobalModule iIMGlobalModule = this.f8928A;
        if (iIMGlobalModule != null) {
            return iIMGlobalModule.getBtmGuideConfigList(this.f8940M);
        }
        return null;
    }

    public List<IMSessionExtendInfo.BottomTabInfo> getBottomTabList() {
        IMSession iMSession;
        if (IMStyleManager.getCurBusinessStyle() == IMStyleManager.Style.GLOBAL_PSG || (iMSession = this.f8931D) == null || iMSession.getExtendSessionInfo() == null) {
            return null;
        }
        return this.f8931D.getExtendSessionInfo().bottomTabInfoList;
    }

    public IMActionInvokeReturn invokeTabAction(IMTabActionItem iMTabActionItem, IMActionInvokeEnv iMActionInvokeEnv) {
        if (iMTabActionItem == null) {
            return null;
        }
        if (this.f8952Y) {
            this.f8951X = true;
        }
        IMActionInvokeReturn invokeAction = iMTabActionItem.invokeAction(this, iMActionInvokeEnv);
        if (invokeAction == null || invokeAction.containView == null) {
            this.f8960g.shrinkBottomBar();
        }
        return invokeAction;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 188) {
            List<IMLocalMedia> obtainMultipleResult = IMPictureSelector.obtainMultipleResult(intent);
            IMLog.m6631d(f8916b, C4234I.m6591t("共选择图片->", Integer.valueOf(obtainMultipleResult.size())));
            for (IMLocalMedia path : obtainMultipleResult) {
                IMLog.m6631d(f8916b, C4234I.m6591t("选择图片 -> ", path.getPath()));
            }
            this.f8970y.sendImageMessage(obtainMultipleResult, this.f8936I, this.f8931D, new IMPreSendCallback() {
                public void insertSuccess(List<IMMessage> list) {
                    IMMessageActivity.this.push(list);
                }
            });
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onViewImageEvent(IMViewImageEvent iMViewImageEvent) {
        List<IMMessage> messagesWithType = this.f8965t.getMessagesWithType(196608);
        if (messagesWithType != null) {
            ArrayList arrayList = new ArrayList();
            int size = messagesWithType.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                IMMessage iMMessage = messagesWithType.get(i2);
                if (iMMessage.getMid() == iMViewImageEvent.message.getMid()) {
                    i = i2;
                }
                String content = iMMessage.getContent();
                String file_name = iMMessage.getFile_name();
                if (!TextUtils.isEmpty(content)) {
                    arrayList.add(content);
                } else if (!TextUtils.isEmpty(file_name)) {
                    arrayList.add(file_name);
                }
            }
            this.f8951X = true;
            String str = null;
            IMSession iMSession = this.f8931D;
            if (!(iMSession == null || iMSession.getExtendSessionInfo() == null || TextUtils.isEmpty(this.f8931D.getExtendSessionInfo().watermark))) {
                str = this.f8931D.getExtendSessionInfo().watermark;
            }
            IMPictureExternalPreviewActivity.startActivity(this, i, arrayList, str);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onViewStreetImageEvent(IMViewStreetImageEvent iMViewStreetImageEvent) {
        if (iMViewStreetImageEvent.body != null && iMViewStreetImageEvent.body.streetImage != null && !TextUtils.isEmpty(iMViewStreetImageEvent.body.streetImage.imageUrl)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(iMViewStreetImageEvent.body.streetImage.imageUrl);
            this.f8951X = true;
            String str = null;
            IMSession iMSession = this.f8931D;
            if (!(iMSession == null || iMSession.getExtendSessionInfo() == null || TextUtils.isEmpty(this.f8931D.getExtendSessionInfo().watermark))) {
                str = this.f8931D.getExtendSessionInfo().watermark;
            }
            IMPictureExternalPreviewActivity.startActivity(this, 0, arrayList, str);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void updateMsgReadStatus(IMMessageUpdateReadStatusEvent iMMessageUpdateReadStatusEvent) {
        List<IMMessage> list = iMMessageUpdateReadStatusEvent.list;
        if (this.f8970y != null && list != null && list.size() != 0) {
            int size = list.size();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < size; i++) {
                arrayList.add(Long.valueOf(list.get(i).getMid()));
            }
            this.f8970y.pushMessageReadStatus(this.f8930C, arrayList);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void updateMsgCollection(IMMessageColloectionUpdateEvent iMMessageColloectionUpdateEvent) {
        for (IMMessage next : iMMessageColloectionUpdateEvent.updateMessages) {
            if (next.getSid() == this.f8931D.getSessionId()) {
                this.f8965t.updateItemState(next);
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void handleExpiredPic(IMMessageHandleExpiredPicEvent iMMessageHandleExpiredPicEvent) {
        List<IMMessage> list = iMMessageHandleExpiredPicEvent.updateMessages;
        if (list != null) {
            for (IMMessage next : list) {
                if (next.getSid() == this.f8931D.getSessionId()) {
                    this.f8965t.updateItemState(next);
                }
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void receiveSysCardShow(IMMessageSysCardShowEvent iMMessageSysCardShowEvent) {
        IMMessage iMMessage = iMMessageSysCardShowEvent.message;
        if (iMMessage != null && this.f8931D.getType() != 4) {
            this.f8948U.append(iMMessage.getId(), iMMessage);
        }
    }

    public void sendEmoji(String str, String str2, String str3) {
        if (this.f8970y != null && this.f8936I != null) {
            m6052p();
            String str4 = str;
            String str5 = str2;
            String str6 = str3;
            m6019b(this.f8970y.sendEmojiMessage(str4, str5, IMInnerData.getInstance().getEmojiPrefix(), str6, this.f8936I, this.f8931D));
            IMTraceUtil.addBusinessEvent("wyc_ddim_emoji_ck").add("emoji_id", str).report();
        }
    }

    public void push(List<IMMessage> list) {
        MessageAdapter messageAdapter = this.f8965t;
        if (messageAdapter != null) {
            messageAdapter.hidePopup();
            this.f8965t.addItem(list);
        }
        m6056r();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m6019b(IMMessage iMMessage) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(iMMessage);
        this.f8965t.addItem(arrayList);
        if (this.f8965t.getItemCount() > 0) {
            this.f8962q.scrollToPosition(this.f8965t.getItemCount() - 1);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6007a(Long l, Long l2, boolean z) {
        IIMMessageModule iIMMessageModule = this.f8970y;
        if (iIMMessageModule != null) {
            iIMMessageModule.loadHistoryMessage(l.longValue(), l2.longValue(), 20, z);
        }
    }

    /* renamed from: c */
    private void m6025c(IMMessage iMMessage) {
        IMMessage iMMessage2;
        if (this.f8970y == null) {
            IMLog.m6632e(f8916b, "the messageModule is null while resend msg");
            return;
        }
        m6052p();
        iMMessage.setStatus(100);
        int type = iMMessage.getType();
        if (type == 65536) {
            iMMessage2 = this.f8970y.sendTextMessage(iMMessage, this.f8936I, this.f8931D, (IMSendMessageCallback) null);
        } else if (type == 65537) {
            iMMessage2 = this.f8970y.sendTextMessage(iMMessage, this.f8936I, this.f8931D, (IMSendMessageCallback) null);
        } else if (type == 131072) {
            iMMessage2 = this.f8970y.sendAudioMessage(iMMessage, this.f8936I, this.f8931D, (IMSendMessageCallback) null);
        } else if (type == 196608) {
            iMMessage2 = this.f8970y.sendImageMessage(iMMessage, this.f8936I, this.f8931D);
        } else if (type == 327680) {
            iMMessage2 = this.f8970y.sendTextMessage(iMMessage, this.f8936I, this.f8931D, (IMSendMessageCallback) null);
        } else if (type == 393223) {
            iMMessage2 = this.f8970y.sendTextMessage(iMMessage, this.f8936I, this.f8931D, (IMSendMessageCallback) null);
        } else if (type == 458752) {
            iMMessage2 = this.f8970y.sendTextMessage(iMMessage, this.f8936I, this.f8931D, (IMSendMessageCallback) null);
        } else if (type == 10486017) {
            iMMessage2 = this.f8970y.sendTextMessage(iMMessage, this.f8936I, this.f8931D, (IMSendMessageCallback) null);
        } else {
            return;
        }
        this.f8965t.updateItemState(iMMessage2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6003a(IMBaseResponse iMBaseResponse) {
        if (iMBaseResponse != null && this.f8970y != null && !iMBaseResponse.isSuccess()) {
            String str = iMBaseResponse.errmsg;
            int i = iMBaseResponse.errno;
            if (i == 200000010 || i == 200000011 || i == 200000012) {
                if (!TextUtils.isEmpty(str)) {
                    long uid = IMContextInfoHelper.getUid();
                    long randId = IMIdGenerator.getInstance().getRandId();
                    IMMessageDaoEntity iMMessageDaoEntity = new IMMessageDaoEntity();
                    iMMessageDaoEntity.setText_content(iMBaseResponse.errmsg);
                    iMMessageDaoEntity.setStatus(200);
                    iMMessageDaoEntity.setSession_id(this.f8930C);
                    iMMessageDaoEntity.setCreate_time(System.currentTimeMillis());
                    iMMessageDaoEntity.setType(IMApiConst.MsgTypeSystem);
                    IMMessage iMMessage = new IMMessage(iMMessageDaoEntity);
                    iMMessage.setSenderUid(uid);
                    iMMessage.setContent(iMBaseResponse.errmsg);
                    iMMessage.setUniqueId(this.f8930C, randId);
                    m6019b(iMMessage);
                    this.f8970y.insertMessage(iMMessage);
                }
            } else if (!TextUtils.isEmpty(str)) {
                m5994a((int) R.drawable.im_toast_warm, str);
            }
        }
    }

    public void onUserInfoLoaded(HashMap<Long, IMUser> hashMap, long[] jArr) {
        if (hashMap == null || hashMap.isEmpty()) {
            m6054q();
            return;
        }
        this.f8965t.setUsers(hashMap);
        this.f8965t.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m6054q() {
        IMSession iMSession = this.f8931D;
        if (iMSession == null || iMSession.getType() != 4) {
            OmegaUtil.trackTitleNamePath(getString(R.string.bts_user_default_name), this.f8931D, 4);
            this.f8959f.setTitle(IMResource.getString(R.string.bts_user_default_name));
            return;
        }
        this.f8959f.setTitle(IMResource.getString(R.string.im_details_activity_default_title));
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m6056r() {
        this.f8941N = false;
        if (this.f8962q != null && this.f8965t.getItemCount() > 0) {
            this.f8962q.scrollToPosition(this.f8965t.getItemCount() - 1);
        }
        this.f8956ab.postDelayed(new Runnable() {
            public void run() {
                boolean unused = IMMessageActivity.this.f8941N = false;
                if (IMMessageActivity.this.f8962q != null) {
                    IMMessageActivity.this.f8962q.scrollBy(0, 300);
                }
            }
        }, 100);
    }

    public void onBackPressed() {
        IMBaseBottomBar iMBaseBottomBar = this.f8960g;
        if (iMBaseBottomBar == null || !iMBaseBottomBar.onBackPressed()) {
            try {
                finish();
            } catch (Exception e) {
                IMLog.m6633e(e);
                IMTraceError.trackError("im_message_aty_back_fail", e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public void m6058s() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getApplicationWindowToken(), 2);
            }
        } catch (Exception e) {
            IMLog.m6632e(f8916b, "[closeSoftInput]", e);
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        MessageAdapter messageAdapter = this.f8965t;
        if (messageAdapter != null) {
            messageAdapter.hidePopup();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
    }

    public void onResendMessage(IMMessage iMMessage) {
        m6025c(iMMessage);
    }

    public boolean interceptMessageUrl(String str) {
        IMBusinessConfig iMBusinessConfig = this.f8967v;
        if (iMBusinessConfig != null) {
            return iMBusinessConfig.interceptMessageUrl(this, this.f8931D, str);
        }
        return false;
    }

    public void displayEggs(IMConfig.EggsInfo eggsInfo) {
        this.f8963r.displayEggs(eggsInfo);
    }

    /* renamed from: t */
    private void m6059t() {
        IMMessage lastMessage = this.f8965t.getLastMessage();
        if (lastMessage != null) {
            lastMessage.lastMessage = this.f8931D.getDraft();
        } else {
            lastMessage = new IMMessage(65536);
            lastMessage.setContent("");
            lastMessage.setCreateTime(System.currentTimeMillis());
            lastMessage.setSid(this.f8930C);
        }
        lastMessage.setSidType(this.f8931D.getType());
        IMManager.getInstance().updateSession(lastMessage);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSessionInfoUpdateEvent(IMSessionInfoUpdateEvent iMSessionInfoUpdateEvent) {
        IMLog.m6631d("IMEventDispatcher", "NOTIFY_SEESIONINFO_CHANGE handleSessionUpdate-->");
        m6021b(iMSessionInfoUpdateEvent.imSessionList);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSessionInfoUpdateErrorEvent(IMSessionInfoUpdateErrorEvent iMSessionInfoUpdateErrorEvent) {
        IMLog.m6631d("IMEventDispatcher", "NOTIFY_SEESIONINFO_CHANGE onSessionInfoUpdateErrorEvent--> " + iMSessionInfoUpdateErrorEvent.errorStatusCode);
        if (iMSessionInfoUpdateErrorEvent.errorStatusCode == 111) {
            IMBusinessParam iMBusinessParam = this.f8936I;
            if (iMBusinessParam != null) {
                iMBusinessParam.clearSecret();
            }
            this.f8969x.updateSessionEnableStatus(this.f8930C, false, 0);
            this.f8931D.setSessionEnable(false);
            IMBaseBottomBar iMBaseBottomBar = this.f8960g;
            if (iMBaseBottomBar != null) {
                iMBaseBottomBar.onStatusChanged(this.f8931D);
                return;
            }
            this.f8931D.setExtendSessionInfo(new IMSessionExtendInfo((String) null, (String) null, 0, (String) null, (String) null, 0, (String) null));
            m5992a(0);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onOuterFinishEvent(IMMessageDetailFinishEvent iMMessageDetailFinishEvent) {
        if (this.f8930C == iMMessageDetailFinishEvent.finishSessionId) {
            finish();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m6021b(List<IMSession> list) {
        if (list != null && list.size() > 0) {
            IMSession iMSession = list.get(0);
            if (iMSession.getSessionId() == this.f8931D.getSessionId()) {
                IMBusinessParam iMBusinessParam = this.f8936I;
                if (iMBusinessParam != null) {
                    iMBusinessParam.clearSecret();
                }
                IMSession iMSession2 = this.f8931D;
                this.f8931D = iMSession;
                m6006a(iMSession2, iMSession);
                m6005a(this.f8931D);
                IMLog.m6631d("IMEventDispatcher", "NOTIFY_SEESIONINFO_CHANGE mSession status-->" + this.f8931D.getSessionEnable());
                IMSessionExtendInfo extendSessionInfo = this.f8931D.getExtendSessionInfo();
                if (extendSessionInfo != null) {
                    if (this.f8931D.getSessionEnable()) {
                        this.f8969x.updateSessionEnableStatus(this.f8930C, true, extendSessionInfo.input);
                    } else {
                        this.f8969x.updateSessionEnableStatus(this.f8930C, false, extendSessionInfo.input);
                    }
                }
                IMCustomContext iMCustomContext = this.f8932E;
                if (iMCustomContext != null) {
                    iMCustomContext.setSession(this.f8931D);
                }
                MessageAdapter messageAdapter = this.f8965t;
                if (messageAdapter != null) {
                    messageAdapter.setSessionInfo(this.f8931D.supportMsgReadStatus, this.f8931D.supportTranslate);
                }
                MessageAdapter messageAdapter2 = this.f8965t;
                if (messageAdapter2 != null) {
                    messageAdapter2.updateRenderCardEnv(this.f8930C, IMParamUtil.getTraceOrderId(this.f8936I, this.f8931D), IMParamUtil.getTraceExtra(this.f8936I, this.f8943P));
                }
                m6062u();
            }
        }
    }

    /* renamed from: u */
    private void m6062u() {
        IMSession iMSession = this.f8931D;
        if (iMSession != null && iMSession.getExtendSessionInfo() != null && this.f8970y != null && this.f8931D.getExtendSessionInfo().input == 0 && IMStreetUtils.containsStreetImage(this.f8931D)) {
            this.f8970y.handleExpiredPicture(this.f8931D.getSessionId());
        }
    }

    /* renamed from: a */
    private void m6006a(IMSession iMSession, IMSession iMSession2) {
        if (iMSession != null && iMSession2 != null) {
            int i = iMSession.getExtendSessionInfo() != null ? iMSession.getExtendSessionInfo().input : -1;
            int i2 = iMSession2.getExtendSessionInfo() != null ? iMSession2.getExtendSessionInfo().input : -1;
            IMLog.m6631d("IMBottombar", "handle bar oldstatus " + i + "   newStatus " + i2);
            if (this.f8960g == null) {
                if (i2 == 0 || i2 == 1) {
                    m5992a(0);
                } else if (i2 == 2) {
                    m5992a(1);
                }
                m6030e();
            } else if ((i == -1 || i == 0 || i == 1) && i2 == 2) {
                m5992a(1);
                return;
            } else if ((i == -1 || i == 2) && (i2 == 0 || i2 == 1)) {
                m5992a(0);
                return;
            }
            IMBaseBottomBar iMBaseBottomBar = this.f8960g;
            if (iMBaseBottomBar != null) {
                iMBaseBottomBar.onStatusChanged(this.f8931D);
                if (!TextUtils.isEmpty(iMSession2.recommendString)) {
                    this.f8960g.setRecommendInfo(this.f8931D.recommendString);
                }
            }
        }
    }

    /* renamed from: a */
    private void m5992a(int i) {
        if (this.f8936I != null) {
            String str = null;
            if (this.f8931D.getType() == 4) {
                IMBaseBottomBar iMBaseBottomBar = this.f8960g;
                if (iMBaseBottomBar != null) {
                    iMBaseBottomBar.dettachFromParent();
                    this.f8960g = null;
                    return;
                }
                return;
            }
            IMBaseBottomBar iMBaseBottomBar2 = this.f8960g;
            if (iMBaseBottomBar2 != null) {
                iMBaseBottomBar2.onDestroyView();
                this.f8960g = null;
            }
            if (this.f8931D.getExtendSessionInfo() == null || (this.f8931D.getExtendSessionInfo().input == 2 && TextUtils.isEmpty(this.f8931D.recommendString) && TextUtils.isEmpty(IMInnerData.getInstance().getRecommendInfo(Long.valueOf(this.f8931D.getSessionId()))))) {
                this.f8935H.setVisibility(0);
                IMLoadingView iMLoadingView = (IMLoadingView) this.f8935H.findViewById(R.id.im_detailes_loading_icon);
                iMLoadingView.setVisibility(0);
                iMLoadingView.startLoading();
                this.f8935H.findViewById(R.id.im_detailes_loading_text).setVisibility(8);
                return;
            }
            if (this.f8935H.isShown()) {
                this.f8935H.setVisibility(8);
            }
            if (i == 0) {
                i = (this.f8931D.getExtendSessionInfo() != null ? this.f8931D.getExtendSessionInfo().input : 0) == 2 ? 1 : 0;
            }
            if (i == 1) {
                str = this.f8967v.getBottomBarClass();
                IMLog.m6631d("IMBottomBar", "拿到的类名" + str);
            }
            if (TextUtils.isEmpty(str)) {
                this.f8960g = IMBaseBottomBar.instantiate((Context) this, IMConversationBottomBar.class);
            } else {
                IMBaseBottomBar instantiate = IMBaseBottomBar.instantiate((Context) this, str);
                this.f8960g = instantiate;
                if (instantiate == null) {
                    this.f8960g = IMBaseBottomBar.instantiate((Context) this, IMConversationBottomBar.class);
                }
            }
            this.f8960g.setBottomBarData(this.f8931D, this.f8936I, this.f8967v, this.f8940M);
            this.f8960g.setActivityFrom(this.f8943P);
            this.f8960g.attachToParent((LinearLayout) findViewById(R.id.bts_im_layout));
            this.f8960g.setBottomBarListener(this);
            IMBaseBottomBar iMBaseBottomBar3 = this.f8960g;
            if (iMBaseBottomBar3 instanceof IMConversationBottomBar) {
                ((IMConversationBottomBar) iMBaseBottomBar3).bindEmotionInputDetector(this, this.f8933F);
                ((IMConversationBottomBar) this.f8960g).setRecommendEmojiView(this.f8942O);
            }
            this.f8960g.onActivityCreate();
            this.f8960g.onStatusChanged(this.f8931D);
            this.f8960g.setRecommendInfo(this.f8931D.recommendString);
        }
    }

    /* renamed from: a */
    private void m6005a(IMSession iMSession) {
        m6038i();
        m6026c(iMSession);
        m6020b(iMSession);
    }

    /* renamed from: b */
    private void m6020b(IMSession iMSession) {
        List<IMUser> userInfos = iMSession.getUserInfos();
        if (userInfos != null && userInfos.size() != 0) {
            HashMap hashMap = new HashMap((int) (((double) userInfos.size()) * 1.5d));
            for (IMUser next : userInfos) {
                hashMap.put(Long.valueOf(next.getUid()), next);
            }
            this.f8965t.setUsers(hashMap);
            this.f8965t.notifyDataSetChanged();
        }
    }

    /* renamed from: c */
    private void m6026c(IMSession iMSession) {
        if (iMSession.operationBody != null) {
            this.f8964s.setVisibility(0);
            this.f8964s.setData(iMSession.operationBody);
        } else if (!TextUtils.isEmpty(iMSession.getTipText())) {
            this.f8964s.setVisibility(0);
            IMTopOperationBody iMTopOperationBody = new IMTopOperationBody();
            iMTopOperationBody.btnLink = String.format(getString(R.string.im_user_profileweb_uri), new Object[]{Long.valueOf(IMSession.getPeerId(this.f8931D.getUserIds()).longValue() & -281474976710657L), 103});
            iMTopOperationBody.btnText = iMSession.getTipFol();
            iMTopOperationBody.tipText = iMSession.getTipText();
            this.f8964s.setData(iMTopOperationBody);
        } else {
            this.f8964s.setVisibility(8);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void showRecommendCustomDialog(IMShowCustomWordDialogEvent iMShowCustomWordDialogEvent) {
        showAddCustomWordDialog(iMShowCustomWordDialogEvent.text, 2);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void showLocationDialog(IMSendAddressEvent iMSendAddressEvent) {
        IMBusinessConfig iMBusinessConfig;
        final IMAddress iMAddress = iMSendAddressEvent.address;
        if (iMAddress != null && (iMBusinessConfig = this.f8967v) != null && iMBusinessConfig.isShowExtendIcon()) {
            IMDialog confirmDialog = IMDialogFactory.getConfirmDialog((Activity) this, IMResource.getDrawableID(R.drawable.im_dialog_icon_location), String.format(getString(R.string.bts_im_location_alert), new Object[]{iMAddress.getDisplayname()}), getString(R.string.alert_ok), getString(R.string.alert_cancel), (IMDialog.Callback) new IMDialog.Callback() {
                public void onCancel() {
                }

                public void onSubmit() {
                    if (IMMessageActivity.this.f8970y != null) {
                        IMMessageActivity.this.m6019b(IMMessageActivity.this.f8970y.sendLocationMessage(IMMessageActivity.this.buildFromAddress(iMAddress), IMApiConst.MsgTypeSendLocation, IMMessageActivity.this.f8936I, IMMessageActivity.this.f8931D));
                    }
                }
            });
            this.f8968w = confirmDialog;
            confirmDialog.show(this.mController, getSupportFragmentManager(), "show_location");
        }
    }

    public IMLocationEntity buildFromAddress(IMAddress iMAddress) {
        IMLocationEntity iMLocationEntity = new IMLocationEntity();
        iMLocationEntity.displayname = iMAddress.getDisplayname();
        iMLocationEntity.cityId = iMAddress.getCityId();
        iMLocationEntity.cityName = iMAddress.getCityName();
        iMLocationEntity.lat = iMAddress.getLat();
        iMLocationEntity.lng = iMAddress.getLng();
        iMLocationEntity.address = iMAddress.getAddress();
        iMLocationEntity.country_iso_code = iMAddress.getIsoCode();
        if (IMTextUtil.isEmpty(iMLocationEntity.address)) {
            iMLocationEntity.address = iMAddress.getDisplayname();
        }
        return iMLocationEntity;
    }

    /* renamed from: v */
    private void m6064v() {
        Intent intent = new Intent();
        intent.setAction(IMEventDispatcher.IM_ACTION_LOCATION_REQUEST);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    /* renamed from: w */
    private void m6066w() {
        View view = this.f8933F;
        if (view != null) {
            int height = view.getHeight();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f8933F.getLayoutParams();
            layoutParams.height = height;
            layoutParams.weight = 0.0f;
            this.f8933F.setLayoutParams(layoutParams);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void unLockRecycleHeight(IMMessageUnlockRecyclerViewEvent iMMessageUnlockRecyclerViewEvent) {
        View view = this.f8933F;
        if (view != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams.height = 0;
            layoutParams.weight = 1.0f;
            this.f8933F.setLayoutParams(layoutParams);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void skipToMainActivity(IMSkipToMainActivityEvent iMSkipToMainActivityEvent) {
        m6067x();
        m6009a(iMSkipToMainActivityEvent.url);
    }

    /* renamed from: x */
    private void m6067x() {
        if (IMContextInfoHelper.getAppMainClass() != null) {
            Intent intent = new Intent(this, IMContextInfoHelper.getAppMainClass());
            intent.addFlags(View.STATUS_BAR_TRANSIENT);
            startActivity(intent);
        }
    }

    /* renamed from: a */
    private void m6009a(String str) {
        try {
            final Intent intent = Intent.getIntent(str);
            intent.setAction("android.intent.action.VIEW");
            this.f8956ab.postDelayed(new Runnable() {
                public void run() {
                    try {
                        IMMessageActivity.this.startActivity(intent);
                    } catch (Exception e) {
                        IMLog.m6632e(IMMessageActivity.f8916b, "switchBranch", e);
                    }
                }
            }, 500);
        } catch (URISyntaxException e) {
            IMLog.m6632e(f8916b, "switchBranch", e);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void msgListIsEmpty(IMMessageEmptyEvent iMMessageEmptyEvent) {
        IMSession iMSession = this.f8931D;
        if (iMSession != null && iMSession.getType() == 4) {
            this.f8944Q.setVisibility(0);
            this.f8945R.setVisibility(0);
            this.f8962q.setVisibility(8);
            this.f8963r.setVisibility(8);
            this.f8944Q.setImageResource(IMResource.getDrawableID(R.drawable.im_nomix_no_history_msg));
            this.f8945R.setText(IMResource.getString(R.string.im_nomix_no_history_msg_text));
            IMLog.m6631d("IMview", "has set empty bg");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0051  */
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleInnerSchemeEvent(com.didi.beatles.p099im.event.IMInnerSchemeEvent r6) {
        /*
            r5 = this;
            java.lang.String r0 = r6.getAction()
            int r1 = r0.hashCode()
            r2 = -2098199687(0xffffffff82f00379, float:-3.5266824E-37)
            r3 = 0
            r4 = 1
            if (r1 == r2) goto L_0x001f
            r2 = 664593897(0x279ce5e9, float:4.3547967E-15)
            if (r1 == r2) goto L_0x0015
            goto L_0x0029
        L_0x0015:
            java.lang.String r1 = "/take_photo"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0029
            r0 = 1
            goto L_0x002a
        L_0x001f:
            java.lang.String r1 = "/send_msg"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0029
            r0 = 0
            goto L_0x002a
        L_0x0029:
            r0 = -1
        L_0x002a:
            if (r0 == 0) goto L_0x0051
            if (r0 == r4) goto L_0x004d
            java.lang.Object[] r0 = new java.lang.Object[r4]
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "[handleInnerSchemeEvent] Invalid event : "
            r1.append(r2)
            java.lang.String r6 = r6.getAction()
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0[r3] = r6
            java.lang.String r6 = "IMMessageActivity"
            com.didi.beatles.p099im.utils.IMLog.m6632e(r6, r0)
            goto L_0x0058
        L_0x004d:
            r5.m6069y()
            goto L_0x0058
        L_0x0051:
            java.lang.Object r6 = r6.getData()
            r5.m6008a((java.lang.Object) r6)
        L_0x0058:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.activity.IMMessageActivity.handleInnerSchemeEvent(com.didi.beatles.im.event.IMInnerSchemeEvent):void");
    }

    /* renamed from: a */
    private void m6008a(Object obj) {
        String str;
        if (obj instanceof IMOrderStatusChangeBody.ExtendInfo) {
            IMOrderStatusChangeBody.ExtendInfo extendInfo = (IMOrderStatusChangeBody.ExtendInfo) obj;
            IMLog.m6631d(f8916b, "[handleSendMsgScheme] " + extendInfo.msgType + " | " + extendInfo.msgData);
            if (extendInfo.msgType > 0 && extendInfo.msgData != null) {
                int i = extendInfo.msgType;
                if (i == 65536) {
                    str = extendInfo.msgData.content;
                } else if (i != 458752) {
                    str = null;
                } else {
                    str = IMJsonUtil.jsonFromObject(extendInfo.msgData);
                }
                if (str != null) {
                    m6010a(str, extendInfo.msgType, -1, (Object) null);
                }
            }
        }
    }

    /* renamed from: y */
    private void m6069y() {
        IMLog.m6631d(f8916b, "[handleTakePhotoScheme]");
        IMPictureSelector.create((Activity) this).openCamera().maxImageSize(200).glideOverride(160, 160).compress(true).minimumCompressSize(100).forResult(188);
    }
}
